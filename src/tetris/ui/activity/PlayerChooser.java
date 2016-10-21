package tetris.ui.activity;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.ui.Activity;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.MainContainer;

import tetris.utils.ImageProcesser;

public class PlayerChooser extends Activity{
	
	private final int LAYOUT_BACKGROUND = 0;
	private final int LAYOUT_ARROW = LAYOUT_BACKGROUND + 1;
	
	private JPanel arrow;
	private int arrow_state;// = 0;
	private final double arrow_widthOfBG = 0.050;//4.72/120;
	private final double arrow_heightOfBG = 0.0563;
	private final double arrow_xRelative = 0.39;
	private final double arrow_yRelative[] = {0.608, 0.718}; 
	private final int CHOOSE_1 = 0;
	private final int CHOOSE_2 = 1;
	
	public PlayerChooser() {
		// TODO Auto-generated constructor stub
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		MainContainer mainContainer = MainContainer.getInstance();
		
		ImageIcon bgImage = ImageProcesser.imageScale(new ImageIcon("resources\\image\\playerchooser_bg.jpg"),
				mainContainer.getInterWidth(),
				mainContainer.getInterHeight());
		
		jLayeredPane = new JLayeredPane();
		JPanel bgPanel = new JPanel();
		
		bgPanel.setBounds(0, 0, mainContainer.getInterWidth(), mainContainer.getInterHeight());
		bgPanel.add(new JLabel(bgImage));
		bgPanel.setBorder(new EmptyBorder(-5, 0, -5, 0));
		jLayeredPane.add(bgPanel, LAYOUT_BACKGROUND);
		
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
		
		keyAdapter = new MAdapter();
		mainContainer.setKeyBoardAdapter(keyAdapter);
		
		mainContainer.setLayeredPane(jLayeredPane);
		mainContainer.validate();
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
		
		arrowUp();
		
		mainContainer.setKeyBoardAdapter(keyAdapter);
		mainContainer.setLayeredPane(jLayeredPane);
		mainContainer.repaint();
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
		if(arrow_state<CHOOSE_2){
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
				switch (arrow_state) {
				case CHOOSE_1:
					activityHolder.turnToNextActivity(Constants.INDEX_SINGLE_PLAYER);
					break;

				default:
					break;
				}
				
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
