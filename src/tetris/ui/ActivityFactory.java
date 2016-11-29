package tetris.ui;

import tetris.ui.activity.BeginActivity;
import tetris.ui.activity.IntroductionActivity;
import tetris.ui.activity.MatchActivity;
import tetris.ui.activity.PlayerChooser;
import tetris.ui.activity.RankLister;
import tetris.ui.activity.SinglePlayer;

public class ActivityFactory {
	public static Activity produceActivity(int index){
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

		default:
			return null;
		}

	}
}
