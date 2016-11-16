package tetris.ui.single;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.common.GlobalConstants;
import tetris.ui.MainContainer;
import tetris.utils.LoadFont;

public class DataPanel extends JPanel{
	private JLabel data;
	
	private double XRelative;
	private double YRelative;
	private double WidthOfWhole;
	private double HeightOfWhole;
	
	public DataPanel(double x, double y, double w, double h) {
		// TODO Auto-generated constructor stub
		MainContainer mainContainer = MainContainer.getInstance();
		
		XRelative = x;
		YRelative = y;
		WidthOfWhole = w;
		HeightOfWhole = h;
		//this.setLayout(mgr);
		this.setBounds((int)(mainContainer.getInterWidth() * XRelative), 
				(int)(mainContainer.getInterHeight() * YRelative), 
				(int)(mainContainer.getInterWidth() * WidthOfWhole), 
				(int)(mainContainer.getInterHeight() * HeightOfWhole));
		this.setBorder(new EmptyBorder(-5, 0, -5, 0));
		this.setOpaque(false);
		
		this.setBackground(Color.blue);
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
