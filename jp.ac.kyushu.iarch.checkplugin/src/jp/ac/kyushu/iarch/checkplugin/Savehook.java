package jp.ac.kyushu.iarch.checkplugin;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Savehook extends AbstractUIPlugin implements IStartup {
	public void start(BundleContext context) throws Exception {
	
	}
	public void earlyStartup(){
		ResourcesPlugin.getWorkspace().addResourceChangeListener(new IResourceChangeListener(){
			@Override
			public void resourceChanged(IResourceChangeEvent event) {
				System.out.println("file changed:"+event.getDelta());
			}
		});
	}
}
