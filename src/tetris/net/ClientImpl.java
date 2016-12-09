package tetris.net;

import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import tetris.game.logic.GameAdapter;
import tetris.game.logic.GameConstants;
import tetris.game.logic.GameEntity;
import tetris.game.logic.InitUILogic;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.activity.MatchActivity;

public class ClientImpl extends UnicastRemoteObject implements ClientInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = -911918969070457823L;

	/**
	 * complete the method here to be invoke
	 */


	protected ClientImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String test(String str) throws RemoteException {
		// TODO Auto-generated method stub
		return "send from"+str;
	}

	
	
	@Override
	public boolean acceptBattle() throws RemoteException {
		// TODO Auto-generated method stub
		ServerManager sManager = ServerManager.getInstance();
		if(sManager.state == status.online) {
			sManager.setState(status.battling);
			sManager.server.setStatus(sManager.username, status.battling);
			GameEntity gEntity = GameEntity.getInstance();
			gEntity.OnlineGameInit();
			gEntity.OnlineGameStart();
			return true;
		}
			
		return false;
	}
	

	@Override
	public boolean InitCheck() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setBlockColorByCoordinates(int i, int j, Color color) throws RemoteException {
		// TODO Auto-generated method stub
		GameEntity.getInstance().getcomActivity().setRivalColor(i, j, color);
	}

	@Override
	public void youWin() throws RemoteException {
		// TODO Auto-generated method stub
		GameEntity.getInstance().onlinemdThread.exit1 = true;
		GameEntity.getInstance().onlinemdThread.exit2 = true;
		ServerManager sManager = ServerManager.getInstance();
		sManager.server.updateScore(sManager.username, GameConstants.YOU_WIN_SCORE);
		sManager.setState(status.online);
		sManager.server.setStatus(sManager.username, status.online);
		InitUILogic.showRivalDiaolog();
	}

	@Override
	public void inviteBattle(String rivalName) throws RemoteException {
		// TODO Auto-generated method stub
		ActivityHolder activityHolder = ActivityHolder.getInstance();
		MatchActivity matchActivity = (MatchActivity) activityHolder.getActivityByIndex(Constants.INDEX_MATCH_ACTIVITY);
		matchActivity.showInvitedDialog(rivalName);
	}

}
