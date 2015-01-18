package jp.ac.kyushu.iarch.dataflowdiagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;

import Dataflow_editor.DataFlow;
import Dataflow_editor.Dataflow_editorFactory;

public class CreateDataflowFeature extends AbstractCreateConnectionFeature {

public CreateDataflowFeature (IFeatureProvider fp) {
 // provide name and description for the UI, e.g. the palate
 super(fp, "Dataflow", "Create Dataflow");
}

public boolean canCreate(ICreateConnectionContext context) {
	// return true if both anchors belong to an Class
	// and those Classes are not identical
	/*From External_entity to External_entity*/
{	
	Dataflow_editor.External_entity source = getExternal_entity(context.getSourceAnchor());
	Dataflow_editor.External_entity target = getExternal_entity(context.getTargetAnchor());
	if (source != null && target != null && source != target) {
    	return true;
	}
}
	/*--------below new adding--------*/
	/*--------add DataStore--------*/
	/*From DataStore -> DataStore*/
{
	Dataflow_editor.DataStore source = getDataStore(context.getSourceAnchor());
	Dataflow_editor.DataStore target = getDataStore(context.getTargetAnchor());	   
	if (source != null && target != null && source != target) {
		    return true;
	}
}

/*From Process -> Process*/
	
{
	Dataflow_editor.Process source = getProcess(context.getSourceAnchor());
	Dataflow_editor.Process target = getProcess(context.getTargetAnchor());
	if (source != null && target != null && source != target) {
	    	return true;
	}
}


/*From Process -> DataStore*/
{
	Dataflow_editor.Process source = getProcess(context.getSourceAnchor());
	Dataflow_editor.DataStore target = getDataStore(context.getTargetAnchor());
	if (source != null && target != null && source != target) {
	    	return true;
	}
}

/*From DataStore -> Process */
{
	Dataflow_editor.DataStore source = getDataStore(context.getSourceAnchor());
	Dataflow_editor.Process target = getProcess(context.getTargetAnchor());
	if (source != null && target != null && source != target) {
	    	return true;
	}
}

/*From Process -> External_entity */
{
	Dataflow_editor.Process source = getProcess(context.getSourceAnchor());
	Dataflow_editor.External_entity target = getExternal_entity(context.getTargetAnchor());
	if (source != null && target != null && source != target) {
	    	return true;
	}
}

/*From External_entity -> Process */
{
	Dataflow_editor.External_entity source = getExternal_entity(context.getSourceAnchor());
	Dataflow_editor.Process target = getProcess(context.getTargetAnchor());
	if (source != null && target != null && source != target) {
	    	return true;
	}
}

/*From External_entity -> DataStore */
{
	Dataflow_editor.External_entity source = getExternal_entity(context.getSourceAnchor());
	Dataflow_editor.DataStore target = getDataStore(context.getTargetAnchor());
	if (source != null && target != null && source != target) {
	    	return true;
	}
}

/*From DataStore -> External_entity */
{
	Dataflow_editor.DataStore source = getDataStore(context.getSourceAnchor());
	Dataflow_editor.External_entity target = getExternal_entity(context.getTargetAnchor());
	if (source != null && target != null && source != target) {
	    	return true;
	}
}
	
	
	return false;
}


public boolean canStartConnection(ICreateConnectionContext context) {
 // return true if start anchor belongs to a EE
if (getExternal_entity(context.getSourceAnchor()) != null) {
     return true;
 }
// return true if start anchor belongs to a DataStore
if (getDataStore(context.getSourceAnchor()) != null) {
     return true;
 }
 /*add Process*/
if (getProcess(context.getSourceAnchor()) != null) {
     return true;
 }
 
 
 return false;
}




