package jp.ac.kyushu.iarch.checkplugin.utils;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.ui.handlers.HandlerUtil;

@SuppressWarnings("restriction")
public class ProjectSelectionUtils {
	public static IProject getProject(ExecutionEvent event, String message){
		IProject project;
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (!(selection instanceof IStructuredSelection)) {
			MessageDialog.open(MessageDialog.WARNING,
					HandlerUtil.getActiveShell(event), message,
					"Please Select Project.", SWT.None);
			return null;
		}
		IStructuredSelection stSelection = (IStructuredSelection) selection;
		Object projectElement = stSelection.getFirstElement();
		if (projectElement instanceof IProject) {
			project = (IProject)projectElement;
		}else if(projectElement instanceof JavaProject){
			project = ((JavaProject)stSelection.getFirstElement()).getProject();
		}else{
			MessageDialog.open(MessageDialog.WARNING,
					HandlerUtil.getActiveShell(event), message,
					"Please Select Project.", SWT.None);
			return null;
		}

		return project;		
	}
}
