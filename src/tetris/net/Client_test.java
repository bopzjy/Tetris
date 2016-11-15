package tetris.net;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Client_test {
	static ServerManager servermanager;
	static User[] playerlist;
	static ClientManager clientmanager;
	ClientInterface clientinterface;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		servermanager=new ServerManager();
		clientmanager=new ClientManager();
		try {
			servermanager.login("xiaoming");
			playerlist=servermanager.getOnlinePlayers();
			clientmanager.buildVM();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
