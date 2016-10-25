package tetris.game.logic;

import java.util.Random;

public class FEPipelineProducer implements Runnable {

	FallingEntryPipeline line = null;

	public FEPipelineProducer() {
		// TODO Auto-generated constructor stub
		line = new FallingEntryPipeline();
	}

	public FEPipelineProducer(FallingEntryPipeline FEPipeline) {
		this.line = FEPipeline;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random ra = new Random();
		while (true) {
			int lineSize = line.getFEPipelineSize();
			// System.out.println("Producer:" + lineSize);
			if (lineSize < GameConstants.LENGTH_OF_FEPIPELINE) {
				int patternNum = ra.nextInt(10);
				int colorNum = GameConstants.PATTERN_COLOR[patternNum];
				int speedRank = getRank();
				line.FEOffer(patternNum, colorNum, speedRank);
			} else {

			}
		}
	}

	public int getRank() {
		for (int i = 0; i < GameConstants.NUMBER_OF_SPEED_RANK; i++) {
			if (line.getScore() < GameConstants.SCORE_RANK[i]) {
				return i;
			}
		}
		return -1;
	}

}
