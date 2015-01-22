package jp.ac.kyushu.iarch.classdiagram.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

public class DiagramTypeProvider extends AbstractDiagramTypeProvider implements IDiagramTypeProvider{

	@Override
	public boolean isAutoUpdateAtRuntime() {
		// TODO Auto-generated method stub
		return true;
	}
	private IToolBehaviorProvider[] toolBehaviorProviders;
 
    @Override
    public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
        if (toolBehaviorProviders == null) {
            toolBehaviorProviders =
                new IToolBehaviorProvider[] { new ClassToolBehaviorProvider(
                    this) };
        }
        return toolBehaviorProviders;
    }
       public DiagramTypeProvider() {
          super();
          setFeatureProvider(new DiagramFeatureProvider(this));
       }
}