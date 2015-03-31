package jp.ac.kyushu.iarch.checkplugin.handler;



import java.io.*;

import jp.ac.kyushu.iarch.checkplugin.model.AbstractionRatio;
import jp.ac.kyushu.iarch.checkplugin.view.AbstractionRatioViewPart;

import org.eclipse.core.resources.IResource;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
/**
 * Control the function :<br>
 * Count abstraction ratio.
 * Show abstraction ratio in UI.
 * @author Templar
 *
 */
public class AbstractionRatioController {
	
	private String CSVpath = "/absRatioHistory.csv";
	
	public void checkAR(IResource archfile,IResource xml){
		AbstractionRatioChecker absRatioChecker = new AbstractionRatioChecker();
		absRatioChecker.execute(archfile, xml);		
		showAR(absRatioChecker);
		saveARToCSV(absRatioChecker,archfile);
	}	
	
	/**
	 * Show Abstraction ratio in Eclipse UI.
	 * <p>
	 * As is implemented in CheckerWorkSpaceJob<br>
	 * Modify UI from another thread is possible.
	 * </p>
	 * 
	 * @param checker AbstractionRatioChecker 
	 */
	private void showAR(AbstractionRatioChecker checker){
		AbstractionRatioViewPart absRatioView = null;
		IWorkbenchWindow[] views = PlatformUI.getWorkbench().getWorkbenchWindows();
		for(IViewReference view :views[0].getActivePage().getViewReferences()){
			if(view.getId().equals(AbstractionRatioViewPart.ID)){
				absRatioView = (AbstractionRatioViewPart)view.getView(true);
				
			}
		}
		if(absRatioView==null){ // if view not open.
			try{
				absRatioView = (AbstractionRatioViewPart)PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage()
						.showView(AbstractionRatioViewPart.ID);
			}catch(PartInitException pie){
				pie.printStackTrace();
				return;
			}
		}
		
		absRatioView.setRatio(checker.getAbstractionRatio());
		absRatioView.setArchAndImpl(checker.getArchpointNum(), checker.getXmlpointNum());
		absRatioView.setStructureRatio(1-(double)(checker.getClassNum()+checker.getMethodNum())
				/(double)(checker.getXmlClassNum()+checker.getXmlMethodNum()));
		absRatioView.setStructureArchAndImpl(checker.getClassNum()+checker.getMethodNum() ,
				checker.getXmlClassNum()+checker.getXmlMethodNum());
		absRatioView.setBehaviorRatio(1-(double)checker.getBehaviorNum() 
				/ (double)checker.getXmlInvocationPointNum());
		absRatioView.setBehaviorArchAndImpl(checker.getBehaviorNum(),
				checker.getXmlInvocationPointNum());
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
	private void saveARToCSV(AbstractionRatio ar, IResource iresource){
		String CSVPath =iresource.getProject().getLocation().toOSString()+ CSVpath;
		File csv = new File(CSVPath);
		try {			
			BufferedWriter bw = new BufferedWriter(new FileWriter(csv,true));
			bw.write(Double.toString(ar.getAbstractionRatio())+",");
			bw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
