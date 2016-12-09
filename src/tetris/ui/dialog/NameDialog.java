package tetris.ui.dialog;

import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tetris.common.GlobalConstants;
import tetris.game.logic.NameAdapter;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.MainContainer;
import tetris.ui.TranslucenceJPanel;
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
		 * Demo: 閫氳繃nameTextField鐨刱eylistener锛屾崟鑾峰洖杞︼紝骞朵綔鍑虹浉搴旂殑澶勭悊
		 */
		/*nameTextField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) { 
				// TODO Auto-generated method stub
				ActivityHolder activityHolder = ActivityHolder.getInstance();
				SinglePlayer singlePlayer = (SinglePlayer) activityHolder.getActivityByIndex(Constants.INDEX_SINGLE_PLAYER);
				super.keyPressed(e);
				switch (e.getKeyCode()) {
					
				case KeyEvent.VK_ENTER:
					//闅愯棌name瀵硅瘽妗�
					singlePlayer.hideNameDialog();
					//鍥炶溅鎰忓懗鐫�杈撳叆缁撴潫锛岃繘琛屼笅涓�姝ユ搷浣�
					singlePlayer.getNameText();
					// doSomething...
					break;
					
				default:
					break;
				}
			}
		});*/
		nameTextField.addKeyListener(new NameAdapter());
	}
	
	public String getTextFieldValue(){
		return nameTextField.getText().trim();
	}
	
}
