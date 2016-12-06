package tetris.game.logic;

import java.awt.Color;
import java.util.Random;

import tetris.common.GlobalConstants;

public class MovingDown implements Runnable {
	GameEntity gEntity;
	FallingEntityPipeline FEPLine = null;
	FallingEntity currentFEntity = null;
	Random ra1 = new Random();
//	Random ra2 = new Random(37);
//	Random ra3 = new Random(37);

	public MovingDown(GameEntity gEntity) {
		// TODO Auto-generated constructor stub
		this.gEntity = gEntity;
		FEPLine = new FallingEntityPipeline(this.gEntity);
		for (int i = 0; i < GameConstants.LENGTH_OF_FEPIPELINE; i++) {
			FallingEntityProduce();
		}
		
	}
	
	public void start() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			boolean nullflag = true;
			FallingEntity fEntity = null;
			int lineSize = FEPLine.getFEPipelineSize();
			if (lineSize != 0) {
				fEntity = FEPLine.FEPoll();
				lineSize--;
				nullflag = false;
			}

			if (nullflag) {
				FallingEntityProduce();
				fEntity = FEPLine.FEPoll();
			} else {
				FallingEntityProduce();
			}
			currentFEntity = fEntity;
			FallingEntity fEntityTemp = new FallingEntity(fEntity);

			int index = GameConstants.NEXT_HEADSPOTS_INDEX.get(fEntityTemp.patternNum * 10 + fEntityTemp.directNum)
					.intValue();
			fEntityTemp.headSpot = GameConstants.NEXT_HEADSPOTS[index];
			fEntityTemp.SpotCal();

			paintBeforeNextEntity();
			paintFallingEntity(fEntityTemp, fEntityTemp.color, 0);
			
			fEntity.speedRank = getRank();
			while (true) {
				FallingEntity falltemp = new FallingEntity(fEntity);
				if (falltemp.moveDown()) {
					boolean conflictFlag = false;
					conflictFlag = IsEntityConflict(fEntity,falltemp);
					boolean downArrayFlag = falltemp.checkDownArray();
					if (!conflictFlag && !downArrayFlag) {
						paintFEntityInArray(fEntity, true);
						paintFEntityInArray(falltemp, false);
						paintFallingEntity(fEntity, Color.white, 1);
						paintFallingEntity(falltemp, falltemp.color, 1);
						fEntity.moveDown();
						try {
							Thread.sleep(GameConstants.SPEED_RANK[fEntity.speedRank]);
							//Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if (fEntity.checkUpArray()) {
						GameOver();
						return;
					} else {
						checkFullRow(fEntity);
						//paintFallingEntity(fEntityTemp, Color.white, 0);
						break;
					}
				} else {
					System.out.println("moveDown Error");
					return;
				}
			}
		}

	}

	private void paintBeforeNextEntity() {
		// TODO Auto-generated method stub
		for(int i=0;i<4;i++) {
			for (int j=0;j<5;j++) {
				gEntity.GameActivity.setNextBlockColor(i, j, null);
			}
		}
	}

	public void GameOver() {
		gEntity.GameActivity.showNameDialog();    
	}

	public void checkFullRow(FallingEntity fEntity) {
		int maxx = fEntity.getMaxX();
		int minx = fEntity.getMinX();
		int dist = maxx-minx +1;
		for(int c=0;c<dist;c++) {
			if(!checkFullRowhandler(maxx) && maxx>=0) {
				maxx--;
			}
		}
//		int[] rowIndex = { fEntity.headSpot.x, fEntity.secSpot.x, fEntity.thirdSpot.x, fEntity.fourthSpot.x };
//		boolean[] rowTag = { false, false, false, false };
//		if (checkFullRowhandler(fEntity.headSpot)) {
//			fullcount++;
//			rowTag[0] = true;
//		}
//		if (checkFullRowhandler(fEntity.secSpot)) {
//			fullcount++;
//			rowTag[1] = true;
//		}
//		if (checkFullRowhandler(fEntity.thirdSpot)) {
//			fullcount++;
//			rowTag[2] = true;
//		}
//		if (checkFullRowhandler(fEntity.fourthSpot)) {
//			fullcount++;
//			rowTag[3] = true;
//		}
//
//		if (fullcount != 0) {
//			gEntity.upScore(fullcount * 10);
//			gEntity.checkLevel();
//			repaintArray(rowIndex, rowTag);
//			repaintActivity(fEntity.lowestRow());
//			gEntity.GameActivity.setScore(Integer.toString(gEntity.getScore()));
//			gEntity.GameActivity.setLevel(Integer.toString(gEntity.getLevel()));
//		}

	}
	
	public void repaintArray(int maxX) {
		for(int cx=maxX;cx>0;cx--) {
			for(int y=0;y<GlobalConstants.NUMBER_OF_COLUMNS;y++) {
				gEntity.GameArray[cx][y] = gEntity.GameArray[cx-1][y];
			}
		}
		for(int y=0;y<GlobalConstants.NUMBER_OF_COLUMNS;y++) {
			gEntity.GameArray[0][y] = 0;
		}
	}

