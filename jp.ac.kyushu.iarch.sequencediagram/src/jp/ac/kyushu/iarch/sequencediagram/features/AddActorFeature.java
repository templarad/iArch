package jp.ac.kyushu.iarch.sequencediagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import behavior.Actor;



public class AddActorFeature extends AbstractAddShapeFeature {

	public AddActorFeature(IFeatureProvider fp) {
		super(fp);
	}


	@Override
	public boolean canAdd(IAddContext context) {
		if(context.getNewObject() instanceof behavior.Actor){
			if(context.getTargetContainer() instanceof Diagram){
				return true;				
			}
		}
		return false;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		Actor actor = (Actor) context.getNewObject();
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);
		
		int width = 50 ;
		int height = 65;
		
		IGaService gaService = Graphiti.getGaService();
		Rectangle rect;  // dummy Rect
		{
			//Shape shape = peCreateService.createShape(containerShape, false);
			rect = gaService.createRectangle(containerShape);
			rect.setForeground(manageColor(255, 255, 255));
//			rect.setBackground(manageColor(255, 255, 255));
			rect.setFilled(false);
			//gaService.setLocationAndSize(rect, context.getX(), 70, width, height);
			gaService.setLocationAndSize(rect, context.getX(), 30, width, height);
            if (actor.eResource() == null) {
                getDiagram().eResource().getContents().add(actor);
                }
			link(containerShape, actor);
		}
		{
			Shape shape = peCreateService.createShape(containerShape, false);
			Text text = gaService.createText(shape, actor.getName());
			text.setForeground(manageColor(0,0,0));
			text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
			gaService.setLocationAndSize(text, 0, 10, width, 90);
			link(shape, actor);
		}
		{
			Shape shape = peCreateService.createShape(containerShape, false);
			Ellipse head = gaService.createEllipse(shape);
			head.setForeground(manageColor(0,0,0));
			head.setBackground(manageColor(255,255,255));
			gaService.setLocationAndSize(head, width/2-5,5,10,10);
			link(shape, actor);
		}
		{
			Shape shape = peCreateService.createShape(containerShape, false);
			Polyline body = gaService.createPolyline(shape, new int[]{width/2, 14,width/2,35});
			body.setForeground(manageColor(0, 0, 0));
			body.setLineWidth(1);
			link(shape, actor);
		}
		{                                                                                                                                                                                                                                                                                                                                                               
			Shape shape = peCreateService.createShape(containerShape, false);
			Polyline arms = gaService.createPolyline(shape, new int[]{10,18,width-10,18});
			arms.setForeground(manageColor(0, 0, 0));
			arms.setLineWidth(1);
			link(shape, actor);
		}
		{
			Shape shape = peCreateService.createShape(containerShape, false);
			Polyline lleg = gaService.createPolyline(shape, new int[]{width/2, 35, 10, 45});
			lleg.setForeground(manageColor(0, 0, 0));
			lleg.setFilled(false);
			lleg.setLineWidth(1);
			link(shape, actor);
		}
		{
			Shape shape = peCreateService.createShape(containerShape, false);
			Polyline rleg = gaService.createPolyline(shape, new int[]{width/2, 35, width-10, 45});
			rleg.setForeground(manageColor(0, 0, 0));
			rleg.setFilled(false);
			rleg.setLineWidth(1);
			link(shape, actor);
		}
		peCreateService.createChopboxAnchor(containerShape);

		return containerShape;
	}
}
