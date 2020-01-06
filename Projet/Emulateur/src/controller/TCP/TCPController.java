package controller.TCP;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import model.Employee;
import model.TCPData;
/**
 * Classe permettant d'envoyer et recevoir des objets TCPData en lançant des threads
 * faisant appel à TCPCentraleServer et TCPCentraleClient.
 * @see TCPEmuServer
 * @see TCPEmuClient
 * 
 */
public class TCPController
{
	/**
	 * Lance un thread TCPEmuServer, en récupère les données reçues,
	 * puis les retourne dans un objet ArrayList d'employés. La fonction peut-être bouclée
	 * pour toujours rester en attente de données.
	 *  @see TCPEmuServer
	 * @return ArrayList d'employés contenant une liste d'employés
	 * @throws InterruptedException
	 * 		Interruption du thread
	 * @throws ExecutionException
	 * 		Erreur de lancement du thread
	 *
	 */
	public static ArrayList<Employee> waitForData() throws InterruptedException, ExecutionException
	{
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		TCPEmuServer server = new TCPEmuServer();
		Future<ArrayList<Employee>> f = service.submit(server);
		ArrayList<Employee> receivedPunchings = f.get();
		service.shutdown();
		return receivedPunchings;
	}
	/**
	 * Lance un thread TCPEmuClient avec comme paramètre un TCPData contenant les
	 * données à envoyer par TCP.
	 * 
	 * @see TCPEmuClient
	 * @param dataToSend
	 * 		TCPData contenant un PunchingIO
	 */
	public static void sendData(TCPData dataToSend)
	{
		new Thread(new TCPEmuClient(dataToSend)).start();
	}
}
