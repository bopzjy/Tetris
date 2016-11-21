package tetris.ui.activity;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import tetris.common.GlobalConstants;
import tetris.game.logic.GameAdapter;
import tetris.game.logic.GameEntry;
import tetris.ui.Activity;
import tetris.ui.ActivityHolder;
import tetris.ui.MainContainer;
import tetris.ui.Interface.ILevelScore;
import tetris.ui.Interface.ISetBlockColor;
import tetris.ui.Interface.IGameOverDialog;
import tetris.ui.Interface.ITypeName;
import tetris.ui.activity.RankLister.MAdapter;
import tetris.ui.single.BlocksPanel;
import tetris.ui.single.DataPanel;
import tetris.ui.single.GameOverDialog;
import tetris.ui.single.NameDialog;
import tetris.ui.single.NextPanel;
import tetris.ui.single.TranslucenceJPanel;
import tetris.ui.single.Translucent;
import tetris.utils.ImageProcesser;
import tetris.utils.LoadFont;

public class SinglePlayer extends Activity implements ISetBlockColor,ITypeName,ILevelScore,IGameOverDialog{
	
	private final int LAYOUT_BACKGROUND = 0;
	private final int LAYOUT_BLOCKSPANEL = LAYOUT_BACKGROUND + 1;
	private final int LAYOUT_SCOREPANEL = LAYOUT_BLOCKSPANEL + 1;
	private final int LAYOUT_LEVELPANEL = LAYOUT_SCOREPANEL + 1;
	private final int LAYOUT_NEXTPANEL = LAYOUT_LEVELPANEL + 1;
	private final int LAYOUT_NAMEDIALOG = LAYOUT_NEXTPANEL + 1;
	private final int LAYOUT_GAMEOVER = LAYOUT_NAMEDIALOG + 1;
	
	private BlocksPanel blocksPanel;
	
	private NameDialog nameDialog;
	private DataPanel scorePanel, levelPanel;
	private NextPanel nextPanel;
	private GameOverDialog gameOverDialog;
	
