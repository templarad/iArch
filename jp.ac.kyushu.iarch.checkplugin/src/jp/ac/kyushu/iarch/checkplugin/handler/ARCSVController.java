package jp.ac.kyushu.iarch.checkplugin.handler;


import org.eclipse.core.resources.IProject;

public class ARCSVController {
	private String csvFilePath;
	private IProject project;
	public ARCSVController(IProject project){
		this.project=project;
	}
	public void writeRatio(double ratio){
		if(csvFilePath.isEmpty() || csvFilePath == null){
			csvFilePath=getDefaultPath(project);
		}
	}
	
	public String getDefaultPath(IProject project){
		String projectPath = project.getProject().getLocation().toOSString();
		return projectPath + "/absRatio.csv";
	}
	
	/**
	 * @return the csvFilePath
	 */
	public String getCsvFilePath() {
		return csvFilePath;
	}

	/**
	 * @param csvFilePath the csvFilePath to set
	 */
	public void setCsvFilePath(String csvFilePath) {
		this.csvFilePath = csvFilePath;
	}

	/**
	 * Save abstraction ratio to CSV file.
	 * <p>
	 * CSV file is decided by another class<br>
	 * You can change CSV file by modify class AbstractionRatioCSVController
	 * </p>
	 * 
	 * @param ar AbstractionRatio
	 */
	private void saveARToCSV(){
		//writeRatio();
		
	}
}
