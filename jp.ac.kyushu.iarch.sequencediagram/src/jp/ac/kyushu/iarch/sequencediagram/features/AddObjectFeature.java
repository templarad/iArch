package jp.ac.kyushu.iarch.sequencediagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
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

import behavior.Object;

public class AddObjectFeature extends AbstractAddShapeFeature {

	public AddObjectFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		if(context.getNewObject() instanceof behavior.Object){
			if(context.getTargetContainer() instanceof Diagram){
				return true;				
			}
		}
		return false;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		Object obj = (Object) context.getNewObject();
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);
		link(containerShape, obj);
		int width = context.getWidth()<=0?100 : context.getWidth();
		if(width < obj.getName().length()*10){
			width = obj.getName().length()*10;
		}
//		int height = context.getHeight()<=0?20:context.getHeight();
		int height = 20;
		IGaService gaService = Graphiti.getGaService();
		Rectangle rect;
		{
			rect = gaService.createRectangle(containerShape);
			rect.setForeground(manageColor(0,0,0));
			rect.setBackground(manageColor(250, 250, 250));
			rect.setLineWidth(1);
			gaService.setLocationAndSize(rect, context.getX(), 60, width, height);
		}
		{
			Shape shape = peCreateService.createShape(containerShape, false);
			Text text = gaService.createText(shape, ": "+obj.getName());
			text.setForeground(manageColor(0,0,0));
			text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
			gaService.setLocationAndSize(text, 0, 0, width, 20);
			link(shape, obj);
		}
		peCreateService.createChopboxAnchor(containerShape);
		
		return containerShape;
	}
}
