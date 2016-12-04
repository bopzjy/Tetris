package tetris.ui.Interface;

public interface IGameOverDialog {
	public void showGameOverDialog();
	public void hideGameOverDialog();
	
	public void setLevelInDialog(String text);
	public void setScoreInDialog(String text);
}
