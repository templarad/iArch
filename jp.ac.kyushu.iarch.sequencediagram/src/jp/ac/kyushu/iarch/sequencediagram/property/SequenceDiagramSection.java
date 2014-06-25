package jp.ac.kyushu.iarch.sequencediagram.property;

import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.impl.AbstractFeature;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import behavior.NamedElement;;
public class SequenceDiagramSection extends GFPropertySection implements
    ITabbedPropertyConstants {
 
    public Text nameText;
    
    public Button ArchPTCheck;
    
    //Enable to edit Name
    private ModifyListener listenerClassName = new ModifyListener() {

    	@Override
    	public void modifyText(ModifyEvent e) {
    		String value = nameText.getText();
    		if (value == null) {
    			value = "";//$NON-NLS-1$
    		}
    		PictogramElement pe = getSelectedPictogramElement();
    		if (pe != null) {
    			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
    			// the filter assured, that it is a Class
    			if (bo == null)
    				return;
    			String name = ((NamedElement) bo).getName();
    			if (value.equals(name)||(name==null&&value==""))
    				return;
    		}
    		final String typedValue = value;
    		IFeature feature = new AbstractFeature(getDiagramTypeProvider().getFeatureProvider()) {
    				
    			@Override
    			public void execute(IContext context) {
    				PictogramElement pe = getSelectedPictogramElement();
    				if (pe != null) {
    					Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
    					// the filter assured, that it is a Class
    					if (bo == null)
    						return;
    					NamedElement namedE = (NamedElement) bo;
    					namedE.setName(typedValue);
    				}
    			}
    			
    			@Override
    			public boolean canExecute(IContext context) {
    				return true;
    			}
    		};
    		CustomContext context = new CustomContext();
    		execute(feature, context);
    	}
    };
    
  //Enable to select ArchPoint
    SelectionAdapter listenerArchPT = new SelectionAdapter(){
    	public void widgetSelected(SelectionEvent e){
    		boolean isArchPT = ArchPTCheck.getSelection();
    		PictogramElement pe = getSelectedPictogramElement();
    		if (pe != null) {
    			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
        		if (bo==null)
        			return;	
    		}
    		final boolean isArchPoint = isArchPT;
    		IFeature feature = new AbstractFeature(getDiagramTypeProvider().getFeatureProvider()) {
				
    			@Override
    			public void execute(IContext context) {
    				PictogramElement pe = getSelectedPictogramElement();
    				if (pe != null) {
    					Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
    					// the filter assured, that it is a Class
    					if (bo == null)
    						return;
    					NamedElement nm = (NamedElement)bo;
    					nm.setArchpoint(isArchPoint);
    					
    					//We cannot refresh a FreeFormConnection to update its warn Decorators,
    					//Instead, we can refresh its name box, to update its Decorators
    					if (pe instanceof FreeFormConnection){
    						FreeFormConnection cs = (FreeFormConnection) pe;
    						//Refresh all of its name boxes.
        	            	for (Shape shape : cs.getConnectionDecorators()) {    	                    
        	                    this.getDiagramBehavior().refreshRenderingDecorators(shape);        	                    
        	                }
    					}
    					
    					this.getDiagramBehavior().refreshRenderingDecorators(pe);
    				}
    			}
    			
    			@Override
    			public boolean canExecute(IContext context) {
    				return true;
    			}
    		};
    		CustomContext context = new CustomContext();
    		execute(feature, context);
    	}
    	
    };
    
    @Override
    public void createControls(Composite parent,
        TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);
 
        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
        Composite composite = factory.createFlatFormComposite(parent);
        FormData data;
 
        nameText = factory.createText(composite, "");
        nameText.addModifyListener(listenerClassName);
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE);
        nameText.setLayoutData(data);
 
        CLabel valueLabel = factory.createCLabel(composite,  "Name:");

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(nameText, -HSPACE);
        data.top = new FormAttachment(nameText, 0, SWT.CENTER);
        valueLabel.setLayoutData(data);
        
        //Archpoint 
        FormData data2;
        
        ArchPTCheck = factory.createButton(composite, "isArchpoint", SWT.CHECK);
        ArchPTCheck.addSelectionListener(listenerArchPT);
        data2 = new FormData();
        data2.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data2.right = new FormAttachment(100, 0);
        data2.top = new FormAttachment(nameText, VSPACE);
        ArchPTCheck.setLayoutData(data2);
 
    
        CLabel ArchPTLabel = factory.createCLabel(composite,  "ArchPoint:");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(ArchPTCheck, -HSPACE);
        data.top = new FormAttachment(nameText, 0, SWT.CENTER);
        ArchPTLabel.setLayoutData(data2);
    }
 
    @Override
    public void refresh() {
        PictogramElement pe = getSelectedPictogramElement();
        if (pe != null) {
            Object bo = Graphiti.getLinkService()
                 .getBusinessObjectForLinkedPictogramElement(pe);
            // the filter assured, that it is a EClass
            if (bo == null)
                return;
            String name = ((NamedElement) bo).getName();
            boolean isarchpint= ((NamedElement) bo).isArchpoint();
            nameText.setText(name == null ? "" : name);
            ArchPTCheck.setSelection(isarchpint);
        }
    }
    
}