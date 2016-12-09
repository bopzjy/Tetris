package tetris.ui.activity;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.stylesheets.StyleSheetList;

import tetris.common.Player;
import tetris.ui.Activity;
import tetris.ui.ActivityFactory;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.MWidget;
import tetris.ui.MainContainer;
import tetris.ui.activity.PlayerChooser.MAdapter;
import tetris.utils.ImageProcesser;
import tetris.utils.LoadFont;
import tetris.utils.LocalRank;

public class RankLister extends Activity{
	
	private static final int LAYOUT_WIGET = LAYOUT_BACKGROUND + 1;
	private static final int MAX_ITEMS = 10;
	
	private MWidget listJPanel;
	private MJLabel listItem[][];
	
	public RankLister() {
		super("resources\\image\\rank_bg.jpg");
		init();
	}
	
	@Override
	protected void init() {
		MainContainer mainContainer = MainContainer.getInstance();
		
		listItem = new MJLabel[10][2];
		
		listJPanel = new MWidget(new double[][]{{0.2375, 0.280}, {0.583, 0.51}});
		
		GridLayout layout = new GridLayout(0, 2, 0, 2);
		listJPanel.setLayout(layout);
		listJPanel.setOpaque(false);
		
		for(int i = 0; i<10; i++){
			listItem[i][0] = new MJLabel();
			listItem[i][1] = new MJLabel();
			listJPanel.add(listItem[i][0]);
			listJPanel.add(listItem[i][1]);
		}
		
		jLayeredPane.add(listJPanel, new Integer(LAYOUT_WIGET));
		keyAdapter = new MAdapter();

	}
	
	public void setRankList(Player[] players){
		if(players==null)
			return;
		for(int i = 0; i<players.length && i<MAX_ITEMS; i++){
			listItem[i][0].setText(players[i].getName());
			listItem[i][1].setText(players[i].getScore() + "");
		}
		for(int i = players.length; i<MAX_ITEMS; i++){
			listItem[i][0].setText(null);
			listItem[i][1].setText(null);
		}	
	}
	
	class MJLabel extends JLabel{
		public MJLabel() {
			this.setFont(LoadFont.loadFont(36));
			this.setHorizontalAlignment(SwingConstants.CENTER);
			//this.setText("abcdefg");
		}
		
	}
	
	class MAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
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
		
		rankLister.setRankList(LocalRank.getMaxXPalyers());
	}
	
}
