package jp.ac.kyushu.iarch.checkplugin.view;

import java.util.List;

import jp.ac.kyushu.iarch.checkplugin.model.ComponentClassPairModel;
import jp.ac.kyushu.iarch.checkplugin.model.ComponentMethodPairModel;

import org.eclipse.jdt.ui.ISharedImages;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.part.ViewPart;

public class SourceCodeCheckViewPart extends ViewPart {
	public static final String ID = "jp.ac.kyushu.iarch.checkplugin.archfaceview";
	private TreeViewer treeViewer;

	public class ArchfaceTreeContentProvider implements ITreeContentProvider {

		@Override
		public void dispose() {
			// TODO Auto-generated method stub

		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub

		}

		@Override
		public Object[] getElements(Object inputElement) {
			// TODO Auto-generated method stub
			if (inputElement instanceof List) {
				return ((List) inputElement).toArray();
			}
			return null;
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			// TODO Auto-generated method stub
			if (parentElement instanceof ComponentClassPairModel) {
				return ((ComponentClassPairModel) parentElement).methodPairsList
						.toArray();
			}else if(parentElement instanceof ComponentMethodPairModel){
				if(((ComponentMethodPairModel) parentElement).isAltSet()){
					return ((ComponentMethodPairModel) parentElement).getAltMethodPairSets().toArray();
				}else{
					return null;
				}
			}
			return null;
		}

		@Override
		public Object getParent(Object element) {
			// TODO Auto-generated method stub
			if (element instanceof ComponentMethodPairModel) {
				return ((ComponentMethodPairModel) element).getParentModel();
			}else if(element instanceof ComponentMethodPairModel){
				if(((ComponentMethodPairModel) element).isAltSet()){
					return ((ComponentMethodPairModel) element).getAltParentMethodModel();
				}
			}
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			// TODO Auto-generated method stub
			if (element instanceof ComponentClassPairModel) {
				return true;
			}else if(element instanceof ComponentMethodPairModel){
				if (((ComponentMethodPairModel) element).isAltSet()) {
					return true;
				}else{
					return false;
				}
			} else {
				return false;
			}
		}

	}

	class TableLabelProvider implements ITableLabelProvider {

		@Override
		public void addListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			switch (columnIndex) {
			case 0:
				if (element instanceof ComponentClassPairModel) {
					return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_CLASS);
				} else if (element instanceof ComponentMethodPairModel) {
					return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_PUBLIC);
				} else {
					element.toString();
				}
			}
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			switch (columnIndex) {
			case 0:
				if (element instanceof ComponentClassPairModel) {
					return ((ComponentClassPairModel) element).getName();
				} else if (element instanceof ComponentMethodPairModel) {
					return ((ComponentMethodPairModel) element).getName();
				} else {
					element.toString();
				}
			case 1:
				if (element instanceof ComponentClassPairModel) {
					return "-";
				} else if (element instanceof ComponentMethodPairModel) {
					if (((ComponentMethodPairModel) element).isOpt()) {
						return "Optional";
					} else if (((ComponentMethodPairModel) element).isAlt()) {
						return "Alternative";
					}else if(((ComponentMethodPairModel) element).isAltSet()){
						return "Alternatives";
					} else {
						return "Certain";
					}
				}
			case 2:
				if (element instanceof ComponentClassPairModel) {
					if (((ComponentClassPairModel) element).isExistJavaNode()) {
						return "✔";
					} else {
						return "×";
					}
				} else if (element instanceof ComponentMethodPairModel) {
					if(((ComponentMethodPairModel) element).isAltSet()){
						return "-";
					}
					if(((ComponentMethodPairModel) element).isExistJavaNode()){
						return "✔";
					}else{
						return "×";
					}
				}
			}
			return null;
		}

	}

	public void setClassPairs(List<ComponentClassPairModel> classPairs) {
		treeViewer.setInput(classPairs);
		treeViewer.expandAll();
	}

	public SourceCodeCheckViewPart() {
		// TODO Auto-generated constructor stub
	}

	class ComponentPanel extends Composite {

		public ComponentPanel(Composite parent, int style) {
			super(parent, style);
			// TODO Auto-generated constructor stub
		}

	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		GridLayout parentGridLayout = new GridLayout(2, true);
		parent.setLayout(parentGridLayout);
		parent.setLayoutData(new GridData(GridData.FILL_BOTH));
		Tree tree = new Tree(parent, SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.BORDER_SOLID | SWT.CHECK | SWT.FULL_SELECTION);
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		tree.setLayoutData(new GridData(GridData.FILL_BOTH));
		treeViewer = new TreeViewer(tree);
		TreeColumn nameColumn = new TreeColumn(tree, SWT.LEFT);
		nameColumn.setText("Component Name");
		nameColumn.setWidth(150);
		TreeColumn uncertainColumn = new TreeColumn(tree, SWT.LEFT);
		uncertainColumn.setText("Uncertain Type");
		uncertainColumn.setWidth(100);
		TreeColumn isExistColumn = new TreeColumn(tree, SWT.LEFT);
		isExistColumn.setText("Impl");
		isExistColumn.setWidth(50);

		treeViewer.setContentProvider(new ArchfaceTreeContentProvider());
		treeViewer.setLabelProvider(new TableLabelProvider());
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
