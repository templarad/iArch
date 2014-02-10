package jp.ac.kyushu.iarch.checkplugin;

import java.util.ArrayList;

import jp.ac.kyushu.iarch.checkplugin.handler.ArchfaceChecker;
import jp.ac.kyushu.iarch.checkplugin.handler.CheckerWorkSpaceJob;
import jp.ac.kyushu.iarch.checkplugin.handler.ClassDiagramChecker;
import jp.ac.kyushu.iarch.checkplugin.handler.ProblemViewManager;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.internal.Workbench;
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

				final ArrayList<IProject> changed = new ArrayList<IProject>();
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
							String ext = resource.getFileExtension();
							final IProject proj = delta.getResource().getProject();

							if(ext.equals("class") )
								return true;
							else{
								changed.add(proj);								
							}
		   					//return true;
		               }
		               return true;
		            }
		         };//
				try {
					rootDelta.accept(visitor);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(changed.size()>0)
				{
					new CheckerWorkSpaceJob("Check", changed.get(0)).schedule();
				}
				//ProblemViewManager.removeAllProblems(proj);
				
				
			}//@Override public void resourceChanged
		});
		
	}
	
	public IProject getProject(){
		ISelectionService selectionService =     
	            Workbench.getInstance().getActiveWorkbenchWindow().getSelectionService();
		ISelection selection = selectionService.getSelection();   
		IProject project = null;
		
        if(selection instanceof IStructuredSelection) {    
            Object element = ((IStructuredSelection)selection).getFirstElement();    

            if (element instanceof IResource) {    
                project= ((IResource)element).getProject();    
            }else if (element instanceof IJavaElement) {    
                IJavaProject jProject= ((IJavaElement)element).getJavaProject();    
                project = jProject.getProject();    
            }    
        }
        return project; 
	}

}