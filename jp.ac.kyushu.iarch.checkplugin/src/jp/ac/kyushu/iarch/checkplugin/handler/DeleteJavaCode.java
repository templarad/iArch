package jp.ac.kyushu.iarch.checkplugin.handler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

public class DeleteJavaCode  {
	
	
	
	public static void delete(String Path,String MethordName){
		
		SourceFile sourceFile;
		try {
			
			ASTVisitor visitor = new DeleteVisitor(MethordName);
//			String InsertCode=ASTSourceCodeChecker.InsertJavaCode;
//			String InsertPath=ASTSourceCodeChecker.InsertPath;
//			String InsertMethod=ASTSourceCodeChecker.InsertMethod;
			
			sourceFile = new SourceFile(Path);
			CompilationUnit unit;
	        
	        ASTParser astParser = ASTParser.newParser(AST.JLS4);

	        astParser.setBindingsRecovery(true);
	        astParser.setStatementsRecovery(true);

	        astParser.setResolveBindings(true);

	        astParser.setEnvironment(Envs.getClassPath(), Envs.getSourcePath(),
	                null, true);

	        astParser.setUnitName(sourceFile.getFilePath());
	        astParser.setSource(sourceFile.getSourceCode().toCharArray());
	        unit = (CompilationUnit) astParser.createAST(new NullProgressMonitor());
	        unit.recordModifications();

	        unit.accept(visitor);
	  
	        String code = getCode(sourceFile.getSourceCode(), unit);

	        
	        
	        BufferedWriter out = new BufferedWriter(new FileWriter(Path));
	        out.write(code);
	        out.close();
//	        PrintWriter out = new PrintWriter("change.java");
//	        out.write(code);
//	        out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void insert2(String MethordName){
		SourceFile sourceFile;
		try {
			
			ASTVisitor visitor2 = new InsertMethordVisitor(MethordName);
			sourceFile = new SourceFile("C:/Users/Liyuning/Desktop/iArch/ObserverPattern/src/Subject.java");
			CompilationUnit unit;
	        
	        ASTParser astParser = ASTParser.newParser(AST.JLS4);

	        astParser.setBindingsRecovery(true);
	        astParser.setStatementsRecovery(true);

	        astParser.setResolveBindings(true);

	        astParser.setEnvironment(Envs.getClassPath(), Envs.getSourcePath(),
	                null, true);

	        astParser.setUnitName(sourceFile.getFilePath());
	        astParser.setSource(sourceFile.getSourceCode().toCharArray());
	        unit = (CompilationUnit) astParser.createAST(new NullProgressMonitor());
	        unit.recordModifications();

	        unit.accept(visitor2);
	  
	        String code = getCode(sourceFile.getSourceCode(), unit);
	        System.out.println(code);
	        
	        
	        BufferedWriter out = new BufferedWriter(new FileWriter("C:/Users/Liyuning/Desktop/iArch/ObserverPattern/src/Subject.java"));
	        out.write(code);
	        out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
