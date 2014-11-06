package jp.ac.kyushu.iarch.basefunction.model;

import org.eclipse.emf.ecore.resource.Resource;

public class SequenceDiagramModel {

	private Resource sequenceDiagram = null;

	/**
	 * @return the sequenceDiagram
	 */
	public Resource getSequenceDiagram() {
		return sequenceDiagram;
	}


	public SequenceDiagramModel(Resource sequenceResource){
		this.sequenceDiagram = sequenceResource;
		
	}
}
