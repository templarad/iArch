package jp.ac.kyushu.iarch.checkplugin.view;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class SelectArchfile extends Dialog {
	private Table archiTable;
	private Button okButton;
	private IProject project;
	private Table sourceTable;
	private IResource archiface;
	
	/**
	 * Constructor
	 * @param parentShell
	 * @param project
	 */
	public SelectArchfile(Shell parentShell, IProject project) {
		super(parentShell);
		this.project = project;
	}
	
	@Override
	protected Point getInitialSize() {
		return new Point(400, 500);
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Select Diagrams");
	}
	
	/**
	 * Create dialog widgets
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		CheckCheckedStateListener checkboxListener = new CheckCheckedStateListener();
		Composite composite = (Composite)super.createDialogArea(parent);
		Label archiLabel = new Label(composite, SWT.NONE);
		archiLabel.setText("Archiface files");
		archiTable = new Table(composite, SWT.CHECK|SWT.BORDER | SWT.V_SCROLL);
		archiTable.setLayoutData(new GridData(350, 60));
		archiTable.addSelectionListener(checkboxListener);
		
		Label classLabel = new Label(composite, SWT.NONE);
		classLabel.setText("Source files");
		sourceTable = new Table(composite, SWT.CHECK|SWT.BORDER|SWT.V_SCROLL);
		sourceTable.setLayoutData(new GridData(350, 60));
		sourceTable.addSelectionListener(checkboxListener);
		
		setInitialItems();
		
		return composite;
	}
	
	/**
	 * Create OK and Cancel button
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		okButton = createButton(parent, IDialogConstants.OK_ID, "OK", true);
		okButton.setEnabled(true);
		createButton(parent, IDialogConstants.CANCEL_ID,"Cancel", true);
	}
	
	
	/**
	 * move selected files from widget
	 */
	@Override
	protected void okPressed() {
		for(TableItem item : archiTable.getItems()){
			if(item.getChecked()){
				archiface = (IResource)item.getData();
			}
		}
		
		setReturnCode(OK);
		super.okPressed();
	}
	
	/**
	 * @author hosoai
	 * Selection validation
	 */
	class CheckCheckedStateListener implements SelectionListener{
		@Override
		public void widgetSelected(SelectionEvent e) {
			int cntArchiFiles = 0;
			int cntDataflowDiagrams = 0;
			int cntClassDiagrams = 0;
			int cntSequenceDiagrams = 0;
			for(TableItem item : archiTable.getItems()){
				if(item.getChecked()) cntArchiFiles++;
			}
		}
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {	}		
	}
	
	/**
	 * Set archiface file and diagram files to table.
	 */
	private void setInitialItems() {
		try {
			project.accept(new IResourceVisitor() {
				@Override
				public boolean visit(IResource resource) throws CoreException {
					String ext = resource.getFileExtension();
					if(ext==null) return true;
					switch(ext){
					case "arch":
						TableItem aitem = new TableItem(archiTable, SWT.CHECK);
						aitem.setText(resource.getName());
						aitem.setData(resource);
						aitem.setChecked(true);
						break;
						
					case"java":
						TableItem citem = new TableItem(sourceTable, SWT.CHECK);
						citem.setText(resource.getName());
						citem.setData(resource);
						citem.setChecked(true);

						break;
					
					default:
						break;
					}
					return true;
				}
			});
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	/*Accessors*/
	public IResource getArchiface(){
		return archiface;
	}
	
}
