package jp.ac.kyushu.iarch.sequencediagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import behavior.Actor;
import behavior.Lifeline;
import behavior.BehaviorFactory;

public class CreateLifelineFeature extends AbstractCreateConnectionFeature {

	public CreateLifelineFeature(IFeatureProvider fp) {
		super(fp, "Lifeline", "add Lifeline");
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
//		Anchor anchor = context.getSourceAnchor();
//		if (anchor != null) {
//			Object parent = getBusinessObjectForPictogramElement(anchor
//					.getParent());
//			if (parent instanceof Actor) {
//				return true;
//			} else if (parent instanceof sequence.Object) {
//				return true;
//			}
//		}
		return true;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		Connection connection = null;
		Lifeline lifeline = BehaviorFactory.eINSTANCE.createLifeline();
		PictogramElement sourcePe = context.getSourcePictogramElement();
		if (sourcePe != null && sourcePe instanceof ContainerShape) {
			Object parent = getBusinessObjectForPictogramElement(sourcePe);
			if (parent instanceof Actor) {
				Actor actor = (Actor) parent;
				actor.setInclude(lifeline);
				AddConnectionContext addContext = new AddConnectionContext(
						context.getSourceAnchor(), null);
				addContext.setNewObject(lifeline);
				connection = (Connection) getFeatureProvider().addIfPossible(addContext);
				
				return connection;
			} else if (parent instanceof behavior.Object) {
				behavior.Object object = (behavior.Object) parent;
				object.setInclude(lifeline);
				AddConnectionContext addContext = new AddConnectionContext(
						context.getSourceAnchor(), null);
				addContext.setNewObject(lifeline);
				connection = (Connection) getFeatureProvider().addIfPossible(addContext);
				return connection;
			}
		}
		return null;
	}

	@SuppressWarnings("unused")
	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		PictogramElement srcPE = context.getSourcePictogramElement();
		if (srcPE != null && !(srcPE instanceof Diagram)) {
			Object obj = getBusinessObjectForPictogramElement(srcPE);
			Object[] allObj = getAllBusinessObjectsForPictogramElement(srcPE);
			srcPE.getGraphicsAlgorithm();
			if (obj != null) {
				if (obj instanceof behavior.Object || obj instanceof Actor) {
					return true;
				}
			}
		}
		return false;
	}
}
