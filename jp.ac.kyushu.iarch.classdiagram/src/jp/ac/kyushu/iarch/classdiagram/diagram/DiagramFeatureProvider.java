package jp.ac.kyushu.iarch.classdiagram.diagram;

import jp.ac.kyushu.iarch.classdiagram.features.*;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import umlClass.Association;
import umlClass.Operation;
import umlClass.Property;

public class DiagramFeatureProvider extends DefaultFeatureProvider {
	 
    public DiagramFeatureProvider(IDiagramTypeProvider dtp) {
        super(dtp);
    }
    @Override
    public IAddFeature getAddFeature(IAddContext context) {
        // is object for add request a Class?
        if (context.getNewObject() instanceof umlClass.Class) {
            return new AddClassFeature(this);
        }
        else if (context.getNewObject() instanceof Association) {
            return new AddAssociationFeature(this);
        }
        else if (context.getNewObject() instanceof Property){
        	return new AddAttributeFeature(this);
        }
        else if (context.getNewObject() instanceof Operation){
        	return new AddOperationFeature(this);
        }
        return super.getAddFeature(context);
    }
    @Override
    public ICreateFeature[] getCreateFeatures() {
       return new ICreateFeature[] { 
    		   new CreateClassFeature(this) ,
    		   new CreateAttributeFeature(this),
    		   new CreateOperationFeature(this)};
    }
    @Override
    public ICreateConnectionFeature[] getCreateConnectionFeatures() {
       return new ICreateConnectionFeature[] { 
           new CreateAssociationFeature (this) };
    }
    @Override
    public IUpdateFeature getUpdateFeature(IUpdateContext context) {
       PictogramElement pictogramElement = context.getPictogramElement();
       Object bo = getBusinessObjectForPictogramElement(pictogramElement);
       if (pictogramElement instanceof ContainerShape) {
           
           if (bo instanceof umlClass.Class) {
               return new UpdateClassFeature(this);
           }
       }
       else if(pictogramElement instanceof FreeFormConnection){

    	   if(bo instanceof Association){
    		   return new UpdateAssociationFeature(this);
    	   }
       }
       else if(pictogramElement instanceof ConnectionDecorator){
    	   return new UpdateAssociationFeature(this);
       }
       else if(pictogramElement instanceof Shape){
    	   if(bo instanceof Property||bo instanceof umlClass.Operation){
    		   return new UpdateAttributeFeature(this);
    	   }
       }
       return super.getUpdateFeature(context);
     }  
    @Override
    public IResizeShapeFeature getResizeShapeFeature(
            IResizeShapeContext context) {
        Shape shape = context.getShape();
        Object bo = getBusinessObjectForPictogramElement(shape);
        if (bo instanceof umlClass.Class) {
            return new ResizeClassFeature(this);
        }
        return super.getResizeShapeFeature(context);
     }
    @Override
    public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
        Shape shape = context.getShape();
        Object bo = getBusinessObjectForPictogramElement(shape);
        if (bo instanceof Property) {
            return new MoveAttributeFeature(this);
        }
        else if (bo instanceof Operation) {
            return new MoveOperationFeature(this);
        }
        return super.getMoveShapeFeature(context);
     } 
    
    @Override
    public ILayoutFeature getLayoutFeature(ILayoutContext context) {
        PictogramElement pictogramElement = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof umlClass.Class) {
            return new LayoutClassFeature(this);
        }
        return super.getLayoutFeature(context);
    }
    @Override
    public ICustomFeature[] getCustomFeatures(ICustomContext context) {
        	return new ICustomFeature[] {	new RenameClassFeature(this),
        									new RenameAssociationFeature(this),
        									new RenameAttributeFeature(this),
        									new RenameOperationFeature(this),
        									new RefactorRemoveMethodFeature(this),
        									new GenerateClassDiagramFeature(this)};
    } 
    @Override
    public IDirectEditingFeature getDirectEditingFeature(
        IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pe);
        if (bo instanceof umlClass.Class) {
            return new DirectEditClassFeature(this);
        }else if(bo instanceof Association){
        	return new DirectEditAssociationFeature(this);
        }
        else if(pe instanceof ConnectionDecorator){
        	return new DirectEditAssociationFeature(this);
        }
        else if(bo instanceof Property){
        	return new DirectEditAttributeFeature(this);
        }
        else if(bo instanceof Operation){
        	return new DirectEditOperationFeature(this);
        }
        return super.getDirectEditingFeature(context);
     } 
} 