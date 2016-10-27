package tetris.game.logic;

import java.util.Random;

public class MovingDown implements Runnable {

	GameEntry gEntry;

	public MovingDown(GameEntry gEntry) {
		// TODO Auto-generated constructor stub
		this.gEntry = gEntry;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean nullflag = true;
		FallingEntry fEntry = null;
		int lineSize = gEntry.FEPLine.getFEPipelineSize();
		if (lineSize != 0) {
			fEntry = gEntry.FEPLine.FEPoll();
			lineSize--;
			nullflag = false;
		}

		if (nullflag) {
			FallingEntryProduce();
			fEntry = gEntry.FEPLine.FEPoll();
		} else {
			FallingEntryProduce();
		}
		
		while (true) {
			Spot hSpot = new Spot(fEntry.headSpot.x+1,fEntry.headSpot.y);
			Spot sSpot = new Spot(fEntry.secSpot.x+1,fEntry.secSpot.y); 
			Spot tSpot = new Spot(fEntry.thirdSpot.x+1,fEntry.thirdSpot.y); 
			Spot fSpot = new Spot(fEntry.fourthSpot.x+1,fEntry.fourthSpot.y);
			boolean conflictFlag = false;
			
			
		}

	}
	
	public boolean checkInArray(Spot sp) {
		return (sp.x>=0 && sp.y>=0);
	}
	
	public boolean checkEntryConflict(Spot hSpot,Spot sSpot,Spot tSpot, Spot fSpot) {
		if (checheckInArray(hSpot)&&gEntry.GameArray[hSpot.x][hSpot.y] != 0) {
			return false;
		} else if (checkInArray(sSpot)&&gEntry.GameArray[sSpot.x][sSpot.y] != 0){
			return false;
		} else if (checkInArray(tSpot)&&gEntry.GameArray[tSpot.x][tSpot.y] != 0) {
			return false;
		} else if (checkInArray(fSpot)&&gEntry.GameArray[fSpot.x][fSpot.y] != 0) {
			return false;
		} else {
			return true;
		}
	}

	public void FallingEntryProduce() {
		int lineSize = gEntry.FEPLine.getFEPipelineSize();
		Random ra1 = new Random(37);
		Random ra2 = new Random(37);
		Random ra3 = new Random(37);
		if (lineSize < GameConstants.LENGTH_OF_FEPIPELINE) {
			int patternNum = ra1.nextInt(GameConstants.NUMBER_OF_PATTERN);
			int colorNum = ra2.nextInt(GameConstants.NUMBER_OF_COLOR);
			int direct = GameConstants.PATTERN_DIRECT[patternNum];
			int directNum = ra3.nextInt(direct);
			int speedRank = getRank();
			Spot spotTemp = getInitialSpot(patternNum, directNum);
			// System.out.println(patternNum + " " + colorNum + " " +
			// speedRank);
			gEntry.FEPLine.FEOffer(patternNum, colorNum, speedRank, spotTemp, directNum);
		} else {
			System.out.println("Produce Fail");
		}
	}

	public int getRank() {
		for (int i = 0; i < GameConstants.NUMBER_OF_SPEED_RANK; i++) {
			if (gEntry.getScore() < GameConstants.SCORE_RANK[i]) {
				return i;
			}
		}
		return -1;
	}

	public Spot getInitialSpot(int patternNum, int directNum) {
		Spot temp = null;
		switch (patternNum) {
		case 0:
			temp = patternZeroInitial(directNum);
			break;
		case 1:
			temp = patternOneInitial(directNum);
			break;

		case 2:
			temp = patternTwoInitial(directNum);
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
			temp = patternSixInitial(directNum);
			break;

		default:
			temp = new Spot(-1, -1);
			break;
		}
		return temp;
	}

	public Spot patternZeroInitial(int directNum) {
		Spot temp = null;
		switch (directNum) {
		case 0:
			temp = new Spot(-1, 5);
			break;
		case 1:
			temp = new Spot(-1, 4);
			break;
		default:
			temp = new Spot(-2, -2);
			break;
		}
		return temp;
	}

	public Spot patternOneInitial(int directNum) {
		Spot temp = null;
		switch (directNum) {
		case 0:
			temp = new Spot(-1, 5);
		case 1:
			temp = new Spot(-2, 5);
		case 2:
			temp = new Spot(-2, 5);
		case 3:
			temp = new Spot(-2, 6);
		default:
			temp = new Spot(-2, -2);
			break;
		}
		return temp;
	}

	public Spot patternTwoInitial(int directNum) {
		Spot temp = null;
		switch (directNum) {
		case 0:
			temp = new Spot(-1, 5);
			break;
		case 1:
			temp = new Spot(-2, 5);
			break;
		default:
			temp = new Spot(-2, -2);
			break;
		}
		return temp;
	}

	public Spot patternThreeInitial(int directNum) {
		Spot temp = null;
		switch (directNum) {
		case 0:
			temp = new Spot(-1, 5);
			break;
		case 1:
			temp = new Spot(-2, 5);
			break;
		default:
			temp = new Spot(-2, -2);
			break;
		}
		return temp;
	}

	public Spot patternFourInitial(int directNum) {

		return new Spot(-2, 5);
	}

	public Spot patternFiveInitial(int directNum) {
		Spot temp = null;
		switch (directNum) {
		case 0:
			temp = new Spot(-2, 5);
		case 1:
			temp = new Spot(-2, 5);
		case 2:
			temp = new Spot(-2, 6);
		case 3:
			temp = new Spot(-1, 5);
		default:
			temp = new Spot(-2, -2);
			break;
		}
		return temp;
	}

	public Spot patternSixInitial(int directNum) {
		Spot temp = null;
		switch (directNum) {
		case 0:
			temp = new Spot(-2, 6);
		case 1:
			temp = new Spot(-2, 5);
		case 2:
			temp = new Spot(-2, 5);
		case 3:
			temp = new Spot(-2, 5);
		default:
			temp = new Spot(-2, -2);
			break;
		}
		return temp;
	}

}
