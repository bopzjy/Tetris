package tetris.game.logic;

import java.awt.Color;

public class FlashEntity {
	public int x;
	public int y;
	public Color color;
	
	public FlashEntity(FlashEntity f) {
		// TODO Auto-generated constructor stub
		x = f.x;
		y = f.y;
		color = f.color;
	}
	
	public FlashEntity(int x,int y,Color color) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.color = color;
	}
}
