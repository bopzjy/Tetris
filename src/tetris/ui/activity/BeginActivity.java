package tetris.ui.activity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.activation.MailcapCommandMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.ui.Activity;
import tetris.ui.ActivityHolder;
import tetris.ui.ChangeUI;
import tetris.ui.Constants;
import tetris.ui.MainContainer;
import tetris.ui.component.ArrowJpanel;
import tetris.utils.ImageProcesser;

public class BeginActivity extends Activity implements ChangeUI{
		
	private final int LAYOUT_ARROW = LAYOUT_BACKGROUND + 1;
	
	private ArrowJpanel arrow;
	private int arrow_state;// = 0;
	private final double arrow_shape[][] = {
			{0.045, 0.0559},
			{0.30, 0.585},
			{0.30, 0.665},
			{0.30, 0.745}
	};
	
	private final int CHOOSE_1 = 0;
	private final int CHOOSE_2 = 1;
	private final int CHOOSE_3 = 2;
	
	public BeginActivity() {
		super("resources\\image\\begin_bg.jpg");
		
		keyAdapter = null;
		arrow_state = 0;
		
		init();
		
	}

	@Override
	public void init() {
		//MainContainer.getInstance().j
		//MainContainer mainContainer = MainContainer.getInstance();
		
		arrow = new ArrowJpanel(arrow_shape, arrow_shape.length - 1);
		jLayeredPane.add(arrow, new Integer(LAYOUT_ARROW));

		keyAdapter = new MAdapter();
		//mainContainer.setKeyBoardAdapter(keyAdapter);
		
	}
	
	public static void main(String[] args) {
		new BeginActivity();
	}

	@Override
	public void RestoreUI() {
		MainContainer mainContainer = MainContainer.getInstance();
		
		mainContainer.setKeyBoardAdapter(keyAdapter);
		mainContainer.setLayeredPane(jLayeredPane);
		mainContainer.repaint();
		//mainContainer.validate();
		
	}

	@Override
	public void InitUI() {
		// TODO Auto-generated method stub
		/*MainContainer mainContainer = MainContainer.getInstance();
		
		mainContainer.setKeyBoardAdapter(keyAdapter);
		mainContainer.setLayeredPane(jLayeredPane);
		mainContainer.repaint();*/
		
		MainContainer mainContainer = MainContainer.getInstance();
		//mainContainer.setKeyBoardAdapter(keyAdapter);
		mainContainer.setLayeredPane(jLayeredPane);	
		System.out.println("heedada");
		jLayeredPane.repaint();
		mainContainer.repaint();
		mainContainer.validate();
		
	}
	
	class MAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyPressed(e);
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ENTER:
				System.out.println("enter");
				ActivityHolder activityHolder = ActivityHolder.getInstance();
				activityHolder.pushActivityByIndex(Constants.INDEX_BEGIN_ACTIVITY);
				switch (arrow_state) {
				case CHOOSE_1:
					activityHolder.turnToNextActivity(Constants.INDEX_PLAYER_CHOOSER);
					break;
					
				case CHOOSE_2:
					System.out.println("chose 2");
					activityHolder.turnToNextActivity(Constants.INDEX_RANK_LISTER);
					break;

				case CHOOSE_3:
					System.out.println("chose 3");
					activityHolder.turnToNextActivity(Constants.INDEX_INTRODUCTION_ACTIVITY);
					break;
					
				default:
					break;
				}
				
				break;
				
			case KeyEvent.VK_UP:
				arrow.lastState();
				
				break;

			case KeyEvent.VK_DOWN:
				arrow.nextState();
				break;
				
			default:
				break;
			}
		}
	}
	

}
