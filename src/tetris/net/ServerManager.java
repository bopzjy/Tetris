package tetris.net;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import tetris.common.GlobalConstants;
import tetris.game.logic.GameEntity;
import tetris.utils.ParseMD5;

public class ServerManager {
	private static ServerManager instance = new ServerManager();
	public String username="";
	String password=null;
	public status state=status.offline;
	String url="rmi://"+GlobalConstants.SERVER_HOST+":"+String.valueOf(GlobalConstants.SERVER_PORT)+"/ServerImpl";
	String clientrmi="rmi://219.223.198.130:"+String.valueOf(GlobalConstants.CLIENT_PORT)+"/ClientImpl";
	public ServerInterface server;
	sendState sendstatethread;
	public User [] users = null;
	ServerManager(){
		clientrmi="rmi://"+getLocalHostIP()+":"+String.valueOf(GlobalConstants.CLIENT_PORT)+"/ClientImpl";
		connect();
	}

	public void connect(){
		try {
			server=(ServerInterface)Naming.lookup(url);
			System.out.println(url);
			server.test();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//登陆，登陆成功返回true，登录失败或者重复登陆返回false
	public boolean login(String username,String password) throws RemoteException{
		System.out.println("login:" + username + ":" + password);
		boolean success=server.login(username,ParseMD5.parseStrToMd5U32(password), clientrmi);
		if(!success)
			return false;
		this.username=username;
		this.password=password;
		state=status.online;
		sendstatethread=new sendState();
		sendstatethread.start();
		return true;
	}
	//获取排名最高的玩家
	public ArrayList<User> getTopPlayers() throws RemoteException{
		return server.getTopPlayers();
	}
	//更新自己的状态，对战时需要更新为对战装台，对战结束需要更新为空闲状态
	public void setState(status state){
		this.state=state;
	}
	//退出登陆
	public void logout() throws RemoteException{
		server.logout(username);
		sendstatethread.stop();
		//disconnect();
	}
	//获取在线玩家列表
	public User[] getOnlinePlayers() throws RemoteException{
		ArrayList<User> userarray=server.getOnlinePlayers();
		users=new User[userarray.size()];
		for(int i=0;i<userarray.size();i++)
			users[i]=userarray.get(i);
		return users;
	}
	//发送心跳包更新状态，超时自动退出登陆。
	class sendState extends Thread{
		public void run(){
			while(true){
				try {
					if(!server.setStatus(username, state)){
						
						break;
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//先注册，后登陆
	public boolean register(String username, String password){
		System.out.println("register:" + username + ":" + password);
		try {
			return server.register(username, ParseMD5.parseStrToMd5U32(password));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
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
    

	public static ServerManager getInstance() {
		if (instance == null) {
			instance = new ServerManager();
		}
		return instance;
	}
	
}
