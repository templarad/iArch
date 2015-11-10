package jp.ac.kyushu.iarch.checkplugin.view;

import java.util.ArrayList;
import java.util.List;

import jp.ac.kyushu.iarch.basefunction.controller.GraphitiModelManager;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.mm.pictograms.Diagram;
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

public class SelectDiagramsDialog extends Dialog {
	private Table archiTable;
	private Table classTable;
	private Table dataflowTable;
	private Table sequenceTable;
	private IProject project;
	private Button okButton;
	private IResource archiface;
	private IResource classDiagram;
	private IResource dataflowDiagram;
	private List<IResource> sequenceDiagrams;
	
	/**
	 * Constructor
	 * @param parentShell
	 * @param project
	 */
	public SelectDiagramsDialog(Shell parentShell, IProject project) {
		super(parentShell);
		this.project = project;
		sequenceDiagrams = new  ArrayList<>();
	}
	
	@Override
	protected Point getInitialSize() {
		return new Point(480, 700);
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
		classLabel.setText("Class Diagrams");
		classTable = new Table(composite, SWT.CHECK|SWT.BORDER|SWT.V_SCROLL);
		classTable.setLayoutData(new GridData(350, 60));
		classTable.addSelectionListener(checkboxListener);
		
		Label dataflowLabel = new Label(composite, SWT.NONE);
		dataflowLabel.setText("Dataflow Diagrams");
		dataflowTable = new Table(composite, SWT.CHECK|SWT.BORDER|SWT.V_SCROLL);
		dataflowTable.setLayoutData(new GridData(350, 60));
		dataflowTable.addSelectionListener(checkboxListener);

		Label sequenceLabel = new Label(composite, SWT.NONE);
		sequenceLabel.setText("Sequence Diagrams");
		sequenceTable = new Table(composite, SWT.CHECK|SWT.BORDER|SWT.V_SCROLL);
		sequenceTable.setLayoutData(new GridData(350, 100));
		sequenceTable.addSelectionListener(checkboxListener);
		
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
		for(TableItem item : classTable.getItems()){
			if(item.getChecked()){
				classDiagram = (IResource)item.getData();
			}
		}
		for(TableItem item : dataflowTable.getItems()){
			if(item.getChecked()){
				dataflowDiagram = (IResource)item.getData();
			}
		}
		for(TableItem item : sequenceTable.getItems()){
			if(item.getChecked()){
				sequenceDiagrams.add((IResource)item.getData());
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
			int cntClassDiagrams = 0;
			int cntDataflowDiagrams = 0;
			int cntSequenceDiagrams = 0;
			for(TableItem item : archiTable.getItems()){
				if(item.getChecked()) cntArchiFiles++;
			}
			for(TableItem item : classTable.getItems()){
				if(item.getChecked()) cntClassDiagrams++;
			}
			for(TableItem item : dataflowTable.getItems()){
				if(item.getChecked()) cntDataflowDiagrams++;
			}
			for(TableItem item : sequenceTable.getItems()){
				if(item.getChecked()) cntSequenceDiagrams++;
			}
			if(cntArchiFiles==1&&cntClassDiagrams==1&&cntDataflowDiagrams>=0&&cntSequenceDiagrams>0){
				okButton.setEnabled(true);
			}else{
				okButton.setEnabled(false);
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
					case "diagram":
						Resource model = GraphitiModelManager.getGraphitiModel(resource);
						Diagram o = (Diagram)model.getContents().get(0);
						if("ClassDiagram".equals(o.getDiagramTypeId())){
							TableItem citem = new TableItem(classTable, SWT.CHECK);
							citem.setText(resource.getName());
							citem.setData(resource);
							citem.setChecked(true);							
						}else if("DataflowDiagram".equals(o.getDiagramTypeId())){
							TableItem citem = new TableItem(dataflowTable, SWT.CHECK);
							citem.setText(resource.getName());
							citem.setData(resource);							
							citem.setChecked(true);
						}else if("SequenceDiagram".equals(o.getDiagramTypeId())){
							TableItem sitem = new TableItem(sequenceTable, SWT.CHECK);
							sitem.setText(resource.getName());
							sitem.setData(resource);							
							sitem.setChecked(true);
						}else{
							System.err.println("undefine diagram types");
						}
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
	
	public IResource getClassDiagram(){
		return classDiagram;
	}
	
	public IResource getDataflowDiagram(){
		return dataflowDiagram;
	}
	
	public List<IResource> getSequenceDiagrams(){
		return sequenceDiagrams;
	}	
}
