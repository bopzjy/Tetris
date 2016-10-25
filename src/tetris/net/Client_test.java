package tetris.net;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client_test {
	static String url="rmi://localhost:9999/ServerImpl";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerInterface si=(ServerInterface)Naming.lookup(url);
			si.test();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
