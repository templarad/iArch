package jp.ac.kyushu.iarch.sequencediagram.features;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.logging.Logger;

import jp.ac.kyushu.iarch.archdsl.archDSL.Behavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.basefunction.controller.ArchModelController;
import jp.ac.kyushu.iarch.basefunction.controller.GraphitiModelManager;
import jp.ac.kyushu.iarch.basefunction.reader.ArchModel;
import jp.ac.kyushu.iarch.basefunction.reader.ProjectReader;
import jp.ac.kyushu.iarch.basefunction.reader.XMLreader;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import behavior.Actor;
import behavior.BehaviorFactory;
import behavior.Lifeline;
import behavior.Message;
import behavior.Object;

/**
 * Auto generate sequence diagram feature.
 * 
 * @author Templar
 *
 */
public class GenerateSequenceDiagramFeature extends AbstractCustomFeature {
	Logger logger = Logger.getGlobal();
	/**
	 * A list of <b>Object</b> in sequence diagram.
	 */
	private List<behavior.Object> objects;
	/**
	 * A list of shapes in sequence diagram which is linked with <b>Object</b>.
	 */
	private List<Shape> shapes;

	/**
	 * A list of Connection which is linked with <b>Lifeline</b>.
	 */
	private List<Connection> lifelineConnections;

	/**
	 * The start <b>Y</b> position for auto generating messages.
	 */
	static private int MESSAGE_START_Y = 120;

	/**
	 * The space size between each <b>Object</b> in the diagram.
	 */
	static private int OBJECT_SPACE = 120;
	/**
	 * A weakHashMap to link the '<em>Object name</em>' with '
	 * <em>lifeline Connection</em>'.
	 */
	private WeakHashMap<String, Connection> objectlifelineMap = new WeakHashMap<String, Connection>();

	public GenerateSequenceDiagramFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void execute(ICustomContext context) {
		XMLreader xmlreader = new XMLreader(ProjectReader.getProject());
		List<IResource> sequenceDiagramIResources = xmlreader
				.getSequenceDiagramResource();
		IResource archfile = xmlreader.getArchfileResource();
		ArchModel archModel = new ArchModelController(archfile);
		Model archfaceModel = archModel.getModel();

		// Generate diagram by each Resource
		for (IResource sequenceDiagramIResource : sequenceDiagramIResources) {
			Resource sequenceResource = GraphitiModelManager.getGraphitiModel(sequenceDiagramIResource);
			generateSequenceDiagram(sequenceResource, archfaceModel);
		}
	}

