package jp.ac.kyushu.iarch.dataflowdiagram.diagram.providers; 

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider; 
import org.eclipse.graphiti.tb.IToolBehaviorProvider;



public class DiagramTypeProvider extends AbstractDiagramTypeProvider {

	public DiagramTypeProvider() {
		super();
		setFeatureProvider(new DiagramFeatureProvider(this));
	}
	
	IToolBehaviorProvider[] toolBehaviorProviders;

	@Override
	public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
		if (toolBehaviorProviders == null) {
			toolBehaviorProviders = new IToolBehaviorProvider[] { new DiagramToolBehaviorProvider(
					this) };
		}
		return toolBehaviorProviders;

	}
	
	
	
}
	