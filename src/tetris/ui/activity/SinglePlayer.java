package tetris.ui.activity;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import tetris.common.GlobalConstants;
import tetris.game.logic.GameAdapter;

import tetris.game.logic.GameEntity;

import tetris.ui.Activity;
import tetris.ui.ActivityFactory;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.MainContainer;
import tetris.ui.component.ArrowJpanel;
import tetris.ui.component.BlocksPanel;
import tetris.ui.component.DataPanel;
import tetris.ui.dialog.GameOverDialog;
import tetris.ui.dialog.NameDialog;

public class SinglePlayer extends Activity{
	
	private final int LAYOUT_BLOCKSPANEL = LAYOUT_BACKGROUND + 1;
	private final int LAYOUT_SCOREPANEL = LAYOUT_BLOCKSPANEL + 1;
	private final int LAYOUT_LEVELPANEL = LAYOUT_SCOREPANEL + 1;
	private final int LAYOUT_NEXTPANEL = LAYOUT_LEVELPANEL + 1;
	private final int LAYOUT_NAMEDIALOG = LAYOUT_NEXTPANEL + 1;
	private final int LAYOUT_GAMEOVER = LAYOUT_NAMEDIALOG + 1;
	private final int LAYOUT_GAMEOVER_ARROW = LAYOUT_GAMEOVER + 1;
	
	private BlocksPanel blocksPanel, nextPanel;
	
	private NameDialog nameDialog;
	private DataPanel scorePanel, levelPanel;
	//private NextPanel nextPanel;
	private GameOverDialog gameOverDialog;
	private ArrowJpanel gameOverArrow; 
	private final double arrow_shape[][] = {
			{0.05, 0.0563},
			{0.215, 0.65},
			{0.450, 0.65}
	};
	
	public SinglePlayer() {
		super("resources\\image\\single_bg.jpg");
		init();
	
	}

	protected void init() {
		
		blocksPanel = new BlocksPanel(GlobalConstants.SINGLE_GAMEBLOCKS_SHAPE, GlobalConstants.BLOCKSPANEL_INIT_COLOR, 
				GlobalConstants.NUMBER_OF_ROWS, GlobalConstants.NUMBER_OF_COLUMNS, 2);
		jLayeredPane.add(blocksPanel, new Integer(LAYOUT_BLOCKSPANEL));
		//setBlockColorByCoordinates(5, 5, Color.yellow);
		
		nextPanel = new BlocksPanel(GlobalConstants.SINGLE_NEXTPANEL_SHAPE, null, 4, 5, 2);
		jLayeredPane.add(nextPanel, new Integer(LAYOUT_NEXTPANEL));
		
		nameDialog = new NameDialog(GlobalConstants.SINGLE_NAMEDIALOG_SHAPE);
		jLayeredPane.add(nameDialog, new Integer(LAYOUT_NAMEDIALOG));
		
		scorePanel = new DataPanel(GlobalConstants.SINGLE_SCORE_SHAPE);
		jLayeredPane.add(scorePanel, new Integer(LAYOUT_SCOREPANEL));
		
		levelPanel = new DataPanel(GlobalConstants.SINGLE_LEVEL_SHAPE);
		jLayeredPane.add(levelPanel, new Integer(LAYOUT_LEVELPANEL));
			
		gameOverArrow = new ArrowJpanel(arrow_shape, arrow_shape.length - 1, MainContainer.getInstance());
		gameOverDialog = new GameOverDialog(GlobalConstants.SINGLE_GAMEOVER_SHAPE, gameOverArrow);
		gameOverArrow.setVisible(false);
		jLayeredPane.add(gameOverDialog, new Integer(LAYOUT_GAMEOVER));
		jLayeredPane.add(gameOverArrow, new Integer(LAYOUT_GAMEOVER_ARROW));
		
	}
	
	public static void main(String[] args) {
		ActivityFactory.produceAllActivity();
		((SinglePlayer) ActivityHolder.getInstance().getActivityByIndex(Constants.INDEX_SINGLE_PLAYER)).InitUI();
		//new SinglePlayer().InitUI();
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
	public void InitUI() {
		// TODO Auto-generated method stub
		super.InitUI();
		GameEntity.getInstance().start();
	}

	public void showNameDialog() {
		nameDialog.setVisible(true);
	}

	public String getNameText() {
		System.out.println(nameDialog.getTextFieldValue());
		return nameDialog.getTextFieldValue();
	}

	public int getLevel() {
		return levelPanel.getGameData();
	}

	public int getScore() {
		return scorePanel.getGameData();
	}

	public void hideNameDialog() {
		nameDialog.setVisible(false);
	}

	public void setBlockColorByCoordinates(int i, int j, Color color) {
		blocksPanel.setBlockColorByCoordinates(i, j, color);
	}
	
	public void setNextBlockColor(int i, int j, Color color) {
		nextPanel.setBlockColorByCoordinates(i, j, color);
	}

	public void showGameOverDialog() {
		gameOverDialog.setVisible(true);
		gameOverDialog.requestFocusInWindow();
		gameOverArrow.setVisible(true);
	}

	public void hideGameOverDialog() {
		gameOverDialog.setVisible(false);
		gameOverArrow.setVisible(false);
	}

	public void setLevel(String text) {
		levelPanel.setGameData(text);
	}

	public void setScore(String text) {
		scorePanel.setGameData(text);
	}

	public void setLevelInDialog(String text) {
		gameOverDialog.setLevelValue(text);
	}

	public void setScoreInDialog(String text) {
		gameOverDialog.setScoreValue(text);
	}
}
