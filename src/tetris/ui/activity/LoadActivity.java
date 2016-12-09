package tetris.ui.activity;

import tetris.ui.Activity;
import tetris.ui.ActivityFactory;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.MainContainer;

public class LoadActivity extends Activity{
	
	public LoadActivity() {
		// TODO Auto-generated constructor stub
		super("resources\\image\\load_bg.jpg");
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		MainContainer mainContainer = MainContainer.getInstance();
		
		mainContainer.getContentPane().add(jLayeredPane);		
		mainContainer.validate();
		
		ActivityFactory.produceAllActivity();
		
		ActivityHolder.getInstance().turnToNextActivity(Constants.INDEX_BEGIN_ACTIVITY);
	}
	
	public static void main(String[] args){
		new LoadActivity();		
	}

}
