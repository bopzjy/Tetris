package tetris.ui.activity;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.common.GlobalConstants;
import tetris.ui.Activity;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.MainContainer;
import tetris.ui.activity.PlayerChooser.MAdapter;
import tetris.utils.ImageProcesser;
import tetris.ui.component.ArrowJpanel;
import tetris.ui.component.RegisterDialog;

public class LoginActivity extends Activity{
	
	private final int LAYOUT_ARROW = LAYOUT_BACKGROUND + 1;
	private final int LAYOUT_REGISTERDIALOG = LAYOUT_ARROW + 1;

	private final double arrow_shape[][] = {
			{0.05, 0.0563},
			{0.24, 0.66},
			{0.48, 0.66}	
	};
	
	private ArrowJpanel arrow;
	private int arrow_state;// = 0;
	private final int CHOOSE_1 = 0;
	private final int CHOOSE_2 = 1;
	
	private RegisterDialog registerDialog;
	
	public LoginActivity() {
		// TODO Auto-generated constructor stub
		super("resources\\image\\login_bg.jpg");
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		MainContainer mainContainer = MainContainer.getInstance();
		
		arrow = new ArrowJpanel(arrow_shape, arrow_shape.length - 1);
		jLayeredPane.add(arrow, new Integer(LAYOUT_ARROW));
		
		registerDialog = new RegisterDialog(GlobalConstants.REGISTER_SHAPE);
		jLayeredPane.add(registerDialog, new Integer(LAYOUT_REGISTERDIALOG));
		registerDialog.setVisible(true);
		
		keyAdapter = new MAdapter();
		mainContainer.setKeyBoardAdapter(keyAdapter);
		
		mainContainer.getContentPane().add(jLayeredPane);		
		mainContainer.validate();
		
	}
	
	
	public void setKeyListener() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		new LoginActivity();
		
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

	}
	
	class MAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			ActivityHolder activityHolder = ActivityHolder.getInstance();
			super.keyPressed(e);
			switch (e.getKeyCode()) {
			/*case KeyEvent.VK_ESCAPE:
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
				}*/
				
			case KeyEvent.VK_LEFT:
				arrow.lastState();
				
				break;

			case KeyEvent.VK_RIGHT:
				arrow.nextState();
				break;
				
			default:
				break;
			}
		}
	}
}
