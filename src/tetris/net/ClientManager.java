package tetris.net;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import tetris.common.GlobalConstants;

public class ClientManager {
	public int port=GlobalConstants.CLIENT_PORT;
	public String url="rmi://localhost:"+GlobalConstants.CLIENT_PORT+"/ClientImpl";
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
			registry=LocateRegistry.createRegistry(port);
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
