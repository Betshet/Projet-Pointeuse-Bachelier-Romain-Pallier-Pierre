package controller.TCP;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import model.*;
/**
 * 
 * Classe à exécuter dans un thread qui paramètre les sockets TCP pour envoyer
 * un pointage d'employé vers un port particulier.
 *
 */
public class TCPEmuClient implements Runnable
{
	/**
	 * Socket TCP du client
	 */
	Socket s;
	/**
	 * Adresse cible
	 */
	InetSocketAddress isA;
	/**
	 * Pointage à envoyer
	 */
	PunchingIO dataToSend;
	/**
	 * Constructeur par défaut
	 */
	public TCPEmuClient()
	{
		s=null;
		isA=null;
		dataToSend=null;
	}
	/**
	 * Constructeur de confort
	 * <p>Ajoute un TCPData dans l'attribut dataToSend</p>
	 * @param newDataToSend
	 * 		TCPData contenant les données à envoyer
	 */
	public TCPEmuClient(TCPData newDataToSend)
	{
		s=null;
		isA=null;
		dataToSend=newDataToSend.getPunchData();
	}
	/**
	 * Prépare le socket TCP de façon à cibler l'adresse <i>isA</i>
	 * @throws IOException
	 * 		Erreur de paramétrage des sockets
	 */
	protected void setSocket() throws IOException 
	{
		isA = new InetSocketAddress("localhost",8086);
		s = new Socket(isA.getHostName(), isA.getPort());
	}
	/**
	 * Code exécuté dans le thread. Prépare les sockets, et envoie le contenu
	 * de <i>dataToSend</i> par TCP.
	 */
	public void run( ) 
	{
		try 
		{
			setSocket();
			
			PunchingIO msOut = new PunchingIO();
			msOut=dataToSend;
			ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
			PunchingIO buffer = msOut;
			out.writeObject(buffer);
			out.flush();
			out.close();
			s.close(); 
		}
		catch(IOException e){ System.out.println("IOException TCPServerInfo EmuClient"); }
	}
}
