package Communication;
import java.net.*;
import java.io.IOException;

class UDPRWEmpty extends UDPInfo
{
	 private byte[] sB; /** The buffer array. */
	 
	 public byte[] getsB() {
		return sB;
	}

	public void setsB(byte[] sB) {
		this.sB = sB;
	}

	/** To prepare a sending packet at a given size e.g. 2048 kbytes. */
	 protected DatagramPacket getSendingPacket(InetSocketAddress isAR, int size) throws IOException
	 {
		 return new DatagramPacket(new byte[size],0,size,isAR.getAddress(),isAR.getPort());
	 }
	 
	 /** To prepare a receiving packet at a given size. */
	 protected DatagramPacket getReceivingPacket(int size) throws IOException
	 { 
		 return new DatagramPacket(new byte[size],size); 
	 }
} 

