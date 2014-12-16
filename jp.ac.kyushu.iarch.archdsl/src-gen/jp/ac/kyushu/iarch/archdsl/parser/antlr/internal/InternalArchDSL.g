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
(((
(
		{ 
	        newCompositeNode(grammarAccess.getModelAccess().getInterfacesInterfaceParserRuleCall_0_0_0()); 
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
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getModelAccess().getU_interfacesUncertainInterfaceParserRuleCall_0_1_0()); 
	    }
		lv_u_interfaces_1_0=ruleUncertainInterface		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModelRule());
	        }
       		add(
       			$current, 
       			"u_interfaces",
        		lv_u_interfaces_1_0, 
        		"UncertainInterface");
	        afterParserOrEnumRuleCall();
	    }

)
))*(
(
		{ 
	        newCompositeNode(grammarAccess.getModelAccess().getBehaviorsBehaviorParserRuleCall_1_0()); 
	    }
		lv_behaviors_2_0=ruleBehavior		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModelRule());
	        }
       		add(
       			$current, 
       			"behaviors",
        		lv_behaviors_2_0, 
        		"Behavior");
	        afterParserOrEnumRuleCall();
	    }

)
)*)
;





// Entry rule entryRuleUncertainInterface
entryRuleUncertainInterface returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getUncertainInterfaceRule()); }
	 iv_ruleUncertainInterface=ruleUncertainInterface 
	 { $current=$iv_ruleUncertainInterface.current; } 
	 EOF 
;

// Rule UncertainInterface
ruleUncertainInterface returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='interface uncertain' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getUncertainInterfaceAccess().getInterfaceUncertainKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getUncertainInterfaceAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getUncertainInterfaceRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)(	otherlv_2='extends' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getUncertainInterfaceAccess().getExtendsKeyword_2_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getUncertainInterfaceRule());
	        }
        }
	otherlv_3=RULE_ID
	{
		newLeafNode(otherlv_3, grammarAccess.getUncertainInterfaceAccess().getSuperInterfaceInterfaceCrossReference_2_1_0()); 
	}

)
))?	otherlv_4='{' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getUncertainInterfaceAccess().getLeftCurlyBracketKeyword_3());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getUncertainInterfaceAccess().getAltmethodsAltMethodParserRuleCall_4_0_0()); 
	    }
		lv_altmethods_5_0=ruleAltMethod		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUncertainInterfaceRule());
	        }
       		add(
       			$current, 
       			"altmethods",
        		lv_altmethods_5_0, 
        		"AltMethod");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getUncertainInterfaceAccess().getOptmethodsOptMethodParserRuleCall_4_1_0()); 
	    }
		lv_optmethods_6_0=ruleOptMethod		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUncertainInterfaceRule());
	        }
       		add(
       			$current, 
       			"optmethods",
        		lv_optmethods_6_0, 
        		"OptMethod");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_7='}' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getUncertainInterfaceAccess().getRightCurlyBracketKeyword_5());
    }
)
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





// Entry rule entryRuleAltMethod
entryRuleAltMethod returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAltMethodRule()); }
	 iv_ruleAltMethod=ruleAltMethod 
	 { $current=$iv_ruleAltMethod.current; } 
	 EOF 
;

// Rule AltMethod
ruleAltMethod returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='{' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getAltMethodAccess().getLeftCurlyBracketKeyword_0());
    }
(
(
		lv_type_1_0=RULE_ID
		{
			newLeafNode(lv_type_1_0, grammarAccess.getAltMethodAccess().getTypeIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAltMethodRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"type",
        		lv_type_1_0, 
        		"ID");
	    }

)
)(
(
		lv_name_2_0=RULE_ID
		{
			newLeafNode(lv_name_2_0, grammarAccess.getAltMethodAccess().getNameIDTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAltMethodRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"ID");
	    }

)
)	otherlv_3='(' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getAltMethodAccess().getLeftParenthesisKeyword_3());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getAltMethodAccess().getParamParamParserRuleCall_4_0_0()); 
	    }
		lv_param_4_0=ruleParam		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAltMethodRule());
	        }
       		add(
       			$current, 
       			"param",
        		lv_param_4_0, 
        		"Param");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5=',' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getAltMethodAccess().getCommaKeyword_4_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAltMethodAccess().getParamParamParserRuleCall_4_1_1_0()); 
	    }
		lv_param_6_0=ruleParam		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAltMethodRule());
	        }
       		add(
       			$current, 
       			"param",
        		lv_param_6_0, 
        		"Param");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_7=')' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getAltMethodAccess().getRightParenthesisKeyword_5());
    }
