package tetris.ui.component;

import javax.swing.ImageIcon;

import tetris.ui.MainContainer;
import tetris.ui.TranslucenceJPanel;
import tetris.utils.ImageProcesser;

public class WaitDialog extends TranslucenceJPanel{
	public WaitDialog(double[][] shape) {
		super(shape);
		MainContainer mainContainer = MainContainer.getInstance();
		
		bgImage = ImageProcesser.imageScale(new ImageIcon("resources\\image\\wait.png"),
				(int)(mainContainer.getInterWidth() * shape[1][0]),
				(int)(mainContainer.getInterHeight() * shape[1][1]));
		
		transparency = 0.9f;
		setVisible(false);
	}
}
