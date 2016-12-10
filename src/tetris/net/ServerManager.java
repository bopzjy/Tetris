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
	
	//��½����½�ɹ�����true����¼ʧ�ܻ����ظ���½����false
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
	//��ȡ������ߵ����
	public ArrayList<User> getTopPlayers() throws RemoteException{
		return server.getTopPlayers();
	}
	//�����Լ���״̬����սʱ��Ҫ����Ϊ��սװ̨����ս������Ҫ����Ϊ����״̬
	public void setState(status state){
		this.state=state;
	}
	//�˳���½
	public void logout() throws RemoteException{
		server.logout(username);
		sendstatethread.stop();
		//disconnect();
	}
	//��ȡ��������б�
	public User[] getOnlinePlayers() throws RemoteException{
		ArrayList<User> userarray=server.getOnlinePlayers();
		users=new User[userarray.size()];
		for(int i=0;i<userarray.size();i++)
			users[i]=userarray.get(i);
		return users;
	}
	//��������������״̬����ʱ�Զ��˳���½��
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
	//��ע�ᣬ���½
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
             /**���ر���������*/ 
             InetAddress addr = InetAddress.getLocalHost(); 
             /**���� IP ��ַ�ַ��������ı�������ʽ��*/ 
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
