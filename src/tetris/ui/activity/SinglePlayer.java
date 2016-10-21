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
import tetris.ui.activity.RankLister.MAdapter;
import tetris.ui.single.BlocksPanel;
import tetris.utils.ImageProcesser;

public class SinglePlayer extends Activity{
	
	private final int LAYOUT_BACKGROUND = 0;
	private final int LAYOUT_BLOCKSPANEL = LAYOUT_BACKGROUND + 1;
	
	public BlocksPanel blocksPanel; 
	
	public SinglePlayer() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		MainContainer mainContainer = MainContainer.getInstance();
		
		ImageIcon bgImage = ImageProcesser.imageScale(new ImageIcon("resources\\image\\single_bg.jpg"),
				mainContainer.getInterWidth(),
				mainContainer.getInterHeight());
		
		jLayeredPane = new JLayeredPane();
		JPanel bgPanel = new JPanel();
		
		bgPanel.setBounds(0, 0, mainContainer.getInterWidth(), mainContainer.getInterHeight());
		bgPanel.add(new JLabel(bgImage));
		bgPanel.setBorder(new EmptyBorder(-5, 0, -5, 0));
		jLayeredPane.add(bgPanel, LAYOUT_BACKGROUND);
		
		blocksPanel = new BlocksPanel();
		jLayeredPane.add(blocksPanel, new Integer(LAYOUT_BLOCKSPANEL));
		//blocksPanel.setBlockColorByCoordinates(5, 5, Color.yellow);
		
		keyAdapter = new MAdapter();
		mainContainer.setKeyBoardAdapter(keyAdapter);
		
		mainContainer.setLayeredPane(jLayeredPane);
		mainContainer.validate();
	}
	
	public static void main(String[] args) {
		new SinglePlayer();
	}
	
	
	@Override
	public void RestoreUI() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void InitUI() {
		// TODO Auto-generated method stub
		MainContainer mainContainer = MainContainer.getInstance();
		
		blocksPanel.clearPanel();
		
		mainContainer.setKeyBoardAdapter(keyAdapter);
		mainContainer.setLayeredPane(jLayeredPane);
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
