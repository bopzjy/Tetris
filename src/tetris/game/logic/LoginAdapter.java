package tetris.game.logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;

import tetris.common.Player;
import tetris.net.ClientManager;
import tetris.net.ServerManager;
import tetris.net.User;
import tetris.ui.Activity;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.activity.LoginActivity;
import tetris.ui.activity.MatchActivity;

public class LoginAdapter extends KeyAdapter{
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		ActivityHolder activityHolder = ActivityHolder.getInstance();
		LoginActivity loginActivity = (LoginActivity) activityHolder.getActivityByIndex(Constants.INDEX_LOGIN_ACTIVITY);
		super.keyPressed(e);
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			System.out.println("esc");
			activityHolder.turnToLastActivity();			
			break;
		
		case KeyEvent.VK_ENTER:
			System.out.println("enter");
			activityHolder = ActivityHolder.getInstance();
			//activityHolder.pushActivityByIndex(Constants.INDEX_BEGIN_ACTIVITY);
			switch (loginActivity.arrow.getState()) {
			case 1:
				ServerManager sManager = ServerManager.getInstance();
				try {
					if(sManager.login(loginActivity.getName(),loginActivity.getPasswdVale())){
						MatchActivity mActivity = (MatchActivity) activityHolder.getActivityByIndex(Constants.INDEX_MATCH_ACTIVITY);
						User [] users = sManager.getOnlinePlayers();
						Player [] players = new Player[users.length];
						for (int i=0;i<users.length;i++) {
							players[i] = new Player(users[i].username,users[i].score,users[i].ipaddr);
						}
						mActivity.rivalDialog.initCandidatesList(players);
						activityHolder.turnToNextActivity(Constants.INDEX_MATCH_ACTIVITY);
						mActivity.showRivalDialog();
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
				
			case 2:
				loginActivity.showRegisterDialog();
				break;

			default:
				break;
			}
			
		case KeyEvent.VK_LEFT:
			loginActivity.arrow.lastState();		
			break;

		case KeyEvent.VK_RIGHT:
			loginActivity.arrow.nextState();
			break;
			
		default:
			break;
		}
	}
}
