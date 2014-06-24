package jp.ac.kyushu.iarch.checkplugin.model;

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

public class ArchfaceModel {
	final private static Injector injector = ArchDSLActivator.getInstance()
			.getInjector(ArchDSLPlugin.getLanguageName());
	
	public static Model getArchfaceModel(IResource archifile) {
		XtextResourceSet rs = (XtextResourceSet) injector.getInstance(
				XtextResourceSetProvider.class).get(archifile.getProject());
		rs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

		Resource resource = rs.getResource(URI.createPlatformResourceURI(
				archifile.getFullPath().toString(), true), true);
		return (Model) resource.getContents().get(0);
	}
}
