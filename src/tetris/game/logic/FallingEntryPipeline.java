package tetris.game.logic;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

public class FallingEntryPipeline {

	// 产生下落物的队列
	Queue<FallingEntry> FEPipeline = null;

	// 队列对应的游戏实例
	GameEntry gEntry = null;

	public FallingEntryPipeline(GameEntry gEntry) {
		FEPipeline = new LinkedList<FallingEntry>();
		this.gEntry = gEntry;
	}

	public FallingEntryPipeline() {
		FEPipeline = new LinkedList<FallingEntry>();
		gEntry = new GameEntry();
	}

	public int getScore() {
		return gEntry.getScore();
	}

	public boolean FEOffer(int patternNum, Color color, int speedRank, Spot headspot,int directNum) {
		return FEPipeline.offer(new FallingEntry(patternNum, color, speedRank,headspot,directNum));
	}

	public boolean FEOffer(FallingEntry fe) {
		return FEPipeline.offer(fe);
	}

	public FallingEntry FEPoll() {
		return FEPipeline.poll();
	}

	public int getFEPipelineSize() {
		return FEPipeline.size();
	}

	public void printFallingEntryPipeline() {
		Queue<FallingEntry> FEPTemp = new LinkedList<FallingEntry>();
		FallingEntry FETemp = FEPoll();
		while (FETemp != null) {
			FETemp.printFallingEntry();
			FEPTemp.offer(FETemp);
			FETemp = FEPoll();
		}
		FEPipeline = FEPTemp;
	}

	public static void main(String args[]) throws InterruptedException {
		//FallingEntry fe0 = new FallingEntry();
		//FallingEntry fe1 = new FallingEntry(1, 2, 3);
		// fe0.printFallingEntry();
		// fe1.printFallingEntry();
		//FallingEntryPipeline fep0 = new FallingEntryPipeline();
		// fep0.FEOffer(fe0);
		// fep0.FEOffer(fe1);
		// fep0.FEOffer(2, 3, 3);
		// fep0.printFallingEntryPipeline();
		//Thread Producer = new Thread(new FEPipelineProducer(fep0));
		//Thread Consumer = new Thread(new FEPipelineConsumer(fep0));
		//Producer.start();
		//Thread.sleep(2);
		//Consumer.start();
	}

}
