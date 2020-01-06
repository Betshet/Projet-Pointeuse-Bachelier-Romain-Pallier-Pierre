package controller.TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;

import model.*;
/**
 * 
 * Classe à exécuter dans un thread qui paramètre les sockets TCP pour recevoir
 * un PunchingIO depuis un port particulier. 
 *
 */
public class TCPCentraleServer implements Callable<PunchingIO>
{

	/**
	 * Socket passive du serveur
	 */
	ServerSocket ss;
	/**
	 * Socket active du serveur
	 */
	Socket s;
	/**
	 * Adresse cible
	 */
	InetSocketAddress isA;
	
	/**
	 * Constructeur par défaut
	 */
	public TCPCentraleServer() 
	{
		s=null;
		ss = null;
		isA = null;
	}
	/**
	 * Prépare le socket TCP de façon à cibler l'adresse <i>isA</i>
	 * @throws IOException
	 * 		Erreur de paramétrage des sockets
	 */
	protected void setSocket() throws IOException 
	{
		isA = new InetSocketAddress("localhost",8086);
		ss = new ServerSocket(isA.getPort());
	}
	/**
	 * Code exécuté dans le thread. Prépare les sockets, et attend un
	 * PunchingIO de la pointeuse.
	 */
	public PunchingIO call( ) 
	{
		while(true)
		{
		try 
		{
			setSocket(); 
			System.out.println("The server sets the passive socket");
			s = ss.accept();
			System.out.println("The server accepts the connexion");
			
			ObjectInputStream in =  new ObjectInputStream(s.getInputStream());//pas sur
			PunchingIO msIn = new PunchingIO();
			
			try 
			{
				PunchingIO arrayList = (PunchingIO) in.readObject();
				PunchingIO readObject = arrayList;
				msIn=readObject;
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			in.close();
			System.out.println("\n Got message ! \n");			
			s.close(); 
			ss.close();
			return msIn;
		}
		catch(IOException e)
			{ System.out.println("IOException TCPServerInfo CentraleServer"); }
		}
	}
}
