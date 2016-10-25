package tetris.net;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
	void getTopPlayers(final ArrayList<User> players){
		
	}
	void quicksort(){
		
	}
	
}
