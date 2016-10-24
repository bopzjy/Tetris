package tetris.game.logic;

import java.util.HashMap;
import java.util.Map;

public class GameConstants {
	public static final int NUMBER_OF_PATTERN = 10;
	public static final int NUMBER_OF_SPEED_RANK = 10;
	public static final int NUMBER_OF_COLOR = 10;
	public static final int LENGTH_OF_FEPIPELINE = 20;
	//下落快和顔色的固定映射
	public static final int [] PATTERN_COLOR  = {0,1,2,3,4,5,6,7,8,9};
	//当前分数和下落物速度的映射
	public static  Map<Integer,Integer> _SCORE_SPEED = new HashMap<Integer,Integer>(10);
	
	//构建map
	public static void initMap () {
		_SCORE_SPEED.put(300, 0);
		_SCORE_SPEED.put(6000, 1);
		_SCORE_SPEED.put(1500, 2);
		_SCORE_SPEED.put(3000, 3);
		_SCORE_SPEED.put(5000, 4);
		_SCORE_SPEED.put(7000, 5);
		_SCORE_SPEED.put(9000, 6);
		_SCORE_SPEED.put(12000, 7);
		_SCORE_SPEED.put(15000, 8);
		_SCORE_SPEED.put(18000, 9);
	    
	}
}
