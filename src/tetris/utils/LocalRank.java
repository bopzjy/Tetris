package tetris.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import tetris.common.Player;

public class LocalRank {
	public static Player[] getMaxXPalyers(){
		ArrayList<Player> players = new ArrayList<>();
		
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("resources\\Data\\local.dat")));
			int num = 0;
			for (String line = br.readLine(); line != null && num<10; line = br.readLine()) {  
	            String sub[] = line.split(":");
	            players.add(new Player(sub[0], Integer.parseInt(sub[1])));
	            num++;
	        }  
	        br.close();  
		}catch (Exception e) {
			return null;
		}
		
		return (Player[])players.toArray(new Player[players.size()]);
	}
	
	public static void addPlayerRecord(Player player){
		ArrayList<Player> players = new ArrayList<>();
		
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("resources\\Data\\local.dat")));
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				if(line.equals(""))	continue;
	            String sub[] = line.split(":");
	            players.add(new Player(sub[0], Integer.parseInt(sub[1])));
	        }  
	        br.close();  
		}catch (Exception e) {
			return;
		}
		
		boolean flag = true;
		for(Player iPlayer:players){
            if(iPlayer.getName().equals(player.getName())){
            	flag = false;      
                if(iPlayer.getScore()<player.getScore()){
                	iPlayer.setScore(player.getScore());
                	break;
                } 
            }
        }
		if(flag)	players.add(player);
		Collections.sort(players);
		
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter("resources\\Data\\local.dat"));
			for(int i = 0; i<players.size(); i++){
				bw.write(String.format("%s:%d", players.get(i).getName(), players.get(i).getScore()));
				if(i!=players.size()-1)
					bw.newLine();
				//System.out.println(i++);
			}
			bw.close();
		}catch (Exception e) {
			return;
		}
	}
}
