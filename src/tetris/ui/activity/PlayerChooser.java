package tetris.ui.activity;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.ui.Activity;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.MainContainer;
import tetris.ui.component.ArrowJpanel;
import tetris.utils.ImageProcesser;

public class PlayerChooser extends Activity{
	
	private final int LAYOUT_ARROW = LAYOUT_BACKGROUND + 1;
	
	private ArrowJpanel arrow;
	private int arrow_state;// = 0;
	private final double arrow_shape[][] = {
		{0.05, 0.0563},
		{0.39, 0.608},
		{0.39, 0.718}	
	};
	private final int CHOOSE_1 = 0;
	private final int CHOOSE_2 = 1;
	
	public PlayerChooser() {
		// TODO Auto-generated constructor stub
		super("resources\\image\\playerchooser_bg.jpg");
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		MainContainer mainContainer = MainContainer.getInstance();
		
		arrow = new ArrowJpanel(arrow_shape);
		jLayeredPane.add(arrow, new Integer(LAYOUT_ARROW));

		keyAdapter = new MAdapter();
		mainContainer.setKeyBoardAdapter(keyAdapter);
		
		mainContainer.setLayeredPane(jLayeredPane);
		mainContainer.validate();
	}
	
	public static void main(String[] args) {
		new PlayerChooser();
	}
	
	@Override
	public void RestoreUI() {
		// TODO Auto-generated method stub
		MainContainer mainContainer = MainContainer.getInstance();
		
		mainContainer.setKeyBoardAdapter(keyAdapter);
		mainContainer.setLayeredPane(jLayeredPane);
		mainContainer.repaint();
	}

	@Override
	public void InitUI() {
		// TODO Auto-generated method stub
		MainContainer mainContainer = MainContainer.getInstance();
		
		mainContainer.setKeyBoardAdapter(keyAdapter);
		mainContainer.setLayeredPane(jLayeredPane);
		mainContainer.repaint();
	}

	
	class MAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			ActivityHolder activityHolder = ActivityHolder.getInstance();
			super.keyPressed(e);
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				System.out.println("esc");
				activityHolder.turnToLastActivity();			
				break;
			
			case KeyEvent.VK_ENTER:
				System.out.println("enter");
				activityHolder = ActivityHolder.getInstance();
				activityHolder.pushActivityByIndex(Constants.INDEX_BEGIN_ACTIVITY);
				switch (arrow_state) {
				case CHOOSE_1:
					activityHolder.turnToNextActivity(Constants.INDEX_SINGLE_PLAYER);
					break;

				default:
					break;
				}
				
			case KeyEvent.VK_UP:
				System.out.println("up");
				arrow.lastState();
				
				break;

			case KeyEvent.VK_DOWN:
				System.out.println("down");
				arrow.nextState();
				break;
				
			default:
				break;
			}
		}
	}


}
