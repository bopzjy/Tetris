package tetris.ui;

import java.awt.event.KeyAdapter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.utils.ImageProcesser;

public abstract class Activity implements ChangeUI {
	protected JLayeredPane jLayeredPane;
	protected KeyAdapter  keyAdapter;

	protected abstract void init();
	
	protected final int LAYOUT_BACKGROUND = 0;
	
	public Activity(String path) {
	
		MainContainer mainContainer = MainContainer.getInstance();
		
		jLayeredPane = new JLayeredPane();
		
		ImageIcon bgImage = ImageProcesser.imageScale(new ImageIcon(path),
				mainContainer.getInterWidth(),
				mainContainer.getInterHeight());
		
		JPanel bgPanel = new JPanel();
		bgPanel.setBounds(0, 0, mainContainer.getInterWidth(), mainContainer.getInterHeight());
		bgPanel.add(new JLabel(bgImage));
		bgPanel.setBorder(new EmptyBorder(-5, 0, -5, 0));
		jLayeredPane.add(bgPanel, new Integer(LAYOUT_BACKGROUND));
	}
}
