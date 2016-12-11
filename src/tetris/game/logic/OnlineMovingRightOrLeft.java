package tetris.game.logic;

import java.awt.Color;
import java.rmi.RemoteException;

public class OnlineMovingRightOrLeft {
	GameEntity gEntity = null;
	OnlineMovingDown mdThread = null;

	public OnlineMovingRightOrLeft(GameEntity gEntity) {
		this.gEntity = gEntity;
		this.mdThread = gEntity.onlinemdThread;
	}

	public void OnlineMoveRightOrLeft(int RLFlag) throws RemoteException {
		FallingEntity falltemp = new FallingEntity(mdThread.currentFEntity);
		if (falltemp.moveRightOrLeft(RLFlag)) {
			boolean conflictFlag = false;
			conflictFlag = mdThread.IsEntityConflict(mdThread.currentFEntity,falltemp);
			if (!conflictFlag) {
				mdThread.paintFEntityInArray(mdThread.currentFEntity, true);
				mdThread.paintFEntityInArray(falltemp, false);
				try {
					mdThread.paintFallingEntity(mdThread.currentFEntity, Color.white, 1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					mdThread.paintFallingEntity(falltemp, falltemp.color, 1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
