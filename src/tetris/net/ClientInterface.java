package tetris.net;

import java.awt.Color;
import java.rmi.Remote;
import java.rmi.RemoteException;
//add the remote method of client here 
public interface ClientInterface extends Remote{
	public String test(String str) throws RemoteException;
	
	public boolean acceptBattle() throws RemoteException;
	public boolean InitCheck() throws RemoteException;
	public void setBlockColorByCoordinates(int i,int j,Color color) throws RemoteException;
	public void youWin() throws RemoteException;
	public void inviteBattle(String rivalName) throws RemoteException;
	public void inviteBattleACK() throws RemoteException;
	public void rejectedBattle() throws RemoteException;
}
