package jp.ac.kyushu.iarch.checkplugin.handler;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Display;

/**
 * Create a new job to check after project saving.
 */
public class CheckerWorkSpaceJob extends Job {
	IProject proj = null;
	public CheckerWorkSpaceJob(String firstName, IProject project) {
		super(firstName);
		this.proj = project;
	}
	
	//A new job to do the check
	protected IStatus run(IProgressMonitor monitor) {
		if(proj==null){
			System.out.println("Project is null: Auto-check");
			return Status.CANCEL_STATUS;
		}
		ProblemViewManager.removeAllProblems(proj);
		ArchfaceChecker archfaceChecker = ArchfaceChecker.getInstance(proj);
		archfaceChecker.checkProject();
		
		Display.getDefault().asyncExec(new Runnable() {
		      @Override
		      public void run() {
		    	  ARHander arhander = new ARHander();
		    	  arhander.checkAR(ArchfaceChecker.getArchfileResource(), ArchfaceChecker.getARXMLResource());
		      }
		    });
		
		//monitor.done();
		return Status.OK_STATUS;
	}
}
