package tetris.game.logic;

import java.awt.Color;
import java.util.Random;

import tetris.common.GlobalConstants;

public class MovingDown implements Runnable {

	GameEntry gEntry;
	FallingEntryPipeline FEPLine = null;
	FallingEntry currentFEntry = null;

	public MovingDown(GameEntry gEntry) {
		// TODO Auto-generated constructor stub
		this.gEntry = gEntry;
		FEPLine = new FallingEntryPipeline(this.gEntry);
		for (int i = 0; i < GameConstants.LENGTH_OF_FEPIPELINE; i++) {
			FallingEntryProduce();
		}
		new Thread(this).start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			boolean nullflag = true;
			FallingEntry fEntry = null;
			int lineSize = FEPLine.getFEPipelineSize();
			if (lineSize != 0) {
				fEntry = FEPLine.FEPoll();
				lineSize--;
				nullflag = false;
			}

			if (nullflag) {
				FallingEntryProduce();
				fEntry = FEPLine.FEPoll();
			} else {
				FallingEntryProduce();
			}
			currentFEntry = fEntry;
			FallingEntry fEntryTemp = new FallingEntry(fEntry);

			int index = GameConstants.NEXT_HEADSPOTS_INDEX.get(fEntryTemp.patternNum * 10 + fEntryTemp.directNum)
					.intValue();
			fEntryTemp.headSpot = GameConstants.NEXT_HEADSPOTS[index];
			fEntryTemp.SpotCal();

			paintBeforeNextEntry();
			paintFallingEntry(fEntryTemp, fEntryTemp.color, 0);

			while (true) {
				FallingEntry falltemp = new FallingEntry(fEntry);
				if (falltemp.moveDown()) {
					boolean conflictFlag = false;
					conflictFlag = IsEntryConflict(falltemp);
					boolean downArrayFlag = falltemp.checkDownArray();
					if (!conflictFlag && !downArrayFlag) {
						paintFEntryInArray(fEntry, true);
						paintFEntryInArray(falltemp, false);
						paintFallingEntry(fEntry, Color.white, 1);
						paintFallingEntry(falltemp, falltemp.color, 1);
						fEntry.moveDown();
						try {
							Thread.sleep(GameConstants.SPEED_RANK[fEntry.speedRank]);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if (fEntry.checkUpArray()) {
						GameOver();
						return;
					} else {
						checkFullRow(fEntry);
						paintFallingEntry(fEntryTemp, Color.white, 0);
						break;
					}
				} else {
					System.out.println("moveDown Error");
					return;
				}

			}
		}

	}

	private void paintBeforeNextEntry() {
		// TODO Auto-generated method stub
		for(int i=0;i<4;i++) {
			for (int j=0;j<5;j++) {
				gEntry.GameActivity.setNextBlockColor(i, j, Color.white);
			}
		}
	}

	public void GameOver() {
        gEntry.GameActivity.showGameOverDialog();     
	}

	public void checkFullRow(FallingEntry fEntry) {
		int fullcount = 0;
		int[] rowIndex = { fEntry.headSpot.x, fEntry.secSpot.x, fEntry.thirdSpot.x, fEntry.fourthSpot.x };
		boolean[] rowTag = { false, false, false, false };
		if (checkFullRowhandler(fEntry.headSpot)) {
			fullcount++;
			rowTag[0] = true;
		}
		if (checkFullRowhandler(fEntry.secSpot)) {
			fullcount++;
			rowTag[1] = true;
		}
		if (checkFullRowhandler(fEntry.thirdSpot)) {
			fullcount++;
			rowTag[2] = true;
		}
		if (checkFullRowhandler(fEntry.fourthSpot)) {
			fullcount++;
			rowTag[3] = true;
		}

		if (fullcount != 0) {
			gEntry.upScore(fullcount * 10);
			repaintArray(rowIndex, rowTag);
			repaintActivity(fEntry.lowestRow());
		}

	}

	public void repaintArray(int[] rowIndex, boolean[] rowTag) {
		for (int i = 0; i < GameConstants.NUMBER_OF_SPOT - 1; i++) {
			int temp = i;
			for (int j = i + 1; j < GameConstants.NUMBER_OF_SPOT; j++) {
				if (rowIndex[j] > rowIndex[temp]) {
					temp = j;
				}
			}
			if (temp != i) {
				int indexTemp = rowIndex[i];
				rowIndex[i] = rowIndex[temp];
				rowIndex[temp] = indexTemp;
				boolean tagTemp = rowTag[i];
				rowTag[i] = rowTag[temp];
				rowTag[temp] = tagTemp;
			}
		}
		int count = 0;
		for (int i = 0; i < GameConstants.NUMBER_OF_SPOT; i++) {
			if (i == 0 || (i != 0 && rowIndex[i] != rowIndex[i - 1])) {
				if (rowTag[i]) {
					count++;
				}
			}
		}

		int rowNum = rowIndex[GameConstants.NUMBER_OF_SPOT - 1] - rowIndex[0] + 1;
		int rowWrite = rowNum - count;
		int bas = rowIndex[0];
		for (int i = 0; i < rowWrite; i++) {
			int j = 0;
			for (; j < GameConstants.NUMBER_OF_SPOT; j++) {
				if (j == 0 || (j != 0 && rowIndex[j] != rowIndex[j - 1])) {
					if (!rowTag[j]) {
						for (int k = 0; k < GlobalConstants.NUMBER_OF_COLUMNS; k++) {
							gEntry.GameArray[bas + i][k] = gEntry.GameArray[rowIndex[j]][k];
						}
					}
				}
			}
		}

		for (int i = rowIndex[GameConstants.NUMBER_OF_SPOT - 1]; i >= 0; i--) {
			for (int j = 0; j < GlobalConstants.NUMBER_OF_COLUMNS; j++) {
				gEntry.GameArray[i + count][j] = gEntry.GameArray[i][j];
			}
		}

	}

	public void repaintActivity(int lowestx) {
		for (int i = lowestx; i >= 0; i--) {
			for (int j = 0; j < GlobalConstants.NUMBER_OF_COLUMNS; j++) {
				Color color = GameConstants.COLOR_SET[gEntry.GameArray[i][j]];
				gEntry.GameActivity.setBlockColorByCoordinates(i, j, color);
			}
		}
	}

	public boolean checkFullRowhandler(Spot s) {
		int x = s.x;
		boolean fullFlag = true;
		for (int y = 0; y < GlobalConstants.NUMBER_OF_COLUMNS; y++) {
			if (gEntry.GameArray[x][y] == 0) {
				fullFlag = false;
				break;
			}
		}
		if (fullFlag) {
			for (int y = 0; y < GlobalConstants.NUMBER_OF_COLUMNS; y++) {
				gEntry.GameArray[x][y] = 0;
				gEntry.GameActivity.setBlockColorByCoordinates(x, y, Color.white);
			}
			return true;
		} else {
			return false;
		}
	}

	public void paintFEntryInArray(FallingEntry fEntry, boolean nullFlag) {
		// nullFlag为true时，表示置为白色，false表示写上颜色
		if (!nullFlag) {
			int colorNum = GameConstants.COLOR_INDEX.get(fEntry.color).intValue();
			if (fEntry.headSpot.IsInArray()) {
				gEntry.GameArray[fEntry.headSpot.x][fEntry.headSpot.y] = colorNum;
			}
			if (fEntry.secSpot.IsInArray()) {
				gEntry.GameArray[fEntry.secSpot.x][fEntry.secSpot.y] = colorNum;
			}
			if (fEntry.thirdSpot.IsInArray()) {
				gEntry.GameArray[fEntry.thirdSpot.x][fEntry.thirdSpot.y] = colorNum;
			}
			if (fEntry.fourthSpot.IsInArray()) {
				gEntry.GameArray[fEntry.fourthSpot.x][fEntry.fourthSpot.y] = colorNum;
			}

		} else {
			if (fEntry.headSpot.IsInArray()) {
				gEntry.GameArray[fEntry.headSpot.x][fEntry.headSpot.y] = 0;
			}
			if (fEntry.secSpot.IsInArray()) {
				gEntry.GameArray[fEntry.secSpot.x][fEntry.secSpot.y] = 0;
			}
			if (fEntry.thirdSpot.IsInArray()) {
				gEntry.GameArray[fEntry.thirdSpot.x][fEntry.thirdSpot.y] = 0;
			}
			if (fEntry.fourthSpot.IsInArray()) {
				gEntry.GameArray[fEntry.fourthSpot.x][fEntry.fourthSpot.y] = 0;
			}
		}
	}

	public void paintFallingEntry(FallingEntry fEntry, Color color, int flag) {
		// flag为0表示写右上方矩阵，flag为1表示写游戏矩阵
		if (flag == 0) {
			gEntry.GameActivity.setNextBlockColor(fEntry.headSpot.x, fEntry.headSpot.y, color);
			gEntry.GameActivity.setNextBlockColor(fEntry.secSpot.x, fEntry.secSpot.y, color);
			gEntry.GameActivity.setNextBlockColor(fEntry.thirdSpot.x, fEntry.thirdSpot.y, color);
			gEntry.GameActivity.setNextBlockColor(fEntry.fourthSpot.x, fEntry.fourthSpot.y, color);
		}
		if (flag == 1) {
			if (fEntry.IsInArray()) {
				gEntry.GameActivity.setBlockColorByCoordinates(fEntry.headSpot.x, fEntry.headSpot.y, color);
			}
			if (fEntry.IsInArray()) {
				gEntry.GameActivity.setBlockColorByCoordinates(fEntry.secSpot.x, fEntry.secSpot.y, color);
			}
			if (fEntry.IsInArray()) {
				gEntry.GameActivity.setBlockColorByCoordinates(fEntry.thirdSpot.x, fEntry.thirdSpot.y, color);
			}
			if (fEntry.IsInArray()) {
				gEntry.GameActivity.setBlockColorByCoordinates(fEntry.fourthSpot.x, fEntry.fourthSpot.y, color);
			}

		}
	}

	public boolean IsEntryConflict(FallingEntry falltemp) {
		if (falltemp.headSpot.IsInArray() && gEntry.GameArray[falltemp.headSpot.x][falltemp.headSpot.y] != 0) {
			return true;
		} else if (falltemp.secSpot.IsInArray() && gEntry.GameArray[falltemp.secSpot.x][falltemp.secSpot.y] != 0) {
			return true;
		} else if (falltemp.thirdSpot.IsInArray()
				&& gEntry.GameArray[falltemp.thirdSpot.x][falltemp.thirdSpot.y] != 0) {
			return true;
		} else if (falltemp.fourthSpot.IsInArray()
				&& gEntry.GameArray[falltemp.fourthSpot.x][falltemp.fourthSpot.y] != 0) {
			return true;
		} else {
			return false;
		}
	}

	public void FallingEntryProduce() {
		int lineSize = FEPLine.getFEPipelineSize();
		Random ra1 = new Random(37);
		Random ra2 = new Random(37);
		Random ra3 = new Random(37);
		if (lineSize < GameConstants.LENGTH_OF_FEPIPELINE) {
			int patternNum = ra1.nextInt(GameConstants.NUMBER_OF_PATTERN);
			int colorNum = ra2.nextInt(GameConstants.NUMBER_OF_COLOR);
			Color color = GameConstants.COLOR_SET[colorNum];
			int direct = GameConstants.PATTERN_DIRECT[patternNum];
			int directNum = ra3.nextInt(direct);
			int speedRank = getRank();
			Spot spotTemp = getInitialSpot(patternNum, directNum);
			// System.out.println(patternNum + " " + colorNum + " " +
			// speedRank);
			FEPLine.FEOffer(patternNum, color, speedRank, spotTemp, directNum);
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
