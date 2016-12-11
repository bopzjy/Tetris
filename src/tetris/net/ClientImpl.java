package tetris.net;

import java.awt.Color;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import tetris.game.logic.GameAdapter;
import tetris.game.logic.GameConstants;
import tetris.game.logic.GameEntity;
import tetris.game.logic.InitUILogic;
import tetris.game.logic.OnlineFlash;
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
		OnlineFlash.getInstance().exit = true;
		ServerManager sManager = ServerManager.getInstance();
		sManager.server.updateScore(sManager.username, GameConstants.YOU_WIN_SCORE);
		sManager.setState(status.online);
		sManager.server.setStatus(sManager.username, status.online);
		InitUILogic.showRivalDiaolog();
	}

	@Override
	public void inviteBattle(String rivalName, String url) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			ClientManager.getInstance().connect(url);
		} catch (MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActivityHolder activityHolder = ActivityHolder.getInstance();
		MatchActivity matchActivity = (MatchActivity) activityHolder.getActivityByIndex(Constants.INDEX_MATCH_ACTIVITY);
		matchActivity.hideRivalDialog();
		matchActivity.showInvitedDialog(rivalName);
	}

	@Override
	public void inviteBattleACK() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("101+++++++++++++++++++++++++++++++++++++++++++++");
		GameEntity.getInstance().OnlineGameStart();
		System.out.println("local has start");
	}

	@Override
	public void rejectedBattle() throws RemoteException {
		// TODO Auto-generated method stub
		ServerManager sManager = ServerManager.getInstance();
		sManager.setState(status.online);
		sManager.server.setStatus(sManager.username, status.online);
		ActivityHolder activityHolder = ActivityHolder.getInstance();
		MatchActivity matchActivity = (MatchActivity) activityHolder.getActivityByIndex(Constants.INDEX_MATCH_ACTIVITY);
		matchActivity.hideWaitDialog();
		InitUILogic.showRivalDiaolog();
	}

}
