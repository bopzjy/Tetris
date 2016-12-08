package tetris.ui.activity;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.ui.Activity;
import tetris.ui.ActivityFactory;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.MainContainer;
import tetris.ui.activity.PlayerChooser.MAdapter;
import tetris.utils.ImageProcesser;

public class RankLister extends Activity{
	
	public RankLister() {
		// TODO Auto-generated constructor stub
		super("resources\\image\\rank_bg.jpg");
		init();
	}
	
	@Override
	protected void init() {
		MainContainer mainContainer = MainContainer.getInstance();
		keyAdapter = new MAdapter();

	}
	
	
	@Override
	public void RestoreUI() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void InitUI() {
		super.InitUI();
	}
	
	class MAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			ActivityHolder activityHolder = ActivityHolder.getInstance();
			super.keyPressed(e);
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				activityHolder.turnToLastActivity();			
				break;
			default:
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		ActivityFactory.produceAllActivity();
		RankLister rankLister = (RankLister) ActivityHolder.getInstance().getActivityByIndex(Constants.INDEX_RANK_LISTER);
		rankLister.InitUI();
		
	}
	
	
}
