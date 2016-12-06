package tetris.game.logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.net.ssl.SSLEngineResult.Status;

import tetris.common.Player;
import tetris.net.ClientInterface;
import tetris.net.ClientManager;
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
			matchActivity.hideRivalDialog();
			matchActivity.showWaitDialog();
			ServerManager sManager = ServerManager.getInstance();
			sManager.setState(status.battling);
			try {
				if(!sManager.server.setStatus(sManager.username,status.battling)){
					System.out.println();
				}
			} catch (RemoteException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			ClientManager cManager = ClientManager.getInstance();
			User opponent = sManager.users[matchActivity.rivalDialog.arrowJpanel.getState()];
			try {
				ClientInterface clientInterface = cManager.connect(opponent.url);
				GameEntity gEntity = GameEntity.getInstance();
				gEntity.OnlineGameInit();
				if(clientInterface.acceptBattle()) {
					matchActivity.hideWaitDialog();
					//activityHolder.turnToNextActivity(Constants.INDEX_COMPETE_ACTIVITY);
					gEntity.OnlineGameStart();
				}
			} catch (MalformedURLException | RemoteException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		default:
			break;
		}
	}
}
