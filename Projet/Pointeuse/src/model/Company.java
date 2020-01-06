package model;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * La classe Company permet de créer des objets Company, contenant toutes les composantes
 * de l'entreprise.
 * <ul>
 * <li>Un nom d'entreprise
 * <li>Un chef d'entreprise
 * <li>Une liste de départements
 * <li>Une liste d'employés
 * <li>Une liste de managers
 * <li>Un compteur d'Id uniques, utilisé pour donner des ID uniques aux employés embauchés
 * </ul>
 * 
 * <p>Il est possible d'embaucher ou de renvoyer des employés et managers, ainsi que de créer
 * de nouveau départements.</p>
 *
 */
public class Company implements java.io.Serializable{


	private static final long serialVersionUID = 734751888988596959L;
	
	/**
	 * Nom de l'entreprise
	 */
	private String sCompanyName;
	/**
	 * Chef d'entreprise
	 */
	private Person PERBoss;
	/**
	 * Liste de tous les départments
	 */
	private ArrayList<Department> DptList;
	/**
	 * Liste de tous les employés
	 */
	private ArrayList<Employee> EmpList;
	/**
	 * Liste de tous les managers
	 */
	private ArrayList<Manager> ManagerList;
	/**
	 * Compteur d'ID uniques
	 */
	private long uniqueIDcount = 0;
	
	/**
	 * Constructeur Company par défaut
	 * <p>Crée une Company vide. </p>
	 */
	public Company()
	{
		sCompanyName=null;
		DptList=new ArrayList<Department>();
		PERBoss=null;
		EmpList = new ArrayList<Employee>();
		ManagerList = new ArrayList<Manager>();
	}
	
	/**
	 * Constructeur Company de confort
	 * 
	 * <p>Crée une Company avec sCompName en nom d'entreprise, et avec Boss comme chef
	 * d'entreprise</p>
	 * @param sCompName
	 * 		Nom de l'entreprise
	 * @param Boss
	 * 		Chef d'entreprise
	 */
	public Company(String sCompName, Person Boss)
	{
		sCompanyName=sCompName;
		DptList=new ArrayList<Department>();
		PERBoss=Boss;
		EmpList = new ArrayList<Employee>();
		ManagerList = new ArrayList<Manager>();
	}
	
	/**
	 * 
	 * @return Nom d'entreprise
	 */
	public String getCompanyName()
	{
		return sCompanyName;
	}
	
	/**
	 * Change le nom de l'entreprise
	 * @param sCompName
	 * 		Nouveau nom de l'entreprise
	 */
	public void setCompanyName(String sCompName)
	{
		sCompanyName=sCompName;		
	}
	/**
	 * 
	 * @return Chef d'entreprise
	 */
	public Person getBoss()
	{
		return PERBoss;
	}
	/**
	 * Change le chef d'entreprise
	 * @param newBoss
	 * 		Nouveau chef d'entreprise
	 */
	public void setBoss(Person newBoss)
	{
		PERBoss=newBoss;		
	}
	/**
	 * 
	 * @return Liste de départements
	 */
	public  ArrayList<Department> getDptList()
	{
		return DptList;
	}
	/**
	 * 
	 * @return Liste d'employés
	 */
	public ArrayList<Employee> getEmpList() {
		return EmpList;
	}
	/**
	 * Change la liste d'employés
	 * @param empList
	 * 		Nouvelle liste d'employés
	 */
	public void setEmpList(ArrayList<Employee> empList) {
		EmpList = empList;
	}
	/**
	 * 
	 * @return Liste de managers
	 */
	public ArrayList<Manager> getManagerList() {
		return ManagerList;
	}
	/**
	 * Change la liste de managers
	 * @param managerList
	 * 		Nouvelle liste de managers
	 */
	public void setManagerList(ArrayList<Manager> managerList) {
		ManagerList = managerList;
	}
	/**
	 * 
	 * @return Numéro actuel du compteur d'ID uniques
	 */
	public long getUniqueIDcount() {
		return uniqueIDcount;
	}
	/**
	 * Change le compteur d'ID uniques
	 * @param uniqueIDcount
	 * 		Nouvelle valeur du compteur d'ID uniques
	 */
	public void setUniqueIDcount(long newUniqueIDcount) {
		uniqueIDcount = newUniqueIDcount;
	}
	/**
	 * Génère un ID unique en incrémentant la valeur du compteur
	 * @return Un ID unique
	 */
	public long uniqueID()
	{
		setUniqueIDcount(uniqueIDcount+1);
		return getUniqueIDcount();
	}

