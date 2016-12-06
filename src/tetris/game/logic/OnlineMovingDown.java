package tetris.game.logic;

import java.awt.Color;
import java.rmi.RemoteException;
import java.util.Random;

import tetris.common.GlobalConstants;
import tetris.net.ClientInterface;
import tetris.net.ClientManager;
import tetris.net.ServerManager;
import tetris.net.status;

public class OnlineMovingDown implements Runnable {
	GameEntity gEntity;
	FallingEntityPipeline FEPLine = null;
	FallingEntity currentFEntity = null;
	Random ra1 = new Random();
	public volatile boolean exit1 = false;
	public volatile boolean exit2 = false;

	public OnlineMovingDown(GameEntity gEntity) {
		// TODO Auto-generated constructor stub
		this.gEntity = gEntity;
		FEPLine = new FallingEntityPipeline(this.gEntity);
		for (int i = 0; i < GameConstants.LENGTH_OF_FEPIPELINE; i++) {
			FallingEntityProduce();
		}

	}

	public void start() {
		exit1 = false;
		exit2 = false;
		new Thread(this).start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!exit1) {
			gEntity.fastfall = false;
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
			try {
				paintFallingEntity(fEntityTemp, fEntityTemp.color, 0);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			fEntity.speedRank = getRank();
			while (!exit2) {
				FallingEntity falltemp = new FallingEntity(fEntity);
				if (falltemp.moveDown()) {
					boolean conflictFlag = false;
					conflictFlag = IsEntityConflict(fEntity, falltemp);
					boolean downArrayFlag = falltemp.checkDownArray();
					if (!conflictFlag && !downArrayFlag) {
						paintFEntityInArray(fEntity, true);
						paintFEntityInArray(falltemp, false);
						try {
							paintFallingEntity(fEntity, Color.white, 1);
							paintFallingEntity(falltemp, falltemp.color, 1);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						fEntity.moveDown();
						if (!gEntity.fastfall) {
							try {
								Thread.sleep(GameConstants.SPEED_RANK[fEntity.speedRank]);
								// Thread.sleep(200);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					} else if (fEntity.checkUpArray()) {
						try {
							GameOver();
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return;
					} else {
						try {
							checkFullRow(fEntity);
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// paintFallingEntity(fEntityTemp, Color.white, 0);
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
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				gEntity.comActvity.setNextBlockColor(i, j, null);
			}
		}
	}

	public void GameOver() throws RemoteException {
		ClientInterface cInter = ClientManager.getInstance().getInterface();
		cInter.youWin();
		ServerManager sManager = ServerManager.getInstance();
		sManager.setState(status.online);
		sManager.server.setStatus(sManager.username, status.online);
		InitUILogic.showRivalDiaolog();
	}

	public void checkFullRow(FallingEntity fEntity) throws RemoteException {
		int maxx = fEntity.getMaxX();
		int minx = fEntity.getMinX();
		int dist = maxx - minx + 1;
		for (int c = 0; c < dist; c++) {
			if (!checkFullRowhandler(maxx) && maxx >= 0) {
				maxx--;
			}
		}

	}

	public void repaintArray(int maxX) {
		for (int cx = maxX; cx > 0; cx--) {
			for (int y = 0; y < GlobalConstants.NUMBER_OF_COLUMNS; y++) {
				gEntity.GameArray[cx][y] = gEntity.GameArray[cx - 1][y];
			}
		}
		for (int y = 0; y < GlobalConstants.NUMBER_OF_COLUMNS; y++) {
			gEntity.GameArray[0][y] = 0;
		}
	}

	public void repaintActivity(int lowestx) throws RemoteException {
		ClientManager cManager = ClientManager.getInstance();
		for (int j = 0; j < GlobalConstants.NUMBER_OF_COLUMNS; j++) {
			gEntity.comActvity.setMyColor(lowestx, j, Color.white);
			cManager.getInterface().setBlockColorByCoordinates(lowestx, j, Color.white);
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
				gEntity.comActvity.setMyColor(i, j, color);
				cManager.getInterface().setBlockColorByCoordinates(i, j, color);
			}
		}
	}

	public boolean checkFullRowhandler(int maxX) throws RemoteException {
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
			repaintArray(maxX);
			repaintActivity(maxX);
			return true;
		} else {
			return false;
		}
	}

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

	public void paintFallingEntity(FallingEntity fEntity, Color color, int flag) throws RemoteException {
		// flag为0表示写右上方矩阵，flag为1表示写游戏矩阵
		if (flag == 0) {
			gEntity.comActvity.setNextBlockColor(fEntity.headSpot.x, fEntity.headSpot.y, color);
			gEntity.comActvity.setNextBlockColor(fEntity.secSpot.x, fEntity.secSpot.y, color);
			gEntity.comActvity.setNextBlockColor(fEntity.thirdSpot.x, fEntity.thirdSpot.y, color);
			gEntity.comActvity.setNextBlockColor(fEntity.fourthSpot.x, fEntity.fourthSpot.y, color);
		}
		if (flag == 1) {
			ClientInterface cInter = ClientManager.getInstance().getInterface();
			if (fEntity.headSpot.IsInArray()) {
				gEntity.comActvity.setMyColor(fEntity.headSpot.x, fEntity.headSpot.y, color);
				cInter.setBlockColorByCoordinates(fEntity.headSpot.x, fEntity.headSpot.y, color);
			}
			if (fEntity.secSpot.IsInArray()) {
				gEntity.comActvity.setMyColor(fEntity.secSpot.x, fEntity.secSpot.y, color);
				cInter.setBlockColorByCoordinates(fEntity.secSpot.x, fEntity.secSpot.y, color);
			}
			if (fEntity.thirdSpot.IsInArray()) {
				gEntity.comActvity.setMyColor(fEntity.thirdSpot.x, fEntity.thirdSpot.y, color);
				cInter.setBlockColorByCoordinates(fEntity.thirdSpot.x, fEntity.thirdSpot.y, color);
			}
			if (fEntity.fourthSpot.IsInArray()) {
				gEntity.comActvity.setMyColor(fEntity.fourthSpot.x, fEntity.fourthSpot.y, color);
				cInter.setBlockColorByCoordinates(fEntity.fourthSpot.x, fEntity.fourthSpot.y, color);
			}

		}
	}

	public boolean IsEntityConflict(FallingEntity fEntity, FallingEntity falltemp) {
		int[][] tempArray = new int[GlobalConstants.NUMBER_OF_ROWS][GlobalConstants.NUMBER_OF_COLUMNS];
		for (int i = 0; i < GlobalConstants.NUMBER_OF_ROWS; i++) {
			for (int j = 0; j < GlobalConstants.NUMBER_OF_COLUMNS; j++) {
				tempArray[i][j] = gEntity.GameArray[i][j];
			}
		}
		if (fEntity.headSpot.inArray) {
			tempArray[fEntity.headSpot.x][fEntity.headSpot.y] = 0;
		}
		if (fEntity.secSpot.inArray) {
			tempArray[fEntity.secSpot.x][fEntity.secSpot.y] = 0;
		}
		if (fEntity.thirdSpot.inArray) {
			tempArray[fEntity.thirdSpot.x][fEntity.thirdSpot.y] = 0;
		}
		if (fEntity.fourthSpot.inArray) {
			tempArray[fEntity.fourthSpot.x][fEntity.fourthSpot.y] = 0;
		}
		if (falltemp.headSpot.IsInArray() && tempArray[falltemp.headSpot.x][falltemp.headSpot.y] != 0) {
			return true;
		} else if (falltemp.secSpot.IsInArray() && tempArray[falltemp.secSpot.x][falltemp.secSpot.y] != 0) {
			return true;
		} else if (falltemp.thirdSpot.IsInArray() && tempArray[falltemp.thirdSpot.x][falltemp.thirdSpot.y] != 0) {
			return true;
		} else if (falltemp.fourthSpot.IsInArray() && tempArray[falltemp.fourthSpot.x][falltemp.fourthSpot.y] != 0) {
			return true;
		} else {
			return false;
		}
	}

	public void FallingEntityProduce() {
		int lineSize = FEPLine.getFEPipelineSize();

		if (lineSize < GameConstants.LENGTH_OF_FEPIPELINE) {
			int patternNum = ra1.nextInt(GameConstants.NUMBER_OF_PATTERN);
			int colorNum = ra1.nextInt(GameConstants.NUMBER_OF_COLOR - 1) + 1;
			Color color = GameConstants.COLOR_SET[colorNum];
			int direct = GameConstants.PATTERN_DIRECT[patternNum];
			int directNum = ra1.nextInt(direct);
			int speedRank = getRank();
			Spot spotTemp = MovingDown.getInitialSpot(patternNum, directNum);
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

}
