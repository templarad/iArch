package jp.ac.kyushu.iarch.checkplugin.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.part.ViewPart;

public class UncertainViewPart extends ViewPart {

	public UncertainViewPart() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO 自動生成されたメソッド・スタブ
		parent.setLayout(new FillLayout());

		Table table = new Table(parent, SWT.MULTI);

		// visible header
		table.setHeaderVisible(true);

		// header settings
		String[] cols = {"Type","Methods","Resources","Line No."};

	}

	@Override
	public void setFocus() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
