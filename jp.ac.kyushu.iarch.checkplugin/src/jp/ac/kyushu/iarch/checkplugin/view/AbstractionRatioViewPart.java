package jp.ac.kyushu.iarch.checkplugin.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.ui.part.ViewPart;

public class AbstractionRatioViewPart extends ViewPart {
	public static final String ID = "jp.ac.kyushu.iarch.checkplugin.abstractionratioview";
	private RatioPanel allRatio;
	private RatioPanel structureRatio;
	private RatioPanel behaviorRatio;
	public AbstractionRatioViewPart() {
		
	}
	
	class RatioPanel extends Composite{
		private Label ratio;
		private ProgressBar bar;
		private Label impl;
		private Label arch;
		public RatioPanel(Composite parent, int style, String title) {
			super(parent, style);
			Font titleFont = new Font(this.getDisplay(), new FontData("Comic Sans MS", 14, SWT.ITALIC));
			Font paramFont = new Font(this.getDisplay(), new FontData("Comic Sans MS", 10, SWT.ITALIC));
			Layout layout = new  GridLayout(6,false);
			this.setLayout(layout);
			
			GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_CENTER, GridData.VERTICAL_ALIGN_CENTER, true, true, 6, 1);
			Label titleLabel = new Label(this, SWT.None);
			titleLabel.setText(title);
			titleLabel.setFont(titleFont);
			titleLabel.setLayoutData(gridData);
			
			bar = new ProgressBar(this, SWT.SMOOTH);
			bar.setMaximum(100);
			bar.setMinimum(0);
			bar.setSize(10, 5);
			gridData = new GridData(GridData.FILL_HORIZONTAL);
			gridData.horizontalSpan = 6;
			gridData.verticalSpan = 1;
			bar.setLayoutData(gridData);
			
			ratio = new Label(this, SWT.None);
			ratio.setText("  -  ");
			ratio.setFont(titleFont);
			gridData = new GridData(GridData.HORIZONTAL_ALIGN_CENTER, GridData.VERTICAL_ALIGN_CENTER, true, true, 3, 2);
			gridData.minimumWidth = 50;
			ratio.setLayoutData(gridData);
			
			arch = new Label(this, SWT.NONE);
			arch.setText("  -  ");
			arch.setFont(titleFont);
			arch.setAlignment(SWT.LEFT);
			gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL, GridData.VERTICAL_ALIGN_CENTER, true, true, 1, 1);
			arch.setLayoutData(gridData);

			Label perLabel = new Label(this, SWT.NONE);
			perLabel.setText(" / ");
			perLabel.setFont(paramFont);
			gridData = new GridData(GridData.HORIZONTAL_ALIGN_CENTER, GridData.VERTICAL_ALIGN_CENTER, true, true, 1, 2);
			perLabel.setLayoutData(gridData);

			impl = new Label(this, SWT.NONE);
			impl.setText("  -  ");
			impl.setFont(titleFont);
			impl.setAlignment(SWT.RIGHT);
			gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL, GridData.VERTICAL_ALIGN_CENTER, true, true, 1, 1);
			impl.setLayoutData(gridData);
			
			Label archLabel = new Label(this, SWT.NONE);
			archLabel.setText("arch");
			archLabel.setFont(paramFont);
			gridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING, GridData.VERTICAL_ALIGN_CENTER, true, true, 1, 1);
			archLabel.setLayoutData(gridData);

			Label implLabel = new Label(this, SWT.NONE);
			implLabel.setText("impl");
			implLabel.setFont(paramFont);
			gridData = new GridData(GridData.HORIZONTAL_ALIGN_END, GridData.VERTICAL_ALIGN_CENTER, true, true, 1, 1);
			implLabel.setLayoutData(gridData);
		}
		public void setRatio(double ratioParam){
			String ratioStr = Double.toString(ratioParam);
			if(ratioStr.length()>5){
				ratioStr = ratioStr.substring(0,4);
			}
			ratio.setText(ratioStr);
			bar.setSelection((int)(ratioParam*100));
		}
		public void setImpl(int implParam){
			impl.setText(Integer.toString(implParam));
		}
		public void setArch(int archParam){
			arch.setText(Integer.toString(archParam));
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		Layout layout = new GridLayout(1,false);
		parent.setLayout(layout);
		GridData griddata = new GridData(GridData.FILL_HORIZONTAL);
		allRatio = new RatioPanel(parent,SWT.None, "Abstraction Ratio");
		allRatio.setLayoutData(griddata);
		structureRatio = new RatioPanel(parent, SWT.None, "Structure Abstraction Ratio");
		structureRatio.setLayoutData(griddata);
		behaviorRatio = new RatioPanel(parent, SWT.None, "Behavior Abstraction Ratio");
		behaviorRatio.setLayoutData(griddata);
	}

	@Override
	public void setFocus() {
	}
	
	
	// TODO 下記，現状AbstractionRatioCheckerクラスよりアクセスするようにしているが，
	// 出来ればObserverパターンにて処理したいところ．
	
	public void setRatio(double ratio){
		allRatio.setRatio(ratio);
	}
	
	public void setArchAndImpl(int arch, int impl){
		allRatio.setArch(arch);
		allRatio.setImpl(impl);
	}
	
	public void setStructureRatio(double ratio){
		structureRatio.setRatio(ratio);
	}
	
	public void setStructureArchAndImpl(int arch, int impl){
		structureRatio.setArch(arch);
		structureRatio.setImpl(impl);
	}
	
	public void setBehaviorRatio(double ratio){
		behaviorRatio.setRatio(ratio);
	}
	
	public void setBehaviorArchAndImpl(int arch, int impl){
		behaviorRatio.setArch(arch);
		behaviorRatio.setImpl(impl);
	}
}
