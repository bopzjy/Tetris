package tetris.game.logic;

import tetris.common.GlobalConstants;
import tetris.ui.Activity;
import tetris.ui.activity.SinglePlayer;

public class GameEntry {

	// ս���߼�����
	int[][] GameArray = null;
	// ��Ϸ��Ӧ�Ľ������
	SinglePlayer GameActivity = null;
	FallingEntryPipeline FEPLine = null ;
	MovingDown mdThread = null;
	// ������¼
	int score;

	public GameEntry() {
		init();
	}

	public GameEntry(SinglePlayer GameActivity) {
		this.GameActivity = GameActivity;
		init();
	}

	public void init() {
		// TODO Auto-generated method stub
		mdThread = new MovingDown(this);
		FEPLine = new FallingEntryPipeline(this);
		GameArray = new int[GlobalConstants.NUMBER_OF_ROWS][GlobalConstants.NUMBER_OF_COLUMNS];
		score = 0;
		
		//���������������߳�
		Thread Producer = new Thread(new FEPipelineProducer(FEPLine));
		
		
	}

	public void printGameArray() {
		for (int i = 0; i < GlobalConstants.NUMBER_OF_ROWS; i++) {
			int j = 0;
			int col = GlobalConstants.NUMBER_OF_COLUMNS - 1;
			for (; j < col; j++) {
				System.out.print(GameArray[i][j] + " ");
			}
			System.out.println(GameArray[i][j]);
		}

	}

	public int getScore() {
		return score;
	}
	
	public void upScore (int temp) {
		score = score + temp;
	}

	public static void main(String args[]) {
		GameEntry gg = new GameEntry();
		gg.printGameArray();
	}
}
