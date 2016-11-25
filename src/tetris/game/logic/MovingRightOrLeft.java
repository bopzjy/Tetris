package tetris.game.logic;

import java.awt.Color;

public class MovingRightOrLeft {
	GameEntity gEntry = null;
	MovingDown mdThread = null;

	public MovingRightOrLeft(GameEntity gEntry) {
		this.gEntry = gEntry;
		this.mdThread = gEntry.mdThread;
	}

	public void MoveRightOrLeft(int RLFlag) {
		FallingEntity falltemp = new FallingEntity(mdThread.currentFEntry);
		if (falltemp.moveRightOrLeft(RLFlag)) {
			boolean conflictFlag = false;
			conflictFlag = mdThread.IsEntryConflict(falltemp);
			if (!conflictFlag) {
				mdThread.paintFEntryInArray(mdThread.currentFEntry, true);
				mdThread.paintFEntryInArray(falltemp, false);
				mdThread.paintFallingEntity(mdThread.currentFEntry, Color.white, 1);
				mdThread.paintFallingEntity(falltemp, falltemp.color, 1);
				mdThread.currentFEntry.moveRightOrLeft(RLFlag);
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
