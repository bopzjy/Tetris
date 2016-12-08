package tetris.ui.component;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.common.GlobalConstants;
import tetris.ui.MWidget;
import tetris.ui.MainContainer;
import tetris.utils.LoadFont;

public class DataPanel extends MWidget{
	private JLabel data;
	
	public DataPanel(double[][] shape) {
		// TODO Auto-generated constructor stub
		super(shape);
		
		this.setBorder(new EmptyBorder(-5, 0, -5, 0));
		this.setOpaque(false);
		
		//this.setBackground(Color.blue);
		data = new JLabel();
		this.add(data);
		data.setFont(LoadFont.loadFont("resources\\font\\font.ttf", GlobalConstants.FONT_SIZE));
		data.setHorizontalAlignment(JLabel.CENTER);
		
		//this.setVisible(false);
		//test
		//setGameData("12345");	
	}
	
	public int getGameData(){
		return Integer.parseInt(data.getText().trim());
	}
	
	public void setGameData(String text){
		data.setText(text);
	}
}
