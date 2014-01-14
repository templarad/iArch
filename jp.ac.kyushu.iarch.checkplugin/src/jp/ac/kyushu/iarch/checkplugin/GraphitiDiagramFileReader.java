package jp.ac.kyushu.iarch.checkplugin;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramsPackage;

public class GraphitiDiagramFileReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		new GraphitiDiagramFileReader().read("newDiagram.diagram");
	}
	
	public void read(String file) throws IOException{
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("diagram", new XMIResourceFactoryImpl());
		rs.getPackageRegistry().put("http://eclipse.org/graphiti/mm/pictograms", PictogramsPackage.eINSTANCE);
		Resource resource = rs.getResource(URI.createFileURI(file), true);
		
		for(EObject o : resource.getContents()){
			if(o instanceof Diagram){
				if(((Diagram)o).getDiagramTypeId().equals("classdiagram")){
					
				}
			}
			System.out.println(o);
		}
	}
}
