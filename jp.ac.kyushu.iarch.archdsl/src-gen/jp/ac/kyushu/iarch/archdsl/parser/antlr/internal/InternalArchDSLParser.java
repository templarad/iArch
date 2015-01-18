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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalArchDSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'interface component'", "'{'", "'}'", "'('", "','", "');'", "'Dflow data'", "';'", "'Dfa'", "'='", "'->'", "'['", "'|'", "'->>'", "'];'", "'.'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int RULE_INT=5;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalArchDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalArchDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalArchDSLParser.tokenNames; }
    public String getGrammarFileName() { return "../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g"; }



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



    // $ANTLR start "entryRuleModel"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:76:1: ruleModel returns [EObject current=null] : ( ( (lv_interfaces_0_0= ruleInterface ) )* ( (lv_behaviors_1_0= ruleBehavior ) )* ( (lv_dflows_2_0= ruleDflow ) )* ( (lv_dfas_3_0= ruleDfa ) )* ( (lv_dataflows_4_0= ruleDataflow ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_interfaces_0_0 = null;

        EObject lv_behaviors_1_0 = null;

        EObject lv_dflows_2_0 = null;

        EObject lv_dfas_3_0 = null;

        EObject lv_dataflows_4_0 = null;


         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:79:28: ( ( ( (lv_interfaces_0_0= ruleInterface ) )* ( (lv_behaviors_1_0= ruleBehavior ) )* ( (lv_dflows_2_0= ruleDflow ) )* ( (lv_dfas_3_0= ruleDfa ) )* ( (lv_dataflows_4_0= ruleDataflow ) )* ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:80:1: ( ( (lv_interfaces_0_0= ruleInterface ) )* ( (lv_behaviors_1_0= ruleBehavior ) )* ( (lv_dflows_2_0= ruleDflow ) )* ( (lv_dfas_3_0= ruleDfa ) )* ( (lv_dataflows_4_0= ruleDataflow ) )* )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:80:1: ( ( (lv_interfaces_0_0= ruleInterface ) )* ( (lv_behaviors_1_0= ruleBehavior ) )* ( (lv_dflows_2_0= ruleDflow ) )* ( (lv_dfas_3_0= ruleDfa ) )* ( (lv_dataflows_4_0= ruleDataflow ) )* )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:80:2: ( (lv_interfaces_0_0= ruleInterface ) )* ( (lv_behaviors_1_0= ruleBehavior ) )* ( (lv_dflows_2_0= ruleDflow ) )* ( (lv_dfas_3_0= ruleDfa ) )* ( (lv_dataflows_4_0= ruleDataflow ) )*
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:80:2: ( (lv_interfaces_0_0= ruleInterface ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:81:1: (lv_interfaces_0_0= ruleInterface )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:81:1: (lv_interfaces_0_0= ruleInterface )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:82:3: lv_interfaces_0_0= ruleInterface
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getInterfacesInterfaceParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInterface_in_ruleModel131);
            	    lv_interfaces_0_0=ruleInterface();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"interfaces",
            	            		lv_interfaces_0_0, 
            	            		"Interface");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:98:3: ( (lv_behaviors_1_0= ruleBehavior ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    int LA2_2 = input.LA(2);

                    if ( (LA2_2==20) ) {
                        int LA2_3 = input.LA(3);

                        if ( (LA2_3==14) ) {
                            alt2=1;
                        }


                    }


                }


                switch (alt2) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:99:1: (lv_behaviors_1_0= ruleBehavior )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:99:1: (lv_behaviors_1_0= ruleBehavior )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:100:3: lv_behaviors_1_0= ruleBehavior
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getBehaviorsBehaviorParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleBehavior_in_ruleModel153);
            	    lv_behaviors_1_0=ruleBehavior();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"behaviors",
            	            		lv_behaviors_1_0, 
            	            		"Behavior");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:116:3: ( (lv_dflows_2_0= ruleDflow ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==17) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:117:1: (lv_dflows_2_0= ruleDflow )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:117:1: (lv_dflows_2_0= ruleDflow )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:118:3: lv_dflows_2_0= ruleDflow
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getDflowsDflowParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDflow_in_ruleModel175);
            	    lv_dflows_2_0=ruleDflow();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"dflows",
            	            		lv_dflows_2_0, 
            	            		"Dflow");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:134:3: ( (lv_dfas_3_0= ruleDfa ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==19) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:135:1: (lv_dfas_3_0= ruleDfa )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:135:1: (lv_dfas_3_0= ruleDfa )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:136:3: lv_dfas_3_0= ruleDfa
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getDfasDfaParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDfa_in_ruleModel197);
            	    lv_dfas_3_0=ruleDfa();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"dfas",
            	            		lv_dfas_3_0, 
            	            		"Dfa");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:152:3: ( (lv_dataflows_4_0= ruleDataflow ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:153:1: (lv_dataflows_4_0= ruleDataflow )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:153:1: (lv_dataflows_4_0= ruleDataflow )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:154:3: lv_dataflows_4_0= ruleDataflow
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getDataflowsDataflowParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDataflow_in_ruleModel219);
            	    lv_dataflows_4_0=ruleDataflow();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"dataflows",
            	            		lv_dataflows_4_0, 
            	            		"Dataflow");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleInterface"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:178:1: entryRuleInterface returns [EObject current=null] : iv_ruleInterface= ruleInterface EOF ;
    public final EObject entryRuleInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterface = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:179:2: (iv_ruleInterface= ruleInterface EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:180:2: iv_ruleInterface= ruleInterface EOF
            {
             newCompositeNode(grammarAccess.getInterfaceRule()); 
            pushFollow(FOLLOW_ruleInterface_in_entryRuleInterface256);
            iv_ruleInterface=ruleInterface();

            state._fsp--;

             current =iv_ruleInterface; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterface266); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInterface"


    // $ANTLR start "ruleInterface"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:187:1: ruleInterface returns [EObject current=null] : (otherlv_0= 'interface component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' ) ;
    public final EObject ruleInterface() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_methods_3_0 = null;


         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:190:28: ( (otherlv_0= 'interface component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:191:1: (otherlv_0= 'interface component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:191:1: (otherlv_0= 'interface component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:191:3: otherlv_0= 'interface component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleInterface303); 

                	newLeafNode(otherlv_0, grammarAccess.getInterfaceAccess().getInterfaceComponentKeyword_0());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:195:1: ( (lv_name_1_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:196:1: (lv_name_1_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:196:1: (lv_name_1_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:197:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInterface320); 

            			newLeafNode(lv_name_1_0, grammarAccess.getInterfaceAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getInterfaceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleInterface337); 

                	newLeafNode(otherlv_2, grammarAccess.getInterfaceAccess().getLeftCurlyBracketKeyword_2());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:217:1: ( (lv_methods_3_0= ruleMethod ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:218:1: (lv_methods_3_0= ruleMethod )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:218:1: (lv_methods_3_0= ruleMethod )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:219:3: lv_methods_3_0= ruleMethod
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getInterfaceAccess().getMethodsMethodParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMethod_in_ruleInterface358);
            	    lv_methods_3_0=ruleMethod();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getInterfaceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"methods",
            	            		lv_methods_3_0, 
            	            		"Method");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleInterface371); 

                	newLeafNode(otherlv_4, grammarAccess.getInterfaceAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInterface"


    // $ANTLR start "entryRuleMethod"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:247:1: entryRuleMethod returns [EObject current=null] : iv_ruleMethod= ruleMethod EOF ;
    public final EObject entryRuleMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethod = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:248:2: (iv_ruleMethod= ruleMethod EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:249:2: iv_ruleMethod= ruleMethod EOF
            {
             newCompositeNode(grammarAccess.getMethodRule()); 
            pushFollow(FOLLOW_ruleMethod_in_entryRuleMethod407);
            iv_ruleMethod=ruleMethod();

            state._fsp--;

             current =iv_ruleMethod; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethod417); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMethod"


    // $ANTLR start "ruleMethod"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:256:1: ruleMethod returns [EObject current=null] : ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ');' ) ;
    public final EObject ruleMethod() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_param_3_0 = null;

        EObject lv_param_5_0 = null;


         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:259:28: ( ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ');' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:260:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ');' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:260:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ');' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:260:2: ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ');'
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:260:2: ( (lv_type_0_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:261:1: (lv_type_0_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:261:1: (lv_type_0_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:262:3: lv_type_0_0= RULE_ID
            {
            lv_type_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMethod459); 

            			newLeafNode(lv_type_0_0, grammarAccess.getMethodAccess().getTypeIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMethodRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"type",
                    		lv_type_0_0, 
                    		"ID");
            	    

            }


            }

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:278:2: ( (lv_name_1_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:279:1: (lv_name_1_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:279:1: (lv_name_1_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:280:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMethod481); 

            			newLeafNode(lv_name_1_0, grammarAccess.getMethodAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMethodRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleMethod498); 

                	newLeafNode(otherlv_2, grammarAccess.getMethodAccess().getLeftParenthesisKeyword_2());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:300:1: ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:300:2: ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )*
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:300:2: ( (lv_param_3_0= ruleParam ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:301:1: (lv_param_3_0= ruleParam )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:301:1: (lv_param_3_0= ruleParam )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:302:3: lv_param_3_0= ruleParam
                    {
                     
                    	        newCompositeNode(grammarAccess.getMethodAccess().getParamParamParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleParam_in_ruleMethod520);
                    lv_param_3_0=ruleParam();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMethodRule());
                    	        }
                           		add(
                           			current, 
                           			"param",
                            		lv_param_3_0, 
                            		"Param");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:318:2: (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==15) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:318:4: otherlv_4= ',' ( (lv_param_5_0= ruleParam ) )
                    	    {
                    	    otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleMethod533); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getMethodAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:322:1: ( (lv_param_5_0= ruleParam ) )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:323:1: (lv_param_5_0= ruleParam )
                    	    {
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:323:1: (lv_param_5_0= ruleParam )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:324:3: lv_param_5_0= ruleParam
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getMethodAccess().getParamParamParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParam_in_ruleMethod554);
                    	    lv_param_5_0=ruleParam();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getMethodRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"param",
                    	            		lv_param_5_0, 
                    	            		"Param");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleMethod570); 

                	newLeafNode(otherlv_6, grammarAccess.getMethodAccess().getRightParenthesisSemicolonKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethod"


    // $ANTLR start "entryRuleParam"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:352:1: entryRuleParam returns [EObject current=null] : iv_ruleParam= ruleParam EOF ;
    public final EObject entryRuleParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParam = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:353:2: (iv_ruleParam= ruleParam EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:354:2: iv_ruleParam= ruleParam EOF
            {
             newCompositeNode(grammarAccess.getParamRule()); 
            pushFollow(FOLLOW_ruleParam_in_entryRuleParam606);
            iv_ruleParam=ruleParam();

            state._fsp--;

             current =iv_ruleParam; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParam616); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParam"


    // $ANTLR start "ruleParam"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:361:1: ruleParam returns [EObject current=null] : ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleParam() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:364:28: ( ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:365:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:365:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:365:2: ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:365:2: ( (lv_type_0_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:366:1: (lv_type_0_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:366:1: (lv_type_0_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:367:3: lv_type_0_0= RULE_ID
            {
            lv_type_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParam658); 

            			newLeafNode(lv_type_0_0, grammarAccess.getParamAccess().getTypeIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getParamRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"type",
                    		lv_type_0_0, 
                    		"ID");
            	    

            }


            }

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:383:2: ( (lv_name_1_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:384:1: (lv_name_1_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:384:1: (lv_name_1_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:385:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParam680); 

            			newLeafNode(lv_name_1_0, grammarAccess.getParamAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getParamRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParam"


    // $ANTLR start "entryRuleDflow"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:409:1: entryRuleDflow returns [EObject current=null] : iv_ruleDflow= ruleDflow EOF ;
    public final EObject entryRuleDflow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDflow = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:410:2: (iv_ruleDflow= ruleDflow EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:411:2: iv_ruleDflow= ruleDflow EOF
            {
             newCompositeNode(grammarAccess.getDflowRule()); 
            pushFollow(FOLLOW_ruleDflow_in_entryRuleDflow721);
            iv_ruleDflow=ruleDflow();

            state._fsp--;

             current =iv_ruleDflow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDflow731); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDflow"


    // $ANTLR start "ruleDflow"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:418:1: ruleDflow returns [EObject current=null] : (otherlv_0= 'Dflow data' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDflow() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:421:28: ( (otherlv_0= 'Dflow data' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:422:1: (otherlv_0= 'Dflow data' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:422:1: (otherlv_0= 'Dflow data' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:422:3: otherlv_0= 'Dflow data' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleDflow768); 

                	newLeafNode(otherlv_0, grammarAccess.getDflowAccess().getDflowDataKeyword_0());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:426:1: ( (lv_name_1_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:427:1: (lv_name_1_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:427:1: (lv_name_1_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:428:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDflow785); 

            			newLeafNode(lv_name_1_0, grammarAccess.getDflowAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDflowRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleDflow802); 

                	newLeafNode(otherlv_2, grammarAccess.getDflowAccess().getSemicolonKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDflow"


    // $ANTLR start "entryRuleDfa"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:456:1: entryRuleDfa returns [EObject current=null] : iv_ruleDfa= ruleDfa EOF ;
    public final EObject entryRuleDfa() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDfa = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:457:2: (iv_ruleDfa= ruleDfa EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:458:2: iv_ruleDfa= ruleDfa EOF
            {
             newCompositeNode(grammarAccess.getDfaRule()); 
            pushFollow(FOLLOW_ruleDfa_in_entryRuleDfa838);
            iv_ruleDfa=ruleDfa();

            state._fsp--;

             current =iv_ruleDfa; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDfa848); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDfa"


    // $ANTLR start "ruleDfa"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:465:1: ruleDfa returns [EObject current=null] : (otherlv_0= 'Dfa' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleDfa() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:468:28: ( (otherlv_0= 'Dfa' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:469:1: (otherlv_0= 'Dfa' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:469:1: (otherlv_0= 'Dfa' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:469:3: otherlv_0= 'Dfa' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleDfa885); 

                	newLeafNode(otherlv_0, grammarAccess.getDfaAccess().getDfaKeyword_0());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:473:1: ( (lv_name_1_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:474:1: (lv_name_1_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:474:1: (lv_name_1_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:475:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDfa902); 

            			newLeafNode(lv_name_1_0, grammarAccess.getDfaAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDfaRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleDfa919); 

                	newLeafNode(otherlv_2, grammarAccess.getDfaAccess().getSemicolonKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDfa"


    // $ANTLR start "entryRuleBehavior"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:503:1: entryRuleBehavior returns [EObject current=null] : iv_ruleBehavior= ruleBehavior EOF ;
    public final EObject entryRuleBehavior() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehavior = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:504:2: (iv_ruleBehavior= ruleBehavior EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:505:2: iv_ruleBehavior= ruleBehavior EOF
            {
             newCompositeNode(grammarAccess.getBehaviorRule()); 
            pushFollow(FOLLOW_ruleBehavior_in_entryRuleBehavior955);
            iv_ruleBehavior=ruleBehavior();

            state._fsp--;

             current =iv_ruleBehavior; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBehavior965); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBehavior"


    // $ANTLR start "ruleBehavior"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:512:1: ruleBehavior returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '(' ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= ');' ) ;
    public final EObject ruleBehavior() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;

         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:515:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '(' ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= ');' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:516:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '(' ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= ');' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:516:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '(' ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= ');' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:516:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '(' ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= ');'
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:516:2: ( (otherlv_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:517:1: (otherlv_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:517:1: (otherlv_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:518:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getBehaviorRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBehavior1010); 

            		newLeafNode(otherlv_0, grammarAccess.getBehaviorAccess().getInterfaceInterfaceCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleBehavior1022); 

                	newLeafNode(otherlv_1, grammarAccess.getBehaviorAccess().getEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleBehavior1034); 

                	newLeafNode(otherlv_2, grammarAccess.getBehaviorAccess().getLeftParenthesisKeyword_2());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:537:1: ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:537:2: ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:537:2: ( ( ruleFQN ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:538:1: ( ruleFQN )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:538:1: ( ruleFQN )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:539:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getBehaviorRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getBehaviorAccess().getCallMethodCrossReference_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleBehavior1058);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:552:2: (otherlv_4= '->' ( ( ruleFQN ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==21) ) {
                            int LA9_1 = input.LA(2);

                            if ( (LA9_1==RULE_ID) ) {
                                int LA9_2 = input.LA(3);

                                if ( (LA9_2==21||LA9_2==26) ) {
                                    alt9=1;
                                }


                            }


                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:552:4: otherlv_4= '->' ( ( ruleFQN ) )
                    	    {
                    	    otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleBehavior1071); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getBehaviorAccess().getHyphenMinusGreaterThanSignKeyword_3_1_0());
                    	        
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:556:1: ( ( ruleFQN ) )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:557:1: ( ruleFQN )
                    	    {
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:557:1: ( ruleFQN )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:558:3: ruleFQN
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getBehaviorRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getBehaviorAccess().getCallMethodCrossReference_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFQN_in_ruleBehavior1094);
                    	    ruleFQN();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,21,FOLLOW_21_in_ruleBehavior1108); 

                        	newLeafNode(otherlv_6, grammarAccess.getBehaviorAccess().getHyphenMinusGreaterThanSignKeyword_3_2());
                        
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:575:1: ( (otherlv_7= RULE_ID ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:576:1: (otherlv_7= RULE_ID )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:576:1: (otherlv_7= RULE_ID )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:577:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getBehaviorRule());
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBehavior1128); 

                    		newLeafNode(otherlv_7, grammarAccess.getBehaviorAccess().getEndInterfaceCrossReference_3_3_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,16,FOLLOW_16_in_ruleBehavior1142); 

                	newLeafNode(otherlv_8, grammarAccess.getBehaviorAccess().getRightParenthesisSemicolonKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBehavior"


    // $ANTLR start "entryRuleDataflow"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:600:1: entryRuleDataflow returns [EObject current=null] : iv_ruleDataflow= ruleDataflow EOF ;
    public final EObject entryRuleDataflow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataflow = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:601:2: (iv_ruleDataflow= ruleDataflow EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:602:2: iv_ruleDataflow= ruleDataflow EOF
            {
             newCompositeNode(grammarAccess.getDataflowRule()); 
            pushFollow(FOLLOW_ruleDataflow_in_entryRuleDataflow1178);
            iv_ruleDataflow=ruleDataflow();

            state._fsp--;

             current =iv_ruleDataflow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataflow1188); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataflow"


    // $ANTLR start "ruleDataflow"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:609:1: ruleDataflow returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' (otherlv_3= '|' ( (otherlv_4= RULE_ID ) ) otherlv_5= '|' (otherlv_6= '->>' ( ( ruleFQN ) ) (otherlv_8= '->>' otherlv_9= '|' ( (otherlv_10= RULE_ID ) ) otherlv_11= '|' ) ) (otherlv_12= '->>' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->>' otherlv_15= '|' ( (otherlv_16= RULE_ID ) ) otherlv_17= '|' ) ) (otherlv_18= '->>' ( ( ruleFQN ) ) (otherlv_20= '->>' otherlv_21= '|' ( (otherlv_22= RULE_ID ) ) otherlv_23= '|' ) ) otherlv_24= '->>' ( (otherlv_25= RULE_ID ) ) )? otherlv_26= '];' ) ;
    public final EObject ruleDataflow() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_26=null;

         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:612:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' (otherlv_3= '|' ( (otherlv_4= RULE_ID ) ) otherlv_5= '|' (otherlv_6= '->>' ( ( ruleFQN ) ) (otherlv_8= '->>' otherlv_9= '|' ( (otherlv_10= RULE_ID ) ) otherlv_11= '|' ) ) (otherlv_12= '->>' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->>' otherlv_15= '|' ( (otherlv_16= RULE_ID ) ) otherlv_17= '|' ) ) (otherlv_18= '->>' ( ( ruleFQN ) ) (otherlv_20= '->>' otherlv_21= '|' ( (otherlv_22= RULE_ID ) ) otherlv_23= '|' ) ) otherlv_24= '->>' ( (otherlv_25= RULE_ID ) ) )? otherlv_26= '];' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:613:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' (otherlv_3= '|' ( (otherlv_4= RULE_ID ) ) otherlv_5= '|' (otherlv_6= '->>' ( ( ruleFQN ) ) (otherlv_8= '->>' otherlv_9= '|' ( (otherlv_10= RULE_ID ) ) otherlv_11= '|' ) ) (otherlv_12= '->>' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->>' otherlv_15= '|' ( (otherlv_16= RULE_ID ) ) otherlv_17= '|' ) ) (otherlv_18= '->>' ( ( ruleFQN ) ) (otherlv_20= '->>' otherlv_21= '|' ( (otherlv_22= RULE_ID ) ) otherlv_23= '|' ) ) otherlv_24= '->>' ( (otherlv_25= RULE_ID ) ) )? otherlv_26= '];' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:613:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' (otherlv_3= '|' ( (otherlv_4= RULE_ID ) ) otherlv_5= '|' (otherlv_6= '->>' ( ( ruleFQN ) ) (otherlv_8= '->>' otherlv_9= '|' ( (otherlv_10= RULE_ID ) ) otherlv_11= '|' ) ) (otherlv_12= '->>' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->>' otherlv_15= '|' ( (otherlv_16= RULE_ID ) ) otherlv_17= '|' ) ) (otherlv_18= '->>' ( ( ruleFQN ) ) (otherlv_20= '->>' otherlv_21= '|' ( (otherlv_22= RULE_ID ) ) otherlv_23= '|' ) ) otherlv_24= '->>' ( (otherlv_25= RULE_ID ) ) )? otherlv_26= '];' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:613:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' (otherlv_3= '|' ( (otherlv_4= RULE_ID ) ) otherlv_5= '|' (otherlv_6= '->>' ( ( ruleFQN ) ) (otherlv_8= '->>' otherlv_9= '|' ( (otherlv_10= RULE_ID ) ) otherlv_11= '|' ) ) (otherlv_12= '->>' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->>' otherlv_15= '|' ( (otherlv_16= RULE_ID ) ) otherlv_17= '|' ) ) (otherlv_18= '->>' ( ( ruleFQN ) ) (otherlv_20= '->>' otherlv_21= '|' ( (otherlv_22= RULE_ID ) ) otherlv_23= '|' ) ) otherlv_24= '->>' ( (otherlv_25= RULE_ID ) ) )? otherlv_26= '];'
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:613:2: ( (otherlv_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:614:1: (otherlv_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:614:1: (otherlv_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:615:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDataflowRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataflow1233); 

            		newLeafNode(otherlv_0, grammarAccess.getDataflowAccess().getDfaDfaCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleDataflow1245); 

                	newLeafNode(otherlv_1, grammarAccess.getDataflowAccess().getEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleDataflow1257); 

                	newLeafNode(otherlv_2, grammarAccess.getDataflowAccess().getLeftSquareBracketKeyword_2());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:634:1: (otherlv_3= '|' ( (otherlv_4= RULE_ID ) ) otherlv_5= '|' (otherlv_6= '->>' ( ( ruleFQN ) ) (otherlv_8= '->>' otherlv_9= '|' ( (otherlv_10= RULE_ID ) ) otherlv_11= '|' ) ) (otherlv_12= '->>' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->>' otherlv_15= '|' ( (otherlv_16= RULE_ID ) ) otherlv_17= '|' ) ) (otherlv_18= '->>' ( ( ruleFQN ) ) (otherlv_20= '->>' otherlv_21= '|' ( (otherlv_22= RULE_ID ) ) otherlv_23= '|' ) ) otherlv_24= '->>' ( (otherlv_25= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:634:3: otherlv_3= '|' ( (otherlv_4= RULE_ID ) ) otherlv_5= '|' (otherlv_6= '->>' ( ( ruleFQN ) ) (otherlv_8= '->>' otherlv_9= '|' ( (otherlv_10= RULE_ID ) ) otherlv_11= '|' ) ) (otherlv_12= '->>' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->>' otherlv_15= '|' ( (otherlv_16= RULE_ID ) ) otherlv_17= '|' ) ) (otherlv_18= '->>' ( ( ruleFQN ) ) (otherlv_20= '->>' otherlv_21= '|' ( (otherlv_22= RULE_ID ) ) otherlv_23= '|' ) ) otherlv_24= '->>' ( (otherlv_25= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleDataflow1270); 

                        	newLeafNode(otherlv_3, grammarAccess.getDataflowAccess().getVerticalLineKeyword_3_0());
                        
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:638:1: ( (otherlv_4= RULE_ID ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:639:1: (otherlv_4= RULE_ID )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:639:1: (otherlv_4= RULE_ID )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:640:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDataflowRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataflow1290); 

                    		newLeafNode(otherlv_4, grammarAccess.getDataflowAccess().getGetflowDflowCrossReference_3_1_0()); 
                    	

                    }


                    }

                    otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleDataflow1302); 

                        	newLeafNode(otherlv_5, grammarAccess.getDataflowAccess().getVerticalLineKeyword_3_2());
                        
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:655:1: (otherlv_6= '->>' ( ( ruleFQN ) ) (otherlv_8= '->>' otherlv_9= '|' ( (otherlv_10= RULE_ID ) ) otherlv_11= '|' ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:655:3: otherlv_6= '->>' ( ( ruleFQN ) ) (otherlv_8= '->>' otherlv_9= '|' ( (otherlv_10= RULE_ID ) ) otherlv_11= '|' )
                    {
                    otherlv_6=(Token)match(input,24,FOLLOW_24_in_ruleDataflow1315); 

                        	newLeafNode(otherlv_6, grammarAccess.getDataflowAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_3_3_0());
                        
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:659:1: ( ( ruleFQN ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:660:1: ( ruleFQN )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:660:1: ( ruleFQN )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:661:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDataflowRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getDataflowAccess().getCallMethodCrossReference_3_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleDataflow1338);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:674:2: (otherlv_8= '->>' otherlv_9= '|' ( (otherlv_10= RULE_ID ) ) otherlv_11= '|' )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:674:4: otherlv_8= '->>' otherlv_9= '|' ( (otherlv_10= RULE_ID ) ) otherlv_11= '|'
                    {
                    otherlv_8=(Token)match(input,24,FOLLOW_24_in_ruleDataflow1351); 

                        	newLeafNode(otherlv_8, grammarAccess.getDataflowAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_3_3_2_0());
                        
                    otherlv_9=(Token)match(input,23,FOLLOW_23_in_ruleDataflow1363); 

                        	newLeafNode(otherlv_9, grammarAccess.getDataflowAccess().getVerticalLineKeyword_3_3_2_1());
                        
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:682:1: ( (otherlv_10= RULE_ID ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:683:1: (otherlv_10= RULE_ID )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:683:1: (otherlv_10= RULE_ID )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:684:3: otherlv_10= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDataflowRule());
                    	        }
                            
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataflow1383); 

                    		newLeafNode(otherlv_10, grammarAccess.getDataflowAccess().getGetflowDflowCrossReference_3_3_2_2_0()); 
                    	

                    }


                    }

                    otherlv_11=(Token)match(input,23,FOLLOW_23_in_ruleDataflow1395); 

                        	newLeafNode(otherlv_11, grammarAccess.getDataflowAccess().getVerticalLineKeyword_3_3_2_3());
                        

                    }


                    }

                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:699:3: (otherlv_12= '->>' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->>' otherlv_15= '|' ( (otherlv_16= RULE_ID ) ) otherlv_17= '|' ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:699:5: otherlv_12= '->>' ( (otherlv_13= RULE_ID ) ) (otherlv_14= '->>' otherlv_15= '|' ( (otherlv_16= RULE_ID ) ) otherlv_17= '|' )
                    {
                    otherlv_12=(Token)match(input,24,FOLLOW_24_in_ruleDataflow1410); 

                        	newLeafNode(otherlv_12, grammarAccess.getDataflowAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_3_4_0());
                        
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:703:1: ( (otherlv_13= RULE_ID ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:704:1: (otherlv_13= RULE_ID )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:704:1: (otherlv_13= RULE_ID )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:705:3: otherlv_13= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDataflowRule());
                    	        }
                            
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataflow1430); 

                    		newLeafNode(otherlv_13, grammarAccess.getDataflowAccess().getGetIfInterfaceCrossReference_3_4_1_0()); 
                    	

                    }


                    }

                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:716:2: (otherlv_14= '->>' otherlv_15= '|' ( (otherlv_16= RULE_ID ) ) otherlv_17= '|' )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:716:4: otherlv_14= '->>' otherlv_15= '|' ( (otherlv_16= RULE_ID ) ) otherlv_17= '|'
                    {
                    otherlv_14=(Token)match(input,24,FOLLOW_24_in_ruleDataflow1443); 

                        	newLeafNode(otherlv_14, grammarAccess.getDataflowAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_3_4_2_0());
                        
                    otherlv_15=(Token)match(input,23,FOLLOW_23_in_ruleDataflow1455); 

                        	newLeafNode(otherlv_15, grammarAccess.getDataflowAccess().getVerticalLineKeyword_3_4_2_1());
                        
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:724:1: ( (otherlv_16= RULE_ID ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:725:1: (otherlv_16= RULE_ID )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:725:1: (otherlv_16= RULE_ID )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:726:3: otherlv_16= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDataflowRule());
                    	        }
                            
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataflow1475); 

                    		newLeafNode(otherlv_16, grammarAccess.getDataflowAccess().getGetflowDflowCrossReference_3_4_2_2_0()); 
                    	

                    }


                    }

                    otherlv_17=(Token)match(input,23,FOLLOW_23_in_ruleDataflow1487); 

                        	newLeafNode(otherlv_17, grammarAccess.getDataflowAccess().getVerticalLineKeyword_3_4_2_3());
                        

                    }


                    }

                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:741:3: (otherlv_18= '->>' ( ( ruleFQN ) ) (otherlv_20= '->>' otherlv_21= '|' ( (otherlv_22= RULE_ID ) ) otherlv_23= '|' ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:741:5: otherlv_18= '->>' ( ( ruleFQN ) ) (otherlv_20= '->>' otherlv_21= '|' ( (otherlv_22= RULE_ID ) ) otherlv_23= '|' )
                    {
                    otherlv_18=(Token)match(input,24,FOLLOW_24_in_ruleDataflow1502); 

                        	newLeafNode(otherlv_18, grammarAccess.getDataflowAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_3_5_0());
                        
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:745:1: ( ( ruleFQN ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:746:1: ( ruleFQN )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:746:1: ( ruleFQN )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:747:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDataflowRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getDataflowAccess().getCallMethodCrossReference_3_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleDataflow1525);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:760:2: (otherlv_20= '->>' otherlv_21= '|' ( (otherlv_22= RULE_ID ) ) otherlv_23= '|' )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:760:4: otherlv_20= '->>' otherlv_21= '|' ( (otherlv_22= RULE_ID ) ) otherlv_23= '|'
                    {
                    otherlv_20=(Token)match(input,24,FOLLOW_24_in_ruleDataflow1538); 

                        	newLeafNode(otherlv_20, grammarAccess.getDataflowAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_3_5_2_0());
                        
                    otherlv_21=(Token)match(input,23,FOLLOW_23_in_ruleDataflow1550); 

                        	newLeafNode(otherlv_21, grammarAccess.getDataflowAccess().getVerticalLineKeyword_3_5_2_1());
                        
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:768:1: ( (otherlv_22= RULE_ID ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:769:1: (otherlv_22= RULE_ID )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:769:1: (otherlv_22= RULE_ID )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:770:3: otherlv_22= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDataflowRule());
                    	        }
                            
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataflow1570); 

                    		newLeafNode(otherlv_22, grammarAccess.getDataflowAccess().getGetflowDflowCrossReference_3_5_2_2_0()); 
                    	

                    }


                    }

                    otherlv_23=(Token)match(input,23,FOLLOW_23_in_ruleDataflow1582); 

                        	newLeafNode(otherlv_23, grammarAccess.getDataflowAccess().getVerticalLineKeyword_3_5_2_3());
                        

                    }


                    }

                    otherlv_24=(Token)match(input,24,FOLLOW_24_in_ruleDataflow1596); 

                        	newLeafNode(otherlv_24, grammarAccess.getDataflowAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_3_6());
                        
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:789:1: ( (otherlv_25= RULE_ID ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:790:1: (otherlv_25= RULE_ID )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:790:1: (otherlv_25= RULE_ID )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:791:3: otherlv_25= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDataflowRule());
                    	        }
                            
                    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataflow1616); 

                    		newLeafNode(otherlv_25, grammarAccess.getDataflowAccess().getEndInterfaceCrossReference_3_7_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_26=(Token)match(input,25,FOLLOW_25_in_ruleDataflow1630); 

                	newLeafNode(otherlv_26, grammarAccess.getDataflowAccess().getRightSquareBracketSemicolonKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataflow"


    // $ANTLR start "entryRuleFQN"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:814:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:815:2: (iv_ruleFQN= ruleFQN EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:816:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN1667);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN1678); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:823:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:826:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:827:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:827:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:827:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN1718); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:834:1: (kw= '.' this_ID_2= RULE_ID )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==26) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:835:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,26,FOLLOW_26_in_ruleFQN1737); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN1752); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFQN"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterface_in_ruleModel131 = new BitSet(new long[]{0x00000000000A0812L});
    public static final BitSet FOLLOW_ruleBehavior_in_ruleModel153 = new BitSet(new long[]{0x00000000000A0012L});
    public static final BitSet FOLLOW_ruleDflow_in_ruleModel175 = new BitSet(new long[]{0x00000000000A0012L});
    public static final BitSet FOLLOW_ruleDfa_in_ruleModel197 = new BitSet(new long[]{0x0000000000080012L});
    public static final BitSet FOLLOW_ruleDataflow_in_ruleModel219 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleInterface_in_entryRuleInterface256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterface266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleInterface303 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInterface320 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleInterface337 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_ruleMethod_in_ruleInterface358 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_13_in_ruleInterface371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethod_in_entryRuleMethod407 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethod417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMethod459 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMethod481 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleMethod498 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleMethod520 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleMethod533 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleMethod554 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_ruleMethod570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParam_in_entryRuleParam606 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParam616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParam658 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParam680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDflow_in_entryRuleDflow721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDflow731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleDflow768 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDflow785 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleDflow802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDfa_in_entryRuleDfa838 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDfa848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleDfa885 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDfa902 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleDfa919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBehavior_in_entryRuleBehavior955 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBehavior965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBehavior1010 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleBehavior1022 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleBehavior1034 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleBehavior1058 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleBehavior1071 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleBehavior1094 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleBehavior1108 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBehavior1128 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleBehavior1142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataflow_in_entryRuleDataflow1178 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataflow1188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataflow1233 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleDataflow1245 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleDataflow1257 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_23_in_ruleDataflow1270 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataflow1290 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleDataflow1302 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleDataflow1315 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleDataflow1338 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleDataflow1351 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleDataflow1363 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataflow1383 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleDataflow1395 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleDataflow1410 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataflow1430 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleDataflow1443 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleDataflow1455 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataflow1475 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleDataflow1487 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleDataflow1502 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleDataflow1525 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleDataflow1538 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleDataflow1550 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataflow1570 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleDataflow1582 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleDataflow1596 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataflow1616 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleDataflow1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN1667 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN1678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1718 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleFQN1737 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1752 = new BitSet(new long[]{0x0000000004000002L});

}