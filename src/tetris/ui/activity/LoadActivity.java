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
import tetris.ui.activity.BeginActivity.MAdapter;
import tetris.utils.ImageProcesser;

public class LoadActivity extends Activity{
	
	private final int LAYOUT_BACKGROUND = 0;
	
	public LoadActivity() {
		// TODO Auto-generated constructor stub
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		MainContainer mainContainer = MainContainer.getInstance();
		
		ImageIcon bgImage = ImageProcesser.imageScale(new ImageIcon("resources\\image\\load_bg.jpg"),//, 1101,918);
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
		
		/*try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
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
