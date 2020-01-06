package controller.TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import model.*;
/**
 * 
 * Classe à exécuter dans un thread qui paramètre les sockets TCP pour recevoir
 * une ArrayList d'employés depuis un port particulier. 
 *
 */
public class TCPEmuServer implements Callable<ArrayList<Employee>>
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
	public TCPEmuServer() 
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
		isA = new InetSocketAddress("localhost",8085);
		ss = new ServerSocket(isA.getPort());
	}
	/**
	 * Code exécuté dans le thread. Prépare les sockets, et attend une
	 * ArrayList de la centrale.
	 */
	public ArrayList<Employee> call( ) 
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
			ArrayList<Employee> msIn = new ArrayList<Employee>();
			
			try 
			{
				ArrayList<Employee> arrayList = (ArrayList<Employee>) in.readObject();
				ArrayList<Employee> readObject = arrayList;
				msIn.addAll(readObject);
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			in.close();
			System.out.println("\n Got message ! \n");
			System.out.println("msIn is : "+msIn.get(0).PERGetPersonContact());
			
			s.close(); 
			ss.close();
			return msIn;
		}
		catch(IOException e)
			{ System.out.println("IOException TCPServerInfo EmuServer"); }
		}
	}
}
