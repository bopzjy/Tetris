package tetris.game.logic;

import java.awt.Color;

public class MovingRightOrLeft {
	GameEntry gEntry = null;
	MovingDown mdThread = null;

	public MovingRightOrLeft(GameEntry gEntry) {
		this.gEntry = gEntry;
		this.mdThread = gEntry.mdThread;
	}

	public void MoveRightOrLeft(int RLFlag) {
		FallingEntry falltemp = new FallingEntry(mdThread.currentFEntry);
		if (falltemp.moveRightOrLeft(RLFlag)) {
			boolean conflictFlag = false;
			conflictFlag = mdThread.IsEntryConflict(falltemp);
			if (!conflictFlag) {
				mdThread.paintFEntryInArray(mdThread.currentFEntry, true);
				mdThread.paintFEntryInArray(falltemp, false);
				mdThread.paintFallingEntry(mdThread.currentFEntry, Color.white, 1);
				mdThread.paintFallingEntry(falltemp, falltemp.color, 1);
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
