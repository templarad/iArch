package jp.ac.kyushu.iarch.classdiagram.features;

import jp.ac.kyushu.iarch.basefunction.hander.ArchModelHander;
import jp.ac.kyushu.iarch.basefunction.reader.*;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

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
            	umlClass.Class contextClass = (umlClass.Class) bo;
            	String className = contextClass.getName();
            	
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
                String currentName = eClass.getName();
                // ask user for a new class name
                String newName = ExampleUtil.askString(getName(), getDescription(),
                        currentName);
                if (newName != null && !newName.equals(currentName)) {
                	IProject project = ProjectReader.getProject();
                	XMLreader xx= new XMLreader(project);
                	ArchModelHander archmodel = new ArchModelHander(xx.getArchfileResource());
//                	try {
//						project.getMarker(0).getAttribute(IMarker.PROBLEM);
//					} catch (CoreException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
                	archmodel.changeClassName(currentName, newName);

                    eClass.setName(newName);
                    this.hasDoneChanges = true;
                    updatePictogramElement(pes[0]);
                }
            }
        }
    }
 
    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }
}