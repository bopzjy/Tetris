package tetris.game.logic;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class GameConstants {

	// ���������ĸ�����
	public static final int NUMBER_OF_SPOT = 4;
	// ������ģʽ��
	public static final int NUMBER_OF_PATTERN = 7;
	// �����ٶȵȼ���
	public static final int NUMBER_OF_SPEED_RANK = 10;
	// ��ɫ����
	public static final int NUMBER_OF_COLOR = 20;
	// ������Ԥ������
	public static final int LENGTH_OF_FEPIPELINE = 20;
	// �������ɫ�Ĺ̶�ӳ��
	public static final int[] PATTERN_COLOR = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	// �ٶȵȼ���Ӧ�ķ����ݶ�
	public static final int[] SCORE_RANK = { 300, 600, 1500, 3000, 5000, 3000, 5000, 7000, 9000, 12000, 15000, 18000 };

	public static final int[] PATTERN_DIRECT = { 2, 4, 2, 2, 1, 4, 4 };

	public static final Spot[] HEADSPOT_ROTATE = { new Spot(-1, -1), new Spot(1, 1), new Spot(0, 0), new Spot(0, 0),
			new Spot(0, 0), new Spot(0, 0), new Spot(-1, 0), new Spot(1, 0), new Spot(-1, 0), new Spot(1, 0),
			new Spot(0, 0), new Spot(0, 0), new Spot(0, 0), new Spot(0, 0), new Spot(0, 0), new Spot(0, 0),
			new Spot(0, 0), new Spot(0, 0), new Spot(0, 0) };

	public static final Color[] COLOR_SET = { new Color(0xFBE601), new Color(0xE9BC01), new Color(0xDC9600),
			new Color(0xCB6018), new Color(0xC44031), new Color(0xBF0311), new Color(0xA01027), new Color(0x5B40013),
			new Color(0x3C2C13), new Color(0x000040), new Color(0x011A5A), new Color(0x0121381), new Color(0x065CA5),
			new Color(0x76AADA), new Color(0x609E75), new Color(0x70A847), new Color(0x4C7B35), new Color(0x75A453),
			new Color(0x2B5F31), new Color(0x1D4020) };

	public static HashMap<Color, Integer> COLOR_INDEX = new HashMap<Color, Integer>();

	public static void ColorIndexInit() {
		for (int i = 0; i < NUMBER_OF_COLOR; i++) {
			COLOR_INDEX.put(COLOR_SET[i], new Integer(i));
		}
	}

	public static final Spot[] NEXT_HEADSPOTS = { new Spot(3, 2), new Spot(1, 1), new Spot(2, 2), new Spot(1, 2),
			new Spot(1, 2), new Spot(1, 2), new Spot(2, 2), new Spot(1, 1), new Spot(2, 2), new Spot(1, 1),
			new Spot(1, 1), new Spot(1, 2), new Spot(1, 2), new Spot(1, 2), new Spot(2, 2), new Spot(1, 2),
			new Spot(1, 2), new Spot(1, 2), new Spot(1, 2) };

	public static HashMap<Integer, Integer> NEXT_HEADSPOTS_INDEX = new HashMap<Integer, Integer>();

	public static void nextHeadspotsIndexInit() {
		NEXT_HEADSPOTS_INDEX.put(0, 0);
		NEXT_HEADSPOTS_INDEX.put(1, 1);
		NEXT_HEADSPOTS_INDEX.put(10, 2);
		NEXT_HEADSPOTS_INDEX.put(11, 3);
		NEXT_HEADSPOTS_INDEX.put(12, 4);
		NEXT_HEADSPOTS_INDEX.put(13, 5);
		NEXT_HEADSPOTS_INDEX.put(20, 6);
		NEXT_HEADSPOTS_INDEX.put(21, 7);
		NEXT_HEADSPOTS_INDEX.put(30, 8);
		NEXT_HEADSPOTS_INDEX.put(31, 9);
		NEXT_HEADSPOTS_INDEX.put(40, 10);
		NEXT_HEADSPOTS_INDEX.put(50, 11);
		NEXT_HEADSPOTS_INDEX.put(51, 12);
		NEXT_HEADSPOTS_INDEX.put(52, 13);
		NEXT_HEADSPOTS_INDEX.put(53, 14);
		NEXT_HEADSPOTS_INDEX.put(60, 15);
		NEXT_HEADSPOTS_INDEX.put(61, 16);
		NEXT_HEADSPOTS_INDEX.put(62, 17);
		NEXT_HEADSPOTS_INDEX.put(63, 18);
	}

	static {
		ColorIndexInit();
		nextHeadspotsIndexInit();
	}

}
