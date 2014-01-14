package jp.ac.kyushu.iarch.sequencediagram.features;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;

public class ResizeBehaviorExecutionFeature extends DefaultResizeShapeFeature {
    
    public ResizeBehaviorExecutionFeature(IFeatureProvider fp) {
        super(fp);
    }
    @Override
    public void resizeShape(IResizeShapeContext context) {
		Shape shape = context.getShape();
		int x = context.getX();
		int y = context.getY();
		int width = shape.getGraphicsAlgorithm().getWidth();
		int height = context.getHeight();

		if (shape.getGraphicsAlgorithm() != null) {
			Graphiti.getGaService().setLocationAndSize(shape.getGraphicsAlgorithm(), x, y, width, height);
		}

		layoutPictogramElement(shape);
	}
 }