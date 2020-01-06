package Communication;
import java.net.*;
import java.io.IOException;	

public class UDPRWText extends UDPRWEmpty {

	 
	 private int p;
	 private byte[] array;
	
	 /** To create a sending packet send with a txt message. */
	 protected DatagramPacket getTextSendingPacket(InetSocketAddress isA, String msg, int size) throws IOException
	 {
		 setsB(toBytes(msg, new byte[size]));
		 return new DatagramPacket(getsB(),0,getsB().length,isA.getAddress(),isA.getPort());
	 }
	 
	 /** To set the Msg to a parametter packet. */
	 protected void setMsg(DatagramPacket dP, String msg) throws IOException
	 {
		 toBytes(msg, dP.getData()); 
	 
	 }
	 
	 private byte[] toBytes(String msg, byte[] lbuf) 
	 {
		 array = msg.getBytes();
		 if(array.length < lbuf.length)
			 for(int i=0;i<array.length;i++) 
				 lbuf[i] = array[i];
		 return lbuf;
	 }
	 
	 
	 
	 /** To extract the txt message from a packet. */
	 protected String getMsg(DatagramPacket dP) 
	 {
		 setsB(dP.getData());
		 for(int i=0;i<getsB().length;i++)
		 {
			 if(getsB()[i] == 0)
			 {
				 p = i;
			 	i = getsB().length;
			 }
		 }
		 String wesh = new String(dP.getData(),0,p);
		 return wesh;
	 }


}
