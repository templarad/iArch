package jp.ac.kyushu.iarch.dataflowdiagram.features;
import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import Dataflow_editor.DataFlow;

public class RenameDataflowFeature extends AbstractCustomFeature {
 
    private boolean hasDoneChanges = false;
      
    public RenameDataflowFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public String getName() {
        return "Rename Dataflow";
    }
 
    @Override
    public String getDescription() {
        return "Change the name of the Dataflow";
    }
 
    @Override
    public boolean canExecute(ICustomContext context) {
        // allow rename if exactly one pictogram element
        // representing a Association is selected
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if (bo instanceof DataFlow) {
                ret = true;
            }
            else if(pes[0] instanceof ConnectionDecorator){
            	ret = true;
            }
        }
        return ret;
    }
 
    
    public void execute(ICustomContext context) {
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if (bo instanceof DataFlow) {
            	DataFlow eReference = (DataFlow) bo;
                String currentName = eReference.getName();
                // ask user for a new class name
                String newName = ExampleUtil.askString(getName(), getDescription(),
                        currentName);
                if (newName != null && !newName.equals(currentName)) {
                    this.hasDoneChanges = true;
                    eReference.setName(newName);
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