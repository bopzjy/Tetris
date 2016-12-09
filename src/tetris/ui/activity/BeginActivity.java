package tetris.ui.activity;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import tetris.ui.Activity;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.MainContainer;
import tetris.ui.component.ArrowJpanel;
import tetris.utils.LocalRank;


public class BeginActivity extends Activity{
		
	private static final int LAYOUT_ARROW = LAYOUT_BACKGROUND + 1;
	
	private ArrowJpanel arrow;
	private final double arrow_shape[][] = {
			{0.045, 0.0559},
			{0.30, 0.57},
			{0.30, 0.645},
			{0.30, 0.725}
	};
	
	private final int CHOOSE_1 = 1;
	private final int CHOOSE_2 = 2;
	private final int CHOOSE_3 = 3;
	
	public BeginActivity() {
		super("resources\\image\\begin_bg.jpg");	
		init();	
	}

	@Override
	public void init() {
		
		arrow = new ArrowJpanel(arrow_shape, 3, MainContainer.getInstance());
		jLayeredPane.add(arrow, new Integer(LAYOUT_ARROW));

		keyAdapter = new MAdapter();
		
	}
	
	public static void main(String[] args) {
		new BeginActivity();
	}
	
	class MAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ENTER:
				ActivityHolder activityHolder = ActivityHolder.getInstance();
				activityHolder.pushActivityByIndex(Constants.INDEX_BEGIN_ACTIVITY);
				switch (arrow.getState()) {
				case CHOOSE_1:
					activityHolder.turnToNextActivity(Constants.INDEX_PLAYER_CHOOSER);
					break;
					
				case CHOOSE_2:
					RankLister rankLister = (RankLister) activityHolder.turnToNextActivity(Constants.INDEX_RANK_LISTER);
					rankLister.setRankList(LocalRank.getMaxXPalyers());
					break;

				case CHOOSE_3:
					activityHolder.turnToNextActivity(Constants.INDEX_INTRODUCTION_ACTIVITY);
					break;
					
				default:
					break;
				}
				
				break;
				
			case KeyEvent.VK_UP:
				arrow.lastState();
				
				break;

			case KeyEvent.VK_DOWN:
				arrow.nextState();
				break;
				
			default:
				break;
			}
		}
	}
	

}
