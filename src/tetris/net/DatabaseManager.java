package tetris.net;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;

public class DatabaseManager {
	boolean isChanged=false;
	ArrayList<User> data;
	Recorder recorder;
	DatabaseManager(){
		load();
		recorder=new Recorder();
		recorder.start();
	}
	//��dataд���ļ�
	void save(){
		try {
			FileOutputStream fos=new FileOutputStream("data");
			ObjectOutputStream out=new ObjectOutputStream(fos);
			out.writeObject(data);
			out.close();
			isChanged=false;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//���ļ���ȡdata
	void load(){
		data=new ArrayList<User>();
		try {
			File file=new File("data");
			if(file.exists()){
				FileInputStream fis=new FileInputStream(file);
				ObjectInputStream in=new ObjectInputStream(fis);
				Object object=in.readObject();
				if(object instanceof ArrayList<?>){
					ArrayList<?> arraylist=(ArrayList<?>)object;
					for(int i=0;i<arraylist.size();i++){
						Object userobject=arraylist.get(i);
						data.add((User)userobject);
					}
				}
				in.close();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��ȡ����������û�
	void setTopPlayers(final ArrayList<User> players){
		players.clear();
		Comparator<User> comparator=new Comparator<User>(){
			@Override
			public int compare(User o1, User o2) {
				// TODO Auto-generated method stub
				return o2.score-o1.score;
			}			
		};
		data.sort(comparator);
		for(int i=0;i<10;i++){
			players.add(data.get(i));
		}
	}
	//��data�����������û�����д���ļ�
	boolean addUser(User user){
		boolean nothave=true;
		for(int i=0;i<data.size();i++){
			if(user.username.equals(data.get(i).username)){
				nothave=false;
				return false;
			}
		}
		if(nothave)
			data.add(user);
		isChanged=true;
		return true;
	}
	//�����û��ɼ�,�û����ھͷ��سɼ����º���ܳɼ������򷵻�0
	public int updateScore(String name,int score){
		boolean nothave=true;
		for(int i=0;i<data.size();i++){
			if(data.get(i).equals(name)){
				nothave=false;
				//if(data.get(i).score<score)
					//data.get(i).score=score;
				isChanged=true;
				data.get(i).score+=score;
				return data.get(i).score;
			}
		}
		/*
		if(nothave){
			User user=new User();
			user.username=name;
			user.score=score;
			data.add(user);
		}
		*/
		//isChanged=true;
		return 0;
	}
	//����Ƿ��и��û�
	public int checkUser(User user){
		for(int i=0;i<data.size();i++){
			if(data.get(i).username.equals(user.username)&&data.get(i).password.equals(user.password))
				return i;
		}
		return -1;
	}
	
	class Recorder extends Thread{
		public void run(){
			while(true){
				try {
					sleep(1000);
					if(isChanged)
						save();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
