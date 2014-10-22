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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'interface uncertain'", "'u_extends'", "'{'", "'}'", "'interface component'", "'('", "','", "');'", "'.'", "'),'", "')'", "'};'", "'['", "']'", "'='", "'->'"
    };
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:152:1: ruleUncertainInterface returns [EObject current=null] : (otherlv_0= 'interface uncertain' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'u_extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' ( ( (lv_altmethods_5_0= ruleAltMethod ) ) | ( (lv_optmethods_6_0= ruleOptMethod ) ) )* otherlv_7= '}' ) ;
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
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:155:28: ( (otherlv_0= 'interface uncertain' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'u_extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' ( ( (lv_altmethods_5_0= ruleAltMethod ) ) | ( (lv_optmethods_6_0= ruleOptMethod ) ) )* otherlv_7= '}' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:156:1: (otherlv_0= 'interface uncertain' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'u_extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' ( ( (lv_altmethods_5_0= ruleAltMethod ) ) | ( (lv_optmethods_6_0= ruleOptMethod ) ) )* otherlv_7= '}' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:156:1: (otherlv_0= 'interface uncertain' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'u_extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' ( ( (lv_altmethods_5_0= ruleAltMethod ) ) | ( (lv_optmethods_6_0= ruleOptMethod ) ) )* otherlv_7= '}' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:156:3: otherlv_0= 'interface uncertain' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'u_extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' ( ( (lv_altmethods_5_0= ruleAltMethod ) ) | ( (lv_optmethods_6_0= ruleOptMethod ) ) )* otherlv_7= '}'
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

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleUncertainInterface300); 

                	newLeafNode(otherlv_2, grammarAccess.getUncertainInterfaceAccess().getU_extendsKeyword_2());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:182:1: ( (otherlv_3= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:183:1: (otherlv_3= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:183:1: (otherlv_3= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:184:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getUncertainInterfaceRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUncertainInterface320); 

            		newLeafNode(otherlv_3, grammarAccess.getUncertainInterfaceAccess().getSuperInterfacesInterfaceCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleUncertainInterface332); 

                	newLeafNode(otherlv_4, grammarAccess.getUncertainInterfaceAccess().getLeftCurlyBracketKeyword_4());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:199:1: ( ( (lv_altmethods_5_0= ruleAltMethod ) ) | ( (lv_optmethods_6_0= ruleOptMethod ) ) )*
            loop3:
            do {
                int alt3=3;
                switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA3_2 = input.LA(2);

                    if ( (LA3_2==19) ) {
                        int LA3_5 = input.LA(3);

                        if ( (LA3_5==13) ) {
                            alt3=1;
                        }
                        else if ( (LA3_5==23) ) {
                            alt3=2;
                        }


                    }


                    }
                    break;
                case 13:
                    {
                    alt3=1;
                    }
                    break;
                case 23:
                    {
                    alt3=2;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:199:2: ( (lv_altmethods_5_0= ruleAltMethod ) )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:199:2: ( (lv_altmethods_5_0= ruleAltMethod ) )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:200:1: (lv_altmethods_5_0= ruleAltMethod )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:200:1: (lv_altmethods_5_0= ruleAltMethod )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:201:3: lv_altmethods_5_0= ruleAltMethod
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getUncertainInterfaceAccess().getAltmethodsAltMethodParserRuleCall_5_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAltMethod_in_ruleUncertainInterface354);
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
            	     
            	    	        newCompositeNode(grammarAccess.getUncertainInterfaceAccess().getOptmethodsOptMethodParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleOptMethod_in_ruleUncertainInterface381);
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
            	    break loop3;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_14_in_ruleUncertainInterface395); 

                	newLeafNode(otherlv_7, grammarAccess.getUncertainInterfaceAccess().getRightCurlyBracketKeyword_6());
                

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
            pushFollow(FOLLOW_ruleInterface_in_entryRuleInterface431);
            iv_ruleInterface=ruleInterface();

            state._fsp--;

             current =iv_ruleInterface; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterface441); 

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
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleInterface478); 

                	newLeafNode(otherlv_0, grammarAccess.getInterfaceAccess().getInterfaceComponentKeyword_0());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:265:1: ( (lv_name_1_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:266:1: (lv_name_1_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:266:1: (lv_name_1_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:267:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInterface495); 

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

            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleInterface512); 

                	newLeafNode(otherlv_2, grammarAccess.getInterfaceAccess().getLeftCurlyBracketKeyword_2());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:287:1: ( (lv_methods_3_0= ruleMethod ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:288:1: (lv_methods_3_0= ruleMethod )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:288:1: (lv_methods_3_0= ruleMethod )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:289:3: lv_methods_3_0= ruleMethod
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getInterfaceAccess().getMethodsMethodParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMethod_in_ruleInterface533);
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
            	    break loop4;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleInterface546); 

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
            pushFollow(FOLLOW_ruleMethod_in_entryRuleMethod582);
            iv_ruleMethod=ruleMethod();

            state._fsp--;

             current =iv_ruleMethod; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethod592); 

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
            lv_type_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMethod634); 

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
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMethod656); 

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

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleMethod673); 

                	newLeafNode(otherlv_2, grammarAccess.getMethodAccess().getLeftParenthesisKeyword_2());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:370:1: ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
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
                    	    
                    pushFollow(FOLLOW_ruleParam_in_ruleMethod695);
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
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==17) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:388:4: otherlv_4= ',' ( (lv_param_5_0= ruleParam ) )
                    	    {
                    	    otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleMethod708); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getMethodAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:392:1: ( (lv_param_5_0= ruleParam ) )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:393:1: (lv_param_5_0= ruleParam )
                    	    {
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:393:1: (lv_param_5_0= ruleParam )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:394:3: lv_param_5_0= ruleParam
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getMethodAccess().getParamParamParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParam_in_ruleMethod729);
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
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleMethod745); 

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
            pushFollow(FOLLOW_ruleAltMethod_in_entryRuleAltMethod781);
            iv_ruleAltMethod=ruleAltMethod();

            state._fsp--;

             current =iv_ruleAltMethod; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAltMethod791); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:431:1: ruleAltMethod returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? otherlv_2= '{' ( ( (lv_type_3_0= RULE_ID ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_param_6_0= ruleParam ) ) (otherlv_7= ',' ( (lv_param_8_0= ruleParam ) ) )* )? otherlv_9= '),' )* ( (lv_type_10_0= RULE_ID ) ) ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '(' ( ( (lv_param_13_0= ruleParam ) ) (otherlv_14= ',' ( (lv_param_15_0= ruleParam ) ) )* )? otherlv_16= ')' otherlv_17= '};' ) ;
    public final EObject ruleAltMethod() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_type_3_0=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token lv_type_10_0=null;
        Token lv_name_11_0=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        EObject lv_param_6_0 = null;

        EObject lv_param_8_0 = null;

        EObject lv_param_13_0 = null;

        EObject lv_param_15_0 = null;


         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:434:28: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? otherlv_2= '{' ( ( (lv_type_3_0= RULE_ID ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_param_6_0= ruleParam ) ) (otherlv_7= ',' ( (lv_param_8_0= ruleParam ) ) )* )? otherlv_9= '),' )* ( (lv_type_10_0= RULE_ID ) ) ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '(' ( ( (lv_param_13_0= ruleParam ) ) (otherlv_14= ',' ( (lv_param_15_0= ruleParam ) ) )* )? otherlv_16= ')' otherlv_17= '};' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:435:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? otherlv_2= '{' ( ( (lv_type_3_0= RULE_ID ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_param_6_0= ruleParam ) ) (otherlv_7= ',' ( (lv_param_8_0= ruleParam ) ) )* )? otherlv_9= '),' )* ( (lv_type_10_0= RULE_ID ) ) ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '(' ( ( (lv_param_13_0= ruleParam ) ) (otherlv_14= ',' ( (lv_param_15_0= ruleParam ) ) )* )? otherlv_16= ')' otherlv_17= '};' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:435:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? otherlv_2= '{' ( ( (lv_type_3_0= RULE_ID ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_param_6_0= ruleParam ) ) (otherlv_7= ',' ( (lv_param_8_0= ruleParam ) ) )* )? otherlv_9= '),' )* ( (lv_type_10_0= RULE_ID ) ) ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '(' ( ( (lv_param_13_0= ruleParam ) ) (otherlv_14= ',' ( (lv_param_15_0= ruleParam ) ) )* )? otherlv_16= ')' otherlv_17= '};' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:435:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? otherlv_2= '{' ( ( (lv_type_3_0= RULE_ID ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_param_6_0= ruleParam ) ) (otherlv_7= ',' ( (lv_param_8_0= ruleParam ) ) )* )? otherlv_9= '),' )* ( (lv_type_10_0= RULE_ID ) ) ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '(' ( ( (lv_param_13_0= ruleParam ) ) (otherlv_14= ',' ( (lv_param_15_0= ruleParam ) ) )* )? otherlv_16= ')' otherlv_17= '};'
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:435:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:435:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.'
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:435:3: ( (otherlv_0= RULE_ID ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:436:1: (otherlv_0= RULE_ID )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:436:1: (otherlv_0= RULE_ID )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:437:3: otherlv_0= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getAltMethodRule());
                    	        }
                            
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAltMethod837); 

                    		newLeafNode(otherlv_0, grammarAccess.getAltMethodAccess().getCallInterfaceInterfaceCrossReference_0_0_0()); 
                    	

                    }


                    }

                    otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleAltMethod849); 

                        	newLeafNode(otherlv_1, grammarAccess.getAltMethodAccess().getFullStopKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleAltMethod863); 

                	newLeafNode(otherlv_2, grammarAccess.getAltMethodAccess().getLeftCurlyBracketKeyword_1());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:456:1: ( ( (lv_type_3_0= RULE_ID ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_param_6_0= ruleParam ) ) (otherlv_7= ',' ( (lv_param_8_0= ruleParam ) ) )* )? otherlv_9= '),' )*
            loop10:
            do {
                int alt10=2;
                alt10 = dfa10.predict(input);
                switch (alt10) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:456:2: ( (lv_type_3_0= RULE_ID ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_param_6_0= ruleParam ) ) (otherlv_7= ',' ( (lv_param_8_0= ruleParam ) ) )* )? otherlv_9= '),'
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:456:2: ( (lv_type_3_0= RULE_ID ) )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:457:1: (lv_type_3_0= RULE_ID )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:457:1: (lv_type_3_0= RULE_ID )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:458:3: lv_type_3_0= RULE_ID
            	    {
            	    lv_type_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAltMethod881); 

            	    			newLeafNode(lv_type_3_0, grammarAccess.getAltMethodAccess().getTypeIDTerminalRuleCall_2_0_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getAltMethodRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"type",
            	            		lv_type_3_0, 
            	            		"ID");
            	    	    

            	    }


            	    }

            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:474:2: ( (lv_name_4_0= RULE_ID ) )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:475:1: (lv_name_4_0= RULE_ID )
            	    {
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:475:1: (lv_name_4_0= RULE_ID )
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:476:3: lv_name_4_0= RULE_ID
            	    {
            	    lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAltMethod903); 

            	    			newLeafNode(lv_name_4_0, grammarAccess.getAltMethodAccess().getNameIDTerminalRuleCall_2_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getAltMethodRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"name",
            	            		lv_name_4_0, 
            	            		"ID");
            	    	    

            	    }


            	    }

            	    otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleAltMethod920); 

            	        	newLeafNode(otherlv_5, grammarAccess.getAltMethodAccess().getLeftParenthesisKeyword_2_2());
            	        
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:496:1: ( ( (lv_param_6_0= ruleParam ) ) (otherlv_7= ',' ( (lv_param_8_0= ruleParam ) ) )* )?
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==RULE_ID) ) {
            	        alt9=1;
            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:496:2: ( (lv_param_6_0= ruleParam ) ) (otherlv_7= ',' ( (lv_param_8_0= ruleParam ) ) )*
            	            {
            	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:496:2: ( (lv_param_6_0= ruleParam ) )
            	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:497:1: (lv_param_6_0= ruleParam )
            	            {
            	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:497:1: (lv_param_6_0= ruleParam )
            	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:498:3: lv_param_6_0= ruleParam
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getAltMethodAccess().getParamParamParserRuleCall_2_3_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleParam_in_ruleAltMethod942);
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

            	            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:514:2: (otherlv_7= ',' ( (lv_param_8_0= ruleParam ) ) )*
            	            loop8:
            	            do {
            	                int alt8=2;
            	                int LA8_0 = input.LA(1);

            	                if ( (LA8_0==17) ) {
            	                    alt8=1;
            	                }


            	                switch (alt8) {
            	            	case 1 :
            	            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:514:4: otherlv_7= ',' ( (lv_param_8_0= ruleParam ) )
            	            	    {
            	            	    otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleAltMethod955); 

            	            	        	newLeafNode(otherlv_7, grammarAccess.getAltMethodAccess().getCommaKeyword_2_3_1_0());
            	            	        
            	            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:518:1: ( (lv_param_8_0= ruleParam ) )
            	            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:519:1: (lv_param_8_0= ruleParam )
            	            	    {
            	            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:519:1: (lv_param_8_0= ruleParam )
            	            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:520:3: lv_param_8_0= ruleParam
            	            	    {
            	            	     
            	            	    	        newCompositeNode(grammarAccess.getAltMethodAccess().getParamParamParserRuleCall_2_3_1_1_0()); 
            	            	    	    
            	            	    pushFollow(FOLLOW_ruleParam_in_ruleAltMethod976);
            	            	    lv_param_8_0=ruleParam();

            	            	    state._fsp--;


            	            	    	        if (current==null) {
            	            	    	            current = createModelElementForParent(grammarAccess.getAltMethodRule());
            	            	    	        }
            	            	           		add(
            	            	           			current, 
            	            	           			"param",
            	            	            		lv_param_8_0, 
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

            	    otherlv_9=(Token)match(input,20,FOLLOW_20_in_ruleAltMethod992); 

            	        	newLeafNode(otherlv_9, grammarAccess.getAltMethodAccess().getRightParenthesisCommaKeyword_2_4());
            	        

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:540:3: ( (lv_type_10_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:541:1: (lv_type_10_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:541:1: (lv_type_10_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:542:3: lv_type_10_0= RULE_ID
            {
            lv_type_10_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAltMethod1011); 

            			newLeafNode(lv_type_10_0, grammarAccess.getAltMethodAccess().getTypeIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAltMethodRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"type",
                    		lv_type_10_0, 
                    		"ID");
            	    

            }


            }

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:558:2: ( (lv_name_11_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:559:1: (lv_name_11_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:559:1: (lv_name_11_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:560:3: lv_name_11_0= RULE_ID
            {
            lv_name_11_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAltMethod1033); 

            			newLeafNode(lv_name_11_0, grammarAccess.getAltMethodAccess().getNameIDTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAltMethodRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_11_0, 
                    		"ID");
            	    

            }


            }

            otherlv_12=(Token)match(input,16,FOLLOW_16_in_ruleAltMethod1050); 

                	newLeafNode(otherlv_12, grammarAccess.getAltMethodAccess().getLeftParenthesisKeyword_5());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:580:1: ( ( (lv_param_13_0= ruleParam ) ) (otherlv_14= ',' ( (lv_param_15_0= ruleParam ) ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:580:2: ( (lv_param_13_0= ruleParam ) ) (otherlv_14= ',' ( (lv_param_15_0= ruleParam ) ) )*
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:580:2: ( (lv_param_13_0= ruleParam ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:581:1: (lv_param_13_0= ruleParam )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:581:1: (lv_param_13_0= ruleParam )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:582:3: lv_param_13_0= ruleParam
                    {
                     
                    	        newCompositeNode(grammarAccess.getAltMethodAccess().getParamParamParserRuleCall_6_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleParam_in_ruleAltMethod1072);
                    lv_param_13_0=ruleParam();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAltMethodRule());
                    	        }
                           		add(
                           			current, 
                           			"param",
                            		lv_param_13_0, 
                            		"Param");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:598:2: (otherlv_14= ',' ( (lv_param_15_0= ruleParam ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==17) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:598:4: otherlv_14= ',' ( (lv_param_15_0= ruleParam ) )
                    	    {
                    	    otherlv_14=(Token)match(input,17,FOLLOW_17_in_ruleAltMethod1085); 

                    	        	newLeafNode(otherlv_14, grammarAccess.getAltMethodAccess().getCommaKeyword_6_1_0());
                    	        
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:602:1: ( (lv_param_15_0= ruleParam ) )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:603:1: (lv_param_15_0= ruleParam )
                    	    {
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:603:1: (lv_param_15_0= ruleParam )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:604:3: lv_param_15_0= ruleParam
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAltMethodAccess().getParamParamParserRuleCall_6_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParam_in_ruleAltMethod1106);
                    	    lv_param_15_0=ruleParam();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAltMethodRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"param",
                    	            		lv_param_15_0, 
                    	            		"Param");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_16=(Token)match(input,21,FOLLOW_21_in_ruleAltMethod1122); 

                	newLeafNode(otherlv_16, grammarAccess.getAltMethodAccess().getRightParenthesisKeyword_7());
                
            otherlv_17=(Token)match(input,22,FOLLOW_22_in_ruleAltMethod1134); 

                	newLeafNode(otherlv_17, grammarAccess.getAltMethodAccess().getRightCurlyBracketSemicolonKeyword_8());
                

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:636:1: entryRuleOptMethod returns [EObject current=null] : iv_ruleOptMethod= ruleOptMethod EOF ;
    public final EObject entryRuleOptMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptMethod = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:637:2: (iv_ruleOptMethod= ruleOptMethod EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:638:2: iv_ruleOptMethod= ruleOptMethod EOF
            {
             newCompositeNode(grammarAccess.getOptMethodRule()); 
            pushFollow(FOLLOW_ruleOptMethod_in_entryRuleOptMethod1170);
            iv_ruleOptMethod=ruleOptMethod();

            state._fsp--;

             current =iv_ruleOptMethod; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOptMethod1180); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:645:1: ruleOptMethod returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? otherlv_2= '[' ( (lv_type_3_0= RULE_ID ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_param_6_0= ruleParam ) ) (otherlv_7= ',' ( (lv_param_8_0= ruleParam ) ) )* )? otherlv_9= ');' otherlv_10= ']' ) ;
    public final EObject ruleOptMethod() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_type_3_0=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_param_6_0 = null;

        EObject lv_param_8_0 = null;


         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:648:28: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? otherlv_2= '[' ( (lv_type_3_0= RULE_ID ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_param_6_0= ruleParam ) ) (otherlv_7= ',' ( (lv_param_8_0= ruleParam ) ) )* )? otherlv_9= ');' otherlv_10= ']' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:649:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? otherlv_2= '[' ( (lv_type_3_0= RULE_ID ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_param_6_0= ruleParam ) ) (otherlv_7= ',' ( (lv_param_8_0= ruleParam ) ) )* )? otherlv_9= ');' otherlv_10= ']' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:649:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? otherlv_2= '[' ( (lv_type_3_0= RULE_ID ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_param_6_0= ruleParam ) ) (otherlv_7= ',' ( (lv_param_8_0= ruleParam ) ) )* )? otherlv_9= ');' otherlv_10= ']' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:649:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? otherlv_2= '[' ( (lv_type_3_0= RULE_ID ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_param_6_0= ruleParam ) ) (otherlv_7= ',' ( (lv_param_8_0= ruleParam ) ) )* )? otherlv_9= ');' otherlv_10= ']'
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:649:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:649:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.'
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:649:3: ( (otherlv_0= RULE_ID ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:650:1: (otherlv_0= RULE_ID )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:650:1: (otherlv_0= RULE_ID )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:651:3: otherlv_0= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getOptMethodRule());
                    	        }
                            
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOptMethod1226); 

                    		newLeafNode(otherlv_0, grammarAccess.getOptMethodAccess().getCallInterfaceInterfaceCrossReference_0_0_0()); 
                    	

                    }


                    }

                    otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleOptMethod1238); 

                        	newLeafNode(otherlv_1, grammarAccess.getOptMethodAccess().getFullStopKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleOptMethod1252); 

                	newLeafNode(otherlv_2, grammarAccess.getOptMethodAccess().getLeftSquareBracketKeyword_1());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:670:1: ( (lv_type_3_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:671:1: (lv_type_3_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:671:1: (lv_type_3_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:672:3: lv_type_3_0= RULE_ID
            {
            lv_type_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOptMethod1269); 

            			newLeafNode(lv_type_3_0, grammarAccess.getOptMethodAccess().getTypeIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOptMethodRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"type",
                    		lv_type_3_0, 
                    		"ID");
            	    

            }


            }

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:688:2: ( (lv_name_4_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:689:1: (lv_name_4_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:689:1: (lv_name_4_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:690:3: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOptMethod1291); 

            			newLeafNode(lv_name_4_0, grammarAccess.getOptMethodAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOptMethodRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_4_0, 
                    		"ID");
            	    

            }


            }

            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleOptMethod1308); 

                	newLeafNode(otherlv_5, grammarAccess.getOptMethodAccess().getLeftParenthesisKeyword_4());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:710:1: ( ( (lv_param_6_0= ruleParam ) ) (otherlv_7= ',' ( (lv_param_8_0= ruleParam ) ) )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:710:2: ( (lv_param_6_0= ruleParam ) ) (otherlv_7= ',' ( (lv_param_8_0= ruleParam ) ) )*
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:710:2: ( (lv_param_6_0= ruleParam ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:711:1: (lv_param_6_0= ruleParam )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:711:1: (lv_param_6_0= ruleParam )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:712:3: lv_param_6_0= ruleParam
                    {
                     
                    	        newCompositeNode(grammarAccess.getOptMethodAccess().getParamParamParserRuleCall_5_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleParam_in_ruleOptMethod1330);
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

                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:728:2: (otherlv_7= ',' ( (lv_param_8_0= ruleParam ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==17) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:728:4: otherlv_7= ',' ( (lv_param_8_0= ruleParam ) )
                    	    {
                    	    otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleOptMethod1343); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getOptMethodAccess().getCommaKeyword_5_1_0());
                    	        
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:732:1: ( (lv_param_8_0= ruleParam ) )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:733:1: (lv_param_8_0= ruleParam )
                    	    {
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:733:1: (lv_param_8_0= ruleParam )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:734:3: lv_param_8_0= ruleParam
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getOptMethodAccess().getParamParamParserRuleCall_5_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParam_in_ruleOptMethod1364);
                    	    lv_param_8_0=ruleParam();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getOptMethodRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"param",
                    	            		lv_param_8_0, 
                    	            		"Param");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,18,FOLLOW_18_in_ruleOptMethod1380); 

                	newLeafNode(otherlv_9, grammarAccess.getOptMethodAccess().getRightParenthesisSemicolonKeyword_6());
                
            otherlv_10=(Token)match(input,24,FOLLOW_24_in_ruleOptMethod1392); 

                	newLeafNode(otherlv_10, grammarAccess.getOptMethodAccess().getRightSquareBracketKeyword_7());
                

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:766:1: entryRuleParam returns [EObject current=null] : iv_ruleParam= ruleParam EOF ;
    public final EObject entryRuleParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParam = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:767:2: (iv_ruleParam= ruleParam EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:768:2: iv_ruleParam= ruleParam EOF
            {
             newCompositeNode(grammarAccess.getParamRule()); 
            pushFollow(FOLLOW_ruleParam_in_entryRuleParam1428);
            iv_ruleParam=ruleParam();

            state._fsp--;

             current =iv_ruleParam; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParam1438); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:775:1: ruleParam returns [EObject current=null] : ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleParam() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:778:28: ( ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:779:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:779:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:779:2: ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:779:2: ( (lv_type_0_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:780:1: (lv_type_0_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:780:1: (lv_type_0_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:781:3: lv_type_0_0= RULE_ID
            {
            lv_type_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParam1480); 

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

            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:797:2: ( (lv_name_1_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:798:1: (lv_name_1_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:798:1: (lv_name_1_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:799:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParam1502); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:823:1: entryRuleBehavior returns [EObject current=null] : iv_ruleBehavior= ruleBehavior EOF ;
    public final EObject entryRuleBehavior() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehavior = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:824:2: (iv_ruleBehavior= ruleBehavior EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:825:2: iv_ruleBehavior= ruleBehavior EOF
            {
             newCompositeNode(grammarAccess.getBehaviorRule()); 
            pushFollow(FOLLOW_ruleBehavior_in_entryRuleBehavior1543);
            iv_ruleBehavior=ruleBehavior();

            state._fsp--;

             current =iv_ruleBehavior; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBehavior1553); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:832:1: ruleBehavior returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '(' ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= ');' ) ;
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
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:835:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '(' ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= ');' ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:836:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '(' ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= ');' )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:836:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '(' ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= ');' )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:836:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '(' ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= ');'
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:836:2: ( (otherlv_0= RULE_ID ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:837:1: (otherlv_0= RULE_ID )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:837:1: (otherlv_0= RULE_ID )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:838:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getBehaviorRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBehavior1598); 

            		newLeafNode(otherlv_0, grammarAccess.getBehaviorAccess().getInterfaceInterfaceCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleBehavior1610); 

                	newLeafNode(otherlv_1, grammarAccess.getBehaviorAccess().getEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleBehavior1622); 

                	newLeafNode(otherlv_2, grammarAccess.getBehaviorAccess().getLeftParenthesisKeyword_2());
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:857:1: ( ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:857:2: ( ( ruleFQN ) ) (otherlv_4= '->' ( ( ruleFQN ) ) )* otherlv_6= '->' ( (otherlv_7= RULE_ID ) )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:857:2: ( ( ruleFQN ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:858:1: ( ruleFQN )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:858:1: ( ruleFQN )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:859:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getBehaviorRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getBehaviorAccess().getCallMethodCrossReference_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleBehavior1646);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:872:2: (otherlv_4= '->' ( ( ruleFQN ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==26) ) {
                            int LA16_1 = input.LA(2);

                            if ( (LA16_1==RULE_ID) ) {
                                int LA16_2 = input.LA(3);

                                if ( (LA16_2==19||LA16_2==26) ) {
                                    alt16=1;
                                }


                            }


                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:872:4: otherlv_4= '->' ( ( ruleFQN ) )
                    	    {
                    	    otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleBehavior1659); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getBehaviorAccess().getHyphenMinusGreaterThanSignKeyword_3_1_0());
                    	        
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:876:1: ( ( ruleFQN ) )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:877:1: ( ruleFQN )
                    	    {
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:877:1: ( ruleFQN )
                    	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:878:3: ruleFQN
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getBehaviorRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getBehaviorAccess().getCallMethodCrossReference_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFQN_in_ruleBehavior1682);
                    	    ruleFQN();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,26,FOLLOW_26_in_ruleBehavior1696); 

                        	newLeafNode(otherlv_6, grammarAccess.getBehaviorAccess().getHyphenMinusGreaterThanSignKeyword_3_2());
                        
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:895:1: ( (otherlv_7= RULE_ID ) )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:896:1: (otherlv_7= RULE_ID )
                    {
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:896:1: (otherlv_7= RULE_ID )
                    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:897:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getBehaviorRule());
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBehavior1716); 

                    		newLeafNode(otherlv_7, grammarAccess.getBehaviorAccess().getEndInterfaceCrossReference_3_3_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,18,FOLLOW_18_in_ruleBehavior1730); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:920:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:921:2: (iv_ruleFQN= ruleFQN EOF )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:922:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN1767);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN1778); 

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
    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:929:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:932:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:933:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:933:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:933:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN1818); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:940:1: (kw= '.' this_ID_2= RULE_ID )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==19) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../jp.ac.kyushu.iarch.archdsl/src-gen/jp/ac/kyushu/iarch/archdsl/parser/antlr/internal/InternalArchDSL.g:941:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,19,FOLLOW_19_in_ruleFQN1837); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN1852); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop18;
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


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\13\uffff";
    static final String DFA10_eofS =
        "\13\uffff";
    static final String DFA10_minS =
        "\2\4\1\20\2\4\2\uffff\1\21\2\4\1\21";
    static final String DFA10_maxS =
        "\2\4\1\20\1\25\1\4\2\uffff\1\25\2\4\1\25";
    static final String DFA10_acceptS =
        "\5\uffff\1\2\1\1\4\uffff";
    static final String DFA10_specialS =
        "\13\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4\17\uffff\1\6\1\5",
            "\1\7",
            "",
            "",
            "\1\10\2\uffff\1\6\1\5",
            "\1\11",
            "\1\12",
            "\1\10\2\uffff\1\6\1\5"
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "()* loopback of 456:1: ( ( (lv_type_3_0= RULE_ID ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_param_6_0= ruleParam ) ) (otherlv_7= ',' ( (lv_param_8_0= ruleParam ) ) )* )? otherlv_9= '),' )*";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterface_in_ruleModel132 = new BitSet(new long[]{0x0000000000008812L});
    public static final BitSet FOLLOW_ruleUncertainInterface_in_ruleModel159 = new BitSet(new long[]{0x0000000000008812L});
    public static final BitSet FOLLOW_ruleBehavior_in_ruleModel182 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleUncertainInterface_in_entryRuleUncertainInterface219 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUncertainInterface229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleUncertainInterface266 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUncertainInterface283 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleUncertainInterface300 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUncertainInterface320 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleUncertainInterface332 = new BitSet(new long[]{0x0000000000806010L});
    public static final BitSet FOLLOW_ruleAltMethod_in_ruleUncertainInterface354 = new BitSet(new long[]{0x0000000000806010L});
    public static final BitSet FOLLOW_ruleOptMethod_in_ruleUncertainInterface381 = new BitSet(new long[]{0x0000000000806010L});
    public static final BitSet FOLLOW_14_in_ruleUncertainInterface395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterface_in_entryRuleInterface431 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterface441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleInterface478 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInterface495 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleInterface512 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleMethod_in_ruleInterface533 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleInterface546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethod_in_entryRuleMethod582 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethod592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMethod634 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMethod656 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleMethod673 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleMethod695 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleMethod708 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleMethod729 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleMethod745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAltMethod_in_entryRuleAltMethod781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAltMethod791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAltMethod837 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleAltMethod849 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleAltMethod863 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAltMethod881 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAltMethod903 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleAltMethod920 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleAltMethod942 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_17_in_ruleAltMethod955 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleAltMethod976 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_20_in_ruleAltMethod992 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAltMethod1011 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAltMethod1033 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleAltMethod1050 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleAltMethod1072 = new BitSet(new long[]{0x0000000000220000L});
    public static final BitSet FOLLOW_17_in_ruleAltMethod1085 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleAltMethod1106 = new BitSet(new long[]{0x0000000000220000L});
    public static final BitSet FOLLOW_21_in_ruleAltMethod1122 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleAltMethod1134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptMethod_in_entryRuleOptMethod1170 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOptMethod1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOptMethod1226 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleOptMethod1238 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleOptMethod1252 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOptMethod1269 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOptMethod1291 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleOptMethod1308 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleOptMethod1330 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleOptMethod1343 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleOptMethod1364 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleOptMethod1380 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleOptMethod1392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParam_in_entryRuleParam1428 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParam1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParam1480 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParam1502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBehavior_in_entryRuleBehavior1543 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBehavior1553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBehavior1598 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleBehavior1610 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleBehavior1622 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleBehavior1646 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleBehavior1659 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleBehavior1682 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleBehavior1696 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBehavior1716 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleBehavior1730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN1767 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN1778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1818 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleFQN1837 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1852 = new BitSet(new long[]{0x0000000000080002L});

}