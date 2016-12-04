package tetris.game.logic;

import java.awt.Color;

import tetris.common.GlobalConstants;
import tetris.ui.Activity;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.activity.SinglePlayer;

public class GameEntity {

	private static GameEntity instance = null;

	// 战场逻辑矩阵
	int[][] GameArray = null;
	// 游戏对应的界面对象
	SinglePlayer GameActivity = null;
	MovingDown mdThread = null;
	// 分数记录
	int score;
	int level;
	
	GameAdapter gAdapter=null;

	public GameEntity() {
		init();
	}

	public void init() {
		// TODO Auto-generated method stub
		GameActivity = (SinglePlayer) ActivityHolder.getInstance().getActivityByIndex(Constants.INDEX_SINGLE_PLAYER);
		mdThread = new MovingDown(this);
		GameArray = new int[GlobalConstants.NUMBER_OF_ROWS][GlobalConstants.NUMBER_OF_COLUMNS];
		score = 0;
		gAdapter = new GameAdapter(this);

	}

	public static GameEntity getInstance() {
		if (instance == null) {
			instance = new GameEntity();
		}
		return instance;
	}

	public void start() {
		GameActivity = (SinglePlayer) ActivityHolder.getInstance().getActivityByIndex(Constants.INDEX_SINGLE_PLAYER);
		score = 0;
		GameActivity.setScore(Integer.toString(score));
		level = 0;
		GameActivity.setLevel(Integer.toString(level));
		emptyArray();
		emptyGameNextArray();
		emptyGameMainArray();
		mdThread.start();
	}

	public void emptyArray() {
		for (int i = 0; i < GlobalConstants.NUMBER_OF_ROWS; i++) {
			for (int j = 0; j < GlobalConstants.NUMBER_OF_COLUMNS; j++) {
				GameArray[i][j] = 0;
			}
		}
	}

	public void emptyGameNextArray() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				GameActivity.setNextBlockColor(i, j, null);
			}
		}
	}

	public void emptyGameMainArray() {
		for (int i = 0; i < GlobalConstants.NUMBER_OF_ROWS; i++) {
			for (int j = 0; j < GlobalConstants.NUMBER_OF_COLUMNS; j++) {
				GameActivity.setBlockColorByCoordinates(i, j, Color.white);
			}
		}
	}

	public void printGameArray() {
		for (int i = 0; i < GlobalConstants.NUMBER_OF_ROWS; i++) {
			int j = 0;
			int col = GlobalConstants.NUMBER_OF_COLUMNS - 1;
			for (; j < col; j++) {
				System.out.print(GameArray[i][j] + " ");
			}
			System.out.println(GameArray[i][j]);
		}

	}

	public int getScore() {
		return score;
	}

	public void upScore(int temp) {
		score = score + temp;
	}

	public void checkLevel() {
		for (int i = level; i < GameConstants.NUMBER_OF_SPEED_RANK; i++) {
			if (score > GameConstants.SCORE_RANK[i]) {
				level = i;
			} else {
				level = i;
				break;
			}
		}
	}

	public int getLevel() {
		return level;
	}
	
	public GameAdapter getAdapter() {
		return gAdapter;
	}
	
	public static void main(String args[]) {
		ActivityHolder ac  = ActivityHolder.getInstance();
		SinglePlayer sp = (SinglePlayer) ac.turnToNextActivity(Constants.INDEX_SINGLE_PLAYER);
		GameEntity.getInstance().start();
	}
	
}
