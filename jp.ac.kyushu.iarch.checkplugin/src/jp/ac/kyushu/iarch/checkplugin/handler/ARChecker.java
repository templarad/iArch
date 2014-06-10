package jp.ac.kyushu.iarch.checkplugin.handler;

import jp.ac.kyushu.iarch.archdsl.ArchDSLPlugin;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.archdsl.ui.internal.ArchDSLActivator;
import jp.ac.kyushu.iarch.checkplugin.view.AbstractionRatioViewPart;

import org.apache.xerces.parsers.DOMParser;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.w3c.dom.Document;

import com.google.inject.Injector;

public class ARChecker {
	
	final private static Injector injector = ArchDSLActivator.getInstance()
			.getInjector(ArchDSLPlugin.getLanguageName());

	private AbstractionRatioChecker abstractionRatioChecker;
	
	public void checkAR(IResource archifile,IResource xml){
		Model archiface = getArchifaceModel(archifile);
		abstractionRatioChecker = new AbstractionRatioChecker();
		abstractionRatioChecker.checkArchiface(archiface, archifile);	
		Document xmldocument = getCodeXml(xml);
		abstractionRatioChecker.checkXml(xml,xmldocument);
		abstractionRatioChecker.calculateAbstractionRatio(archifile);
		
		//checkAbstractionRatioValidation(archifile,xml);
		
		showAbstractionRatio(abstractionRatioChecker);
	}
	
	private Model getArchifaceModel(IResource archifile) {
		XtextResourceSet rs = (XtextResourceSet) injector.getInstance(
				XtextResourceSetProvider.class).get(archifile.getProject());
		rs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

		Resource resource = rs.getResource(URI.createPlatformResourceURI(
				archifile.getFullPath().toString(), true), true);
		return (Model) resource.getContents().get(0);
	}
	
	private Document getCodeXml(IResource xml){
		Document xmldocument = null;
		try{
			DOMParser parser = new DOMParser();
			parser.parse(xml.getLocation().toString());
			xmldocument = parser.getDocument();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return xmldocument;
	}
	
	private void showAbstractionRatio(AbstractionRatioChecker checker){
		AbstractionRatioViewPart abstractionRatioView = null;
		IWorkbenchWindow[] views = PlatformUI.getWorkbench().getWorkbenchWindows();
		//for(IViewReference view :PlatformUI.getWorkbench().getActiveWorkbenchWindows().getActivePage().getViewReferences()){
		for(IViewReference view :views[0].getActivePage().getViewReferences()){
			if(view.getId().equals(AbstractionRatioViewPart.ID)){
				abstractionRatioView = (AbstractionRatioViewPart)view.getView(true);
				
			}
		}
		if(abstractionRatioView==null){ // if view not open.
			try{
				abstractionRatioView = (AbstractionRatioViewPart)PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage()
						.showView(AbstractionRatioViewPart.ID);
			}catch(PartInitException pie){
				pie.printStackTrace();
				return;
			}
		}
		
		abstractionRatioView.setRatio(checker.getAbstractionRatio());
		abstractionRatioView.setArchAndImpl(checker.getArchpointNum(), checker.getXmlpointNum());
		abstractionRatioView.setStructureRatio(1-(double)(checker.getClassNum()+checker.getMethodNum())
				/(double)(checker.getXmlClassNum()+checker.getXmlMethodNum()));
		abstractionRatioView.setStructureArchAndImpl(checker.getXmlClassNum()+checker.getMethodNum() ,
				checker.getXmlClassNum()+checker.getXmlMethodNum());
		abstractionRatioView.setBehaviorRatio(1-(double)checker.getBehaviorNum() 
				/ (double)checker.getXmlInvocationPointNum());
		abstractionRatioView.setBehaviorArchAndImpl(checker.getBehaviorNum(),
				checker.getXmlInvocationPointNum());
	}
}
