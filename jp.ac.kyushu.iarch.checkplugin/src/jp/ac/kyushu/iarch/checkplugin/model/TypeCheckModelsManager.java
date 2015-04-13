package jp.ac.kyushu.iarch.checkplugin.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fukamachi
 *
 */
public class TypeCheckModelsManager {
	public static List<ComponentClassPairModel> componentClassPairModels = new ArrayList<ComponentClassPairModel>();
	public static List<ComponentMethodPairModel> componentMethodPairModels = new ArrayList<ComponentMethodPairModel>();

	private static TypeCheckModelsManager typeCheckModelsManager = new TypeCheckModelsManager();

	private TypeCheckModelsManager(){
		//Singleton
	}

	public static void modelsInit(){
		componentClassPairModels = new ArrayList<ComponentClassPairModel>();
		componentMethodPairModels = new ArrayList<ComponentMethodPairModel>();
	}
}
