package jp.ac.kyushu.iarch.classdiagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;

import umlClass.Association;
import umlClass.UmlClassFactory;

public class CreateAssociationFeature extends AbstractCreateConnectionFeature {

public CreateAssociationFeature (IFeatureProvider fp) {
 // provide name and description for the UI, e.g. the palette
 super(fp, "Association", "Create Association");
}

public boolean canCreate(ICreateConnectionContext context) {
	// return true if both anchors belong to an Class
	// and those Classes are not identical
	umlClass.Class source = getClass(context.getSourceAnchor());
	umlClass.Class target = getClass(context.getTargetAnchor());
	if (source != null && target != null && source != target) {
	    return true;
	}
	return false;
}

public boolean canStartConnection(ICreateConnectionContext context) {
 // return true if start anchor belongs to a Class
 if (getClass(context.getSourceAnchor()) != null) {
     return true;
 }
 return false;
}

public Connection create(ICreateConnectionContext context) {
 Connection newConnection = null;

 // get Classes which should be connected
 umlClass.Class source = getClass(context.getSourceAnchor());
 umlClass.Class target = getClass(context.getTargetAnchor());

 if (source != null && target != null) {
     // create new business object 
     Association eReference = createAssociation(source, target);
     
     eReference.setArchpoint(true);
     getDiagram().eResource().getContents().add(eReference);
     // add connection for business object
     AddConnectionContext addContext =
         new AddConnectionContext(context.getSourceAnchor(), context
             .getTargetAnchor());
     addContext.setNewObject(eReference);
     eReference.setTarget(target);
     eReference.setOwner(source);
     newConnection =
         (Connection) getFeatureProvider().addIfPossible(addContext);
     getFeatureProvider().getDirectEditingInfo().setActive(true);
 }

 return newConnection;
}

/**
* Returns the Class belonging to the anchor, or null if not available.
*/
private umlClass.Class getClass(Anchor anchor) {
 if (anchor != null) {
     Object object =
         getBusinessObjectForPictogramElement(anchor.getParent());
     if (object instanceof umlClass.Class) {
         return (umlClass.Class) object;
     }
 }
 return null;
}

/**
* Creates a Reference between two Classes.
*/
private Association createAssociation(umlClass.Class source, umlClass.Class target) {
	Association eReference = UmlClassFactory.eINSTANCE.createAssociation();
	eReference.setName("newAssociation");
	//eReference.setEType(target);
	//eReference.setLowerBound(0);
	//eReference.setUpperBound(1);
	//source.getEStructuralFeatures().add(eReference);
	return eReference;
	}
}
