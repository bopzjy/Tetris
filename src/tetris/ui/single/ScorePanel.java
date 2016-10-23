package tetris.ui.single;

import java.awt.Color;

import javax.swing.JPanel;

public class ScorePanel extends JPanel{
	private final double XRelative = 150.0/1229;
	private final double YRelative = 330.0/1024;
	private final double WidthOfWhole = (1075.0 - 150)/1229;
	private final double HeightOfWhole = (635.0 - 330)/1024;
	
	public ScorePanel() {
		// TODO Auto-generated constructor stub
		this.setBackground(Color.blue);
		
	}
}
