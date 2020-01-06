package Communication;
import java.io.IOException;

import java.util.*;

public class UDPClientChat extends UDPClientBuilder implements Runnable{

	
	 public void run() 
	 {
		 try 
		 {
			 	String msg = "";
			 	setConnectionClient("localhost",8093); 
			 	
				Scanner sc;
				sc = new Scanner(System.in);

					
					msg = sc.nextLine();

					req = getTextSendingPacket(isA,msg,8);
					s.send(req);
					System.out.println("request sent"); 
					
					sc.close();
					s.close();	
				

		 }
		 catch(IOException e)
		 { System.out.println("Chat fermé"); }

	 }
}
