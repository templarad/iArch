package jp.ac.kyushu.iarch.archdsl.serializer;

import com.google.inject.Inject;
import java.util.List;
import jp.ac.kyushu.iarch.archdsl.services.ArchDSLGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class ArchDSLSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ArchDSLGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AltCall_CommaKeyword_3_0_a;
	protected AbstractElementAlias match_AltCall_CommaKeyword_3_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ArchDSLGrammarAccess) access;
		match_AltCall_CommaKeyword_3_0_a = new TokenAlias(true, true, grammarAccess.getAltCallAccess().getCommaKeyword_3_0());
		match_AltCall_CommaKeyword_3_0_p = new TokenAlias(true, false, grammarAccess.getAltCallAccess().getCommaKeyword_3_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_AltCall_CommaKeyword_3_0_a.equals(syntax))
				emit_AltCall_CommaKeyword_3_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AltCall_CommaKeyword_3_0_p.equals(syntax))
				emit_AltCall_CommaKeyword_3_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ','*
	 */
	protected void emit_AltCall_CommaKeyword_3_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ','+
	 */
	protected void emit_AltCall_CommaKeyword_3_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
