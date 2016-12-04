package tetris.game.logic;

import java.awt.Color;
import java.awt.event.KeyEvent;

import tetris.common.GlobalConstants;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;

public class FallingEntity {
	int patternNum;
	Color color;
	int speedRank;
	int directNum;
	boolean inArray;
	Spot headSpot = null;
	Spot secSpot = null;
	Spot thirdSpot = null;
	Spot fourthSpot = null;

	public FallingEntity(int patternNum, Color color, int speedRank, Spot headSpot, int directNum) {
		this.patternNum = patternNum;
		this.color = color;
		this.speedRank = speedRank;
		this.directNum = directNum;
		this.headSpot = headSpot;
		SpotCal();
		this.inArray = false;
	}

	public FallingEntity(int patternNum, Color color, int speedRank, Spot headSpot, int directNum, boolean inArray) {
		this.patternNum = patternNum;
		this.color = color;
		this.speedRank = speedRank;
		this.directNum = directNum;
		this.headSpot = headSpot;
		SpotCal();
		this.inArray = inArray;
	}

	public FallingEntity(FallingEntity fEntity) {
		patternNum = fEntity.patternNum;
		color = fEntity.color;
		speedRank = fEntity.speedRank;
		directNum = fEntity.directNum;
		inArray = fEntity.inArray;
		headSpot = new Spot(fEntity.headSpot);
		secSpot = new Spot(fEntity.secSpot);
		thirdSpot = new Spot(fEntity.thirdSpot);
		fourthSpot = new Spot(fEntity.fourthSpot);

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
			break;
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

	public FallingEntity() {
		patternNum = 0;
		speedRank = 0;
	}

	public void checkInArray() {
		// if (inArray) {
		// return;
		// }
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

	public boolean checkUpArray() {
		headSpot.checkSpotUpArray();
		secSpot.checkSpotUpArray();
		thirdSpot.checkSpotUpArray();
		fourthSpot.checkSpotUpArray();
		if (headSpot.IsUpArray()) {
			return true;
		} else if (secSpot.IsUpArray()) {
			return true;
		} else if (thirdSpot.IsUpArray()) {
			return true;
		} else if (fourthSpot.IsUpArray()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkDownArray() {
		headSpot.checkSpotdownArray();
		secSpot.checkSpotdownArray();
		thirdSpot.checkSpotdownArray();
		fourthSpot.checkSpotdownArray();
		if (headSpot.IsDownArray()) {
			return true;
		} else if (secSpot.IsDownArray()) {
			return true;
		} else if (thirdSpot.IsDownArray()) {
			return true;
		} else if (fourthSpot.IsDownArray()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean IsInArray() {
		return inArray;
	}

	public boolean moveDown() {
//		int htemp = headSpot.x + 1;
//		if (htemp >= GlobalConstants.NUMBER_OF_ROWS) {
//			return false;
//		}
//		int stemp = secSpot.x + 1;
//		if (stemp >= GlobalConstants.NUMBER_OF_ROWS) {
//			return false;
//		}
//		int ttemp = thirdSpot.x + 1;
//		if (ttemp >= GlobalConstants.NUMBER_OF_ROWS) {
//			return false;
//		}
//		int ftemp = fourthSpot.x + 1;
//		if (ftemp >= GlobalConstants.NUMBER_OF_ROWS) {
//			return false;
//		}

		headSpot.x++;
		secSpot.x++;
		thirdSpot.x++;
		fourthSpot.x++;
		checkInArray();
		return true;
	}

	public boolean moveRightOrLeft(int RLFlag) {
		// RLFlag为0时表示向左移动，为1是表示向右移动
		if (RLFlag == 0) {
			int htemp = headSpot.y - 1;
			if (htemp < 0) {
				return false;
			}
			int stemp = secSpot.y - 1;
			if (stemp < 0) {
				return false;
			}
			int ttemp = thirdSpot.y - 1;
			if (ttemp < 0) {
				return false;
			}
			int ftemp = fourthSpot.y - 1;
			if (ftemp < 0) {
				return false;
			}
		} else if (RLFlag == 1) {
			int htemp = headSpot.y + 1;
			if (htemp >= GlobalConstants.NUMBER_OF_COLUMNS) {
				return false;
			}
			int stemp = secSpot.y + 1;
			if (stemp >= GlobalConstants.NUMBER_OF_COLUMNS) {
				return false;
			}
			int ttemp = thirdSpot.y + 1;
			if (ttemp >= GlobalConstants.NUMBER_OF_COLUMNS) {
				return false;
			}
			int ftemp = fourthSpot.y + 1;
			if (ftemp >= GlobalConstants.NUMBER_OF_COLUMNS) {
				return false;
			}
		} else {
			return false;
		}
		// RLFlag为0时表示向左移动，为1时表示向右移动
		if (RLFlag == 0) {
			headSpot.y--;
			secSpot.y--;
			thirdSpot.y--;
			fourthSpot.y--;
		} else if (RLFlag == 1) {
			headSpot.y++;
			secSpot.y++;
			thirdSpot.y++;
			fourthSpot.y++;
		}
		checkInArray();
		return true;
	}

	public boolean rotate() {
		int modtemp = GameConstants.PATTERN_DIRECT[patternNum];
		directNum = (directNum + 1) % modtemp;
		int index = GameConstants.NEXT_HEADSPOTS_INDEX.get(patternNum * 10 + directNum).intValue();
		Spot translate = GameConstants.HEADSPOT_ROTATE[index];
		headSpot.x = headSpot.x + translate.x;
		headSpot.y = headSpot.y + translate.y;
		SpotCal();
		if (!checkInRange(headSpot)) {
			return false;
		} else if (!checkInRange(secSpot)) {
			return false;
		} else if (!checkInRange(thirdSpot)) {
			return false;
		} else if (!checkInRange(fourthSpot)) {
			return false;
		} else {
			checkInArray();
			return true;
		}
	}

	public boolean checkInRange(Spot s) {
		if (s.x < GlobalConstants.NUMBER_OF_ROWS && s.y >= 0 && s.y < GlobalConstants.NUMBER_OF_COLUMNS) {
			return true;
		} else {
			return false;
		}
	}

	public void printFallingEntity() {
		System.out.println(patternNum + " " + color + " " + speedRank);
	}

	public int lowestRow() {
		int lowestx = -10;
		if (headSpot.x > lowestx) {
			lowestx = headSpot.x;
		}
		if (secSpot.x > lowestx) {
			lowestx = secSpot.x;
		}
		if (thirdSpot.x > lowestx) {
			lowestx = thirdSpot.x;
		}
		if (fourthSpot.x > lowestx) {
			lowestx = fourthSpot.x;
		}
		return lowestx;
	}

	public int getMaxX(){
		int maxX = headSpot.x;
		if(maxX < secSpot.x) {
			maxX = secSpot.x;
		}
		if(maxX < thirdSpot.x) {
			maxX = thirdSpot.x;
		}
		if(maxX < fourthSpot.x) {
			maxX = fourthSpot.x;
		}
		return maxX;
	}
	
	public int getMinX(){
		int minx = headSpot.x;
		if(minx > secSpot.x) {
			minx = secSpot.x;
		}
		if(minx > thirdSpot.x) {
			minx = thirdSpot.x;
		}
		if(minx > fourthSpot.x) {
			minx = fourthSpot.x;
		}
		return minx;
	}
}
