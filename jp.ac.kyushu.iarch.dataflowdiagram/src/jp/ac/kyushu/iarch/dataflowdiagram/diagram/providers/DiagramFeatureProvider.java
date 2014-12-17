package jp.ac.kyushu.iarch.dataflowdiagram.diagram.providers;

import jp.ac.kyushu.iarch.dataflowdiagram.features.DirectEditDataflowFeature;
import jp.ac.kyushu.iarch.dataflowdiagram.features.DirectEditDatastoreFeature;
import jp.ac.kyushu.iarch.dataflowdiagram.features.DirectEditExternal_entityFeature;
import jp.ac.kyushu.iarch.dataflowdiagram.features.DirectEditProcessFeature;
import jp.ac.kyushu.iarch.dataflowdiagram.features.RenameDataflowFeature;
import jp.ac.kyushu.iarch.dataflowdiagram.features.AddProcessFeature;
import jp.ac.kyushu.iarch.dataflowdiagram.features.CreateProcessFeature;
import jp.ac.kyushu.iarch.dataflowdiagram.features.AddDatastoreFeature;
import jp.ac.kyushu.iarch.dataflowdiagram.features.CreateDatastoreFeature;
import jp.ac.kyushu.iarch.dataflowdiagram.features.AddExternal_entityFeature;
import jp.ac.kyushu.iarch.dataflowdiagram.features.CreateExternal_entityFeature;
import jp.ac.kyushu.iarch.dataflowdiagram.features.AddDataflowFeature;
import jp.ac.kyushu.iarch.dataflowdiagram.features.CreateDataflowFeature;
import jp.ac.kyushu.iarch.dataflowdiagram.features.UpdateDataflowFeature;
import jp.ac.kyushu.iarch.dataflowdiagram.features.UpdateDatastoreFeature;
import jp.ac.kyushu.iarch.dataflowdiagram.features.UpdateExternal_entityFeature;
import jp.ac.kyushu.iarch.dataflowdiagram.features.UpdateProcessFeature;
/* add new feature!!!!!!*/

import jp.ac.kyushu.iarch.dataflowdiagram.features.RenameDatastoreFeature;
import jp.ac.kyushu.iarch.dataflowdiagram.features.RenameExternal_entityFeature;
import jp.ac.kyushu.iarch.dataflowdiagram.features.RenameProcessFeature;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;


public class DiagramFeatureProvider extends DefaultFeatureProvider {

	public DiagramFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}
	@Override
    public IAddFeature getAddFeature(IAddContext context) {
        // is object for add request a Class?
		// add new element>>>>>>>>
        if (context.getNewObject() instanceof Dataflow_editor.Process) {
            return new AddProcessFeature(this);
            }
        else if (context.getNewObject() instanceof Dataflow_editor.DataStore) {
            return new AddDatastoreFeature(this);
        	}
        else if (context.getNewObject() instanceof Dataflow_editor.External_entity) {
            return new AddExternal_entityFeature(this);
        	}
        else if (context.getNewObject() instanceof Dataflow_editor.DataFlow) {
            return new AddDataflowFeature(this);
        	}
        
        
        return super.getAddFeature(context);
    }
@Override
public ICreateFeature[] getCreateFeatures() {
   return new ICreateFeature[] {                      //!add new element!>>>>>>
		   new CreateProcessFeature(this),
		   new CreateExternal_entityFeature(this),
   		   new CreateDatastoreFeature(this)};
		   /*
		   !add new element!
		   */
	}


@Override
public ICreateConnectionFeature[] getCreateConnectionFeatures() {
   return new ICreateConnectionFeature[] { 
       new CreateDataflowFeature (this) };
	}


@Override
public ICustomFeature[] getCustomFeatures(ICustomContext context) {
    	return new ICustomFeature[] {	
        new RenameProcessFeature(this),
        new RenameDatastoreFeature(this),
        new RenameExternal_entityFeature(this),
    	new RenameDataflowFeature(this)};
    	
	}



@Override
public IUpdateFeature getUpdateFeature(IUpdateContext context) {
   PictogramElement pictogramElement = context.getPictogramElement();
   if (pictogramElement instanceof ContainerShape) {
       Object bo = getBusinessObjectForPictogramElement(pictogramElement);
       if (bo instanceof Dataflow_editor.Process) {
           return new UpdateProcessFeature(this);
       }
       else if (bo instanceof Dataflow_editor.DataStore) {
           return new UpdateDatastoreFeature(this);
       }
       else if (bo instanceof Dataflow_editor.External_entity) {
           return new UpdateExternal_entityFeature(this);
       }
   }
   
   else if(pictogramElement instanceof FreeFormConnection){
	   Object bo = getBusinessObjectForPictogramElement(pictogramElement);
	   if(bo instanceof Dataflow_editor.DataFlow){
		   return new UpdateDataflowFeature(this);
	   }
   }
   else if(pictogramElement instanceof ConnectionDecorator){
   	return new UpdateDataflowFeature(this);
   }
   return super.getUpdateFeature(context);
 }


@Override
public IDirectEditingFeature getDirectEditingFeature(
    IDirectEditingContext context) {
    PictogramElement pe = context.getPictogramElement();
    Object bo = getBusinessObjectForPictogramElement(pe);
    if (bo instanceof Dataflow_editor.DataFlow) {
        return new DirectEditDataflowFeature(this);
    }
    else if(bo instanceof Dataflow_editor.External_entity){
    	return new DirectEditExternal_entityFeature(this);
    }
    else if(bo instanceof Dataflow_editor.DataStore){
    	return new DirectEditDatastoreFeature(this);
    }
    else if(bo instanceof Dataflow_editor.Process){
    	return new DirectEditProcessFeature(this);
    }
    else if(pe instanceof ConnectionDecorator){
        	return new DirectEditDataflowFeature(this);
    }
    
    return super.getDirectEditingFeature(context);
 } 




}

