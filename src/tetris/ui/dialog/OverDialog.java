package tetris.ui.dialog;

import tetris.common.Player;
import tetris.ui.TranslucenceJPanel;
import tetris.ui.component.HeadPortrait;

public class OverDialog extends TranslucenceJPanel{
	public HeadPortrait mHead, rivalHead;
	public OverDialog(double[][] shape) {
		// TODO Auto-generated constructor stub
		super(shape);
		setBackGroud("resources\\image\\np_over.png");
		transparency = 0.9f;
		setLayout(null);
		
		mHead = new HeadPortrait(new double[][]{{0.175,0.22},{0.245,0.36}}, this);
		add(mHead);
		
		rivalHead = new HeadPortrait(new double[][]{{0.175,0.22},{0.595,0.36}}, this);
		add(rivalHead);
		
		
		
		setVisible(false);
	}
}

