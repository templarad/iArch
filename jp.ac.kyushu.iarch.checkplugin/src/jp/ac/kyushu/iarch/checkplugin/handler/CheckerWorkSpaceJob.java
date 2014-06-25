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
	private static IProject proj;
	private static String Name = "Archface Auto-check";
	private static CheckerWorkSpaceJob cwsJob = new CheckerWorkSpaceJob();
	public CheckerWorkSpaceJob() {
		super(Name);

	}
	public static CheckerWorkSpaceJob getInstance(IProject project){
		proj = project;
		return cwsJob;
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
		    	  AbstractionRatioController arhander = new AbstractionRatioController();
		    	  arhander.checkAR(ArchfaceChecker.getArchfileResource(), ArchfaceChecker.getARXMLResource());
		      }
		    });
		
		monitor.done();
		return Status.OK_STATUS;
	}
}
