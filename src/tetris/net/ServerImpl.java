package tetris.net;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6968375369107732749L;
	

	protected ServerImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

}
