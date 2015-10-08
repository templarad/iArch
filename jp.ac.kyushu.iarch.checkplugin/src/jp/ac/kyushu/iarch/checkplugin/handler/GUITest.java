package jp.ac.kyushu.iarch.checkplugin.handler;

import java.awt.EventQueue;
import javax.swing.JList;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import javax.swing.JFrame;

public class GUITest {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GUITest window = new GUITest();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(463, 426);
		shell.setText("SWT Application");
		
		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.setBounds(26, 0, 409, 359);
		
		TabItem tbtmNewItem = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem.setText("Insert");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmNewItem.setControl(composite);
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton_1.setBounds(171, 272, 95, 28);
		btnNewButton_1.setText("Check");
		
		String[] name={"Subject","_notify();"};
		
		Label lblInsertMessage = new Label(composite, SWT.NONE);
		lblInsertMessage.setBounds(10, 10, 110, 29);
		lblInsertMessage.setText("Insert Message");
		
		Label lblInformation = new Label(composite, SWT.NONE);
		lblInformation.setBounds(156, 10, 94, 29);
		lblInformation.setText("Java File");
		
		List list = new List(composite, SWT.BORDER);
		list.setBounds(31, 45, 89, 78);
		
		Button btnInsert = new Button(composite, SWT.NONE);
		btnInsert.setBounds(296, 272, 95, 28);
		btnInsert.setText("Insert");
		
		List list_1 = new List(composite, SWT.BORDER);
		list_1.setBounds(156, 45, 75, 183);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(280, 10, 90, 29);
		lblNewLabel.setText("JavaCode");
		
		List list_2 = new List(composite, SWT.BORDER);
		list_2.setBounds(266, 45, 125, 183);
		
		List list_3 = new List(composite, SWT.BORDER);
		list_3.setBounds(31, 151, 89, 78);
		
		TabItem tbtmNewItem_1 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem_1.setText("Update");
		
		Label lblUpdate = new Label(tabFolder, SWT.NONE);
		tbtmNewItem_1.setControl(lblUpdate);
		lblUpdate.setText("Update");
		
		TabItem tbtmNewItem_2 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem_2.setText("Delete");
		
		Label lblLete = new Label(tabFolder, SWT.NONE);
		tbtmNewItem_2.setControl(lblLete);
		lblLete.setText("Delete");

		
	
	}
}
