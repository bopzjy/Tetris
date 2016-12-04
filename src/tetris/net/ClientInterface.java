package tetris.net;

import java.rmi.Remote;
import java.rmi.RemoteException;
//add the remote method of client here 
public interface ClientInterface extends Remote{
	public String test(String str) throws RemoteException;
}
