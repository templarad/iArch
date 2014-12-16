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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:76:1: ruleModel returns [EObject current=null] : ( ( ( (lv_interfaces_0_0= ruleInterface ) ) | ( (lv_u_interfaces_1_0= ruleUncertainInterface ) ) )* ( (lv_behaviors_2_0= ruleBehavior ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_interfaces_0_0 = null;

        EObject lv_u_interfaces_1_0 = null;

        EObject lv_behaviors_2_0 = null;


         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:79:28: ( ( ( ( (lv_interfaces_0_0= ruleInterface ) ) | ( (lv_u_interfaces_1_0= ruleUncertainInterface ) ) )* ( (lv_behaviors_2_0= ruleBehavior ) )* ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:80:1: ( ( ( (lv_interfaces_0_0= ruleInterface ) ) | ( (lv_u_interfaces_1_0= ruleUncertainInterface ) ) )* ( (lv_behaviors_2_0= ruleBehavior ) )* )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:80:1: ( ( ( (lv_interfaces_0_0= ruleInterface ) ) | ( (lv_u_interfaces_1_0= ruleUncertainInterface ) ) )* ( (lv_behaviors_2_0= ruleBehavior ) )* )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:80:2: ( ( (lv_interfaces_0_0= ruleInterface ) ) | ( (lv_u_interfaces_1_0= ruleUncertainInterface ) ) )* ( (lv_behaviors_2_0= ruleBehavior ) )*
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

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:117:4: ( (lv_behaviors_2_0= ruleBehavior ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:118:1: (lv_behaviors_2_0= ruleBehavior )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:118:1: (lv_behaviors_2_0= ruleBehavior )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:119:3: lv_behaviors_2_0= ruleBehavior
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getBehaviorsBehaviorParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleBehavior_in_ruleModel182);
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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:143:1: entryRuleUncertainInterface returns [EObject current=null] : iv_ruleUncertainInterface= ruleUncertainInterface EOF ;
    public final EObject entryRuleUncertainInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUncertainInterface = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:144:2: (iv_ruleUncertainInterface= ruleUncertainInterface EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:145:2: iv_ruleUncertainInterface= ruleUncertainInterface EOF
            {
             newCompositeNode(grammarAccess.getUncertainInterfaceRule()); 
            pushFollow(FOLLOW_ruleUncertainInterface_in_entryRuleUncertainInterface219);
            iv_ruleUncertainInterface=ruleUncertainInterface();

            state._fsp--;

             current =iv_ruleUncertainInterface; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUncertainInterface229); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:152:1: ruleUncertainInterface returns [EObject current=null] : (otherlv_0= 'interface uncertain' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( ( (lv_altmethods_5_0= ruleAltMethod ) ) | ( (lv_optmethods_6_0= ruleOptMethod ) ) )* otherlv_7= '}' ) ;
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
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:155:28: ( (otherlv_0= 'interface uncertain' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( ( (lv_altmethods_5_0= ruleAltMethod ) ) | ( (lv_optmethods_6_0= ruleOptMethod ) ) )* otherlv_7= '}' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:156:1: (otherlv_0= 'interface uncertain' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( ( (lv_altmethods_5_0= ruleAltMethod ) ) | ( (lv_optmethods_6_0= ruleOptMethod ) ) )* otherlv_7= '}' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:156:1: (otherlv_0= 'interface uncertain' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( ( (lv_altmethods_5_0= ruleAltMethod ) ) | ( (lv_optmethods_6_0= ruleOptMethod ) ) )* otherlv_7= '}' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:156:3: otherlv_0= 'interface uncertain' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( ( (lv_altmethods_5_0= ruleAltMethod ) ) | ( (lv_optmethods_6_0= ruleOptMethod ) ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleUncertainInterface266); 

                	newLeafNode(otherlv_0, grammarAccess.getUncertainInterfaceAccess().getInterfaceUncertainKeyword_0());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:160:1: ( (lv_name_1_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:161:1: (lv_name_1_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:161:1: (lv_name_1_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:162:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUncertainInterface283); 

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

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:178:2: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:178:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleUncertainInterface301); 

                        	newLeafNode(otherlv_2, grammarAccess.getUncertainInterfaceAccess().getExtendsKeyword_2_0());
                        
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:182:1: ( (otherlv_3= RULE_ID ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:183:1: (otherlv_3= RULE_ID )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:183:1: (otherlv_3= RULE_ID )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:184:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getUncertainInterfaceRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUncertainInterface321); 

                    		newLeafNode(otherlv_3, grammarAccess.getUncertainInterfaceAccess().getSuperInterfaceInterfaceCrossReference_2_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleUncertainInterface335); 

                	newLeafNode(otherlv_4, grammarAccess.getUncertainInterfaceAccess().getLeftCurlyBracketKeyword_3());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:199:1: ( ( (lv_altmethods_5_0= ruleAltMethod ) ) | ( (lv_optmethods_6_0= ruleOptMethod ) ) )*
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
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:199:2: ( (lv_altmethods_5_0= ruleAltMethod ) )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:199:2: ( (lv_altmethods_5_0= ruleAltMethod ) )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:200:1: (lv_altmethods_5_0= ruleAltMethod )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:200:1: (lv_altmethods_5_0= ruleAltMethod )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:201:3: lv_altmethods_5_0= ruleAltMethod
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getUncertainInterfaceAccess().getAltmethodsAltMethodParserRuleCall_4_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAltMethod_in_ruleUncertainInterface357);
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
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:218:6: ( (lv_optmethods_6_0= ruleOptMethod ) )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:218:6: ( (lv_optmethods_6_0= ruleOptMethod ) )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:219:1: (lv_optmethods_6_0= ruleOptMethod )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:219:1: (lv_optmethods_6_0= ruleOptMethod )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:220:3: lv_optmethods_6_0= ruleOptMethod
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getUncertainInterfaceAccess().getOptmethodsOptMethodParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleOptMethod_in_ruleUncertainInterface384);
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

            otherlv_7=(Token)match(input,14,FOLLOW_14_in_ruleUncertainInterface398); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:248:1: entryRuleInterface returns [EObject current=null] : iv_ruleInterface= ruleInterface EOF ;
    public final EObject entryRuleInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterface = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:249:2: (iv_ruleInterface= ruleInterface EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:250:2: iv_ruleInterface= ruleInterface EOF
            {
             newCompositeNode(grammarAccess.getInterfaceRule()); 
            pushFollow(FOLLOW_ruleInterface_in_entryRuleInterface434);
            iv_ruleInterface=ruleInterface();

            state._fsp--;

             current =iv_ruleInterface; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterface444); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:257:1: ruleInterface returns [EObject current=null] : (otherlv_0= 'interface component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' ) ;
    public final EObject ruleInterface() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_methods_3_0 = null;


         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:260:28: ( (otherlv_0= 'interface component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:261:1: (otherlv_0= 'interface component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:261:1: (otherlv_0= 'interface component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:261:3: otherlv_0= 'interface component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleInterface481); 

                	newLeafNode(otherlv_0, grammarAccess.getInterfaceAccess().getInterfaceComponentKeyword_0());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:265:1: ( (lv_name_1_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:266:1: (lv_name_1_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:266:1: (lv_name_1_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:267:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInterface498); 

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

            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleInterface515); 

                	newLeafNode(otherlv_2, grammarAccess.getInterfaceAccess().getLeftCurlyBracketKeyword_2());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:287:1: ( (lv_methods_3_0= ruleMethod ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:288:1: (lv_methods_3_0= ruleMethod )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:288:1: (lv_methods_3_0= ruleMethod )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:289:3: lv_methods_3_0= ruleMethod
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getInterfaceAccess().getMethodsMethodParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMethod_in_ruleInterface536);
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

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleInterface549); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:317:1: entryRuleMethod returns [EObject current=null] : iv_ruleMethod= ruleMethod EOF ;
    public final EObject entryRuleMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethod = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:318:2: (iv_ruleMethod= ruleMethod EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:319:2: iv_ruleMethod= ruleMethod EOF
            {
             newCompositeNode(grammarAccess.getMethodRule()); 
            pushFollow(FOLLOW_ruleMethod_in_entryRuleMethod585);
            iv_ruleMethod=ruleMethod();

            state._fsp--;

             current =iv_ruleMethod; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethod595); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:326:1: ruleMethod returns [EObject current=null] : ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ');' ) ;
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
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:329:28: ( ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ');' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:330:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ');' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:330:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ');' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:330:2: ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ');'
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:330:2: ( (lv_type_0_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:331:1: (lv_type_0_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:331:1: (lv_type_0_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:332:3: lv_type_0_0= RULE_ID
            {
            lv_type_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMethod637); 

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

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:348:2: ( (lv_name_1_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:349:1: (lv_name_1_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:349:1: (lv_name_1_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:350:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMethod659); 

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

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleMethod676); 

                	newLeafNode(otherlv_2, grammarAccess.getMethodAccess().getLeftParenthesisKeyword_2());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:370:1: ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:370:2: ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )*
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:370:2: ( (lv_param_3_0= ruleParam ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:371:1: (lv_param_3_0= ruleParam )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:371:1: (lv_param_3_0= ruleParam )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:372:3: lv_param_3_0= ruleParam
                    {
                     
                    	        newCompositeNode(grammarAccess.getMethodAccess().getParamParamParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleParam_in_ruleMethod698);
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

                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:388:2: (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==17) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:388:4: otherlv_4= ',' ( (lv_param_5_0= ruleParam ) )
                    	    {
                    	    otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleMethod711); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getMethodAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:392:1: ( (lv_param_5_0= ruleParam ) )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:393:1: (lv_param_5_0= ruleParam )
                    	    {
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:393:1: (lv_param_5_0= ruleParam )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:394:3: lv_param_5_0= ruleParam
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getMethodAccess().getParamParamParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParam_in_ruleMethod732);
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

            otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleMethod748); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:422:1: entryRuleAltMethod returns [EObject current=null] : iv_ruleAltMethod= ruleAltMethod EOF ;
    public final EObject entryRuleAltMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAltMethod = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:423:2: (iv_ruleAltMethod= ruleAltMethod EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:424:2: iv_ruleAltMethod= ruleAltMethod EOF
            {
             newCompositeNode(grammarAccess.getAltMethodRule()); 
            pushFollow(FOLLOW_ruleAltMethod_in_entryRuleAltMethod784);
            iv_ruleAltMethod=ruleAltMethod();

            state._fsp--;

             current =iv_ruleAltMethod; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAltMethod794); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:431:1: ruleAltMethod returns [EObject current=null] : (otherlv_0= '{' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )? otherlv_7= ')' (otherlv_8= ',' ( (lv_type_9_0= RULE_ID ) ) ( (lv_a_name_10_0= RULE_ID ) ) otherlv_11= '(' ( ( (lv_param_12_0= ruleParam ) ) (otherlv_13= ',' ( (lv_param_14_0= ruleParam ) ) )* )? otherlv_15= ')' )* otherlv_16= '};' ) ;
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
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:434:28: ( (otherlv_0= '{' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )? otherlv_7= ')' (otherlv_8= ',' ( (lv_type_9_0= RULE_ID ) ) ( (lv_a_name_10_0= RULE_ID ) ) otherlv_11= '(' ( ( (lv_param_12_0= ruleParam ) ) (otherlv_13= ',' ( (lv_param_14_0= ruleParam ) ) )* )? otherlv_15= ')' )* otherlv_16= '};' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:435:1: (otherlv_0= '{' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )? otherlv_7= ')' (otherlv_8= ',' ( (lv_type_9_0= RULE_ID ) ) ( (lv_a_name_10_0= RULE_ID ) ) otherlv_11= '(' ( ( (lv_param_12_0= ruleParam ) ) (otherlv_13= ',' ( (lv_param_14_0= ruleParam ) ) )* )? otherlv_15= ')' )* otherlv_16= '};' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:435:1: (otherlv_0= '{' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )? otherlv_7= ')' (otherlv_8= ',' ( (lv_type_9_0= RULE_ID ) ) ( (lv_a_name_10_0= RULE_ID ) ) otherlv_11= '(' ( ( (lv_param_12_0= ruleParam ) ) (otherlv_13= ',' ( (lv_param_14_0= ruleParam ) ) )* )? otherlv_15= ')' )* otherlv_16= '};' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:435:3: otherlv_0= '{' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )? otherlv_7= ')' (otherlv_8= ',' ( (lv_type_9_0= RULE_ID ) ) ( (lv_a_name_10_0= RULE_ID ) ) otherlv_11= '(' ( ( (lv_param_12_0= ruleParam ) ) (otherlv_13= ',' ( (lv_param_14_0= ruleParam ) ) )* )? otherlv_15= ')' )* otherlv_16= '};'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleAltMethod831); 

                	newLeafNode(otherlv_0, grammarAccess.getAltMethodAccess().getLeftCurlyBracketKeyword_0());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:439:1: ( (lv_type_1_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:440:1: (lv_type_1_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:440:1: (lv_type_1_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:441:3: lv_type_1_0= RULE_ID
            {
            lv_type_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAltMethod848); 

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

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:457:2: ( (lv_name_2_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:458:1: (lv_name_2_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:458:1: (lv_name_2_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:459:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAltMethod870); 

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

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleAltMethod887); 

                	newLeafNode(otherlv_3, grammarAccess.getAltMethodAccess().getLeftParenthesisKeyword_3());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:479:1: ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:479:2: ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )*
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:479:2: ( (lv_param_4_0= ruleParam ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:480:1: (lv_param_4_0= ruleParam )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:480:1: (lv_param_4_0= ruleParam )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:481:3: lv_param_4_0= ruleParam
                    {
                     
                    	        newCompositeNode(grammarAccess.getAltMethodAccess().getParamParamParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleParam_in_ruleAltMethod909);
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

                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:497:2: (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==17) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:497:4: otherlv_5= ',' ( (lv_param_6_0= ruleParam ) )
                    	    {
                    	    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleAltMethod922); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getAltMethodAccess().getCommaKeyword_4_1_0());
                    	        
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:501:1: ( (lv_param_6_0= ruleParam ) )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:502:1: (lv_param_6_0= ruleParam )
                    	    {
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:502:1: (lv_param_6_0= ruleParam )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:503:3: lv_param_6_0= ruleParam
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAltMethodAccess().getParamParamParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParam_in_ruleAltMethod943);
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

            otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleAltMethod959); 

                	newLeafNode(otherlv_7, grammarAccess.getAltMethodAccess().getRightParenthesisKeyword_5());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:523:1: (otherlv_8= ',' ( (lv_type_9_0= RULE_ID ) ) ( (lv_a_name_10_0= RULE_ID ) ) otherlv_11= '(' ( ( (lv_param_12_0= ruleParam ) ) (otherlv_13= ',' ( (lv_param_14_0= ruleParam ) ) )* )? otherlv_15= ')' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==17) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:523:3: otherlv_8= ',' ( (lv_type_9_0= RULE_ID ) ) ( (lv_a_name_10_0= RULE_ID ) ) otherlv_11= '(' ( ( (lv_param_12_0= ruleParam ) ) (otherlv_13= ',' ( (lv_param_14_0= ruleParam ) ) )* )? otherlv_15= ')'
            	    {
            	    otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleAltMethod972); 

            	        	newLeafNode(otherlv_8, grammarAccess.getAltMethodAccess().getCommaKeyword_6_0());
            	        
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:527:1: ( (lv_type_9_0= RULE_ID ) )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:528:1: (lv_type_9_0= RULE_ID )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:528:1: (lv_type_9_0= RULE_ID )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:529:3: lv_type_9_0= RULE_ID
            	    {
            	    lv_type_9_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAltMethod989); 

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

            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:545:2: ( (lv_a_name_10_0= RULE_ID ) )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:546:1: (lv_a_name_10_0= RULE_ID )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:546:1: (lv_a_name_10_0= RULE_ID )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:547:3: lv_a_name_10_0= RULE_ID
            	    {
            	    lv_a_name_10_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAltMethod1011); 

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

            	    otherlv_11=(Token)match(input,16,FOLLOW_16_in_ruleAltMethod1028); 

            	        	newLeafNode(otherlv_11, grammarAccess.getAltMethodAccess().getLeftParenthesisKeyword_6_3());
            	        
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:567:1: ( ( (lv_param_12_0= ruleParam ) ) (otherlv_13= ',' ( (lv_param_14_0= ruleParam ) ) )* )?
            	    int alt11=2;
            	    int LA11_0 = input.LA(1);

            	    if ( (LA11_0==RULE_ID) ) {
            	        alt11=1;
            	    }
            	    switch (alt11) {
            	        case 1 :
            	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:567:2: ( (lv_param_12_0= ruleParam ) ) (otherlv_13= ',' ( (lv_param_14_0= ruleParam ) ) )*
            	            {
            	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:567:2: ( (lv_param_12_0= ruleParam ) )
            	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:568:1: (lv_param_12_0= ruleParam )
            	            {
            	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:568:1: (lv_param_12_0= ruleParam )
            	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:569:3: lv_param_12_0= ruleParam
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getAltMethodAccess().getParamParamParserRuleCall_6_4_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleParam_in_ruleAltMethod1050);
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

            	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:585:2: (otherlv_13= ',' ( (lv_param_14_0= ruleParam ) ) )*
            	            loop10:
            	            do {
            	                int alt10=2;
            	                int LA10_0 = input.LA(1);

            	                if ( (LA10_0==17) ) {
            	                    alt10=1;
            	                }


            	                switch (alt10) {
            	            	case 1 :
            	            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:585:4: otherlv_13= ',' ( (lv_param_14_0= ruleParam ) )
            	            	    {
            	            	    otherlv_13=(Token)match(input,17,FOLLOW_17_in_ruleAltMethod1063); 

            	            	        	newLeafNode(otherlv_13, grammarAccess.getAltMethodAccess().getCommaKeyword_6_4_1_0());
            	            	        
            	            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:589:1: ( (lv_param_14_0= ruleParam ) )
            	            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:590:1: (lv_param_14_0= ruleParam )
            	            	    {
            	            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:590:1: (lv_param_14_0= ruleParam )
            	            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:591:3: lv_param_14_0= ruleParam
            	            	    {
            	            	     
            	            	    	        newCompositeNode(grammarAccess.getAltMethodAccess().getParamParamParserRuleCall_6_4_1_1_0()); 
            	            	    	    
            	            	    pushFollow(FOLLOW_ruleParam_in_ruleAltMethod1084);
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

            	    otherlv_15=(Token)match(input,19,FOLLOW_19_in_ruleAltMethod1100); 

            	        	newLeafNode(otherlv_15, grammarAccess.getAltMethodAccess().getRightParenthesisKeyword_6_5());
            	        

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_16=(Token)match(input,20,FOLLOW_20_in_ruleAltMethod1114); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:623:1: entryRuleOptMethod returns [EObject current=null] : iv_ruleOptMethod= ruleOptMethod EOF ;
    public final EObject entryRuleOptMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptMethod = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:624:2: (iv_ruleOptMethod= ruleOptMethod EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:625:2: iv_ruleOptMethod= ruleOptMethod EOF
            {
             newCompositeNode(grammarAccess.getOptMethodRule()); 
            pushFollow(FOLLOW_ruleOptMethod_in_entryRuleOptMethod1150);
            iv_ruleOptMethod=ruleOptMethod();

            state._fsp--;

             current =iv_ruleOptMethod; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOptMethod1160); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:632:1: ruleOptMethod returns [EObject current=null] : (otherlv_0= '[' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )? otherlv_7= ');' otherlv_8= ']' ) ;
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
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:635:28: ( (otherlv_0= '[' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )? otherlv_7= ');' otherlv_8= ']' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:636:1: (otherlv_0= '[' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )? otherlv_7= ');' otherlv_8= ']' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:636:1: (otherlv_0= '[' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )? otherlv_7= ');' otherlv_8= ']' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:636:3: otherlv_0= '[' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )? otherlv_7= ');' otherlv_8= ']'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleOptMethod1197); 

                	newLeafNode(otherlv_0, grammarAccess.getOptMethodAccess().getLeftSquareBracketKeyword_0());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:640:1: ( (lv_type_1_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:641:1: (lv_type_1_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:641:1: (lv_type_1_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:642:3: lv_type_1_0= RULE_ID
            {
            lv_type_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOptMethod1214); 

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

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:658:2: ( (lv_name_2_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:659:1: (lv_name_2_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:659:1: (lv_name_2_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:660:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOptMethod1236); 

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

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleOptMethod1253); 

                	newLeafNode(otherlv_3, grammarAccess.getOptMethodAccess().getLeftParenthesisKeyword_3());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:680:1: ( ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:680:2: ( (lv_param_4_0= ruleParam ) ) (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )*
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:680:2: ( (lv_param_4_0= ruleParam ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:681:1: (lv_param_4_0= ruleParam )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:681:1: (lv_param_4_0= ruleParam )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:682:3: lv_param_4_0= ruleParam
                    {
                     
                    	        newCompositeNode(grammarAccess.getOptMethodAccess().getParamParamParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleParam_in_ruleOptMethod1275);
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

                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:698:2: (otherlv_5= ',' ( (lv_param_6_0= ruleParam ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==17) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:698:4: otherlv_5= ',' ( (lv_param_6_0= ruleParam ) )
                    	    {
                    	    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleOptMethod1288); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getOptMethodAccess().getCommaKeyword_4_1_0());
                    	        
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:702:1: ( (lv_param_6_0= ruleParam ) )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:703:1: (lv_param_6_0= ruleParam )
                    	    {
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:703:1: (lv_param_6_0= ruleParam )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:704:3: lv_param_6_0= ruleParam
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getOptMethodAccess().getParamParamParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParam_in_ruleOptMethod1309);
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

            otherlv_7=(Token)match(input,18,FOLLOW_18_in_ruleOptMethod1325); 

                	newLeafNode(otherlv_7, grammarAccess.getOptMethodAccess().getRightParenthesisSemicolonKeyword_5());
                
            otherlv_8=(Token)match(input,22,FOLLOW_22_in_ruleOptMethod1337); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:736:1: entryRuleParam returns [EObject current=null] : iv_ruleParam= ruleParam EOF ;
    public final EObject entryRuleParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParam = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:737:2: (iv_ruleParam= ruleParam EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:738:2: iv_ruleParam= ruleParam EOF
            {
             newCompositeNode(grammarAccess.getParamRule()); 
            pushFollow(FOLLOW_ruleParam_in_entryRuleParam1373);
            iv_ruleParam=ruleParam();

            state._fsp--;

             current =iv_ruleParam; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParam1383); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:745:1: ruleParam returns [EObject current=null] : ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleParam() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:748:28: ( ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:749:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:749:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:749:2: ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:749:2: ( (lv_type_0_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:750:1: (lv_type_0_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:750:1: (lv_type_0_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:751:3: lv_type_0_0= RULE_ID
            {
            lv_type_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParam1425); 

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

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:767:2: ( (lv_name_1_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:768:1: (lv_name_1_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:768:1: (lv_name_1_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:769:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParam1447); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:793:1: entryRuleBehavior returns [EObject current=null] : iv_ruleBehavior= ruleBehavior EOF ;
    public final EObject entryRuleBehavior() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehavior = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:794:2: (iv_ruleBehavior= ruleBehavior EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:795:2: iv_ruleBehavior= ruleBehavior EOF
            {
             newCompositeNode(grammarAccess.getBehaviorRule()); 
            pushFollow(FOLLOW_ruleBehavior_in_entryRuleBehavior1488);
            iv_ruleBehavior=ruleBehavior();

            state._fsp--;

             current =iv_ruleBehavior; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBehavior1498); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:802:1: ruleBehavior returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '(' ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= ');' ) ;
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
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:805:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '(' ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= ');' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:806:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '(' ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= ');' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:806:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '(' ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= ');' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:806:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '(' ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= ');'
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:806:2: ( (otherlv_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:807:1: (otherlv_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:807:1: (otherlv_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:808:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getBehaviorRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBehavior1543); 

            		newLeafNode(otherlv_0, grammarAccess.getBehaviorAccess().getInterfaceInterfaceCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleBehavior1555); 

                	newLeafNode(otherlv_1, grammarAccess.getBehaviorAccess().getEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleBehavior1567); 

                	newLeafNode(otherlv_2, grammarAccess.getBehaviorAccess().getLeftParenthesisKeyword_2());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:827:1: ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:827:2: ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:827:2: ( ( ruleFQN ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:828:1: ( ruleFQN )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:828:1: ( ruleFQN )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:829:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getBehaviorRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getBehaviorAccess().getCallMethodCrossReference_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleBehavior1591);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:842:2: (otherlv_4= '->' ( ( ruleFQN ) ) )*
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
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:842:4: otherlv_4= '->' ( ( ruleFQN ) )
                    	    {
                    	    otherlv_4=(Token)match(input,24,FOLLOW_24_in_ruleBehavior1604); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getBehaviorAccess().getHyphenMinusGreaterThanSignKeyword_3_1_0());
                    	        
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:846:1: ( ( ruleFQN ) )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:847:1: ( ruleFQN )
                    	    {
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:847:1: ( ruleFQN )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:848:3: ruleFQN
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getBehaviorRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getBehaviorAccess().getCallMethodCrossReference_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFQN_in_ruleBehavior1627);
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

                    otherlv_6=(Token)match(input,24,FOLLOW_24_in_ruleBehavior1641); 

                        	newLeafNode(otherlv_6, grammarAccess.getBehaviorAccess().getHyphenMinusGreaterThanSignKeyword_3_2());
                        
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:865:1: ( (otherlv_7= RULE_ID ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:866:1: (otherlv_7= RULE_ID )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:866:1: (otherlv_7= RULE_ID )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:867:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getBehaviorRule());
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBehavior1661); 

                    		newLeafNode(otherlv_7, grammarAccess.getBehaviorAccess().getEndInterfaceCrossReference_3_3_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,18,FOLLOW_18_in_ruleBehavior1675); 

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


    // $ANTLR start "entryRuleFQN"
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:890:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:891:2: (iv_ruleFQN= ruleFQN EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:892:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN1712);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN1723); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:899:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:902:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:903:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:903:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:903:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN1763); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:910:1: (kw= '.' this_ID_2= RULE_ID )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==25) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:911:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,25,FOLLOW_25_in_ruleFQN1782); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN1797); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop17;
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
    public static final BitSet FOLLOW_ruleBehavior_in_ruleModel182 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleUncertainInterface_in_entryRuleUncertainInterface219 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUncertainInterface229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleUncertainInterface266 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUncertainInterface283 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_ruleUncertainInterface301 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUncertainInterface321 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleUncertainInterface335 = new BitSet(new long[]{0x0000000000206000L});
    public static final BitSet FOLLOW_ruleAltMethod_in_ruleUncertainInterface357 = new BitSet(new long[]{0x0000000000206000L});
    public static final BitSet FOLLOW_ruleOptMethod_in_ruleUncertainInterface384 = new BitSet(new long[]{0x0000000000206000L});
    public static final BitSet FOLLOW_14_in_ruleUncertainInterface398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterface_in_entryRuleInterface434 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterface444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleInterface481 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInterface498 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleInterface515 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleMethod_in_ruleInterface536 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleInterface549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethod_in_entryRuleMethod585 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethod595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMethod637 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMethod659 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleMethod676 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleMethod698 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleMethod711 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleMethod732 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleMethod748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAltMethod_in_entryRuleAltMethod784 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAltMethod794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleAltMethod831 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAltMethod848 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAltMethod870 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleAltMethod887 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleAltMethod909 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_17_in_ruleAltMethod922 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleAltMethod943 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_19_in_ruleAltMethod959 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_17_in_ruleAltMethod972 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAltMethod989 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAltMethod1011 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleAltMethod1028 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleAltMethod1050 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_17_in_ruleAltMethod1063 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleAltMethod1084 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_19_in_ruleAltMethod1100 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_20_in_ruleAltMethod1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptMethod_in_entryRuleOptMethod1150 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOptMethod1160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleOptMethod1197 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOptMethod1214 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOptMethod1236 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleOptMethod1253 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleOptMethod1275 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleOptMethod1288 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleOptMethod1309 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleOptMethod1325 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleOptMethod1337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParam_in_entryRuleParam1373 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParam1383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParam1425 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParam1447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBehavior_in_entryRuleBehavior1488 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBehavior1498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBehavior1543 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleBehavior1555 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleBehavior1567 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleBehavior1591 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleBehavior1604 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleBehavior1627 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleBehavior1641 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBehavior1661 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleBehavior1675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN1712 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN1723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1763 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleFQN1782 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1797 = new BitSet(new long[]{0x0000000002000002L});

}