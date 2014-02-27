package jp.ac.kyushu.iarch.checkplugin.handler;

import java.util.List;

import jp.ac.kyushu.iarch.archdsl.ArchDSLPlugin;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.archdsl.ui.internal.ArchDSLActivator;
import jp.ac.kyushu.iarch.checkplugin.utils.ProjectSelectionUtils;
import jp.ac.kyushu.iarch.checkplugin.view.SelectAllFileDialog;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import com.google.inject.Injector;

public class CheckArchfaceHandler implements IHandler {
	final private static Injector injector = ArchDSLActivator.getInstance()
			.getInjector(ArchDSLPlugin.getLanguageName());

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// create dialog & items
		IProject project = ProjectSelectionUtils.getProject(event, "Check Archiface");

		SelectAllFileDialog dialog = new SelectAllFileDialog(
				HandlerUtil.getActiveShell(event), project);
		if (dialog.open() == MessageDialog.OK) {
			// clear problems
			ProblemViewManager.removeAllProblems(project);
			
			// check archiface
//			mergeDiagrams(dialog.getClassDiagram(), dialog.getSequenceDiagrams());
			checkArchifaceValidation(dialog.getArchiface(),
					dialog.getClassDiagram(), dialog.getSequenceDiagrams());
		}

		return null;
	}

/*
	private void mergeDiagrams(IResource clazz, List<IResource> sequences) {
		Resource classModel = GraphitiModelManager.getGraphitiModel(clazz);
		for (EObject obj : classModel.getContents()) {
			System.out.println("class obj :" + obj);
		}

		for (IResource seqRes : sequences) {
			Resource seqModel = GraphitiModelManager.getGraphitiModel(seqRes);
			for (EObject obj : seqModel.getContents()) {
				System.out.println("seq obj :" + obj);
			}
		}
	}
*/
	private void checkArchifaceValidation(IResource archifile,
			IResource classDiagramResource,
			List<IResource> sequenceDiagramResources) {
		Model archiface = getArchifaceModel(archifile);
		ClassDiagramChecker classDiagramChecker = new ClassDiagramChecker();
		classDiagramChecker.checkClassDiagram(archiface, classDiagramResource);
		
		SequenceDiagramChecker sequenceDiagramChecker = new SequenceDiagramChecker();
		for(IResource sequenceDiagramResource : sequenceDiagramResources){
			sequenceDiagramChecker.checkSequenceDiagram(archiface, sequenceDiagramResource);					
		}
	}
	
	private Model getArchifaceModel(IResource archifile) {
		XtextResourceSet rs = (XtextResourceSet) injector.getInstance(
				XtextResourceSetProvider.class).get(archifile.getProject());
		rs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

		Resource resource = rs.getResource(URI.createPlatformResourceURI(
				archifile.getFullPath().toString(), true), true);
		return (Model) resource.getContents().get(0);
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
	}
}
