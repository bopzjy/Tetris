package tetris.ui.dialog;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import tetris.common.Player;
import tetris.game.logic.rivalKeyAdapter;
import tetris.ui.MWidget;
import tetris.ui.MainContainer;
import tetris.ui.TranslucenceJPanel;
import tetris.ui.component.ArrowJpanel;
import tetris.ui.component.Rival4Dialog;
import tetris.utils.ImageProcesser;

public class RivalDialog extends TranslucenceJPanel{
	private static float HGAP_RATE = 0.035f;
	private static double[] list_shape = {0.25,0.145};
	private static int MAX_RIVAL = 5;
	
	public ArrowJpanel arrowJpanel;
	private Rival4Dialog[] candidates;
	private JPanel candidatesJPanel;
	
	public RivalDialog(double[][] shape, ArrowJpanel arrowJpanel) {
		// TODO Auto-generated constructor stub
		super(shape);
		MainContainer mainContainer = MainContainer.getInstance();
		
		setBackGroud("resources\\image\\rivaldialog_bg.png");
		
		this.arrowJpanel = arrowJpanel;
		
		candidates = new Rival4Dialog[MAX_RIVAL];
		for(int i = 0; i<MAX_RIVAL; i++)
			candidates[i] = new Rival4Dialog(this);
		
		candidatesJPanel = new JPanel();
		candidatesJPanel.setLocation((int)(this.getWidth() * list_shape[0]), (int)(this.getHeight() * list_shape[1]));
		candidatesJPanel.setSize(candidates[0].getWidth(), candidates[0].getHeight() * 5 + 4 * (int)(this.getHeight() * HGAP_RATE));

		GridLayout layout = new GridLayout(5, 1, 0, (int)(this.getHeight() * HGAP_RATE));
		candidatesJPanel.setLayout(layout);
		candidatesJPanel.setOpaque(false);

		for (int i = 0; i < MAX_RIVAL; i++) 
			candidatesJPanel.add(candidates[i]);
		
		this.setLayout(null);
		this.add(candidatesJPanel);
		this.addKeyListener(new rivalKeyAdapter());
		this.setVisible(false);
	}
	
	public void setCandidatesList(Player[] players){
		if(players.length<=0)
			return;
		
		arrowJpanel.setMaxState(players.length);
		arrowJpanel.restoreArrow();
		
		for(int i = 0; i<players.length; i++)
			candidates[i].setPlayerNC(players[i]);
		for(int i = players.length; i<MAX_RIVAL; i++)
			candidates[i].setPlayerNC(null);
		
	}
	
	class MKeyAdapter extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				arrowJpanel.lastState();
				break;
				
			case KeyEvent.VK_DOWN:
				arrowJpanel.nextState();
				break;

			default:
				break;
			}
		}
	}
}
