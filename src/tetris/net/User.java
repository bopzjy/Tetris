package tetris.net;

public class User {
	public String username=null;
	public String url=null;
	public String score=null;
	public int rank=0;
	enum status{offline,online,battling};
	public status state=status.offline;
}
