package jp.ac.kyushu.iarch.classdiagram.features;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;

import umlClass.Property;
import umlClass.UmlClassFactory;
 
public class CreateAttributeFeature extends AbstractCreateFeature {
 
    private static final String TITLE = "Create attribute";
 
    private static final String USER_QUESTION = "Enter new Attribute name";
 
    public CreateAttributeFeature(IFeatureProvider fp) {
        // set name and description of the creation feature
        super(fp, "Attribute", "Create Attribute");
    }
 
    public boolean canCreate(ICreateContext context) {
    	ContainerShape shape = context.getTargetContainer();
    	Object bo=getBusinessObjectForPictogramElement(shape);
    	if(bo instanceof umlClass.Class){//if(!(shape instanceof Diagram))
    		return true;
    	}
    	return false;
        //return context.getTargetContainer() instanceof umlClass.Class;
    }
 
    public Object[] create(ICreateContext context) {
        // ask user for Attribute name
        String newAttributeName = ExampleUtil.askString(TITLE, USER_QUESTION, "");
        if (newAttributeName == null || newAttributeName.trim().length() == 0) {
            return EMPTY;
        }
        
        // create Attribute
        Property newAttribute = UmlClassFactory.eINSTANCE.createProperty();
        // Add model element to resource.
        // We add the model element to the resource of the diagram for
        // simplicity's sake. Normally, a customer would use its own
        // model persistence layer for storing the business model separately.
        newAttribute.setArchpoint(true);
        newAttribute.setName(newAttributeName);
        Object bo=getBusinessObjectForPictogramElement(context.getTargetContainer());
        if(bo instanceof umlClass.Class){
        	((umlClass.Class) getBusinessObjectForPictogramElement(context.getTargetContainer())).getAttribute().add(newAttribute);
        }
//        context.getTargetContainer().eContents().add(newAttribute);
        getDiagram().eResource().getContents().add(newAttribute);
               
 
        // do the add
        addGraphicalRepresentation(context, newAttribute);
        updatePictogramElement(context.getTargetContainer());
        // return newly created business object(s)
        return new Object[] { newAttribute };
    }
}