package tetris.ui.component;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import tetris.ui.MWidget;
import tetris.ui.MainContainer;
import tetris.ui.TranslucenceJPanel;
import tetris.ui.component.RivalDialog.MKeyAdapter;
import tetris.utils.ImageProcesser;
import tetris.utils.LoadFont;

public class InvitedDialog extends TranslucenceJPanel{
	private ArrowJpanel arrowJpanel;
	private HeadPortrait headPortrait;
	public JLabel nameJLabel;
	public InvitedDialog(double[][] shape) {
		super(shape);
		setBackGroud("resources\\image\\invited.png");
		transparency = 0.9f;
		setLayout(null);
		
		arrowJpanel = new ArrowJpanel(new double[][]{{0.08,0.12},{0.14,0.61},{0.52,0.61}}, 2, this);
		add(arrowJpanel);
		
		headPortrait = new HeadPortrait(new double[][]{{0.10,0.20},{0.28,0.29}}, this);
		add(headPortrait);
		
		nameJLabel = new JLabel();
		nameJLabel.setHorizontalAlignment(JLabel.CENTER);
		nameJLabel.setFont(LoadFont.loadFont(60));
		nameJLabel.setBounds((int)(this.getWidth() * 0.33), (int)(this.getHeight() * 0.13), 
				(int)(this.getWidth() * 0.5), (int)(this.getHeight() * 0.5));
		add(nameJLabel);
		
		this.addKeyListener(new MKeyAdapter());
		
		this.setVisible(false);

	}
	
	class MKeyAdapter extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				arrowJpanel.lastState();
				break;
				
			case KeyEvent.VK_RIGHT:
				arrowJpanel.nextState();
				break;

			default:
				break;
			}
		}
	}
}
