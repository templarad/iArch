package jp.ac.kyushu.iarch.sequencediagram.diagram.providers;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;

public class SequenceDiagramTypeProvider extends AbstractDiagramTypeProvider
		implements IDiagramTypeProvider {

	public SequenceDiagramTypeProvider() {
		super();
		setFeatureProvider(new SequenceFeatureProvider(this));
	}
}
