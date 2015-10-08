package jp.ac.kyushu.iarch.checkplugin.handler;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.TypeDeclaration;
public class DeleteVisitor extends ASTVisitor{
	private String MethordName;

	
	public DeleteVisitor(String MethordName){
		
		this.MethordName=MethordName;

	}
	
	public boolean visit(TypeDeclaration node) {
		return super.visit(node);
	}
    public boolean visit(MethodDeclaration node) {


    	if(node.getName().toString().equals(MethordName)){
    	  
    		node.delete();
    		
    	}
    	return super.visit(node);
    }
}
