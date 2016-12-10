package tetris.game.logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;

import com.mysql.fabric.xmlrpc.Client;

import tetris.net.ClientManager;
import tetris.net.ServerManager;
import tetris.net.status;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.activity.MatchActivity;

public class invitedAdapter extends KeyAdapter {
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
			switch (matchActivity.invitedDialog.getArrowJpanel().getState()) {
			case 1:
				ServerManager sManager = ServerManager.getInstance();
				if(sManager.state == status.online) {
					sManager.setState(status.battling);
					try {
						sManager.server.setStatus(sManager.username, status.battling);
					} catch (RemoteException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					GameEntity gEntity = GameEntity.getInstance();
					gEntity.OnlineGameInit();
					try {
						ClientManager.getInstance().getInterface().inviteBattleACK();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					gEntity.OnlineGameStart();
					
				}
				break;

			case 2:
				ClientManager cManager = ClientManager.getInstance();
				try {
					cManager.getInterface().rejectedBattle();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				matchActivity.hideInvitedDialog();
				try {
					InitUILogic.showRivalDiaolog();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;

			default:
				break;
			}
			break;

		default:
			break;
		}
	}
}
