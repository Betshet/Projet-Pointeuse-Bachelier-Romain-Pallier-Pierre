 package model;
import java.util.ArrayList;
import java.time.*;

/**
 * La classe Employee permet de créer des objets Employee, décrivant un employé de l'entreprise
 * et ses attributs qui sont :
 * <ul>
 * <li>Un identifiant d'employé
 * <li>Un départment
 * <li>Une heure standard d'arrivée
 * <li>Une heure standard de départ
 * <li>Une liste de jours de travail
 * </ul>
 * 
 * <p>Il est possible d'ajouter des jours de travrail ou d'en enlever.</p>
 *
 */
public class Employee extends Person implements java.io.Serializable{
	

	private static final long serialVersionUID = -488295036120737115L;
	/**
	 * ID de l'employé
	 */
	private long iIDEmp;
	/**
	 * Départment de l'employé
	 */
	private Department DEPDpt;
	/**
	 * Heure standard d'arrivée
	 */
	private HourMod HMODStdAT;
	/**
	 * Heure standard de départ
	 */
	private HourMod HMODStdDT;
	/**
	 * Liste des jours de travails de l'employé
	 */
	private ArrayList<WorkingDay> lWORDaysList;
	/**
	 * Constructeur par défaut
	 * <p>Crée un Employee vide.</p>
	 */
	public Employee(){
		super();
		iIDEmp = -1;
		DEPDpt = null;
		HMODStdAT = null; //standard arrival time
		HMODStdAT = null; // standard departure time
		lWORDaysList = null;
	}
	/**
	 * Constructeur de confort
	 * <p>Crée un Employee et initialise ses attributs avec les valeurs données en paramètres</p>
	 * @param EmpName
	 * 		Nom de l'employé
	 * @param EmpSurname
	 * 		Prénom de l'employé
	 * @param ID
	 * 		Id de l'employé
	 * @param EmpContact
	 * 		Contact de l'employé
	 * @param hourMod
	 * 		Heure d'arrivée standard
	 * @param hourMod2
	 * 		Heure de départ standard
	 */
	public Employee(String EmpName, String EmpSurname, long ID, String EmpContact, HourMod hourMod, HourMod hourMod2){
		super(EmpName,EmpSurname,EmpContact);
		iIDEmp = ID;
		DEPDpt = null;
		HMODStdAT = hourMod;
		HMODStdDT = hourMod2;
		lWORDaysList = new ArrayList<WorkingDay>();
	}
	

	/**
	 * Change l'ID de l'employé
	 * @param newID
	 * 		Nouvel ID
	 */
	public void EMPSetEmpID(long newID){
		iIDEmp = newID;
	}
	/**
	 * 
	 * @return Id de l'employé
	 */
	public long EMPGetEmpID(){
		return(iIDEmp);
	}
	/**
	 * Change le département
	 * @param newDpt
	 * 		Nouveau département
	 */
	public void EMPSetDepartment(Department newDpt){
		DEPDpt = newDpt;
	}
	/**
	 * 
	 * @return Départment de l'employé
	 */
	public Department EMPGetDepartment(){
		return(DEPDpt);
	}
	/**
	 * Change l'heure d'arrivée standard
	 * @param newStdAT
	 * 		Nouvelle heure d'arrivée
	 */
	public void EMPSetStdAT(HourMod newStdAT){
		HMODStdAT = newStdAT;
	}
	/**
	 * 
	 * @return Heure d'arrivée standard
	 */
	public HourMod EMPGetStdAT(){ //attention difference entre dt et at !
		return(HMODStdAT);
	}
	/**
	 * Change l'heure de départ standard
	 * @param newStdDT
	 * 		Nouvelle heure de départ
	 */
	public void EMPSetStdDT(HourMod newStdDT){
		HMODStdDT = newStdDT;
	}
	/**
	 * 
	 * @return Heure de départ standard
	 */
	public HourMod EMPGetStdDT(){
		return(HMODStdDT);
	}
	
	/**
	 * 
	 * @return Liste de WorkingDay de l'employé
	 * @see WorkingDay
	 */
	public ArrayList<WorkingDay> EMPGetWorkindDayList()
	{
		return lWORDaysList;
	}
	/**
	 * Ajoute un WorkingDay à la liste de l'employé
	 * @param newWorkingDay
	 * 		Nouveau WorkingDay
	 */
	public void EMPAddWorkingDay(WorkingDay newWorkingDay){
		lWORDaysList.add(newWorkingDay);
	}
	/**
	 * Retire un WorkingDay de la liste dont la date et l'heure correspondent à RMDate et RMTime
	 * @param RMDate
	 * 		Date recherchée
	 * @param RMTime
	 * 		Heure recherchée
	 */
	public void EMPRemoveWorkingDay(LocalDate RMDate,LocalTime RMTime)
	{
		//à gerer : absence du workingday
		for(int iter = 0; iter < lWORDaysList.size(); iter++)
		{
			if(lWORDaysList.get(iter).getPunchIn().getPunchDate()== RMDate 
					&& lWORDaysList.get(iter).getPunchIn().getPunchHour().getHour()==RMTime )
				lWORDaysList.remove(lWORDaysList.get(iter));
		}
	}
	/**
	 * Recherche un WorkingDay de la liste dont la date et l'heure correspondent à RMDate et RMTime
	 * @param GetDate
	 * 		Date recherchée
	 * @param GetTime
	 * 		Heure recherchée
	 * @return Jour de travail correspondant, ou null
	 */
	public WorkingDay EMPGetWorkingDay(LocalDate GetDate,LocalTime GetTime)
	{
		//à gerer : absence du workingday
		for(WorkingDay iter : lWORDaysList)
		{
			if(iter.getPunchIn().getPunchDate()== GetDate 
					&& iter.getPunchIn().getPunchHour().getHour()==GetTime )
				return iter;
		}
		return null; // ?
	}
	
	
	/**
	 * Convertit en String un employé et ses attributs
	 */
	public String toString(){
		return Integer.toString((int) iIDEmp)+" "+super.toString();
	}
	/**
	 * Affiche dans la console un employé
	 */
	public void printEmp()
	{
		System.out.println("Employee info under : ");
		this.printPers();
		System.out.println("iIDEmp : "+iIDEmp);
		System.out.println("Standard arrival");
		HMODStdAT.printHourMod();
		System.out.println("Standard departure");
		HMODStdDT.printHourMod();
		//print HMod1
		//print HMod2
		//print WorkingDaylist
	}
	
}
