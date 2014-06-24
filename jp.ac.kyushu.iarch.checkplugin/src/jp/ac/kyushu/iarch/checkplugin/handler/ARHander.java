package jp.ac.kyushu.iarch.checkplugin.handler;


import jp.ac.kyushu.iarch.checkplugin.model.AbstractionRatio;
import jp.ac.kyushu.iarch.checkplugin.view.AbstractionRatioViewPart;




import org.eclipse.core.resources.IResource;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class ARHander {
	
	public void checkAR(IResource archfile,IResource xml){
		AbstractionRatioChecker abstractionRatioChecker = new AbstractionRatioChecker();
		
		abstractionRatioChecker.execute(archfile, xml);		
		showAbstractionRatio(abstractionRatioChecker);
		saveAbstractionRatioToCSV(abstractionRatioChecker);
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
	private void showAbstractionRatio(AbstractionRatioChecker checker){
		AbstractionRatioViewPart abstractionRatioView = null;
		IWorkbenchWindow[] views = PlatformUI.getWorkbench().getWorkbenchWindows();
		//for(IViewReference view :PlatformUI.getWorkbench().getActiveWorkbenchWindows().getActivePage().getViewReferences()){
		for(IViewReference view :views[0].getActivePage().getViewReferences()){
			if(view.getId().equals(AbstractionRatioViewPart.ID)){
				abstractionRatioView = (AbstractionRatioViewPart)view.getView(true);
				
			}
		}
		if(abstractionRatioView==null){ // if view not open.
			try{
				abstractionRatioView = (AbstractionRatioViewPart)PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage()
						.showView(AbstractionRatioViewPart.ID);
			}catch(PartInitException pie){
				pie.printStackTrace();
				return;
			}
		}
		
		abstractionRatioView.setRatio(checker.getAbstractionRatio());
		abstractionRatioView.setArchAndImpl(checker.getArchpointNum(), checker.getXmlpointNum());
		abstractionRatioView.setStructureRatio(1-(double)(checker.getClassNum()+checker.getMethodNum())
				/(double)(checker.getXmlClassNum()+checker.getXmlMethodNum()));
		abstractionRatioView.setStructureArchAndImpl(checker.getXmlClassNum()+checker.getMethodNum() ,
				checker.getXmlClassNum()+checker.getXmlMethodNum());
		abstractionRatioView.setBehaviorRatio(1-(double)checker.getBehaviorNum() 
				/ (double)checker.getXmlInvocationPointNum());
		abstractionRatioView.setBehaviorArchAndImpl(checker.getBehaviorNum(),
				checker.getXmlInvocationPointNum());
	}
	
	/**
	 * Save Abstraction ratio to CSV file.
	 * <p>
	 * CSV file is decided by another class<br>
	 * You can change CSV file by modify class ...
	 * </p>
	 * 
	 * @param ar AbstractionRatio
	 */
	private void saveAbstractionRatioToCSV(AbstractionRatio ar){
		ar.getAbstractionRatio();
	}
}
