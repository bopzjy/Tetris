package tetris.game.logic;

import java.awt.Color;

import tetris.common.GlobalConstants;
import tetris.ui.Activity;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.activity.CompeteActivity;
import tetris.ui.activity.LoginActivity;
import tetris.ui.activity.MatchActivity;
import tetris.ui.activity.SinglePlayer;

public class GameEntity {

	private static GameEntity instance = null;

	// 战场逻辑矩阵
	int[][] GameArray = null;
	// 游戏对应的界面对象
	SinglePlayer GameActivity = null;
	CompeteActivity comActvity = null;
	MovingDown mdThread = null;
	OnlineMovingDown onlinemdThread = null;
	// 分数记录
	int score;
	int level;

	GameAdapter gAdapter = null;
	OnlineGameAdapter onlinegameAdapter = null;

	public GameEntity() {
		init();
	}

	public void init() {
		// TODO Auto-generated method stub
		GameActivity = (SinglePlayer) ActivityHolder.getInstance().getActivityByIndex(Constants.INDEX_SINGLE_PLAYER);
		mdThread = new MovingDown(this);
		onlinemdThread = new OnlineMovingDown(this);
		GameArray = new int[GlobalConstants.NUMBER_OF_ROWS][GlobalConstants.NUMBER_OF_COLUMNS];
		score = 0;
		gAdapter = new GameAdapter(this);
		onlinegameAdapter = new OnlineGameAdapter(this);
		comActvity = ActivityHolder.getInstance().getActivityByIndex(Constants.INDEX_COMPETE_ACTIVITY);
	}

	public void OnlineGameInit() {
		comActvity = ActivityHolder.getInstance().getActivityByIndex(Constants.INDEX_COMPETE_ACTIVITY);
		score = 0;
		level = 0;
		emptyArray();
		emptyGameNextArray(1);
		emptyGameMainArray(1);
	}

	public void OnlineGameStart() {
		ActivityHolder.getInstance().turnToNextActivity(Constants.INDEX_SINGLE_PLAYER);
		onlinemdThread.start();
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
		emptyGameNextArray(0);
		emptyGameMainArray(0);
		ActivityHolder.getInstance().turnToNextActivity(Constants.INDEX_SINGLE_PLAYER);
		mdThread.start();
	}

	public void emptyArray() {
		for (int i = 0; i < GlobalConstants.NUMBER_OF_ROWS; i++) {
			for (int j = 0; j < GlobalConstants.NUMBER_OF_COLUMNS; j++) {
				GameArray[i][j] = 0;
			}
		}
	}

	public void emptyGameNextArray(int onlineflag) {
		//0表示单机，1表示网络对战
		if(onlineflag == 0) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 5; j++) {
					GameActivity.setNextBlockColor(i, j, null);
				}
			}
		} else {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 5; j++) {
					comActvity.setNextBlockColor(i, j, null);
				}
			}
		}
		
	}

	public void emptyGameMainArray(int onlineflag) {
		//0表示单机，1表示网络对战
		if(onlineflag == 0) {
			for (int i = 0; i < GlobalConstants.NUMBER_OF_ROWS; i++) {
				for (int j = 0; j < GlobalConstants.NUMBER_OF_COLUMNS; j++) {
					GameActivity.setBlockColorByCoordinates(i, j, Color.white);
				}
			}
		} else {
			for (int i = 0; i < GlobalConstants.NUMBER_OF_ROWS; i++) {
				for (int j = 0; j < GlobalConstants.NUMBER_OF_COLUMNS; j++) {
					comActvity.setMyColor(i, j, Color.white);
				}
			}
			for (int i = 0; i < GlobalConstants.NUMBER_OF_ROWS; i++) {
				for (int j = 0; j < GlobalConstants.NUMBER_OF_COLUMNS; j++) {
					comActvity.setRivalColor(i, j, Color.white);
				}
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
		ActivityHolder ac = ActivityHolder.getInstance();
		// SinglePlayer sp = (SinglePlayer)
		// ac.turnToNextActivity(Constants.INDEX_SINGLE_PLAYER);
		// LoginActivity sp2 = (LoginActivity)
		// ac.turnToNextActivity(Constants.INDEX_LOGIN_ACTIVITY);
		// ac.pushActivityByIndex(Constants.INDEX_LOGIN_ACTIVITY);
		// GameEntity.getInstance().start();
		MatchActivity la = new MatchActivity();
		la.InitUI();
		la.showRivalDialog();
	}

}
