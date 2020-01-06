package model;
import java.util.ArrayList;

/**
 * La classe Department permet de créer des départements de l'entreprise, avec ces attributs :
 * <ul>
 * <li>Un nom de département
 * <li>Un manager à sa tête
 * <li>Un liste des employés faisant partie du département
 * <li>Une liste de managers dans le département
 * </ul>
 * <p>Il est possible d'engager et renvoyer des employés et manager depuis cette classe,
 * bien que ces fonctions seront surtout appelées par la classe Company.</p>
 */
public class Department implements java.io.Serializable {

	private static final long serialVersionUID = 8428352569692187727L;
	/**
	 * Nom du département
	 */
	private String DepName;
	/**
	 * Manager dirigeant le département
	 */
	private Manager EMPManager;
	/**
	 * Liste des employés du département
	 */
	private ArrayList<Employee> EmployeeList;
	/**
	 * Liste des managers du département
	 */
	private ArrayList<Manager> ManagerList;
	
	//Constructeurs
	/**
	 * Constructeur par défaut
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
	 * <p>Crée un département</p>
	 * @param newDepName
	 * 		Nom du nouveau département
	 * @param newManager
	 * 		Manager dirigeant le nouveau département
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
	 * @return Nom du Département
	 */
	public String getSDepName() 
	{
		return DepName;
	}
	/**
	 * 
	 * @return Manager dirigeant le département
	 */
	public Manager getManager() 
	{
		return EMPManager;
	}
	/**
	 * 
	 * @return Liste des employés du département
	 */
	public ArrayList<Employee> getEmployeeList() 
	{
		return EmployeeList;
	}
	
	//Setters
	/**
	 * Change le nom du département
	 * @param sDepName
	 * 		Nouveau nom du département
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
	 * Change la liste d'employés
	 * @param newlEmployeeList
	 * 		Nouvelle liste d'employés
	 */
	public void setEmployeeList(ArrayList<Employee> newlEmployeeList) 
	{
		EmployeeList = newlEmployeeList;
	}
	/**
	 * 
	 * @return Liste de managers du département
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
	 * Engage un employé
	 * @param newEmployee
	 * 		Nouvel employé
	 */
	public void hireEmployee(Employee newEmployee)
	{
		EmployeeList.add(newEmployee);	
	}
	/**
	 * Renvoie un employé
	 * @param firedEmployee
	 * 		Employé renvoyé
	 */
	public void fireEmployee(Employee firedEmployee)
	{
		EmployeeList.remove(firedEmployee);
	}
	/**
	 * Engage un manager
	 * @param newManager
	 * 		Manager engagé
	 */
	public void hireManager(Manager newManager)
	{
		ManagerList.add(newManager);	
	}
	/**
	 * Revoie un manager
	 * @param manager
	 * 		Manager renvoyé
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
