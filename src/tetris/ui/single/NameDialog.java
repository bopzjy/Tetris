package tetris.ui.single;

import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tetris.common.GlobalConstants;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.MainContainer;
import tetris.ui.activity.SinglePlayer;
import tetris.utils.ImageProcesser;
import tetris.utils.LoadFont;

public class NameDialog extends TranslucenceJPanel{//extends JPanel{
	
	private JTextField nameTextField;
	
	private final static float TRANSPARENCY = 0.9f;
	
	public NameDialog(double[][] shape){
		super(shape);
		MainContainer mainContainer = MainContainer.getInstance();
				
		bgImage = ImageProcesser.imageScale(new ImageIcon("resources\\image\\type_name.png"),
				(int)(mainContainer.getInterWidth() * shape[1][0]),
				(int)(mainContainer.getInterHeight() * shape[1][1]));
		
		transparency = TRANSPARENCY;
		
		this.setLayout(null);
		nameTextField = new JTextField(8);
		nameTextField.setBackground(null);
		nameTextField.setOpaque(false);
		nameTextField.setFont(LoadFont.loadFont("resources\\font\\font.ttf", GlobalConstants.FONT_SIZE));
		nameTextField.setBounds((int)(this.getWidth() * shape[2][0]),
				(int)(this.getHeight() * shape[2][1]), 
				(int)(this.getWidth() * shape[3][0]), 
				(int)(this.getHeight() * shape[3][1]));
		nameTextField.setBorder(null);
		this.add(nameTextField);

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
	
	public String getTextFieldValue(){
		return nameTextField.getText().trim();
	}
	
}
