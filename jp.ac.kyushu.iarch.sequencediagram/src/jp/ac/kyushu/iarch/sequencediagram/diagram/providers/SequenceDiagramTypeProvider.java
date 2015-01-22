package jp.ac.kyushu.iarch.sequencediagram.diagram.providers;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;


public class SequenceDiagramTypeProvider extends AbstractDiagramTypeProvider
		implements IDiagramTypeProvider {
	private IToolBehaviorProvider[] toolBehaviorProviders;

	public SequenceDiagramTypeProvider() {
		super();
		setFeatureProvider(new SequenceFeatureProvider(this));
	}
	
	@Override
    public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
        if (toolBehaviorProviders == null) {
            toolBehaviorProviders =
                new IToolBehaviorProvider[] { new SequenceToolBehaviorProvider(
                    this) };
        }
        return toolBehaviorProviders;
    }
	
}