	/**
	 * Engage un nouveau manager dans un départment donné?
	 * @param newManager
	 * 		Manager engagé
	 * @param dpt
	 * 		Département où le manager est engagé
	 */
	public void hireManager(Manager newManager, Department dpt)
	{
		getManagerList().add(newManager);
		dpt.hireManager(newManager);
		newManager.EMPSetDepartment(dpt);
	}
	/**
	 * Renvoie un manager et le supprime de la liste de Managers
	 * @param man
	 * 		Manager à renvoyer
	 */
	public void fireManager(Manager man)
	{
		getManagerList().remove(man);
		man.EMPGetDepartment().fireManager(man);
	}
	/**
	 * Ajoute un départment à la liste de départements
	 * @param newDepartment
	 * 		Département à ajouter
	 */
	public void addDepartment(Department newDepartment)
	{
		DptList.add(newDepartment);
	}
	
	/**
	 * Retire un départment de la liste
	 * @param oldDepartment
	 * 		Départment à retirer
	 */
	public void removeDepartment(Department oldDepartment)
	{
		DptList.remove(oldDepartment); 
	}
	
	/**
	 * Crée un département et l'ajoute à la liste de tous les départements
	 * @param nomDpt
	 * 		Nom du département créé
	 * @param manager
	 * 		Nom du Manager du Département
	 */
	public void createDepartment(String nomDpt, Manager manager)
	{
		addDepartment(new Department(nomDpt,manager));
	}
	/**
	 * Ajoute un employé à la liste des employés
	 * @param emp
	 * 		Employé ajouté
	 */
	private void addEmployee(Employee emp)
	{
		getEmpList().add(emp);
	}
	/**
	 * Retire un employé de la liste des employés
	 * @param emp
	 * 		Employé retiré
	 */
	private void removeEmployee(Employee emp)
	{
		getEmpList().remove(emp);
	}
	/**
	 * Engage un employé et l'ajoute à la liste des employés
	 * @param emp
	 * 		Employé engagé
	 * @param dpt
	 * 		Départment de l'employé
	 */
	public void hireEmployee(Employee emp, Department dpt)
	{
		addEmployee(emp);
		if(dpt != null)
		{
			dpt.hireEmployee(emp);
			emp.EMPSetDepartment(dpt);
		}
	}
	
