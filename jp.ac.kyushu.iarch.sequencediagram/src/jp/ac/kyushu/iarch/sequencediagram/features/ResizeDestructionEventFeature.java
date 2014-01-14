package jp.ac.kyushu.iarch.sequencediagram.features;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;

public class ResizeDestructionEventFeature extends DefaultResizeShapeFeature {
    
    public ResizeDestructionEventFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public boolean canResizeShape(IResizeShapeContext context) {
    	boolean canResize = false;
        return canResize;
    }
 }