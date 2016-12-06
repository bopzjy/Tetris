package tetris.ui.activity;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.ui.Activity;
import tetris.ui.ActivityHolder;
import tetris.ui.MainContainer;
import tetris.ui.activity.PlayerChooser.MAdapter;
import tetris.utils.ImageProcesser;

public class IntroductionActivity extends Activity{

	private final int LAYOUT_LABEL = LAYOUT_BACKGROUND + 1;
	
	private final double LABLE_WidthOfWhole = 0.7;
	private final double LABLE_HeightOfWhole = 0.48;
	private final double LABLE_XRelative = 0.16358;
	private final double LABLE_YRelative = 0.35;
	
	public IntroductionActivity() {
		// TODO Auto-generated constructor stub
		super("resources\\image\\introduction_bg.jpg");
		init();
	}
	
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		MainContainer mainContainer = MainContainer.getInstance();
		
		JLabel jLabel = new JLabel();
		JPanel intro = new JPanel();
		jLabel.setText("heheda");
		intro.add(jLabel);
		intro.setBackground(Color.red);
		intro.setBounds((int)(LABLE_XRelative * mainContainer.getInterWidth()), 
				(int)(LABLE_YRelative * mainContainer.getInterHeight()), 
				(int)(LABLE_WidthOfWhole * mainContainer.getInterWidth()), 
				(int)(LABLE_HeightOfWhole * mainContainer.getInterHeight()));
		jLayeredPane.add(intro, new Integer(LAYOUT_LABEL));
		
		keyAdapter = new MAdapter();
		
		
	}
	
	public static void main(String[] args) {
		new IntroductionActivity();
	}
	
	@Override
	public void RestoreUI() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void InitUI() {
		// TODO Auto-generated method stub
		MainContainer mainContainer = MainContainer.getInstance();
		
		mainContainer.setKeyBoardAdapter(keyAdapter);
		mainContainer.setLayeredPane(jLayeredPane);
		mainContainer.setKeyBoardAdapter(keyAdapter);
		mainContainer.validate();
		mainContainer.repaint();
	}
	
	public void setKeyListener() {
		if(keyAdapter==null)
			keyAdapter = new MAdapter();
		MainContainer.getInstance().setKeyBoardAdapter(keyAdapter);
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
			default:
				break;
			}
		}
	}
	

}
