package jp.ac.kyushu.iarch.classdiagram.features;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jp.ac.kyushu.iarch.basefunction.controller.ArchModelController;
import jp.ac.kyushu.iarch.basefunction.reader.ProjectReader;
import jp.ac.kyushu.iarch.basefunction.reader.XMLreader;

import org.eclipse.core.resources.IProject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RefactoringRemoveClass extends AbstractCustomFeature{

	private static final Logger logger = LoggerFactory.getLogger(RefactoringRemoveClass.class);
	
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
		IProject project = ProjectReader.getProject();
		XMLreader xx= new XMLreader(project);
		ArchModelController archmodel = new ArchModelController(xx.getArchfileResource());
		List<String> removeClasses = new ArrayList<String>(); 
		PictogramElement[] pes = context.getPictogramElements();
		for(PictogramElement pe : pes){
			Object bo = getBusinessObjectForPictogramElement(pe);
			umlClass.Class umlClass = (umlClass.Class) bo;
			String removeClassName = umlClass.getName();
			removeClasses.add(removeClassName);
		}
		Iterator<String> classIt = removeClasses.iterator();
		while(classIt.hasNext()){
			String removeClassName = classIt.next();
			archmodel.removeClass(removeClassName);
		}
		logger.debug("Remove class num = {}", removeClasses.size());
	}

}
