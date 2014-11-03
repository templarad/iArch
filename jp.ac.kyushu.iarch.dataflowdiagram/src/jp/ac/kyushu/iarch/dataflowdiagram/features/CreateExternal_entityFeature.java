package jp.ac.kyushu.iarch.dataflowdiagram.features;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import Dataflow_editor.Dataflow_editorFactory;
 
public class CreateExternal_entityFeature extends AbstractCreateFeature {
 
//    private static final String TITLE = "Create Process";
//   private static final String USER_QUESTION = "Enter new Process name";
 
    public CreateExternal_entityFeature(IFeatureProvider fp) {
        // set name and description of the creation feature       !!!!!!!!!!!Set name!!!!!!!!!!
        super(fp, "External entity", "Create External entity");
    }
 
    public boolean canCreate(ICreateContext context) {
        return context.getTargetContainer() instanceof Diagram;
    }
 
    public Object[] create(ICreateContext context) {
		String newExternal_entityName = ExampleUtil.askString("Create External entity", "Enter new External entity's name", "Entity");
		if(newExternal_entityName == null || newExternal_entityName.trim().length()==0){
			return EMPTY;
		}
		
		Dataflow_editor.External_entity external_entity = Dataflow_editorFactory.eINSTANCE.createExternal_entity();
		
		external_entity.setArchpoint(true);     //2014.8.7 new
		
		getDiagram().eResource().getContents().add(external_entity);
		external_entity.setName(newExternal_entityName);
		
		addGraphicalRepresentation(context, external_entity);
		
		return new Object[] {external_entity};
	}
}