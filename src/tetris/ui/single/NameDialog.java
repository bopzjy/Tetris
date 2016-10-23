package tetris.ui.single;

import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tetris.common.GlobalConstants;
import tetris.ui.Constants;
import tetris.ui.MainContainer;
import tetris.utils.ImageProcesser;
import tetris.utils.LoadFont;

public class NameDialog extends TranslucenceJPanel{//extends JPanel{
	
	private double XRelative = 150.0/1229;
	private double YRelative = 330.0/1024;
	private double WidthOfWhole = (1075.0 - 150)/1229;
	private double HeightOfWhole = (635.0 - 330)/1024;
	
	private double TEXTFIELD_XRelative = 0.45;
	private double TEXTFIELD_YRelative = 0.37;
	private double TEXTFIELD_WidthOfWhole = 0.3623188405797101;
	private double TEXTFIELD_HeightOfWhole = 0.23;
			
	
	private JTextField nameTextField;
	
	private final static float TRANSPARENCY = 0.9f;
	
	public NameDialog(double x, double y, double w, double h, 
			double x1, double y1, double w1, double h1) {
		MainContainer mainContainer = MainContainer.getInstance();
		
		XRelative = x;
		YRelative = y;
		WidthOfWhole = w;
		HeightOfWhole = h;
		
		TEXTFIELD_XRelative = x1;
		TEXTFIELD_YRelative = y1;
		TEXTFIELD_WidthOfWhole = w1;
		TEXTFIELD_HeightOfWhole = h1;
		
		bgImage = ImageProcesser.imageScale(new ImageIcon("resources\\image\\type_name.png"),
				(int)(mainContainer.getInterWidth() * WidthOfWhole),
				(int)(mainContainer.getInterHeight() * HeightOfWhole));
		
		transparency = TRANSPARENCY;
		background = ImageProcesser.toBufferedImage(bgImage.getImage());
		
		//Translucent bg =  new Translucent();
		//bg.setBGTranslucent(bgImage, TRANSPARENCY);
		//this.setImage(bgImage.getImage());
		
		this.setBounds((int)(mainContainer.getInterWidth() * XRelative), 
				(int)(mainContainer.getInterHeight() * YRelative), 
				(int)(mainContainer.getInterWidth() * WidthOfWhole), 
				(int)(mainContainer.getInterHeight() * HeightOfWhole));
		
		this.setLayout(null);
		nameTextField = new JTextField(8);
		nameTextField.setBackground(null);
		nameTextField.setOpaque(false);
		nameTextField.setFont(LoadFont.loadFont("resources\\font\\font.ttf", GlobalConstants.FONT_SIZE));
		nameTextField.setBounds((int)(this.getWidth() * TEXTFIELD_XRelative),
				(int)(this.getHeight() * TEXTFIELD_YRelative), 
				(int)(this.getWidth() * TEXTFIELD_WidthOfWhole), 
				(int)(this.getHeight() * TEXTFIELD_HeightOfWhole));
		
		//System.out.println((int)(this.getWidth() * TEXTFIELD_WidthOfWhole) * (int)(this.getHeight() * TEXTFIELD_HeightOfWhole));
		//nameTextField.setText("niMAei");
		nameTextField.setBorder(null);
		this.add(nameTextField);

		this.setVisible(false);
	}
	
	public String getTextFieldValue(){
		return nameTextField.getText();
	}
	
}
