package tetris.game.logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import tetris.net.ServerManager;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.activity.LoginActivity;
import tetris.ui.activity.SinglePlayer;

public class registerKeyAdapter extends KeyAdapter{
	public void keyPressed(KeyEvent e) { 
		// TODO Auto-generated method stub
		ActivityHolder activityHolder = ActivityHolder.getInstance();
		LoginActivity loginActivity = (LoginActivity) activityHolder.getActivityByIndex(Constants.INDEX_LOGIN_ACTIVITY);
		super.keyPressed(e);
		switch (e.getKeyCode()) {
			
		case KeyEvent.VK_ENTER:
			System.out.println("lzl press enter");
			ServerManager sManager = ServerManager.getInstance();
			if(sManager.register(loginActivity.registerDialog.getName(), loginActivity.registerDialog.getPasswdVale())) {
				loginActivity.hideRegisterDialog();
			} else {
				System.out.println("Register Failed!");
				loginActivity.hideRegisterDialog();
			}
			break;
			
		default:
			break;
		}
	}
}
