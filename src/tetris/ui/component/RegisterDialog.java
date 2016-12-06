package tetris.ui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import tetris.common.GlobalConstants;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.MainContainer;
import tetris.ui.TranslucenceJPanel;
import tetris.ui.activity.SinglePlayer;
import tetris.utils.ImageProcesser;
import tetris.utils.LoadFont;

public class RegisterDialog extends TranslucenceJPanel{

	private double[][] name_shape = {
			{0.50, 0.21},		// location
			{0.362, 0.23}		// size
	};
	private double[][] passwd_shape = {
			{0.52, 0.39},		// location
			{0.362, 0.23}		// size
	};
	
	private JTextField nameTextField;
	private JPasswordField password;
	
	private final static float TRANSPARENCY = 0.9f;
	
	public RegisterDialog(double[][] shape) {
		super(shape);
		MainContainer mainContainer = MainContainer.getInstance();
		
		bgImage = ImageProcesser.imageScale(new ImageIcon("resources\\image\\register.png"),
				(int)(mainContainer.getInterWidth() * shape[1][0]),
				(int)(mainContainer.getInterHeight() * shape[1][1]));
		
		transparency = TRANSPARENCY; 
		
		this.setLayout(null);
		
		nameTextField = new JTextField(8);
		nameTextField.setBackground(null);
		nameTextField.setOpaque(false);
		nameTextField.setFont(LoadFont.loadDefaultFont());
		nameTextField.setBounds((int)(this.getWidth() * name_shape[0][0]), (int)(this.getHeight() * name_shape[0][1]), 
				(int)(this.getWidth() * name_shape[1][0]), (int)(this.getHeight() * name_shape[1][1]));
		nameTextField.setBorder(null);
		nameTextField.setHorizontalAlignment(JTextField.CENTER);
		this.add(nameTextField);
		
		password = new JPasswordField(10);
		password.setBackground(null);
		password.setOpaque(false);
		password.setFont(new Font("time nwes", Font.PLAIN, GlobalConstants.FONT_SIZE));
		password.setBounds((int)(this.getWidth() * passwd_shape[0][0]), (int)(this.getHeight() * passwd_shape[0][1]), 
				(int)(this.getWidth() * passwd_shape[1][0]), (int)(this.getHeight() * passwd_shape[1][1]));
		//password.setText("sdfsdfsaf");
		password.setBorder(null);
		this.add(password);

		this.setVisible(false);
		
		/*
		 * Demo: 通过nameTextField的keylistener，捕获回车，并作出相应的处理
		 */
		nameTextField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) { 
				// TODO Auto-generated method stub
				ActivityHolder activityHolder = ActivityHolder.getInstance();
				SinglePlayer singlePlayer = (SinglePlayer) activityHolder.getActivityByIndex(Constants.INDEX_SINGLE_PLAYER);
				super.keyPressed(e);
				switch (e.getKeyCode()) {
					
				case KeyEvent.VK_ENTER:
					//隐藏name对话框
					singlePlayer.hideNameDialog();
					//回车意味着输入结束，进行下一步操作
					singlePlayer.getNameText();
					// doSomething...
					break;
					
				default:
					break;
				}
			}
		});
	}
	
	public String getName(){
		return nameTextField.getText().trim();
	}
	
	public String getPasswdVale(){
		return password.getPassword().toString();		
	}
}
