package Communication;
import java.io.IOException;
import java.net.*;

class UDPServerBuilder extends UDPRWText
{ 
	InetSocketAddress isA;
	DatagramSocket s;
	DatagramPacket req, rep;
	final int size = 2048;
	
	UDPServerBuilder() 
	{ 
		isA = null;
		s = null;
		req = rep = null;
	} 
	
	protected void setConnectionServer(String IPadress, int Port) throws IOException
	{
		
		isA = new InetSocketAddress(IPadress,Port);
		s = new DatagramSocket(isA.getPort());
		s.setSoTimeout(0);

		/** we can include more setting, later ... */ 
	}
}