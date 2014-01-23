package jp.ac.kyushu.iarch.checkplugin.handler;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

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
			System.out.println("null");
			return Status.CANCEL_STATUS;
		}
		ArchfaceChecker archfaceChecker = new ArchfaceChecker(proj);
		archfaceChecker.checkProject();
		monitor.done();
		return Status.OK_STATUS;
	}
}
