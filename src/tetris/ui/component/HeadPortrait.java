package tetris.ui.component;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.ui.MainContainer;
import tetris.utils.ImageProcesser;

public class HeadPortrait extends JPanel{
	public HeadPortrait(double[][] shape, Component context) {
		// TODO Auto-generated constructor stub
		//context.getWidth()
		//MainContainer mainContainer = MainContainer.getInstance();
		ImageIcon headIcon = new ImageIcon("resources\\image\\cat.png");
		headIcon = ImageProcesser.imageScale(headIcon, 
				(int)(context.getWidth() * shape[0][0]), 
				(int)(context.getHeight() * shape[0][1]));
		
		add(new JLabel(headIcon));
		setOpaque(false);
		setBorder(new EmptyBorder(-5, 0, -5, 0));
		setBounds((int)(context.getWidth() * shape[1][0]), 
				(int)(context.getHeight() * shape[1][1]), 
				headIcon.getIconWidth(), headIcon.getIconHeight());
	}
}
