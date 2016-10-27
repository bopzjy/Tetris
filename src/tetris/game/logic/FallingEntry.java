package tetris.game.logic;

import java.awt.event.KeyEvent;

import tetris.ui.ActivityHolder;
import tetris.ui.Constants;

public class FallingEntry {
	int patternNum;
	int colorNum;
	int speedRank;
	int directNum;
	Spot headSpot = null;
	Spot secSpot = null;
	Spot thirdSpot = null;
	Spot fourthSpot = null;

	public FallingEntry(int patternNum, int colorNum, int speedRank, Spot headSpot, int directNum) {
		this.patternNum = patternNum;
		this.colorNum = colorNum;
		this.speedRank = speedRank;
		this.directNum = directNum;
		this.headSpot = headSpot;
		SpotCal();
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
		colorNum = 0;
		speedRank = 0;
	}

	public void printFallingEntry() {
		System.out.println(patternNum + " " + colorNum + " " + speedRank);
	}
}
