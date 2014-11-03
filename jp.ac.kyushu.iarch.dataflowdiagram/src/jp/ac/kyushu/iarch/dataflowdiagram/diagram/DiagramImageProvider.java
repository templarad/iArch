package jp.ac.kyushu.iarch.dataflowdiagram.diagram;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;
import org.eclipse.graphiti.ui.platform.IImageProvider;

/**
 * @author Kakushusyo
 */
public class DiagramImageProvider extends AbstractImageProvider implements
		IImageProvider {

	
	public static final String PROCESS_IMAGE = "Process";
	public static final String AA_IMAGE = "AA";
	public static final String DATASTORE_IMAGE = "Datastore";
	public static final String EXTERNAL_ENTITY_IMAGE = "External entity";
	public static final String ARROW_IMAGE = "Dataflow";
	
	@Override
	protected void addAvailableImages() {
		// register the path for each image identifier
		addImageFilePath(PROCESS_IMAGE, "icons/" + PROCESS_IMAGE + ".png");
		addImageFilePath(AA_IMAGE, "icons/" + AA_IMAGE + ".png");
		addImageFilePath(DATASTORE_IMAGE, "icons/" + DATASTORE_IMAGE + ".png");
		addImageFilePath(EXTERNAL_ENTITY_IMAGE, "icons/" + EXTERNAL_ENTITY_IMAGE + ".png");
		addImageFilePath(ARROW_IMAGE, "icons/" + ARROW_IMAGE + ".png");
	
	
	}

}
