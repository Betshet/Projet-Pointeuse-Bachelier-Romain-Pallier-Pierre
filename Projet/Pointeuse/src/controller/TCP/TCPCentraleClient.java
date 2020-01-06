package controller.TCP;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;

import model.*;
/**
 * 
 * Classe � ex�cuter dans un thread qui param�tre les sockets TCP pour envoyer
 * une liste d'employ�s vers un port particulier.
 *
 */
public class TCPCentraleClient implements Runnable
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
	 * Liste d'employ�s � envoyer
	 */
	ArrayList<Employee> dataToSend;
	
	/**
	 * Constructeur par d�faut
	 */
	public TCPCentraleClient()
	{
		s=null;
		isA=null;
		dataToSend=null;
	}
	/**
	 * Constructeur de confort
	 * <p>Ajoute un TCPData dans l'attribut dataToSend</p>
	 * @param newDataToSend
	 * 		TCPData contenant les donn�es � envoyer
	 */
	public TCPCentraleClient(TCPData newDataToSend)
	{
		s=null;
		isA=null;
		dataToSend=newDataToSend.getEmployeeData();
	}
	/**
	 * Pr�pare le socket TCP de fa�on � cibler l'adresse <i>isA</i>
	 * @throws IOException
	 * 		Erreur de param�trage des sockets
	 */
	protected void setSocket() throws IOException 
	{
		isA = new InetSocketAddress("localhost",8085);
		s = new Socket(isA.getHostName(), isA.getPort());
	}
	/**
	 * Code ex�cut� dans le thread. Pr�pare les sockets, et envoie le contenu
	 * de <i>dataToSend</i> par TCP.
	 */
	public void run( ) 
	{
		try 
		{
			setSocket();
			ArrayList<Employee> msOut = dataToSend;
			
			ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
			ArrayList<Employee> buffer = msOut;
			out.writeObject(buffer);
			out.flush();
			out.close();
			s.close();
		}
		catch(IOException e){ System.out.println("IOException TCPServerInfo CentraleClient"); }
	}
}
