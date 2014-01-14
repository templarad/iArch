package jp.ac.kyushu.iarch.sequencediagram.features;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import behavior.BehaviorFactory;

public class CreateActorFeature extends AbstractCreateFeature {

	public CreateActorFeature(IFeatureProvider fp) {
		super(fp, "Actor", "Create Actor");
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public Object[] create(ICreateContext context) {
		String newActorName = ExampleUtil.askString("Create actor", "Enter new actor name", "");
		if(newActorName == null || newActorName.trim().length()==0){
			return EMPTY;
		}
		
		behavior.Actor actor = BehaviorFactory.eINSTANCE.createActor();
		getDiagram().eResource().getContents().add(actor);
		actor.setName(newActorName);
		
		addGraphicalRepresentation(context, actor);
		
		return new Object[] {actor};
	}
}
