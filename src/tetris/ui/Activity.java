package tetris.ui;

import java.awt.event.KeyAdapter;

import javax.swing.JLayeredPane;

public abstract class Activity implements ChangeUI {
	protected JLayeredPane jLayeredPane;
	protected KeyAdapter  keyAdapter;
	protected abstract void init();
	/*protected void setKeyListener(){
		if(keyAdapter==null)
			keyAdapter = new MAdapter();
		MainContainer.getInstance().setKeyBoardAdapter(keyAdapter);
	};
	protected abstract class MAdapter{};*/
}
