package jp.ac.kyushu.iarch.basefunction.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

/**
 * Read an arch configuration file in a Java project
 * @author Templar
 */
public class XMLreader {
	private static String ArchfilePath=null;
	private static String ClassDiagramPath=null;
	private static List<String> SequenceDiagramPathes= new ArrayList<String>();
	private static List<String> SourceCodePathes = new ArrayList<String>();
	private static String ARXMLPath=null;
	private static IJavaProject JavaProject=null;

	public XMLreader(IProject project){
		readXMLContent(project);
		setJavaProject(JavaCore.create(project));
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
		String FS = File.separator;	//separator for file path(On Windows, this means '\\', and on Mac OS and Linux, this means '/') added by Fukamachi
		try{
			SAXReader saxReader = new SAXReader();
			FileInputStream fis = new FileInputStream(project.getProject().getLocation().toOSString()+FS+"Config.xml");
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
	public IResource getClassDiagramResource() {
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
	public IResource getArchfileResource() {
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
	public List<IResource> getSequenceDiagramResource(){
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
	public List<IResource> getSourceCodeResource(){
		List<IResource> SourceCodeResources = new ArrayList<IResource>();
		for(String SourceCodePath:SourceCodePathes){
			IPath path = new Path(SourceCodePath);
			IResource SourceCodeResource = readIResource(path);
			SourceCodeResources.add(SourceCodeResource);
		}
		return SourceCodeResources;
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
=======
package jp.ac.kyushu.iarch.basefunction.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

/**
 * Read an arch configuration file in a Java project
 * @author Templar
 */
public class XMLreader {
	private static String ArchfilePath = null;
	private static String ClassDiagramPath = null;
	private static String DataflowDiagramPath = null;
	private static List<String> SequenceDiagramPathes= new ArrayList<String>();
	private static List<String> SourceCodePathes = new ArrayList<String>();
	private static String ARXMLPath = null;
	private static IJavaProject JavaProject = null;

	public XMLreader(IProject project){
		readXMLContent(project);
		setJavaProject(JavaCore.create(project));
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
		ArchfilePath = null;
		ClassDiagramPath = null;
		DataflowDiagramPath = null;
		SequenceDiagramPathes.removeAll(SequenceDiagramPathes);
		SourceCodePathes.removeAll(SourceCodePathes);
		ARXMLPath = null;
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
				List<Node> Dataflowlist = document.selectNodes("//DataflowDiagram/Path/@Attribute");
				if(Dataflowlist.size()!=0){
					Attribute attribute=(Attribute) Dataflowlist.get(0);
					setDataflowDiagramPath(attribute.getValue());
				}
			}
			
			{
				@SuppressWarnings("unchecked")
				List<Node> ClassDiagramlist = document.selectNodes("//ClassDiagram/Path/@Attribute");	
				if(ClassDiagramlist.size()!=0){
					Attribute attribute=(Attribute) ClassDiagramlist.get(0);
					setClassDiagramPath(attribute.getValue());
				}
			}
		   
			{
				@SuppressWarnings("unchecked")
				List<Node> SequenceDiagramlist = document.selectNodes("//SequenceDiagram/Path/@Attribute");
				if(SequenceDiagramlist.size()!=0){
					for (Iterator<Node> iter = SequenceDiagramlist.iterator(); iter.hasNext(); ) {
						Attribute attribute = (Attribute) iter.next();
						String url = attribute.getValue();
						SequenceDiagramPathes.add(url);
					}
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
	public IResource getClassDiagramResource() {
		if(ClassDiagramPath == null)
			return null;
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
	public IResource getArchfileResource() {
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
	
	
	//2014.10.30
	/**
	 * @return the dataflowDiagramResource
	 */
	public IResource getDataflowDiagramResource() {
		if(DataflowDiagramPath == null)
			return null;
		IPath path = new Path(DataflowDiagramPath);
		IResource DataflowDiagramResource = readIResource(path);
		return DataflowDiagramResource;
	}

	/**
	 * @param classDiagramPath the classDiagramPath to set
	 */
	public static void setDataflowDiagramPath(String dataflowDiagramPath) {
		DataflowDiagramPath = dataflowDiagramPath;
	}
	
	
	/**
	 * @return the SequenceDiagramResources
	 */
	public List<IResource> getSequenceDiagramResource(){
		if(SequenceDiagramPathes.size() == 0)
			return new ArrayList<IResource>();
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
	public List<IResource> getSourceCodeResource(){
		List<IResource> SourceCodeResources = new ArrayList<IResource>();
		for(String SourceCodePath:SourceCodePathes){
			IPath path = new Path(SourceCodePath);
			IResource SourceCodeResource = readIResource(path);
			SourceCodeResources.add(SourceCodeResource);			
		}
		return SourceCodeResources;
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