package tetris.ui.component;

import java.awt.Component;

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
	private int max_state;
	private double location[][];
	private Component context;
	
	/*public ArrowJpanel(double[][] shape, int max_state){
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
		this.max_state = max_state;
	}*/
	
	public ArrowJpanel(double[][] shape, int max_state, Component context){
		this.location = shape;
		ImageIcon arrowIcon = new ImageIcon("resources\\image\\arrow.png");
		arrowIcon = ImageProcesser.imageScale(arrowIcon, (int)(context.getWidth() * shape[0][0]), (int)(context.getHeight() * shape[0][1]));
		
		add(new JLabel(arrowIcon));
		setOpaque(false);
		setBorder(new EmptyBorder(-5, 0, -5, 0));
		setBounds((int)(context.getWidth() * location[1][0]), (int)(context.getHeight() * location[1][1]), 
				arrowIcon.getIconWidth(), arrowIcon.getIconHeight());
		
		state = 1;
		this.max_state = max_state;
		this.context = context;
	}
	
	public void lastState(){
		if(state>1){
			state--;
			setLocation((int)(context.getWidth() * location[state][0]), (int)(context.getHeight() * location[state][1]));		
		}
	}
	
	public void nextState(){
		if(state<max_state){
			state++;
			setLocation((int)(context.getWidth() * location[state][0]), (int)(context.getHeight() * location[state][1]));		
		}
	}
	
	public int getState(){
		return state;
	}
	
	public void setMaxState(int max){
		this.max_state = max;
	}
	
	public void restoreArrow(){
		state = 1;
		MainContainer mainContainer = MainContainer.getInstance();
		setLocation((int)(mainContainer.getInterWidth() * location[1][0]),
				(int)(mainContainer.getInterHeight() * location[1][1]));		
	
	}
}
