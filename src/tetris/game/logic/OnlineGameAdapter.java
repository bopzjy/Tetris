package tetris.game.logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		MovingRightOrLeft moveLF = new MovingRightOrLeft(gEntity);
		Rotating rot = new Rotating(gEntity); 
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
			moveLF.MoveRightOrLeft(0);
			break;
			
		case KeyEvent.VK_RIGHT:			
			moveLF.MoveRightOrLeft(1);
			break;
		
		case KeyEvent.VK_UP:
			rot.rotate();
			break;
			
		default:
			break;
		}
		
	}
}