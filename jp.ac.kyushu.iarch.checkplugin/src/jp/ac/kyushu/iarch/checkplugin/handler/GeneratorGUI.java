package jp.ac.kyushu.iarch.checkplugin.handler;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;

public class GeneratorGUI extends JFrame implements IHandler{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;



	public static void GUImain() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneratorGUI frame = new GeneratorGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	  public void add(Component c,GridBagConstraints constraints,int x,int y,int w,int h)
	    {
	        constraints.gridx=x;
	        constraints.gridy=y;
	        constraints.gridwidth=w;
	        constraints.gridheight=h;
	        add(c,constraints);
	} 
	/**
	 * Create the frame.
	 */
	public GeneratorGUI() {
		
		setTitle("Test");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

//		ASTSourceCodeChecker Checker=new ASTSourceCodeChecker();
//		String InsertCode=Checker.getInsertCode();
//		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Insert", null, panel, null);
		panel.setLayout(new BorderLayout());
		
		String InsertCode=ASTSourceCodeChecker.InsertJavaCode;
		String InsertPath=ASTSourceCodeChecker.InsertPath;
		String InsertMethod=ASTSourceCodeChecker.InsertMethod;
		
		String[] name={InsertCode,InsertPath,InsertMethod};
		
		final JList list = new JList(name);
		panel.add(list,"North");
		
		final JTextField textField_1 = new JTextField();
		panel.add(textField_1, BorderLayout.SOUTH);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton, BorderLayout.EAST);
	
	
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event){
				
				textField_1.setText((String)list.getSelectedValue());
			} 
			
			
		});
	}

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		GUImain();
		return null;
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

}
