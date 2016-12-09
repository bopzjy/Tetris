package tetris.common;

public class Player implements Comparable<Player>{
	private String name;
	private int score;
	
	public Player(String name, int score) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.score = score;
	}
	
	public String getName(){
		return name;
	}
	
	public int getScore(){
		return score;
	}

	@Override
	public int compareTo(Player player) {
		//return this.score - player.getScore();
		return player.getScore() - this.score;
	}
	
	public void setScore(int score){
		this.score = score;
	}
}
