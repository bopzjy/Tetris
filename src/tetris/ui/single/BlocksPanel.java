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
	//private final double XRelative = 152.8/1229;
	private final double XRelative = 0.144;
	//private final double YRelative = 52.9/1024;
	private final double YRelative = 0.080;
	private final double WidthOfWhole = (652.1-152.8)/1229;
	private final double HeightOfWhole = (942.0 - 79)/1024;
	private final Color INIT_COLOR = Color.white;
	
	private JPanel[][] blocksRef;
	
	public BlocksPanel() {
		// TODO Auto-generated constructor stub
		MainContainer mainContainer = MainContainer.getInstance();
		
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
}