	/**
	 * Renvoie un employé en l'enlevant de la liste de tous les employés et de la liste d'employés de
	 * son département.
	 * @see Department#fireEmployee(Employee)
	 * @param emp
	 * 		Employé renvoyé
	 */
	public void fireEmployee(Employee emp)
	{
		removeEmployee(emp);
		emp.EMPGetDepartment().fireEmployee(emp);
	}
	/**
	 * Recherche un manager dans la liste via son ID
	 * @param ID
	 * 		ID recherché
	 * @return Manager recherché
	 * @throws Exception
	 * 		Index Invalide
	 */
	public Manager getManagerByID(long ID) throws Exception
	{
		for(Manager man: getManagerList())
		{
			if(man.EMPGetEmpID() == ID)
				return man;
		}
		throw new Exception("Invalid Index");
	}
	/**
	 * Recherche un employé dans la liste via son ID
	 * @param ID
	 * 		ID recherché
	 * @return Employé recherché
	 * @throws Exception
	 * 		Index invalide
	 */
	public Employee getEmployeeByID(long ID) throws Exception
	{
		for(Employee emp: getEmpList())
		{
			if(emp.EMPGetEmpID() == ID)
				return emp;
		}
		throw new Exception("Invalid Index");
	}
	/**
	 *  Recherche un ou des employés dans la liste via son/leur nom
	 * @param name
	 * 		Nom recherché
	 * @return Liste d'employés avec le nom recherché
	 */
	public ArrayList<Employee> getEmployeeByName(String name) 
	{
		ArrayList<Employee> retour = new ArrayList<Employee>();
		for(Employee emp: getEmpList())
		{
			if(emp.PERGetPersonName().equals(name))
				retour.add(emp);
		}
		return retour;

	}
	/**
	 *  Recherche un ou des employés dans la liste via son/leur prénom
	 * @param name
	 * 		Nom recherché
	 * @return Liste d'employés avec le prénom recherché
	 */
	public ArrayList<Employee> getEmployeeBySurname(String name) 
	{
		ArrayList<Employee> retour = new ArrayList<Employee>();
		for(Employee emp: getEmpList())
		{
			if(emp.PERGetPersonName().equals(name))
				retour.add(emp);
		}
		return retour;
	}
	/**
	 * Renvoie les employées dans un départment donné
	 * @param dpt
	 * 		Département
	 * @return Liste d'employés dans le département <i>dpt</i>.
	 * @throws Exception
	 * 		Objet non existant
	 */
	public ArrayList<Employee> getEmployeeByDepartment(Department dpt) throws Exception
	{
		for(Employee emp: getEmpList())
		{
			if(emp.EMPGetDepartment().getSDepName().equals(dpt.getSDepName()))
				return emp.EMPGetDepartment().getEmployeeList();
		}
		return null;
	}
	/**
	 * Renvoie les employés ayant une heure d'arrivée standard semblable
	 * @see Employee#EMPGetStdAT()
	 * @param stdat
	 * 		Heure d'arrivée standard recherchée
	 * @return Liste d'employés avec l'heure d'arrivée standard recherchée
	 */
	public ArrayList<Employee> getEmployeeByStdAT(HourMod stdat)
	{
		ArrayList<Employee> retour = new ArrayList<Employee>();
		for(Employee emp: getEmpList())
		{
			if(emp.EMPGetStdAT().equals(stdat))
				retour.add(emp);
		}
		return retour;
	}
	/**
	 * Renvoie les employés ayant une heure de départ standard semblable
	 * @see Employee#EMPGetStdDT()
	 * @param stddt
	 * 		Heure de départ standard recherchée
	 * @return Liste d'employés avec l'heure de départ standard recherchée
	 */
	public ArrayList<Employee> getEmployeeByStdDT(HourMod stddt)
	{
		ArrayList<Employee> retour = new ArrayList<Employee>();
		for(Employee emp: getEmpList())
		{
			if(emp.EMPGetStdDT().equals(stddt))
				retour.add(emp);
		}
		return retour;
	}
	/**
	 * Recherche un départment via son nom
	 * @param name
	 * 		Nom du départment recherché
	 * @return Département recherché
	 * @throws Exception
	 * 		Département non existant
	 */
	public Department getDepartment(String name) throws Exception
	{
		for(Department iter: getDptList())
		{
			if(iter.getSDepName().equals(name))
				return iter;
		}
		throw new Exception("No department found");
	}
	/**
	 * Affiche dans la console un objet Company et plusieurs de ses attributs
	 */
	public void printComp()
	{
		System.out.println("sCompanyName : "+sCompanyName+"\n");
		System.out.println("Boss info under : ");
		PERBoss.printPers();
		for(int iIter=0;iIter<DptList.size();iIter++)
		{
			System.out.println("Dpt number : "+iIter+"\n");
			DptList.get(iIter).printDept();
			System.out.println("\n");
		}
		
	}
	/**
	 * Convertit tous les attributs de tous les employés de l'entreprise en String
	 * pour les stocker dans un Object[][].
	 * @see Employee
	 * @return Un Object[][] contenant tous les attributs de tous les employés convertis en String
	 */
	public Object[][] getAllEmployeesString()
	{

		Object[][] returnList = new Object[getEmpList().size()][7];
		int compteur = 0;
		for(Employee currentEmp : getEmpList())
		{
				returnList[compteur][0]=currentEmp.EMPGetEmpID();
				returnList[compteur][1]=currentEmp.PERGetPersonName();
				returnList[compteur][2]=currentEmp.PERGetPersonSurname();
				returnList[compteur][3]=currentEmp.PERGetPersonContact();
				if(currentEmp.EMPGetDepartment()==null)
					returnList[compteur][4] = null;
				else
					returnList[compteur][4]=currentEmp.EMPGetDepartment().getSDepName();
				returnList[compteur][5]=currentEmp.EMPGetStdAT().toString();
				returnList[compteur][6]=currentEmp.EMPGetStdDT().toString();
				compteur++;
		}
		
		return returnList;
	}
	/**
	 * Stocke tous les PunchingIO et leurs attributs de l'entreprise dans un Object[][]
	 * @see PunchingIO
	 * @return Object[][] contenant tous les attributs des pointages de l'entreprise
	 */
	public Object[][] getAllPointages()
	{
		//Counting Punching for size
		int numberOfPunch=0;
		for(Employee currentEmp : getEmpList())
		{
			for(WorkingDay currentWorkingDay : currentEmp.EMPGetWorkindDayList())
			{
				if(currentWorkingDay.getPunchIn()!=null)
				{
					numberOfPunch++;
				}
				
				if(currentWorkingDay.getPunchOut()!=null)
				{
					numberOfPunch++;
				}
			}
		}
		
		//Filling object [][]
		Object[][] returnList = new Object[numberOfPunch][4];
		int compteur = 0;
		for(Employee currentEmp : getEmpList())
		{
			for(WorkingDay currentWorkingDay : currentEmp.EMPGetWorkindDayList())
			{
				if(currentWorkingDay.getPunchIn()!=null)
				{
					returnList[compteur][0]=currentWorkingDay.getPunchIn().getPunchDate();
					returnList[compteur][1]=currentWorkingDay.getPunchIn().getPunchHour();
					returnList[compteur][2]=currentWorkingDay.getPunchIn().getPunchingEmp().toString();
					returnList[compteur][3]="Entrée";
					compteur++;
				}
				
				if(currentWorkingDay.getPunchOut()!=null)
				{
					returnList[compteur][0]=currentWorkingDay.getPunchOut().getPunchDate();
					returnList[compteur][1]=currentWorkingDay.getPunchOut().getPunchHour();
					returnList[compteur][2]=currentWorkingDay.getPunchOut().getPunchingEmp().toString();
					returnList[compteur][3]="Sortie";
					compteur++;
				}
			}
		}
		return returnList;
	}
	/**
	 * Stocke tous les Department de l'entreprise et leurs attributs dans un Object[][]
	 * @see Department
	 * @return Object[][] contenant tous les départements de l'entreprise et leurs attributs
	 */
	public Object[][] getAllDepartments()
	{
		Object[][] returnList = new Object[getDptList().size()][4];
		int compteur = 0;
		for(Department currentDpt : getDptList())
		{
				returnList[compteur][0]=currentDpt.getSDepName();
				returnList[compteur][1]=currentDpt.getManager().PERGetPersonSurname() +" "+ currentDpt.getManager().PERGetPersonName();
				returnList[compteur][2]=currentDpt.getEmployeeList().size();
				returnList[compteur][3]=currentDpt.getManagerList().size();
				compteur++;
		}
		
		return returnList;
	}
	/**
	 * Stocke tous les Manager de l'entreprise et leurs attributs dans un Object[][]
	 * @see Manager
	 * @return Object[][] contenant tous les manangers de l'entreprise et leurs attributs
	 */
	public Object[][] getAllManager()
	{
		
		Object[][] returnList = new Object[getManagerList().size()][7];
		int compteur = 0;
		for(Manager currentMan : getManagerList())
		{
				returnList[compteur][0]=currentMan.EMPGetEmpID();
				returnList[compteur][1]=currentMan.PERGetPersonName();
				returnList[compteur][2]=currentMan.PERGetPersonSurname();
				returnList[compteur][3]=currentMan.PERGetPersonContact();
				returnList[compteur][4]=currentMan.EMPGetDepartment().getSDepName();
				returnList[compteur][5]=currentMan.EMPGetStdAT().toString();
				returnList[compteur][6]=currentMan.EMPGetStdDT().toString();
				compteur++;
		}
		
		return returnList;
	}
	
