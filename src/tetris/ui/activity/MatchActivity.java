package tetris.ui.activity;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import tetris.common.GlobalConstants;
import tetris.common.Player;
import tetris.ui.Activity;
import tetris.ui.MainContainer;
import tetris.ui.activity.LoginActivity.MAdapter;
import tetris.ui.component.ArrowJpanel;
import tetris.ui.component.HeadPortrait;
import tetris.ui.component.RegisterDialog;
import tetris.ui.component.RivalDialog;
import tetris.ui.single.MWidget;
import tetris.utils.LoadFont;

public class MatchActivity extends Activity{
	
	private final int LAYOUT_ADDUSER = LAYOUT_BACKGROUND + 1;
	private final int LAYOUT_RIVALDIALOG = LAYOUT_ADDUSER + 1;
	private final int LAYOUT_DIALOGARROW = LAYOUT_RIVALDIALOG + 1;
	private final int LAYOUT_BIG_HEAD = LAYOUT_DIALOGARROW + 1;
	private final int LAYOUT_SMALL_HEAD = LAYOUT_BIG_HEAD + 1;
	
	private RivalDialog rivalDialog;
	private ArrowJpanel dialogArrow;
	private HeadPortrait big, small;
	private HeadPortrait rivalHead;
	private JLabel meLabel, rivalLabel;
	private static double[][] arrow_shape = {
			{0.05, 0.0563},		
			{0.27, 0.43},
			{0.27, 0.515},
			{0.27, 0.6},
			{0.27, 0.685},
			{0.27, 0.77}	
	};
	public MatchActivity() {
		// TODO Auto-generated constructor stub
		super("resources\\image\\match_bg.jpg");
		init();
	}
	
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		
		MainContainer mainContainer = MainContainer.getInstance();
		
		MWidget adduser = new MWidget(new double[][]{
			{0.59, 0.51},
			{0.12, 0.15}
		});
		adduser.setOpaque(false);
		adduser.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				mainContainer.setCursor(new Cursor(Cursor.HAND_CURSOR ));
			}
			
			public void mouseExited(MouseEvent e){
				mainContainer.setCursor(new Cursor(Cursor.DEFAULT_CURSOR ));
			}
			
			public void mouseClicked(MouseEvent e) {
				System.out.println("clicked");
			}
		});
		jLayeredPane.add(adduser, new Integer(LAYOUT_ADDUSER));
		
		big = new HeadPortrait(new double[][]{{0.15, 0.15}, {0.275, 0.49} }, mainContainer);
		jLayeredPane.add(big, new Integer(LAYOUT_BIG_HEAD));
		small = new HeadPortrait(new double[][]{{0.08, 0.08}, {0.735, 0.155} }, mainContainer);
		jLayeredPane.add(small, new Integer(LAYOUT_SMALL_HEAD));
		rivalHead = new HeadPortrait(new double[][]{{0.15, 0.15}, {0.575, 0.49} }, mainContainer);
		jLayeredPane.add(rivalHead, new Integer(LAYOUT_SMALL_HEAD));
		
		meLabel = new JLabel();
		//meLabel.setText("heheda");
		meLabel.setHorizontalAlignment(JLabel.CENTER);
		meLabel.setBounds((int)(mainContainer.getInterWidth() * 0.205), 
				(int)(mainContainer.getInterHeight() * 0.55), 
				(int)(mainContainer.getInterWidth() * 0.3), (int)(mainContainer.getInterHeight() * 0.3));
		meLabel.setFont(LoadFont.loadDefaultFont());
		jLayeredPane.add(meLabel, new Integer(LAYOUT_BIG_HEAD));
		
		rivalLabel = new JLabel();
		//rivalLabel.setText("heheda");
		rivalLabel.setHorizontalAlignment(JLabel.CENTER);
		rivalLabel.setFont(LoadFont.loadDefaultFont());
		rivalLabel.setBounds((int)(mainContainer.getInterWidth() * 0.505), 
				(int)(mainContainer.getInterHeight() * 0.55), 
				(int)(mainContainer.getInterWidth() * 0.3), (int)(mainContainer.getInterHeight() * 0.3));
		jLayeredPane.add(rivalLabel, new Integer(LAYOUT_SMALL_HEAD));
		
		dialogArrow = new ArrowJpanel(arrow_shape, 5);
		rivalDialog = new RivalDialog(new double[][]{
			{0.20, 0.34},
			{0.61, 0.58}
		}, dialogArrow);
		jLayeredPane.add(rivalDialog, new Integer(LAYOUT_RIVALDIALOG));
		jLayeredPane.add(dialogArrow, new Integer(LAYOUT_DIALOGARROW));
		
		//keyAdapter = new MAdapter();
		//mainContainer.setKeyBoardAdapter(keyAdapter);
		
		mainContainer.getContentPane().add(jLayeredPane);		
		mainContainer.validate();
		
		hideRivalDialog();
		//showRivalDialog();
		hideRival();
		//showRival(new Player("abdsff", 100));
		
	}

	@Override
	public void RestoreUI() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void InitUI() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new MatchActivity();
	}
	
	public void showRivalDialog(){
		rivalDialog.setVisible(true);
		rivalDialog.requestFocusInWindow();
		dialogArrow.setVisible(true);
	}
	
	public void hideRivalDialog(){
		rivalDialog.setVisible(false);
		dialogArrow.setVisible(false);
	}
	
	public void showMe(Player me){
		this.meLabel.setText(me.getName());
	}
	
	public void showRival(Player rival){
		rivalLabel.setText(rival.getName());
		rivalLabel.setVisible(true);
		rivalHead.setVisible(true);
	}
	
	public void hideRival(){
		rivalLabel.setVisible(false);
		rivalHead.setVisible(false);
	}
}
