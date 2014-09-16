package jp.ac.kyushu.iarch.basefunction.reader;

import java.io.File;
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


public class XMLreader {
	private String ArchfilePath=null;
	private IJavaProject JavaProject=null;

	public XMLreader(IProject project){
		System.out.println("ok");
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
	
	public IResource readIResource(IPath path){
		IResource re = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
		return re;
	}
	
	private void initial(){
		ArchfilePath=null;
	}

	
	public void readXMLContent(IProject project) {
		initial();
		try{
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(project.getProject().getLocation().toOSString()+"/Config.xml");
			{
				
				@SuppressWarnings("unchecked")
				List<Node> Archfilelist = document.selectNodes("//Archfile/Path/@Attribute");			   
				Attribute attribute=(Attribute) Archfilelist.get(0);
				setArchfilePath(attribute.getValue());
			}			
		}
		catch(DocumentException e){
			System.out.println(e.getMessage());
		}
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
	public void setArchfilePath(String archfilePath) {
		ArchfilePath = archfilePath;
	}
	
	


	/**
	 * @return the javaProject
	 */
	public IJavaProject getJavaProject() {
		return JavaProject;
	}

	/**
	 * @param javaProject the javaProject to set
	 */
	private void setJavaProject(IJavaProject javaProject) {
		JavaProject = javaProject;
	}
}
