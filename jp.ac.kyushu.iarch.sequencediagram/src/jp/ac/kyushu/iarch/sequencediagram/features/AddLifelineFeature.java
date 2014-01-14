package jp.ac.kyushu.iarch.sequencediagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import behavior.BehaviorFactory;
import behavior.DestructionEvent;
import behavior.Lifeline;

public class AddLifelineFeature extends AbstractAddFeature {

	public AddLifelineFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return context.getNewObject() instanceof Lifeline;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		IAddConnectionContext concontext = (IAddConnectionContext)context;
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();
		int locationY = 470;
		//if there have been a DestructionEvent, get the location Y
		for(Shape shape:getDiagram().getChildren())
		{
			Object bo = getBusinessObjectForPictogramElement(shape);
			if (bo instanceof DestructionEvent)
			{
				locationY = shape.getGraphicsAlgorithm().getY();
				break;
			}
		}
		ContainerShape dummyContainer = peCreateService.createContainerShape(getDiagram(), true);
		Rectangle dummyrect = gaService.createRectangle(dummyContainer);
		ContainerShape parentShape = (ContainerShape) concontext.getSourceAnchor().eContainer();
		
		gaService.setLocationAndSize(dummyrect, 
				parentShape.getGraphicsAlgorithm().getX()+parentShape.getGraphicsAlgorithm().getWidth()/2-5, locationY, 10, 10);
		dummyrect.setLineWidth(1);
		Anchor dummyAnchor = peCreateService.createChopboxAnchor(dummyContainer);

		Lifeline lifeline = (Lifeline)context.getNewObject();
		
		DestructionEvent de = BehaviorFactory.eINSTANCE.createDestructionEvent();
		
		getDiagram().eResource().getContents().add(lifeline);
		getDiagram().eResource().getContents().add(de);
		Connection connection = peCreateService.createFreeFormConnection(getDiagram());
		connection.setStart(concontext.getSourceAnchor());
		connection.setEnd(dummyAnchor);
		
		Polyline polyline = gaService.createPolyline(connection);
		polyline.setWidth(10);
		polyline.setLineWidth(1);
		polyline.setLineStyle(LineStyle.DASH);
		polyline.setForeground(manageColor(0,0,0));
		polyline.setFilled(true);
		link(dummyContainer,de);
		link(connection, lifeline);
		lifeline.setEndby(de);
	
		return connection;
	}
}
