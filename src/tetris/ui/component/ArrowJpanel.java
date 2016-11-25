package tetris.ui.component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.ui.MainContainer;
import tetris.utils.ImageProcesser;

public class ArrowJpanel extends JPanel{
	
	/*
	 * location:
	 * 	size
	 * 	location
	 */
	
	private int state;
	private double location[][];
	
	public ArrowJpanel(double[][] shape){
		this.location = shape;
		MainContainer mainContainer = MainContainer.getInstance();
		ImageIcon arrowIcon = new ImageIcon("resources\\image\\arrow.png");
		arrowIcon = ImageProcesser.imageScale(arrowIcon, 
				(int)(mainContainer.getInterWidth() * shape[0][0]), 
				(int)(mainContainer.getInterHeight() * shape[0][1]));
		
		add(new JLabel(arrowIcon));
		setOpaque(false);
		setBorder(new EmptyBorder(-5, 0, -5, 0));
		setBounds((int)(mainContainer.getInterWidth() * location[1][0]), 
				(int)(mainContainer.getInterHeight() * location[1][1]), 
				arrowIcon.getIconWidth(), arrowIcon.getIconHeight());
		
		state = 1;
	}
	
	public void lastState(){
		if(state>1){
			MainContainer mainContainer = MainContainer.getInstance();
			state--;
			setLocation((int)(mainContainer.getInterWidth() * location[state][0]),
					(int)(mainContainer.getInterHeight() * location[state][1]));		
		}
	}
	
	public void nextState(){
		if(state<location.length-1){
			MainContainer mainContainer = MainContainer.getInstance();
			state++;
			setLocation((int)(mainContainer.getInterWidth() * location[state][0]),
					(int)(mainContainer.getInterHeight() * location[state][1]));		
		}
	}
	
	public int getState(){
		return state-1;
	}
	
}
