package jp.ac.kyushu.iarch.dataflowdiagram.diagram.providers;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.palette.IToolEntry;
import org.eclipse.graphiti.palette.impl.ObjectCreationToolEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;

public class DiagramToolBehaviorProvider extends DefaultToolBehaviorProvider {

	public DiagramToolBehaviorProvider(
			IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
	}



	public IPaletteCompartmentEntry[] getPalette() {
		
		IPaletteCompartmentEntry compartments[] = super.getPalette();

		for (IPaletteCompartmentEntry compartment : compartments) {
			
			if (compartment.getLabel().equals("Objects")) {
				
				compartment.getToolEntries().clear();

				
				for (ICreateFeature feature : getFeatureProvider()
						.getCreateFeatures()) {
					
					String id = feature.getCreateName();

					IToolEntry newEntry = new ObjectCreationToolEntry(
							feature.getCreateName(),
							feature.getCreateDescription(), id, id, feature);
					compartment.getToolEntries().add(newEntry);
				}
			}
		}
		return compartments;
	}
	
	
	
}
	
	
	
	
	

	 
