package jp.ac.kyushu.iarch.checkplugin.handler;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import jp.ac.kyushu.iarch.checkplugin.utils.ProjectSelectionUtils;
import jp.ac.kyushu.iarch.checkplugin.view.SelectAllFileDialog;

import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.dom4j.Document;
import org.dom4j.Element;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.HandlerUtil;

public class ConfigurationXMLHandler implements IHandler{
	
	public void CreateConfigFile(IProject project, SelectAllFileDialog AllDialog){
		Document codeXmlDocument = DocumentHelper.createDocument();
		Element rootElement = codeXmlDocument.addElement("Project");
		rootElement.addAttribute("name", project.getName());
		
		final Element ArchCodeElement = rootElement.addElement("Archfile");
		{
			final Element PathElement = ArchCodeElement.addElement("Path");
			PathElement.addAttribute("Attribute", AllDialog.getArchiface().getFullPath().toOSString());
		}

		
		final Element ClassDiagramElement = rootElement.addElement("ClassDiagram");
		{			
			final Element PathElement = ClassDiagramElement.addElement("Path");
			PathElement.addAttribute("Attribute", AllDialog.getClassDiagram().getFullPath().toOSString());
		}
		
		final Element DataflowDiagramElement = rootElement.addElement("DataflowDiagram");
		{			
			final Element PathElement = DataflowDiagramElement.addElement("Path");
			PathElement.addAttribute("Attribute", AllDialog.getDataflowDiagram().getFullPath().toOSString());
		}
		
		final Element SequenceDiagramElement = rootElement.addElement("SequenceDiagram");
		{			
			for(IResource resource:AllDialog.getSequenceDiagrams()){
				final Element PathElement = SequenceDiagramElement.addElement("Path");
				PathElement.addAttribute("Attribute", resource.getFullPath().toOSString());
			}
		}
		
		
		final Element SourceCodeElement = rootElement.addElement("SourceCode");
		{
			
			for(IResource resource:AllDialog.getSourceCode()){
				final Element PathElement = SourceCodeElement.addElement("Path");
				PathElement.addAttribute("Attribute", resource.getFullPath().toOSString());
			}
		}
		
		
		final Element XMLElement = rootElement.addElement("ARXML");
		{
			final Element PathElement = XMLElement.addElement("Path");
			PathElement.addAttribute("Attribute", AllDialog.getXml().getFullPath().toOSString());
		}
		
		
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();
			String projectPath = project.getProject().getLocation().toOSString();
			XMLWriter output = new XMLWriter(new FileWriter(new File(projectPath + "/Config.xml")), format);
			codeXmlDocument.setXMLEncoding("utf-8");
			output.write(codeXmlDocument);
			output.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}


	
	public boolean isConfigFileExist(IProject project){
		String ConfigFile=project.getProject().getLocation().toOSString()+"/Config.xml";
		File myFilePath = new File(ConfigFile);

		if (myFilePath.exists()) {
			return true;
		}
		return false;
	}
	@Override
	public void addHandlerListener(IHandlerListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IProject project = ProjectSelectionUtils.getProject(event, "Configuration");

		SelectAllFileDialog dialog = new SelectAllFileDialog(
				HandlerUtil.getActiveShell(event), project);
		if (dialog.open() == MessageDialog.OK) {
			if(project == null){
				return null;
			}
			if(isConfigFileExist(project)){
				CreateConfigFile(project,dialog);
			}else{
				CreateConfigFile(project,dialog);
			}
			ArchfaceChecker.readXMLContent(project);
		}
		
			
		
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener arg0) {
		// TODO Auto-generated method stub
		
	}

}
