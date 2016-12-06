package tetris.net;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -369278961792783423L;
	public String username=null;
	public String password=null;
	public String url=null;
	public int score=0;
	public int rank=0;
	public int timeleft=10;
	public status state=status.offline;
}
