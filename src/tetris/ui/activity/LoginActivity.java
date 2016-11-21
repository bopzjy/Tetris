package tetris.ui.activity;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.ui.Activity;
import tetris.ui.ActivityHolder;
import tetris.ui.Constants;
import tetris.ui.MainContainer;
import tetris.utils.ImageProcesser;

public class LoginActivity extends Activity{
	
	private final int LAYOUT_BACKGROUND = 0;

	private final double arrow_widthOfBG = 0.050;//4.72/120;
	private final double arrow_heightOfBG = 0.0563;
	private final double arrow_xRelative[] = {0.14, 0.45};
	private final double arrow_yRelative = 0.748;
	
	private JPanel arrow;
	private int arrow_state;// = 0;
	private final int CHOOSE_1 = 0;
	private final int CHOOSE_2 = 1;
	
	public LoginActivity() {
		// TODO Auto-generated constructor stub
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		MainContainer mainContainer = MainContainer.getInstance();
		
		ImageIcon bgImage = ImageProcesser.imageScale(new ImageIcon("resources\\image\\login_bg.jpg"),//, 1101,918);
				mainContainer.getInterWidth(),
				mainContainer.getInterHeight());
		
		jLayeredPane = new JLayeredPane();
		JPanel bgPanel = new JPanel();
		
		bgPanel.setBounds(0, 0, mainContainer.getInterWidth(), mainContainer.getInterHeight());
		bgPanel.add(new JLabel(bgImage));
		bgPanel.setBorder(new EmptyBorder(-5, 0, -5, 0));
		jLayeredPane.add(bgPanel, new Integer(LAYOUT_BACKGROUND));	
		
		mainContainer.getContentPane().add(jLayeredPane);		
		mainContainer.validate();
		
		ActivityHolder.getInstance().turnToNextActivity(Constants.INDEX_BEGIN_ACTIVITY);
	}


	public void setKeyListener() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		//System.out.println("nimei");
		new LoadActivity();
		
	}

	@Override
	public void RestoreUI() {
		// TODO Auto-generated method stub
	}

	@Override
	public void InitUI() {
		// TODO Auto-generated method stub

	}
}
