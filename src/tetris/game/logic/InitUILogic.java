package tetris.game.logic;

import java.rmi.RemoteException;

import tetris.common.Player;
import tetris.net.ServerManager;
import tetris.net.User;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.activity.MatchActivity;

public class InitUILogic {
	public static void showRivalDiaolog() throws RemoteException {
		ActivityHolder activityHolder = ActivityHolder.getInstance();
		MatchActivity mActivity = (MatchActivity) activityHolder.getActivityByIndex(Constants.INDEX_MATCH_ACTIVITY);
		User [] users = ServerManager.getInstance().getOnlinePlayers();
		Player [] players = new Player[users.length];
		for (int i=0;i<users.length;i++) {
			players[i] = new Player(users[i].username,users[i].score);
		}
		mActivity.rivalDialog.initCandidatesList(players);
		activityHolder.turnToNextActivity(Constants.INDEX_MATCH_ACTIVITY);
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		mActivity.showRivalDialog();
	}
}
