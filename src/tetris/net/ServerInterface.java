package tetris.net;

import java.rmi.Remote;
import java.rmi.RemoteException;
//add the remote method of Server here
public interface ServerInterface extends Remote{
	public void test() throws RemoteException;
	//д���rmi��ַ������
	public boolean login(String username,String localurl);
}
