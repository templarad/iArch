package jp.ac.kyushu.iarch.sequencediagram.features;

import java.util.ArrayList;
import java.util.List;

import jp.ac.kyushu.iarch.archdsl.archDSL.Behavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.basefunction.controller.ArchModelController;
import jp.ac.kyushu.iarch.basefunction.controller.GraphitiModelManager;
import jp.ac.kyushu.iarch.basefunction.reader.ArchModel;
import jp.ac.kyushu.iarch.basefunction.reader.ProjectReader;
import jp.ac.kyushu.iarch.basefunction.reader.XMLreader;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import behavior.Actor;
import behavior.BehaviorFactory;
import behavior.Lifeline;
import behavior.Object;

public class GenerateSequenceDiagramFeature extends AbstractCustomFeature{
	
	private List<behavior.Object> objects;

	private List<Shape> shapes;
	
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
		
		//Initialize objects
		objects = new ArrayList<behavior.Object>();
		for(Interface intrface : archfaceModel.getInterfaces()){
			behavior.Object obj = BehaviorFactory.eINSTANCE.createObject();
			obj.setArchpoint(true);
			obj.setName(intrface.getName());			
			objects.add(obj);
		}
		
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
		// TODO Auto-generated method stub
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
		
		addObject();
		addLifeLine();
	}
	
	public void addLifeLine(){
		Shape shape = null;
		shapes = new ArrayList<Shape>();
		for(Shape tempshape : getDiagram().getChildren()){
			shapes.add(tempshape);
		}
		//Add a lifeline will make a change to getDiagram().getChildren()
		//You need to make another arraylist point to the old children.
		for(Shape tempshape : shapes){
			if (tempshape.getLink().getBusinessObjects().get(0) instanceof Actor ||
					tempshape.getLink().getBusinessObjects().get(0) instanceof behavior.Object){
				shape = tempshape;
				Anchor anchor = shape.getAnchors().get(0);
				
				//Add lifeline
				{
					behavior.Lifeline lifeline = BehaviorFactory.eINSTANCE.createLifeline();
					AddConnectionContext connectioncontext = new AddConnectionContext(anchor,null);
					connectioncontext.setNewObject(lifeline);
					
					connectioncontext.setTargetContainer(getDiagram());
					IAddFeature iaddcontext = getFeatureProvider().getAddFeature(connectioncontext);;
					
					if (null != iaddcontext)
						iaddcontext.execute(connectioncontext);
				}
			}
		}
		
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
			
			startX+=120;

		}
		
	}
}