	/* get Classes which should be connected */
	public Connection create(ICreateConnectionContext context) {
		DataFlow newdataflow = null;
		Connection newConnection = null;

		// get elements which should be connected
		Dataflow_editor.External_entity EtE_source = getExternal_entity(context
				.getSourceAnchor());
		Dataflow_editor.External_entity EtE_target = getExternal_entity(context
				.getTargetAnchor());

		if (EtE_source != null && EtE_target != null) {
			// create new business object
			newdataflow = EtE_createDataFlow(EtE_source, EtE_target);

			newdataflow.setArchpoint(true);// 2014.8.7 new

			// add connection for business object
			AddConnectionContext addContext = new AddConnectionContext(
					context.getSourceAnchor(), context.getTargetAnchor());
			addContext.setNewObject(newdataflow);
			newConnection = (Connection) getFeatureProvider().addIfPossible(
					addContext);
			getFeatureProvider().getDirectEditingInfo().setActive(true);
		}

		/* below new adding */
		Dataflow_editor.DataStore DStDS_source = getDataStore(context
				.getSourceAnchor());
		Dataflow_editor.DataStore DStDS_target = getDataStore(context
				.getTargetAnchor());

		if (DStDS_source != null && DStDS_target != null) {
			// create new business object
			newdataflow = DStDS_createDataFlow(DStDS_source,
					DStDS_target);

			newdataflow.setArchpoint(true);// 2014.8.7 new

			// add connection for business object
			AddConnectionContext addContext = new AddConnectionContext(
					context.getSourceAnchor(), context.getTargetAnchor());
			addContext.setNewObject(newdataflow);
			newConnection = (Connection) getFeatureProvider().addIfPossible(
					addContext);
			getFeatureProvider().getDirectEditingInfo().setActive(true);
		}

		/* add Process */
		Dataflow_editor.Process PtP_source = getProcess(context
				.getSourceAnchor());
		Dataflow_editor.Process PtP_target = getProcess(context
				.getTargetAnchor());
		/* add Process */
		if (PtP_source != null && PtP_target != null) {
			// create new business object
			newdataflow = PtP_createDataFlow(PtP_source, PtP_target);

			newdataflow.setArchpoint(true);// 2014.8.7 new

			// add connection for business object
			AddConnectionContext addContext = new AddConnectionContext(
					context.getSourceAnchor(), context.getTargetAnchor());
			addContext.setNewObject(newdataflow);
			newConnection = (Connection) getFeatureProvider().addIfPossible(
					addContext);
			getFeatureProvider().getDirectEditingInfo().setActive(true);
		}

		/*------------------add PtDS----------------------*/
		Dataflow_editor.Process PtDS_source = getProcess(context
				.getSourceAnchor());
		Dataflow_editor.DataStore PtDS_target = getDataStore(context
				.getTargetAnchor());

		if (PtDS_source != null && PtDS_target != null) {
			// create new business object
			newdataflow = PtDS_createDataFlow(PtDS_source,
					PtDS_target);

			newdataflow.setArchpoint(true);// 2014.8.7 new

			// add connection for business object
			AddConnectionContext addContext = new AddConnectionContext(
					context.getSourceAnchor(), context.getTargetAnchor());
			addContext.setNewObject(newdataflow);
			newConnection = (Connection) getFeatureProvider().addIfPossible(
					addContext);
			getFeatureProvider().getDirectEditingInfo().setActive(true);
		}

		/* add DStP */
		Dataflow_editor.DataStore DStP_source = getDataStore(context
				.getSourceAnchor());
		Dataflow_editor.Process DStP_target = getProcess(context
				.getTargetAnchor());

		if (DStP_source != null && DStP_target != null) {
			// create new business object
			newdataflow = DStP_createDataFlow(DStP_source,
					DStP_target);

			//dataflow.setArchpoint(true);// 2014.8.7 new

			// add connection for business object
			AddConnectionContext addContext = new AddConnectionContext(
					context.getSourceAnchor(), context.getTargetAnchor());
			addContext.setNewObject(newdataflow);
			newConnection = (Connection) getFeatureProvider().addIfPossible(
					addContext);
			getFeatureProvider().getDirectEditingInfo().setActive(true);
		}

		/* add Process to External_entity */
		Dataflow_editor.Process PtE_source = getProcess(context
				.getSourceAnchor());
		Dataflow_editor.External_entity PtE_target = getExternal_entity(context
				.getTargetAnchor());

		if (PtE_source != null && PtE_target != null) {
			// create new business object
			/* !!"createDataFlow"->"PtE_createDataFlow" line398 changed,too !! */
			newdataflow = PtE_createDataFlow(PtE_source, PtE_target);

			//dataflow.setArchpoint(true);// 2014.8.7 new

			// add connection for business object
			AddConnectionContext addContext = new AddConnectionContext(
					context.getSourceAnchor(), context.getTargetAnchor());
			addContext.setNewObject(newdataflow);
			newConnection = (Connection) getFeatureProvider().addIfPossible(
					addContext);
			getFeatureProvider().getDirectEditingInfo().setActive(true);
		}

		/* add External_entity -> Process */
		Dataflow_editor.External_entity EtP_source = getExternal_entity(context
				.getSourceAnchor());
		Dataflow_editor.Process EtP_target = getProcess(context
				.getTargetAnchor());

		if (EtP_source != null && EtP_target != null) {
			// create new business object
			newdataflow = EtP_createDataFlow(EtP_source, EtP_target);
			// add connection for business object
			AddConnectionContext addContext = new AddConnectionContext(
					context.getSourceAnchor(), context.getTargetAnchor());
			addContext.setNewObject(newdataflow);
			newConnection = (Connection) getFeatureProvider().addIfPossible(
					addContext);
			getFeatureProvider().getDirectEditingInfo().setActive(true);
		}

		/* add External_entity -> DataStore */
		Dataflow_editor.External_entity EtDS_source = getExternal_entity(context
				.getSourceAnchor());
		Dataflow_editor.DataStore EtDS_target = getDataStore(context
				.getTargetAnchor());

		if (EtDS_source != null && EtDS_target != null) {
			// create new business object
			newdataflow = EtDS_createDataFlow(EtDS_source,
					EtDS_target);
			// add connection for business object
			AddConnectionContext addContext = new AddConnectionContext(
					context.getSourceAnchor(), context.getTargetAnchor());
			addContext.setNewObject(newdataflow);
			newConnection = (Connection) getFeatureProvider().addIfPossible(
					addContext);
			getFeatureProvider().getDirectEditingInfo().setActive(true);
		}

		/* add DataStore -> External_entity */
		Dataflow_editor.DataStore DStE_source = getDataStore(context
				.getSourceAnchor());
		Dataflow_editor.External_entity DStE_target = getExternal_entity(context
				.getTargetAnchor());

		if (DStE_source != null && DStE_target != null) {
			// create new business object
			newdataflow = DStE_createDataFlow(DStE_source,
					DStE_target);
			// add connection for business object
			AddConnectionContext addContext = new AddConnectionContext(
					context.getSourceAnchor(), context.getTargetAnchor());
			addContext.setNewObject(newdataflow);
			newConnection = (Connection) getFeatureProvider().addIfPossible(
					addContext);
			getFeatureProvider().getDirectEditingInfo().setActive(true);

			//getDiagram().eResource().getContents().add(dataflow);

		}

		if(newdataflow == null){
			
		}else{
			getDiagram().eResource().getContents().add(newdataflow);
		}
		return newConnection;
	}





/**
* Returns the Class belonging to the anchor, or null if not available.
*/
private Dataflow_editor.External_entity getExternal_entity(Anchor anchor_e) {
 if (anchor_e != null) {
     Object object_e =
         getBusinessObjectForPictogramElement(anchor_e.getParent());
     if (object_e instanceof Dataflow_editor.External_entity) {
         return (Dataflow_editor.External_entity) object_e;      
     }    
 }
 return null;
}

/*below new adding*/
/*below new private class*/
private Dataflow_editor.DataStore getDataStore(Anchor anchor_ds) {
	 if (anchor_ds != null) {
	     Object object_ds =
	         getBusinessObjectForPictogramElement(anchor_ds.getParent());
	     if (object_ds instanceof Dataflow_editor.DataStore) {
	         return (Dataflow_editor.DataStore) object_ds;      
	     } 
 }
 return null;
}
/*below new private class*/
/*add Process*/
private Dataflow_editor.Process getProcess(Anchor anchor_p) {
	 if (anchor_p != null) {
	     Object object_p =
	         getBusinessObjectForPictogramElement(anchor_p.getParent());
	     if (object_p instanceof Dataflow_editor.Process) {
	         return (Dataflow_editor.Process) object_p;      
	     }  
 }
return null;
}


/**
* Creates a Reference between two element.
*/
private DataFlow EtE_createDataFlow(Dataflow_editor.External_entity EtE_source, Dataflow_editor.External_entity EtE_target) {
	DataFlow EtE_Reference = Dataflow_editorFactory.eINSTANCE.createDataFlow();
	EtE_Reference.setName("state");
	return  EtE_Reference;
	}


private DataFlow DStDS_createDataFlow(Dataflow_editor.DataStore DStDS_source, Dataflow_editor.DataStore DStDS_target) {
	DataFlow DStDS_Reference = Dataflow_editorFactory.eINSTANCE.createDataFlow();
	DStDS_Reference.setName("state");
	return  DStDS_Reference;
	}


private DataFlow PtP_createDataFlow(Dataflow_editor.Process PtP_source, Dataflow_editor.Process PtP_target) {
	DataFlow PtP_Reference = Dataflow_editorFactory.eINSTANCE.createDataFlow();
	PtP_Reference.setName("state");
	return  PtP_Reference;
	}

private DataFlow PtDS_createDataFlow(Dataflow_editor.Process PtDS_source, Dataflow_editor.DataStore PtDS_target) {
	DataFlow PtDS_Reference = Dataflow_editorFactory.eINSTANCE.createDataFlow();
	PtDS_Reference.setName("state");
	return  PtDS_Reference;
	}

private DataFlow DStP_createDataFlow(Dataflow_editor.DataStore DStP_source, Dataflow_editor.Process DStP_target) {
	DataFlow DStP_Reference = Dataflow_editorFactory.eINSTANCE.createDataFlow();
	DStP_Reference.setName("state");
	return  DStP_Reference;
	}

/*2014.12.15 new "createDataFlow"->"PtE_createDataFlow"    line249 changed,too*/
private DataFlow PtE_createDataFlow(Dataflow_editor.Process PtE_source, Dataflow_editor.External_entity PtE_target) {
	DataFlow PtE_Reference = Dataflow_editorFactory.eINSTANCE.createDataFlow();
	PtE_Reference.setName("state");
	return  PtE_Reference;
	}

private DataFlow EtP_createDataFlow(Dataflow_editor.External_entity EtP_source, Dataflow_editor.Process EtP_target) {
	DataFlow EtP_Reference = Dataflow_editorFactory.eINSTANCE.createDataFlow();
	EtP_Reference.setName("state");
	return  EtP_Reference;
	}

private DataFlow EtDS_createDataFlow(Dataflow_editor.External_entity PtDS_source, Dataflow_editor.DataStore PtDS_target) {
	DataFlow EtDS_Reference = Dataflow_editorFactory.eINSTANCE.createDataFlow();
	EtDS_Reference.setName("state");
	return  EtDS_Reference;
	}

private DataFlow DStE_createDataFlow(Dataflow_editor.DataStore PtDS_source, Dataflow_editor.External_entity PtDS_target) {
	DataFlow DStE_Reference = Dataflow_editorFactory.eINSTANCE.createDataFlow();
	DStE_Reference.setName("state");
	return  DStE_Reference;
	}














}
