package tetris.game.logic;

import java.util.HashMap;
import java.util.Map;

public class GameConstants {

	// ������ģʽ��
	public static final int NUMBER_OF_PATTERN = 7;
	// �����ٶȵȼ���
	public static final int NUMBER_OF_SPEED_RANK = 10;
	// ��ɫ����
	public static final int NUMBER_OF_COLOR = 10;
	// ������Ԥ������
	public static final int LENGTH_OF_FEPIPELINE = 20;
	// �������ɫ�Ĺ̶�ӳ��
	public static final int[] PATTERN_COLOR = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	// �ٶȵȼ���Ӧ�ķ����ݶ�
	public static final int[] SCORE_RANK = { 300, 600, 1500, 3000, 5000, 3000, 5000, 7000, 9000, 12000, 15000, 18000 };

	public static final int[] PATTERN_DIRECT = { 2, 4, 2, 2, 1, 4, 4 };

	// //��ǰ�������������ٶȵ�ӳ��
	// public static Map<Integer,Integer> _SCORE_SPEED = new
	// HashMap<Integer,Integer>(10);
	//
	// //����map
	// public static void initMap () {
	// _SCORE_SPEED.put(300, 0);
	// _SCORE_SPEED.put(600, 1);
	// _SCORE_SPEED.put(1500, 2);
	// _SCORE_SPEED.put(3000, 3);
	// _SCORE_SPEED.put(5000, 4);
	// _SCORE_SPEED.put(7000, 5);
	// _SCORE_SPEED.put(9000, 6);
	// _SCORE_SPEED.put(12000, 7);
	// _SCORE_SPEED.put(15000, 8);
	// _SCORE_SPEED.put(18000, 9);
	//
	// }
}
