package tetris.ui.single;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.common.GlobalConstants;
import tetris.ui.MainContainer;

public class BlocksPanel extends JPanel implements SetBlockColor{
	
	private final int HGAP = 2;
	private final int VGAP = 2;

	private final Color INIT_COLOR = Color.white;
	
	private double XRelative = 0.144;
	private double YRelative = 0.080;
	private double WidthOfWhole = (652.1-152.8)/1229;
	private double HeightOfWhole = (942.0 - 79)/1024;
	
	private JPanel[][] blocksRef;
	
	public BlocksPanel(double x, double y, double w, double h) {
		// TODO Auto-generated constructor stub
		MainContainer mainContainer = MainContainer.getInstance();
		
		XRelative = x;
		YRelative = y;
		WidthOfWhole = w;
		HeightOfWhole = h;
		
		blocksRef = new JPanel[GlobalConstants.NUMBER_OF_ROWS][GlobalConstants.NUMBER_OF_COLUMNS];
		
		setLayout(new GridLayout(GlobalConstants.NUMBER_OF_ROWS, GlobalConstants.NUMBER_OF_COLUMNS, HGAP, VGAP));
		for(int i = 0; i < GlobalConstants.NUMBER_OF_ROWS; i++){
			for(int j = 0; j < GlobalConstants.NUMBER_OF_COLUMNS; j++){
				blocksRef[i][j] = new JPanel();
				blocksRef[i][j].setBackground(INIT_COLOR);
				
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

	@Override
	public void setBlockColorByCoordinates(int i, int j, Color color) {
		// TODO Auto-generated method stub
		blocksRef[i][j].setBackground(color);
	}
	
	public void clearPanel(){
		for(int i = 0; i < GlobalConstants.NUMBER_OF_ROWS; i++){
			for(int j = 0; j < GlobalConstants.NUMBER_OF_COLUMNS; j++){
				blocksRef[i][j].setBackground(INIT_COLOR);
			}
		}
	}
	
	public void setScale(){
		
	}

}
