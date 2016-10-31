package tetris.game.logic;

import java.awt.Color;
import java.awt.event.KeyEvent;

import tetris.common.GlobalConstants;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;

public class FallingEntry {
	int patternNum;
	Color color;
	int speedRank;
	int directNum;
	boolean inArray;
	Spot headSpot = null;
	Spot secSpot = null;
	Spot thirdSpot = null;
	Spot fourthSpot = null;

	public FallingEntry(int patternNum, Color color, int speedRank, Spot headSpot, int directNum) {
		this.patternNum = patternNum;
		this.color = color;
		this.speedRank = speedRank;
		this.directNum = directNum;
		this.headSpot = headSpot;
		SpotCal();
		this.inArray = false;
	}

	public FallingEntry(int patternNum, Color color, int speedRank, Spot headSpot, int directNum, boolean inArray) {
		this.patternNum = patternNum;
		this.color = color;
		this.speedRank = speedRank;
		this.directNum = directNum;
		this.headSpot = headSpot;
		SpotCal();
		this.inArray = inArray;
	}
	
	public FallingEntry(FallingEntry fEntry) {
		patternNum = fEntry.patternNum;
		color = fEntry.color;
		speedRank = fEntry.speedRank;
		directNum = fEntry.directNum;
		inArray = fEntry.inArray;
		headSpot = new Spot(fEntry.headSpot);
		secSpot = new Spot(fEntry.secSpot);
		thirdSpot = new Spot(fEntry.thirdSpot);
		fourthSpot = new Spot(fEntry.fourthSpot);
		
	}

	public void SpotCal() {
		switch (patternNum) {
		case 0:
			SpotCalhandlerZero();
			break;
		case 1:
			SpotCalhandlerOne();
			break;

		case 2:
			SpotCalhandlerTwo();
			break;
		case 3:
			SpotCalhandlerThree();
			break;
		case 4:
			SpotCalhandlerFour();
			break;
		case 5:
			SpotCalhandlerFive();
		case 6:
			SpotCalhandlerSix();
			break;

		default:
			break;
		}
	}

	public void SpotCalhandlerZero() {
		switch (directNum) {
		case 0:
			if (secSpot == null) {
				secSpot = new Spot(headSpot.x - 1, headSpot.y);
			} else {
				secSpot.x = headSpot.x - 1;
				secSpot.y = headSpot.y;
			}
			if (thirdSpot == null) {
				thirdSpot = new Spot(headSpot.x - 2, headSpot.y);
			} else {
				thirdSpot.x = headSpot.x - 2;
				thirdSpot.y = headSpot.y;
			}
			if (fourthSpot == null) {
				fourthSpot = new Spot(headSpot.x - 3, headSpot.y);
			} else {
				fourthSpot.x = headSpot.x - 3;
				fourthSpot.y = headSpot.y;
			}
			break;
		case 1:
			if (secSpot == null) {
				secSpot = new Spot(headSpot.x, headSpot.y + 1);
			} else {
				secSpot.x = headSpot.x;
				secSpot.y = headSpot.y + 1;
			}
			if (thirdSpot == null) {
				thirdSpot = new Spot(headSpot.x, headSpot.y + 2);
			} else {
				thirdSpot.x = headSpot.x;
				thirdSpot.y = headSpot.y + 2;
			}
			if (fourthSpot == null) {
				fourthSpot = new Spot(headSpot.x, headSpot.y + 3);
			} else {
				fourthSpot.x = headSpot.x;
				fourthSpot.y = headSpot.y + 3;
			}
			break;
		}
	}

