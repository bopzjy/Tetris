package tetris.common;

public class Player {
	private String name;
	private int score;
	public String ipaddress;
	
	public Player(String name, int score) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.score = score;
	}
	
	public Player(String name, int score, String ipaddress) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.score = score;
		this.ipaddress = ipaddress;
	}
	
	public String getName(){
		return name;
	}
	
	public int getScore(){
		return score;
	}
	
	public String getIpaddr(){
		return ipaddress;
	}
}
