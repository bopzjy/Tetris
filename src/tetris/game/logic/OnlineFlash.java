package tetris.game.logic;

import java.awt.Color;
import java.rmi.RemoteException;

import tetris.net.ClientManager;

public class OnlineFlash implements Runnable{

	private static OnlineFlash instance = new OnlineFlash();
	public FlashPipeline fPipeline = null;
	public volatile boolean exit = false;
	public volatile int sign = 0;
	
	public static OnlineFlash getInstance() {
		return instance;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		fPipeline = new FlashPipeline();
		sign =0;
		exit = false;
		FlashEntity fEntity =null;
		while(!exit) {
				fEntity = fPipeline.FEPoll();
				if(fEntity != null) {
					try {
						ClientManager.getInstance().getInterface().setBlockColorByCoordinates(fEntity.x, fEntity.y, fEntity.color);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
			
						
			
		}
		
	}
	
	public void start() {
		new Thread(this).start();
	}
	
	public void FlashBlock(int x,int y,Color color) {
			fPipeline.FEOffer(x, y, color);
	}

}