	public void SpotCalhandlerOne() {
		switch (directNum) {
		case 0:
			if (secSpot == null) {
				secSpot = new Spot(headSpot.x, headSpot.y - 1);
			} else {
				secSpot.x = headSpot.x;
				secSpot.y = headSpot.y - 1;
			}
			if (thirdSpot == null) {
				thirdSpot = new Spot(headSpot.x, headSpot.y + 1);
			} else {
				thirdSpot.x = headSpot.x;
				thirdSpot.y = headSpot.y + 1;
			}
			if (fourthSpot == null) {
				fourthSpot = new Spot(headSpot.x - 1, headSpot.y);
			} else {
				fourthSpot.x = headSpot.x - 1;
				fourthSpot.y = headSpot.y;
			}
			break;
		case 1:
			if (secSpot == null) {
				secSpot = new Spot(headSpot.x - 1, headSpot.y);
			} else {
				secSpot.x = headSpot.x - 1;
				secSpot.y = headSpot.y;
			}
			if (thirdSpot == null) {
				thirdSpot = new Spot(headSpot.x + 1, headSpot.y);
			} else {
				thirdSpot.x = headSpot.x + 1;
				thirdSpot.y = headSpot.y;
			}
			if (fourthSpot == null) {
				fourthSpot = new Spot(headSpot.x, headSpot.y + 1);
			} else {
				fourthSpot.x = headSpot.x;
				fourthSpot.y = headSpot.y + 1;
			}
			break;
		case 2:
			if (secSpot == null) {
				secSpot = new Spot(headSpot.x, headSpot.y + 1);
			} else {
				secSpot.x = headSpot.x;
				secSpot.y = headSpot.y + 1;
			}
			if (thirdSpot == null) {
				thirdSpot = new Spot(headSpot.x, headSpot.y - 1);
			} else {
				thirdSpot.x = headSpot.x;
				thirdSpot.y = headSpot.y - 1;
			}
			if (fourthSpot == null) {
				fourthSpot = new Spot(headSpot.x + 1, headSpot.y);
			} else {
				fourthSpot.x = headSpot.x + 1;
				fourthSpot.y = headSpot.y;
			}
			break;
		case 3:
			if (secSpot == null) {
				secSpot = new Spot(headSpot.x + 1, headSpot.y);
			} else {
				secSpot.x = headSpot.x + 1;
				secSpot.y = headSpot.y;
			}
			if (thirdSpot == null) {
				thirdSpot = new Spot(headSpot.x - 1, headSpot.y);
			} else {
				thirdSpot.x = headSpot.x - 1;
				thirdSpot.y = headSpot.y;
			}
			if (fourthSpot == null) {
				fourthSpot = new Spot(headSpot.x, headSpot.y - 1);
			} else {
				fourthSpot.x = headSpot.x;
				fourthSpot.y = headSpot.y - 1;
			}
			break;
		}
	}

	public void SpotCalhandlerTwo() {
		switch (directNum) {
		case 0:
			if (secSpot == null) {
				secSpot = new Spot(headSpot.x, headSpot.y + 1);
			} else {
				secSpot.x = headSpot.x;
				secSpot.y = headSpot.y + 1;
			}
			if (thirdSpot == null) {
				thirdSpot = new Spot(headSpot.x - 1, headSpot.y);
			} else {
				thirdSpot.x = headSpot.x - 1;
				thirdSpot.y = headSpot.y;
			}
			if (fourthSpot == null) {
				fourthSpot = new Spot(headSpot.x - 1, headSpot.y - 1);
			} else {
				fourthSpot.x = headSpot.x - 1;
				fourthSpot.y = headSpot.y - 1;
			}
			break;
		case 1:
			if (secSpot == null) {
				secSpot = new Spot(headSpot.x + 1, headSpot.y);
			} else {
				secSpot.x = headSpot.x + 1;
				secSpot.y = headSpot.y;
			}
			if (thirdSpot == null) {
				thirdSpot = new Spot(headSpot.x, headSpot.y + 1);
			} else {
				thirdSpot.x = headSpot.x;
				thirdSpot.y = headSpot.y + 1;
			}
			if (fourthSpot == null) {
				fourthSpot = new Spot(headSpot.x - 1, headSpot.y + 1);
			} else {
				fourthSpot.x = headSpot.x - 1;
				fourthSpot.y = headSpot.y + 1;
			}
			break;
		}
	}

	public void SpotCalhandlerThree() {
		switch (directNum) {
		case 0:
			if (secSpot == null) {
				secSpot = new Spot(headSpot.x, headSpot.y - 1);
			} else {
				secSpot.x = headSpot.x;
				secSpot.y = headSpot.y - 1;
			}
			if (thirdSpot == null) {
				thirdSpot = new Spot(headSpot.x - 1, headSpot.y);
			} else {
				thirdSpot.x = headSpot.x - 1;
				thirdSpot.y = headSpot.y;
			}
			if (fourthSpot == null) {
				fourthSpot = new Spot(headSpot.x - 1, headSpot.y + 1);
			} else {
				fourthSpot.x = headSpot.x - 1;
				fourthSpot.y = headSpot.y + 1;
			}
			break;
		case 1:
			if (secSpot == null) {
				secSpot = new Spot(headSpot.x - 1, headSpot.y);
			} else {
				secSpot.x = headSpot.x - 1;
				secSpot.y = headSpot.y;
			}
			if (thirdSpot == null) {
				thirdSpot = new Spot(headSpot.x, headSpot.y + 1);
			} else {
				thirdSpot.x = headSpot.x;
				thirdSpot.y = headSpot.y + 1;
			}
			if (fourthSpot == null) {
				fourthSpot = new Spot(headSpot.x + 1, headSpot.y + 1);
			} else {
				fourthSpot.x = headSpot.x + 1;
				fourthSpot.y = headSpot.y + 1;
			}
			break;
		}
	}

