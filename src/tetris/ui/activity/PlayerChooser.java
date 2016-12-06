package tetris.ui.activity;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import tetris.ui.Activity;
import tetris.ui.ActivityFactory;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.MainContainer;
import tetris.ui.component.ArrowJpanel;

public class PlayerChooser extends Activity{
	
	private final int LAYOUT_ARROW = LAYOUT_BACKGROUND + 1;
	
	private ArrowJpanel arrow;
	private final double arrow_shape[][] = {
		{0.05, 0.0563},
		{0.39, 0.580},
		{0.39, 0.690}	
	};
	private final int CHOOSE_1 = 1;
	private final int CHOOSE_2 = 2;
	
	public PlayerChooser() {
		// TODO Auto-generated constructor stub
		super("resources\\image\\playerchooser_bg.jpg");
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		//MainContainer mainContainer = MainContainer.getInstance();
		
		arrow = new ArrowJpanel(arrow_shape, arrow_shape.length - 1, MainContainer.getInstance());
		jLayeredPane.add(arrow, new Integer(LAYOUT_ARROW));

		keyAdapter = new MAdapter();
	}
	
	public static void main(String[] args) {
		ActivityFactory.produceAllActivity();
		new PlayerChooser().InitUI();;
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
		mainContainer.validate();
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
				activityHolder.pushActivityByIndex(Constants.INDEX_PLAYER_CHOOSER);
				switch (arrow.getState()) {
				case CHOOSE_1:
					activityHolder.turnToNextActivity(Constants.INDEX_SINGLE_PLAYER);
					break;
				
				case CHOOSE_2:
					activityHolder.turnToNextActivity(Constants.INDEX_LOGIN_ACTIVITY);
					break;
					
				default:
					break;
				}
				
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
