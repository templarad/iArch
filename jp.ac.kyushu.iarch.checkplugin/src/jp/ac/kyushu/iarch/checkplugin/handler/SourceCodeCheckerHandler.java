package jp.ac.kyushu.iarch.checkplugin.handler;

import java.util.List;

import jp.ac.kyushu.iarch.checkplugin.model.ComponentClassPairModel;
import jp.ac.kyushu.iarch.checkplugin.view.SourceCodeCheckViewPart;

import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class SourceCodeCheckerHandler {
	public void showArchface(List<ComponentClassPairModel> classPairs) {
		SourceCodeCheckViewPart archfaceView = null;
		IWorkbenchWindow[] views = PlatformUI.getWorkbench()
				.getWorkbenchWindows();
		for (IViewReference view : views[0].getActivePage().getViewReferences()) {
			if (view.getId().equals(SourceCodeCheckViewPart.ID)) {
				archfaceView = (SourceCodeCheckViewPart) view.getView(true);

			}
		}
		if (archfaceView == null) { // if view not open.
			try {
				archfaceView = (SourceCodeCheckViewPart) PlatformUI
						.getWorkbench().getActiveWorkbenchWindow()
						.getActivePage().showView(SourceCodeCheckViewPart.ID);
			} catch (PartInitException pie) {
				pie.printStackTrace();
				return;
			}
		}
		archfaceView.setClassPairs(classPairs);
	}

}
