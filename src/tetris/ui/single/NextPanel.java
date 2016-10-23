package tetris.ui.single;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.common.GlobalConstants;
import tetris.ui.MainContainer;

public class NextPanel extends JPanel{
	
	private final int ROWS = 4;
	private final int COLUMN = 5;
	private final int HGAP = 2;
	private final int VGAP = 2;
		
	private double XRelative;
	private double YRelative;
	private double WidthOfWhole;
	private double HeightOfWhole;
	
	private final Color INIT_COLOR = null;
	
	private JPanel[][] blocksRef;
	
	public NextPanel(double x, double y, double w, double h) {
		// TODO Auto-generated constructor stub
		MainContainer mainContainer = MainContainer.getInstance();
		
		XRelative = x;
		YRelative = y;
		WidthOfWhole = w;
		HeightOfWhole = h;
		
		blocksRef = new JPanel[ROWS][COLUMN];
		
		setLayout(new GridLayout(ROWS, COLUMN, HGAP, VGAP));
		for(int i = 0; i < ROWS; i++){
			for(int j = 0; j < COLUMN; j++){
				blocksRef[i][j] = new JPanel();
				//blocksRef[i][j].setBackground(INIT_COLOR);
				blocksRef[i][j].setOpaque(false);
				
				this.add(blocksRef[i][j]);
			}
		}
		
		this.setBounds((int)(mainContainer.getInterWidth() * XRelative), 
				(int)(mainContainer.getInterHeight() * YRelative), 
				(int)(mainContainer.getInterWidth() * WidthOfWhole), 
				(int)(mainContainer.getInterHeight() * HeightOfWhole));
		
		this.setBorder(new EmptyBorder(-5, 0, -5, 0));
		this.setOpaque(false);
	}
	
	public void setBlockColorByCoordinates(int i, int j, Color color) {
		// TODO Auto-generated method stub
		if(color==null)
			this.blocksRef[i][j].setOpaque(false);
		else{
			this.blocksRef[i][j].setOpaque(true);
			blocksRef[i][j].setBackground(color);
		}
	}
}
