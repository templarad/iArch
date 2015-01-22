package jp.ac.kyushu.iarch.checkplugin.handler;


import java.util.List;


import java.util.logging.Logger;

import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.basefunction.reader.ArchModel;
import jp.ac.kyushu.iarch.basefunction.reader.XMLreader;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;


public class ArchfaceChecker extends XMLreader {

	Logger logger = Logger.getGlobal();
	
	public ArchfaceChecker(IProject project){
		super(project);

	}
//	public static ArchfaceChecker getInstance(IProject project){
//		ProblemViewManager.removeAllProblems(project);
//		readXMLContent(project);
//		setJavaProject(JavaCore.create(project));
//		return archfacechecker;
//	}
	public void checkProject(){		
		checkProjectValidation(getArchfileResource(),getClassDiagramResource(),getDataflowDiagramResource(),
				getSequenceDiagramResource(),getSourceCodeResource(),getARXMLResource());
	}
	
	public void checkProjectValidation(IResource archfile, 
			IResource classDiagramResource, 
			IResource dataflowDiagramResource,
			List<IResource> sequenceDiagramResources,
			List<IResource> sourceCodeResources,
			IResource aRXMLResource){
		if(archfile == null){
			logger.info("No archfile found. Stop the auto check.");
			return;
		}
		ArchModel archmodel = new ArchModel(archfile);
		
		Model archModel = archmodel.getModel();
		//check diagram
		if(classDiagramResource != null){
			ClassDiagramChecker classDiagramChecker = new ClassDiagramChecker();
			classDiagramChecker.checkClassDiagram(archModel, classDiagramResource);
		}
		
		if(sequenceDiagramResources.size() > 0){
			SequenceDiagramChecker sequenceDiagramChecker = new SequenceDiagramChecker();
			for(IResource sequenceDiagramResource : sequenceDiagramResources){
				sequenceDiagramChecker.checkSequenceDiagram(archModel, sequenceDiagramResource);					
			}
		}
		
		//check dataflow diagram
		if(dataflowDiagramResource != null){
			DataflowDiagramChecker dataflowDiagramChecker = new DataflowDiagramChecker();
			dataflowDiagramChecker.checkDataflowDiagram(archModel, dataflowDiagramResource);
		}
		
		//Check source code
		ASTSourceCodeChecker astchecker = new ASTSourceCodeChecker();
		astchecker.SourceCodeArchifileChecker(archModel, getJavaProject());
		
		//Check AR
//		ARChecker archecker = new ARChecker();
//		archecker.checkAR(archfile, aRXMLResource);
		
		return;
	}
	
}
