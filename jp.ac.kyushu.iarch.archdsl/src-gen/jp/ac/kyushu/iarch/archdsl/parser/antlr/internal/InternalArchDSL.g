/*
* generated by Xtext
*/
grammar InternalArchDSL;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package jp.ac.kyushu.iarch.archdsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package jp.ac.kyushu.iarch.archdsl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import jp.ac.kyushu.iarch.archdsl.services.ArchDSLGrammarAccess;

}

@parser::members {

 	private ArchDSLGrammarAccess grammarAccess;
 	
    public InternalArchDSLParser(TokenStream input, ArchDSLGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Model";	
   	}
   	
   	@Override
   	protected ArchDSLGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getModelRule()); }
	 iv_ruleModel=ruleModel 
	 { $current=$iv_ruleModel.current; } 
	 EOF 
;

// Rule Model
ruleModel returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getModelAccess().getInterfacesInterfaceParserRuleCall_0_0()); 
	    }
		lv_interfaces_0_0=ruleInterface		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModelRule());
	        }
       		add(
       			$current, 
       			"interfaces",
        		lv_interfaces_0_0, 
        		"Interface");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getModelAccess().getBehaviorsBehaviorParserRuleCall_1_0()); 
	    }
		lv_behaviors_1_0=ruleBehavior		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModelRule());
	        }
       		add(
       			$current, 
       			"behaviors",
        		lv_behaviors_1_0, 
        		"Behavior");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getModelAccess().getConnectorsConnectorParserRuleCall_2_0()); 
	    }
		lv_connectors_2_0=ruleConnector		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModelRule());
	        }
       		add(
       			$current, 
       			"connectors",
        		lv_connectors_2_0, 
        		"Connector");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getModelAccess().getDflowsDFlowParserRuleCall_3_0()); 
	    }
		lv_dflows_3_0=ruleDFlow		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModelRule());
	        }
       		add(
       			$current, 
       			"dflows",
        		lv_dflows_3_0, 
        		"DFlow");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getModelAccess().getDatasDataParserRuleCall_4_0()); 
	    }
		lv_datas_4_0=ruleData		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModelRule());
	        }
       		add(
       			$current, 
       			"datas",
        		lv_datas_4_0, 
        		"Data");
	        afterParserOrEnumRuleCall();
	    }

)
)*)
;





// Entry rule entryRuleInterface
entryRuleInterface returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getInterfaceRule()); }
	 iv_ruleInterface=ruleInterface 
	 { $current=$iv_ruleInterface.current; } 
	 EOF 
;

// Rule Interface
ruleInterface returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='interface component' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getInterfaceAccess().getInterfaceComponentKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getInterfaceAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getInterfaceRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getInterfaceAccess().getLeftCurlyBracketKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getInterfaceAccess().getMethodsMethodParserRuleCall_3_0()); 
	    }
		lv_methods_3_0=ruleMethod		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getInterfaceRule());
	        }
       		add(
       			$current, 
       			"methods",
        		lv_methods_3_0, 
        		"Method");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_4='}' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getInterfaceAccess().getRightCurlyBracketKeyword_4());
    }
)
;





// Entry rule entryRuleMethod
entryRuleMethod returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMethodRule()); }
	 iv_ruleMethod=ruleMethod 
	 { $current=$iv_ruleMethod.current; } 
	 EOF 
;

// Rule Method
ruleMethod returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_type_0_0=RULE_ID
		{
			newLeafNode(lv_type_0_0, grammarAccess.getMethodAccess().getTypeIDTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMethodRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"type",
        		lv_type_0_0, 
        		"ID");
	    }

)
)(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getMethodAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMethodRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getMethodAccess().getLeftParenthesisKeyword_2());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getMethodAccess().getParamParamParserRuleCall_3_0_0()); 
	    }
		lv_param_3_0=ruleParam		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMethodRule());
	        }
       		add(
       			$current, 
       			"param",
        		lv_param_3_0, 
        		"Param");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4=',' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getMethodAccess().getCommaKeyword_3_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMethodAccess().getParamParamParserRuleCall_3_1_1_0()); 
	    }
		lv_param_5_0=ruleParam		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMethodRule());
	        }
       		add(
       			$current, 
       			"param",
        		lv_param_5_0, 
        		"Param");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_6=');' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getMethodAccess().getRightParenthesisSemicolonKeyword_4());
    }
)
;





// Entry rule entryRuleParam
entryRuleParam returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getParamRule()); }
	 iv_ruleParam=ruleParam 
	 { $current=$iv_ruleParam.current; } 
	 EOF 
;

// Rule Param
ruleParam returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_type_0_0=RULE_ID
		{
			newLeafNode(lv_type_0_0, grammarAccess.getParamAccess().getTypeIDTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getParamRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"type",
        		lv_type_0_0, 
        		"ID");
	    }

)
)(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getParamAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getParamRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
))
;





// Entry rule entryRulecParam
entryRulecParam returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCParamRule()); }
	 iv_rulecParam=rulecParam 
	 { $current=$iv_rulecParam.current; } 
	 EOF 
