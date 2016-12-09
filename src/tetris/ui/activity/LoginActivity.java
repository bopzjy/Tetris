package tetris.ui.activity;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import tetris.common.GlobalConstants;
import tetris.game.logic.LoginAdapter;
import tetris.game.logic.registerKeyAdapter;
import tetris.ui.Activity;
import tetris.ui.ActivityFactory;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.MainContainer;
import tetris.utils.LoadFont;
import tetris.ui.component.ArrowJpanel;
import tetris.ui.dialog.RegisterDialog;

public class LoginActivity extends Activity{
	
	private final int LAYOUT_ARROW = LAYOUT_BACKGROUND + 1; 
	private final int LAYOUT_REGISTERDIALOG = LAYOUT_ARROW + 1;

	private final double arrow_shape[][] = {
			{0.05, 0.0563},
			{0.23, 0.64},
			{0.47, 0.64}	
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
		
		arrow = new ArrowJpanel(arrow_shape, 2, mainContainer);
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
		password.setHorizontalAlignment(JPasswordField.CENTER);
		password.setBorder(null);
		jLayeredPane.add(password, new Integer(LAYOUT_ARROW));
		
		keyAdapter = new LoginAdapter();
		
		registerDialog.addKeyListener(new registerKeyAdapter());
		
	}
	
	public static void main(String[] args){
		
		ActivityFactory.produceAllActivity();
		LoginActivity loginActivity = (LoginActivity) ActivityHolder.getInstance().getActivityByIndex(Constants.INDEX_LOGIN_ACTIVITY);
		loginActivity.InitUI();
		loginActivity.showRegisterDialog();
	}
	
	public String getName(){
		return nameTextField.getText().trim();
	}
	
	public String getPasswdVale(){
		return String.valueOf(password.getPassword());		
	}
	
	public void showRegisterDialog(){	
		// 一定要可见了才能获取焦点
		registerDialog.setVisible(true);
		registerDialog.requestFocusInWindow();
		MainContainer.getInstance().removeMouseAdapter();
	}
	
	public void hideRegisterDialog(){
		registerDialog.setVisible(false);
		MainContainer.getInstance().setMouseAdapter();
	}
}
