package tetris.game.logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.net.ssl.SSLEngineResult.Status;

import tetris.common.Player;
import tetris.net.ServerManager;
import tetris.net.User;
import tetris.net.status;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.activity.LoginActivity;
import tetris.ui.activity.MatchActivity;

public class rivalKeyAdapter extends KeyAdapter{
	public void keyPressed(KeyEvent e) {
		ActivityHolder activityHolder = ActivityHolder.getInstance();
		MatchActivity matchActivity = (MatchActivity) activityHolder.getActivityByIndex(Constants.INDEX_MATCH_ACTIVITY);
		super.keyPressed(e);
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			System.out.println("hehedada");
			matchActivity.rivalDialog.arrowJpanel.lastState();
			break;
			
		case KeyEvent.VK_DOWN:
			matchActivity.rivalDialog.arrowJpanel.nextState();
			break;
			
		case KeyEvent.VK_ENTER:
			ServerManager sManager = ServerManager.getInstance();
			sManager.setState(status.offline);
			break;

		default:
			break;
		}
	}
}
