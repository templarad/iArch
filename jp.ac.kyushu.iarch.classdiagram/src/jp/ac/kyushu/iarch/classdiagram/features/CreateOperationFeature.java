package jp.ac.kyushu.iarch.classdiagram.features;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;

import umlClass.DataType;
import umlClass.Operation;
import umlClass.UmlClassFactory;
 
public class CreateOperationFeature extends AbstractCreateFeature {
 
    private static final String TITLE = "Create Operation";
 
    private static final String USER_QUESTION = "Enter new Operation name";
 
    public CreateOperationFeature(IFeatureProvider fp) {
        // set name and description of the creation feature
        super(fp, "Operation", "Create Operation");
    }
 
    public boolean canCreate(ICreateContext context) {
    	ContainerShape shape = context.getTargetContainer();
    	Object bo=getBusinessObjectForPictogramElement(shape);
    	if(bo instanceof umlClass.Class){
    		return true;
    	}
    	return false;
    }
 
    public Object[] create(ICreateContext context) {
        // ask user for Operation name
        String newOperationName = ExampleUtil.askString(TITLE, USER_QUESTION, "");
        if (newOperationName == null || newOperationName.trim().length() == 0) {
            return EMPTY;
        }
        
        // create Operation
        Operation newOperation = UmlClassFactory.eINSTANCE.createOperation();
        DataType newdatatype = UmlClassFactory.eINSTANCE.createDataType();
        
        newOperation.setArchpoint(true);
        
        //This should be executed first
        getDiagram().eResource().getContents().add(newdatatype);
        
        
        // Add model element to resource.
        // We add the model element to the resource of the diagram for
        // simplicity's sake. Normally, a customer would use its own
        // model persistence layer for storing the business model separately.
        
        newdatatype.setName("void");
        
        //newdatatype.getOwnedOperation().add(newOperation);
        
        newOperation.setName(newOperationName);
        newOperation.setDatatype(newdatatype);
        DataType datetype = newOperation.getDatatype();
        System.out.println(datetype.getName()+"...operation name:"+datetype.getOwnedOperation().get(0).getName());
        Object bo=getBusinessObjectForPictogramElement(context.getTargetContainer());
        if(bo instanceof umlClass.Class){
        	((umlClass.Class) bo).getOwnedOperation().add(newOperation);
        }
        //context.getTargetContainer().eContents().add(newAttribute);
        //getDiagram().eResource().getContents().add(newOperation);
        
        
        // do the add
        addGraphicalRepresentation(context, newOperation);
        updatePictogramElement(context.getTargetContainer());
        // return newly created business object(s)
        return new Object[] { newOperation };
    }
}