package jp.ac.kyushu.iarch.basefunction.reader;


import jp.ac.kyushu.iarch.archdsl.ArchDSLPlugin;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.archdsl.ui.internal.ArchDSLActivator;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import com.google.inject.Injector;


/**
 * A class for reading arch-code AST.
 * 
 * @author Templar
 *
 */
public class ArchModel {
	protected static Resource resource = null;
	final private static Injector injector = ArchDSLActivator.getInstance()
			.getInjector(ArchDSLPlugin.getLanguageName());
	public ArchModel(IResource archfile){
		readResoure(archfile);
	}
	public Model getModel(){
		return (Model) resource.getContents().get(0);
	}
	
	private static void readResoure(IResource archfile) {
		XtextResourceSet rs = (XtextResourceSet) injector.getInstance(
				XtextResourceSetProvider.class).get(archfile.getProject());
		rs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

		resource = rs.getResource(URI.createPlatformResourceURI(
				archfile.getFullPath().toString(), true), true);
		
	}
	
}
