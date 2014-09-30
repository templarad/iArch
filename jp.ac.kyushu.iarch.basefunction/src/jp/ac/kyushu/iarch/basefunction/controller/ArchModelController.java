package jp.ac.kyushu.iarch.basefunction.controller;

import java.io.IOException;

import org.eclipse.core.resources.IResource;

import jp.ac.kyushu.iarch.archdsl.archDSL.Behavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.basefunction.reader.ArchModel;
/**
 * A class for refactoring arch-code from diagram.
 * <br>After you use changeXXX method, it will save the change to arch-code automatically.
 * @author Templar
 *
 */
public class ArchModelController extends ArchModel {
	
	public ArchModelController(IResource archfile){
		super(archfile);
	}
	/**
	 * 
	 * @param currentName The old name of the class which you want to change.
	 * @param newName The new name of the class you want to change to.
	 * 
	 */
	public void changeClassName(String currentName, String newName){
		if(null == resource)
			return;
		boolean changed = false;
		Model model = (Model) resource.getContents().get(0);
		
		int i=0;
        for(Interface interfc : model.getInterfaces()){
        	
        	if(interfc.getName().equals(currentName)){
        		model.getInterfaces().get(i).setName(newName);
        		changed = true;
        		break;
        	}
        	i++;
        }
        if(!changed)
        	return;
		try {
			resource.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param className Which class does the attribute included.
	 * @param currentAttri The old name of the attribute which you want to change.
	 * @param newAttri The new name of attribute you want to change to.
	 * 
	 */
	public void changeOperationName(String className, String currentAttri, String newAttri){
		if(null == resource)
			return;
		boolean changed = false;
		Model model = (Model) resource.getContents().get(0);
		
		int i=0;
        for(Interface interfc :model.getInterfaces()){
        	
        	if(interfc.getName().equals(className)){
        		int j = 0;
        		for(Method method: interfc.getMethods()){
        			if(currentAttri.equals(method.getName()) ){
        				model.getInterfaces().get(i).getMethods().get(j).setName(newAttri);
        				changed=true;
                		break;
        			}
        			j++;
        		}        		
        	}
        	i++;
        }
        if(!changed)
        	return;
		try {
			resource.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void changeAttributeName(String className, String currentAttri, String newAttri){
		if(null == resource)
			return;
		boolean changed = false;


        if(!changed)
        	return;
		try {
			resource.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeMethod(String className, String currentAttri){
		if(null == resource)
			return;
		boolean changed = false;
		Model model = (Model) resource.getContents().get(0);
		
		int i=0;
        for(Interface interfc :model.getInterfaces()){
        	
        	if(interfc.getName().equals(className)){
        		int j = 0;
        		for(Method method: interfc.getMethods()){
        			if(currentAttri.equals(method.getName()) ){
        				model.getInterfaces().get(i).getMethods().remove(j);
        				changed=true;
                		break;
        			}
        			j++;
        		}        		
        	}
        	i++;
        }
        
        for(Behavior behvior:model.getBehaviors()){
        	i = 0;
        	for(Method method : behvior.getCall()){
        		if(method.getName().equals(currentAttri)){
        			behvior.getCall().remove(i);
        			i--;
        			break;
        		}
        		i++;
        	}
        }
        
        if(!changed)
        	return;
		try {
			resource.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
