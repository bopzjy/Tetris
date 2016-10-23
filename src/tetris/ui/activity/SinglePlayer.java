package tetris.ui.activity;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import tetris.common.GlobalConstants;
import tetris.ui.Activity;
import tetris.ui.ActivityHolder;
import tetris.ui.MainContainer;
import tetris.ui.activity.RankLister.MAdapter;
import tetris.ui.single.BlocksPanel;
import tetris.ui.single.NameDialog;
import tetris.ui.single.SetBlockColor;
import tetris.ui.single.TranslucenceJPanel;
import tetris.ui.single.Translucent;
import tetris.ui.single.TypeName;
import tetris.utils.ImageProcesser;
import tetris.utils.LoadFont;

public class SinglePlayer extends Activity implements SetBlockColor,TypeName{
	
	private final int LAYOUT_BACKGROUND = 0;
	private final int LAYOUT_BLOCKSPANEL = LAYOUT_BACKGROUND + 1;
	private final int LAYOUT_NAMEDIALOG = LAYOUT_BLOCKSPANEL + 1;
	
	private final double XRelative = 150.0/1229;
	private final double YRelative = 330.0/1024;
	private final double WidthOfWhole = (1075.0 - 150)/1229;
	private final double HeightOfWhole = (635.0 - 330)/1024;
	
	private BlocksPanel blocksPanel;
	
	private NameDialog nameDialog;
	private JTextField nameTextField;
	//private  
	
	public SinglePlayer() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		MainContainer mainContainer = MainContainer.getInstance();
		
		ImageIcon bgImage = ImageProcesser.imageScale(new ImageIcon("resources\\image\\single_bg.jpg"),
				mainContainer.getInterWidth(),
				mainContainer.getInterHeight());
		
		jLayeredPane = new JLayeredPane();
		JPanel bgPanel = new JPanel();
		
		bgPanel.setBounds(0, 0, mainContainer.getInterWidth(), mainContainer.getInterHeight());
		bgPanel.add(new JLabel(bgImage));
		bgPanel.setBorder(new EmptyBorder(-5, 0, -5, 0));
		jLayeredPane.add(bgPanel, LAYOUT_BACKGROUND);
		
		blocksPanel = new BlocksPanel(GlobalConstants.SINGLE_BLOCKSPANEL_XRelative, GlobalConstants.SINGLE_BLOCKSPANEL_YRelative,
				GlobalConstants.SINGLE_BLOCKSPANEL_WidthOfWhole, GlobalConstants.SINGLE_BLOCKSPANEL_HeightOfWhole);
		jLayeredPane.add(blocksPanel, new Integer(LAYOUT_BLOCKSPANEL));
		//blocksPanel.setBlockColorByCoordinates(5, 5, Color.yellow);
		
		nameDialog = new NameDialog(GlobalConstants.SINGLE_NAMEDIALOG_XRelative, GlobalConstants.SINGLE_NAMEDIALOG_YRelative,
				GlobalConstants.SINGLE_NAMEDIALOG_WidthOfWhole, GlobalConstants.SINGLE_NAMEDIALOG_HeightOfWhole,
				GlobalConstants.SINGLE_NAMEDIALOG_TF_XRelative, GlobalConstants.SINGLE_NAMEDIALOG_TF_YRelative,
				GlobalConstants.SINGLE_NAMEDIALOG_TF_WidthOfWhole, GlobalConstants.SINGLE_NAMEDIALOG_TF_HeightOfWhole);
		jLayeredPane.add(nameDialog, new Integer(LAYOUT_NAMEDIALOG));
		showNameDialog();	
		
		keyAdapter = new MAdapter();
		mainContainer.setKeyBoardAdapter(keyAdapter);
		
		mainContainer.setLayeredPane(jLayeredPane);
		mainContainer.validate();
	}
	
	public static void main(String[] args) {
		new SinglePlayer();
	}
	
	
	@Override
	public void RestoreUI() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void InitUI() {
		// TODO Auto-generated method stub
		MainContainer mainContainer = MainContainer.getInstance();
		
		blocksPanel.clearPanel();
		
		mainContainer.setKeyBoardAdapter(keyAdapter);
		mainContainer.setLayeredPane(jLayeredPane);
		mainContainer.repaint();
	}
	
	public void setKeyListener() {
		if(keyAdapter==null)
			keyAdapter = new MAdapter();
		MainContainer.getInstance().setKeyBoardAdapter(keyAdapter);
	}
	
	class MAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) { 
			// TODO Auto-generated method stub
			ActivityHolder activityHolder = ActivityHolder.getInstance();
			super.keyPressed(e);
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				System.out.println("esc");
				activityHolder.turnToLastActivity();			
				break;
				
			case KeyEvent.VK_Q:
				//showNameDialog();
				getNameText();
				break;
				
			//case KeyEvent.VK_ENTER:
				
			default:
				break;
			}
		}
	}

	@Override
	public void showNameDialog() {
		// TODO Auto-generated method stub
		nameDialog.setVisible(true);
	}

	@Override
	public void setBlockColorByCoordinates(int i, int j, Color color) {
		// TODO Auto-generated method stub
		blocksPanel.setBlockColorByCoordinates(5, 5, Color.yellow);
	}

	@Override
	public String getNameText() {
		// TODO Auto-generated method stub
		System.out.println(nameDialog.getTextFieldValue());
		return nameDialog.getTextFieldValue();
		//return null;
	}
}
