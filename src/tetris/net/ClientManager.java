package tetris.net;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ClientManager {
	public String url="rmi://localhost:1111/ClientImpl";
	Registry registry;
	public ClientManager(){
		
	}
	public ClientInterface connect(String url) 
			throws MalformedURLException, RemoteException, NotBoundException{
		return (ClientInterface)Naming.lookup(url);
	}
	public void buildVM(){
		try {
			ClientImpl client=new ClientImpl();
			registry=LocateRegistry.createRegistry(1111);
			Naming.rebind(url, client);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeVM(){
		try {
			Naming.unbind(url);
			UnicastRemoteObject.unexportObject(registry, true);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
