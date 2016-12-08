package tetris.ui.dialog;


import java.awt.Shape;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.common.GlobalConstants;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.MainContainer;
import tetris.ui.TranslucenceJPanel;
import tetris.ui.component.ArrowJpanel;
import tetris.utils.ImageProcesser;
import tetris.utils.LoadFont;

public class GameOverDialog extends TranslucenceJPanel{//extends JPanel{

	private ArrowJpanel arrow;
	private int arrow_state;// = 0;
	private final int CHOOSE_1 = 0;
	private final int CHOOSE_2 = 1;
			
	private JLabel level, score;
	
	private final static float TRANSPARENCY = 0.9f;
	
	public GameOverDialog(double[][] shape, ArrowJpanel arrow){
		super(shape);
		this.arrow = arrow;
		MainContainer mainContainer = MainContainer.getInstance();
		
		bgImage = ImageProcesser.imageScale(new ImageIcon("resources\\image\\gameover.png"),
				(int)(mainContainer.getInterWidth() * shape[1][0]),
				(int)(mainContainer.getInterHeight() * shape[1][1]));
		
		transparency = TRANSPARENCY;
		
		this.setLayout(null);
		
		level = new JLabel();
		level.setFont(LoadFont.loadFont("resources\\font\\font.ttf", GlobalConstants.FONT_SIZE));
		level.setText("12345");
		level.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel levelJPanel = new JPanel();
		levelJPanel.setOpaque(false);
		levelJPanel.setBounds((int)(this.getWidth() * shape[2][0]), (int)(this.getHeight() * shape[2][1]), 
				(int)(this.getWidth() * shape[3][0]), (int)(this.getHeight() * shape[3][1]));
		levelJPanel.add(level);
		
		score = new JLabel();
		score.setFont(LoadFont.loadFont("resources\\font\\font.ttf", GlobalConstants.FONT_SIZE));
		score.setText("9876543");
		score.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel scoreJPanel = new JPanel();
		scoreJPanel.setOpaque(false);
		scoreJPanel.setBounds((int)(this.getWidth() * shape[4][0]),(int)(this.getHeight() * shape[4][1]), 
				(int)(this.getWidth() * shape[5][0]), (int)(this.getHeight() * shape[5][1]));
		scoreJPanel.add(score);
			
		this.add(levelJPanel);
		this.add(scoreJPanel);
		
		this.setFocusable(true);
		this.addKeyListener(new MAdapter());
		
		this.setVisible(false);
	}
	
	public void setLevelValue(String text){
		level.setText(text);
	}
	
	public void setScoreValue(String text){
		score.setText(text);
	}
	
	class MAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			ActivityHolder activityHolder = ActivityHolder.getInstance();
			super.keyPressed(e);
			switch (e.getKeyCode()) {	
			case KeyEvent.VK_ENTER:
				System.out.println("enter");
				switch (arrow_state) {
				case CHOOSE_1:
					
					break;
				case CHOOSE_2:
					break;

				default:
					break;
				}
				break;
				
			case KeyEvent.VK_LEFT:
				System.out.println("left");
				arrow.lastState();
				
				break;

			case KeyEvent.VK_RIGHT:
				System.out.println("right");
				arrow.nextState();
				break;
				
			default:
				break;
			}
		}
	}
}