	/**
	 * Stocke tous les PunchingIO ayant comme date <i>wantedDate</i> et leurs attributs 
	 * dans un Object[][]
	 * @see PunchingIO
	 * @param wantedDate
	 * 		Date recherchée
	 * @return Object[][] contenant tous les attributs des pointages de l'entreprise
	 */
	public Object[][] getAllPointagesByDate(LocalDate wantedDate)
	{
		//Counting Punching for size
				int numberOfPunch=0;
				for(Employee currentEmp : getEmpList())
				{
					for(WorkingDay currentWorkingDay : currentEmp.EMPGetWorkindDayList())
					{
						if(currentWorkingDay.getPunchIn()!=null
								&&currentWorkingDay.getPunchIn().getPunchDate().equals(wantedDate))
						{
							numberOfPunch++;
						}
						
						if(currentWorkingDay.getPunchOut()!=null
								&&currentWorkingDay.getPunchOut().getPunchDate().equals(wantedDate))
						{
							numberOfPunch++;
						}
					}
				}
				
				//Filling object [][]
				Object[][] returnList = new Object[numberOfPunch][4];
				int compteur = 0;
				for(Employee currentEmp : getEmpList())
				{
					for(WorkingDay currentWorkingDay : currentEmp.EMPGetWorkindDayList())
					{
						if(currentWorkingDay.getPunchIn()!=null
								&&currentWorkingDay.getPunchIn().getPunchDate().equals(wantedDate))
						{
							returnList[compteur][0]=currentWorkingDay.getPunchIn().getPunchDate();
							returnList[compteur][1]=currentWorkingDay.getPunchIn().getPunchHour();
							returnList[compteur][2]=currentWorkingDay.getPunchIn().getPunchingEmp().toString();
							returnList[compteur][3]="Punching in";
							compteur++;
						}
						
						if(currentWorkingDay.getPunchOut()!=null
								&&currentWorkingDay.getPunchOut().getPunchDate().equals(wantedDate))
						{
							returnList[compteur][0]=currentWorkingDay.getPunchOut().getPunchDate();
							returnList[compteur][1]=currentWorkingDay.getPunchOut().getPunchHour();
							returnList[compteur][2]=currentWorkingDay.getPunchOut().getPunchingEmp().toString();
							returnList[compteur][3]="Punching out";
							compteur++;
						}
					}
				}
				return returnList;
	}
	
