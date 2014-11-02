package jp.ac.kyushu.iarch.checkplugin.handler;
import org.dom4j.io.SAXReader;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import jp.ac.kyushu.iarch.checkplugin.utils.ProjectSelectionUtils;
import jp.ac.kyushu.iarch.checkplugin.view.SelectSourceCodeFile;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.HandlerUtil;
public class codeToArchface implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		
       IProject project = ProjectSelectionUtils.getProject(event, "Generate Archiface");
		
		SelectSourceCodeFile dialog = new SelectSourceCodeFile(
				HandlerUtil.getActiveShell(event), project);
		if (dialog.open() == MessageDialog.OK) {
			
			try {
				GenerateArchifaceCode(dialog.getXml());
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	
	Element test=null;
	private void GenerateArchifaceCode(IResource xmlfile) throws DocumentException { 
		String archfaceString="";
	SAXReader reader = new SAXReader();
	 Document XMLdocument = reader.read(xmlfile.getLocation().toString());
	 Element root = XMLdocument.getRootElement();
    test = (Element) root.selectSingleNode("//Package[@name='']");
	 for (Iterator classIterator = test.elementIterator(); classIterator.hasNext();) { 
			
            Element classXML = (Element) classIterator.next();
            String ClassName = classXML.attributeValue("name"); 
            archfaceString+="interface component  "+ClassName+" {";
            archfaceString+= "\n";
            for (Iterator methodIterator = classXML.elementIterator(); methodIterator.hasNext();) {
                Element methodXML = (Element) methodIterator.next();
                String ex=methodXML.getName().toString();
            	if (methodXML.getName().toString()=="MethodDeclaration") {
                    String methodName=methodXML.attributeValue("name");
                    //Add Modifiers
                    List methodModifiers= methodXML.selectNodes("MethodModifiers/modifier");
                    Element lastModifiers=(Element) methodModifiers.get(methodModifiers.size()-1);
                    String modifierString=lastModifiers.getText();
                    if (!modifierString.equals("void")) {
                    	modifierString=methodXML.element("returnType").getText();
					}
                    String methodParameter="";
                    
                    List methodParameterEle = methodXML.selectNodes("parameterTypeElement");
                    if (methodParameterEle.size()!=0) {
					  methodParameter=methodXML.element("parameterTypeElement").element("parameterType").getText();
					}
                    archfaceString+="	"+modifierString;
                    //String methodArgumentType=methodXML.attributeValue("");
                    archfaceString+=" "+methodName+"  ("+methodParameter+")";
    	            archfaceString+= "\n";
    	            
    				}
            }
            archfaceString+="}"+"\n";
	 }
	 
	 //behavior list
	 archfaceString="";
	 for (Iterator classIterator = test.elementIterator(); classIterator.hasNext();) { 
         Element classXML = (Element) classIterator.next();
         String ClassName = classXML.attributeValue("name"); 
         for (Iterator methodIterator = classXML.elementIterator(); methodIterator.hasNext();) {
        	 
             Element methodXML = (Element) methodIterator.next();
         	if (methodXML.getName().toString().equals("MethodDeclaration")) {
         		archfaceString+=ClassName+"= "+"{";
                 String methodName=methodXML.attributeValue("name");
                 //Add Modifiers
                 List methodInvocations= methodXML.selectNodes("MethodInvocation");
                 archfaceString+=ClassName+"."+methodName+"->"+retrunString(ClassName, methodXML);
                 archfaceString+=ClassName+"}"+"\n";
 				}
         }
         archfaceString+="\n";
	 }
	 //Manufacture sequence
/*	 for (Iterator classIterator = test.elementIterator(); classIterator.hasNext();) { 
			
         Element classXML = (Element) classIterator.next();
         String ClassName = classXML.attributeValue("name"); 
         archfaceString+=ClassName+"= ";
         for (Iterator methodIterator = classXML.elementIterator(); methodIterator.hasNext();) {
             Element methodXML = (Element) methodIterator.next();
             String ex=methodXML.getName().toString();
         	if (methodXML.getName().toString()=="MethodDeclaration") {
                 String methodName=methodXML.attributeValue("name");
                 //Add Modifiers
                 archfaceString+="  		"+ClassName+"."+methodName+"->";
                 List methodInvocations= methodXML.selectNodes("MethodInvocation");
                 for (Iterator iterator = methodInvocations.iterator(); iterator
							.hasNext();) {
						Element object = (Element) iterator.next();
						String methodNameInvo=object.attributeValue("name");
						String methodClass=object.attributeValue("type");
						if (!(methodClass==null)){
							
						archfaceString+=methodClass+"."+methodNameInvo+"  ;  ";
						}
						else {
							methodClass=ClassName;
							archfaceString+=methodClass+"."+methodNameInvo+"  ;  ";
						
						}
						codeMap.put(ClassName+"."+methodName,methodClass+"."+methodNameInvo);
					}
                 archfaceString+="\n";
 				}
  	       archfaceString+="\n";
         }
	       archfaceString+="\n";
	 }
	 */
	String projectPath = xmlfile.getProject().getLocation().toOSString();
	String ArchiCodeFile=projectPath +"/Generated Archface";
	File myFilePath = new File(ArchiCodeFile);
	try {
		if (!myFilePath.exists()) {
			myFilePath.createNewFile();   
			}
		FileWriter resultFile = new FileWriter(myFilePath);
		PrintWriter myFile = new PrintWriter(resultFile);
		myFile.println(archfaceString);
		resultFile.close();
		}
	catch (Exception e) {
		System.out.println("Create File Error!");
		e.printStackTrace();
		}
	
	
}
	
	
	private String retrunString(String className,Element methodElement)
	{
		String aString="";
		List methodInvocations= methodElement.selectNodes("MethodInvocation");
		for (Iterator iterator = methodInvocations.iterator(); iterator
			 .hasNext();) {
			if (!iterator .hasNext()) {
				 aString="\n";
				break;
			}
			Element object = (Element) iterator.next();
			String methodInvoName=object.attributeValue("name");
			String methodClass=object.attributeValue("type");
			if (methodClass==null){
				methodClass=className;
			}
			aString+=methodClass+"."+methodInvoName+"->";
			try {
				
				Element methodElement2=(Element) test.selectSingleNode("//Class[@name='"+methodClass+"']/MethodDeclaration[@name='"+methodInvoName+"']");
				 		//+ "/MethodDeclaration[@name='"+methodInvoName+"']");	
				
				if (!(methodElement2==null)) {
					aString+=retrunString(methodClass,methodElement2);
				}
				
			} 
			
			catch (Exception e) {
				continue;
				// TODO: handle exception
			}
		}
		return aString;
         
			
		}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
