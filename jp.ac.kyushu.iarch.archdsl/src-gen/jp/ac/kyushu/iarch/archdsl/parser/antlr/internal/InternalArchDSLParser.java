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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'interface uncertain'", "'extends'", "'{'", "'}'", "'interface component'", "'('", "','", "');'", "')'", "'};'", "'['", "']'", "'='", "'->'", "'.'"
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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:76:1: ruleModel returns [EObject current=null] : ( ( ( (lv_interfaces_0_0= ruleInterface ) ) | ( (lv_u_interfaces_1_0= ruleUncertainInterface ) ) )* ( ( (lv_behaviors_2_0= ruleBehavior ) ) | ( (lv_u_behaviors_3_0= ruleUncertainBehavior ) ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_interfaces_0_0 = null;

        EObject lv_u_interfaces_1_0 = null;

        EObject lv_behaviors_2_0 = null;

        EObject lv_u_behaviors_3_0 = null;


         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:79:28: ( ( ( ( (lv_interfaces_0_0= ruleInterface ) ) | ( (lv_u_interfaces_1_0= ruleUncertainInterface ) ) )* ( ( (lv_behaviors_2_0= ruleBehavior ) ) | ( (lv_u_behaviors_3_0= ruleUncertainBehavior ) ) )* ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:80:1: ( ( ( (lv_interfaces_0_0= ruleInterface ) ) | ( (lv_u_interfaces_1_0= ruleUncertainInterface ) ) )* ( ( (lv_behaviors_2_0= ruleBehavior ) ) | ( (lv_u_behaviors_3_0= ruleUncertainBehavior ) ) )* )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:80:1: ( ( ( (lv_interfaces_0_0= ruleInterface ) ) | ( (lv_u_interfaces_1_0= ruleUncertainInterface ) ) )* ( ( (lv_behaviors_2_0= ruleBehavior ) ) | ( (lv_u_behaviors_3_0= ruleUncertainBehavior ) ) )* )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:80:2: ( ( (lv_interfaces_0_0= ruleInterface ) ) | ( (lv_u_interfaces_1_0= ruleUncertainInterface ) ) )* ( ( (lv_behaviors_2_0= ruleBehavior ) ) | ( (lv_u_behaviors_3_0= ruleUncertainBehavior ) ) )*
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:80:2: ( ( (lv_interfaces_0_0= ruleInterface ) ) | ( (lv_u_interfaces_1_0= ruleUncertainInterface ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }
                else if ( (LA1_0==11) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:80:3: ( (lv_interfaces_0_0= ruleInterface ) )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:80:3: ( (lv_interfaces_0_0= ruleInterface ) )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:81:1: (lv_interfaces_0_0= ruleInterface )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:81:1: (lv_interfaces_0_0= ruleInterface )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:82:3: lv_interfaces_0_0= ruleInterface
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getInterfacesInterfaceParserRuleCall_0_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInterface_in_ruleModel132);
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


            	    }
            	    break;
            	case 2 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:99:6: ( (lv_u_interfaces_1_0= ruleUncertainInterface ) )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:99:6: ( (lv_u_interfaces_1_0= ruleUncertainInterface ) )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:100:1: (lv_u_interfaces_1_0= ruleUncertainInterface )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:100:1: (lv_u_interfaces_1_0= ruleUncertainInterface )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:101:3: lv_u_interfaces_1_0= ruleUncertainInterface
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getU_interfacesUncertainInterfaceParserRuleCall_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleUncertainInterface_in_ruleModel159);
            	    lv_u_interfaces_1_0=ruleUncertainInterface();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"u_interfaces",
            	            		lv_u_interfaces_1_0, 
            	            		"UncertainInterface");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:117:4: ( ( (lv_behaviors_2_0= ruleBehavior ) ) | ( (lv_u_behaviors_3_0= ruleUncertainBehavior ) ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    int LA2_2 = input.LA(2);

                    if ( (LA2_2==23) ) {
                        alt2=1;
                    }
                    else if ( (LA2_2==12) ) {
                        alt2=2;
                    }


                }


                switch (alt2) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:117:5: ( (lv_behaviors_2_0= ruleBehavior ) )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:117:5: ( (lv_behaviors_2_0= ruleBehavior ) )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:118:1: (lv_behaviors_2_0= ruleBehavior )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:118:1: (lv_behaviors_2_0= ruleBehavior )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:119:3: lv_behaviors_2_0= ruleBehavior
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getBehaviorsBehaviorParserRuleCall_1_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleBehavior_in_ruleModel183);
            	    lv_behaviors_2_0=ruleBehavior();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"behaviors",
            	            		lv_behaviors_2_0, 
            	            		"Behavior");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:136:6: ( (lv_u_behaviors_3_0= ruleUncertainBehavior ) )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:136:6: ( (lv_u_behaviors_3_0= ruleUncertainBehavior ) )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:137:1: (lv_u_behaviors_3_0= ruleUncertainBehavior )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:137:1: (lv_u_behaviors_3_0= ruleUncertainBehavior )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:138:3: lv_u_behaviors_3_0= ruleUncertainBehavior
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getU_behaviorsUncertainBehaviorParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleUncertainBehavior_in_ruleModel210);
            	    lv_u_behaviors_3_0=ruleUncertainBehavior();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"u_behaviors",
            	            		lv_u_behaviors_3_0, 
            	            		"UncertainBehavior");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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


    // $ANTLR start "entryRuleUncertainInterface"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:162:1: entryRuleUncertainInterface returns [EObject current=null] : iv_ruleUncertainInterface= ruleUncertainInterface EOF ;
    public final EObject entryRuleUncertainInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUncertainInterface = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:163:2: (iv_ruleUncertainInterface= ruleUncertainInterface EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:164:2: iv_ruleUncertainInterface= ruleUncertainInterface EOF
            {
             newCompositeNode(grammarAccess.getUncertainInterfaceRule()); 
            pushFollow(FOLLOW_ruleUncertainInterface_in_entryRuleUncertainInterface248);
            iv_ruleUncertainInterface=ruleUncertainInterface();

            state._fsp--;

             current =iv_ruleUncertainInterface; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUncertainInterface258); 

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
    // $ANTLR end "entryRuleUncertainInterface"


    // $ANTLR start "ruleUncertainInterface"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:171:1: ruleUncertainInterface returns [EObject current=null] : (otherlv_0= 'interface uncertain' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( ( (lv_altmethods_5_0= ruleAltMethod ) ) | ( (lv_optmethods_6_0= ruleOptMethod ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleUncertainInterface() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_altmethods_5_0 = null;

        EObject lv_optmethods_6_0 = null;


         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:174:28: ( (otherlv_0= 'interface uncertain' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( ( (lv_altmethods_5_0= ruleAltMethod ) ) | ( (lv_optmethods_6_0= ruleOptMethod ) ) )* otherlv_7= '}' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:175:1: (otherlv_0= 'interface uncertain' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( ( (lv_altmethods_5_0= ruleAltMethod ) ) | ( (lv_optmethods_6_0= ruleOptMethod ) ) )* otherlv_7= '}' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:175:1: (otherlv_0= 'interface uncertain' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( ( (lv_altmethods_5_0= ruleAltMethod ) ) | ( (lv_optmethods_6_0= ruleOptMethod ) ) )* otherlv_7= '}' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:175:3: otherlv_0= 'interface uncertain' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( ( (lv_altmethods_5_0= ruleAltMethod ) ) | ( (lv_optmethods_6_0= ruleOptMethod ) ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleUncertainInterface295); 

                	newLeafNode(otherlv_0, grammarAccess.getUncertainInterfaceAccess().getInterfaceUncertainKeyword_0());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:179:1: ( (lv_name_1_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:180:1: (lv_name_1_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:180:1: (lv_name_1_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:181:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUncertainInterface312); 

            			newLeafNode(lv_name_1_0, grammarAccess.getUncertainInterfaceAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUncertainInterfaceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:197:2: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:197:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleUncertainInterface330); 

                        	newLeafNode(otherlv_2, grammarAccess.getUncertainInterfaceAccess().getExtendsKeyword_2_0());
                        
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:201:1: ( (otherlv_3= RULE_ID ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:202:1: (otherlv_3= RULE_ID )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:202:1: (otherlv_3= RULE_ID )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:203:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getUncertainInterfaceRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUncertainInterface350); 

                    		newLeafNode(otherlv_3, grammarAccess.getUncertainInterfaceAccess().getSuperInterfaceInterfaceCrossReference_2_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleUncertainInterface364); 

                	newLeafNode(otherlv_4, grammarAccess.getUncertainInterfaceAccess().getLeftCurlyBracketKeyword_3());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:218:1: ( ( (lv_altmethods_5_0= ruleAltMethod ) ) | ( (lv_optmethods_6_0= ruleOptMethod ) ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }
                else if ( (LA4_0==21) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:218:2: ( (lv_altmethods_5_0= ruleAltMethod ) )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:218:2: ( (lv_altmethods_5_0= ruleAltMethod ) )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:219:1: (lv_altmethods_5_0= ruleAltMethod )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:219:1: (lv_altmethods_5_0= ruleAltMethod )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:220:3: lv_altmethods_5_0= ruleAltMethod
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getUncertainInterfaceAccess().getAltmethodsAltMethodParserRuleCall_4_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAltMethod_in_ruleUncertainInterface386);
            	    lv_altmethods_5_0=ruleAltMethod();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getUncertainInterfaceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"altmethods",
            	            		lv_altmethods_5_0, 
            	            		"AltMethod");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:237:6: ( (lv_optmethods_6_0= ruleOptMethod ) )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:237:6: ( (lv_optmethods_6_0= ruleOptMethod ) )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:238:1: (lv_optmethods_6_0= ruleOptMethod )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:238:1: (lv_optmethods_6_0= ruleOptMethod )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:239:3: lv_optmethods_6_0= ruleOptMethod
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getUncertainInterfaceAccess().getOptmethodsOptMethodParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleOptMethod_in_ruleUncertainInterface413);
            	    lv_optmethods_6_0=ruleOptMethod();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getUncertainInterfaceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"optmethods",
            	            		lv_optmethods_6_0, 
            	            		"OptMethod");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_14_in_ruleUncertainInterface427); 

                	newLeafNode(otherlv_7, grammarAccess.getUncertainInterfaceAccess().getRightCurlyBracketKeyword_5());
                

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
    // $ANTLR end "ruleUncertainInterface"


    // $ANTLR start "entryRuleInterface"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:267:1: entryRuleInterface returns [EObject current=null] : iv_ruleInterface= ruleInterface EOF ;
    public final EObject entryRuleInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterface = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:268:2: (iv_ruleInterface= ruleInterface EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:269:2: iv_ruleInterface= ruleInterface EOF
            {
             newCompositeNode(grammarAccess.getInterfaceRule()); 
            pushFollow(FOLLOW_ruleInterface_in_entryRuleInterface463);
            iv_ruleInterface=ruleInterface();

            state._fsp--;

             current =iv_ruleInterface; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterface473); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:276:1: ruleInterface returns [EObject current=null] : (otherlv_0= 'interface component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' ) ;
    public final EObject ruleInterface() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_methods_3_0 = null;


         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:279:28: ( (otherlv_0= 'interface component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:280:1: (otherlv_0= 'interface component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:280:1: (otherlv_0= 'interface component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:280:3: otherlv_0= 'interface component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleInterface510); 

                	newLeafNode(otherlv_0, grammarAccess.getInterfaceAccess().getInterfaceComponentKeyword_0());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:284:1: ( (lv_name_1_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:285:1: (lv_name_1_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:285:1: (lv_name_1_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:286:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInterface527); 

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

            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleInterface544); 

                	newLeafNode(otherlv_2, grammarAccess.getInterfaceAccess().getLeftCurlyBracketKeyword_2());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:306:1: ( (lv_methods_3_0= ruleMethod ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:307:1: (lv_methods_3_0= ruleMethod )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:307:1: (lv_methods_3_0= ruleMethod )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:308:3: lv_methods_3_0= ruleMethod
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getInterfaceAccess().getMethodsMethodParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMethod_in_ruleInterface565);
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
            	    break loop5;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleInterface578); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:336:1: entryRuleMethod returns [EObject current=null] : iv_ruleMethod= ruleMethod EOF ;
    public final EObject entryRuleMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethod = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:337:2: (iv_ruleMethod= ruleMethod EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:338:2: iv_ruleMethod= ruleMethod EOF
            {
             newCompositeNode(grammarAccess.getMethodRule()); 
            pushFollow(FOLLOW_ruleMethod_in_entryRuleMethod614);
            iv_ruleMethod=ruleMethod();

            state._fsp--;

             current =iv_ruleMethod; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethod624); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:345:1: ruleMethod returns [EObject current=null] : ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ');' ) ;
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
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:348:28: ( ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ');' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:349:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ');' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:349:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ');' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:349:2: ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ');'
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:349:2: ( (lv_type_0_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:350:1: (lv_type_0_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:350:1: (lv_type_0_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:351:3: lv_type_0_0= RULE_ID
            {
            lv_type_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMethod666); 

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

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:367:2: ( (lv_name_1_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:368:1: (lv_name_1_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:368:1: (lv_name_1_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:369:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMethod688); 

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

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleMethod705); 

                	newLeafNode(otherlv_2, grammarAccess.getMethodAccess().getLeftParenthesisKeyword_2());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:389:1: ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:389:2: ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )*
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:389:2: ( (lv_param_3_0= ruleParam ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:390:1: (lv_param_3_0= ruleParam )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:390:1: (lv_param_3_0= ruleParam )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:391:3: lv_param_3_0= ruleParam
                    {
                     
                    	        newCompositeNode(grammarAccess.getMethodAccess().getParamParamParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleParam_in_ruleMethod727);
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

                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:407:2: (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==17) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:407:4: otherlv_4= ',' ( (lv_param_5_0= ruleParam ) )
                    	    {
                    	    otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleMethod740); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getMethodAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:411:1: ( (lv_param_5_0= ruleParam ) )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:412:1: (lv_param_5_0= ruleParam )
                    	    {
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:412:1: (lv_param_5_0= ruleParam )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:413:3: lv_param_5_0= ruleParam
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getMethodAccess().getParamParamParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParam_in_ruleMethod761);
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
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleMethod777); 

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


    // $ANTLR start "entryRuleAltMethod"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:441:1: entryRuleAltMethod returns [EObject current=null] : iv_ruleAltMethod= ruleAltMethod EOF ;
    public final EObject entryRuleAltMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAltMethod = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:442:2: (iv_ruleAltMethod= ruleAltMethod EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:443:2: iv_ruleAltMethod= ruleAltMethod EOF
            {
             newCompositeNode(grammarAccess.getAltMethodRule()); 
            pushFollow(FOLLOW_ruleAltMethod_in_entryRuleAltMethod813);
            iv_ruleAltMethod=ruleAltMethod();

            state._fsp--;

             current =iv_ruleAltMethod; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAltMethod823); 

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
    // $ANTLR end "entryRuleAltMethod"


    // $ANTLR start "ruleAltMethod"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:450:1: ruleAltMethod returns [EObject current=null] : (otherlv_0= '{' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )? otherlv_7= ')' (otherlv_8= ',' ( (lv_type_9_0= RULE_ID ) ) ( (lv_a_name_10_0= RULE_ID ) ) otherlv_11= '(' ( ( (lv_param_12_0= ruleParam ) ) (otherlv_13= ',' ( (lv_param_14_0= ruleParam ) ) )* )? otherlv_15= ')' )* otherlv_16= '};' ) ;
    public final EObject ruleAltMethod() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_type_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_type_9_0=null;
        Token lv_a_name_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        EObject lv_param_4_0 = null;

        EObject lv_param_6_0 = null;

        EObject lv_param_12_0 = null;

        EObject lv_param_14_0 = null;


         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:453:28: ( (otherlv_0= '{' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )? otherlv_7= ')' (otherlv_8= ',' ( (lv_type_9_0= RULE_ID ) ) ( (lv_a_name_10_0= RULE_ID ) ) otherlv_11= '(' ( ( (lv_param_12_0= ruleParam ) ) (otherlv_13= ',' ( (lv_param_14_0= ruleParam ) ) )* )? otherlv_15= ')' )* otherlv_16= '};' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:454:1: (otherlv_0= '{' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )? otherlv_7= ')' (otherlv_8= ',' ( (lv_type_9_0= RULE_ID ) ) ( (lv_a_name_10_0= RULE_ID ) ) otherlv_11= '(' ( ( (lv_param_12_0= ruleParam ) ) (otherlv_13= ',' ( (lv_param_14_0= ruleParam ) ) )* )? otherlv_15= ')' )* otherlv_16= '};' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:454:1: (otherlv_0= '{' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )? otherlv_7= ')' (otherlv_8= ',' ( (lv_type_9_0= RULE_ID ) ) ( (lv_a_name_10_0= RULE_ID ) ) otherlv_11= '(' ( ( (lv_param_12_0= ruleParam ) ) (otherlv_13= ',' ( (lv_param_14_0= ruleParam ) ) )* )? otherlv_15= ')' )* otherlv_16= '};' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:454:3: otherlv_0= '{' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )? otherlv_7= ')' (otherlv_8= ',' ( (lv_type_9_0= RULE_ID ) ) ( (lv_a_name_10_0= RULE_ID ) ) otherlv_11= '(' ( ( (lv_param_12_0= ruleParam ) ) (otherlv_13= ',' ( (lv_param_14_0= ruleParam ) ) )* )? otherlv_15= ')' )* otherlv_16= '};'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleAltMethod860); 

                	newLeafNode(otherlv_0, grammarAccess.getAltMethodAccess().getLeftCurlyBracketKeyword_0());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:458:1: ( (lv_type_1_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:459:1: (lv_type_1_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:459:1: (lv_type_1_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:460:3: lv_type_1_0= RULE_ID
            {
            lv_type_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAltMethod877); 

            			newLeafNode(lv_type_1_0, grammarAccess.getAltMethodAccess().getTypeIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAltMethodRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"type",
                    		lv_type_1_0, 
                    		"ID");
            	    

            }


            }

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:476:2: ( (lv_name_2_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:477:1: (lv_name_2_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:477:1: (lv_name_2_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:478:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAltMethod899); 

            			newLeafNode(lv_name_2_0, grammarAccess.getAltMethodAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAltMethodRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleAltMethod916); 

                	newLeafNode(otherlv_3, grammarAccess.getAltMethodAccess().getLeftParenthesisKeyword_3());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:498:1: ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:498:2: ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )*
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:498:2: ( (lv_param_4_0= ruleParam ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:499:1: (lv_param_4_0= ruleParam )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:499:1: (lv_param_4_0= ruleParam )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:500:3: lv_param_4_0= ruleParam
                    {
                     
                    	        newCompositeNode(grammarAccess.getAltMethodAccess().getParamParamParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleParam_in_ruleAltMethod938);
                    lv_param_4_0=ruleParam();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAltMethodRule());
                    	        }
                           		add(
                           			current, 
                           			"param",
                            		lv_param_4_0, 
                            		"Param");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:516:2: (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==17) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:516:4: otherlv_5= ',' ( (lv_param_6_0= ruleParam ) )
                    	    {
                    	    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleAltMethod951); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getAltMethodAccess().getCommaKeyword_4_1_0());
                    	        
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:520:1: ( (lv_param_6_0= ruleParam ) )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:521:1: (lv_param_6_0= ruleParam )
                    	    {
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:521:1: (lv_param_6_0= ruleParam )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:522:3: lv_param_6_0= ruleParam
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAltMethodAccess().getParamParamParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParam_in_ruleAltMethod972);
                    	    lv_param_6_0=ruleParam();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAltMethodRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"param",
                    	            		lv_param_6_0, 
                    	            		"Param");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleAltMethod988); 

                	newLeafNode(otherlv_7, grammarAccess.getAltMethodAccess().getRightParenthesisKeyword_5());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:542:1: (otherlv_8= ',' ( (lv_type_9_0= RULE_ID ) ) ( (lv_a_name_10_0= RULE_ID ) ) otherlv_11= '(' ( ( (lv_param_12_0= ruleParam ) ) (otherlv_13= ',' ( (lv_param_14_0= ruleParam ) ) )* )? otherlv_15= ')' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==17) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:542:3: otherlv_8= ',' ( (lv_type_9_0= RULE_ID ) ) ( (lv_a_name_10_0= RULE_ID ) ) otherlv_11= '(' ( ( (lv_param_12_0= ruleParam ) ) (otherlv_13= ',' ( (lv_param_14_0= ruleParam ) ) )* )? otherlv_15= ')'
            	    {
            	    otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleAltMethod1001); 

            	        	newLeafNode(otherlv_8, grammarAccess.getAltMethodAccess().getCommaKeyword_6_0());
            	        
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:546:1: ( (lv_type_9_0= RULE_ID ) )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:547:1: (lv_type_9_0= RULE_ID )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:547:1: (lv_type_9_0= RULE_ID )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:548:3: lv_type_9_0= RULE_ID
            	    {
            	    lv_type_9_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAltMethod1018); 

            	    			newLeafNode(lv_type_9_0, grammarAccess.getAltMethodAccess().getTypeIDTerminalRuleCall_6_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getAltMethodRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"type",
            	            		lv_type_9_0, 
            	            		"ID");
            	    	    

            	    }


            	    }

            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:564:2: ( (lv_a_name_10_0= RULE_ID ) )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:565:1: (lv_a_name_10_0= RULE_ID )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:565:1: (lv_a_name_10_0= RULE_ID )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:566:3: lv_a_name_10_0= RULE_ID
            	    {
            	    lv_a_name_10_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAltMethod1040); 

            	    			newLeafNode(lv_a_name_10_0, grammarAccess.getAltMethodAccess().getA_nameIDTerminalRuleCall_6_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getAltMethodRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"a_name",
            	            		lv_a_name_10_0, 
            	            		"ID");
            	    	    

            	    }


            	    }

            	    otherlv_11=(Token)match(input,16,FOLLOW_16_in_ruleAltMethod1057); 

            	        	newLeafNode(otherlv_11, grammarAccess.getAltMethodAccess().getLeftParenthesisKeyword_6_3());
            	        
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:586:1: ( ( (lv_param_12_0= ruleParam ) ) (otherlv_13= ',' ( (lv_param_14_0= ruleParam ) ) )* )?
            	    int alt11=2;
            	    int LA11_0 = input.LA(1);

            	    if ( (LA11_0==RULE_ID) ) {
            	        alt11=1;
            	    }
            	    switch (alt11) {
            	        case 1 :
            	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:586:2: ( (lv_param_12_0= ruleParam ) ) (otherlv_13= ',' ( (lv_param_14_0= ruleParam ) ) )*
            	            {
            	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:586:2: ( (lv_param_12_0= ruleParam ) )
            	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:587:1: (lv_param_12_0= ruleParam )
            	            {
            	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:587:1: (lv_param_12_0= ruleParam )
            	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:588:3: lv_param_12_0= ruleParam
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getAltMethodAccess().getParamParamParserRuleCall_6_4_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleParam_in_ruleAltMethod1079);
            	            lv_param_12_0=ruleParam();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getAltMethodRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"param",
            	                    		lv_param_12_0, 
            	                    		"Param");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }


            	            }

            	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:604:2: (otherlv_13= ',' ( (lv_param_14_0= ruleParam ) ) )*
            	            loop10:
            	            do {
            	                int alt10=2;
            	                int LA10_0 = input.LA(1);

            	                if ( (LA10_0==17) ) {
            	                    alt10=1;
            	                }


            	                switch (alt10) {
            	            	case 1 :
            	            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:604:4: otherlv_13= ',' ( (lv_param_14_0= ruleParam ) )
            	            	    {
            	            	    otherlv_13=(Token)match(input,17,FOLLOW_17_in_ruleAltMethod1092); 

            	            	        	newLeafNode(otherlv_13, grammarAccess.getAltMethodAccess().getCommaKeyword_6_4_1_0());
            	            	        
            	            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:608:1: ( (lv_param_14_0= ruleParam ) )
            	            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:609:1: (lv_param_14_0= ruleParam )
            	            	    {
            	            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:609:1: (lv_param_14_0= ruleParam )
            	            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:610:3: lv_param_14_0= ruleParam
            	            	    {
            	            	     
            	            	    	        newCompositeNode(grammarAccess.getAltMethodAccess().getParamParamParserRuleCall_6_4_1_1_0()); 
            	            	    	    
            	            	    pushFollow(FOLLOW_ruleParam_in_ruleAltMethod1113);
            	            	    lv_param_14_0=ruleParam();

            	            	    state._fsp--;


            	            	    	        if (current==null) {
            	            	    	            current = createModelElementForParent(grammarAccess.getAltMethodRule());
            	            	    	        }
            	            	           		add(
            	            	           			current, 
            	            	           			"param",
            	            	            		lv_param_14_0, 
            	            	            		"Param");
            	            	    	        afterParserOrEnumRuleCall();
            	            	    	    

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop10;
            	                }
            	            } while (true);


            	            }
            	            break;

            	    }

            	    otherlv_15=(Token)match(input,19,FOLLOW_19_in_ruleAltMethod1129); 

            	        	newLeafNode(otherlv_15, grammarAccess.getAltMethodAccess().getRightParenthesisKeyword_6_5());
            	        

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_16=(Token)match(input,20,FOLLOW_20_in_ruleAltMethod1143); 

                	newLeafNode(otherlv_16, grammarAccess.getAltMethodAccess().getRightCurlyBracketSemicolonKeyword_7());
                

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
    // $ANTLR end "ruleAltMethod"


    // $ANTLR start "entryRuleOptMethod"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:642:1: entryRuleOptMethod returns [EObject current=null] : iv_ruleOptMethod= ruleOptMethod EOF ;
    public final EObject entryRuleOptMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptMethod = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:643:2: (iv_ruleOptMethod= ruleOptMethod EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:644:2: iv_ruleOptMethod= ruleOptMethod EOF
            {
             newCompositeNode(grammarAccess.getOptMethodRule()); 
            pushFollow(FOLLOW_ruleOptMethod_in_entryRuleOptMethod1179);
            iv_ruleOptMethod=ruleOptMethod();

            state._fsp--;

             current =iv_ruleOptMethod; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOptMethod1189); 

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
    // $ANTLR end "entryRuleOptMethod"


    // $ANTLR start "ruleOptMethod"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:651:1: ruleOptMethod returns [EObject current=null] : (otherlv_0= '[' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )? otherlv_7= ');' otherlv_8= ']' ) ;
    public final EObject ruleOptMethod() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_type_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_param_4_0 = null;

        EObject lv_param_6_0 = null;


         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:654:28: ( (otherlv_0= '[' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )? otherlv_7= ');' otherlv_8= ']' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:655:1: (otherlv_0= '[' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )? otherlv_7= ');' otherlv_8= ']' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:655:1: (otherlv_0= '[' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )? otherlv_7= ');' otherlv_8= ']' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:655:3: otherlv_0= '[' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )? otherlv_7= ');' otherlv_8= ']'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleOptMethod1226); 

                	newLeafNode(otherlv_0, grammarAccess.getOptMethodAccess().getLeftSquareBracketKeyword_0());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:659:1: ( (lv_type_1_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:660:1: (lv_type_1_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:660:1: (lv_type_1_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:661:3: lv_type_1_0= RULE_ID
            {
            lv_type_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOptMethod1243); 

            			newLeafNode(lv_type_1_0, grammarAccess.getOptMethodAccess().getTypeIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOptMethodRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"type",
                    		lv_type_1_0, 
                    		"ID");
            	    

            }


            }

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:677:2: ( (lv_name_2_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:678:1: (lv_name_2_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:678:1: (lv_name_2_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:679:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOptMethod1265); 

            			newLeafNode(lv_name_2_0, grammarAccess.getOptMethodAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOptMethodRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleOptMethod1282); 

                	newLeafNode(otherlv_3, grammarAccess.getOptMethodAccess().getLeftParenthesisKeyword_3());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:699:1: ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:699:2: ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )*
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:699:2: ( (lv_param_4_0= ruleParam ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:700:1: (lv_param_4_0= ruleParam )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:700:1: (lv_param_4_0= ruleParam )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:701:3: lv_param_4_0= ruleParam
                    {
                     
                    	        newCompositeNode(grammarAccess.getOptMethodAccess().getParamParamParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleParam_in_ruleOptMethod1304);
                    lv_param_4_0=ruleParam();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOptMethodRule());
                    	        }
                           		add(
                           			current, 
                           			"param",
                            		lv_param_4_0, 
                            		"Param");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:717:2: (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==17) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:717:4: otherlv_5= ',' ( (lv_param_6_0= ruleParam ) )
                    	    {
                    	    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleOptMethod1317); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getOptMethodAccess().getCommaKeyword_4_1_0());
                    	        
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:721:1: ( (lv_param_6_0= ruleParam ) )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:722:1: (lv_param_6_0= ruleParam )
                    	    {
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:722:1: (lv_param_6_0= ruleParam )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:723:3: lv_param_6_0= ruleParam
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getOptMethodAccess().getParamParamParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParam_in_ruleOptMethod1338);
                    	    lv_param_6_0=ruleParam();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getOptMethodRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"param",
                    	            		lv_param_6_0, 
                    	            		"Param");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,18,FOLLOW_18_in_ruleOptMethod1354); 

                	newLeafNode(otherlv_7, grammarAccess.getOptMethodAccess().getRightParenthesisSemicolonKeyword_5());
                
            otherlv_8=(Token)match(input,22,FOLLOW_22_in_ruleOptMethod1366); 

                	newLeafNode(otherlv_8, grammarAccess.getOptMethodAccess().getRightSquareBracketKeyword_6());
                

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
    // $ANTLR end "ruleOptMethod"


    // $ANTLR start "entryRuleParam"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:755:1: entryRuleParam returns [EObject current=null] : iv_ruleParam= ruleParam EOF ;
    public final EObject entryRuleParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParam = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:756:2: (iv_ruleParam= ruleParam EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:757:2: iv_ruleParam= ruleParam EOF
            {
             newCompositeNode(grammarAccess.getParamRule()); 
            pushFollow(FOLLOW_ruleParam_in_entryRuleParam1402);
            iv_ruleParam=ruleParam();

            state._fsp--;

             current =iv_ruleParam; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParam1412); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:764:1: ruleParam returns [EObject current=null] : ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleParam() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:767:28: ( ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:768:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:768:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:768:2: ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:768:2: ( (lv_type_0_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:769:1: (lv_type_0_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:769:1: (lv_type_0_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:770:3: lv_type_0_0= RULE_ID
            {
            lv_type_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParam1454); 

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

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:786:2: ( (lv_name_1_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:787:1: (lv_name_1_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:787:1: (lv_name_1_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:788:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParam1476); 

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


    // $ANTLR start "entryRuleBehavior"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:812:1: entryRuleBehavior returns [EObject current=null] : iv_ruleBehavior= ruleBehavior EOF ;
    public final EObject entryRuleBehavior() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehavior = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:813:2: (iv_ruleBehavior= ruleBehavior EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:814:2: iv_ruleBehavior= ruleBehavior EOF
            {
             newCompositeNode(grammarAccess.getBehaviorRule()); 
            pushFollow(FOLLOW_ruleBehavior_in_entryRuleBehavior1517);
            iv_ruleBehavior=ruleBehavior();

            state._fsp--;

             current =iv_ruleBehavior; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBehavior1527); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:821:1: ruleBehavior returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '(' ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= ');' ) ;
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
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:824:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '(' ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= ');' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:825:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '(' ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= ');' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:825:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '(' ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= ');' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:825:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '(' ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= ');'
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:825:2: ( (otherlv_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:826:1: (otherlv_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:826:1: (otherlv_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:827:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getBehaviorRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBehavior1572); 

            		newLeafNode(otherlv_0, grammarAccess.getBehaviorAccess().getInterfaceInterfaceCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleBehavior1584); 

                	newLeafNode(otherlv_1, grammarAccess.getBehaviorAccess().getEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleBehavior1596); 

                	newLeafNode(otherlv_2, grammarAccess.getBehaviorAccess().getLeftParenthesisKeyword_2());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:846:1: ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:846:2: ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:846:2: ( ( ruleFQN ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:847:1: ( ruleFQN )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:847:1: ( ruleFQN )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:848:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getBehaviorRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getBehaviorAccess().getCallMethodCrossReference_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleBehavior1620);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:861:2: (otherlv_4= '->' ( ( ruleFQN ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==24) ) {
                            int LA15_1 = input.LA(2);

                            if ( (LA15_1==RULE_ID) ) {
                                int LA15_2 = input.LA(3);

                                if ( ((LA15_2>=24 && LA15_2<=25)) ) {
                                    alt15=1;
                                }


                            }


                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:861:4: otherlv_4= '->' ( ( ruleFQN ) )
                    	    {
                    	    otherlv_4=(Token)match(input,24,FOLLOW_24_in_ruleBehavior1633); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getBehaviorAccess().getHyphenMinusGreaterThanSignKeyword_3_1_0());
                    	        
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:865:1: ( ( ruleFQN ) )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:866:1: ( ruleFQN )
                    	    {
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:866:1: ( ruleFQN )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:867:3: ruleFQN
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getBehaviorRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getBehaviorAccess().getCallMethodCrossReference_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFQN_in_ruleBehavior1656);
                    	    ruleFQN();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,24,FOLLOW_24_in_ruleBehavior1670); 

                        	newLeafNode(otherlv_6, grammarAccess.getBehaviorAccess().getHyphenMinusGreaterThanSignKeyword_3_2());
                        
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:884:1: ( (otherlv_7= RULE_ID ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:885:1: (otherlv_7= RULE_ID )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:885:1: (otherlv_7= RULE_ID )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:886:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getBehaviorRule());
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBehavior1690); 

                    		newLeafNode(otherlv_7, grammarAccess.getBehaviorAccess().getEndInterfaceCrossReference_3_3_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,18,FOLLOW_18_in_ruleBehavior1704); 

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


    // $ANTLR start "entryRuleUncertainBehavior"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:911:1: entryRuleUncertainBehavior returns [EObject current=null] : iv_ruleUncertainBehavior= ruleUncertainBehavior EOF ;
    public final EObject entryRuleUncertainBehavior() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUncertainBehavior = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:912:2: (iv_ruleUncertainBehavior= ruleUncertainBehavior EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:913:2: iv_ruleUncertainBehavior= ruleUncertainBehavior EOF
            {
             newCompositeNode(grammarAccess.getUncertainBehaviorRule()); 
            pushFollow(FOLLOW_ruleUncertainBehavior_in_entryRuleUncertainBehavior1742);
            iv_ruleUncertainBehavior=ruleUncertainBehavior();

            state._fsp--;

             current =iv_ruleUncertainBehavior; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUncertainBehavior1752); 

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
    // $ANTLR end "entryRuleUncertainBehavior"


    // $ANTLR start "ruleUncertainBehavior"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:920:1: ruleUncertainBehavior returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'extends' ( (otherlv_2= RULE_ID ) ) otherlv_3= '=' otherlv_4= '(' ( ( ( ( ruleFQN ) ) | (otherlv_6= '[' ( ( ruleFQN ) ) otherlv_8= ']' ) ) (otherlv_9= '->' ( ( ( ruleFQN ) ) | (otherlv_11= '[' ( ( ruleFQN ) ) otherlv_13= ']' ) ) )* otherlv_14= '->' ( (otherlv_15= RULE_ID ) ) )? otherlv_16= ');' ) ;
    public final EObject ruleUncertainBehavior() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;

         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:923:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'extends' ( (otherlv_2= RULE_ID ) ) otherlv_3= '=' otherlv_4= '(' ( ( ( ( ruleFQN ) ) | (otherlv_6= '[' ( ( ruleFQN ) ) otherlv_8= ']' ) ) (otherlv_9= '->' ( ( ( ruleFQN ) ) | (otherlv_11= '[' ( ( ruleFQN ) ) otherlv_13= ']' ) ) )* otherlv_14= '->' ( (otherlv_15= RULE_ID ) ) )? otherlv_16= ');' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:924:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'extends' ( (otherlv_2= RULE_ID ) ) otherlv_3= '=' otherlv_4= '(' ( ( ( ( ruleFQN ) ) | (otherlv_6= '[' ( ( ruleFQN ) ) otherlv_8= ']' ) ) (otherlv_9= '->' ( ( ( ruleFQN ) ) | (otherlv_11= '[' ( ( ruleFQN ) ) otherlv_13= ']' ) ) )* otherlv_14= '->' ( (otherlv_15= RULE_ID ) ) )? otherlv_16= ');' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:924:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'extends' ( (otherlv_2= RULE_ID ) ) otherlv_3= '=' otherlv_4= '(' ( ( ( ( ruleFQN ) ) | (otherlv_6= '[' ( ( ruleFQN ) ) otherlv_8= ']' ) ) (otherlv_9= '->' ( ( ( ruleFQN ) ) | (otherlv_11= '[' ( ( ruleFQN ) ) otherlv_13= ']' ) ) )* otherlv_14= '->' ( (otherlv_15= RULE_ID ) ) )? otherlv_16= ');' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:924:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'extends' ( (otherlv_2= RULE_ID ) ) otherlv_3= '=' otherlv_4= '(' ( ( ( ( ruleFQN ) ) | (otherlv_6= '[' ( ( ruleFQN ) ) otherlv_8= ']' ) ) (otherlv_9= '->' ( ( ( ruleFQN ) ) | (otherlv_11= '[' ( ( ruleFQN ) ) otherlv_13= ']' ) ) )* otherlv_14= '->' ( (otherlv_15= RULE_ID ) ) )? otherlv_16= ');'
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:924:2: ( (lv_name_0_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:925:1: (lv_name_0_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:925:1: (lv_name_0_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:926:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUncertainBehavior1794); 

            			newLeafNode(lv_name_0_0, grammarAccess.getUncertainBehaviorAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUncertainBehaviorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleUncertainBehavior1811); 

                	newLeafNode(otherlv_1, grammarAccess.getUncertainBehaviorAccess().getExtendsKeyword_1());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:946:1: ( (otherlv_2= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:947:1: (otherlv_2= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:947:1: (otherlv_2= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:948:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getUncertainBehaviorRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUncertainBehavior1831); 

            		newLeafNode(otherlv_2, grammarAccess.getUncertainBehaviorAccess().getInterfaceInterfaceCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleUncertainBehavior1843); 

                	newLeafNode(otherlv_3, grammarAccess.getUncertainBehaviorAccess().getEqualsSignKeyword_3());
                
            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleUncertainBehavior1855); 

                	newLeafNode(otherlv_4, grammarAccess.getUncertainBehaviorAccess().getLeftParenthesisKeyword_4());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:967:1: ( ( ( ( ruleFQN ) ) | (otherlv_6= '[' ( ( ruleFQN ) ) otherlv_8= ']' ) ) (otherlv_9= '->' ( ( ( ruleFQN ) ) | (otherlv_11= '[' ( ( ruleFQN ) ) otherlv_13= ']' ) ) )* otherlv_14= '->' ( (otherlv_15= RULE_ID ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID||LA20_0==21) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:967:2: ( ( ( ruleFQN ) ) | (otherlv_6= '[' ( ( ruleFQN ) ) otherlv_8= ']' ) ) (otherlv_9= '->' ( ( ( ruleFQN ) ) | (otherlv_11= '[' ( ( ruleFQN ) ) otherlv_13= ']' ) ) )* otherlv_14= '->' ( (otherlv_15= RULE_ID ) )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:967:2: ( ( ( ruleFQN ) ) | (otherlv_6= '[' ( ( ruleFQN ) ) otherlv_8= ']' ) )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==RULE_ID) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==21) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:967:3: ( ( ruleFQN ) )
                            {
                            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:967:3: ( ( ruleFQN ) )
                            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:968:1: ( ruleFQN )
                            {
                            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:968:1: ( ruleFQN )
                            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:969:3: ruleFQN
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getUncertainBehaviorRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getUncertainBehaviorAccess().getCallSuperMethodCrossReference_5_0_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleFQN_in_ruleUncertainBehavior1880);
                            ruleFQN();

                            state._fsp--;

                             
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:983:6: (otherlv_6= '[' ( ( ruleFQN ) ) otherlv_8= ']' )
                            {
                            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:983:6: (otherlv_6= '[' ( ( ruleFQN ) ) otherlv_8= ']' )
                            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:983:8: otherlv_6= '[' ( ( ruleFQN ) ) otherlv_8= ']'
                            {
                            otherlv_6=(Token)match(input,21,FOLLOW_21_in_ruleUncertainBehavior1899); 

                                	newLeafNode(otherlv_6, grammarAccess.getUncertainBehaviorAccess().getLeftSquareBracketKeyword_5_0_1_0());
                                
                            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:987:1: ( ( ruleFQN ) )
                            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:988:1: ( ruleFQN )
                            {
                            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:988:1: ( ruleFQN )
                            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:989:3: ruleFQN
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getUncertainBehaviorRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getUncertainBehaviorAccess().getCallSuperMethodCrossReference_5_0_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleFQN_in_ruleUncertainBehavior1922);
                            ruleFQN();

                            state._fsp--;

                             
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_8=(Token)match(input,22,FOLLOW_22_in_ruleUncertainBehavior1934); 

                                	newLeafNode(otherlv_8, grammarAccess.getUncertainBehaviorAccess().getRightSquareBracketKeyword_5_0_1_2());
                                

                            }


                            }
                            break;

                    }

                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1006:3: (otherlv_9= '->' ( ( ( ruleFQN ) ) | (otherlv_11= '[' ( ( ruleFQN ) ) otherlv_13= ']' ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==24) ) {
                            int LA19_1 = input.LA(2);

                            if ( (LA19_1==RULE_ID) ) {
                                int LA19_2 = input.LA(3);

                                if ( ((LA19_2>=24 && LA19_2<=25)) ) {
                                    alt19=1;
                                }


                            }
                            else if ( (LA19_1==21) ) {
                                alt19=1;
                            }


                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1006:5: otherlv_9= '->' ( ( ( ruleFQN ) ) | (otherlv_11= '[' ( ( ruleFQN ) ) otherlv_13= ']' ) )
                    	    {
                    	    otherlv_9=(Token)match(input,24,FOLLOW_24_in_ruleUncertainBehavior1949); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getUncertainBehaviorAccess().getHyphenMinusGreaterThanSignKeyword_5_1_0());
                    	        
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1010:1: ( ( ( ruleFQN ) ) | (otherlv_11= '[' ( ( ruleFQN ) ) otherlv_13= ']' ) )
                    	    int alt18=2;
                    	    int LA18_0 = input.LA(1);

                    	    if ( (LA18_0==RULE_ID) ) {
                    	        alt18=1;
                    	    }
                    	    else if ( (LA18_0==21) ) {
                    	        alt18=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 18, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt18) {
                    	        case 1 :
                    	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1010:2: ( ( ruleFQN ) )
                    	            {
                    	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1010:2: ( ( ruleFQN ) )
                    	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1011:1: ( ruleFQN )
                    	            {
                    	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1011:1: ( ruleFQN )
                    	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1012:3: ruleFQN
                    	            {

                    	            			if (current==null) {
                    	            	            current = createModelElement(grammarAccess.getUncertainBehaviorRule());
                    	            	        }
                    	                    
                    	             
                    	            	        newCompositeNode(grammarAccess.getUncertainBehaviorAccess().getCallSuperMethodCrossReference_5_1_1_0_0()); 
                    	            	    
                    	            pushFollow(FOLLOW_ruleFQN_in_ruleUncertainBehavior1973);
                    	            ruleFQN();

                    	            state._fsp--;

                    	             
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1026:6: (otherlv_11= '[' ( ( ruleFQN ) ) otherlv_13= ']' )
                    	            {
                    	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1026:6: (otherlv_11= '[' ( ( ruleFQN ) ) otherlv_13= ']' )
                    	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1026:8: otherlv_11= '[' ( ( ruleFQN ) ) otherlv_13= ']'
                    	            {
                    	            otherlv_11=(Token)match(input,21,FOLLOW_21_in_ruleUncertainBehavior1992); 

                    	                	newLeafNode(otherlv_11, grammarAccess.getUncertainBehaviorAccess().getLeftSquareBracketKeyword_5_1_1_1_0());
                    	                
                    	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1030:1: ( ( ruleFQN ) )
                    	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1031:1: ( ruleFQN )
                    	            {
                    	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1031:1: ( ruleFQN )
                    	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1032:3: ruleFQN
                    	            {

                    	            			if (current==null) {
                    	            	            current = createModelElement(grammarAccess.getUncertainBehaviorRule());
                    	            	        }
                    	                    
                    	             
                    	            	        newCompositeNode(grammarAccess.getUncertainBehaviorAccess().getCallSuperMethodCrossReference_5_1_1_1_1_0()); 
                    	            	    
                    	            pushFollow(FOLLOW_ruleFQN_in_ruleUncertainBehavior2015);
                    	            ruleFQN();

                    	            state._fsp--;

                    	             
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }

                    	            otherlv_13=(Token)match(input,22,FOLLOW_22_in_ruleUncertainBehavior2027); 

                    	                	newLeafNode(otherlv_13, grammarAccess.getUncertainBehaviorAccess().getRightSquareBracketKeyword_5_1_1_1_2());
                    	                

                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,24,FOLLOW_24_in_ruleUncertainBehavior2043); 

                        	newLeafNode(otherlv_14, grammarAccess.getUncertainBehaviorAccess().getHyphenMinusGreaterThanSignKeyword_5_2());
                        
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1053:1: ( (otherlv_15= RULE_ID ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1054:1: (otherlv_15= RULE_ID )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1054:1: (otherlv_15= RULE_ID )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1055:3: otherlv_15= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getUncertainBehaviorRule());
                    	        }
                            
                    otherlv_15=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUncertainBehavior2063); 

                    		newLeafNode(otherlv_15, grammarAccess.getUncertainBehaviorAccess().getEndInterfaceCrossReference_5_3_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_16=(Token)match(input,18,FOLLOW_18_in_ruleUncertainBehavior2077); 

                	newLeafNode(otherlv_16, grammarAccess.getUncertainBehaviorAccess().getRightParenthesisSemicolonKeyword_6());
                

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
    // $ANTLR end "ruleUncertainBehavior"


    // $ANTLR start "entryRuleFQN"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1078:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1079:2: (iv_ruleFQN= ruleFQN EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1080:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN2114);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN2125); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1087:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1090:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1091:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1091:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1091:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN2165); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1098:1: (kw= '.' this_ID_2= RULE_ID )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==25) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:1099:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,25,FOLLOW_25_in_ruleFQN2184); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN2199); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop21;
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
    public static final BitSet FOLLOW_ruleInterface_in_ruleModel132 = new BitSet(new long[]{0x0000000000008812L});
    public static final BitSet FOLLOW_ruleUncertainInterface_in_ruleModel159 = new BitSet(new long[]{0x0000000000008812L});
    public static final BitSet FOLLOW_ruleBehavior_in_ruleModel183 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleUncertainBehavior_in_ruleModel210 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleUncertainInterface_in_entryRuleUncertainInterface248 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUncertainInterface258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleUncertainInterface295 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUncertainInterface312 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_ruleUncertainInterface330 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUncertainInterface350 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleUncertainInterface364 = new BitSet(new long[]{0x0000000000206000L});
    public static final BitSet FOLLOW_ruleAltMethod_in_ruleUncertainInterface386 = new BitSet(new long[]{0x0000000000206000L});
    public static final BitSet FOLLOW_ruleOptMethod_in_ruleUncertainInterface413 = new BitSet(new long[]{0x0000000000206000L});
    public static final BitSet FOLLOW_14_in_ruleUncertainInterface427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterface_in_entryRuleInterface463 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterface473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleInterface510 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInterface527 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleInterface544 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleMethod_in_ruleInterface565 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleInterface578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethod_in_entryRuleMethod614 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethod624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMethod666 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMethod688 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleMethod705 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleMethod727 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleMethod740 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleMethod761 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleMethod777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAltMethod_in_entryRuleAltMethod813 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAltMethod823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleAltMethod860 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAltMethod877 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAltMethod899 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleAltMethod916 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleAltMethod938 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_17_in_ruleAltMethod951 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleAltMethod972 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_19_in_ruleAltMethod988 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_17_in_ruleAltMethod1001 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAltMethod1018 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAltMethod1040 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleAltMethod1057 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleAltMethod1079 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_17_in_ruleAltMethod1092 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleAltMethod1113 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_19_in_ruleAltMethod1129 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_20_in_ruleAltMethod1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptMethod_in_entryRuleOptMethod1179 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOptMethod1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleOptMethod1226 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOptMethod1243 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOptMethod1265 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleOptMethod1282 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleOptMethod1304 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleOptMethod1317 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleOptMethod1338 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleOptMethod1354 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleOptMethod1366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParam_in_entryRuleParam1402 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParam1412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParam1454 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParam1476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBehavior_in_entryRuleBehavior1517 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBehavior1527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBehavior1572 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleBehavior1584 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleBehavior1596 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleBehavior1620 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleBehavior1633 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleBehavior1656 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleBehavior1670 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBehavior1690 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleBehavior1704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUncertainBehavior_in_entryRuleUncertainBehavior1742 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUncertainBehavior1752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUncertainBehavior1794 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleUncertainBehavior1811 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUncertainBehavior1831 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleUncertainBehavior1843 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleUncertainBehavior1855 = new BitSet(new long[]{0x0000000000240010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleUncertainBehavior1880 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_21_in_ruleUncertainBehavior1899 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleUncertainBehavior1922 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleUncertainBehavior1934 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleUncertainBehavior1949 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleUncertainBehavior1973 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_21_in_ruleUncertainBehavior1992 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleUncertainBehavior2015 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleUncertainBehavior2027 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleUncertainBehavior2043 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUncertainBehavior2063 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleUncertainBehavior2077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN2114 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN2165 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleFQN2184 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN2199 = new BitSet(new long[]{0x0000000002000002L});

}