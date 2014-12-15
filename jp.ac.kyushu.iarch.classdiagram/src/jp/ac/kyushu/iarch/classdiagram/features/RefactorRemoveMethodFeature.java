package jp.ac.kyushu.iarch.classdiagram.features;

import java.io.IOException;
import java.util.List;

import jp.ac.kyushu.iarch.basefunction.controller.ArchModelController;
import jp.ac.kyushu.iarch.basefunction.controller.SequenceDiagramModelController;
import jp.ac.kyushu.iarch.basefunction.reader.ProjectReader;
import jp.ac.kyushu.iarch.basefunction.reader.XMLreader;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;

import umlClass.Operation;
/**
 * Haven't completed yet:<br>
 * Modify sequence diagram function.
 * @author Templar
 *
 */
public class RefactorRemoveMethodFeature extends AbstractCustomFeature{

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
//                    	try {
//    						project.getMarker(0).getAttribute(IMarker.PROBLEM);
//    					} catch (CoreException e) {
//    						// TODO Auto-generated catch block
//    						e.printStackTrace();
//    					}
                    	
                    	archmodel.removeMethod(owenClass.getName(),currentName);
                    	List<IResource> sqDiagrams = xx.getSequenceDiagramResource();
                    	boolean changed = false;
                    	for (IResource sqDiagram:sqDiagrams){
                    		SequenceDiagramModelController sdmh = new SequenceDiagramModelController();
                    		changed = sdmh.removeMethod(sqDiagram, owenClass.getName(), currentName);
                    	}
                    	if(!changed)
                    		System.out.println("Refactoring: Can't find the same object("+ owenClass.getName()+") in sequence diagram.");


//                		try {
//    						((Operation) bo).eContainer().eResource().save(null);
//    					} catch (IOException e) {
//    						// TODO Auto-generated catch block
//    						e.printStackTrace();
//        					
//                    	}
                	}
                	//End refactoring
                	
                    this.hasDoneChanges = true;
                    Shape shape = (Shape) context.getPictogramElements()[0];
            		DeleteContext ctx = new DeleteContext(shape);
            		ctx.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 2));
            		IDeleteFeature deleteFeature = getFeatureProvider().getDeleteFeature(ctx);
            		if (deleteFeature!=null)
            			deleteFeature.execute(ctx);
            		updatePictogramElement(shape.getContainer());
                    try {
                    	getDiagram().eResource().save(null);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    
            }
        }
	}

    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }
}
