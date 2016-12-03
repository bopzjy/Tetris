package tetris.net;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import tetris.common.GlobalConstants;

public class ServerManager {
	private static ServerManager instance = null;
	String username="";
	status state=status.offline;
	String url="rmi://"+GlobalConstants.SERVER_HOST+":"+String.valueOf(GlobalConstants.SERVER_PORT)+"/ServerImpl";
	String clientrmi="rmi://localhost:"+String.valueOf(GlobalConstants.CLIENT_PORT)+"/ClientImpl";
	ServerInterface server;
	sendState sendstatethread;
	ServerManager(){
		try {
			server=(ServerInterface)Naming.lookup(url);
			server.test();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void login(String username) throws RemoteException{
		server.login(username, clientrmi);
		this.username=username;
		state=status.online;
		sendstatethread=new sendState();
		sendstatethread.start();
		
	}
	
	public ArrayList<User> getTopPlayers() throws RemoteException{
		return server.getTopPlayers();
	}
	
	public void setState(status state){
		this.state=state;
	}
	
	public void logout() throws RemoteException{
		server.logout(username);
	}
	
	public User[] getOnlinePlayers() throws RemoteException{
		ArrayList<User> userarray=server.getOnlinePlayers();
		User []users=new User[userarray.size()];
		for(int i=0;i<userarray.size();i++)
			users[i]=userarray.get(i);
		return users;
	}
	
	public static ServerManager getInstance() {
		if (instance == null) {
			instance = new ServerManager();
		}
		return instance;
	}
	
	class sendState extends Thread{
		public void run(){
			while(true){
				try {
					server.setStatus(username, state);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
