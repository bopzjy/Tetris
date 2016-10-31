package tetris.game.logic;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class GameConstants {

	// 下落块包含的格子数
	public static final int NUMBER_OF_SPOT = 4;
	// 下落物模式数
	public static final int NUMBER_OF_PATTERN = 7;
	// 下落速度等级数
	public static final int NUMBER_OF_SPEED_RANK = 10;
	// 颜色总数
	public static final int NUMBER_OF_COLOR = 20;
	// 下落物预生成数
	public static final int LENGTH_OF_FEPIPELINE = 20;
	// 下落快和顔色的固定映射
	public static final int[] PATTERN_COLOR = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	// 速度等级对应的分数梯度
	public static final int[] SCORE_RANK = { 300, 600, 1500, 3000, 5000, 3000, 5000, 7000, 9000, 12000, 15000, 18000 };

	public static final int[] PATTERN_DIRECT = { 2, 4, 2, 2, 1, 4, 4 };

	public static final Color[] COLOR_SET = { new Color(0xFBE601), new Color(0xE9BC01), new Color(0xDC9600),
			new Color(0xCB6018), new Color(0xC44031), new Color(0xBF0311), new Color(0xA01027), new Color(0x5B40013),
			new Color(0x3C2C13), new Color(0x000040), new Color(0x011A5A), new Color(0x0121381), new Color(0x065CA5),
			new Color(0x76AADA), new Color(0x609E75), new Color(0x70A847), new Color(0x4C7B35), new Color(0x75A453),
			new Color(0x2B5F31), new Color(0x1D4020) };
	
	public static HashMap<Color,Integer> COLOR_INDEX = new HashMap<Color,Integer>();
	public static void ColorIndexInit() {
		for(int i=0;i<NUMBER_OF_COLOR;i++) {
			COLOR_INDEX.put(COLOR_SET[i], new Integer(i));
		}
	}
}
