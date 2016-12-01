package tetris.ui.activity;

import java.awt.Color;

import tetris.common.GlobalConstants;
import tetris.common.Player;
import tetris.ui.Activity;
import tetris.ui.MainContainer;
import tetris.ui.component.PlayerIcon;
import tetris.ui.single.BlocksPanel;

public class CompeteActivity extends Activity{
	
	private int LAYOUT_WIDGET = LAYOUT_BACKGROUND + 1;
	
	private PlayerIcon myHead, rivalHead;
	
	private BlocksPanel myBlocks, rivalBlocks; 
	private BlocksPanel nextPanel;
	
	public CompeteActivity() {
		super("resources\\image\\compete_bg.jpg");
		init();
	}
	
	protected void init() {
		MainContainer mainContainer = MainContainer.getInstance();
		
		myHead = new PlayerIcon(new double[][]{{0.075, 0.085}, {0.625, 0.075}}, new double[][]{{0.515, 0.14}, {0.3, 0.1}}, mainContainer);
		myHead.addedToContainer(jLayeredPane, LAYOUT_WIDGET);
		myHead.setFontSize(25);
		//myHead.setName("heheda");
		
		rivalHead = new PlayerIcon(new double[][]{{0.075, 0.085}, {0.795, 0.075}}, new double[][]{{0.685, 0.14}, {0.3, 0.1}}, mainContainer);
		rivalHead.addedToContainer(jLayeredPane, LAYOUT_WIDGET);
		rivalHead.setFontSize(25);
		//rivalHead.setName("heheda");
		
		myBlocks = new BlocksPanel(new double[][]{{0.12, 0.080},{0.406, 0.843}}, GlobalConstants.BLOCKSPANEL_INIT_COLOR, 
				GlobalConstants.NUMBER_OF_ROWS, GlobalConstants.NUMBER_OF_COLUMNS, 2);
		jLayeredPane.add(myBlocks, new Integer(LAYOUT_WIDGET));
		
		rivalBlocks = new BlocksPanel(new double[][]{{0.63303498779495524816924328722539, 0.409},{0.2479, 0.5138}}, GlobalConstants.BLOCKSPANEL_INIT_COLOR, 
				GlobalConstants.NUMBER_OF_ROWS, GlobalConstants.NUMBER_OF_COLUMNS, 2);
		jLayeredPane.add(rivalBlocks, new Integer(LAYOUT_WIDGET));
		
		nextPanel = new BlocksPanel(new double[][]{{0.735, 0.248}, {0.125, 0.125}}, null, 4, 5, 2);
		jLayeredPane.add(nextPanel, new Integer(LAYOUT_WIDGET));
		// Demo: print blocks
		
		nextPanel.setBlockColorByCoordinates(1, 2, Color.green);
		nextPanel.setBlockColorByCoordinates(2, 2, Color.green);
		nextPanel.setBlockColorByCoordinates(3, 2, Color.green);
		nextPanel.setBlockColorByCoordinates(0, 2, Color.green);
		
		
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
	
	public void setHead(Player[] players){
		myHead.setName(players[0].getName());
		rivalHead.setName(players[1].getName());
	}
	
	public static void main(String[] args) {
		new CompeteActivity();
	}
	
	
}
