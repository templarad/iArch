package jp.ac.kyushu.iarch.checkplugin.handler;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
public class InsertMethordVisitor extends ASTVisitor{
	private String MethordName;
	
	public InsertMethordVisitor(String MethordName){
		
		this.MethordName=MethordName;
	
	}
	
	public boolean visit(TypeDeclaration node) {
		
	
		MethodDeclaration methodDeclaration = addMethodDec(node,Modifier.PUBLIC,"void",MethordName);

		return super.visit(node);
	}
	

	private MethodDeclaration addMethodDec(TypeDeclaration node, int modifiers,
			String returnTypeName, String methodName) {
		AST ast = node.getAST();


		MethodDeclaration methodDeclaration = ast.newMethodDeclaration();
	
		methodDeclaration.modifiers().addAll(ast.newModifiers(modifiers));

//		methodDeclaration.setReturnType2(new TypeBuilder(returnTypeName)
//				.build(ast));
		
		methodDeclaration.setName(ast.newSimpleName(methodName));
		Block block=ast.newBlock();
		
		methodDeclaration.setBody(block);
		
		node.bodyDeclarations().add(methodDeclaration);
		
		
		
		return methodDeclaration;
	}

}
