package jp.ac.kyushu.iarch.checkplugin.handler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.Node;

import org.eclipse.core.resources.IProject;


public class ArchfaceChecker {
	private static String ArchfilePath=null;
	private static String ClassDiagramPath=null;
	private static List<String> SequenceDiagramPath= new ArrayList<String>();
	private static List<String> SourceCodePath = new ArrayList<String>();
	private static String ARXMLPath=null;
	
	public boolean isConfigFileExist(IProject project){
		String ConfigFile=project.getProject().getLocation().toOSString()+"/Config.xml";
		File myFilePath = new File(ConfigFile);

		if (myFilePath.exists()) {
			return true;
		}
		return false;
	}

	public static void readXMLContent(IProject project) {
		  try{
			   SAXReader saxReader = new SAXReader();
			   Document document = saxReader.read(project.getProject().getLocation().toOSString()+"/Config.xml");
			   {
				   @SuppressWarnings("unchecked")
				List<Node> Archfilelist = document.selectNodes("//Archfile/Path/@Attribute");			   
				   Attribute attribute=(Attribute) Archfilelist.get(0);
				   ArchfilePath = attribute.getValue();
			   }
			   
			   {
				   @SuppressWarnings("unchecked")
				List<Node> ClassDiagramlist = document.selectNodes("//ClassDiagram/Path/@Attribute");			   
				   Attribute attribute=(Attribute) ClassDiagramlist.get(0);
				   ClassDiagramPath = attribute.getValue();
			   }
			   
			   {

				   @SuppressWarnings("unchecked")
				List<Node> SequenceDiagramlist = document.selectNodes("//SequenceDiagram/Path/@Attribute");
				   for (Iterator<Node> iter = SequenceDiagramlist.iterator(); iter.hasNext(); ) {
			            Attribute attribute = (Attribute) iter.next();
			            String url = attribute.getValue();
			            SequenceDiagramPath.add(url);
			        }
			   }
			   
			   {
				   @SuppressWarnings("unchecked")
				List<Node> SourceCodelist = document.selectNodes("//SourceCode/Path/@Attribute");
				   for (Iterator<Node> iter = SourceCodelist.iterator(); iter.hasNext(); ) {
			            Attribute attribute = (Attribute) iter.next();
			            String url = attribute.getValue();
			            SourceCodePath.add(url);
			        }
			   }
			   
			   {
				   @SuppressWarnings("unchecked")
				List<Node> ARXMLlist = document.selectNodes("//ARXML/Path/@Attribute");			   
				   Attribute attribute=(Attribute) ARXMLlist.get(0);
				   ARXMLPath = attribute.getValue();
			   }
			   
			   }
		  catch(DocumentException e){
              System.out.println(e.getMessage());
              }
	}
	
}
