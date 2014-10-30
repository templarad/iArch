package jp.ac.kyushu.iarch.dataflowdiagram.diagram;

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
		// 共三个compartments
		IPaletteCompartmentEntry compartments[] = super.getPalette();

		for (IPaletteCompartmentEntry compartment : compartments) {
			// 为所有EMF模型提供图片
			if (compartment.getLabel().equals("Objects")) {
				// 首先清除默认的所有条目
				compartment.getToolEntries().clear();

				// 获取4个创建特征
				for (ICreateFeature feature : getFeatureProvider()
						.getCreateFeatures()) {
					// addImageFilePath(TERMINAL_IMAGE,
					// realPath)做了id到图片路径的映射，提供id即可
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
	
	
	
	
	

	 
