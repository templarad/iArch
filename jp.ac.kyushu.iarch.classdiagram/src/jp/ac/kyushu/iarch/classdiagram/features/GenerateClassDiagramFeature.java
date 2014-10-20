package jp.ac.kyushu.iarch.classdiagram.features;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jp.ac.kyushu.iarch.basefunction.controller.ArchModelController;
import jp.ac.kyushu.iarch.basefunction.controller.GraphitiModelManager;
import jp.ac.kyushu.iarch.basefunction.model.ClassDiagramModel;
import jp.ac.kyushu.iarch.basefunction.reader.ArchModel;
import jp.ac.kyushu.iarch.basefunction.reader.ProjectReader;
import jp.ac.kyushu.iarch.basefunction.reader.XMLreader;
import jp.ac.kyushu.iarch.classdiagram.diagram.DiagramFeatureProvider;
import jp.ac.kyushu.iarch.archdsl.archDSL.Behavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.features.impl.AbstractFeature;

import umlClass.Operation;
import umlClass.UmlClassFactory;

public class GenerateClassDiagramFeature extends AbstractCustomFeature{

	public GenerateClassDiagramFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}
	@Override
    public String getName() {
        return "Generate All Class";
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
    
	private static final IColorConstant E_CLASS_TEXT_FOREGROUND =
	        IColorConstant.BLACK;

	private static final IColorConstant OPERATION_TEXT_FOREGROUND =
	        IColorConstant.BLACK;
	
	private static final IColorConstant E_CLASS_FOREGROUND =
	        new ColorConstant(98, 131, 167);

	private static final IColorConstant E_CLASS_BACKGROUND =
	        new ColorConstant(187, 218, 247);
	
    private static final IColorConstant OPERATION_FOREGROUND =
            new ColorConstant(98, 131, 167);
	/**
	 * The X position of first class to generate.
	 */
	private static int STARTX = 40;
	
	/**
	 * The Y position of first class to generate.
	 */
	private static int STARTY = 70;
	
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
		
		Resource classResource = GraphitiModelManager.getGraphitiModel(classDiagramIResource);
		
		
		
		ClassDiagramModel cdm = new ClassDiagramModel(classResource);
		Model archmodel = archModel.getModel();
		int i=0;
		for(Interface archclass : archmodel.getInterfaces()){
			umlClass.Class umlclass = UmlClassFactory.eINSTANCE.createClass();
			umlclass.setArchpoint(true);
			if(null == cdm.getClass(archclass.getName())){
				umlclass.setName(archclass.getName());
				
			
				ContainerShape classShape = addClassFeature(classResource,umlclass,STARTX,STARTY + i * 50);
				List<umlClass.Operation> operations = getOperations(archmodel, archclass);
				generateOperations(umlclass, operations, classShape);
				i++;
				layoutPictogramElement(classShape);
			    updatePictogramElement(classShape);
			}else{
				//Fill the lost operation.
				
			}
		}
		try {
			classResource.save(null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		//cdm.getClass(classResource, className)

	}
	protected Color manageColor(Diagram diagram,IColorConstant colorConstant) {
		return Graphiti.getGaService().manageColor(diagram, colorConstant);
	}
	
	private ContainerShape addClassFeature(Resource classResource, umlClass.Class addedClass,int startX,int startY){
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		EObject o = classResource.getContents().get(0);
			
		if(o instanceof Diagram){
			Diagram targetDiagram = (Diagram) o;
			
			ContainerShape containerShape =
		             peCreateService.createContainerShape(targetDiagram, true);
			int width = 100;
	        int height = 50;
	        RoundedRectangle roundedRectangle; // need to access it later
	        IGaService gaService = Graphiti.getGaService();
	        {
	            // create and set graphics algorithm
	            roundedRectangle =
	                gaService.createRoundedRectangle(containerShape, 5, 5);
	            roundedRectangle.setForeground(manageColor(targetDiagram,E_CLASS_FOREGROUND));
	            roundedRectangle.setBackground(manageColor(targetDiagram,E_CLASS_BACKGROUND));
	            roundedRectangle.setLineWidth(2);
	            gaService.setLocationAndSize(roundedRectangle,
	            		startX, startY, width, height);
	 
	            // if added Class has no resource we add it to the resource 
	            // of the diagram
	            // in a real scenario the business model would have its own resource

	            targetDiagram.eResource().getContents().add(addedClass);

	            // create link and wire it
	            link(containerShape, addedClass);
	        }
	        // SHAPE WITH LINE
	        {
	            // create shape for line
	            Shape shape = peCreateService.createShape(containerShape, false);
	 
	            // create and set graphics algorithm
	            Polyline polyline =
	                gaService.createPolyline(shape, new int[] { 0, 20, width, 20 });
	            polyline.setForeground(manageColor(E_CLASS_FOREGROUND));
	            polyline.setLineWidth(2);
	        }
	 
	        // SHAPE WITH TEXT
	        {
	            // create shape for text
	            Shape shape = peCreateService.createShape(containerShape, false);
	 
	            // create and set text graphics algorithm
	            Text text = gaService.createText(shape, addedClass.getName());
	            text.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
	            text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER); 
	            // vertical alignment has as default value "center"
	            text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
	            gaService.setLocationAndSize(text, 0, 0, width, 20);
	 
	            // create link and wire it
	            link(shape, addedClass);
	        }
	        peCreateService.createChopboxAnchor(containerShape);
	        
	        
	        
	       
	        return containerShape;
		}
		else return null;
		
	}
	@Override
	public void execute(ICustomContext context) {

		generateClassDiagram();
		
	}
	
	private void generateOperations(umlClass.Class targetClass, List<umlClass.Operation> newOperations, ContainerShape containerShape ){
		//Operation newOperation = UmlClassFactory.eINSTANCE.createOperation();
		int linenum=0;
        // define a default size for the shape
        int height;

		IPeCreateService peCreateService = Graphiti.getPeCreateService();
 
        
        
        IGaService gaService = Graphiti.getGaService();
        peCreateService = Graphiti.getPeCreateService();
        gaService = Graphiti.getGaService();
        int width=containerShape.getGraphicsAlgorithm().getWidth();
        int temp = targetClass.getAttribute().size()*20+targetClass.getOwnedOperation().size()*20+32;
        height = containerShape.getGraphicsAlgorithm().getHeight() <= temp ? temp:
        															containerShape.getGraphicsAlgorithm().getHeight();
        gaService.setSize(containerShape.getGraphicsAlgorithm(), width, height) ;
        int start=targetClass.getAttribute().size()*20+32;

        for(umlClass.Operation newOperation: newOperations)
        {
        	
            if(0 == linenum)
            // SHAPE WITH LINE
            {
                // create shape for line
                Shape shape = peCreateService.createShape(containerShape, false);
     
                // create and set graphics algorithm
                Polyline polyline =
                    gaService.createPolyline(shape, new int[] { 0, start, width, start });
                polyline.setForeground(manageColor(OPERATION_FOREGROUND));
                polyline.setLineWidth(2);
            }
            
            
    		newOperation.setArchpoint(true);
    		targetClass.getOwnedOperation().add(newOperation);
        	
            // create shape for operation
            Shape shape = peCreateService.createShape(containerShape, true);
 
            // create and set text graphics algorithm
          //DataType datetype = addedOperation.getDatatype();
            //System.out.println(datetype.getName()+"...operation name:"+datetype.getOwnedOperation().get(0).getName());
            Text text = gaService.createText(shape , newOperation.getName()+"()");
            text.setForeground(manageColor(OPERATION_TEXT_FOREGROUND));
            text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT); 
            
            // vertical alignment has as default value "center"
            text.setFont(gaService.manageDefaultFont(getDiagram(), true, true));
            gaService.setLocationAndSize(text, 2, start + linenum * 20, containerShape.getGraphicsAlgorithm().getWidth() - 4, 20);
 
            // create link and wire it
            link(shape, newOperation);
            linenum ++;
        }
        
		
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
}
