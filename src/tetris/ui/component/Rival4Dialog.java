package tetris.ui.component;

import java.awt.Component;
import java.util.jar.Attributes.Name;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.common.Player;
import tetris.game.logic.test;
import tetris.utils.LoadFont;

public class Rival4Dialog extends JPanel{
	private double[] shape = {0.6, 0.11};// width and height
	private JLabel name, credit;
	
	public Rival4Dialog(Component context) {
		
		this.setLayout(null);
		this.setBounds(0, 0, (int)(context.getWidth() * shape[0]), (int)(context.getHeight() * shape[1]));
		//this.setBackground(null);
		this.setBorder(new EmptyBorder(-5, 0, -5, 0));
		this.setOpaque(false);
		
		HeadPortrait headPortrait = new HeadPortrait(new double[][]{
			{0.15, 0.99},
			{0, 0}
		}, this);
		name = new JLabel();//(rival.getName());
		name.setBounds((int)(this.getWidth() * 0.12), 
				(int)(this.getHeight() * 0), 
				(int)(this.getWidth() * 0.55), 
				(int)(this.getHeight() * 0.99));
		name.setFont(LoadFont.loadDefaultFont());
		name.setHorizontalAlignment(JLabel.CENTER);
	
		credit = new JLabel();//(rival.getScore() + "");
		credit.setBounds((int)(this.getWidth() * 0.65), 
				(int)(this.getHeight() * 0), 
				(int)(this.getWidth() * 0.35), 
				(int)(this.getHeight() * 0.99));
		credit.setFont(LoadFont.loadDefaultFont());
		credit.setHorizontalAlignment(JLabel.CENTER);
		
		add(headPortrait);
		add(name);
		add(credit);

	}
	
	public void setPlayerNC(Player player){
		if(player==null){
			name.setText("");
			credit.setText("");
		}else{
			name.setText(player.getName());
			credit.setText(player.getScore() + "");
		}
	}
}
