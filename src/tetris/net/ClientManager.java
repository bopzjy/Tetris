package tetris.net;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.xml.bind.ValidationEvent;

import tetris.common.GlobalConstants;
import tetris.game.logic.GameEntity;

public class ClientManager {
	private static ClientManager instance = null;
	public int port=GlobalConstants.CLIENT_PORT;
	public String url;
	public volatile boolean isConnecting = false;
	Registry registry;
	ClientInterface currentClientInterface = null;
	public ClientManager(){
		url="rmi://"+getLocalHostIP()+":"+port+"/ClientImpl";
		set_RMI_URL(2222);
		buildVM();
	}
	public ClientInterface connect(String url) 
			throws MalformedURLException, RemoteException, NotBoundException{
		currentClientInterface = (ClientInterface)Naming.lookup(url);
		return currentClientInterface;
	}
	
	public ClientInterface getInterface () {
		return currentClientInterface;
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

	public void set_RMI_URL(int port){
		url="rmi://"+getLocalHostIP()+":"+port+"/ClientImpl";
		this.port=port;
	}
	
	public static ClientManager getInstance() {
		if (instance == null) {
			instance = new ClientManager();
		}
		return instance;
	}
	
    public static String getLocalHostIP() { 
        String ip; 
        try { 
             /**返回本地主机。*/ 
             InetAddress addr = InetAddress.getLocalHost(); 
             /**返回 IP 地址字符串（以文本表现形式）*/ 
             ip = addr.getHostAddress();  
        } catch(Exception ex) { 
            ip = ""; 
        } 
          
        return ip; 
   } 
    
}
