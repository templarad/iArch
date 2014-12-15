package jp.ac.kyushu.iarch.classdiagram.features;

import org.apache.log4j.Logger;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class RefactoringRemoveClass extends AbstractCustomFeature{

	private static final Logger logger = Logger.getLogger(RefactoringRemoveClass.class);
	
	public RefactoringRemoveClass(IFeatureProvider fp) {
		super(fp);
	}
	@Override
    public String getName() {
        return "Refactoring Remove Class";
    }
 
    @Override
    public String getDescription() {
        return "Remove the class which you don't want to reflect in the model";
    }
 
    @Override
    public boolean canExecute(ICustomContext context) {
    	// allow rename if exactly one pictogram element
        // representing a Class is selected
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null) {
        	for(PictogramElement pe: pes){
        		Object bo = getBusinessObjectForPictogramElement(pe);
        		if (bo instanceof umlClass.Class) {
                    ret = true;
                } else {
                	return false;
                }
        	}
        }
        return ret;
    }
	@Override
	public void execute(ICustomContext context) {
		logger.debug("Start Refactoring : Remove class.");
		PictogramElement[] pes = context.getPictogramElements();
		for(PictogramElement pe : pes){
			Object bo = getBusinessObjectForPictogramElement(pe);
			umlClass.Class umlClass = (umlClass.Class) bo;
			umlClass.getName();
			logger.debug("Start Refactoring : Remove class.= {}", umlClass.getName());
		}
		
	}

}
