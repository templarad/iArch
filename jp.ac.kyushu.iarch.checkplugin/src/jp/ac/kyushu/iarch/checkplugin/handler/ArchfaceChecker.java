package jp.ac.kyushu.iarch.checkplugin.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import jp.ac.kyushu.iarch.archdsl.ArchDSLPlugin;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.archdsl.ui.internal.ArchDSLActivator;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import com.google.inject.Injector;


public class ArchfaceChecker {
	private static String ArchfilePath=null;
	private static String ClassDiagramPath=null;
	private static List<String> SequenceDiagramPathes= new ArrayList<String>();
	private static List<String> SourceCodePathes = new ArrayList<String>();
	private static String ARXMLPath=null;
	private static IJavaProject JavaProject=null;
	private static ArchfaceChecker archfacechecker= new ArchfaceChecker();
	private ArchfaceChecker(){
		//Singleton
	}
	public static ArchfaceChecker getInstance(IProject project){
		ProblemViewManager.removeAllProblems(project);
		readXMLContent(project);
		setJavaProject(JavaCore.create(project));
		return archfacechecker;
	}
	public void checkProject(){		
		checkProjectValidation(getArchfileResource(),getClassDiagramResource(),
				getSequenceDiagramResource(),getSourceCodeResource(),getARXMLResource());
	}
	
	public void checkProjectValidation(IResource archfile, 
			IResource classDiagramResource, 
			List<IResource> sequenceDiagramResources,
			List<IResource> sourceCodeResources,
			IResource aRXMLResource){
		
		Model ArchModel = getArchifaceModel(archfile);
		//check diagram
		ClassDiagramChecker classDiagramChecker = new ClassDiagramChecker();
		classDiagramChecker.checkClassDiagram(ArchModel, classDiagramResource);
		
		SequenceDiagramChecker sequenceDiagramChecker = new SequenceDiagramChecker();
		for(IResource sequenceDiagramResource : sequenceDiagramResources){
			sequenceDiagramChecker.checkSequenceDiagram(ArchModel, sequenceDiagramResource);					
		}
		
		//Check source code
		ASTSourceCodeChecker astchecker = new ASTSourceCodeChecker();
		astchecker.SourceCodeArchifileChecker(ArchModel, getJavaProject());
		
		//Check AR
//		ARChecker archecker = new ARChecker();
//		archecker.checkAR(archfile, aRXMLResource);
		
		return;
	}
	public boolean isConfigFileExist(IProject project){
		String ConfigFile=project.getProject().getLocation().toOSString()+"/Config.xml";
		File myFilePath = new File(ConfigFile);

		if (myFilePath.exists()) {
			return true;
		}
		return false;
	}
	
	public static IResource readIResource(IPath path){
		IResource re = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
		return re;
	}
	
