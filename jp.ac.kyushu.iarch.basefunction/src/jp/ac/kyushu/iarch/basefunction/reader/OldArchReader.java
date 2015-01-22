package jp.ac.kyushu.iarch.basefunction.reader;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

public class OldArchReader{

	private static OldArchReader config = new OldArchReader();
	
	private OldArchReader() {
		
	}

	public static OldArchReader getInstance(){
		return config;
	}
	
	public IResource getOldArchResouce(IProject project){
		String oldArchPath = project.getProject().getLocation().toOSString()+"/arch.old";
		IPath path = new Path(oldArchPath);
		IResource re = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
		return re;

		
	}
}
