package model;
import java.util.ArrayList;

/**
 * La classe Department permet de cr�er des d�partements de l'entreprise, avec ces attributs :
 * <ul>
 * <li>Un nom de d�partement
 * <li>Un manager � sa t�te
 * <li>Un liste des employ�s faisant partie du d�partement
 * <li>Une liste de managers dans le d�partement
 * </ul>
 * <p>Il est possible d'engager et renvoyer des employ�s et manager depuis cette classe,
 * bien que ces fonctions seront surtout appel�es par la classe Company.</p>
 */
public class Department implements java.io.Serializable {

	private static final long serialVersionUID = 8428352569692187727L;
	/**
	 * Nom du d�partement
	 */
	private String DepName;
	/**
	 * Manager dirigeant le d�partement
	 */
	private Manager EMPManager;
	/**
	 * Liste des employ�s du d�partement
	 */
	private ArrayList<Employee> EmployeeList;
	/**
	 * Liste des managers du d�partement
	 */
	private ArrayList<Manager> ManagerList;
	
	//Constructeurs
	/**
	 * Constructeur par d�faut
	 */
	public Department()
	{
		DepName=null;
		EMPManager = new Manager();
		EmployeeList = new ArrayList<Employee>();
		ManagerList = new ArrayList<Manager>();
	}	
	/**
	 * Constructeur de confort
	 * <p>Cr�e un d�partement</p>
	 * @param newDepName
	 * 		Nom du nouveau d�partement
	 * @param newManager
	 * 		Manager dirigeant le nouveau d�partement
	 */
	public Department(String newDepName, Manager newManager)
	{
		DepName=newDepName;

		EMPManager = newManager;

		EmployeeList=new ArrayList<Employee>();
		ManagerList = new ArrayList<Manager>();
		
	}
	
	//Getters
	/**
	 * 
	 * @return Nom du D�partement
	 */
	public String getSDepName() 
	{
		return DepName;
	}
	/**
	 * 
	 * @return Manager dirigeant le d�partement
	 */
	public Manager getManager() 
	{
		return EMPManager;
	}
	/**
	 * 
	 * @return Liste des employ�s du d�partement
	 */
	public ArrayList<Employee> getEmployeeList() 
	{
		return EmployeeList;
	}
	
	//Setters
	/**
	 * Change le nom du d�partement
	 * @param sDepName
	 * 		Nouveau nom du d�partement
	 */
	public void setDepName(String sDepName) 
	{
		DepName = sDepName;
	}
	/**
	 * Change le manager dirigeant
	 * @param eMPManager
	 * 		Nouveau manager dirigeant
	 */
	public void setManager(Manager eMPManager) 
	{
		EMPManager = eMPManager;
	}
	/**
	 * Change la liste d'employ�s
	 * @param newlEmployeeList
	 * 		Nouvelle liste d'employ�s
	 */
	public void setEmployeeList(ArrayList<Employee> newlEmployeeList) 
	{
		EmployeeList = newlEmployeeList;
	}
	/**
	 * 
	 * @return Liste de managers du d�partement
	 */
	public ArrayList<Manager> getManagerList() {
		return ManagerList;
	}
	/**
	 * Change la liste de manages
	 * @param managerList
	 * 		Nouvelle liste de managers
	 */
	public void setManagerList(ArrayList<Manager> managerList) {
		ManagerList = managerList;
	}
	/**
	 * Engage un employ�
	 * @param newEmployee
	 * 		Nouvel employ�
	 */
	public void hireEmployee(Employee newEmployee)
	{
		EmployeeList.add(newEmployee);	
	}
	/**
	 * Renvoie un employ�
	 * @param firedEmployee
	 * 		Employ� renvoy�
	 */
	public void fireEmployee(Employee firedEmployee)
	{
		EmployeeList.remove(firedEmployee);
	}
	/**
	 * Engage un manager
	 * @param newManager
	 * 		Manager engag�
	 */
	public void hireManager(Manager newManager)
	{
		ManagerList.add(newManager);	
	}
	/**
	 * Revoie un manager
	 * @param manager
	 * 		Manager renvoy�
	 */
	public void fireManager(Manager manager)
	{
		ManagerList.remove(manager);
	}
	/**
	 * Affiche dans la console un objet Department et ses attributs
	 */
	public void printDept()
	{
		System.out.println("SDepName : "+DepName+"\n");
		System.out.println("Dep Manager info under : \n");
		EMPManager.printPers();
		for(int iIter=0;iIter<EmployeeList.size();iIter++)
		{
			System.out.println("Employee number : "+iIter+"\n");
			EmployeeList.get(iIter).printEmp();
			System.out.println("\n");
		}
	}
	/**
	 * Convertit en String un Department
	 * @return String
	 * 		Department converti en String
	 */
	@Override
	public String toString()
	{
		return getSDepName();
	}

}
