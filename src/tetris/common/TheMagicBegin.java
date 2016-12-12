package tetris.common;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import tetris.net.Server_test;
import tetris.ui.activity.LoadActivity;

public class TheMagicBegin {
	public static void main(String[] args) {
		if(!isPortUsing("127.0.0.1", 9999)){
			Server_test.main(null);
		}else{
			GlobalConstants.CLIENT_PORT = 1112;
		}
		LoadActivity.main(null);
	}
	
	public static boolean isPortUsing(String host,int port){  
        boolean flag = false;  
        try {
        	InetAddress theAddress = InetAddress.getByName(host);  
            new Socket(theAddress,port);  
            flag = true;  
        } catch (Exception e) {}  
        return flag;  
    } 
}
