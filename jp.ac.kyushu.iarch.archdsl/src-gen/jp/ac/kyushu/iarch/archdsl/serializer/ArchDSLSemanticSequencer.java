package jp.ac.kyushu.iarch.archdsl.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import jp.ac.kyushu.iarch.archdsl.archDSL.AltCall;
import jp.ac.kyushu.iarch.archdsl.archDSL.AltMethod;
import jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage;
import jp.ac.kyushu.iarch.archdsl.archDSL.Behavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.CertainCall;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.archdsl.archDSL.OptCall;
import jp.ac.kyushu.iarch.archdsl.archDSL.OptMethod;
import jp.ac.kyushu.iarch.archdsl.archDSL.Param;
import jp.ac.kyushu.iarch.archdsl.archDSL.UncertainBehavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.UncertainInterface;
import jp.ac.kyushu.iarch.archdsl.services.ArchDSLGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class ArchDSLSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ArchDSLGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ArchDSLPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ArchDSLPackage.ALT_CALL:
				if(context == grammarAccess.getAltCallRule() ||
				   context == grammarAccess.getSuperCallRule()) {
					sequence_AltCall(context, (AltCall) semanticObject); 
					return; 
				}
				else break;
			case ArchDSLPackage.ALT_METHOD:
				if(context == grammarAccess.getAltMethodRule() ||
				   context == grammarAccess.getSuperMethodRule()) {
					sequence_AltMethod(context, (AltMethod) semanticObject); 
					return; 
				}
				else break;
			case ArchDSLPackage.BEHAVIOR:
				if(context == grammarAccess.getBehaviorRule()) {
					sequence_Behavior(context, (Behavior) semanticObject); 
					return; 
				}
				else break;
			case ArchDSLPackage.CERTAIN_CALL:
				if(context == grammarAccess.getCertainCallRule() ||
				   context == grammarAccess.getSuperCallRule()) {
					sequence_CertainCall(context, (CertainCall) semanticObject); 
					return; 
				}
				else break;
			case ArchDSLPackage.INTERFACE:
				if(context == grammarAccess.getInterfaceRule()) {
					sequence_Interface(context, (Interface) semanticObject); 
					return; 
				}
				else break;
			case ArchDSLPackage.METHOD:
				if(context == grammarAccess.getMethodRule() ||
				   context == grammarAccess.getSuperMethodRule()) {
					sequence_Method(context, (Method) semanticObject); 
					return; 
				}
				else break;
			case ArchDSLPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case ArchDSLPackage.OPT_CALL:
				if(context == grammarAccess.getOptCallRule() ||
				   context == grammarAccess.getSuperCallRule()) {
					sequence_OptCall(context, (OptCall) semanticObject); 
					return; 
				}
				else break;
			case ArchDSLPackage.OPT_METHOD:
				if(context == grammarAccess.getOptMethodRule() ||
				   context == grammarAccess.getSuperMethodRule()) {
					sequence_OptMethod(context, (OptMethod) semanticObject); 
					return; 
				}
				else break;
			case ArchDSLPackage.PARAM:
				if(context == grammarAccess.getParamRule()) {
					sequence_Param(context, (Param) semanticObject); 
					return; 
				}
				else break;
			case ArchDSLPackage.UNCERTAIN_BEHAVIOR:
				if(context == grammarAccess.getUncertainBehaviorRule()) {
					sequence_UncertainBehavior(context, (UncertainBehavior) semanticObject); 
					return; 
				}
				else break;
			case ArchDSLPackage.UNCERTAIN_INTERFACE:
				if(context == grammarAccess.getUncertainInterfaceRule()) {
					sequence_UncertainInterface(context, (UncertainInterface) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (opt?='null'? name=[SuperMethod|FQN] (a_name+=[SuperMethod|FQN] | opt?='null'?)*)
	 */
	protected void sequence_AltCall(EObject context, AltCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type+=ID name=ID (param+=Param param+=Param*)? (type+=ID a_name+=ID (param+=Param param+=Param*)?)*)
	 */
	protected void sequence_AltMethod(EObject context, AltMethod semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (interface=[Interface|ID] (call+=[Method|FQN] call+=[Method|FQN]* end=[Interface|ID])?)
	 */
	protected void sequence_Behavior(EObject context, Behavior semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=[SuperMethod|FQN]
	 */
	protected void sequence_CertainCall(EObject context, CertainCall semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ArchDSLPackage.Literals.SUPER_CALL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ArchDSLPackage.Literals.SUPER_CALL__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCertainCallAccess().getNameSuperMethodFQNParserRuleCall_0_1(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID methods+=Method*)
	 */
	protected void sequence_Interface(EObject context, Interface semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=ID name=ID (param+=Param param+=Param*)?)
	 */
	protected void sequence_Method(EObject context, Method semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((interfaces+=Interface | u_interfaces+=UncertainInterface)* (behaviors+=Behavior | u_behaviors+=UncertainBehavior)*)
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=[SuperMethod|FQN]
	 */
	protected void sequence_OptCall(EObject context, OptCall semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ArchDSLPackage.Literals.SUPER_CALL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ArchDSLPackage.Literals.SUPER_CALL__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOptCallAccess().getNameSuperMethodFQNParserRuleCall_1_0_1(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (type=ID name=ID (param+=Param param+=Param*)?)
	 */
	protected void sequence_OptMethod(EObject context, OptMethod semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=ID name=ID)
	 */
	protected void sequence_Param(EObject context, Param semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ArchDSLPackage.Literals.PARAM__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ArchDSLPackage.Literals.PARAM__TYPE));
			if(transientValues.isValueTransient(semanticObject, ArchDSLPackage.Literals.PARAM__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ArchDSLPackage.Literals.PARAM__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getParamAccess().getTypeIDTerminalRuleCall_0_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getParamAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID superInterface=[Interface|ID]? (call+=SuperCall call+=SuperCall* end=[Interface|ID])?)
	 */
	protected void sequence_UncertainBehavior(EObject context, UncertainBehavior semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID superInterface=[Interface|ID]? (altmethods+=AltMethod | optmethods+=OptMethod)*)
	 */
	protected void sequence_UncertainInterface(EObject context, UncertainInterface semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
