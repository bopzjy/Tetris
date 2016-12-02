package tetris.ui.activity;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.ui.Activity;
import tetris.ui.ActivityFactory;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.MainContainer;
import tetris.ui.activity.BeginActivity.MAdapter;
import tetris.utils.ImageProcesser;

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


	public void setKeyListener() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		//System.out.println("nimei");
		new LoadActivity();
		
	}

	@Override
	public void RestoreUI() {
		// TODO Auto-generated method stub
	}

	@Override
	public void InitUI() {
		// TODO Auto-generated method stub

	}
	
}
