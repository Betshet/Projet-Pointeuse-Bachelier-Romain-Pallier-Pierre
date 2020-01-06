package Communication;

import java.io.IOException;
import java.net.DatagramPacket;


public class UDPServerChat extends UDPServerBuilder implements Runnable
{


	
	 public void run() 
	 {
		 try 
		 {
			 	setConnectionServer("localhost",8080); 
			 	System.out.println("Server centrale launched");
					rep = new DatagramPacket(new byte[size],size);
					s.receive(rep);
					System.out.println("request received");
					System.out.println(getMsg(rep));
					
					
				
			 	s.close();
				
		 }
		 catch(IOException e)
		 { System.out.println("IOException UDPServer"); }
	 }
}