	//public GameEntry gEntry =null;
	private GameEntity gameEntity;
	
	
	public SinglePlayer() {
		// TODO Auto-generated constructor stub
		//gEntry = new GameEntry(this);
		init();
		gameEntity.start();
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
		
		blocksPanel = new BlocksPanel(GlobalConstants.SINGLE_BLOCKSPANEL_XRelative, GlobalConstants.SINGLE_BLOCKSPANEL_YRelative,
				GlobalConstants.SINGLE_BLOCKSPANEL_WidthOfWhole, GlobalConstants.SINGLE_BLOCKSPANEL_HeightOfWhole);
		jLayeredPane.add(blocksPanel, new Integer(LAYOUT_BLOCKSPANEL));
		//blocksPanel.setBlockColorByCoordinates(5, 5, Color.yellow);
		
		nameDialog = new NameDialog(GlobalConstants.SINGLE_NAMEDIALOG_XRelative, GlobalConstants.SINGLE_NAMEDIALOG_YRelative,
				GlobalConstants.SINGLE_NAMEDIALOG_WidthOfWhole, GlobalConstants.SINGLE_NAMEDIALOG_HeightOfWhole,
				GlobalConstants.SINGLE_NAMEDIALOG_TF_XRelative, GlobalConstants.SINGLE_NAMEDIALOG_TF_YRelative,
				GlobalConstants.SINGLE_NAMEDIALOG_TF_WidthOfWhole, GlobalConstants.SINGLE_NAMEDIALOG_TF_HeightOfWhole);
		jLayeredPane.add(nameDialog, new Integer(LAYOUT_NAMEDIALOG));
		//showNameDialog();	
		
		scorePanel = new DataPanel(GlobalConstants.SINGLE_SCORE_XRelative, 
				GlobalConstants.SINGLE_SCORE_YRelative, 
				GlobalConstants.SINGLE_SCORE_WidthOfWhole, 
				GlobalConstants.SINGLE_SCORE_HeightOfWhole);
		jLayeredPane.add(scorePanel, new Integer(LAYOUT_SCOREPANEL));
		//test demo
		setScore("12345");
		System.out.println(scorePanel.getGameData());
		
		levelPanel = new DataPanel(GlobalConstants.SINGLE_LEVEL_XRelative, 
				GlobalConstants.SINGLE_LEVEL_YRelative, 
				GlobalConstants.SINGLE_LEVEL_WidthOfWhole, 
				GlobalConstants.SINGLE_LEVEL_HeightOfWhole);
		jLayeredPane.add(levelPanel, new Integer(LAYOUT_LEVELPANEL));
		//test demo
		setLevel("12345");
		System.out.println(levelPanel.getGameData());
		
		nextPanel = new NextPanel(GlobalConstants.SINGLE_NEXT_XRelative, 
				GlobalConstants.SINGLE_NEXT_YRelative, 
				GlobalConstants.SINGLE_NEXT_WidthOfWhole, 
				GlobalConstants.SINGLE_NEXT_HeightOfWhole);
		jLayeredPane.add(nextPanel, new Integer(LAYOUT_NEXTPANEL));
		// Demo: print blocks
		nextPanel.setBlockColorByCoordinates(1, 2, Color.green);
		nextPanel.setBlockColorByCoordinates(2, 2, Color.green);
		nextPanel.setBlockColorByCoordinates(3, 2, Color.green);
		nextPanel.setBlockColorByCoordinates(0, 2, Color.green);
		//nextPanel.setBlockColorByCoordinates(3, 3, Color.green);
		
		
		gameOverDialog = new GameOverDialog(GlobalConstants.SINGLE_GAMEOVER_XRelative, GlobalConstants.SINGLE_GAMEOVER_YRelative,
				GlobalConstants.SINGLE_GAMEOVER_WidthOfWhole, GlobalConstants.SINGLE_GAMEOVER_HeightOfWhole,
				GlobalConstants.SINGLE_GAMEOVER_LEVEL_XRelative, GlobalConstants.SINGLE_GAMEOVER_LEVEL_YRelative,
				GlobalConstants.SINGLE_GAMEOVER_LEVEL_WidthOfWhole, GlobalConstants.SINGLE_GAMEOVER_LEVEL_HeightOfWhole,
				GlobalConstants.SINGLE_GAMEOVER_SCORE_XRelative);
		jLayeredPane.add(gameOverDialog, new Integer(LAYOUT_GAMEOVER));
		//this.showGameOverDialog();
		
//		keyAdapter = new GameAdapter(gEntry);
		keyAdapter = new MAdapter();
		mainContainer.setKeyBoardAdapter(keyAdapter);
		
		mainContainer.setLayeredPane(jLayeredPane);
		mainContainer.validate();
		
		GameEntity gameEntity = new GameEntity();
		
		//showGameOverDialog();
		//hideGameOverDialog();

		
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
				
			case KeyEvent.VK_Q:
				//showNameDialog();
				System.out.println("hoho");
				//getNameText();
				break;
				
			case KeyEvent.VK_ENTER:
				getNameText();
				hideNameDialog();
				break;
				
			default:
				break;
			}
		}
	}
	
	class testAdapter extends KeyAdapter{
		public void keyPressed(KeyEvent e) { 
			// TODO Auto-generated method stub
			ActivityHolder activityHolder = ActivityHolder.getInstance();
			super.keyPressed(e);
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				System.out.println("esc");
				activityHolder.turnToLastActivity();			
				break;
				
			case KeyEvent.VK_Q:
				//showNameDialog();
				System.out.println("heheda");
				//getNameText();
				break;
				
			case KeyEvent.VK_ENTER:
				//getNameText();
				break;
				
			default:
				break;
			}
		}
	}

	@Override
	public void showNameDialog() {
		// TODO Auto-generated method stub
		nameDialog.setVisible(true);
	}

	@Override
	public void setBlockColorByCoordinates(int i, int j, Color color) {
		// TODO Auto-generated method stub
		blocksPanel.setBlockColorByCoordinates(5, 5, Color.yellow);
	}

	@Override
	public String getNameText() {
		// TODO Auto-generated method stub
		System.out.println(nameDialog.getTextFieldValue());
		return nameDialog.getTextFieldValue();
		//return null;
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return levelPanel.getGameData();
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return scorePanel.getGameData();
	}

	@Override
	public void hideNameDialog() {
		// TODO Auto-generated method stub
		nameDialog.setVisible(false);
	}

	@Override
	public void setNextBlockColor(int i, int j, Color color) {
		// TODO Auto-generated method stub
		nextPanel.setBlockColorByCoordinates(i, j, color);
	}

	@Override
	public void showGameOverDialog() {
		// TODO Auto-generated method stub
		gameOverDialog.setVisible(true);
		gameOverDialog.requestFocusInWindow();
	}

	@Override
	public void hideGameOverDialog() {
		// TODO Auto-generated method stub
		gameOverDialog.setVisible(false);
	}

	@Override
	public void setLevel(String text) {
		// TODO Auto-generated method stub
		levelPanel.setGameData(text);
	}

	@Override
	public void setScore(String text) {
		// TODO Auto-generated method stub
		scorePanel.setGameData(text);
	}

	@Override
	public void setLevelInDialog(String text) {
		// TODO Auto-generated method stub
		gameOverDialog.setLevelValue(text);
	}

	@Override
	public void setScoreInDialog(String text) {
		// TODO Auto-generated method stub
		gameOverDialog.setScoreValue(text);
	}
}