	private static void initial(){
		ArchfilePath=null;
		ClassDiagramPath=null;
		SequenceDiagramPathes.removeAll(SequenceDiagramPathes);
		SourceCodePathes.removeAll(SourceCodePathes);
		ARXMLPath=null;
	}

	
	public static void readXMLContent(IProject project) {
		initial();
		try{
			SAXReader saxReader = new SAXReader();
			FileInputStream fis = new FileInputStream(project.getProject().getLocation().toOSString()+"\\Config.xml");
			Document document = saxReader.read(fis);
			{
				@SuppressWarnings("unchecked")
				List<Node> Archfilelist = document.selectNodes("//Archfile/Path/@Attribute");			   
				Attribute attribute=(Attribute) Archfilelist.get(0);
				setArchfilePath(attribute.getValue());
			}
		   
			{
				@SuppressWarnings("unchecked")
				List<Node> ClassDiagramlist = document.selectNodes("//ClassDiagram/Path/@Attribute");			   
				Attribute attribute=(Attribute) ClassDiagramlist.get(0);
				setClassDiagramPath(attribute.getValue());
			}
		   
			{
				@SuppressWarnings("unchecked")
				List<Node> SequenceDiagramlist = document.selectNodes("//SequenceDiagram/Path/@Attribute");
				for (Iterator<Node> iter = SequenceDiagramlist.iterator(); iter.hasNext(); ) {
					Attribute attribute = (Attribute) iter.next();
					String url = attribute.getValue();
					SequenceDiagramPathes.add(url);
					}
				}
			
			{
				@SuppressWarnings("unchecked")
				List<Node> SourceCodelist = document.selectNodes("//SourceCode/Path/@Attribute");
				for (Iterator<Node> iter = SourceCodelist.iterator(); iter.hasNext(); ) {
					Attribute attribute = (Attribute) iter.next();
					String url = attribute.getValue();
					SourceCodePathes.add(url);
					}
				}
			
			{
				@SuppressWarnings("unchecked")
				List<Node> ARXMLlist = document.selectNodes("//ARXML/Path/@Attribute");
				Attribute attribute=(Attribute) ARXMLlist.get(0);
				setARXMLPath(attribute.getValue());
				}
			
		}
		catch(DocumentException e){
			System.out.println(e.getMessage());
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	

	/**
	 * @return the aRXMLResource
	 */
	public static IResource getARXMLResource() {
		IPath path = new Path(ARXMLPath);
		IResource ARXMLResource = readIResource(path);
		return ARXMLResource;
	}

	/**
	 * @param aRXMLPath the aRXMLPath to set
	 */
	public static void setARXMLPath(String aRXMLPath) {
		ARXMLPath = aRXMLPath;
	}

	/**
	 * @return the classDiagramResource
	 */
	public static IResource getClassDiagramResource() {
		IPath path = new Path(ClassDiagramPath);
		IResource ClassDiagramResource = readIResource(path);
		return ClassDiagramResource;
	}

	/**
	 * @param classDiagramPath the classDiagramPath to set
	 */
	public static void setClassDiagramPath(String classDiagramPath) {
		ClassDiagramPath = classDiagramPath;
	}

	/**
	 * @return the archfileResource
	 */
	public static IResource getArchfileResource() {
		IPath path = new Path(ArchfilePath);
		IResource Archfile = readIResource(path);
		return Archfile;
	}

	/**
	 * @param archfilePath the archfilePath to set
	 */
	public static void setArchfilePath(String archfilePath) {
		ArchfilePath = archfilePath;
	}
	
	/**
	 * @return the SequenceDiagramResources
	 */
	public static List<IResource> getSequenceDiagramResource(){
		List<IResource> SequenceDiagramResources = new ArrayList<IResource>();
		for(String SequenceDiagramPath:SequenceDiagramPathes){
			IPath path = new Path(SequenceDiagramPath);
			IResource SequenceDiagramResource = readIResource(path);
			SequenceDiagramResources.add(SequenceDiagramResource);			
		}
			
		return SequenceDiagramResources;
	}
	
	/**
	 * @return the SourceCodeResources
	 */
	public static List<IResource> getSourceCodeResource(){
		List<IResource> SourceCodeResources = new ArrayList<IResource>();
		for(String SourceCodePath:SourceCodePathes){
			IPath path = new Path(SourceCodePath);
			IResource SourceCodeResource = readIResource(path);
			SourceCodeResources.add(SourceCodeResource);			
		}
		return SourceCodeResources;
	}
	
	private Model getArchifaceModel(IResource archfile) {
		final Injector injector = ArchDSLActivator.getInstance().getInjector(ArchDSLPlugin.getLanguageName());;
		XtextResourceSet rs = (XtextResourceSet) injector.getInstance(
				XtextResourceSetProvider.class).get(archfile.getProject());
		rs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

		Resource resource = rs.getResource(URI.createPlatformResourceURI(
				archfile.getFullPath().toString(), true), true);
		return (Model) resource.getContents().get(0);
	}

	/**
	 * @return the javaProject
	 */
	public static IJavaProject getJavaProject() {
		return JavaProject;
	}

	/**
	 * @param javaProject the javaProject to set
	 */
	private static void setJavaProject(IJavaProject javaProject) {
		JavaProject = javaProject;
	}
}
