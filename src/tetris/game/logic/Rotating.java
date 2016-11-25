package tetris.game.logic;

import java.awt.Color;

public class Rotating {
	GameEntity gEntry = null;
	MovingDown mdThread = null;

	public Rotating(GameEntity gEntry) {
		this.gEntry = gEntry;
		this.mdThread = gEntry.mdThread;
	}

	public void rotate() {
		FallingEntity falltemp = new FallingEntity(mdThread.currentFEntry);
		if (falltemp.rotate()) {
			mdThread.paintFEntryInArray(mdThread.currentFEntry, true);
			mdThread.paintFallingEntity(mdThread.currentFEntry, Color.white, 1);
			mdThread.currentFEntry.rotate();
			mdThread.paintFEntryInArray(mdThread.currentFEntry, false);
			mdThread.paintFallingEntity(mdThread.currentFEntry, mdThread.currentFEntry.color, 1);
		} else {
			
		}
	}
}
