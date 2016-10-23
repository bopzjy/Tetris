package tetris.ui.single;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tetris.common.GlobalConstants;
import tetris.ui.Constants;
import tetris.ui.MainContainer;
import tetris.utils.ImageProcesser;
import tetris.utils.LoadFont;

public class GameOverDialog extends TranslucenceJPanel{//extends JPanel{
	
	private double XRelative;
	private double YRelative;
	private double WidthOfWhole;
	private double HeightOfWhole;
	
	private double LEVEL_XRelative;
	private double LEVEL_YRelative;
	private double LEVEL_WidthOfWhole;
	private double LEVEL_HeightOfWhole;
	
	private double SCORE_XRelative;
	private double SCORE_YRelative;
	private double SCORE_WidthOfWhole;
	private double SCORE_HeightOfWhole;
			
	
	private JLabel level, score;
	
	private final static float TRANSPARENCY = 0.9f;
	
	public GameOverDialog(double x, double y, double w, double h, 
			double x1, double y1, double w1, double h1,
			double x2) {
		MainContainer mainContainer = MainContainer.getInstance();
		
		XRelative = x;
		YRelative = y;
		WidthOfWhole = w;
		HeightOfWhole = h;
		
		LEVEL_XRelative = x1;
		LEVEL_YRelative = y1;
		LEVEL_WidthOfWhole = w1;
		LEVEL_HeightOfWhole = h1;
		
		SCORE_XRelative = x2;
		SCORE_YRelative = y1;
		SCORE_WidthOfWhole = w1;
		SCORE_HeightOfWhole = w1;
		
		bgImage = ImageProcesser.imageScale(new ImageIcon("resources\\image\\gameover.png"),
				(int)(mainContainer.getInterWidth() * WidthOfWhole),
				(int)(mainContainer.getInterHeight() * HeightOfWhole));
		
		transparency = TRANSPARENCY;
		
		this.setBounds((int)(mainContainer.getInterWidth() * XRelative), 
				(int)(mainContainer.getInterHeight() * YRelative), 
				(int)(mainContainer.getInterWidth() * WidthOfWhole), 
				(int)(mainContainer.getInterHeight() * HeightOfWhole));	
		this.setLayout(null);
		
		level = new JLabel();
		level.setFont(LoadFont.loadFont("resources\\font\\font.ttf", GlobalConstants.FONT_SIZE));
		level.setText("12345");
		level.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel levelJPanel = new JPanel();
		levelJPanel.setOpaque(false);
		levelJPanel.setBounds((int)(this.getWidth() * LEVEL_XRelative),
				(int)(this.getHeight() * LEVEL_YRelative), 
				(int)(this.getWidth() * LEVEL_WidthOfWhole), 
				(int)(this.getHeight() * LEVEL_HeightOfWhole));
		levelJPanel.add(level);
		
		score = new JLabel();
		score.setFont(LoadFont.loadFont("resources\\font\\font.ttf", GlobalConstants.FONT_SIZE));
		score.setText("9876543");
		score.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel scoreJPanel = new JPanel();
		scoreJPanel.setOpaque(false);
		scoreJPanel.setBounds((int)(this.getWidth() * SCORE_XRelative),
				(int)(this.getHeight() * LEVEL_YRelative), 
				(int)(this.getWidth() * LEVEL_WidthOfWhole), 
				(int)(this.getHeight() * LEVEL_HeightOfWhole));
		scoreJPanel.add(score);
		
		this.add(levelJPanel);
		this.add(scoreJPanel);
		this.setVisible(false);
	}
	
	public void setLevelValue(String text){
		level.setText(text);
		
	}
	
}