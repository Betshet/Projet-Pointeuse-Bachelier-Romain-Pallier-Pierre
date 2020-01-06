package controller.TCP;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import model.PunchingIO;
import model.TCPData;
/**
 * Classe permettant d'envoyer et recevoir des objets TCPData en lan�ant des threads
 * faisant appel � TCPCentraleServer et TCPCentraleClient.
 * @see TCPCentraleServer
 * @see TCPCentraleClient
 * 
 */
public class TCPController
{
	/**
	 * Lance un thread TCPCentraleServer, en r�cup�re les donn�es re�ues,
	 * puis les retourne dans un objet PunchingIO. La fonction peut-�tre boucl�e
	 * pour toujours rester en attente de donn�es.
	 * 
	 * @see TCPCentraleServer
	 * @return PunchingIO contenant un pointage d'un employ�
	 * @throws InterruptedException
	 * 		Interruption du thread
	 * @throws ExecutionException
	 * 		Erreur de lancement du thread
	 */
	public static PunchingIO waitForData() throws InterruptedException, ExecutionException
	{
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		TCPCentraleServer server = new TCPCentraleServer();
		Future<PunchingIO> f = service.submit(server);
		PunchingIO receivedPunchings = f.get();
		service.shutdown();
		return receivedPunchings;
	}
	/**
	 * Lance un thread TCPCentraleClient avec comme param�tre un TCPData contenant les
	 * donn�es � envoyer par TCP.
	 * 
	 * @see TCPCentraleClient
	 * @param dataToSend
	 * 		TCPData contenant une liste d'employ�s
	 */
	public static void sendData(TCPData dataToSend)
	{
		new Thread(new TCPCentraleClient(dataToSend)).start();
	}
}