	public void SpotCalhandlerFour() {
		if (secSpot == null) {
			secSpot = new Spot(headSpot.x, headSpot.y + 1);
		} else {
			secSpot.x = headSpot.x;
			secSpot.y = headSpot.y + 1;
		}
		if (thirdSpot == null) {
			thirdSpot = new Spot(headSpot.x + 1, headSpot.y + 1);
		} else {
			thirdSpot.x = headSpot.x + 1;
			thirdSpot.y = headSpot.y + 1;
		}
		if (fourthSpot == null) {
			fourthSpot = new Spot(headSpot.x + 1, headSpot.y);
		} else {
			fourthSpot.x = headSpot.x + 1;
			fourthSpot.y = headSpot.y;
		}
	}

	public void SpotCalhandlerFive() {
		switch (directNum) {
		case 0:
			if (secSpot == null) {
				secSpot = new Spot(headSpot.x - 1, headSpot.y);
			} else {
				secSpot.x = headSpot.x - 1;
				secSpot.y = headSpot.y;
			}
			if (thirdSpot == null) {
				thirdSpot = new Spot(headSpot.x + 1, headSpot.y);
			} else {
				thirdSpot.x = headSpot.x + 1;
				thirdSpot.y = headSpot.y;
			}
			if (fourthSpot == null) {
				fourthSpot = new Spot(headSpot.x + 1, headSpot.y + 1);
			} else {
				fourthSpot.x = headSpot.x + 1;
				fourthSpot.y = headSpot.y + 1;
			}
			break;
		case 1:
			if (secSpot == null) {
				secSpot = new Spot(headSpot.x, headSpot.y + 1);
			} else {
				secSpot.x = headSpot.x;
				secSpot.y = headSpot.y + 1;
			}
			if (thirdSpot == null) {
				thirdSpot = new Spot(headSpot.x, headSpot.y - 1);
			} else {
				thirdSpot.x = headSpot.x;
				thirdSpot.y = headSpot.y - 1;
			}
			if (fourthSpot == null) {
				fourthSpot = new Spot(headSpot.x + 1, headSpot.y - 1);
			} else {
				fourthSpot.x = headSpot.x + 1;
				fourthSpot.y = headSpot.y - 1;
			}
			break;
		case 2:
			if (secSpot == null) {
				secSpot = new Spot(headSpot.x + 1, headSpot.y);
			} else {
				secSpot.x = headSpot.x + 1;
				secSpot.y = headSpot.y;
			}
			if (thirdSpot == null) {
				thirdSpot = new Spot(headSpot.x - 1, headSpot.y);
			} else {
				thirdSpot.x = headSpot.x - 1;
				thirdSpot.y = headSpot.y;
			}
			if (fourthSpot == null) {
				fourthSpot = new Spot(headSpot.x - 1, headSpot.y - 1);
			} else {
				fourthSpot.x = headSpot.x - 1;
				fourthSpot.y = headSpot.y - 1;
			}
			break;
		case 3:
			if (secSpot == null) {
				secSpot = new Spot(headSpot.x, headSpot.y - 1);
			} else {
				secSpot.x = headSpot.x;
				secSpot.y = headSpot.y - 1;
			}
			if (thirdSpot == null) {
				thirdSpot = new Spot(headSpot.x, headSpot.y + 1);
			} else {
				thirdSpot.x = headSpot.x;
				thirdSpot.y = headSpot.y + 1;
			}
			if (fourthSpot == null) {
				fourthSpot = new Spot(headSpot.x - 1, headSpot.y + 1);
			} else {
				fourthSpot.x = headSpot.x - 1;
				fourthSpot.y = headSpot.y + 1;
			}
			break;
		}
	}

