package tetris.game.logic;

import java.awt.Color;
import java.util.Random;

public class FEPipelineProducer implements Runnable {

	FallingEntityPipeline line = null;

	public FEPipelineProducer() {
		// TODO Auto-generated constructor stub
		line = new FallingEntityPipeline();
	}

	public FEPipelineProducer(FallingEntityPipeline FEPipeline) {
		this.line = FEPipeline;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random ra1 = new Random(37);
		Random ra2 = new Random(37);
		Random ra3 = new Random(37);
		while (true) {
			int lineSize = line.getFEPipelineSize();
			// System.out.println("Producer:" + lineSize);
			if (lineSize < GameConstants.LENGTH_OF_FEPIPELINE) {
				int patternNum = ra1.nextInt(GameConstants.NUMBER_OF_PATTERN);
				int colorNum = ra2.nextInt(GameConstants.NUMBER_OF_COLOR);
				Color color = GameConstants.COLOR_SET[colorNum];
				int direct = GameConstants.PATTERN_DIRECT[patternNum];
				int directNum = ra3.nextInt(direct);
				int speedRank = getRank();
				Spot spotTemp = getInitialSpot(patternNum, directNum);
				System.out.println(patternNum + " " + colorNum + " " + speedRank);
				line.FEOffer(patternNum, color, speedRank,spotTemp,directNum);
			} else {

			}
		}
	}
	
	public Spot getInitialSpot(int patternNum, int directNum){
		Spot temp = null;
		switch (patternNum) {
		case 0:
			temp = patternZeroInitial(directNum);
			break;
		case 1:
			temp = patternOneInitial(directNum);
			break;

		case 2:
			temp = patternTwoInitial( directNum);
			break;
		case 3:
			temp = patternThreeInitial(directNum);
			break;
		case 4:
			temp = patternFourInitial(directNum);
			break;
		case 5:
			temp = patternFiveInitial(directNum);

		case 6:
			temp = patternSixInitial( directNum);
			break;
		
		default:
			temp = new Spot(-1,-1);
			break;
		}
		return temp;
	}
	
	public Spot patternZeroInitial(int directNum) {
		Spot temp = null;
		switch (directNum) {
		case 0:
			temp = new Spot(-1,5);
			break;
		case 1:
			temp = new Spot(-1,4);
			break;
		default:
			temp = new Spot(-2,-2);
			break;
		}
		return temp;
	}
	
	public Spot patternOneInitial(int directNum) {
		Spot temp = null;
		switch (directNum) {
		case 0:
			temp = new Spot(-1,5);
		case 1:
			temp = new Spot(-2,5);
		case 2:
			temp = new Spot(-2,5);
		case 3:
			temp = new Spot(-2,6);
		default:
			temp = new Spot(-2,-2);
			break;
		}
		return temp;
	}
	
	public Spot patternTwoInitial(int directNum) {
		Spot temp = null;
		switch (directNum) {
		case 0:
			temp = new Spot(-1,5);
			break;
		case 1:
			temp = new Spot(-2,5);
			break;
		default:
			temp = new Spot(-2,-2);
			break;
		}
		return temp;
	}

	public Spot patternThreeInitial(int directNum) {
		Spot temp = null;
		switch (directNum) {
		case 0:
			temp = new Spot(-1,5);
			break;
		case 1:
			temp = new Spot(-2,5);
			break;
		default:
			temp = new Spot(-2,-2);
			break;
		}
		return temp;
	}
	
	public Spot patternFourInitial(int directNum) {		
		
		return new Spot(-2,5);
	}
	
	public Spot patternFiveInitial(int directNum) {
		Spot temp = null;
		switch (directNum) {
		case 0:
			temp = new Spot(-2,5);
		case 1:
			temp = new Spot(-2,5);
		case 2:
			temp = new Spot(-2,6);
		case 3:
			temp = new Spot(-1,5);
		default:
			temp = new Spot(-2,-2);
			break;
		}
		return temp;
	}
	
	public Spot patternSixInitial(int directNum) {
		Spot temp = null;
		switch (directNum) {
		case 0:
			temp = new Spot(-2,6);
		case 1:
			temp = new Spot(-2,5);
		case 2:
			temp = new Spot(-2,5);
		case 3:
			temp = new Spot(-2,5);
		default:
			temp = new Spot(-2,-2);
			break;
		}
		return temp;
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
