/*
* generated by Xtext
*/
package jp.ac.kyushu.iarch.archdsl.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class ArchDSLGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class ModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Model");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cInterfacesAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cInterfacesInterfaceParserRuleCall_0_0 = (RuleCall)cInterfacesAssignment_0.eContents().get(0);
		private final Assignment cBehaviorsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cBehaviorsBehaviorParserRuleCall_1_0 = (RuleCall)cBehaviorsAssignment_1.eContents().get(0);
		
		//Model:
		//	interfaces+=Interface* behaviors+=Behavior*;
		public ParserRule getRule() { return rule; }

		//interfaces+=Interface* behaviors+=Behavior*
		public Group getGroup() { return cGroup; }

		//interfaces+=Interface*
		public Assignment getInterfacesAssignment_0() { return cInterfacesAssignment_0; }

		//Interface
		public RuleCall getInterfacesInterfaceParserRuleCall_0_0() { return cInterfacesInterfaceParserRuleCall_0_0; }

		//behaviors+=Behavior*
		public Assignment getBehaviorsAssignment_1() { return cBehaviorsAssignment_1; }

		//Behavior
		public RuleCall getBehaviorsBehaviorParserRuleCall_1_0() { return cBehaviorsBehaviorParserRuleCall_1_0; }
	}

	public class InterfaceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Interface");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cInterfaceComponentKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cMethodsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cMethodsMethodParserRuleCall_3_0 = (RuleCall)cMethodsAssignment_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//Interface:
		//	"interface component" name=ID "{" methods+=Method* "}";
		public ParserRule getRule() { return rule; }

		//"interface component" name=ID "{" methods+=Method* "}"
		public Group getGroup() { return cGroup; }

		//"interface component"
		public Keyword getInterfaceComponentKeyword_0() { return cInterfaceComponentKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }

		//methods+=Method*
		public Assignment getMethodsAssignment_3() { return cMethodsAssignment_3; }

		//Method
		public RuleCall getMethodsMethodParserRuleCall_3_0() { return cMethodsMethodParserRuleCall_3_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}

	public class MethodElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Method");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cTypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cTypeIDTerminalRuleCall_0_0 = (RuleCall)cTypeAssignment_0.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cParamAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cParamParamParserRuleCall_3_0_0 = (RuleCall)cParamAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cParamAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cParamParamParserRuleCall_3_1_1_0 = (RuleCall)cParamAssignment_3_1_1.eContents().get(0);
		private final Keyword cRightParenthesisSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//Method:
		//	type=ID name=ID "(" (param+=Param ("," param+=Param)*)? ");";
		public ParserRule getRule() { return rule; }

		//type=ID name=ID "(" (param+=Param ("," param+=Param)*)? ");"
		public Group getGroup() { return cGroup; }

		//type=ID
		public Assignment getTypeAssignment_0() { return cTypeAssignment_0; }

		//ID
		public RuleCall getTypeIDTerminalRuleCall_0_0() { return cTypeIDTerminalRuleCall_0_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }

		//(param+=Param ("," param+=Param)*)?
		public Group getGroup_3() { return cGroup_3; }

		//param+=Param
		public Assignment getParamAssignment_3_0() { return cParamAssignment_3_0; }

		//Param
		public RuleCall getParamParamParserRuleCall_3_0_0() { return cParamParamParserRuleCall_3_0_0; }

		//("," param+=Param)*
		public Group getGroup_3_1() { return cGroup_3_1; }

		//","
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }

		//param+=Param
		public Assignment getParamAssignment_3_1_1() { return cParamAssignment_3_1_1; }

		//Param
		public RuleCall getParamParamParserRuleCall_3_1_1_0() { return cParamParamParserRuleCall_3_1_1_0; }

		//");"
		public Keyword getRightParenthesisSemicolonKeyword_4() { return cRightParenthesisSemicolonKeyword_4; }
	}

	public class ParamElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Param");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cTypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cTypeIDTerminalRuleCall_0_0 = (RuleCall)cTypeAssignment_0.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//Param:
		//	type=ID name=ID;
		public ParserRule getRule() { return rule; }

		//type=ID name=ID
		public Group getGroup() { return cGroup; }

		//type=ID
		public Assignment getTypeAssignment_0() { return cTypeAssignment_0; }

		//ID
		public RuleCall getTypeIDTerminalRuleCall_0_0() { return cTypeIDTerminalRuleCall_0_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}

	public class BehaviorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Behavior");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cInterfaceAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cInterfaceInterfaceCrossReference_0_0 = (CrossReference)cInterfaceAssignment_0.eContents().get(0);
		private final RuleCall cInterfaceInterfaceIDTerminalRuleCall_0_0_1 = (RuleCall)cInterfaceInterfaceCrossReference_0_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cCallAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final CrossReference cCallMethodCrossReference_3_0_0 = (CrossReference)cCallAssignment_3_0.eContents().get(0);
		private final RuleCall cCallMethodFQNParserRuleCall_3_0_0_1 = (RuleCall)cCallMethodCrossReference_3_0_0.eContents().get(1);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cCallAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final CrossReference cCallMethodCrossReference_3_1_1_0 = (CrossReference)cCallAssignment_3_1_1.eContents().get(0);
		private final RuleCall cCallMethodFQNParserRuleCall_3_1_1_0_1 = (RuleCall)cCallMethodCrossReference_3_1_1_0.eContents().get(1);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		private final Assignment cEndAssignment_3_3 = (Assignment)cGroup_3.eContents().get(3);
		private final CrossReference cEndInterfaceCrossReference_3_3_0 = (CrossReference)cEndAssignment_3_3.eContents().get(0);
		private final RuleCall cEndInterfaceIDTerminalRuleCall_3_3_0_1 = (RuleCall)cEndInterfaceCrossReference_3_3_0.eContents().get(1);
		private final Keyword cRightParenthesisSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//Behavior:
		//	interface=[Interface] "=" "(" (call+=[Method|FQN] ("->" call+=[Method|FQN])* "->" end=[Interface])? ");";
		public ParserRule getRule() { return rule; }

		//interface=[Interface] "=" "(" (call+=[Method|FQN] ("->" call+=[Method|FQN])* "->" end=[Interface])? ");"
		public Group getGroup() { return cGroup; }

		//interface=[Interface]
		public Assignment getInterfaceAssignment_0() { return cInterfaceAssignment_0; }

		//[Interface]
		public CrossReference getInterfaceInterfaceCrossReference_0_0() { return cInterfaceInterfaceCrossReference_0_0; }

		//ID
		public RuleCall getInterfaceInterfaceIDTerminalRuleCall_0_0_1() { return cInterfaceInterfaceIDTerminalRuleCall_0_0_1; }

		//"="
		public Keyword getEqualsSignKeyword_1() { return cEqualsSignKeyword_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }

		//(call+=[Method|FQN] ("->" call+=[Method|FQN])* "->" end=[Interface])?
		public Group getGroup_3() { return cGroup_3; }

		//call+=[Method|FQN]
		public Assignment getCallAssignment_3_0() { return cCallAssignment_3_0; }

		//[Method|FQN]
		public CrossReference getCallMethodCrossReference_3_0_0() { return cCallMethodCrossReference_3_0_0; }

		//FQN
		public RuleCall getCallMethodFQNParserRuleCall_3_0_0_1() { return cCallMethodFQNParserRuleCall_3_0_0_1; }

		//("->" call+=[Method|FQN])*
		public Group getGroup_3_1() { return cGroup_3_1; }

		//"->"
		public Keyword getHyphenMinusGreaterThanSignKeyword_3_1_0() { return cHyphenMinusGreaterThanSignKeyword_3_1_0; }

		//call+=[Method|FQN]
		public Assignment getCallAssignment_3_1_1() { return cCallAssignment_3_1_1; }

		//[Method|FQN]
		public CrossReference getCallMethodCrossReference_3_1_1_0() { return cCallMethodCrossReference_3_1_1_0; }

		//FQN
		public RuleCall getCallMethodFQNParserRuleCall_3_1_1_0_1() { return cCallMethodFQNParserRuleCall_3_1_1_0_1; }

		//"->"
		public Keyword getHyphenMinusGreaterThanSignKeyword_3_2() { return cHyphenMinusGreaterThanSignKeyword_3_2; }

		//end=[Interface]
		public Assignment getEndAssignment_3_3() { return cEndAssignment_3_3; }

		//[Interface]
		public CrossReference getEndInterfaceCrossReference_3_3_0() { return cEndInterfaceCrossReference_3_3_0; }

		//ID
		public RuleCall getEndInterfaceIDTerminalRuleCall_3_3_0_1() { return cEndInterfaceIDTerminalRuleCall_3_3_0_1; }

		//");"
		public Keyword getRightParenthesisSemicolonKeyword_4() { return cRightParenthesisSemicolonKeyword_4; }
	}

	public class FQNElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "FQN");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//FQN:
		//	ID ("." ID)*;
		public ParserRule getRule() { return rule; }

		//ID ("." ID)*
		public Group getGroup() { return cGroup; }

		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }

		//("." ID)*
		public Group getGroup_1() { return cGroup_1; }

		//"."
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	
	
	private final ModelElements pModel;
	private final InterfaceElements pInterface;
	private final MethodElements pMethod;
	private final ParamElements pParam;
	private final BehaviorElements pBehavior;
	private final FQNElements pFQN;
	
	private final Grammar grammar;

	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public ArchDSLGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pModel = new ModelElements();
		this.pInterface = new InterfaceElements();
		this.pMethod = new MethodElements();
		this.pParam = new ParamElements();
		this.pBehavior = new BehaviorElements();
		this.pFQN = new FQNElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("jp.ac.kyushu.iarch.archdsl.ArchDSL".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	
	public Grammar getGrammar() {
		return grammar;
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Model:
	//	interfaces+=Interface* behaviors+=Behavior*;
	public ModelElements getModelAccess() {
		return pModel;
	}
	
	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}

	//Interface:
	//	"interface component" name=ID "{" methods+=Method* "}";
	public InterfaceElements getInterfaceAccess() {
		return pInterface;
	}
	
	public ParserRule getInterfaceRule() {
		return getInterfaceAccess().getRule();
	}

	//Method:
	//	type=ID name=ID "(" (param+=Param ("," param+=Param)*)? ");";
	public MethodElements getMethodAccess() {
		return pMethod;
	}
	
	public ParserRule getMethodRule() {
		return getMethodAccess().getRule();
	}

	//Param:
	//	type=ID name=ID;
	public ParamElements getParamAccess() {
		return pParam;
	}
	
	public ParserRule getParamRule() {
		return getParamAccess().getRule();
	}

	//Behavior:
	//	interface=[Interface] "=" "(" (call+=[Method|FQN] ("->" call+=[Method|FQN])* "->" end=[Interface])? ");";
	public BehaviorElements getBehaviorAccess() {
		return pBehavior;
	}
	
	public ParserRule getBehaviorRule() {
		return getBehaviorAccess().getRule();
	}

	//FQN:
	//	ID ("." ID)*;
	public FQNElements getFQNAccess() {
		return pFQN;
	}
	
	public ParserRule getFQNRule() {
		return getFQNAccess().getRule();
	}

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" . / * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\""))* "\"" | "\'" ("\\" .
	//	/ * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
