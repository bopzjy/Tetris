package tetris.ui.activity;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import tetris.common.GlobalConstants;
import tetris.ui.Activity;
import tetris.ui.MainContainer;
import tetris.ui.activity.LoginActivity.MAdapter;
import tetris.ui.component.ArrowJpanel;
import tetris.ui.component.RegisterDialog;
import tetris.ui.component.RivalDialog;
import tetris.ui.single.MWidget;

public class MatchActivity extends Activity{
	
	private final int LAYOUT_ADDUSER = LAYOUT_BACKGROUND + 1;
	private final int LAYOUT_RIVALDIALOG = LAYOUT_ADDUSER + 1;
	private final int LAYOUT_DIALOGARROW = LAYOUT_RIVALDIALOG + 1;
	
	private RivalDialog rivalDialog;
	private ArrowJpanel dialogArrow;
	private static double[][] arrow_shape = {
			{0.05, 0.0563},		
			{0.27, 0.43},
			{0.27, 0.515},
			{0.27, 0.6},
			{0.27, 0.685},
			{0.27, 0.77}
		//{},	
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

}