//	public void repaintArray(int[] rowIndex, boolean[] rowTag) {
//		for (int i = 0; i < GameConstants.NUMBER_OF_SPOT - 1; i++) {
//			int temp = i;
//			for (int j = i + 1; j < GameConstants.NUMBER_OF_SPOT; j++) {
//				if (rowIndex[j] > rowIndex[temp]) {
//					temp = j;
//				}
//			}
//			if (temp != i) {
//				int indexTemp = rowIndex[i];
//				rowIndex[i] = rowIndex[temp];
//				rowIndex[temp] = indexTemp;
//				boolean tagTemp = rowTag[i];
//				rowTag[i] = rowTag[temp];
//				rowTag[temp] = tagTemp;
//			}
//		}
//		int count = 0;
//		for (int i = 0; i < GameConstants.NUMBER_OF_SPOT; i++) {
//			if (i == 0 || (i != 0 && rowIndex[i] != rowIndex[i - 1])) {
//				if (rowTag[i]) {
//					count++;
//				}
//			}
//		}
//
//		int rowNum = rowIndex[GameConstants.NUMBER_OF_SPOT - 1] - rowIndex[0] + 1;
//		int rowWrite = rowNum - count;
//		int bas = rowIndex[0];
//		for (int i = 0; i < rowWrite; i++) {
//			int j = 0;
//			for (; j < GameConstants.NUMBER_OF_SPOT; j++) {
//				if (j == 0 || (j != 0 && rowIndex[j] != rowIndex[j - 1])) {
//					if (!rowTag[j]) {
//						for (int k = 0; k < GlobalConstants.NUMBER_OF_COLUMNS; k++) {
//							gEntity.GameArray[bas + i][k] = gEntity.GameArray[rowIndex[j]][k];
//						}
//					}
//				}
//			}
//		}
//
//		for (int i = rowIndex[GameConstants.NUMBER_OF_SPOT - 1]; i >= 0; i--) {
//			for (int j = 0; j < GlobalConstants.NUMBER_OF_COLUMNS; j++) {
//				gEntity.GameArray[i + count][j] = gEntity.GameArray[i][j];
//			}
//		}
//
//	}

	public void repaintActivity(int lowestx) {
		for (int j = 0; j < GlobalConstants.NUMBER_OF_COLUMNS; j++) {
			gEntity.GameActivity.setBlockColorByCoordinates(lowestx, j, Color.white);
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = lowestx; i >= 0; i--) {	
			for (int j = 0; j < GlobalConstants.NUMBER_OF_COLUMNS; j++) {
				Color color = GameConstants.COLOR_SET[gEntity.GameArray[i][j]];
				gEntity.GameActivity.setBlockColorByCoordinates(i, j, color);
			}
		}
	}
	
	
	public boolean checkFullRowhandler(int maxX) {
		boolean fullFlag = true;
		for (int y = 0; y < GlobalConstants.NUMBER_OF_COLUMNS; y++) {
			if (gEntity.GameArray[maxX][y] == 0) {
				fullFlag = false;
				break;
			}
		}
		if (fullFlag) {
			gEntity.upScore(10);
			gEntity.checkLevel();
			gEntity.GameActivity.setScore(Integer.toString(gEntity.getScore()));
			gEntity.GameActivity.setLevel(Integer.toString(gEntity.getLevel()));
			repaintArray(maxX);
			repaintActivity(maxX);
			return true;
		} else {
			return false;
		}
	}

