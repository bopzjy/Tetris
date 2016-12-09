package tetris.ui.activity;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import tetris.ui.Activity;
import tetris.ui.ActivityFactory;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.MainContainer;
import tetris.ui.activity.PlayerChooser.MAdapter;
import tetris.utils.ImageProcesser;
import tetris.utils.LoadFont;

public class IntroductionActivity extends Activity{

	private final int LAYOUT_LABEL = LAYOUT_BACKGROUND + 1;
	
	private final double LABLE_WidthOfWhole = 0.7;
	private final double LABLE_HeightOfWhole = 0.48;
	private final double LABLE_XRelative = 0.16358;
	private final double LABLE_YRelative = 0.35;
	
	public IntroductionActivity() {
		super("resources\\image\\introduction_bg.jpg");
		init();
	}
	
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		MainContainer mainContainer = MainContainer.getInstance();
		
		JPanel intro = new JPanel();
		
		//intro.setBackground(Color.red);
		intro.setOpaque(false);
		intro.setBounds((int)(LABLE_XRelative * mainContainer.getInterWidth()), 
				(int)(LABLE_YRelative * mainContainer.getInterHeight()), 
				(int)(LABLE_WidthOfWhole * mainContainer.getInterWidth()), 
				(int)(LABLE_HeightOfWhole * mainContainer.getInterHeight()));
		
		JLabel jLabel = new JLabel("It's Introduction");
		jLabel.setFont(LoadFont.loadDefaultFont());
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setVerticalAlignment(SwingConstants.CENTER);
		jLabel.setText("<html>" 
				+ "Introduction 1: ..........<br>"
				+ "Introduction 2: ..........<br>"
				+ "Introduction 3: ..........<br>"
				+ "Introduction 4: ..........<br>"
				+ "Introduction 5: ..........<br>"
				+ "Introduction 6: ..........<br>"
				+ "Introduction 7: ..........<br>"
				+ "</html>");
		jLabel.setBounds(0, 0, intro.getWidth(), intro.getWidth());
		
		intro.add(jLabel);
		jLayeredPane.add(intro, new Integer(LAYOUT_LABEL));
		
		keyAdapter = new MAdapter();
		
		
	}
	
	public static void main(String[] args) {
		
		ActivityFactory.produceAllActivity();
		IntroductionActivity loginActivity = (IntroductionActivity) ActivityHolder.getInstance().getActivityByIndex(Constants.INDEX_INTRODUCTION_ACTIVITY);
		loginActivity.InitUI();
		//loginActivity.showRegisterDialog();
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
