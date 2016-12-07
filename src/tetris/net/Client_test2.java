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
			servermanager.register("daming","123456");
			servermanager.login("daming","123456");
			playerlist=servermanager.getOnlinePlayers();
			clientmanager.set_RMI_URL(2222);
			clientmanager.buildVM();
			System.out.println(playerlist[0].url);
			clientinterface=clientmanager.connect(playerlist[0].url);
			clientinterface=clientmanager.connect(playerlist[0].url);
			System.out.println(clientinterface.test("daming"));
			
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
