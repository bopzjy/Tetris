package tetris.ui;

import tetris.ui.activity.BeginActivity;
import tetris.ui.activity.CompeteActivity;
import tetris.ui.activity.IntroductionActivity;
import tetris.ui.activity.LoginActivity;
import tetris.ui.activity.MatchActivity;
import tetris.ui.activity.PlayerChooser;
import tetris.ui.activity.RankLister;
import tetris.ui.activity.SinglePlayer;

public class ActivityFactory {
	private static Activity produceActivity(int index){
		switch (index) {
		case Constants.INDEX_BEGIN_ACTIVITY:
			return new BeginActivity();
			//break;
		case Constants.INDEX_PLAYER_CHOOSER:
			return new PlayerChooser();
			
		case Constants.INDEX_RANK_LISTER:
			return new RankLister(); 
			
		case Constants.INDEX_INTRODUCTION_ACTIVITY:
			return new IntroductionActivity();
			
		case Constants.INDEX_SINGLE_PLAYER:
			return new SinglePlayer();
			
		case Constants.INDEX_MATCH_ACTIVITY:
			return new MatchActivity();
			
		case Constants.INDEX_LOGIN_ACTIVITY:
			return new LoginActivity();
			
		case Constants.INDEX_COMPETE_ACTIVITY:
			return new CompeteActivity();

		default:
			return null;
		}

	}
	
	public static void produceAllActivity(){
		for(int i = Constants.INDEX_BEGIN_ACTIVITY; i<Constants.TOTAL_ACTIVITY; i++){
			Activity activity = produceActivity(i);
			ActivityHolder.getInstance().reserveActivity(activity, i);
		}
	}
}
