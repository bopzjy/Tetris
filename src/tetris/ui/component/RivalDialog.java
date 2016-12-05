package tetris.ui.component;

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
import tetris.ui.MainContainer;
import tetris.ui.single.MWidget;
import tetris.ui.single.TranslucenceJPanel;
import tetris.utils.ImageProcesser;

public class RivalDialog extends TranslucenceJPanel{
	private static float TRANSPARENCY = 0.9f;
	private static float HGAP_RATE = 0.035f;
	private static double[] list_shape = {0.25,0.145};
	public ArrowJpanel arrowJpanel;
	/*private static double[][] arrow_shape = {
		{0.3, 0.6},
			
	};*/
	
	private Rival4Dialog[] candidates;
	private JPanel candidatesJPanel;
	
	public RivalDialog(double[][] shape, ArrowJpanel arrowJpanel) {
		// TODO Auto-generated constructor stub
		super(shape);
		MainContainer mainContainer = MainContainer.getInstance();
		
		bgImage = ImageProcesser.imageScale(new ImageIcon("resources\\image\\rivaldialog_bg.png"),
				(int)(mainContainer.getInterWidth() * shape[1][0]),
				(int)(mainContainer.getInterHeight() * shape[1][1]));
		
		transparency = TRANSPARENCY;
		
		this.arrowJpanel = arrowJpanel;
		
		Player[] players = new Player[] {
			new Player("abc", 100),	
			new Player("1abc", 1200),
			new Player("32abc", 1340),
			new Player("abc3254", 1567),
			new Player("345abc23", 1890)
		};
		
		candidatesJPanel = new JPanel();
		initCandidatesList(players);
		
		candidatesJPanel = new JPanel();
		candidatesJPanel.setLocation((int)(this.getWidth() * list_shape[0]), (int)(this.getHeight() * list_shape[1]));
		candidatesJPanel.setSize(candidates[0].getWidth(), candidates[0].getHeight() * 5 + 4 * (int)(this.getHeight() * HGAP_RATE));

		GridLayout layout = new GridLayout(5, 1, 0, (int)(this.getHeight() * HGAP_RATE));
		candidatesJPanel.setLayout(layout);
		candidatesJPanel.setOpaque(false);
		
		//jPanel.add(candidates[0]);
		for (int i = 0; i < candidates.length; i++) {
			candidatesJPanel.add(candidates[i]);
		}
		
		this.setLayout(null);
		this.add(candidatesJPanel);
		this.addKeyListener(new MKeyAdapter());
		this.setVisible(false);
	}
	
	void initCandidatesList(Player[] players){
		if(players.length<=0)
			return;
		
		arrowJpanel.setMaxState(players.length);
		arrowJpanel.restoreArrow();
		candidatesJPanel.removeAll();
		candidates = new Rival4Dialog[players.length];
		for(int i = 0; i<players.length; i++){
			candidates[i] = new Rival4Dialog(players[i], this);
			candidatesJPanel.add(candidates[i]);
		}
		
	}
	
	class MKeyAdapter extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				System.out.println("hehedada");
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
