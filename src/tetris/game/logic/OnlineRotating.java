package tetris.game.logic;

import java.awt.Color;
import java.rmi.RemoteException;

public class OnlineRotating {
	GameEntity gEntity = null;
	OnlineMovingDown mdThread = null;

	public OnlineRotating(GameEntity gEntity) {
		this.gEntity = gEntity;
		this.mdThread = gEntity.onlinemdThread;
	}

	public void rotate() {
		FallingEntity falltemp = new FallingEntity(mdThread.currentFEntity);
		if (falltemp.rotate()) {
			boolean conflictFlag = false;
			conflictFlag = mdThread.IsEntityConflict(mdThread.currentFEntity,falltemp);
			if(!conflictFlag) {
				mdThread.paintFEntityInArray(mdThread.currentFEntity, true);
				try {
					mdThread.paintFallingEntity(mdThread.currentFEntity, Color.white, 1);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mdThread.currentFEntity.rotate();
				mdThread.paintFEntityInArray(mdThread.currentFEntity, false);
				try {
					mdThread.paintFallingEntity(mdThread.currentFEntity, mdThread.currentFEntity.color, 1);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} else {
			
		}
	}
}
