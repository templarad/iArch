package jp.ac.kyushu.iarch.classdiagram.features;

import jp.ac.kyushu.iarch.basefunction.controller.ArchModelController;
import jp.ac.kyushu.iarch.basefunction.controller.GraphitiModelManager;
import jp.ac.kyushu.iarch.basefunction.controller.SequenceDiagramModelController;
import jp.ac.kyushu.iarch.basefunction.reader.*;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;

import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import java.io.IOException;
import java.util.List;



public class RenameClassFeature extends AbstractCustomFeature {
 
    private boolean hasDoneChanges = false;
      
    public RenameClassFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public String getName() {
        return "Rename Class";
    }
 
    @Override
    public String getDescription() {
        return "Change the name of the Class";
    }
 
    @Override
    public boolean canExecute(ICustomContext context) {
        // allow rename if exactly one pictogram element
        // representing a Class is selected
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if (bo instanceof umlClass.Class) {            	
            	ret = true;
            }
        }
        return ret;
    }
 
    @Override
    public void execute(ICustomContext context) {
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if (bo instanceof umlClass.Class) {
            	umlClass.Class eClass = (umlClass.Class) bo;
            	if(eClass.isArchpoint()){
            		
            	}            		
            	else{
            		MessageDialog.open(MessageDialog.WARNING,
        					null, "Can't refactoring",
        					"Please check the archpoint property.", SWT.None);
            		return;
            	}
                String currentName = eClass.getName();
                // ask user for a new class name
                String newName = ExampleUtil.askString(getName(), getDescription(),
                        currentName);
                if (newName != null && !newName.equals(currentName)) {
                	//Refactoring arch-code and sequence diagram
                	{
                    	IProject project = ProjectReader.getProject();
                    	XMLreader xx= new XMLreader(project);
                    	ArchModelController archmodel = new ArchModelController(xx.getArchfileResource());
//                    	try {
//    						project.getMarker(0).getAttribute(IMarker.PROBLEM);
//    					} catch (CoreException e) {
//    						// TODO Auto-generated catch block
//    						e.printStackTrace();
//    					}
                    	
                    	archmodel.changeClassName(currentName, newName);
                    	List<IResource> sqDiagrams = xx.getSequenceDiagramResource();
                    	boolean changed = false;
                    	for (IResource sqDiagram:sqDiagrams){
                    		SequenceDiagramModelController sdmh = new SequenceDiagramModelController();
                    		changed = sdmh.changeObjectName(sqDiagram, currentName, newName);
                    	}
                    	if(!changed)
                    		System.out.println("Refactoring: Can't find the same object in sequence diagram.");
                        eClass.setName(newName);
                        this.hasDoneChanges = true;
                        updatePictogramElement(pes[0]);

                    	Resource classDiagram = GraphitiModelManager.getGraphitiModel(xx.getClassDiagramResource());
                        try {
                        	classDiagram.save(null);
    					} catch (IOException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
//						UpdateContext updateContext = new UpdateContext(getDiagram().getChildren().get(0).getGraphicsAlgorithm().getPictogramElement());
//						IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(updateContext);
//						updateFeature.update(updateContext);

                	}//End refactoring
                	

                }
            }
        }
    }
 
    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }
    
    
}