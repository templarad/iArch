package jp.ac.kyushu.iarch.dataflowdiagram.features;
import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public class RenameDatastoreFeature extends AbstractCustomFeature {
 
    private boolean hasDoneChanges = false;
      
    public RenameDatastoreFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public String getName() {
        return "Rename Datastore";
    }
 
    @Override
    public String getDescription() {
        return "Change the name of the Datastore";
    }
 
    @Override
    public boolean canExecute(ICustomContext context) {
        // allow rename if exactly one pictogram element
        // representing a Class is selected
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if (bo instanceof Dataflow_editor.DataStore) {
                ret = true;
            }
        }
        return ret;
    }
 
   
    public void execute(ICustomContext context) {
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if (bo instanceof Dataflow_editor.DataStore) {
            	Dataflow_editor.DataStore eDatastore = (Dataflow_editor.DataStore) bo;
                String currentName = eDatastore.getName();
                // ask user for a new class name
                String newName = ExampleUtil.askString(getName(), getDescription(),
                        currentName);
                if (newName != null && !newName.equals(currentName)) {
                    this.hasDoneChanges = true;
                    eDatastore.setName(newName);
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