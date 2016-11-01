package tetris.game.logic;

import java.awt.Color;

public class Rotating {
	GameEntry gEntry = null;
	MovingDown mdThread = null;

	public Rotating(GameEntry gEntry) {
		this.gEntry = gEntry;
		this.mdThread = gEntry.mdThread;
	}

	public void rotate() {
		FallingEntry falltemp = new FallingEntry(mdThread.currentFEntry);
		if (falltemp.rotate()) {
			mdThread.paintFEntryInArray(mdThread.currentFEntry, true);
			mdThread.paintFallingEntry(mdThread.currentFEntry, Color.white, 1);
			mdThread.currentFEntry.rotate();
			mdThread.paintFEntryInArray(mdThread.currentFEntry, false);
			mdThread.paintFallingEntry(mdThread.currentFEntry, mdThread.currentFEntry.color, 1);
		} else {
			
		}
	}
}
