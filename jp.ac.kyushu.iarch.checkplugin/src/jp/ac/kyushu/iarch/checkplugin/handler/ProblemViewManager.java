package jp.ac.kyushu.iarch.checkplugin.handler;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

public class ProblemViewManager {
	private static ProblemViewManager problemviewmanager = new ProblemViewManager();


	private ProblemViewManager(){
		//Singleton
	}
	public static ProblemViewManager getInstance(){
		return problemviewmanager;
	}

	public static void removeAllProblems(IProject project){
		try {
			project.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);

		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public static void addError(IResource resource, String message, String location) {
		try {
			IMarker marker = resource.createMarker(IMarker.PROBLEM);
			marker.setAttribute(IMarker.MESSAGE, message);
			marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
			marker.setAttribute(IMarker.LOCATION, location);
			marker.setAttribute(IMarker.LINE_NUMBER,11);
		} catch (CoreException ce) {
			ce.printStackTrace();
		}
	}
	public static void addError1(IResource resource, String message, String location,int lineNumber) {
		try {
			IMarker marker = resource.createMarker(IMarker.PROBLEM);
			marker.setAttribute(IMarker.MESSAGE, message);
			marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
			marker.setAttribute(IMarker.LOCATION, location);
			marker.setAttribute(IMarker.LINE_NUMBER,lineNumber);
		} catch (CoreException ce) {
			ce.printStackTrace();
		}
	}

	public static void addInfo(IResource resource, String message, String location) {
		try {
			IMarker marker = resource.createMarker(IMarker.PROBLEM);
			marker.setAttribute(IMarker.MESSAGE, message);
			marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
			marker.setAttribute(IMarker.LOCATION, location);
		} catch (CoreException ce) {
			ce.printStackTrace();
		}
	}
	public static void addInfo1(IResource resource, String message, String location ,int lineNumber ) {
		try {
			IMarker marker = resource.createMarker(IMarker.PROBLEM);
			marker.setAttribute(IMarker.MESSAGE, message);
			marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
			marker.setAttribute(IMarker.LOCATION, location);
			marker.setAttribute(IMarker.LINE_NUMBER,lineNumber);
		} catch (CoreException ce) {
			ce.printStackTrace();
		}
	}
}