//	public boolean checkFullRowhandler(Spot s) {
//		int x = s.x;
//		boolean fullFlag = true;
//		for (int y = 0; y < GlobalConstants.NUMBER_OF_COLUMNS; y++) {
//			if (gEntity.GameArray[x][y] == 0) {
//				fullFlag = false;
//				break;
//			}
//		}
//		if (fullFlag) {
//			for (int y = 0; y < GlobalConstants.NUMBER_OF_COLUMNS; y++) {
//				gEntity.GameArray[x][y] = 0;
//				gEntity.GameActivity.setBlockColorByCoordinates(x, y, Color.white);
//			}
//			return true;
//		} else {
//			return false;
//		}
//	}

	public void paintFEntityInArray(FallingEntity fEntity, boolean nullFlag) {
		// nullFlag为true时，表示置为白色，false表示写上颜色
		if (!nullFlag) {
			int colorNum = GameConstants.COLOR_INDEX.get(fEntity.color).intValue();
			if (fEntity.headSpot.IsInArray()) {
				gEntity.GameArray[fEntity.headSpot.x][fEntity.headSpot.y] = colorNum;
			}
			if (fEntity.secSpot.IsInArray()) {
				gEntity.GameArray[fEntity.secSpot.x][fEntity.secSpot.y] = colorNum;
			}
			if (fEntity.thirdSpot.IsInArray()) {
				gEntity.GameArray[fEntity.thirdSpot.x][fEntity.thirdSpot.y] = colorNum;
			}
			if (fEntity.fourthSpot.IsInArray()) {
				gEntity.GameArray[fEntity.fourthSpot.x][fEntity.fourthSpot.y] = colorNum;
			}

		} else {
			if (fEntity.headSpot.IsInArray()) {
				gEntity.GameArray[fEntity.headSpot.x][fEntity.headSpot.y] = 0;
			}
			if (fEntity.secSpot.IsInArray()) {
				gEntity.GameArray[fEntity.secSpot.x][fEntity.secSpot.y] = 0;
			}
			if (fEntity.thirdSpot.IsInArray()) {
				gEntity.GameArray[fEntity.thirdSpot.x][fEntity.thirdSpot.y] = 0;
			}
			if (fEntity.fourthSpot.IsInArray()) {
				gEntity.GameArray[fEntity.fourthSpot.x][fEntity.fourthSpot.y] = 0;
			}
		}
	}

	public void paintFallingEntity(FallingEntity fEntity, Color color, int flag) {
		// flag为0表示写右上方矩阵，flag为1表示写游戏矩阵
		if (flag == 0) {
			gEntity.GameActivity.setNextBlockColor(fEntity.headSpot.x, fEntity.headSpot.y, color);
			gEntity.GameActivity.setNextBlockColor(fEntity.secSpot.x, fEntity.secSpot.y, color);
			gEntity.GameActivity.setNextBlockColor(fEntity.thirdSpot.x, fEntity.thirdSpot.y, color);
			gEntity.GameActivity.setNextBlockColor(fEntity.fourthSpot.x, fEntity.fourthSpot.y, color);
		}
		if (flag == 1) {
			if (fEntity.headSpot.IsInArray()) {
				gEntity.GameActivity.setBlockColorByCoordinates(fEntity.headSpot.x, fEntity.headSpot.y, color);
			}
			if (fEntity.secSpot.IsInArray()) {
				gEntity.GameActivity.setBlockColorByCoordinates(fEntity.secSpot.x, fEntity.secSpot.y, color);
			}
			if (fEntity.thirdSpot.IsInArray()) {
				gEntity.GameActivity.setBlockColorByCoordinates(fEntity.thirdSpot.x, fEntity.thirdSpot.y, color);
			}
			if (fEntity.fourthSpot.IsInArray()) {
				gEntity.GameActivity.setBlockColorByCoordinates(fEntity.fourthSpot.x, fEntity.fourthSpot.y, color);
			}

		}
	}

	public boolean IsEntityConflict(FallingEntity fEntity, FallingEntity falltemp) {
		int [][] tempArray = new int[GlobalConstants.NUMBER_OF_ROWS][GlobalConstants.NUMBER_OF_COLUMNS];
		for(int i=0;i<GlobalConstants.NUMBER_OF_ROWS;i++) {
			for (int j=0;j<GlobalConstants.NUMBER_OF_COLUMNS;j++) {
				tempArray [i][j] = gEntity.GameArray[i][j]; 
			}
		}
		if(fEntity.headSpot.inArray) {
			tempArray[fEntity.headSpot.x][fEntity.headSpot.y] = 0;
		}
		if(fEntity.secSpot.inArray) {
			tempArray[fEntity.secSpot.x][fEntity.secSpot.y] = 0;
		}if(fEntity.thirdSpot.inArray) {
			tempArray[fEntity.thirdSpot.x][fEntity.thirdSpot.y] = 0;
		}if(fEntity.fourthSpot.inArray) {
			tempArray[fEntity.fourthSpot.x][fEntity.fourthSpot.y] = 0;
		}
		if (falltemp.headSpot.IsInArray() && tempArray[falltemp.headSpot.x][falltemp.headSpot.y] != 0) {
			return true;
		} else if (falltemp.secSpot.IsInArray() && tempArray[falltemp.secSpot.x][falltemp.secSpot.y] != 0) {
			return true;
		} else if (falltemp.thirdSpot.IsInArray()
				&& tempArray[falltemp.thirdSpot.x][falltemp.thirdSpot.y] != 0) {
			return true;
		} else if (falltemp.fourthSpot.IsInArray()
				&& tempArray[falltemp.fourthSpot.x][falltemp.fourthSpot.y] != 0) {
			return true;
		} else {
			return false;
		}
	}

	public void FallingEntityProduce() {
		int lineSize = FEPLine.getFEPipelineSize();
		
		if (lineSize < GameConstants.LENGTH_OF_FEPIPELINE) {
			int patternNum = ra1.nextInt(GameConstants.NUMBER_OF_PATTERN);
			int colorNum = ra1.nextInt(GameConstants.NUMBER_OF_COLOR-1) + 1;
			Color color = GameConstants.COLOR_SET[colorNum];
			int direct = GameConstants.PATTERN_DIRECT[patternNum];
			int directNum = ra1.nextInt(direct);
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
			if (gEntity.getScore() < GameConstants.SCORE_RANK[i]) {
				return i;
			}
		}
		return -1;
	}

	public static Spot getInitialSpot(int patternNum, int directNum) {
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
			break;
		case 6:
			temp = patternSixInitial(directNum);
			break;

		default:
			temp = new Spot(-1, -1);
			break;
		}
		return temp;
	}

	public static Spot patternZeroInitial(int directNum) {
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

	public static Spot patternOneInitial(int directNum) {
		Spot temp = null;
		switch (directNum) {
		case 0:
			temp = new Spot(-1, 5);
			break;
		case 1:
			temp = new Spot(-2, 5);
			break;
		case 2:
			temp = new Spot(-2, 5);
			break;
		case 3:
			temp = new Spot(-2, 6);
			break;
		default:
			temp = new Spot(-2, -2);
			break;
		}
		return temp;
	}

	public static Spot patternTwoInitial(int directNum) {
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

	public static Spot patternThreeInitial(int directNum) {
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

	public static Spot patternFourInitial(int directNum) {

		return new Spot(-2, 5);
	}

	public static Spot patternFiveInitial(int directNum) {
		Spot temp = null;
		switch (directNum) {
		case 0:
			temp = new Spot(-2, 5);
			break;
		case 1:
			temp = new Spot(-2, 5);
			break;
		case 2:
			temp = new Spot(-2, 6);
			break;
		case 3:
			temp = new Spot(-1, 5);
			break;
		default:
			temp = new Spot(-2, -2);
			break;
		}
		return temp;
	}

	public static Spot patternSixInitial(int directNum) {
		Spot temp = null;
		switch (directNum) {
		case 0:
			temp = new Spot(-2, 6);
			break;
		case 1:
			temp = new Spot(-2, 5);
			break;
		case 2:
			temp = new Spot(-2, 5);
			break;
		case 3:
			temp = new Spot(-2, 5);
			break;
		default:
			temp = new Spot(-2, -2);
			break;
		}
		return temp;
	}

}
