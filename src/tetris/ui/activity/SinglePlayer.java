package tetris.ui.activity;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import tetris.common.GlobalConstants;
import tetris.game.logic.GameAdapter;

import tetris.game.logic.GameEntity;

import tetris.ui.Activity;
import tetris.ui.ActivityHolder;
import tetris.ui.MainContainer;
import tetris.ui.component.ArrowJpanel;
import tetris.ui.single.BlocksPanel;
import tetris.ui.single.DataPanel;
import tetris.ui.single.GameOverDialog;
import tetris.ui.single.NameDialog;

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
			//{0.48, 0.66}	
	};
	
	//private GameEntity gameEntity;
	
	
	public SinglePlayer() {
		// TODO Auto-generated constructor stub
		super("resources\\image\\single_bg.jpg");
		//gEntry = new GameEntry(this);
		init();
		//gameEntity.start();
		GameEntity.getInstance();
	}
	
	@Override
	protected void init() {

		//MainContainer mainContainer = MainContainer.getInstance();
		
		blocksPanel = new BlocksPanel(GlobalConstants.SINGLE_GAMEBLOCKS_SHAPE, GlobalConstants.BLOCKSPANEL_INIT_COLOR, 
				GlobalConstants.NUMBER_OF_ROWS, GlobalConstants.NUMBER_OF_COLUMNS, 2);
		jLayeredPane.add(blocksPanel, new Integer(LAYOUT_BLOCKSPANEL));
		//setBlockColorByCoordinates(5, 5, Color.yellow);
		
		nextPanel = new BlocksPanel(GlobalConstants.SINGLE_NEXTPANEL_SHAPE, null, 4, 5, 2);
		jLayeredPane.add(nextPanel, new Integer(LAYOUT_NEXTPANEL));
		// Demo: print blocks
		/*
		nextPanel.setBlockColorByCoordinates(1, 2, Color.green);
		nextPanel.setBlockColorByCoordinates(2, 2, Color.green);
		nextPanel.setBlockColorByCoordinates(3, 2, Color.green);
		nextPanel.setBlockColorByCoordinates(0, 2, Color.green);
		*/
		
		nameDialog = new NameDialog(GlobalConstants.SINGLE_NAMEDIALOG_SHAPE);
		jLayeredPane.add(nameDialog, new Integer(LAYOUT_NAMEDIALOG));
		
		scorePanel = new DataPanel(GlobalConstants.SINGLE_SCORE_SHAPE);
		jLayeredPane.add(scorePanel, new Integer(LAYOUT_SCOREPANEL));
		//test demo
		setScore("12345");
		//System.out.println(scorePanel.getGameData());
		
		levelPanel = new DataPanel(GlobalConstants.SINGLE_LEVEL_SHAPE);
		jLayeredPane.add(levelPanel, new Integer(LAYOUT_LEVELPANEL));
		//test demo
		setLevel("12345");
		//System.out.println(levelPanel.getGameData());
			
		gameOverArrow = new ArrowJpanel(arrow_shape, arrow_shape.length - 1);
		gameOverDialog = new GameOverDialog(GlobalConstants.SINGLE_GAMEOVER_SHAPE, gameOverArrow);
		gameOverArrow.setVisible(false);
		jLayeredPane.add(gameOverDialog, new Integer(LAYOUT_GAMEOVER));
		jLayeredPane.add(gameOverArrow, new Integer(LAYOUT_GAMEOVER_ARROW));
	
		keyAdapter = new MAdapter();
		//
		
		//mainContainer.setLayeredPane(jLayeredPane);
		//mainContainer.validate();
		
		//showGameOverDialog();
		//hideGameOverDialog();

		//showNameDialog();
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

	public void showNameDialog() {
		// TODO Auto-generated method stub
		nameDialog.setVisible(true);
	}

	public String getNameText() {
		// TODO Auto-generated method stub
		System.out.println(nameDialog.getTextFieldValue());
		return nameDialog.getTextFieldValue();
		//return null;
	}

	public int getLevel() {
		// TODO Auto-generated method stub
		return levelPanel.getGameData();
	}

	public int getScore() {
		// TODO Auto-generated method stub
		return scorePanel.getGameData();
	}

	public void hideNameDialog() {
		// TODO Auto-generated method stub
		nameDialog.setVisible(false);
	}

	public void setBlockColorByCoordinates(int i, int j, Color color) {
		// TODO Auto-generated method stub
		blocksPanel.setBlockColorByCoordinates(i, j, color);
	}
	
	public void setNextBlockColor(int i, int j, Color color) {
		// TODO Auto-generated method stub
		nextPanel.setBlockColorByCoordinates(i, j, color);
	}

	public void showGameOverDialog() {
		// TODO Auto-generated method stub
		gameOverDialog.setVisible(true);
		gameOverDialog.requestFocusInWindow();
		gameOverArrow.setVisible(true);
	}

	public void hideGameOverDialog() {
		// TODO Auto-generated method stub
		gameOverDialog.setVisible(false);
		gameOverArrow.setVisible(false);
	}

	public void setLevel(String text) {
		// TODO Auto-generated method stub
		levelPanel.setGameData(text);
	}

	public void setScore(String text) {
		// TODO Auto-generated method stub
		scorePanel.setGameData(text);
	}

	public void setLevelInDialog(String text) {
		// TODO Auto-generated method stub
		gameOverDialog.setLevelValue(text);
	}

	public void setScoreInDialog(String text) {
		// TODO Auto-generated method stub
		gameOverDialog.setScoreValue(text);
	}
}
