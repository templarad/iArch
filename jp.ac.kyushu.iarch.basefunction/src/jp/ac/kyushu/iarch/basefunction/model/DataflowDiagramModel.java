package jp.ac.kyushu.iarch.basefunction.model;

import org.eclipse.emf.ecore.resource.Resource;

public class DataflowDiagramModel {

	private Resource dataflowDiagram = null;

	/**
	 * @return the sequenceDiagram
	 */
	public Resource getSequenceDiagram() {
		return dataflowDiagram;
	}


	public DataflowDiagramModel(Resource dataflowResource){
		this.dataflowDiagram = dataflowResource;
		
	}
}
