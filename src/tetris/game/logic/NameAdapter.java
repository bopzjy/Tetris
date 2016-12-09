package tetris.game.logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import tetris.common.Player;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.activity.SinglePlayer;

public class NameAdapter extends KeyAdapter{
	public void keyPressed(KeyEvent e) { 
		// TODO Auto-generated method stub
		ActivityHolder activityHolder = ActivityHolder.getInstance();
		SinglePlayer singlePlayer = (SinglePlayer) activityHolder.getActivityByIndex(Constants.INDEX_SINGLE_PLAYER);
		GameEntity gEntity = GameEntity.getInstance();
		super.keyPressed(e);
		switch (e.getKeyCode()) {
			
		case KeyEvent.VK_ENTER:
			singlePlayer.hideNameDialog();
			addPlayerRecord(new Player(singlePlayer.getNameText(),gEntity.getScore()));
			activityHolder.turnToLastActivity();
			break;
			
		default:
			break;
		}
	}
}
