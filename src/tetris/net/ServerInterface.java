package tetris.net;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import tetris.net.status;
//add the remote method of Server here
public interface ServerInterface extends Remote{
	public void test() throws RemoteException;
	//写你的rmi地址和名字密码
	public boolean login(String username,String password,String localurl) throws RemoteException;
	//获取前十名的玩家
	public ArrayList<User> getTopPlayers() throws RemoteException;
	//设置状态，并重置lifetime，存在就返回true，不存在就返回false，然后需要重新登录
	public boolean setStatus(String name,status s) throws RemoteException;
	//用户下线
	public boolean logout(String name) throws RemoteException;
	//获取在线用户名单
	public ArrayList<User> getOnlinePlayers() throws RemoteException;
	//更新成绩
	public int updateScore(String name,int score) throws RemoteException;
	//玩家注册
	public boolean register(String username,String password) throws RemoteException;
}
