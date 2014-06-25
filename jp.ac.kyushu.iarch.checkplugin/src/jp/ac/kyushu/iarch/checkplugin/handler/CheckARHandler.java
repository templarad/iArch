package jp.ac.kyushu.iarch.checkplugin.handler;


import jp.ac.kyushu.iarch.checkplugin.utils.ProjectSelectionUtils;
import jp.ac.kyushu.iarch.checkplugin.view.SelectDiagramsDialogAR;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IProject;

import org.eclipse.jface.dialogs.MessageDialog;

import org.eclipse.ui.handlers.HandlerUtil;


public class CheckARHandler implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IProject project = ProjectSelectionUtils.getProject(event, "Check Abstraction Ratio");
		if(project == null){ return null;}
		
		SelectDiagramsDialogAR dialog = new SelectDiagramsDialogAR(
				HandlerUtil.getActiveShell(event), project);
		if (dialog.open() == MessageDialog.OK) {
			// clear problems
			ProblemViewManager.removeAllProblems(project);
			
			AbstractionRatioController arcontroller = new AbstractionRatioController();
			
			arcontroller.checkAR(dialog.getArchiface(), dialog.getXml());

			
		}

		return null;
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
