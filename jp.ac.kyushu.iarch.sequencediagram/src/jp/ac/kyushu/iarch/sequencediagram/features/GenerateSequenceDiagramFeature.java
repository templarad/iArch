package jp.ac.kyushu.iarch.sequencediagram.features;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import behavior.Actor;
import behavior.BehaviorFactory;
import behavior.Lifeline;
import behavior.Object;

public class GenerateSequenceDiagramFeature extends AbstractCustomFeature{
	/**
	 * A list of objects in sequence diagram.
	 */
	private List<behavior.Object> objects;
	/**
	 * A list of shapes in sequence diagram which is linked with objects.
	 */
	private List<Shape> shapes;
	private List<Connection> lifelineConnections;
	
	/**
	 * The start position of auto generated messages.
	 */
	static private int MESSAGE_START_Y = 120;
	
	/**
	 * The space size between each object.
	 */
	static private int OBJECT_SPACE = 120;
	
	private HashMap<String, Connection> objectlifelineMap = new HashMap<String, Connection>();

	public GenerateSequenceDiagramFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(ICustomContext context) {
		XMLreader xmlreader = new XMLreader(ProjectReader.getProject());
		List<IResource> sequenceDiagramIResources = xmlreader.getSequenceDiagramResource();
		IResource archfile = xmlreader.getArchfileResource();
		ArchModel archModel = new ArchModelController(archfile);
		Model archfaceModel = archModel.getModel();
		
		
		
		//Generate diagram by each Resource
		for(IResource sequenceDiagramIResource : sequenceDiagramIResources){
			Resource sequenceResource = GraphitiModelManager.getGraphitiModel(sequenceDiagramIResource);
			generateSequenceDiagram(sequenceResource,archfaceModel);
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
	
	public void generateSequenceDiagram(Resource sequenceResource, Model archfaceModel ){

		//Add Actor
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
		}
		//
		//Initialize objects
		objects = new ArrayList<behavior.Object>();
		for(Interface intrface : archfaceModel.getInterfaces()){
			behavior.Object obj = BehaviorFactory.eINSTANCE.createObject();
			obj.setArchpoint(true);
			obj.setName(intrface.getName());			
			objects.add(obj);
		}
		addObject();
		addLifeLine();
		lifelineConnections = new ArrayList<Connection>();
		for(Connection tempconnection : getDiagram().getConnections()){
			if(tempconnection.getLink().getBusinessObjects().get(0) instanceof Lifeline){
				lifelineConnections.add(tempconnection);
				
				//Build a hashmap for inserting message.
				java.lang.Object obj = getBusinessObjectForPictogramElement((ContainerShape)tempconnection.getStart().eContainer());
				if(obj instanceof Actor){
					objectlifelineMap.put(((Actor)obj).getName(),tempconnection);
				}else if(obj instanceof Object){
					objectlifelineMap.put(((Object)obj).getName(),tempconnection);
				}else{
					//Never should be here.
					System.out.println("An unknown Connection is added.");
				}
				
			}
		}
		//Test
		
		for(Behavior behavior : archfaceModel.getBehaviors()){
			int i = 0;
			int space = 0;
			for(Method method : behavior.getCall()){
				if(method.eContainer() instanceof Interface){
					String targetName = ( (Interface)method.eContainer() ).getName();
					String sourceName = targetName;
					if(0 == i){
						sourceName = "Actor";
					}else if(i == behavior.getCall().size() - 1){
						sourceName = ((Interface) behavior.getCall().get(i-1).eContainer() ).getName();
						targetName = behavior.getEnd().getName();
					}else{	
						sourceName = ((Interface) behavior.getCall().get(i-1).eContainer() ).getName();
					}
					addMessage(MESSAGE_START_Y + space, objectlifelineMap.get(sourceName), objectlifelineMap.get(targetName));
					if(sourceName.equals(targetName) ){
						space += 40;
					}else{
						space += 25;
					}
				}else{
					//Never should be here.
					System.out.println("An unknown Method 'Call' is added in Archface.");
				}
				i++;
			}
			break;
			
		}
		//addMessage(MESSAGE_START_Y + i * 10, objectlifelineMap.get(key), objectlifelineMap.get(key));
	}
	
	public void addLifeLine() {
		Shape shape = null;
		shapes = new ArrayList<Shape>();
		for (Shape tempshape : getDiagram().getChildren()) {
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

					org.eclipse.graphiti.features.ICreateConnectionFeature icreatecontext = getFeatureProvider().getCreateConnectionFeatures()[0];
					Assert.isTrue(icreatecontext.getCreateName().equals("Lifeline"));
					
					if (null != icreatecontext) {
						icreatecontext.execute(createconnectioncontext);
					}

				}// End add a lifeline
			}
		}// End add all lifeline

	}
	
	public void addObject(){
		int startX = 120;
		for(behavior.Object obj : objects){
			AddContext addcontext = new AddContext();
			addcontext.setX(startX);
			addcontext.setNewObject(obj);
			addcontext.setTargetContainer(getDiagram());
			IAddFeature iaddcontext = getFeatureProvider().getAddFeature(addcontext);
			
			if (null != iaddcontext)
				iaddcontext.execute(addcontext);
			
			startX += OBJECT_SPACE;

		}
		
	}
	
	public void addMessage(final int startY, PictogramElement sourcePE, PictogramElement targetPE){

		
		CreateConnectionContext connectioncontext = new CreateConnectionContext();
		connectioncontext.setSourcePictogramElement(sourcePE);
		connectioncontext.setTargetPictogramElement(targetPE);

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
		
		org.eclipse.graphiti.features.ICreateConnectionFeature icreatecontext = getFeatureProvider().getCreateConnectionFeatures()[1];
		Assert.isTrue(icreatecontext.getCreateName().equals("Message"));

		icreatecontext.execute(connectioncontext);
		
	}
	
}
