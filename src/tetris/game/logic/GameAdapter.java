package tetris.game.logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import tetris.ui.ActivityHolder;

public class GameAdapter extends KeyAdapter{
	public GameEntry gEntry = null;
	public GameAdapter(GameEntry gEntry) {
		// TODO Auto-generated constructor stub
		this.gEntry = gEntry;
	}
	@Override
	public void keyPressed(KeyEvent e) { 
		// TODO Auto-generated method stub
		ActivityHolder activityHolder = ActivityHolder.getInstance();
		super.keyPressed(e);
		MovingRightOrLeft moveLF = new MovingRightOrLeft(gEntry);
		Rotating rot = new Rotating(gEntry); 
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			System.out.println("esc");
			activityHolder.turnToLastActivity();			
			break;
			
		case KeyEvent.VK_Q:
			//showNameDialog();
			gEntry.GameActivity.getNameText();
			break;
			
		case KeyEvent.VK_ENTER:
			gEntry.GameActivity.getNameText();
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
