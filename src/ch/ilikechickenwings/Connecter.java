package ch.ilikechickenwings;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connecter implements Runnable{

	
	Socket socketConnection;
	Boolean socketUp=false;
	public Connecter(String str, String str2){
		
		
		try {
			socketConnection = new Socket(str, Integer.parseInt(str2));
			socketUp=true;
			new Thread(this).start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       
		
	}

	@Override
	public void run() {
		while(socketUp){ 
		try {
				ObjectOutputStream clientOutputStream = new
				       ObjectOutputStream(socketConnection.getOutputStream());
			
		 	ObjectInputStream clientInputStream = new 
		           ObjectInputStream(socketConnection.getInputStream());
		 	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		}
				
		        
		
	}
	
	
}
