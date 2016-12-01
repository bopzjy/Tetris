package tetris.ui.component;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import tetris.ui.MainContainer;
import tetris.utils.LoadFont;

public class PlayerIcon {
	private HeadPortrait headPortrait;
	private JLabel nameJLabel;
	//private Component context;
	
	public PlayerIcon(double[][] head_shape, double[][] name_shape, Component context) {
		// TODO Auto-generated constructor stub
		MainContainer mainContainer = MainContainer.getInstance();
		
		//this.context = context;
		
		headPortrait = new HeadPortrait(head_shape, context);
		
		nameJLabel = new JLabel();
		if(name_shape!=null){
			nameJLabel.setHorizontalAlignment(JLabel.CENTER);
			nameJLabel.setFont(LoadFont.loadDefaultFont());
			nameJLabel.setBounds((int)(context.getWidth() * name_shape[0][0]), 
					(int)(context.getHeight() * name_shape[0][1]), 
					(int)(context.getWidth() * name_shape[1][0]), 
					(int)(context.getHeight() * name_shape[1][1]));
		}
		
	}
	
	public void addedToContainer(JLayeredPane jLayeredPane, int layout){
		jLayeredPane.add(headPortrait, new Integer(layout));
		jLayeredPane.add(nameJLabel, new Integer(layout));
	}
	
	public void addedToContainer(JPanel container){
		container.add(headPortrait);
		container.add(nameJLabel);
	}
	
	public void show(){
		headPortrait.setVisible(true);
		nameJLabel.setVisible(true);
	}
	
	public void hide(){
		headPortrait.setVisible(false);
		nameJLabel.setVisible(false);
	}
	
	public void setName(String name){
		nameJLabel.setText(name);
	}
	
	public void setFontSize(float size){
		nameJLabel.setFont(LoadFont.loadFont(size));
	}
}
