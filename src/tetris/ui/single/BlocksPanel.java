package tetris.ui.single;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.common.GlobalConstants;
import tetris.ui.MWidget;

public class BlocksPanel extends MWidget {
	
	/*private int HGAP = 2;
	private int VGAP = 2;*/
	
	private JPanel[][] blocksRef;
	private Color initColor = null;
	
	/*public BlocksPanel(double[][] shape, Color initColor, int rows, int columns,int gap){
		//super();
		this.HGAP = this.VGAP = gap;
		this(shape, initColor, rows, columns);
	}*/
	
	public BlocksPanel(double[][] shape, Color initColor, int rows, int columns, int gap) {
		// TODO Auto-generated constructor stub
		super(shape);
		this.initColor = initColor;
		blocksRef = new JPanel[rows][columns];
		
		setLayout(new GridLayout(rows, columns, gap, gap));
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				blocksRef[i][j] = new JPanel();
				//blocksRef[i][j].setBackground(initColor);
				setBlockColorByCoordinates(i,j,initColor);
				
				this.add(blocksRef[i][j]);
			}
		}
		
		//clearPanel();
		this.setBorder(new EmptyBorder(-5, 0, -5, 0));
		this.setOpaque(false);
	}

	public void setBlockColorByCoordinates(int i, int j, Color color) {
		// TODO Auto-generated method stub
		blocksRef[i][j].setBackground(color);
		if(color==null)
			blocksRef[i][j].setOpaque(false);
		else{
			blocksRef[i][j].setOpaque(true);
			blocksRef[i][j].setBackground(color);
		}
	}
	
	public void clearPanel(){
		for(int i = 0; i < GlobalConstants.NUMBER_OF_ROWS; i++){
			for(int j = 0; j < GlobalConstants.NUMBER_OF_COLUMNS; j++){
				//blocksRef[i][j].setBackground(initColor);
				setBlockColorByCoordinates(i,j,initColor);
			}
		}
	}
	
}
