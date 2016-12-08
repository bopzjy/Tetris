package tetris.net;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6968375369107732749L;
	static ArrayList<User> onlineuser;
	static ArrayList<User> topplayers;
	static DatabaseManager	manager;
	
	protected ServerImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		onlineuser=new ArrayList<User>();
		topplayers=new ArrayList<User>();
		manager=new DatabaseManager();
		new checktimeleft().start();
	}

	
	@Override
	public void test() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("this is server rmi test");
	}

	//��ҵ�½
	@Override
	public boolean login(String username,String password,String localurl) throws RemoteException {
		// TODO Auto-generated method stub
		//update the onlineuser ArrayList,not update the datebase
		boolean notexisted=true;
		for(int i=0;i<onlineuser.size();i++){
			if(onlineuser.get(i).username.equals(username)){
				onlineuser.get(i).url=localurl;
				notexisted=false;
			}
		}
		if(notexisted){
			User user=new User();
			user.username=username;
			user.url=localurl;
			user.password=password;
			int num=manager.checkUser(user);
			if(num>=0)
			{
				user.rank=manager.data.get(num).rank;
				user.score=manager.data.get(num).score;
				onlineuser.add(user);
				return true;
			}
		}
		return false;
	}
	//��ȡ������ߵ����
	@Override
	public ArrayList<User> getTopPlayers() throws RemoteException {
		// TODO Auto-generated method stub
		manager.setTopPlayers(topplayers);
		return topplayers;
	}
	//�������״̬
	@Override
	public boolean setStatus(String name, status s) throws RemoteException {
		// TODO Auto-generated method stub
		boolean isexisted=false;
		for(int i=0;i<onlineuser.size();i++){
			if(onlineuser.get(i).username.equals(name)){
				onlineuser.get(i).state=s;
				onlineuser.get(i).timeleft=10;
				isexisted=true;
			}
		}
		return isexisted;
	}
	//�˳���½
	@Override
	public boolean logout(String name) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<onlineuser.size();i++){
			if(onlineuser.get(i).username.equals(name)){
				onlineuser.remove(i);
				break;
			}
		}
		return true;
	}
	//���ʣ��ʱ��
	class checktimeleft extends Thread{
		public void run(){
			while(true){
				for(int i=0;i<onlineuser.size();i++){
					onlineuser.get(i).timeleft--;
					if(onlineuser.get(i).timeleft==0){
						try {
							logout(onlineuser.get(i).username);
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						i=0;
					}
				}
				//System.out.println("the online user is"+onlineuser.size());
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//��ȡ�������
	@Override
	public ArrayList<User> getOnlinePlayers() throws RemoteException{
		// TODO Auto-generated method stub
		return onlineuser;
	}
	//���³ɼ�
	@Override
	public int updateScore(String name, int score) throws RemoteException {
		// TODO Auto-generated method stub
		return manager.updateScore(name, score);
	}
	//�û�ע��
	@Override
	public boolean register(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		User user=new User();
		user.username=username;
		user.password=password;
		return manager.addUser(user);
	}
}
