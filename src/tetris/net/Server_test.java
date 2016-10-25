package tetris.net;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

public class Server_test {
	static ServerImpl server;
	static String url="rmi://localhost:9999/";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
	}
	static void init(){
		try {
			server=new ServerImpl();
			LocateRegistry.createRegistry(9999);
			Naming.rebind(url+"ServerImpl", server);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
