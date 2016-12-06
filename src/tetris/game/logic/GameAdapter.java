package tetris.game.logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import tetris.ui.ActivityHolder;
import tetris.ui.Constants;

public class GameAdapter extends KeyAdapter{
	public GameEntity gEntity = null;
	public GameAdapter(GameEntity gEntity) {
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
			gEntity.mdThread.exit1 = true;
			gEntity.mdThread.exit2 = true;
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