	/**
	 * Stocke tous les PunchingIO de l'employé <i>emp</i> et leurs attributs 
	 * dans un Object[][]
	 * @see PunchingIO
	 * @param emp
	 * 		Employé recherchée
	 * @return Object[][] contenant tous les attributs des pointages de l'entreprise
	 */
	public Object[][] getAllPointagesByEmployee(Employee emp)
	{
		//Counting Punching for size
				int numberOfPunch=0;
				for(WorkingDay currentWorkingDay : emp.EMPGetWorkindDayList())
				{
					if(currentWorkingDay.getPunchIn()!=null)
					{numberOfPunch++;}
					if(currentWorkingDay.getPunchOut()!=null)
					{numberOfPunch++;}
				}

				
				//Filling object [][]
				Object[][] returnList = new Object[numberOfPunch][4];
				int compteur = 0;

				for(WorkingDay currentWorkingDay : emp.EMPGetWorkindDayList())
				{
					if(currentWorkingDay.getPunchIn()!=null)
					{
						returnList[compteur][0]=currentWorkingDay.getPunchIn().getPunchDate();
						returnList[compteur][1]=currentWorkingDay.getPunchIn().getPunchHour();
						returnList[compteur][2]=currentWorkingDay.getPunchIn().getPunchingEmp().toString();
						returnList[compteur][3]="Punching in";
						compteur++;
					}
					
					if(currentWorkingDay.getPunchOut()!=null)
					{
						returnList[compteur][0]=currentWorkingDay.getPunchOut().getPunchDate();
						returnList[compteur][1]=currentWorkingDay.getPunchOut().getPunchHour();
						returnList[compteur][2]=currentWorkingDay.getPunchOut().getPunchingEmp().toString();
						returnList[compteur][3]="Punching out";
						compteur++;
					}
				}

				return returnList;
	}
	
	/**
	 * Stocke tous les PunchingIO du département <i>dpt</i> et leurs attributs 
	 * dans un Object[][]
	 * @see PunchingIO
	 * @param dpt
	 * 		Département recherchée
	 * @return Object[][] contenant tous les attributs des pointages de l'entreprise
	 */
	public Object[][] getAllPointagesByDepartment(Department dpt)
	{
		//Counting Punching for size
				int numberOfPunch=0;
				for(Employee currentEmp : dpt.getEmployeeList())
				{
					for(WorkingDay currentWorkingDay : currentEmp.EMPGetWorkindDayList())
					{
						if(currentWorkingDay.getPunchIn()!=null)
						{numberOfPunch++;}
						if(currentWorkingDay.getPunchOut()!=null)
						{numberOfPunch++;}
					}
				}

				
				//Filling object [][]
				Object[][] returnList = new Object[numberOfPunch][4];
				int compteur = 0;

				for(Employee currentEmp : dpt.getEmployeeList())
				{
					for(WorkingDay currentWorkingDay : currentEmp.EMPGetWorkindDayList())
					{
						if(currentWorkingDay.getPunchIn()!=null)
						{
							returnList[compteur][0]=currentWorkingDay.getPunchIn().getPunchDate();
							returnList[compteur][1]=currentWorkingDay.getPunchIn().getPunchHour();
							returnList[compteur][2]=currentWorkingDay.getPunchIn().getPunchingEmp().toString();
							returnList[compteur][3]="Punching in";
							compteur++;
						}
						
						if(currentWorkingDay.getPunchOut()!=null)
						{
							returnList[compteur][0]=currentWorkingDay.getPunchOut().getPunchDate();
							returnList[compteur][1]=currentWorkingDay.getPunchOut().getPunchHour();
							returnList[compteur][2]=currentWorkingDay.getPunchOut().getPunchingEmp().toString();
							returnList[compteur][3]="Punching out";
							compteur++;
						}
					}
				}

				return returnList;
	}
	
}
