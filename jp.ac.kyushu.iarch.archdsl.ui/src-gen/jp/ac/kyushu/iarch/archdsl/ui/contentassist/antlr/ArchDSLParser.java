/*
* generated by Xtext
*/
package jp.ac.kyushu.iarch.archdsl.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import jp.ac.kyushu.iarch.archdsl.services.ArchDSLGrammarAccess;

public class ArchDSLParser extends AbstractContentAssistParser {
	
	@Inject
	private ArchDSLGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected jp.ac.kyushu.iarch.archdsl.ui.contentassist.antlr.internal.InternalArchDSLParser createParser() {
		jp.ac.kyushu.iarch.archdsl.ui.contentassist.antlr.internal.InternalArchDSLParser result = new jp.ac.kyushu.iarch.archdsl.ui.contentassist.antlr.internal.InternalArchDSLParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
					put(grammarAccess.getInterfaceAccess().getGroup(), "rule__Interface__Group__0");
					put(grammarAccess.getMethodAccess().getGroup(), "rule__Method__Group__0");
					put(grammarAccess.getMethodAccess().getGroup_3(), "rule__Method__Group_3__0");
					put(grammarAccess.getMethodAccess().getGroup_3_1(), "rule__Method__Group_3_1__0");
					put(grammarAccess.getParamAccess().getGroup(), "rule__Param__Group__0");
					put(grammarAccess.getDflowAccess().getGroup(), "rule__Dflow__Group__0");
					put(grammarAccess.getDfaAccess().getGroup(), "rule__Dfa__Group__0");
					put(grammarAccess.getBehaviorAccess().getGroup(), "rule__Behavior__Group__0");
					put(grammarAccess.getBehaviorAccess().getGroup_3(), "rule__Behavior__Group_3__0");
					put(grammarAccess.getBehaviorAccess().getGroup_3_1(), "rule__Behavior__Group_3_1__0");
					put(grammarAccess.getDataflowAccess().getGroup(), "rule__Dataflow__Group__0");
					put(grammarAccess.getDataflowAccess().getGroup_3(), "rule__Dataflow__Group_3__0");
					put(grammarAccess.getDataflowAccess().getGroup_3_3(), "rule__Dataflow__Group_3_3__0");
					put(grammarAccess.getDataflowAccess().getGroup_3_3_2(), "rule__Dataflow__Group_3_3_2__0");
					put(grammarAccess.getDataflowAccess().getGroup_3_4(), "rule__Dataflow__Group_3_4__0");
					put(grammarAccess.getDataflowAccess().getGroup_3_4_2(), "rule__Dataflow__Group_3_4_2__0");
					put(grammarAccess.getDataflowAccess().getGroup_3_5(), "rule__Dataflow__Group_3_5__0");
					put(grammarAccess.getDataflowAccess().getGroup_3_5_2(), "rule__Dataflow__Group_3_5_2__0");
					put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
					put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
					put(grammarAccess.getModelAccess().getInterfacesAssignment_0(), "rule__Model__InterfacesAssignment_0");
					put(grammarAccess.getModelAccess().getBehaviorsAssignment_1(), "rule__Model__BehaviorsAssignment_1");
					put(grammarAccess.getModelAccess().getDflowsAssignment_2(), "rule__Model__DflowsAssignment_2");
					put(grammarAccess.getModelAccess().getDfasAssignment_3(), "rule__Model__DfasAssignment_3");
					put(grammarAccess.getModelAccess().getDataflowsAssignment_4(), "rule__Model__DataflowsAssignment_4");
					put(grammarAccess.getInterfaceAccess().getNameAssignment_1(), "rule__Interface__NameAssignment_1");
					put(grammarAccess.getInterfaceAccess().getMethodsAssignment_3(), "rule__Interface__MethodsAssignment_3");
					put(grammarAccess.getMethodAccess().getTypeAssignment_0(), "rule__Method__TypeAssignment_0");
					put(grammarAccess.getMethodAccess().getNameAssignment_1(), "rule__Method__NameAssignment_1");
					put(grammarAccess.getMethodAccess().getParamAssignment_3_0(), "rule__Method__ParamAssignment_3_0");
					put(grammarAccess.getMethodAccess().getParamAssignment_3_1_1(), "rule__Method__ParamAssignment_3_1_1");
					put(grammarAccess.getParamAccess().getTypeAssignment_0(), "rule__Param__TypeAssignment_0");
					put(grammarAccess.getParamAccess().getNameAssignment_1(), "rule__Param__NameAssignment_1");
					put(grammarAccess.getDflowAccess().getNameAssignment_1(), "rule__Dflow__NameAssignment_1");
					put(grammarAccess.getDfaAccess().getNameAssignment_1(), "rule__Dfa__NameAssignment_1");
					put(grammarAccess.getBehaviorAccess().getInterfaceAssignment_0(), "rule__Behavior__InterfaceAssignment_0");
					put(grammarAccess.getBehaviorAccess().getCallAssignment_3_0(), "rule__Behavior__CallAssignment_3_0");
					put(grammarAccess.getBehaviorAccess().getCallAssignment_3_1_1(), "rule__Behavior__CallAssignment_3_1_1");
					put(grammarAccess.getBehaviorAccess().getEndAssignment_3_3(), "rule__Behavior__EndAssignment_3_3");
					put(grammarAccess.getDataflowAccess().getDfaAssignment_0(), "rule__Dataflow__DfaAssignment_0");
					put(grammarAccess.getDataflowAccess().getGetflowAssignment_3_1(), "rule__Dataflow__GetflowAssignment_3_1");
					put(grammarAccess.getDataflowAccess().getCallAssignment_3_3_1(), "rule__Dataflow__CallAssignment_3_3_1");
					put(grammarAccess.getDataflowAccess().getGetflowAssignment_3_3_2_2(), "rule__Dataflow__GetflowAssignment_3_3_2_2");
					put(grammarAccess.getDataflowAccess().getGetIfAssignment_3_4_1(), "rule__Dataflow__GetIfAssignment_3_4_1");
					put(grammarAccess.getDataflowAccess().getGetflowAssignment_3_4_2_2(), "rule__Dataflow__GetflowAssignment_3_4_2_2");
					put(grammarAccess.getDataflowAccess().getCallAssignment_3_5_1(), "rule__Dataflow__CallAssignment_3_5_1");
					put(grammarAccess.getDataflowAccess().getGetflowAssignment_3_5_2_2(), "rule__Dataflow__GetflowAssignment_3_5_2_2");
					put(grammarAccess.getDataflowAccess().getEndAssignment_3_7(), "rule__Dataflow__EndAssignment_3_7");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			jp.ac.kyushu.iarch.archdsl.ui.contentassist.antlr.internal.InternalArchDSLParser typedParser = (jp.ac.kyushu.iarch.archdsl.ui.contentassist.antlr.internal.InternalArchDSLParser) parser;
			typedParser.entryRuleModel();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public ArchDSLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(ArchDSLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
