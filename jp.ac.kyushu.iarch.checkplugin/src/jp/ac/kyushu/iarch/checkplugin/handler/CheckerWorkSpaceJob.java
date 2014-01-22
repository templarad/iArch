package jp.ac.kyushu.iarch.checkplugin.handler;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

public class CheckerWorkSpaceJob extends Job {

	IProject proj = null;
	public CheckerWorkSpaceJob(String firstName, IProject project) {
		super(firstName);
		this.proj = project;
	}
	protected IStatus run(IProgressMonitor monitor) {
		if(proj==null){
			System.out.println("null");
			return Status.CANCEL_STATUS;
		}			
		ArchfaceChecker archfaceChecker = new ArchfaceChecker(proj);
		archfaceChecker.checkProject();
		return Status.OK_STATUS;
	}
}
