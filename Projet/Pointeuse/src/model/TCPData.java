package model;

import java.util.ArrayList;
/**
 * Classe contenant les donn�es � envoyer � l'�mulateur de pointeuse par TCP.
 * Elle contient un liste d'employ�s modifiable.
 *
 */
public class TCPData 
{
	/**
	 * Liste d'employ�s � envoyer
	 */
	private ArrayList<Employee> employeeData;
	/**
	 * Constructeur par d�faut
	 */
	public TCPData()
	{
		setEmployeeData(null);
	}
	/**
	 * Constructeur de confort
	 * <p>Instancie un TCPData avec une liste d'employ�s comme param�tre, pour pouvoir
	 * l'envoyer par TCP.</p>
	 * @param listeEmp
	 * 		Liste d'employ�s
	 */
	public TCPData(ArrayList<Employee> listeEmp)
	{
		setEmployeeData(listeEmp);
	}
	/**
	 * 
	 * @return Liste d'employ�s � envoyer
	 */
	public ArrayList<Employee> getEmployeeData() {
		return employeeData;
	}
	/**
	 * Change la liste d'employ�s � envoyer
	 * @param employeeData
	 * 		Nouvelle liste d'employ�s � envoyer
	 */
	public void setEmployeeData(ArrayList<Employee> employeeData) {
		this.employeeData = employeeData;
	}
}
