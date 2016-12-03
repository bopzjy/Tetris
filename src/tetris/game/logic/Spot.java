package tetris.game.logic;

import tetris.common.GlobalConstants;

public class Spot {
	int x;
	int y;
	boolean inArray;
	boolean upArray;
	boolean downArray;

	public Spot(int x, int y) {
		this.x = x;
		this.y = y;
		this.inArray = false;
		this.upArray = true;
		this.downArray = false;
	}

	public Spot(int x, int y, boolean inArray, boolean upArray, boolean downArray) {
		this.x = x;
		this.y = y;
		this.inArray = inArray;
		this.upArray = upArray;
		this.downArray = downArray;
	}

	public Spot(Spot s) {
		x = s.x;
		y = s.y;
		inArray = s.inArray;
		upArray = s.upArray;
		downArray = s.downArray;
	}
	
	public boolean IsInArray () {
		return inArray;
	}
	
	public boolean IsUpArray () {
		return upArray;
	}
	
	public boolean IsDownArray () {
		return downArray;
	}
	
	public void checkSpotInArray() {
		inArray = (x>=0 && x<GlobalConstants.NUMBER_OF_ROWS && y>=0 && y<GlobalConstants.NUMBER_OF_COLUMNS);
	}

	public void checkSpotUpArray () {
		upArray = (x <0 && y>=0 && y<GlobalConstants.NUMBER_OF_COLUMNS);
	}
	
	public void checkSpotdownArray () {
		downArray = (x>=GlobalConstants.NUMBER_OF_ROWS && y>=0 && y<GlobalConstants.NUMBER_OF_COLUMNS );
	}
}