(	otherlv_8=',' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getAltMethodAccess().getCommaKeyword_6_0());
    }
(
(
		lv_type_9_0=RULE_ID
		{
			newLeafNode(lv_type_9_0, grammarAccess.getAltMethodAccess().getTypeIDTerminalRuleCall_6_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAltMethodRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"type",
        		lv_type_9_0, 
        		"ID");
	    }

)
)(
(
		lv_a_name_10_0=RULE_ID
		{
			newLeafNode(lv_a_name_10_0, grammarAccess.getAltMethodAccess().getA_nameIDTerminalRuleCall_6_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAltMethodRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"a_name",
        		lv_a_name_10_0, 
        		"ID");
	    }

)
)	otherlv_11='(' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getAltMethodAccess().getLeftParenthesisKeyword_6_3());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getAltMethodAccess().getParamParamParserRuleCall_6_4_0_0()); 
	    }
		lv_param_12_0=ruleParam		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAltMethodRule());
	        }
       		add(
       			$current, 
       			"param",
        		lv_param_12_0, 
        		"Param");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_13=',' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getAltMethodAccess().getCommaKeyword_6_4_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAltMethodAccess().getParamParamParserRuleCall_6_4_1_1_0()); 
	    }
		lv_param_14_0=ruleParam		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAltMethodRule());
	        }
       		add(
       			$current, 
       			"param",
        		lv_param_14_0, 
        		"Param");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_15=')' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getAltMethodAccess().getRightParenthesisKeyword_6_5());
    }
)*	otherlv_16='};' 
    {
    	newLeafNode(otherlv_16, grammarAccess.getAltMethodAccess().getRightCurlyBracketSemicolonKeyword_7());
    }
)
;





// Entry rule entryRuleOptMethod
entryRuleOptMethod returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getOptMethodRule()); }
	 iv_ruleOptMethod=ruleOptMethod 
	 { $current=$iv_ruleOptMethod.current; } 
	 EOF 
;

// Rule OptMethod
ruleOptMethod returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='[' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getOptMethodAccess().getLeftSquareBracketKeyword_0());
    }
(
(
		lv_type_1_0=RULE_ID
		{
			newLeafNode(lv_type_1_0, grammarAccess.getOptMethodAccess().getTypeIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getOptMethodRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"type",
        		lv_type_1_0, 
        		"ID");
	    }

)
)(
(
		lv_name_2_0=RULE_ID
		{
			newLeafNode(lv_name_2_0, grammarAccess.getOptMethodAccess().getNameIDTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getOptMethodRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"ID");
	    }

)
)	otherlv_3='(' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getOptMethodAccess().getLeftParenthesisKeyword_3());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getOptMethodAccess().getParamParamParserRuleCall_4_0_0()); 
	    }
		lv_param_4_0=ruleParam		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getOptMethodRule());
	        }
       		add(
       			$current, 
       			"param",
        		lv_param_4_0, 
        		"Param");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5=',' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getOptMethodAccess().getCommaKeyword_4_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getOptMethodAccess().getParamParamParserRuleCall_4_1_1_0()); 
	    }
		lv_param_6_0=ruleParam		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getOptMethodRule());
	        }
       		add(
       			$current, 
       			"param",
        		lv_param_6_0, 
        		"Param");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_7=');' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getOptMethodAccess().getRightParenthesisSemicolonKeyword_5());
    }
	otherlv_8=']' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getOptMethodAccess().getRightSquareBracketKeyword_6());
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
	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getBehaviorAccess().getLeftParenthesisKeyword_2());
    }
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getBehaviorRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getBehaviorAccess().getCallMethodCrossReference_3_0_0()); 
	    }
		ruleFQN		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4='->' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getBehaviorAccess().getHyphenMinusGreaterThanSignKeyword_3_1_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getBehaviorRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getBehaviorAccess().getCallMethodCrossReference_3_1_1_0()); 
	    }
		ruleFQN		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_6='->' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getBehaviorAccess().getHyphenMinusGreaterThanSignKeyword_3_2());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getBehaviorRule());
	        }
        }
	otherlv_7=RULE_ID
	{
		newLeafNode(otherlv_7, grammarAccess.getBehaviorAccess().getEndInterfaceCrossReference_3_3_0()); 
	}

)
))?	otherlv_8=');' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getBehaviorAccess().getRightParenthesisSemicolonKeyword_4());
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


