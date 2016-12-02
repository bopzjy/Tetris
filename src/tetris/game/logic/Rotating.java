package tetris.game.logic;

import java.awt.Color;

public class Rotating {
	GameEntity gEntity = null;
	MovingDown mdThread = null;

	public Rotating(GameEntity gEntity) {
		this.gEntity = gEntity;
		this.mdThread = gEntity.mdThread;
	}

	public void rotate() {
		FallingEntity falltemp = new FallingEntity(mdThread.currentFEntity);
		if (falltemp.rotate()) {
			mdThread.paintFEntityInArray(mdThread.currentFEntity, true);
			mdThread.paintFallingEntity(mdThread.currentFEntity, Color.white, 1);
			mdThread.currentFEntity.rotate();
			mdThread.paintFEntityInArray(mdThread.currentFEntity, false);
			mdThread.paintFallingEntity(mdThread.currentFEntity, mdThread.currentFEntity.color, 1);
		} else {
			
		}
	}
}