	@Override
	public String getName() {
		return "Generate Sequence Diagram";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public String getDescription() {
		return "Reflecting change of code to the Sequence diagram.";
	}

	/**
	 * Auto generate sequence diagram. <br>
	 * The main method of the class.
	 * 
	 * @param sequenceResource
	 *            The sequence diagram resource in which the diagram will
	 *            generate into.
	 * @param archfaceModel
	 *            The Archface Model which will be used in generating diagram.
	 */
	public void generateSequenceDiagram(Resource sequenceResource,
			Model archfaceModel) {

		cleanAllResource();
		// Add Actor
		{
			behavior.Actor actor = BehaviorFactory.eINSTANCE.createActor();
			actor.setName("Actor");
			actor.setArchpoint(false);
			AddContext addcontext = new AddContext();
			addcontext.setX(20);
			addcontext.setNewObject(actor);
			addcontext.setTargetContainer(getDiagram());
			IAddFeature iaddcontext = getFeatureProvider().getAddFeature(addcontext);

			if (null != iaddcontext)
				iaddcontext.execute(addcontext);
			getDiagram().eResource().getContents().add(actor);
		}
		//
		// Initialize objects
		objects = new ArrayList<behavior.Object>();
		for (Interface intrface : archfaceModel.getInterfaces()) {
			behavior.Object obj = BehaviorFactory.eINSTANCE.createObject();
			obj.setArchpoint(true);
			obj.setName(intrface.getName());
			objects.add(obj);
		}
		addObject();
		addLifeLine();
		lifelineConnections = new ArrayList<Connection>();
		for (Connection tempconnection : getDiagram().getConnections()) {
			if (tempconnection.getLink().getBusinessObjects().get(0) instanceof Lifeline) {
				lifelineConnections.add(tempconnection);

				// Build a weakhashmap for inserting message.
				java.lang.Object obj = getBusinessObjectForPictogramElement(
						(ContainerShape) tempconnection.getStart().eContainer()
						);
				if (obj instanceof Actor) {
					objectlifelineMap.put(((Actor) obj).getName(), tempconnection);
				} else if (obj instanceof Object) {
					objectlifelineMap.put(((Object) obj).getName(), tempconnection);
				} else {
					// Never should happen.
					System.out.println("An unknown Connection is added.");
				}

			}
		}

		boolean actorMessageExist = false;//The message from actor will be generated only one time.
		List<Behavior> behaviorList = findFirstBehavior(archfaceModel.getBehaviors());
		// Add message
		int space = 0;
		for (Behavior behavior : behaviorList) {
			int i = 0;
			for (Method method : behavior.getCall()) {
				if (method.eContainer() instanceof Interface) {
					String targetName = ((Interface) method.eContainer())
							.getName();
					String sourceName = targetName;
					if (i == 0 && !actorMessageExist) {
						sourceName = "Actor";
						
					}else if (behavior.getCall().size() == 1){
						targetName = behavior.getEnd().getName();
					} else if (i > 1 && i == behavior.getCall().size() - 1) {
						sourceName = ((Interface) behavior.getCall().get(i - 1)
								.eContainer()).getName();
						targetName = behavior.getEnd().getName();
					} else if (i == 0 && actorMessageExist) {
						i ++;
						continue;
					} else {
						sourceName = ((Interface) behavior.getCall().get(i - 1)
								.eContainer()).getName();
					}

					//When generating message from actor, there is no need to check message existence.
					if(actorMessageExist){
						if(messageExist(method.getName())){
							continue;
						}
					}
					// Add message for each method in archface.
					addMessage(MESSAGE_START_Y + space,
							objectlifelineMap.get(sourceName),
							objectlifelineMap.get(targetName), method.getName());

					actorMessageExist = true;
					// Layout adjustment: Adjusting space size between each
					// message.
					if (sourceName.equals(targetName)) {
						space += 45;
					} else {
						space += 30;
					}
				} else {
					// Never should happen.
					System.out.println("An unknown Method 'Call' is added in Archface.");
				}
				i++;
			}

		}
		try {
			getDiagram().eResource().save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Add all '<b>LifeLines</b>' into the selected sequence diagram <br>
	 * for all '<em><b>interface components</b></em>' in Archface code and an Actor.
	 */
	public void addLifeLine() {
		Shape shape = null;
		shapes = new ArrayList<Shape>();
		for (Shape tempshape : getDiagram().getChildren()) {
			if(tempshape instanceof ContainerShape)
				shapes.add(tempshape);
		}

		// Add a lifeline will make a change to getDiagram().getChildren()
		// You need to make another arraylist point to the old children.
		for (Shape tempshape : shapes) {
			if (tempshape.getLink().getBusinessObjects().get(0) instanceof Actor
					|| tempshape.getLink().getBusinessObjects().get(0) instanceof behavior.Object) {
				shape = tempshape;
				Anchor anchor = shape.getAnchors().get(0);

				// Add a lifeline
				{
					CreateConnectionContext createconnectioncontext = new CreateConnectionContext();
					createconnectioncontext.setSourceAnchor(anchor);
					createconnectioncontext.setSourcePictogramElement(shape);

					org.eclipse.graphiti.features.ICreateConnectionFeature icreatecontext = getFeatureProvider()
							.getCreateConnectionFeatures()[0];
					Assert.isTrue(icreatecontext.getCreateName().equals(
							"Lifeline"));

					if (null != icreatecontext) {
						icreatecontext.execute(createconnectioncontext);
					}
				}// End add a lifeline
			}
		}// End add all lifeline

	}

	/**
	 * Generate all <b>Object</b> into the selected sequence diagram <br>
	 * based on the '<em><b>interface component</b></em>' in Archface code.
	 */
	public void addObject() {
		int startX = 120;
		for (behavior.Object obj : objects) {
			AddContext addcontext = new AddContext();
			addcontext.setX(startX);
			addcontext.setNewObject(obj);
			addcontext.setTargetContainer(getDiagram());
			IAddFeature iaddcontext = getFeatureProvider().getAddFeature(
					addcontext);

			if (null != iaddcontext)
				iaddcontext.execute(addcontext);
			getDiagram().eResource().getContents().add(obj);
			// Layout adjustment: adjust space size between each object.
			startX += OBJECT_SPACE;

		}

	}

	/**
	 * Add a <b>Message</b> between <em><b>sourcePE</b></em> and
	 * <em><b>targetPE</b></em> from the <em><b>startY</b></em>.
	 * 
	 * @param startY
	 *            The start position Y of message on the lifeline.
	 * @param sourcePE
	 *            The start lifeline '<em><b>Connection</b></em>'.
	 * @param targetPE
	 *            The target lifeline '<em><b>Connection</b></em>'.
	 * @param messageName
	 *            The <em>name</> of message.
	 */
	public void addMessage(final int startY, PictogramElement sourcePE,
			PictogramElement targetPE, String messageName) {

		CreateConnectionContext connectioncontext = new CreateConnectionContext();
		connectioncontext.setSourcePictogramElement(sourcePE);
		connectioncontext.setTargetPictogramElement(targetPE);
		connectioncontext.putProperty("name", messageName);
		connectioncontext.setSourceLocation(new ILocation() {

			@Override
			public void setY(int y) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setX(int x) {
				// TODO Auto-generated method stub

			}

			@Override
			public int getY() {
				// TODO Auto-generated method stub
				return startY;
			}

			@Override
			public int getX() {
				// TODO Auto-generated method stub
				return 0;
			}
		});

		ICreateConnectionFeature icreatecontext = getFeatureProvider()
				.getCreateConnectionFeatures()[1];
		Assert.isTrue(icreatecontext.getCreateName().equals("Message"));
		icreatecontext.execute(connectioncontext);
	}
	/**
	 * Clean all resource in the sequence diagram,<br>
	 * before regenerating a new diagram.
	 */
	private void cleanAllResource(){
		Iterator<EObject> eobjectIter = getDiagram().eResource().getContents().iterator();
		while (eobjectIter.hasNext()) {
			EObject nextobj = eobjectIter.next();
			if (nextobj instanceof Diagram) {
			} else {
				eobjectIter.remove();//Remove objects in business model.
			}
		}
		getDiagram().getChildren().clear();//Remove graphical elements.
		getDiagram().getConnections().clear();//Remove connections.
		getDiagram().getPictogramLinks().clear();//Remove links between business model and graphical element.
	}
	
	/**
	 * Check if a method has been generated in the diagram.
	 * @param methodName The name of method to check.
	 * @return <b>true</b> if exist.
	 */
	private boolean messageExist(String methodName){
		for (EObject eobj : getDiagram().eResource().getContents()){
			if (eobj instanceof Message){
				if(((Message)eobj).getName().equals(methodName)){
					return true;
				}
				
			}
		}
		return false;
	}

	/**
	 * Find the first message for Actor.<br>
	 * Usually there are several behaviors in the Archcode.
	 * @param behaviorList the <b>Behavior List</b> from ArchModel.
	 * @return A new Behavior List
	 */
	private List<Behavior> findFirstBehavior(List<Behavior> behaviorList){
		if(behaviorList.size() <= 1){
			return behaviorList;
		}
		List<Behavior> newbehaviorList = new ArrayList<Behavior>();
		//Copy to a new list.
		for(Behavior behavior : behaviorList){
			newbehaviorList.add(behavior);
		}
		//Check the first method in each behavior, if there is a method in other behavior the same as it.
		//If no method exist, swap the behavior to the first one, and return.
		for (int i = 0 ; i< newbehaviorList.size() ; i++){
			Method tofindMethod = newbehaviorList.get(i).getCall().get(0);
			
			if(i == newbehaviorList.size()){
				Behavior temp = newbehaviorList.get(0);
				//exchange the first behavior and behavior(i)
				newbehaviorList.set(0, newbehaviorList.get(i));
				newbehaviorList.set(i, temp);
				return newbehaviorList;
			}
			int behaviorNo = 0;
			for(Behavior behavior : newbehaviorList){
				int methodNo = 0;//for logger;
				int breaktime = 0;
				if(newbehaviorList.get(i).equals(behavior)){
					behaviorNo ++;
					continue;
				}
				for (Method method : behavior.getCall()) {
					String name = ((Interface)method.eContainer()).getName()+"."+method.getName();
					if(name.equals(((Interface)tofindMethod.eContainer()).getName()+"."+tofindMethod.getName())){
						logger.info("Find: ["+((Interface)tofindMethod.eContainer()).getName()+"."+tofindMethod.getName()+"] in behavior["+ behaviorNo +"] method["+methodNo+"]");
						breaktime ++;
						break;
					}
					methodNo ++;
				}
				//Never break, means no method is the same as the tofindMethod.
				if(breaktime == 0){
					Behavior temp = newbehaviorList.get(0);
					//exchange the first behavior and behavior(i)
					newbehaviorList.set(0, newbehaviorList.get(i));
					newbehaviorList.set(i, temp);
					logger.info("Find: ["+((Interface)tofindMethod.eContainer()).getName()+"."+tofindMethod.getName()+"] : no result in other behavior, swap to [0]");
					return newbehaviorList;
				}
				behaviorNo ++;
			}
		}
		return newbehaviorList;
	}
}
