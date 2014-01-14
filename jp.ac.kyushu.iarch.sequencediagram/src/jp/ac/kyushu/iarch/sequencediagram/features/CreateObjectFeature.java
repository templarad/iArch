package jp.ac.kyushu.iarch.sequencediagram.features;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import behavior.BehaviorFactory;

public class CreateObjectFeature extends AbstractCreateFeature {

	public CreateObjectFeature(IFeatureProvider fp) {
		super(fp, "Object", "Create Object");
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public Object[] create(ICreateContext context) {
		String newObjectName = ExampleUtil.askString("Create object", "Enter new obj name", "");
		if(newObjectName == null || newObjectName.trim().length()==0){
			return EMPTY;
		}
		
		behavior.Object object = BehaviorFactory.eINSTANCE.createObject();
		/*Add as an Archpoint in default*/
		object.setArchpoint(true);
		getDiagram().eResource().getContents().add(object);
		object.setName(newObjectName);
		
		addGraphicalRepresentation(context, object);
		
		return new Object[] {object};
	}
}
