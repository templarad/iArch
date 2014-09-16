package jp.ac.kyushu.iarch.classdiagram.features;

import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.basefunction.reader.*;
import jp.ac.kyushu.iarch.classdiagram.diagram.ProjectReader;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Display;

public class RenameClassRefactoringJob extends Job {
	
	private static String NEWName;
	private static String CURRENTName;
	private static String Name = "Rename Class Refactoring";
	private static RenameClassRefactoringJob rcrJob = new RenameClassRefactoringJob();
	public RenameClassRefactoringJob() {
		super(Name);

	}
	public static RenameClassRefactoringJob getInstance(String currentName, String newName ){
		CURRENTName = currentName;
		NEWName = newName;
		return rcrJob;
	}
	//A new job to do the check
	protected IStatus run(IProgressMonitor monitor) {
		if(NEWName == null){
			System.out.println("New name : null");
			return Status.CANCEL_STATUS;
		}
		
		
		
		
		
		Display.getDefault().asyncExec(new Runnable() {
		     
			@Override
		      public void run() {
		    	  IProject project = ProjectReader.getProject();
                  String aa= "/"+project.getProject().getName()+"/arch/observer.arch";
                  
                  System.out.println(aa);
                  IPath path = new Path(aa);
		    	  IResource archfile = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
		    	  XMLreader xx= new XMLreader(project);
		    	  Model archmodel = ArchModel.getArchfaceModel(archfile);
		    	  int i=0;
                  for(Interface interfc :archmodel.getInterfaces()){
                  	
                  	if(interfc.getName()==CURRENTName){
                  		archmodel.getInterfaces().get(i).setName(NEWName);;
                  		break;
                  	}
                  	i++;
                  }
		      }
		    });
		
		monitor.done();
		return Status.OK_STATUS;
	}
	
}