	public void SpotCalhandlerSix() {
		switch (directNum) {
		case 0:
			if (secSpot == null) {
				secSpot = new Spot(headSpot.x - 1, headSpot.y);
			} else {
				secSpot.x = headSpot.x - 1;
				secSpot.y = headSpot.y;
			}
			if (thirdSpot == null) {
				thirdSpot = new Spot(headSpot.x + 1, headSpot.y);
			} else {
				thirdSpot.x = headSpot.x + 1;
				thirdSpot.y = headSpot.y;
			}
			if (fourthSpot == null) {
				fourthSpot = new Spot(headSpot.x + 1, headSpot.y - 1);
			} else {
				fourthSpot.x = headSpot.x + 1;
				fourthSpot.y = headSpot.y - 1;
			}
			break;
		case 1:
			if (secSpot == null) {
				secSpot = new Spot(headSpot.x, headSpot.y + 1);
			} else {
				secSpot.x = headSpot.x;
				secSpot.y = headSpot.y + 1;
			}
			if (thirdSpot == null) {
				thirdSpot = new Spot(headSpot.x, headSpot.y - 1);
			} else {
				thirdSpot.x = headSpot.x;
				thirdSpot.y = headSpot.y - 1;
			}
			if (fourthSpot == null) {
				fourthSpot = new Spot(headSpot.x - 1, headSpot.y - 1);
			} else {
				fourthSpot.x = headSpot.x - 1;
				fourthSpot.y = headSpot.y - 1;
			}
			break;
		case 2:
			if (secSpot == null) {
				secSpot = new Spot(headSpot.x + 1, headSpot.y);
			} else {
				secSpot.x = headSpot.x + 1;
				secSpot.y = headSpot.y;
			}
			if (thirdSpot == null) {
				thirdSpot = new Spot(headSpot.x - 1, headSpot.y);
			} else {
				thirdSpot.x = headSpot.x - 1;
				thirdSpot.y = headSpot.y;
			}
			if (fourthSpot == null) {
				fourthSpot = new Spot(headSpot.x - 1, headSpot.y + 1);
			} else {
				fourthSpot.x = headSpot.x - 1;
				fourthSpot.y = headSpot.y + 1;
			}
			break;
		case 3:
			if (secSpot == null) {
				secSpot = new Spot(headSpot.x, headSpot.y - 1);
			} else {
				secSpot.x = headSpot.x;
				secSpot.y = headSpot.y - 1;
			}
			if (thirdSpot == null) {
				thirdSpot = new Spot(headSpot.x, headSpot.y + 1);
			} else {
				thirdSpot.x = headSpot.x;
				thirdSpot.y = headSpot.y + 1;
			}
			if (fourthSpot == null) {
				fourthSpot = new Spot(headSpot.x + 1, headSpot.y + 1);
			} else {
				fourthSpot.x = headSpot.x + 1;
				fourthSpot.y = headSpot.y + 1;
			}
			break;
		}
	}

	public FallingEntry() {
		patternNum = 0;
		speedRank = 0;
	}

	public void checkInArray() {
		headSpot.checkSpotInArray();
		secSpot.checkSpotInArray();
		thirdSpot.checkSpotInArray();
		fourthSpot.checkSpotInArray();
		if (!headSpot.IsInArray()) {
			inArray = false;
			return;
		} else if (!secSpot.IsInArray()) {
			inArray = false;
			return;
		} else if (!thirdSpot.IsInArray()) {
			inArray = false;
			return;
		} else if (!fourthSpot.IsInArray()) {
			inArray = false;
			return;
		} else {
			inArray = true;
			return;
		}
	}

	public boolean IsInArray() {
		return inArray;
	}
	
	public void moveDown() {
		headSpot.x ++;
		secSpot.x ++;
		thirdSpot.x ++;
		fourthSpot.x ++;		
	}

	public void printFallingEntry() {
		System.out.println(patternNum + " " + color + " " + speedRank);
	}
	
	public int lowestRow() {
		int lowestx = -10;
		if(headSpot.x>lowestx) {
			lowestx = headSpot.x;
		}
		if(secSpot.x>lowestx) {
			lowestx = secSpot.x;
		}
		if(thirdSpot.x>lowestx) {
			lowestx = thirdSpot.x;
		}
		if(fourthSpot.x>lowestx) {
			lowestx = fourthSpot.x;
		}
		return lowestx;
	}
	
}
