package jp.ac.kyushu.iarch.classdiagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import umlClass.UmlClassFactory;
 
public class CreateClassFeature extends AbstractCreateFeature {
 
    private static final String TITLE = "Create class";
 
    private static final String USER_QUESTION = "Enter new class name";
 
    public CreateClassFeature(IFeatureProvider fp) {
        // set name and description of the creation feature
        super(fp, "Class", "Create Class");
    }
 
    public boolean canCreate(ICreateContext context) {
        return context.getTargetContainer() instanceof Diagram;
    }
 
    public Object[] create(ICreateContext context) {
    	// create new Class
        umlClass.Class newClass = UmlClassFactory.eINSTANCE.createClass();
        newClass.setArchpoint(true);
        // Add model element to resource.
        // We add the model element to the resource of the diagram for
        // simplicity's sake. Normally, a customer would use its own
        // model persistence layer for storing the business model separately.
        getDiagram().eResource().getContents().add(newClass);
     
        // do the add
        addGraphicalRepresentation(context, newClass);
     
        // activate direct editing after object creation
        getFeatureProvider().getDirectEditingInfo().setActive(true);
     
        // return newly created business object(s)
        return new Object[] { newClass };
    }
}