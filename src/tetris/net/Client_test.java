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
			boolean a=servermanager.register("xiaoming","123456");
			boolean b=servermanager.login("xiaoming","123456");
			if(a)
				System.out.println("a=true");
			if(b)
				System.out.println("b=true");
			playerlist=servermanager.getOnlinePlayers();
			clientmanager.buildVM();
			//servermanager.disconnect();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
