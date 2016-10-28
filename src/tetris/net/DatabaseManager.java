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
	ArrayList<User> data;
	
	DatabaseManager(){
		load();
	}
	
	void save(){
		try {
			FileOutputStream fos=new FileOutputStream("data");
			ObjectOutputStream out=new ObjectOutputStream(fos);
			out.writeObject(data);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

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

	void addUser(User user){
		boolean nothave=true;
		for(int i=0;i<data.size();i++){
			if(user.username.equals(data.get(i).username)){
				nothave=false;
				break;
			}
		}
		if(nothave)
			data.add(user);
	}
	
	public int updateScore(String name,int score){
		boolean nothave=true;
		for(int i=0;i<data.size();i++){
			if(data.get(i).equals(name)){
				nothave=false;
				if(data.get(i).score<score)
					data.get(i).score=score;
				break;
			}
		}
		if(nothave){
			User user=new User();
			user.username=name;
			user.score=score;
			data.add(user);
		}
		save();
		return 0;
	}
}
