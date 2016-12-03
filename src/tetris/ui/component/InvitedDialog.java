package tetris.ui.component;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import tetris.ui.MainContainer;
import tetris.ui.component.RivalDialog.MKeyAdapter;
import tetris.ui.single.MWidget;
import tetris.ui.single.TranslucenceJPanel;
import tetris.utils.ImageProcesser;

public class InvitedDialog extends TranslucenceJPanel{
	private ArrowJpanel arrowJpanel;
	public InvitedDialog(double[][] shape, ArrowJpanel arrowJpanel) {
		super(shape);
		this.arrowJpanel = arrowJpanel;
		
		MainContainer mainContainer = MainContainer.getInstance();
		
		bgImage = ImageProcesser.imageScale(new ImageIcon("resources\\image\\rivaldialog_bg.png"),
				(int)(mainContainer.getInterWidth() * shape[1][0]),
				(int)(mainContainer.getInterHeight() * shape[1][1]));
		
		transparency = 0.9f;
		
		this.addKeyListener(new MKeyAdapter());
		
		this.setVisible(false);
	}
	
	class MKeyAdapter extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				arrowJpanel.lastState();
				break;
				
			case KeyEvent.VK_DOWN:
				arrowJpanel.nextState();
				break;

			default:
				break;
			}
		}
	}
}
