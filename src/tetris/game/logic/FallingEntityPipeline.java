package tetris.game.logic;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

public class FallingEntityPipeline {

	// 产生下落物的队列
	Queue<FallingEntity> FEPipeline = null;

	// 队列对应的游戏实例
	GameEntity gEntity = null;

	public FallingEntityPipeline(GameEntity gEntity) {
		FEPipeline = new LinkedList<FallingEntity>();
		this.gEntity = gEntity;
	}

	public FallingEntityPipeline() {
		FEPipeline = new LinkedList<FallingEntity>();
		gEntity = new GameEntity();
	}

	public int getScore() {
		return gEntity.getScore();
	}

	public boolean FEOffer(int patternNum, Color color, int speedRank, Spot headspot,int directNum) {
		return FEPipeline.offer(new FallingEntity(patternNum, color, speedRank,headspot,directNum));
	}

	public boolean FEOffer(FallingEntity fe) {
		return FEPipeline.offer(fe);
	}

	public FallingEntity FEPoll() {
		return FEPipeline.poll();
	}

	public int getFEPipelineSize() {
		return FEPipeline.size();
	}

	public void printFallingEntityPipeline() {
		Queue<FallingEntity> FEPTemp = new LinkedList<FallingEntity>();
		FallingEntity FETemp = FEPoll();
		while (FETemp != null) {
			FETemp.printFallingEntity();
			FEPTemp.offer(FETemp);
			FETemp = FEPoll();
		}
		FEPipeline = FEPTemp;
	}

	public static void main(String args[]) throws InterruptedException {
		//FallingEntity fe0 = new FallingEntity();
		//FallingEntity fe1 = new FallingEntity(1, 2, 3);
		// fe0.printFallingEntity();
		// fe1.printFallingEntity();
		//FallingEntityPipeline fep0 = new FallingEntityPipeline();
		// fep0.FEOffer(fe0);
		// fep0.FEOffer(fe1);
		// fep0.FEOffer(2, 3, 3);
		// fep0.printFallingEntityPipeline();
		//Thread Producer = new Thread(new FEPipelineProducer(fep0));
		//Thread Consumer = new Thread(new FEPipelineConsumer(fep0));
		//Producer.start();
		//Thread.sleep(2);
		//Consumer.start();
	}

}
