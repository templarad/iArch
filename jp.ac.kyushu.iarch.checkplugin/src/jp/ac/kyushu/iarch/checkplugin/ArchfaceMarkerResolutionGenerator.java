package jp.ac.kyushu.iarch.checkplugin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jp.ac.kyushu.iarch.checkplugin.handler.DeleteJavaCode;
import jp.ac.kyushu.iarch.checkplugin.handler.InsertJavaCode;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator;

public class ArchfaceMarkerResolutionGenerator implements
		IMarkerResolutionGenerator {

	private String Path;
	private String Insertcode;
	private String MethordName;

//	public ArchfaceMarkerResolutionGenerator(String Path,String MethordName) {
//		// TODO Auto-generated constructor stub
//	this.Path=Path;
//	this.MethordName=MethordName;
//	}

	@Override
	public IMarkerResolution[] getResolutions(IMarker marker) {
		// TODO Auto-generated method stub
	IMarkerResolution resoulution = new IMarkerResolution() {

		@Override
		public void run(IMarker marker) {
			// TODO Auto-generated method stub
			InsertJavaCode ijc=new InsertJavaCode();
			try {
				String Message=(String) marker.getAttribute(IMarker.MESSAGE);
				String Path=(String) marker.getAttribute(IMarker.LOCATION);
				System.out.println(Message);
				Message= Message.trim();

				Pattern pattern1 = Pattern.compile("(Behavior)\\s*:\\s*([A-Za-z]*)\\s*:\\s*([A-Za-z]*).([A-Za-z]*)\\s*:\\s*([A-zA-Z_0-9]*)\\s*is not defined");
				Pattern pattern2 = Pattern.compile("(Interface-)\\s*([A-Za-z]*)\\s*:\\s*([A-zA-Z_0-9]*)\\s*is not defined");

				Matcher matcher1 = pattern1.matcher(Message);
				Matcher matcher2 = pattern2.matcher(Message);


					  while(matcher1.find()){

				//	  String  Message1 = matcher1.group(3).toString();
				//	  Path="C:/Users/Liyuning/Desktop/iArch/ObserverPattern/src/"+Path+".java";
					  MethordName = matcher1.group(4).toString();
					  Insertcode = matcher1.group(5).toString();
					  ijc.insert(Path,MethordName,Insertcode);
				  }


					 while(matcher2.find()){
					//	 Path="C:/Users/Liyuning/Desktop/iArch/ObserverPattern/src/"+Path+".java";
						  MethordName = matcher2.group(3).toString();
						  System.out.println(MethordName);
						  ijc.insert2(Path,MethordName);
					  }


			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}

		@Override
		public String getLabel() {
			// TODO Auto-generated method stub
			return "Fix Archface Error by Inserting ";
		}
	};

	IMarkerResolution resolution2 = new IMarkerResolution() {

		@Override
		public void run(IMarker marker) {
			// TODO Auto-generated method stub

			DeleteJavaCode djc=new DeleteJavaCode();

			try {
				String Message=(String) marker.getAttribute(IMarker.MESSAGE);
				String Path=(String) marker.getAttribute(IMarker.LOCATION);
				 System.out.println(Path);
				Message= Message.trim();
				Pattern pattern = Pattern.compile("(JavaCode-)\\s*([A-Za-z]*)\\s*:\\s*([A-zA-Z_0-9]*)\\s*is not in the Archface");
				Matcher matcher = pattern.matcher(Message);
					while(matcher.find()){

					  MethordName = matcher.group(3).toString();
					  djc.delete(Path, MethordName);
				  }




			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



		}

		@Override
		public String getLabel() {
			// TODO Auto-generated method stub
			return "Fix Archface Warning by deleting";
		}
	};
//	return new IMarkerResolution[]{resoulution};
		return new IMarkerResolution[]{resoulution,resolution2};
	}

}
