package jp.ac.kyushu.iarch.checkplugin.handler;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.TypeDeclaration;
public class InsertVisitor extends ASTVisitor{
	private String MethordName;
	private String Insertcode;
	
	public InsertVisitor(String MethordName,String Insertcode){
		
		this.MethordName=MethordName;
		this.Insertcode=Insertcode;
	}
	
	public boolean visit(TypeDeclaration node) {
		return super.visit(node);
	}

	@SuppressWarnings("unchecked")
	public boolean visit(MethodDeclaration node) {
		AST ast = node.getAST();
		MethodInvocation methodInvocation = ast.newMethodInvocation();
		if(node.getName().toString().equals(MethordName)){
//		methodInvocation.setExpression(ast.newName("moge.Moge"));

		methodInvocation.setName(ast.newSimpleName(Insertcode));
		node.getBody().statements()
				.add(ast.newExpressionStatement(methodInvocation));
		}
		return super.visit(node);
	}
}
