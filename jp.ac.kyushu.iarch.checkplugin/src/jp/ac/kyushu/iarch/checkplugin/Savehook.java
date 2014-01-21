package jp.ac.kyushu.iarch.checkplugin;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
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
				IResourceDelta rootDelta = event.getDelta();
				IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {
		            public boolean visit(IResourceDelta delta) {
		               //only interested in changed resources (not added or removed)
		               if (delta.getKind() != IResourceDelta.CHANGED)
		                  return true;
		               //only interested in content changes
		               if ((delta.getFlags() & IResourceDelta.CONTENT) == 0)
		                  return true;
		               IResource resource = delta.getResource();
		               //only interested in files changes
		               if (resource.getType() == IResource.FILE ) {
		            	   System.out.println(resource.getName()+" is changed.");
		            	   //TODO check
		            	   return true;
		               }
		               return false;
		            }
		         };//
				try {
					rootDelta.accept(visitor);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}
		});
		
	}
}
