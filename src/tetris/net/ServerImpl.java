package tetris.net;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6968375369107732749L;
	static ArrayList<User> onlineuser;

	protected ServerImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		onlineuser=new ArrayList<User>();
	}


	@Override
	public void test() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("this is server rmi test");
	}


	@Override
	public boolean login(String username,String localurl) {
		// TODO Auto-generated method stub
		//update the onlineuser ArrayList
		boolean notexisted=true;
		for(int i=0;i<onlineuser.size();i++){
			if(onlineuser.get(i).username.equals(username)){
				onlineuser.get(i).url=localurl;
				notexisted=false;
			}
		}
		if(notexisted){
			User user=new User();
			user.username=username;
			user.url=localurl;
			onlineuser.add(user);
		}
		//update the database
		return true;
	}

}
