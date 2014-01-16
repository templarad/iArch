package jp.ac.kyushu.iarch.sequencediagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveAnchorContext;
import org.eclipse.graphiti.features.impl.DefaultMoveAnchorFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;

import behavior.MessageOccurrenceSpecification;

public class MoveAnchorFeature extends DefaultMoveAnchorFeature{
	
    public MoveAnchorFeature(IFeatureProvider fp) {
        super(fp);
    }

    @Override
    public void moveAnchor(IMoveAnchorContext context) {
		if (!getUserDecision()) {
			return;
		}
//		IGaService gaService = Graphiti.getGaService();
		ILinkService linkServivce = Graphiti.getLinkService();
		int posY = context.getY();
		
		
		Object ob = getBusinessObjectForPictogramElement(context.getAnchor());
		if (ob instanceof MessageOccurrenceSpecification){
			MessageOccurrenceSpecification MgWhich = (MessageOccurrenceSpecification) ob;
			MessageOccurrenceSpecification Mgstart = (MessageOccurrenceSpecification)MgWhich.getMessage().getSendEvent();
			MessageOccurrenceSpecification Mgend = (MessageOccurrenceSpecification)Mgstart.getMessage().getReceiveEvent();
			if(MgWhich == Mgstart){				
				moveAnchor(context.getAnchor(), context.getAnchor().getGraphicsAlgorithm().getX(), posY);
				for (PictogramElement pe : linkServivce.getPictogramElements(getDiagram(), Mgend)){
					if (pe instanceof Anchor&&
							(MessageOccurrenceSpecification)getBusinessObjectForPictogramElement(pe) == Mgend){
						Anchor anchor = (Anchor) pe;
						moveAnchor(anchor, anchor.getGraphicsAlgorithm().getX(), posY);
					}
				}
			
			}
			else {
				moveAnchor(context.getAnchor(), context.getAnchor().getGraphicsAlgorithm().getX(), posY);
				for (PictogramElement pe : linkServivce.getPictogramElements(getDiagram(), Mgstart)){
					if (pe instanceof Anchor&&
							(MessageOccurrenceSpecification)getBusinessObjectForPictogramElement(pe) == Mgstart){
						Anchor anchor = (Anchor) pe;
						moveAnchor(anchor, anchor.getGraphicsAlgorithm().getX(), posY);
					}
				}
			}			
		}
    }
}
