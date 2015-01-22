package jp.ac.kyushu.iarch.classdiagram.features;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import jp.ac.kyushu.iarch.basefunction.controller.ArchModelController;
import jp.ac.kyushu.iarch.basefunction.controller.GraphitiModelManager;
import jp.ac.kyushu.iarch.basefunction.controller.SequenceDiagramModelController;
import jp.ac.kyushu.iarch.basefunction.reader.ProjectReader;
import jp.ac.kyushu.iarch.basefunction.reader.XMLreader;
import jp.ac.kyushu.iarch.sequencediagram.diagram.providers.SequenceDiagramTypeProvider;
import jp.ac.kyushu.iarch.sequencediagram.diagram.providers.SequenceFeatureProvider;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.features.context.impl.RemoveContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import behavior.MessageOccurrenceSpecification;
import umlClass.Operation;
/**
 * Haven't completed part:<br>
 * Modify sequence diagram function.
 * @author Templar
 *
 */
public class RefactorRemoveMethodFeature extends AbstractCustomFeature{

	private static final Logger logger = LoggerFactory.getLogger(RefactorRemoveMethodFeature.class);
	private boolean hasDoneChanges = false;
	
	public RefactorRemoveMethodFeature(IFeatureProvider fp) {
		super(fp);
	}
	@Override
    public String getName() {
        return "Refactoring Remove Method";
    }
 
    @Override
    public String getDescription() {
        return "Remove the method which you don't want to reflect in the model";
    }
 
    @Override
    public boolean canExecute(ICustomContext context) {
    	// allow rename if exactly one pictogram element
        // representing a Class is selected
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if (bo instanceof Operation) {
                ret = true;
            }
        }
        return ret;
    }
	@Override
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		
		if (!(context.getPictogramElements()[0] instanceof Shape)){
			return;
		}
        if (pes != null && pes.length == 1) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if (bo instanceof Operation) {
            	Operation eOperation = (Operation) bo;
            	//
            	if(eOperation.isArchpoint()){
            		
            	}            		
            	else{
            		MessageDialog.open(MessageDialog.WARNING,
        					null, "Can't refactoring",
        					"Please check the archpoint property.", SWT.None);
            		return;
            	}
            	
                String currentName = eOperation.getName();
                // ask user for a new class name
                
                umlClass.Class owenClass = eOperation.getClass_();
                IProject project = ProjectReader.getProject();
            	XMLreader xx= new XMLreader(project);
            	{
                	
                	ArchModelController archmodel = new ArchModelController(xx.getArchfileResource());
                	archmodel.removeMethod(owenClass.getName(),currentName);
                	List<IResource> sqDiagrams = xx.getSequenceDiagramResource();
                	boolean changed = false;
                	for (IResource sqDiagram:sqDiagrams){
                		SequenceDiagramModelController sdmh = new SequenceDiagramModelController();
                		changed = sdmh.removeMethod(sqDiagram, owenClass.getName(), currentName);
                	}
                	if(!changed){
                		logger.debug("Refactoring - Can't find the same object({}) in sequence diagram.", owenClass.getName());
                	}
            	}
            	//End refactoring
            	//Delete element from class diagram
                this.hasDoneChanges = true;
                Shape shape = (Shape) context.getPictogramElements()[0];
        		DeleteContext ctx = new DeleteContext(shape);
        		ctx.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 2));
        		IDeleteFeature deleteFeature = getFeatureProvider().getDeleteFeature(ctx);
        		if (deleteFeature!=null){
        			deleteFeature.execute(ctx);
        		}
        		RemoveContext removectx = new RemoveContext(shape);
        		ctx.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 2));
        		IRemoveFeature removeFeature = getFeatureProvider().getRemoveFeature(removectx);
        		if (removeFeature!=null){
        			removeFeature.execute(ctx);
        		}
        		
                try {
                	getDiagram().eResource().save(null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("Refactoring - Saving diagram failed : {}", getDiagram().getName());
				}
                updatePictogramElement(shape.getContainer());
                //Delete element from sequence diagram
                removeMessageFromSequenceDiagram(xx, owenClass.getName(), currentName);
            }
        }
	}

    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }
    //重新生成？or改Resource
    public boolean removeMessageFromSequenceDiagram(XMLreader xml,String objectName, String messageName){
    	List<IResource> sqList = xml.getSequenceDiagramResource();
    	if(sqList.isEmpty()){
    		logger.warn("Refactoring - Remove from sequence : no sequence diagram exsit");
    		return false;
    	}
    	Iterator<IResource> sqIt = sqList.iterator();
    	Diagram diagram = null;
    	while(sqIt.hasNext()){
    		IResource sqRescource = sqIt.next();
    		Resource sequenceDiagram = GraphitiModelManager.getGraphitiModel(sqRescource);
    		diagram = (Diagram)sequenceDiagram.getContents().get(0);
    		logger.debug("Refactoring - Remove from diagram : {}", diagram.getDiagramTypeId());
    		Iterator<Shape> containerShapeIt = diagram.getChildren().iterator();
    		while(containerShapeIt.hasNext()){
    			ContainerShape cs = (ContainerShape)containerShapeIt.next();
    			Object obj = cs.getLink().getBusinessObjects().get(0);
    			if(obj instanceof MessageOccurrenceSpecification 
    					&& ((MessageOccurrenceSpecification) obj).getMessage().getName().equals(messageName)
    					&&((MessageOccurrenceSpecification) obj).getCovered().get(0).getActor().getName().equals(objectName)){
    				
    				logger.debug("MessageOccurrenceSpecification : {}", ((MessageOccurrenceSpecification) obj).getCovered().get(0).getActor().getName());
    				DeleteContext ctx = new DeleteContext(cs);
            		ctx.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 2));
            		SequenceDiagramTypeProvider sdtp = new SequenceDiagramTypeProvider();
            		SequenceFeatureProvider sfp = new SequenceFeatureProvider(sdtp);
            		IDeleteFeature deleteFeature = sfp.getDeleteFeature(ctx);
            		if (deleteFeature!=null){
            			deleteFeature.execute(ctx);
            			break;
            		}
    				
    			}
    		}
    		updatePictogramElement(diagram);
    		try {
				diagram.eResource().save(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	
    	return true;
    }
}
