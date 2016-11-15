package tetris.common;

import java.awt.Color;
import java.awt.Font;

public class GlobalConstants {
	public static final int NUMBER_OF_ROWS = 21;
	public static final int NUMBER_OF_COLUMNS = 12;
	public static final int FONT_SIZE = 42;
	//NetConfiguration
	public static final int CLIENT_PORT=1111;
	public static final int SERVER_PORT=9999;
	public static final String SERVER_HOST="127.0.0.1";
	//public static Font F 
	
	// BlocksPanel
	public static Color BLOCKSPANEL_INIT_COLOR = Color.white;
	public static final double SINGLE_BLOCKSPANEL_XRelative = 0.144;
	public static final double SINGLE_BLOCKSPANEL_YRelative = 0.080;
	public static final double SINGLE_BLOCKSPANEL_WidthOfWhole = (652.1-152.8)/1229;
	public static final double SINGLE_BLOCKSPANEL_HeightOfWhole = (942.0 - 79)/1024;
	
	//NameDialog
	public static final double SINGLE_NAMEDIALOG_XRelative = 150.0/1229;
	public static final double SINGLE_NAMEDIALOG_YRelative = 330.0/1024;
	public static final double SINGLE_NAMEDIALOG_WidthOfWhole = (1075.0 - 150)/1229;
	public static final double SINGLE_NAMEDIALOG_HeightOfWhole = (635.0 - 330)/1024;
	public static final double SINGLE_NAMEDIALOG_TF_XRelative = 0.45;
	public static final double SINGLE_NAMEDIALOG_TF_YRelative = 0.37;
	public static final double SINGLE_NAMEDIALOG_TF_WidthOfWhole = 0.3623188405797101;
	public static final double SINGLE_NAMEDIALOG_TF_HeightOfWhole = 0.23;
	
	//ScorePanel
	public static final double SINGLE_SCORE_XRelative = 0.685;
	public static final double SINGLE_SCORE_YRelative = 0.665;
	public static final double SINGLE_SCORE_WidthOfWhole = 0.2;
	public static final double SINGLE_SCORE_HeightOfWhole = 0.1;
	
	//levelPanel
	public static final double SINGLE_LEVEL_XRelative = 0.685;
	public static final double SINGLE_LEVEL_YRelative = 0.5;
	public static final double SINGLE_LEVEL_WidthOfWhole = 0.2;
	public static final double SINGLE_LEVEL_HeightOfWhole = 0.1;	
	
	//nextPanel
	public static final double SINGLE_NEXT_XRelative = 0.695;
	public static final double SINGLE_NEXT_YRelative = 0.178;
	public static final double SINGLE_NEXT_WidthOfWhole =  0.185;
	public static final double SINGLE_NEXT_HeightOfWhole = SINGLE_NEXT_WidthOfWhole; //* 1.19;	
	//public static final double SINGLE_NEXT_HeightOfWhole = 0.24;
	
	//gameoverDialog
	public static final double SINGLE_GAMEOVER_XRelative = 0.11;
	public static final double SINGLE_GAMEOVER_YRelative = 0.17;
	public static final double SINGLE_GAMEOVER_WidthOfWhole = (1075.0 - 150)/1229;
	public static final double SINGLE_GAMEOVER_HeightOfWhole = 0.65;
	
	public static final double SINGLE_GAMEOVER_LEVEL_XRelative = 0.15;
	public static final double SINGLE_GAMEOVER_LEVEL_YRelative = 0.55;
	public static final double SINGLE_GAMEOVER_LEVEL_WidthOfWhole = 0.30;
	public static final double SINGLE_GAMEOVER_LEVEL_HeightOfWhole = 0.13;
	
	public static final double SINGLE_GAMEOVER_SCORE_XRelative = 0.56;
	/*public static final double SINGLE_GAMEOVER_SCORE_YRelative = 0.40;
	public static final double SINGLE_GAMEOVER_SCORE_WidthOfWhole = 0.3623188405797101;
	public static final double SINGLE_GAMEOVER_SCORE_HeightOfWhole = 0.18;*/
	
}

