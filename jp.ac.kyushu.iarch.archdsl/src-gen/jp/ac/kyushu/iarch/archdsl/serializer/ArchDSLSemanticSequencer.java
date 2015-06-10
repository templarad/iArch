package jp.ac.kyushu.iarch.archdsl.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import jp.ac.kyushu.iarch.archdsl.archDSL.ArchDSLPackage;
import jp.ac.kyushu.iarch.archdsl.archDSL.Behavior;
import jp.ac.kyushu.iarch.archdsl.archDSL.Connector;
import jp.ac.kyushu.iarch.archdsl.archDSL.DFlow;
import jp.ac.kyushu.iarch.archdsl.archDSL.Dataflow;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.archdsl.archDSL.Param;
import jp.ac.kyushu.iarch.archdsl.archDSL.StateNotification;
import jp.ac.kyushu.iarch.archdsl.archDSL.cParam;
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
			case ArchDSLPackage.BEHAVIOR:
				if(context == grammarAccess.getBehaviorRule()) {
					sequence_Behavior(context, (Behavior) semanticObject); 
					return; 
				}
				else break;
			case ArchDSLPackage.CONNECTOR:
				if(context == grammarAccess.getConnectorRule()) {
					sequence_Connector(context, (Connector) semanticObject); 
					return; 
				}
				else break;
			case ArchDSLPackage.DFLOW:
				if(context == grammarAccess.getDFlowRule()) {
					sequence_DFlow(context, (DFlow) semanticObject); 
					return; 
				}
				else break;
			case ArchDSLPackage.DATAFLOW:
				if(context == grammarAccess.getDataflowRule()) {
					sequence_Dataflow(context, (Dataflow) semanticObject); 
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
				if(context == grammarAccess.getMethodRule()) {
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
			case ArchDSLPackage.PARAM:
				if(context == grammarAccess.getParamRule()) {
					sequence_Param(context, (Param) semanticObject); 
					return; 
				}
				else break;
			case ArchDSLPackage.STATE_NOTIFICATION:
				if(context == grammarAccess.getStateNotificationRule()) {
					sequence_StateNotification(context, (StateNotification) semanticObject); 
					return; 
				}
				else break;
			case ArchDSLPackage.CPARAM:
				if(context == grammarAccess.getCParamRule()) {
					sequence_cParam(context, (cParam) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
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
	 *     (name=ID (cparam+=cParam cparam+=cParam*)? behaviors+=Behavior*)
	 */
	protected void sequence_Connector(EObject context, Connector semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (cparam+=cParam cparam+=cParam*)? dataflows+=Dataflow*)
	 */
	protected void sequence_DFlow(EObject context, DFlow semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         statenotification=[StateNotification|ID] 
	 *         (
	 *             getflow+=[Param|ID] 
	 *             call+=[Method|FQN] 
	 *             getflow+=[Param|ID] 
	 *             getIf+=[Interface|ID] 
	 *             getflow+=[Param|ID] 
	 *             call+=[Method|FQN] 
	 *             getflow+=[Param|ID] 
	 *             call+=[Method|FQN] 
	 *             end=[StateNotification|ID]
	 *         )?
	 *     )
	 */
	protected void sequence_Dataflow(EObject context, Dataflow semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
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
	 *     (interfaces+=Interface* behaviors+=Behavior* connectors+=Connector* dflows+=DFlow* statenotificaions+=StateNotification*)
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
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
	 *     name=ID
	 */
	protected void sequence_StateNotification(EObject context, StateNotification semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ArchDSLPackage.Literals.STATE_NOTIFICATION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ArchDSLPackage.Literals.STATE_NOTIFICATION__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStateNotificationAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_cParam(EObject context, cParam semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ArchDSLPackage.Literals.CPARAM__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ArchDSLPackage.Literals.CPARAM__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCParamAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
}
