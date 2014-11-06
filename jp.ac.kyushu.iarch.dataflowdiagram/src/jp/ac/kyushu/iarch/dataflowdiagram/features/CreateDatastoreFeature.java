package jp.ac.kyushu.iarch.dataflowdiagram.features;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import Dataflow_editor.Dataflow_editorFactory;
 
public class CreateDatastoreFeature extends AbstractCreateFeature {
 
    public CreateDatastoreFeature(IFeatureProvider fp) {
        super(fp, "Datastore", "Create Datastore");
    }
 
    public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}
    
    public Object[] create(ICreateContext context) {
		String newDatastoreName = ExampleUtil.askString("Create Datastore", "Enter new Datastore's name", "Datastore");
		if(newDatastoreName == null || newDatastoreName.trim().length()==0){
			return EMPTY;
		}
		
		Dataflow_editor.DataStore datastore = Dataflow_editorFactory.eINSTANCE.createDataStore();
		
		//create setArchpoint
		datastore.setArchpoint(true);  //2014.8.7 new
		
		getDiagram().eResource().getContents().add(datastore);
		datastore.setName(newDatastoreName);
		
		addGraphicalRepresentation(context, datastore);
		
		return new Object[] {datastore};
	}
}
