package jp.ac.kyushu.iarch.sequencediagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;

public class GenerateSequenceDiagramFeature extends AbstractCustomFeature{

	public GenerateSequenceDiagramFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(ICustomContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
    public String getName() {
        return "Generate All Class";
    }
 
    @Override
	public boolean canExecute(ICustomContext context) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
    public String getDescription() {
        return "Reflecting change of code to the Class diagram.";
    }
}
