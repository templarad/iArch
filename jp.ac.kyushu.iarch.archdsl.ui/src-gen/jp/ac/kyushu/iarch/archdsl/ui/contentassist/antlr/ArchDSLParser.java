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
					put(grammarAccess.getConnectorAccess().getGroup(), "rule__Connector__Group__0");
					put(grammarAccess.getConnectorAccess().getGroup_3(), "rule__Connector__Group_3__0");
					put(grammarAccess.getConnectorAccess().getGroup_3_1(), "rule__Connector__Group_3_1__0");
					put(grammarAccess.getBehaviorAccess().getGroup(), "rule__Behavior__Group__0");
					put(grammarAccess.getBehaviorAccess().getGroup_2(), "rule__Behavior__Group_2__0");
					put(grammarAccess.getBehaviorAccess().getGroup_2_1(), "rule__Behavior__Group_2_1__0");
					put(grammarAccess.getDFlowAccess().getGroup(), "rule__DFlow__Group__0");
					put(grammarAccess.getDFlowAccess().getGroup_3(), "rule__DFlow__Group_3__0");
					put(grammarAccess.getDFlowAccess().getGroup_3_1(), "rule__DFlow__Group_3_1__0");
					put(grammarAccess.getDataflowAccess().getGroup(), "rule__Dataflow__Group__0");
					put(grammarAccess.getDataflowAccess().getGroup_2(), "rule__Dataflow__Group_2__0");
					put(grammarAccess.getDataflowAccess().getGroup_2_11(), "rule__Dataflow__Group_2_11__0");
					put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
					put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
					put(grammarAccess.getModelAccess().getInterfacesAssignment_0(), "rule__Model__InterfacesAssignment_0");
					put(grammarAccess.getModelAccess().getBehaviorsAssignment_1(), "rule__Model__BehaviorsAssignment_1");
					put(grammarAccess.getModelAccess().getConnectorsAssignment_2(), "rule__Model__ConnectorsAssignment_2");
					put(grammarAccess.getModelAccess().getDflowsAssignment_3(), "rule__Model__DflowsAssignment_3");
					put(grammarAccess.getInterfaceAccess().getNameAssignment_1(), "rule__Interface__NameAssignment_1");
					put(grammarAccess.getInterfaceAccess().getMethodsAssignment_3(), "rule__Interface__MethodsAssignment_3");
					put(grammarAccess.getMethodAccess().getTypeAssignment_0(), "rule__Method__TypeAssignment_0");
					put(grammarAccess.getMethodAccess().getNameAssignment_1(), "rule__Method__NameAssignment_1");
					put(grammarAccess.getMethodAccess().getParamAssignment_3_0(), "rule__Method__ParamAssignment_3_0");
					put(grammarAccess.getMethodAccess().getParamAssignment_3_1_1(), "rule__Method__ParamAssignment_3_1_1");
					put(grammarAccess.getParamAccess().getTypeAssignment_0(), "rule__Param__TypeAssignment_0");
					put(grammarAccess.getParamAccess().getNameAssignment_1(), "rule__Param__NameAssignment_1");
					put(grammarAccess.getCParamAccess().getNameAssignment(), "rule__CParam__NameAssignment");
					put(grammarAccess.getDParamAccess().getNameAssignment(), "rule__DParam__NameAssignment");
					put(grammarAccess.getConnectorAccess().getNameAssignment_1(), "rule__Connector__NameAssignment_1");
					put(grammarAccess.getConnectorAccess().getCparamAssignment_3_0(), "rule__Connector__CparamAssignment_3_0");
					put(grammarAccess.getConnectorAccess().getCparamAssignment_3_1_1(), "rule__Connector__CparamAssignment_3_1_1");
					put(grammarAccess.getConnectorAccess().getBehaviorsAssignment_6(), "rule__Connector__BehaviorsAssignment_6");
					put(grammarAccess.getBehaviorAccess().getInterfaceAssignment_0(), "rule__Behavior__InterfaceAssignment_0");
					put(grammarAccess.getBehaviorAccess().getCallAssignment_2_0(), "rule__Behavior__CallAssignment_2_0");
					put(grammarAccess.getBehaviorAccess().getCallAssignment_2_1_1(), "rule__Behavior__CallAssignment_2_1_1");
					put(grammarAccess.getBehaviorAccess().getEndAssignment_2_3(), "rule__Behavior__EndAssignment_2_3");
					put(grammarAccess.getDFlowAccess().getNameAssignment_1(), "rule__DFlow__NameAssignment_1");
					put(grammarAccess.getDFlowAccess().getDparamAssignment_3_0(), "rule__DFlow__DparamAssignment_3_0");
					put(grammarAccess.getDFlowAccess().getDparamAssignment_3_1_1(), "rule__DFlow__DparamAssignment_3_1_1");
					put(grammarAccess.getDFlowAccess().getDataflowsAssignment_6(), "rule__DFlow__DataflowsAssignment_6");
					put(grammarAccess.getDataflowAccess().getDparamAssignment_0(), "rule__Dataflow__DparamAssignment_0");
					put(grammarAccess.getDataflowAccess().getGetflowAssignment_2_1(), "rule__Dataflow__GetflowAssignment_2_1");
					put(grammarAccess.getDataflowAccess().getCallAssignment_2_4(), "rule__Dataflow__CallAssignment_2_4");
					put(grammarAccess.getDataflowAccess().getGetflowAssignment_2_7(), "rule__Dataflow__GetflowAssignment_2_7");
					put(grammarAccess.getDataflowAccess().getGetIfAssignment_2_10(), "rule__Dataflow__GetIfAssignment_2_10");
					put(grammarAccess.getDataflowAccess().getGetflowAssignment_2_11_2(), "rule__Dataflow__GetflowAssignment_2_11_2");
					put(grammarAccess.getDataflowAccess().getCallAssignment_2_11_5(), "rule__Dataflow__CallAssignment_2_11_5");
					put(grammarAccess.getDataflowAccess().getEndAssignment_2_13(), "rule__Dataflow__EndAssignment_2_13");
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
