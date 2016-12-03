package tetris.game.logic;

import java.awt.Color;

import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.activity.SinglePlayer;

class Test1 {
	public static int X = 100;
	public final static int Y = 200;

	public Test1() {
		System.out.println("Test构造函数执行");
	}

	static {
		System.out.println("static语句块执行");
	}

	public static void display() {
		System.out.println("静态方法被执行");
	}

	public void display_1() {
		System.out.println("实例方法被执行");
	}
}

class test2  {
	public void tmethod (int [] aa) {
		aa[0] = 111111;
		System.out.println(aa[0]);
	}
}

	public class test {
		public test () {}
		public static void main(String args[]) {
			//Test1  t = new Test1();
			//Class.forName("Test");
			//Class.forName("Test");
			ActivityHolder ac  = ActivityHolder.getInstance();
			SinglePlayer sp = (SinglePlayer) ac.turnToNextActivity(Constants.INDEX_SINGLE_PLAYER);
			sp.setBlockColorByCoordinates(0, 0, new Color(0x1D4020));
		}


}
