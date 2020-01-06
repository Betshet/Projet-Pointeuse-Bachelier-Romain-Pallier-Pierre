package model;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * La classe Company permet de cr�er des objets Company, contenant toutes les composantes
 * de l'entreprise.
 * <ul>
 * <li>Un nom d'entreprise
 * <li>Un chef d'entreprise
 * <li>Une liste de d�partements
 * <li>Une liste d'employ�s
 * <li>Une liste de managers
 * <li>Un compteur d'Id uniques, utilis� pour donner des ID uniques aux employ�s embauch�s
 * </ul>
 * 
 * <p>Il est possible d'embaucher ou de renvoyer des employ�s et managers, ainsi que de cr�er
 * de nouveau d�partements.</p>
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
	 * Liste de tous les d�partments
	 */
	private ArrayList<Department> DptList;
	/**
	 * Liste de tous les employ�s
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
	 * Constructeur Company par d�faut
	 * <p>Cr�e une Company vide. </p>
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
	 * <p>Cr�e une Company avec sCompName en nom d'entreprise, et avec Boss comme chef
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
	 * @return Liste de d�partements
	 */
	public  ArrayList<Department> getDptList()
	{
		return DptList;
	}
	/**
	 * 
	 * @return Liste d'employ�s
	 */
	public ArrayList<Employee> getEmpList() {
		return EmpList;
	}
	/**
	 * Change la liste d'employ�s
	 * @param empList
	 * 		Nouvelle liste d'employ�s
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
	 * @return Num�ro actuel du compteur d'ID uniques
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
	 * G�n�re un ID unique en incr�mentant la valeur du compteur
	 * @return Un ID unique
	 */
	public long uniqueID()
	{
		setUniqueIDcount(uniqueIDcount+1);
		return getUniqueIDcount();
	}

	/**
	 * Engage un nouveau manager dans un d�partment donn�?
	 * @param newManager
	 * 		Manager engag�
	 * @param dpt
	 * 		D�partement o� le manager est engag�
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
	 * 		Manager � renvoyer
	 */
	public void fireManager(Manager man)
	{
		getManagerList().remove(man);
		man.EMPGetDepartment().fireManager(man);
	}
	/**
	 * Ajoute un d�partment � la liste de d�partements
	 * @param newDepartment
	 * 		D�partement � ajouter
	 */
	public void addDepartment(Department newDepartment)
	{
		DptList.add(newDepartment);
	}
	
	/**
	 * Retire un d�partment de la liste
	 * @param oldDepartment
	 * 		D�partment � retirer
	 */
	public void removeDepartment(Department oldDepartment)
	{
		DptList.remove(oldDepartment); 
	}
	
	/**
	 * Cr�e un d�partement et l'ajoute � la liste de tous les d�partements
	 * @param nomDpt
	 * 		Nom du d�partement cr��
	 * @param manager
	 * 		Nom du Manager du D�partement
	 */
	public void createDepartment(String nomDpt, Manager manager)
	{
		addDepartment(new Department(nomDpt,manager));
	}
	/**
	 * Ajoute un employ� � la liste des employ�s
	 * @param emp
	 * 		Employ� ajout�
	 */
	private void addEmployee(Employee emp)
	{
		getEmpList().add(emp);
	}
	/**
	 * Retire un employ� de la liste des employ�s
	 * @param emp
	 * 		Employ� retir�
	 */
	private void removeEmployee(Employee emp)
	{
		getEmpList().remove(emp);
	}
	/**
	 * Engage un employ� et l'ajoute � la liste des employ�s
	 * @param emp
	 * 		Employ� engag�
	 * @param dpt
	 * 		D�partment de l'employ�
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
	 * Renvoie un employ� en l'enlevant de la liste de tous les employ�s et de la liste d'employ�s de
	 * son d�partement.
	 * @see Department#fireEmployee(Employee)
	 * @param emp
	 * 		Employ� renvoy�
	 */
	public void fireEmployee(Employee emp)
	{
		removeEmployee(emp);
		emp.EMPGetDepartment().fireEmployee(emp);
	}
	/**
	 * Recherche un manager dans la liste via son ID
	 * @param ID
	 * 		ID recherch�
	 * @return Manager recherch�
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
	 * Recherche un employ� dans la liste via son ID
	 * @param ID
	 * 		ID recherch�
	 * @return Employ� recherch�
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
	 *  Recherche un ou des employ�s dans la liste via son/leur nom
	 * @param name
	 * 		Nom recherch�
	 * @return Liste d'employ�s avec le nom recherch�
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
	 *  Recherche un ou des employ�s dans la liste via son/leur pr�nom
	 * @param name
	 * 		Nom recherch�
	 * @return Liste d'employ�s avec le pr�nom recherch�
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
	 * Renvoie les employ�es dans un d�partment donn�
	 * @param dpt
	 * 		D�partement
	 * @return Liste d'employ�s dans le d�partement <i>dpt</i>.
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
	 * Renvoie les employ�s ayant une heure d'arriv�e standard semblable
	 * @see Employee#EMPGetStdAT()
	 * @param stdat
	 * 		Heure d'arriv�e standard recherch�e
	 * @return Liste d'employ�s avec l'heure d'arriv�e standard recherch�e
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
	 * Renvoie les employ�s ayant une heure de d�part standard semblable
	 * @see Employee#EMPGetStdDT()
	 * @param stddt
	 * 		Heure de d�part standard recherch�e
	 * @return Liste d'employ�s avec l'heure de d�part standard recherch�e
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
	 * Recherche un d�partment via son nom
	 * @param name
	 * 		Nom du d�partment recherch�
	 * @return D�partement recherch�
	 * @throws Exception
	 * 		D�partement non existant
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
	 * Convertit tous les attributs de tous les employ�s de l'entreprise en String
	 * pour les stocker dans un Object[][].
	 * @see Employee
	 * @return Un Object[][] contenant tous les attributs de tous les employ�s convertis en String
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
					returnList[compteur][3]="Entr�e";
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
	 * @return Object[][] contenant tous les d�partements de l'entreprise et leurs attributs
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
	 * 		Date recherch�e
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
	 * Stocke tous les PunchingIO de l'employ� <i>emp</i> et leurs attributs 
	 * dans un Object[][]
	 * @see PunchingIO
	 * @param emp
	 * 		Employ� recherch�e
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
	 * Stocke tous les PunchingIO du d�partement <i>dpt</i> et leurs attributs 
	 * dans un Object[][]
	 * @see PunchingIO
	 * @param dpt
	 * 		D�partement recherch�e
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
