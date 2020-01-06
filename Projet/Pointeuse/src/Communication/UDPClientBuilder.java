package Communication;
import java.io.IOException;
import java.net.*;

class UDPClientBuilder extends UDPRWText
{ 
	InetSocketAddress isA;
	DatagramSocket s;
	DatagramPacket req, rep;
	final int size = 2048;
	
	UDPClientBuilder() 
	{ 
		isA = null;
		s = null;
		req = rep = null;
	} 
	
	protected void setConnectionClient(String IPadress, int Port) throws IOException
	{
		s = new DatagramSocket();
		isA = new InetSocketAddress(IPadress,Port);
		s.setSoTimeout(0);
		/** we can include more setting, later ... */ 
	}
}