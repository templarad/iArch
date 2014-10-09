package jp.ac.kyushu.iarch.sequencediagram.features;

import java.util.List;

import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.basefunction.controller.ArchModelController;
import jp.ac.kyushu.iarch.basefunction.controller.GraphitiModelManager;
import jp.ac.kyushu.iarch.basefunction.reader.ArchModel;
import jp.ac.kyushu.iarch.basefunction.reader.ProjectReader;
import jp.ac.kyushu.iarch.basefunction.reader.XMLreader;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.resource.Resource;
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
		XMLreader xmlreader = new XMLreader(ProjectReader.getProject());
		List<IResource> sequenceDiagramIResources = xmlreader.getSequenceDiagramResource();
		IResource archfile = xmlreader.getArchfileResource();
		ArchModel archModel = new ArchModelController(archfile);
		Model archfaceModel = archModel.getModel();
		for(IResource sequenceDiagramIResource : sequenceDiagramIResources){
			Resource sequenceResource = GraphitiModelManager.getGraphitiModel(sequenceDiagramIResource);
			generateSequenceDiagram(sequenceResource,archfaceModel);
			
			
		}
	}

	@Override
    public String getName() {
        return "Generate Sequence Diagram";
    }
 
    @Override
	public boolean canExecute(ICustomContext context) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
    public String getDescription() {
        return "Reflecting change of code to the Sequence diagram.";
    }
	
	public void generateSequenceDiagram(Resource sequenceResource, Model archfaceModel ){

	}
}
