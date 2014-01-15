package jp.ac.kyushu.iarch.sequencediagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;

public class ChangeColorFeature extends AbstractCustomFeature{

	public ChangeColorFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}
	public final boolean canExecute(ICustomContext context){
		
		return true;
		
	}
	@Override
	public void execute(ICustomContext context) {
		context.getInnerGraphicsAlgorithm().setBackground(manageColor(255, 255, 0));
		context.getInnerPictogramElement().setActive(true);
	}

}
