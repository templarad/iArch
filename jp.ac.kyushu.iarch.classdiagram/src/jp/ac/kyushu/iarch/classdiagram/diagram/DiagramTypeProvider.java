package jp.ac.kyushu.iarch.classdiagram.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;

public class DiagramTypeProvider extends AbstractDiagramTypeProvider {

       public DiagramTypeProvider() {
          super();
          setFeatureProvider(new DiagramFeatureProvider(this));
       }
}