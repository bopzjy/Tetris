package tetris.ui.Interface;

import java.awt.Color;

public interface ISetBlockColor {
	public void setBlockColorByCoordinates(int i, int j, Color color);
	
	/*
	 * 功能：	设置next面板块的颜色，
	 * 		0=<i<4
	 * 		0<=j<5
	 * 		color=null,则设置为透明
	 */
	public void setNextBlockColor(int i, int j, Color color);
}
