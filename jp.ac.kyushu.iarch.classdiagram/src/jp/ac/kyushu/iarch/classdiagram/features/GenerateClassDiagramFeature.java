package jp.ac.kyushu.iarch.classdiagram.features;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;

import jp.ac.kyushu.iarch.archdsl.archDSL.Behavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.basefunction.controller.ArchModelController;
import jp.ac.kyushu.iarch.basefunction.model.ClassDiagramModel;
import jp.ac.kyushu.iarch.basefunction.reader.ArchModel;
import jp.ac.kyushu.iarch.basefunction.reader.ProjectReader;
import jp.ac.kyushu.iarch.basefunction.reader.XMLreader;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;

import umlClass.Association;
import umlClass.Operation;
import umlClass.UmlClassFactory;

public class GenerateClassDiagramFeature extends AbstractCustomFeature{

	public GenerateClassDiagramFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}
	@Override
    public String getName() {
        return "Generate All Classes";
    }
 
    @Override
	public boolean canExecute(ICustomContext context) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
    public String getDescription() {
        return "Reflecting change of code to the Class diagram.";
    }
    
	private List<ContainerShape> classShapes = new ArrayList<ContainerShape>();
	/**
	 * The X position of first class to generate.
	 */
	private static int STARTX = 20;
	
	/**
	 * The Y position of first class to generate.
	 */
	private static int STARTY = 20;
	private static int space = 30;
	private int LOWESTY;
	private int LOWCLASSY;	
	private int RIGHTX;
	
	/**
	 * A weakHashMap to link the '<em>Class name</em>' with '<em>Class ContainerShape</em>'.
	 */
	private WeakHashMap<String, ContainerShape> classContainerMap = new WeakHashMap<String, ContainerShape>();
	
	/**
	 * A weakHashMap to link the '<em>Class name</em>' with its reference classes HashMap.
	 */
	private WeakHashMap<String, HashMap<String,Boolean>> classReferenceMap = new WeakHashMap<String, HashMap<String,Boolean>>();
	
	private void initPosition(Resource classResource){
		EObject o = classResource.getContents().get(0);
		
		if(o instanceof Diagram){
			Diagram targetDiagram = (Diagram) o;
			for(Shape cs : targetDiagram.getChildren()){
				if(cs instanceof ContainerShape){
					classShapes.add((ContainerShape)cs);
					
					RIGHTX = cs.getGraphicsAlgorithm().getX()+ cs.getGraphicsAlgorithm().getWidth();
					
					int Y = cs.getGraphicsAlgorithm().getY();
					LOWCLASSY = (Y > LOWCLASSY)?Y:LOWCLASSY;
					
					Y += cs.getGraphicsAlgorithm().getHeight();
					LOWESTY = (Y > LOWESTY)?Y:LOWESTY;
				}
					
			}
		}
		
		if(RIGHTX + 100 + 2 * space > 500){
			STARTX = space;
			STARTY = LOWESTY + space;
		}else{
			STARTX = RIGHTX + space;
			STARTY = LOWCLASSY;
		}
	}
	
	public void generateClassDiagram(){

		XMLreader xmlreader = new XMLreader(ProjectReader.getProject());
		IResource classDiagramIResource = xmlreader.getClassDiagramResource();
		IResource archfile = xmlreader.getArchfileResource();
		ArchModel archModel = new ArchModelController(archfile);
		if(classDiagramIResource == null){
			MessageDialog.open(MessageDialog.WARNING,
					null, "Can't slice",
					"Please check the Archface Configration.(Menu->iArch->Configration)", SWT.None);
    		return;
		}
		
		
		Resource classResource = getDiagram().eResource();
		initPosition(classResource);
		ClassDiagramModel cdm = new ClassDiagramModel(classResource);
		Model archmodel = archModel.getModel();
		for(Interface archclass : archmodel.getInterfaces()){
			//Get operations which is included in the modified class.
			List<umlClass.Operation> operations = getOperations(archmodel, archclass);
			
			umlClass.Class umlclass = UmlClassFactory.eINSTANCE.createClass();
			umlclass.setArchpoint(true);
			
			if(null == cdm.getClass(archclass.getName())){
				getDiagram().eResource().getContents().add(umlclass);
				umlclass.setName(archclass.getName());
				addClassFeature(umlclass, STARTX, STARTY);
				//Adjust layout.
				if(STARTX + 100 + 2 * space < 500){
					STARTX += 100 + space;
				}else{
					STARTY = LOWESTY + space;
					STARTX = space;
				}
				for(Shape cs : getDiagram().getChildren()){
					if(cs instanceof ContainerShape){
						EObject eobj = ((ContainerShape)cs).getLink().getBusinessObjects().get(0);
						if(eobj instanceof umlClass.Class){
							String className = ((umlClass.Class)eobj).getName();
							if(className.equals(archclass.getName())){
								classContainerMap.put(className, (ContainerShape) cs);
								break;
							}
						}
					}
				}
				
				generateOperations(umlclass, operations, cdm);
				//checkReference(archmodel);
			}else{
				for(Shape cs : getDiagram().getChildren()){
					if(cs instanceof ContainerShape){
						EObject eobj = ((ContainerShape)cs).getLink().getBusinessObjects().get(0);
						if(eobj instanceof umlClass.Class){
							String className = ((umlClass.Class)eobj).getName();
							if(archclass.getName().equals(className)){
								classContainerMap.put(className, (ContainerShape) cs);
								break;
							}
						}
					}
				}
				//Fill the lost operations.
				generateOperations(cdm.getClass(archclass.getName()), operations, cdm);
			}
		}
		getReference(archmodel);
		for(Interface archclass : archmodel.getInterfaces()){
			for(Interface archclassX : archmodel.getInterfaces()){
				String sourceClassName = archclass.getName();
				String targetClassName = archclassX.getName();
				if(!sourceClassName.equals(targetClassName)){
					if(isReference(sourceClassName, targetClassName) && !isGenerated(sourceClassName, targetClassName)){
						generateReference(archclass.getName(), archclassX.getName());
					}
				}
			}
		}
		try {
			
			getDiagram().eResource().save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	protected Color manageColor(Diagram diagram,IColorConstant colorConstant) {
		return Graphiti.getGaService().manageColor(diagram, colorConstant);
	}
	
	private void addClassFeature(umlClass.Class addedClass,int startX,int startY){
		AddContext addcontext = new AddContext();
		addcontext.setX(startX);
		addcontext.setY(startY);
		addcontext.setNewObject(addedClass);
		addcontext.setTargetContainer(getDiagram());
		IAddFeature iaddcontext = getFeatureProvider().getAddFeature(addcontext);
		if (null != iaddcontext){
			iaddcontext.execute(addcontext);
		}		
	}
	@Override
	public void execute(ICustomContext context) {

		generateClassDiagram();
		
	}
	private void generateOperations(umlClass.Class targetClass, List<umlClass.Operation> newOperations, ClassDiagramModel cdm){
		for(umlClass.Operation newOperation: newOperations){
			if(cdm.getOperation(newOperation.getName(), targetClass)==null){
				targetClass.getOwnedOperation().add(newOperation);
				AddContext addcontext = new AddContext();
				addcontext.setNewObject(newOperation);
				addcontext.setTargetContainer(classContainerMap.get(targetClass.getName()));
				IAddFeature iaddcontext = getFeatureProvider().getAddFeature(addcontext);
				if (null != iaddcontext){
					iaddcontext.execute(addcontext);
				}
			}
			
		}
		updatePictogramElement(classContainerMap.get(targetClass.getName()));
		layoutPictogramElement(classContainerMap.get(targetClass.getName()));
		
	}
	
	/**
	 * Get all operations of the specified class from archmodel
	 * @param archmodel The model to get.
	 * @param archclass The specified class.
	 * @return
	 */
	private List<umlClass.Operation> getOperations(Model archmodel,Interface archclass){
		List<umlClass.Operation> newOperations = new  ArrayList<umlClass.Operation>();
		
		for(Method method : archclass.getMethods()){
			Operation newOperation = UmlClassFactory.eINSTANCE.createOperation();
			newOperation.setArchpoint(true);
			newOperation.setName(method.getName());
			newOperations.add(newOperation);
			
		}
		return newOperations;
	}
	
	/**
	 * Get the reference information from Arch code model.
	 * @param archmodel the '<em>Model</em>' from Arch code.
	 */
	private void getReference(Model archmodel){
		for(Behavior behavior : archmodel.getBehaviors()){
			HashMap<String, Boolean> temp = new HashMap<String, Boolean>();
			for(Method method : behavior.getCall()){
				temp.put(((Interface)method.eContainer()).getName(), true);
			}
			classReferenceMap.put(behavior.getInterface().getName(), temp);
		}
	}
	
	/**
	 * Check if a <em>class</em> have a reference to the target class.
	 * @param className The class which is to check.
	 * @param targetName The reference target class.
	 * @return 'true' if they have reference
	 */
	private boolean isReference(String className, String targetName){
		HashMap<String, Boolean> referenceMap = classReferenceMap.get(className);
		if(referenceMap.isEmpty())
			return false;
		if(referenceMap.get(targetName) != null)
			return true;
		return false;
	}
	/**
	 * Check if an Reference from 'className' to 'targetName' is generated. <br>
	 * This method is considered to prevent regenerate Reference.
	 * @param className The <b>name</b> of a class which should be instance of <em>umlClass</em>.
	 * @param targetName The <b>name</b> of a class which should be instance of <em>umlClass</em>.
	 * @return 'true' if the reference is already generated.
	 */
	private boolean isGenerated(String className, String targetName){
		for(EObject eobj : getDiagram().eResource().getContents()){
			if (eobj instanceof Association){
				Association ass = (Association) eobj;
				//remove the null Association which is generated by Ctrl+a -> delete.
				if(ass.getTarget()==null){
					getDiagram().eResource().getContents().remove(ass);
					return false;
				}
				if(ass.getTarget().getName().equals(targetName) && ((umlClass.Class)ass.getOwner()).getName().equals(className)){
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Get a connection between source class and target class.
	 * @param sourceClass
	 * @param targetClass
	 * @return 'true' if generate success.
	 */
	@SuppressWarnings("unused")
	private boolean generateReference(String sourceClass, String targetClass){
		ContainerShape sourcecs= classContainerMap.get(sourceClass);
		ContainerShape targetcs= classContainerMap.get(targetClass);
		if(null == sourcecs || null == targetcs)
			return false;
		CreateConnectionContext createconnectioncontext = new CreateConnectionContext();
		createconnectioncontext.setSourceAnchor(sourcecs.getAnchors().get(0));
		createconnectioncontext.setTargetAnchor(targetcs.getAnchors().get(0));
		createconnectioncontext.setSourcePictogramElement(classContainerMap.get("Subject"));

		org.eclipse.graphiti.features.ICreateConnectionFeature icreatecontext = getFeatureProvider().getCreateConnectionFeatures()[0];
		Assert.isTrue(icreatecontext.getCreateName().equals("Association"));
		
		if (null != icreatecontext) {
			icreatecontext.execute(createconnectioncontext);
			return true;
		}
		return false;
	}
	
}