;

// Rule cParam
rulecParam returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		lv_name_0_0=RULE_ID
		{
			newLeafNode(lv_name_0_0, grammarAccess.getCParamAccess().getNameIDTerminalRuleCall_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getCParamRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"ID");
	    }

)
)
;





// Entry rule entryRuleConnector
entryRuleConnector returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getConnectorRule()); }
	 iv_ruleConnector=ruleConnector 
	 { $current=$iv_ruleConnector.current; } 
	 EOF 
;

// Rule Connector
ruleConnector returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='interface connector' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getConnectorAccess().getInterfaceConnectorKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getConnectorAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getConnectorRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getConnectorAccess().getLeftParenthesisKeyword_2());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getConnectorAccess().getCparamCParamParserRuleCall_3_0_0()); 
	    }
		lv_cparam_3_0=rulecParam		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConnectorRule());
	        }
       		add(
       			$current, 
       			"cparam",
        		lv_cparam_3_0, 
        		"cParam");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4=',' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getConnectorAccess().getCommaKeyword_3_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getConnectorAccess().getCparamCParamParserRuleCall_3_1_1_0()); 
	    }
		lv_cparam_5_0=rulecParam		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConnectorRule());
	        }
       		add(
       			$current, 
       			"cparam",
        		lv_cparam_5_0, 
        		"cParam");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_6=')' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getConnectorAccess().getRightParenthesisKeyword_4());
    }
	otherlv_7='{' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getConnectorAccess().getLeftCurlyBracketKeyword_5());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getConnectorAccess().getBehaviorsBehaviorParserRuleCall_6_0()); 
	    }
		lv_behaviors_8_0=ruleBehavior		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConnectorRule());
	        }
       		add(
       			$current, 
       			"behaviors",
        		lv_behaviors_8_0, 
        		"Behavior");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_9='}' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getConnectorAccess().getRightCurlyBracketKeyword_7());
    }
)
;





// Entry rule entryRuleBehavior
entryRuleBehavior returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getBehaviorRule()); }
	 iv_ruleBehavior=ruleBehavior 
	 { $current=$iv_ruleBehavior.current; } 
	 EOF 
;

// Rule Behavior
ruleBehavior returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getBehaviorRule());
	        }
        }
	otherlv_0=RULE_ID
	{
		newLeafNode(otherlv_0, grammarAccess.getBehaviorAccess().getInterfaceInterfaceCrossReference_0_0()); 
	}

)
)	otherlv_1='=' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getBehaviorAccess().getEqualsSignKeyword_1());
    }
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getBehaviorRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getBehaviorAccess().getCallMethodCrossReference_2_0_0()); 
	    }
		ruleFQN		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3='->' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getBehaviorAccess().getHyphenMinusGreaterThanSignKeyword_2_1_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getBehaviorRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getBehaviorAccess().getCallMethodCrossReference_2_1_1_0()); 
	    }
		ruleFQN		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_5='->' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getBehaviorAccess().getHyphenMinusGreaterThanSignKeyword_2_2());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getBehaviorRule());
	        }
        }
	otherlv_6=RULE_ID
	{
		newLeafNode(otherlv_6, grammarAccess.getBehaviorAccess().getEndInterfaceCrossReference_2_3_0()); 
	}

)
))?	otherlv_7=';' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getBehaviorAccess().getSemicolonKeyword_3());
    }
)
;





// Entry rule entryRuleDFlow
entryRuleDFlow returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getDFlowRule()); }
	 iv_ruleDFlow=ruleDFlow 
	 { $current=$iv_ruleDFlow.current; } 
	 EOF 
;

// Rule DFlow
ruleDFlow returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='interface dflow' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getDFlowAccess().getInterfaceDflowKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getDFlowAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDFlowRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getDFlowAccess().getLeftParenthesisKeyword_2());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getDFlowAccess().getCparamCParamParserRuleCall_3_0_0()); 
	    }
		lv_cparam_3_0=rulecParam		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDFlowRule());
	        }
       		add(
       			$current, 
       			"cparam",
        		lv_cparam_3_0, 
        		"cParam");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4=',' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getDFlowAccess().getCommaKeyword_3_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getDFlowAccess().getCparamCParamParserRuleCall_3_1_1_0()); 
	    }
		lv_cparam_5_0=rulecParam		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDFlowRule());
	        }
       		add(
       			$current, 
       			"cparam",
        		lv_cparam_5_0, 
        		"cParam");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_6=')' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getDFlowAccess().getRightParenthesisKeyword_4());
    }
	otherlv_7='{' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getDFlowAccess().getLeftCurlyBracketKeyword_5());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getDFlowAccess().getDataflowsDataflowParserRuleCall_6_0()); 
	    }
		lv_dataflows_8_0=ruleDataflow		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDFlowRule());
	        }
       		add(
       			$current, 
       			"dataflows",
        		lv_dataflows_8_0, 
        		"Dataflow");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_9='}' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getDFlowAccess().getRightCurlyBracketKeyword_7());
    }
)
;





