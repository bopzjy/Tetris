package tetris.game.logic;

import java.awt.Color;

public class MovingRightOrLeft {
	GameEntity gEntity = null;
	MovingDown mdThread = null;

	public MovingRightOrLeft(GameEntity gEntity) {
		this.gEntity = gEntity;
		this.mdThread = gEntity.mdThread;
	}

	public void MoveRightOrLeft(int RLFlag) {
		FallingEntity falltemp = new FallingEntity(mdThread.currentFEntity);
		if (falltemp.moveRightOrLeft(RLFlag)) {
			boolean conflictFlag = false;
			conflictFlag = mdThread.IsEntityConflict(mdThread.currentFEntity,falltemp);
			if (!conflictFlag) {
				mdThread.paintFEntityInArray(mdThread.currentFEntity, true);
				mdThread.paintFEntityInArray(falltemp, false);
				mdThread.paintFallingEntity(mdThread.currentFEntity, Color.white, 1);
				mdThread.paintFallingEntity(falltemp, falltemp.color, 1);
				mdThread.currentFEntity.moveRightOrLeft(RLFlag);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
