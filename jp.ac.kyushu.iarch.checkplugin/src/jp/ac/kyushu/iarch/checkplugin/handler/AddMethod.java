package jp.ac.kyushu.iarch.checkplugin.handler;

import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Method;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.basefunction.controller.ArchModelController;
import jp.ac.kyushu.iarch.basefunction.reader.OldArchReader;
import jp.ac.kyushu.iarch.basefunction.reader.ProjectReader;
import jp.ac.kyushu.iarch.basefunction.reader.XMLreader;

import org.dom4j.Element;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ChildListPropertyDescriptor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ITrackedNodePosition;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import difflib.Delta;

public class AddMethod  implements IHandler{
	
	private final Logger logger = LoggerFactory.getLogger(AddMethod.class);
	static IJavaProject IJproject;
	Model archiface;
	Model oldArchface;
	IResource IJResourse;
	String Archclassname;
	 static String Methodname;
	 static String MethodnameOriginal;
	 static String MethodnameRevised;
	 static String OldPath="C:/Users/Liyuning/Desktop/difftest/difftest/gen/observerOld.arch";
	 static String NewPath="C:/Users/Liyuning/Desktop/iArch/ObserverPattern/arch/observer.arch";
	/*¡¡¡¡
	 String Archclassname="Subject.java";
	 String methodname="addObserver";
	*/
	// IResource st2=IJResourse.getProject().getFile("/src/"+Archclassname+".java");
	
