package jp.ac.kyushu.iarch.dataflowdiagram.features;
import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public class RenameExternal_entityFeature extends AbstractCustomFeature {
 
    private boolean hasDoneChanges = false;
      
    public RenameExternal_entityFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public String getName() {
        return "Rename External_entity";
    }
 
    @Override
    public String getDescription() {
        return "Change the name of the External_entity";
    }
 
    @Override
    public boolean canExecute(ICustomContext context) {
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if (bo instanceof Dataflow_editor.External_entity) {
                ret = true;
            }
        }
        return ret;
    }
 
   
    public void execute(ICustomContext context) {
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if (bo instanceof Dataflow_editor.External_entity) {
            	Dataflow_editor.External_entity EE = (Dataflow_editor.External_entity) bo;
                String currentName = EE.getName();
                // ask user for a new class name
                String newName = ExampleUtil.askString(getName(), getDescription(),
                        currentName);
                if (newName != null && !newName.equals(currentName)) {
                    this.hasDoneChanges = true;
                    EE.setName(newName);
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