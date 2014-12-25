package jp.ac.kyushu.iarch.classdiagram.features;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jp.ac.kyushu.iarch.basefunction.controller.ArchModelController;
import jp.ac.kyushu.iarch.basefunction.reader.ProjectReader;
import jp.ac.kyushu.iarch.basefunction.reader.XMLreader;

import org.eclipse.core.resources.IProject;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**Haven't completed yet:<br>
 * Refactoring pattern : Remove Class
 * @author Templar
 *
 */
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
		logger.info("Refactoring - Start removing class.");
		IProject project = ProjectReader.getProject();
		XMLreader xx= new XMLreader(project);
		ArchModelController archmodel = new ArchModelController(xx.getArchfileResource());
		List<String> removeClasses = new ArrayList<String>();
		List<ContainerShape> classShape = new ArrayList<ContainerShape>();
		PictogramElement[] pes = context.getPictogramElements();
		for(PictogramElement pe : pes){
			Object bo = getBusinessObjectForPictogramElement(pe);
			umlClass.Class umlClass = (umlClass.Class) bo;
			String removeClassName = umlClass.getName();
			removeClasses.add(removeClassName);
			classShape.add((ContainerShape)pe);
		}
		int removedClassSize = removeClasses.size();
		int classShapeSize = classShape.size();
		
		//Remove classes' from Arch code.
		Iterator<String> classIt = removeClasses.iterator();
		while(classIt.hasNext()){
			String removeClassName = classIt.next();
			if(!archmodel.removeClass(removeClassName)){
				logger.debug("Refactoring - Remove class failed - {}", removeClassName);
			}
		}
		logger.debug("Remove classes success. Num = {}", removedClassSize - removeClasses.size());
		
		//Remove classes' container from diagram.
		Iterator<ContainerShape> csIt = classShape.iterator();
		while(csIt.hasNext()){
			ContainerShape shape = csIt.next();
			DeleteContext ctx = new DeleteContext(shape);
			ctx.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 2));
			IDeleteFeature deleteFeature = getFeatureProvider().getDeleteFeature(ctx);
			if (deleteFeature!=null){
				deleteFeature.execute(ctx);
			}
			updatePictogramElement(shape);
		}
		logger.debug("Removed ContainerShapes from diagram. Num = {}", classShapeSize - classShape.size());
        try {
        	getDiagram().eResource().save(null);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Refactoring - Saving diagram failed : {}", getDiagram().getName());
		}
	}

}