	 private void initial(){
		 
		 IProject project = ProjectReader.getProject();
		 XMLreader x= new XMLreader(project);
	/*
		 OldArchReader oar = OldArchReader.getInstance();
		 IResource oldarchResouce = oar.getOldArchResouce(project);
		 if(oldarchResouce == null){
			 logger.error("Old Archface does not exist! ");
			 return;
		 }
		 */
		 
		 IJproject = (IJavaProject) XMLreader.getJavaProject();
		
		 // IResource IJResourse =  XMLreader.getClassDiagramResource();
		 
		 ArchModelController archmodel = new ArchModelController(x.getArchfileResource());
		 
		 archiface=archmodel.getModel();
		 
		/* 
		 ArchModelController archmodel2 = new ArchModelController(oldarchResouce);
		 oldArchface = archmodel2.getModel();
		 */
	 }
	 

	  
@Override
	 public Object execute(ExecutionEvent event) throws ExecutionException {
	
	initial();
	//File Comparator
	final	File originalFile = new File("C:/Users/Liyuning/Desktop/difftest/difftest/gen/observerOld.arch");
	final  File revisedFile = new File("C:/Users/Liyuning/Desktop/iArch/ObserverPattern/arch/observer.arch");
    

    FileComparator Filetest=new FileComparator(originalFile,revisedFile);
    
    
    
    try{
    	Filetest.getDeltas().get(0);
    	}
    catch (Exception e){
    	JOptionPane.showMessageDialog(null, "Nothing has changed!", "NO CHANGE", JOptionPane.ERROR_MESSAGE);  }
    try {
		for(Delta d : Filetest.getDeltas()){
			//System.out.println(d.getType());
			
			  if(d.getType().name()=="INSERT"){
				  
				  List<String> insert=(List<String>) d.getRevised().getLines();
				  
        		  for(String insertcode:insert){
        			  
        			  System.out.println(insertcode);
                  	 /*
             		  if(insertcode.equals("")){
             			  JOptionPane.showMessageDialog(null, "There's no change!", "NO CHANGE", JOptionPane.ERROR_MESSAGE); 
             		  }
             		  if(insertcode.equals("\t")){
    					  JOptionPane.showMessageDialog(null, "Nothing has changed!", "NO CHANGE", JOptionPane.ERROR_MESSAGE);
    				  }
    				  */
    				  insertcode= insertcode.trim();
    				  Pattern pattern = Pattern.compile("(.*\\s)([A-Za-z]*\\d|[A-Za-z]*)([\\((][\\s\\S]*[\\))]);");
    				  Matcher matcher = pattern.matcher(insertcode);
    				  while(matcher.find()){				  
    					  System.out.println(matcher.group(2).toString());
    					  insertcode= matcher.group(2).toString();
    					  System.out.println(insertcode);
    				  }
    				  
    				  for (Interface archiclass : archiface.getInterfaces()){
    						String className = archiclass.getName();
    						System.out.println(className);
    						for (Method m : archiclass.getMethods()){
    							String methodname = m.getName();
    							System.out.println(methodname);
    								if(methodname.equals(insertcode)){
    									Archclassname=className+".java";
    									Methodname=methodname;
    								}
    							}
    						}
    					insertmethod(Archclassname,Methodname);	
        		  	}
					
				
			  }
			  
			  else if(d.getType().name()=="CHANGE"){
				  
				  List<String> change=(List<String>) d.getRevised().getLines();
				  List<String> changeOriginal=(List<String>)d.getOriginal().getLines();
				  
				  for(String changeOriginalcode: changeOriginal){
					  
					  changeOriginalcode= changeOriginalcode.trim();
    				  Pattern pattern1 = Pattern.compile("(.*\\s)([A-Za-z]*\\d|[A-Za-z]*)([\\((][\\s\\S]*[\\))]);");
    				  Matcher matcher1 = pattern1.matcher(changeOriginalcode);
    				  while(matcher1.find()){				  
    					  System.out.println(matcher1.group(2).toString());
    					  changeOriginalcode= matcher1.group(2).toString();
    					  System.out.println(changeOriginalcode);
    					   MethodnameOriginal=changeOriginalcode;
    				  }
				  }
				  for(String changecode : change){
					  
					  changecode= changecode.trim();
    				  Pattern pattern = Pattern.compile("(.*\\s)([A-Za-z]*\\d|[A-Za-z]*)([\\((][\\s\\S]*[\\))]);");
    				  Matcher matcher = pattern.matcher(changecode);
    				  while(matcher.find()){				  
    					  System.out.println(matcher.group(2).toString());
    					  changecode= matcher.group(2).toString();
    					  System.out.println(changecode);
    				  }
    				  
    				  for (Interface archiclass : archiface.getInterfaces()){
  						String className = archiclass.getName();
  						//System.out.println(className);
  						for (Method m : archiclass.getMethods()){
  							
  							String methodname = m.getName();
  							
  								if(methodname.equals(changecode)){
  									Archclassname=className+".java";
  									MethodnameRevised=methodname;
  									}
  							}
  						}
    				  updatemethod(Archclassname,MethodnameOriginal,MethodnameRevised);	
				  }
			  }
			  
			  
			  }
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}


		
		
		return null;
	}


	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public static void updatemethod(String Archclassname,final String MethodnameOriginal,final String MethodnameRevised){
	    
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setProject(IJproject);
			
		try{
			Iterator<IJavaElement> ijavaElementIt1 = Arrays.asList(IJproject.getChildren()).iterator();
			while(ijavaElementIt1.hasNext()){
				IJavaElement element = ijavaElementIt1.next();
			
		//	for (IJavaElement element : IJproject.getChildren()) {
				
				Iterator<IJavaElement> ijavaElementIt = Arrays.asList(((IPackageFragmentRoot) element).getChildren()).iterator();
				while(ijavaElementIt.hasNext()){
					IJavaElement packg = ijavaElementIt.next();
				
			//	for (IJavaElement packg : ((IPackageFragmentRoot) element).getChildren()) {
					
					IPackageFragment packagefrag = (IPackageFragment) packg;
					
					Iterator<ICompilationUnit> iCompilationUnitIt = Arrays.asList(packagefrag.getCompilationUnits()).iterator();
					while(iCompilationUnitIt.hasNext()){
					final	ICompilationUnit file = iCompilationUnitIt.next();
						
				//	for (final ICompilationUnit file : packagefrag.getCompilationUnits()){
				//Find Java File		
						
						if(file.getElementName().equals(Archclassname)){   
							
							try {
								
//								"/ObserverPattern/src/Subject.java"¤¬ÒŠ¤Ä¤«¤ê¤Þ¤»¤ó
//								SourceFile sourceFile = new SourceFile(file.getPath().toString());
								
								SourceFile sourceFile = new SourceFile("C:/Users/Liyuning/Desktop/iArch/ObserverPattern/src/Subject.java");
								String SourceCode =sourceFile.getSourceCode();
								System.out.println(SourceCode);
								
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
//							ASTVisitor visitor2=new UpdateVisitor();
							
							parser.setSource(file);
							ASTNode rootnode = parser.createAST(null);
							final CompilationUnit cu = (CompilationUnit) rootnode;
							
//							parser.setBindingsRecovery(true);
//							parser.setStatementsRecovery(true);
//							parser.setResolveBindings(true);
//							parser.setEnvironment(Envs.getClassPath(), Envs.getSourcePath(), null, true);						
							
							rootnode.accept(new ASTVisitor(true){
								
								public boolean visit(TypeDeclaration node) {
			
//									String ProjectclassName = node.getName().toString();
//									System.out.println("method:" + node.getName().toString());
//									int classModifiersNum =  node.getModifiers();
						
									return super.visit(node);
								}
								
								public boolean visit(TypeDeclarationStatement node) {

									return super.visit(node);
								}
								
								public boolean visit(MethodInvocation node){

									return super.visit(node);
								}
								
								//Find Method
								public boolean visit(MethodDeclaration node){
									//System.out.println("Method:\t" + node.getName());  
									if( node.getName().toString().equals(MethodnameOriginal)){
										
										AST MethodAST=node.getAST();
										MethodDeclaration id = MethodAST.newMethodDeclaration();
										ASTRewrite rewriter = ASTRewrite.create(MethodAST);
										setMethodName(node, MethodnameRevised);
										rewriter.track(node);
										
										
//										rewriter.set(node.getName(), MethodDeclaration.NAME_PROPERTY, Methodname, null);
//								        ListRewrite lrw = rewriter.getListRewrite(cu, CompilationUnit.IMPORTS_PROPERTY);
//									    lrw.insertLast(id, null);
										

										
										try {
										
									        Document document = new Document(file.getSource());
									    	TextEdit edits=rewriter.rewriteAST();
									        edits.apply(document);
											file.getBuffer().setContents(document.get());
											File newfile = file.getResource().getLocation().toFile();
											write(document.get(), newfile);
											file.getResource().refreshLocal(0, null);
										    file.close();
									    } 
									    catch (CoreException e) {
									        e.printStackTrace();
									    } catch (MalformedTreeException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (BadLocationException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
										
									}
								
									return super.visit(node);
								}
							
						});
						}
						else continue;
						
					}
				}
				    
			
			}
		}
		
		catch(JavaModelException e){
			
		}
		
	}
	private static void setMethodName(MethodDeclaration node, String simpleClassName) {
        AST ast = node.getAST();
        SimpleName simpleName = ast.newSimpleName(simpleClassName);
        node.setName(simpleName);
    }
	
	
public static void insertmethod(String Archclassname,String Methordname){
	    
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setProject(IJproject);
			
		try{
			Iterator<IJavaElement> ijavaElementIt1 = Arrays.asList(IJproject.getChildren()).iterator();
			while(ijavaElementIt1.hasNext()){
				IJavaElement element = ijavaElementIt1.next();
			
		//	for (IJavaElement element : IJproject.getChildren()) {
				
				Iterator<IJavaElement> ijavaElementIt = Arrays.asList(((IPackageFragmentRoot) element).getChildren()).iterator();
				while(ijavaElementIt.hasNext()){
					IJavaElement packg = ijavaElementIt.next();
				
			//	for (IJavaElement packg : ((IPackageFragmentRoot) element).getChildren()) {
					
					IPackageFragment packagefrag = (IPackageFragment) packg;
					
					Iterator<ICompilationUnit> iCompilationUnitIt = Arrays.asList(packagefrag.getCompilationUnits()).iterator();
					while(iCompilationUnitIt.hasNext()){
					final	ICompilationUnit file = iCompilationUnitIt.next();
						
				//	for (final ICompilationUnit file : packagefrag.getCompilationUnits()){
						//Find Java File		
						
						if(file.getElementName().equals(Archclassname)){   
							
							parser.setSource(file);
							ASTNode rootnode = parser.createAST(null);
							final CompilationUnit cu = (CompilationUnit) rootnode;
							
							rootnode.accept(new ASTVisitor(true){
								
								public boolean visit(TypeDeclaration node) {
									
									String ProjectclassName = node.getName().toString();
									int classModifiersNum =  node.getModifiers();
									// create a ASTRewrite		
									//AST ClassAST=node.getAST();
									AST ClassAST=cu.getAST();
					
									ASTRewrite rewriter = ASTRewrite.create(ClassAST);
									
									MethodDeclaration  methodNode = ClassAST.newMethodDeclaration();
								    //methodNode.setConstructor(true);

									methodNode.setName(ClassAST.newSimpleName(Methodname));
									
									Modifier mmd=ClassAST.newModifier(Modifier.ModifierKeyword.PUBLIC_KEYWORD);
									Block block=ClassAST.newBlock();
									methodNode.modifiers().add(mmd);
									methodNode.setReturnType2(null);
									methodNode.setBody(block);
									
									ListRewrite lrw;
									lrw = rewriter.getListRewrite((TypeDeclaration)cu.types().get(0), TypeDeclaration.BODY_DECLARATIONS_PROPERTY);
									lrw.insertLast(methodNode, null);
 
									/*			
									// for getting insertion position
									
									MethodDeclaration methodDecl =node.getMethods()[0];
									Block block =methodDecl.getBody();
									
									// create new statements for insertion
									MethodInvocation newInvocation = ClassAST.newMethodInvocation();
									//insert code
									newInvocation.setName(ClassAST.newSimpleName("add"));
									Statement newStatement = ClassAST.newExpressionStatement(newInvocation);
									
									ListRewrite listRewrite = rewriter.getListRewrite(block, Block.STATEMENTS_PROPERTY);
									listRewrite.insertFirst(newStatement, null);
									*/

									try {
										Document document = new Document(file.getSource());
										TextEdit edits=rewriter.rewriteAST();
										
										edits.apply(document);
										file.getBuffer().setContents(document.get());
										File newfile = file.getResource().getLocation().toFile();
										
										String newFile=readFile(NewPath);
										//File's operation
										write(document.get(), newfile);
										
										writeFile(OldPath,newFile,null);
								        file.getResource().refreshLocal(0, null);
								        file.close();
										
									} catch (JavaModelException
											| IllegalArgumentException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (MalformedTreeException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (BadLocationException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (CoreException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									/*
									SimpleName nameSystem = ClassAST.newSimpleName("Test");  
									MethodInvocation ClassInv=ClassAST.newMethodInvocation();
									
									ClassInv.setName(nameSystem);
							       
							        ExpressionStatement es = ClassAST.newExpressionStatement(ClassInv);
									Block meblock=ClassAST.newBlock();
									meblock.statements().add(es);	
									*/
						
									/*	if(methodname.equals(ProjectclassName)){
									//	node.getMethods();
									}*/
						
									return super.visit(node);
								}
								
								public boolean visit(TypeDeclarationStatement node) {

									return super.visit(node);
								}
								
								public boolean visit(MethodInvocation node){
									
								//	System.out.println("Method :" + node.getName());
									return super.visit(node);
								}
								
								//Find Method
								public boolean visit(MethodDeclaration node){
									/*
									String methodName = node.getName().toString();
									Type returnType = node.getReturnType2();
									int methodModifiersNum = node.getModifiers();
									String	methodReturnType = returnType.toString();
								
									AST MethodAST=node.getAST();
									
									MethodInvocation methodInv = MethodAST.newMethodInvocation();
									StringLiteral sDone = MethodAST.newStringLiteral();  
							        sDone.setEscapedValue("\"Done!\""); 
							        methodInv.arguments().add(sDone);  
 
									ExpressionStatement es = MethodAST.newExpressionStatement(methodInv); 
									Block meblock=MethodAST.newBlock();
									meblock.statements().add(es);
									node.setBody(meblock);
									*/
								
									/*
									//rename method
									
									AST ast=node.getAST();
									SimpleName name=ast.newSimpleName("test");
									node.setName(name);
									SimpleType rtype=ast.newSimpleType(ast.newName("String"));
									node.setReturnType2(rtype);
									*/
									
							        return super.visit(node);
								}
							
						});
						}
						else continue;
						
					}
				}
				    
			
			}
		}
		
		catch(JavaModelException e){
			
		}
		
	}
	
	 public static void write(String content, File file) throws IOException {
		    // create file if it necessary
		    if (!file.exists()) {
		        file.createNewFile();
		    }
		    // write to file
		    PrintWriter out = new PrintWriter((new FileWriter(file)));
		    out.write(content);
		    out.close();
		}
	 
	 private static String readFile(String path)

	 {
	     String str="";
	     File file=new File(path);
	     try {
	         FileInputStream in=new FileInputStream(file);
	         int size=in.available();
	         byte[] buffer=new byte[size];
	         in.read(buffer);
	         in.close();
	         str=new String(buffer,"GB2312");
	     } catch (IOException e) {
	     }
	     return str;
	 }
	 
	 public static void writeFile(String path, String content, String charset)throws IOException {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter writer = null;
			try {
				if (null != charset) {
					writer = new OutputStreamWriter(fos, charset);
				} else {
					writer = new OutputStreamWriter(fos);
				}
				writer.append(content);
			} finally {
				if (null != writer) {
				writer.flush();writer.close();
				}
			}
		}
	 
	 private static String getCode(String code, CompilationUnit unit) {
	        org.eclipse.jface.text.IDocument eDoc = new Document(code);
	        TextEdit edit = unit.rewrite(eDoc, null);
	        try {
	            edit.apply(eDoc);
	            return eDoc.get();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return null;
	        }
	    }
	 
}

