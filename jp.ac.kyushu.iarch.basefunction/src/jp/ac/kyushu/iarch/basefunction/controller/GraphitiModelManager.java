package jp.ac.kyushu.iarch.basefunction.controller;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.graphiti.mm.pictograms.PictogramsPackage;

import umlClass.UmlClassPackage;

/**
 * Graphiti file parser
 * @author hosoai
 */
public class GraphitiModelManager {
	public static Resource getGraphitiModel(IResource file){
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("diagram", new XMIResourceFactoryImpl());
		rs.getPackageRegistry().put("http://eclipse.org/graphiti/mm/pictograms", PictogramsPackage.eINSTANCE);
		rs.getPackageRegistry().put("http://umlClass/1.0", UmlClassPackage.eINSTANCE);
		Resource resource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(),true),true);
		return resource;
	}
}
