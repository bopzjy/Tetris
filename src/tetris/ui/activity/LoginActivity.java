package tetris.ui.activity;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.ObjectInputStream.GetField;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import tetris.common.GlobalConstants;
import tetris.game.logic.LoginAdapter;
import tetris.ui.Activity;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.MainContainer;
import tetris.ui.activity.PlayerChooser.MAdapter;
import tetris.utils.ImageProcesser;
import tetris.utils.LoadFont;
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
	
	private double[][] name_shape = {
			{0.48, 0.43},		// location
			{0.312, 0.08}		// size
	};
	private double[][] passwd_shape = {
			{0.48, 0.525},		// location
			{0.312, 0.08}		// size
	};
	
	public ArrowJpanel arrow;
	private JTextField nameTextField;
	private JPasswordField password;
	
	public RegisterDialog registerDialog;
	
	public LoginActivity() {
		// TODO Auto-generated constructor stub
		super("resources\\image\\login_bg.jpg");
		//System.out.println("nimei123");
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		MainContainer mainContainer = MainContainer.getInstance();
		
		arrow = new ArrowJpanel(arrow_shape, 2);
		
		jLayeredPane.add(arrow, new Integer(LAYOUT_ARROW));
		
		registerDialog = new RegisterDialog(GlobalConstants.REGISTER_SHAPE);
		jLayeredPane.add(registerDialog, new Integer(LAYOUT_REGISTERDIALOG));
		
		nameTextField = new JTextField(8);
		nameTextField.setBackground(null);
		nameTextField.setOpaque(false);
		nameTextField.setFont(LoadFont.loadDefaultFont());
		nameTextField.setBounds((int)(mainContainer.getInterWidth() * name_shape[0][0]), (int)(mainContainer.getInterHeight() * name_shape[0][1]), 
				(int)(mainContainer.getInterWidth() * name_shape[1][0]), (int)(mainContainer.getInterHeight() * name_shape[1][1]));
		nameTextField.setBorder(null);
		nameTextField.setHorizontalAlignment(JTextField.CENTER);
		jLayeredPane.add(nameTextField, new Integer(LAYOUT_ARROW));
		
		password = new JPasswordField(10);
		password.setBackground(null);
		password.setOpaque(false);
		password.setFont(new Font("time nwes", Font.PLAIN, GlobalConstants.FONT_SIZE));
		password.setBounds((int)(mainContainer.getInterWidth() * passwd_shape[0][0]), (int)(mainContainer.getInterHeight() * passwd_shape[0][1]), 
				(int)(mainContainer.getInterWidth() * passwd_shape[1][0]), (int)(mainContainer.getInterHeight() * passwd_shape[1][1]));
		//password.setText("sdfsdfsaf");
		password.setBorder(null);
		jLayeredPane.add(password, new Integer(LAYOUT_ARROW));
		
		keyAdapter = new MAdapter();
		//
		
		//mainContainer.getContentPane().add(jLayeredPane);		
		//mainContainer.validate();
		
	}
	
	
	public void setKeyListener() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		new LoginActivity().InitUI();
		
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
		mainContainer.setKeyBoardAdapter(new LoginAdapter());
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
	
	public String getName(){
		return nameTextField.getText().trim();
	}
	
	public String getPasswdVale(){
		return password.getPassword().toString();		
	}
	
	public void showRegisterDialog(){
		registerDialog.requestFocusInWindow();
		registerDialog.setVisible(true);
	}
	
	public void hideRegisterDialog(){
		registerDialog.setVisible(false);
	}
}
