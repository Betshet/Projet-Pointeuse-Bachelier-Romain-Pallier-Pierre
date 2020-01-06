package model;

import java.util.ArrayList;
/**
 * Classe contenant les données à envoyer à l'émulateur de pointeuse par TCP.
 * Elle contient un liste d'employés modifiable.
 *
 */
public class TCPData 
{
	/**
	 * Liste d'employés à envoyer
	 */
	private ArrayList<Employee> employeeData;
	/**
	 * Constructeur par défaut
	 */
	public TCPData()
	{
		setEmployeeData(null);
	}
	/**
	 * Constructeur de confort
	 * <p>Instancie un TCPData avec une liste d'employés comme paramètre, pour pouvoir
	 * l'envoyer par TCP.</p>
	 * @param listeEmp
	 * 		Liste d'employés
	 */
	public TCPData(ArrayList<Employee> listeEmp)
	{
		setEmployeeData(listeEmp);
	}
	/**
	 * 
	 * @return Liste d'employés à envoyer
	 */
	public ArrayList<Employee> getEmployeeData() {
		return employeeData;
	}
	/**
	 * Change la liste d'employés à envoyer
	 * @param employeeData
	 * 		Nouvelle liste d'employés à envoyer
	 */
	public void setEmployeeData(ArrayList<Employee> employeeData) {
		this.employeeData = employeeData;
	}
}
