package jp.ac.kyushu.iarch.checkplugin.view;

import org.eclipse.jdt.ui.ISharedImages;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.part.ViewPart;

public class UncertainMethodViewPart extends ViewPart {

	public UncertainMethodViewPart() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		parent.setLayout(new FillLayout());
		Tree tree = new Tree(parent, SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.BORDER_SOLID | SWT.CHECK | SWT.FULL_SELECTION);
		tree.setHeaderVisible(true);
		TreeColumn classColumn = new TreeColumn(tree, SWT.LEFT);
		classColumn.setText("Name");
		classColumn.setWidth(200);
		TreeColumn methodColumn = new TreeColumn(tree, SWT.LEFT);
		methodColumn.setText("Uncertain Type");
		methodColumn.setWidth(200);
		TreeColumn column3 = new TreeColumn(tree, SWT.LEFT);
		column3.setWidth(200);
		for (int i = 0; i < 4; i++) {
			TreeItem item = new TreeItem(tree, SWT.NONE);
			item.setText(new String[] { "ClassName " + i, "-", "-" });
			item.setImage(JavaUI.getSharedImages().getImage(
					ISharedImages.IMG_OBJS_CLASS));
			for (int j = 0; j < 4; j++) {
				TreeItem subItem = new TreeItem(item, SWT.BORDER);
				subItem.setText(new String[] { "MethodName " + j,
						"Alternative", "-" });
				subItem.setImage(JavaUI.getSharedImages().getImage(
						ISharedImages.IMG_FIELD_PRIVATE));
			}
		}
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
