package jp.ac.kyushu.iarch.checkplugin.model;
/**
 * The model of Abstraction Ratio
 * @author Templar
 *
 */
public class AbstractionRatio {
	private int arch_method_num;
	private int arch_class_num;
	private int arch_behavior_num;
	private int arch_archpoint_num;
	private int xml_method_num;
	private int xml_class_num;
	private int xml_invocation_point_num;
	private int xml_point_num;
	private double abstraction_ratio;
	
	private static AbstractionRatio abstractionRation= new AbstractionRatio();

	public static AbstractionRatio getInstance(){
		return abstractionRation;
	}
	
	public int getMethodNum(){
		return arch_method_num;
	}
	
	public void setMethodNum(int param){
		arch_method_num = param;
	}
	
	public int getClassNum(){
		return arch_class_num;
	}
	
	public void setClassNum(int param){
		arch_class_num = param;
	}
	
	public int getBehaviorNum(){
		return arch_behavior_num;
	}
	
	public void setBehaviorNum(int param){
		arch_behavior_num = param;
	}
	
	public int getArchpointNum(){
		return arch_archpoint_num;
	}
	
	public void setArchpointNum(int param){
		arch_archpoint_num = param;
	}
	
	public int getXmlMethodNum(){
		return xml_method_num;
	}
	
	public void setXmlMethodNum(int param){
		xml_method_num = param;
	}
	
	public int getXmlClassNum(){
		return xml_class_num;
	}
	
	public void setXmlClassNum(int param){
		xml_class_num = param;
	}
	
	public int getXmlInvocationPointNum(){
		return xml_invocation_point_num;
	}
	
	public void setXmlInvocationPointNum(int param){
		xml_invocation_point_num = param;
	}	
	
	public int getXmlpointNum(){
		return xml_point_num;
	}
	
	public void setXmlpointNum(int param){
		xml_point_num = param;
	}
	
	public double getAbstractionRatio(){
		return abstraction_ratio;
	}
	public void setAbstractionRatio(double param){
		abstraction_ratio = param;
	}
}
