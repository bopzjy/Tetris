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
import tetris.utils.ImageProcesser;

public class BeginActivity extends Activity implements ChangeUI{
		
	private final int LAYOUT_BACKGROUND = 0;
	private final int LAYOUT_ARROW = LAYOUT_BACKGROUND + 1;
	
	private JPanel arrow;
	private int arrow_state;// = 0;
	private final double arrow_widthOfBG = 0.045;//4.72/120;
	private final double arrow_heightOfBG = 0.0559;
	private final double arrow_xRelative = 0.30;
	private final double arrow_yRelative[] = {0.585, 0.665, 0.745}; 
	private final int CHOOSE_1 = 0;
	private final int CHOOSE_2 = 1;
	private final int CHOOSE_3 = 2;
	/*private final double arrow_yRelative_1 = 0.585;
	private final double arrow_yRelative_2 = 0.665;
	private final double arrow_yRelative_3 = 0.745;*/
	
	public BeginActivity() {
		keyAdapter = null;
		arrow_state = 0;
		
		init();
		
	}

	@Override
	public void init() {
		//MainContainer.getInstance().j
		MainContainer mainContainer = MainContainer.getInstance();
		
		ImageIcon bgImage = ImageProcesser.imageScale(new ImageIcon("resources\\image\\begin_bg.jpg"),
				mainContainer.getInterWidth(),
				mainContainer.getInterHeight());
		
		jLayeredPane = new JLayeredPane();
		
		JPanel bgPanel = new JPanel();
		bgPanel.setBounds(0, 0, mainContainer.getInterWidth(), mainContainer.getInterHeight());
		bgPanel.add(new JLabel(bgImage));
		bgPanel.setBorder(new EmptyBorder(-5, 0, -5, 0));
		jLayeredPane.add(bgPanel, new Integer(LAYOUT_BACKGROUND));
		
		ImageIcon arrowIcon = new ImageIcon("resources\\image\\arrow.png");
		arrowIcon = ImageProcesser.imageScale(arrowIcon, 
				(int)(mainContainer.getInterWidth() * arrow_widthOfBG), 
				(int)(mainContainer.getInterHeight() * arrow_heightOfBG));		
		arrow = new JPanel();
		arrow.add(new JLabel(arrowIcon));
		arrow.setOpaque(false);
		arrow.setBorder(new EmptyBorder(-5, 0, -5, 0));
		arrow.setBounds((int)(mainContainer.getInterWidth() * arrow_xRelative), 
				(int)(mainContainer.getInterHeight() * arrow_yRelative[arrow_state]), 
				arrowIcon.getIconWidth(), arrowIcon.getIconHeight());
		jLayeredPane.add(arrow, new Integer(LAYOUT_ARROW));
		
		/*GridLayout testgrid = new GridLayout(2,2);
		testgrid.add(new JButton());
		testgrid.*/
		JPanel test = new JPanel();
		test.setLayout(new GridLayout(2, 2, 1, 1));
		JButton testjb = new JButton();
		JLabel testjl = new JLabel();
		JPanel testjp = new JPanel();
		
		testjb.setBackground(Color.BLUE);
		testjl.setBackground(Color.GREEN);
		testjp.setBackground(Color.black);
		test.add(testjp);
		test.add(new JButton());
		test.add(new JButton());
		test.add(new JButton());
		test.add(new JButton());
		test.add(new JButton());
		test.add(new JButton());
		test.add(new JButton());
		test.setBounds(50, 50, 100, 200);
		//test.setBackground(Color.black);
		test.setOpaque(false);
		jLayeredPane.add(test, new Integer(100));

		keyAdapter = new MAdapter();
		mainContainer.setKeyBoardAdapter(keyAdapter);
		
		mainContainer.setLayeredPane(jLayeredPane);
		mainContainer.validate();
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
	}
	
	private void arrowUp(){
		if(arrow_state>CHOOSE_1){
			MainContainer mainContainer = MainContainer.getInstance();
			arrow_state--;
			
			arrow.setLocation((int)(mainContainer.getInterWidth() * arrow_xRelative),
					(int)(mainContainer.getInterHeight() * arrow_yRelative[arrow_state]));		
		}
	}
	
	private void arrowDown(){
		if(arrow_state<CHOOSE_3){
			MainContainer mainContainer = MainContainer.getInstance();
			arrow_state++;
			
			arrow.setLocation((int)(mainContainer.getInterWidth() * arrow_xRelative),
					(int)(mainContainer.getInterHeight() * arrow_yRelative[arrow_state]));		
		}
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
				System.out.println("up");
				arrowUp();
				
				break;

			case KeyEvent.VK_DOWN:
				System.out.println("down");
				arrowDown();
				break;
				
			default:
				break;
			}
		}
	}
	

}
