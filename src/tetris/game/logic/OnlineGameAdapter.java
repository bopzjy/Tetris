package tetris.game.logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;

import tetris.ui.ActivityHolder;

public class OnlineGameAdapter extends KeyAdapter{
	public GameEntity gEntity = null;
	public OnlineGameAdapter(GameEntity gEntity) {
		// TODO Auto-generated constructor stub
		this.gEntity = gEntity;
	}
	@Override
	public void keyPressed(KeyEvent e) { 
		// TODO Auto-generated method stub
		ActivityHolder activityHolder = ActivityHolder.getInstance();
		super.keyPressed(e);
		OnlineMovingRightOrLeft moveLF = new OnlineMovingRightOrLeft(gEntity);
		OnlineRotating rot = new OnlineRotating(gEntity); 
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			System.out.println("esc");
			activityHolder.turnToLastActivity();			
			break;
			
		case KeyEvent.VK_Q:
			//showNameDialog();
			gEntity.GameActivity.getNameText();
			break;
			
		case KeyEvent.VK_ENTER:
			gEntity.GameActivity.getNameText();
			break;
			
		case KeyEvent.VK_LEFT:
			System.out.println("online left ++++++++++++++++++++++++++++++++++++");
			try {
				moveLF.OnlineMoveRightOrLeft(0);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
			
		case KeyEvent.VK_RIGHT:			
			try {
				moveLF.OnlineMoveRightOrLeft(1);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		
		case KeyEvent.VK_UP:
			rot.rotate();
			break;
			
		default:
			break;
		}
		
	}
}
