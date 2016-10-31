package tetris.game.logic;

public class Spot {
	int x;
	int y;
	boolean inArray;

	public Spot(int x, int y) {
		this.x = x;
		this.y = y;
		this.inArray = false;
	}

	public Spot(int x, int y, boolean inArray) {
		this.x = x;
		this.y = y;
		this.inArray = inArray;
	}

	public Spot(Spot s) {
		x = s.x;
		y = s.y;
		inArray = s.inArray;
	}
	
	public boolean IsInArray () {
		return inArray;
	}
	
	public void checkSpotInArray() {
		inArray = (x>=0 && y>=0);
	}

}
