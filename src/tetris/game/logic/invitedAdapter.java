package tetris.game.logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.mysql.fabric.xmlrpc.Client;

import tetris.net.ClientManager;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.activity.MatchActivity;

public class invitedAdapter extends KeyAdapter{
	ActivityHolder activityHolder = ActivityHolder.getInstance();
	MatchActivity matchActivity = (MatchActivity) activityHolder.getActivityByIndex(Constants.INDEX_MATCH_ACTIVITY);
    ClientManager cManager = ClientManager.getInstance();
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			matchActivity.invitedDialog.getArrowJpanel().lastState();
			break;
			
		case KeyEvent.VK_RIGHT:
			matchActivity.invitedDialog.getArrowJpanel().nextState();
			break;
		
		case KeyEvent.VK_ENTER:
			break;

		default:
			break;
		}
	}
}
