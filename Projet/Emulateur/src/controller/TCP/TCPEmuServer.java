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
 * Classe � ex�cuter dans un thread qui param�tre les sockets TCP pour recevoir
 * une ArrayList d'employ�s depuis un port particulier. 
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
	 * Constructeur par d�faut
	 */
	public TCPEmuServer() 
	{
		s=null;
		ss = null;
		isA = null;
	}

	/**
	 * Pr�pare le socket TCP de fa�on � cibler l'adresse <i>isA</i>
	 * @throws IOException
	 * 		Erreur de param�trage des sockets
	 */
	protected void setSocket() throws IOException 
	{
		isA = new InetSocketAddress("localhost",8085);
		ss = new ServerSocket(isA.getPort());
	}
	/**
	 * Code ex�cut� dans le thread. Pr�pare les sockets, et attend une
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
