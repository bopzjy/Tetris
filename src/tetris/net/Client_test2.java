package tetris.net;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Client_test2 {
	static ServerManager servermanager;
	static User[] playerlist;
	static ClientManager clientmanager;
	static ClientInterface clientinterface;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		servermanager=new ServerManager();
		clientmanager=new ClientManager();
		try {
			servermanager.login("daming");
			playerlist=servermanager.getOnlinePlayers();
			//clientmanager.buildVM();
			clientinterface=clientmanager.connect(playerlist[0].url);
			clientinterface.test("daming");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