// Entry rule entryRuleDataflow
entryRuleDataflow returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getDataflowRule()); }
	 iv_ruleDataflow=ruleDataflow 
	 { $current=$iv_ruleDataflow.current; } 
	 EOF 
;

// Rule Dataflow
ruleDataflow returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getDataflowAccess().getDataflowAction_0(),
            $current);
    }
)	otherlv_1='dStateNotification' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getDataflowAccess().getDStateNotificationKeyword_1());
    }
	otherlv_2='=' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getDataflowAccess().getEqualsSignKeyword_2());
    }
(	otherlv_3='|' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getDataflowAccess().getVerticalLineKeyword_3_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDataflowRule());
	        }
        }
	otherlv_4=RULE_ID
	{
		newLeafNode(otherlv_4, grammarAccess.getDataflowAccess().getGetflowDataCrossReference_3_1_0()); 
	}

)
)	otherlv_5='|' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getDataflowAccess().getVerticalLineKeyword_3_2());
    }
	otherlv_6='->>' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getDataflowAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_3_3());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDataflowRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDataflowAccess().getCallMethodCrossReference_3_4_0()); 
	    }
		ruleFQN		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_8='->>' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getDataflowAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_3_5());
    }
	otherlv_9='|' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getDataflowAccess().getVerticalLineKeyword_3_6());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDataflowRule());
	        }
        }
	otherlv_10=RULE_ID
	{
		newLeafNode(otherlv_10, grammarAccess.getDataflowAccess().getGetflowDataCrossReference_3_7_0()); 
	}

)
)	otherlv_11='|' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getDataflowAccess().getVerticalLineKeyword_3_8());
    }
	otherlv_12='->>' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getDataflowAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_3_9());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDataflowRule());
	        }
        }
	otherlv_13=RULE_ID
	{
		newLeafNode(otherlv_13, grammarAccess.getDataflowAccess().getGetIfInterfaceCrossReference_3_10_0()); 
	}

)
)	otherlv_14='->>' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getDataflowAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_3_11());
    }
	otherlv_15='|' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getDataflowAccess().getVerticalLineKeyword_3_12());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDataflowRule());
	        }
        }
	otherlv_16=RULE_ID
	{
		newLeafNode(otherlv_16, grammarAccess.getDataflowAccess().getGetflowDataCrossReference_3_13_0()); 
	}

)
)	otherlv_17='|' 
    {
    	newLeafNode(otherlv_17, grammarAccess.getDataflowAccess().getVerticalLineKeyword_3_14());
    }
	otherlv_18='->>' 
    {
    	newLeafNode(otherlv_18, grammarAccess.getDataflowAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_3_15());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDataflowRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDataflowAccess().getCallMethodCrossReference_3_16_0()); 
	    }
		ruleFQN		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_20='->>' 
    {
    	newLeafNode(otherlv_20, grammarAccess.getDataflowAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_3_17());
    }
	otherlv_21='|' 
    {
    	newLeafNode(otherlv_21, grammarAccess.getDataflowAccess().getVerticalLineKeyword_3_18());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDataflowRule());
	        }
        }
	otherlv_22=RULE_ID
	{
		newLeafNode(otherlv_22, grammarAccess.getDataflowAccess().getGetflowDataCrossReference_3_19_0()); 
	}

)
)	otherlv_23='|' 
    {
    	newLeafNode(otherlv_23, grammarAccess.getDataflowAccess().getVerticalLineKeyword_3_20());
    }
	otherlv_24='->>' 
    {
    	newLeafNode(otherlv_24, grammarAccess.getDataflowAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_3_21());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDataflowRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDataflowAccess().getCallMethodCrossReference_3_22_0()); 
	    }
		ruleFQN		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_26='->>' 
    {
    	newLeafNode(otherlv_26, grammarAccess.getDataflowAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_3_23());
    }
	otherlv_27='dStateNotification' 
    {
    	newLeafNode(otherlv_27, grammarAccess.getDataflowAccess().getDStateNotificationKeyword_3_24());
    }
)?	otherlv_28=';' 
    {
    	newLeafNode(otherlv_28, grammarAccess.getDataflowAccess().getSemicolonKeyword_4());
    }
)
;





// Entry rule entryRuleData
entryRuleData returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getDataRule()); }
	 iv_ruleData=ruleData 
	 { $current=$iv_ruleData.current; } 
	 EOF 
;

// Rule Data
ruleData returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='flow' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getDataAccess().getFlowKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getDataAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDataRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)	otherlv_2=';' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getDataAccess().getSemicolonKeyword_2());
    }
)
;





// Entry rule entryRuleFQN
entryRuleFQN returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getFQNRule()); } 
	 iv_ruleFQN=ruleFQN 
	 { $current=$iv_ruleFQN.current.getText(); }  
	 EOF 
;

// Rule FQN
ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
    }
    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
    }
)*)
    ;





RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


