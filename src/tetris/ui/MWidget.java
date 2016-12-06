package tetris.ui;

import javax.swing.JPanel;


public class MWidget extends JPanel{
	
	public MWidget(double shape[][]) {
		MainContainer mainContainer = MainContainer.getInstance();
		setBounds((int)(mainContainer.getInterWidth() * shape[0][0]), 
				(int)(mainContainer.getInterHeight() * shape[0][1]), 
				(int)(mainContainer.getInterWidth() * shape[1][0]), 
				(int)(mainContainer.getInterHeight() * shape[1][1]));
	}
		
}
