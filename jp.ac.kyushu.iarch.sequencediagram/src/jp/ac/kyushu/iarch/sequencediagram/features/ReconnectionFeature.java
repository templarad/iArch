package jp.ac.kyushu.iarch.sequencediagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import behavior.Actor;
import behavior.BehaviorExecutionSpecification;

public class ReconnectionFeature extends DefaultReconnectionFeature {
    public ReconnectionFeature(IFeatureProvider fp) {
        super(fp);
    }

    @Override
    public boolean canReconnect(IReconnectionContext context) {
		Object ob = getBusinessObjectForPictogramElement((PictogramElement)context.getOldAnchor().eContainer());
		
		if (ob instanceof Actor||ob instanceof behavior.Object){
        //do not allow to reconnect
			return false;
		}else if(ob instanceof BehaviorExecutionSpecification){
			if(context.getNewAnchor()!=null){
				Object newob = getBusinessObjectForPictogramElement((PictogramElement)context.getNewAnchor().eContainer());
				if(newob instanceof BehaviorExecutionSpecification){
					return true;
				}else return false;
			}
			
		
			return true;
		}
		else return false;
    }
}
