package jp.ac.kyushu.iarch.checkplugin.handler;


import java.util.List;


import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.basefunction.reader.ArchModel;
import jp.ac.kyushu.iarch.basefunction.reader.XMLreader;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;


public class ArchfaceChecker extends XMLreader {

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
		checkProjectValidation(getArchfileResource(),getClassDiagramResource(),
				getSequenceDiagramResource(),getSourceCodeResource(),getARXMLResource());
	}
	
	public void checkProjectValidation(IResource archfile, 
			IResource classDiagramResource, 
			List<IResource> sequenceDiagramResources,
			List<IResource> sourceCodeResources,
			IResource aRXMLResource){
		ArchModel archmodel = new ArchModel(archfile);
		
		Model archModel = archmodel.getModel();
		//check diagram
		ClassDiagramChecker classDiagramChecker = new ClassDiagramChecker();
		classDiagramChecker.checkClassDiagram(archModel, classDiagramResource);
		
		SequenceDiagramChecker sequenceDiagramChecker = new SequenceDiagramChecker();
		for(IResource sequenceDiagramResource : sequenceDiagramResources){
			sequenceDiagramChecker.checkSequenceDiagram(archModel, sequenceDiagramResource);					
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
