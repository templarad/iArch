package jp.ac.kyushu.iarch.dataflowdiagram.features;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import Dataflow_editor.Dataflow_editorFactory;
 
public class CreateProcessFeature extends AbstractCreateFeature {
 
    public CreateProcessFeature(IFeatureProvider fp) {
        super(fp, "Process", "Create Process");
    }
    
    
    public boolean canCreate(ICreateContext context) {
        return context.getTargetContainer() instanceof Diagram;
    }
 
    public Object[] create(ICreateContext context) {
		String newProcessName = ExampleUtil.askString("Create Process", "Enter new Process's name", "Process");
		if(newProcessName == null || newProcessName.trim().length()==0){
			return EMPTY;
		}
		
		Dataflow_editor.Process process = Dataflow_editorFactory.eINSTANCE.createProcess();
		
		/*Add as an Archpoint in default*/		
		process.setArchpoint(true);
		
		getDiagram().eResource().getContents().add(process);
		process.setName(newProcessName);
		
		addGraphicalRepresentation(context, process);
		
		return new Object[] {process};
	}
}
