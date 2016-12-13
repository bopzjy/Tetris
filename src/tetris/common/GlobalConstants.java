package tetris.common;

import java.awt.Color;
import java.awt.Font;

public class GlobalConstants {
	public static final int NUMBER_OF_ROWS = 21;
	public static final int NUMBER_OF_COLUMNS = 12;
	public static final int FONT_SIZE = 42;
	//NetConfiguration
	//public static final int CLIENT_PORT=1111;
	public static int CLIENT_PORT=1111;
	public static final int SERVER_PORT=9999;
	public static final String SERVER_HOST="127.0.0.1";
	//public static Font F 
	// BlocksPanel
	public static Color BLOCKSPANEL_INIT_COLOR = Color.white;
	public static final double[][] SINGLE_GAMEBLOCKS_SHAPE = {
			{0.144, 0.080},				// location
			{0.406, 0.843}				// widht and height 
	};
	
	//NameDialog
	public static final double[][] SINGLE_NAMEDIALOG_SHAPE = {
			{150.0/1229, 330.0/1024},								// location
			{(1075.0 - 150)/1229, (635.0 - 330)/1024},				// width and height 
			{0.45, 0.37},											// name text field location
			{0.3623188405797101, 0.23}								// name text field width and height	
	};
	
	//ScorePanel
	public static final double[][] SINGLE_SCORE_SHAPE = {
			{0.685, 0.665},			// location
			{0.2, 0.1}				// widht and height 
	};
	
	//levelPanel	
	public static final double[][] SINGLE_LEVEL_SHAPE = {
			{0.685, 0.5},			// location
			{0.2, 0.1}				// widht and height 
	};
	
	//nextPanel
	public static final double[][] SINGLE_NEXTPANEL_SHAPE = {
			{0.695, 0.178},				// location
			{0.185, 0.185}				// widht and height 
	};
	//public static final double SINGLE_NEXT_HeightOfWhole = 0.24;
	
	//gameoverDialog
	public static final double[][] SINGLE_GAMEOVER_SHAPE = {
			{0.11, 0.17},								// location
			{0.752,  0.65},								// width and height 
			{0.15, 0.55},								// level text location
			{0.30, 0.13},								// level width and height
			{0.56, 0.55},								// score text location
			{0.30, 0.13}								// score width and height
	};
	
	//register
	public static final double[][] REGISTER_SHAPE = {
			{0.13, 0.27},								// location
			{0.752,  0.45}								// width and height 
	};
}

