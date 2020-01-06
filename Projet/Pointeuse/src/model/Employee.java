 package model;
import java.util.ArrayList;
import java.time.*;

/**
 * La classe Employee permet de cr�er des objets Employee, d�crivant un employ� de l'entreprise
 * et ses attributs qui sont :
 * <ul>
 * <li>Un identifiant d'employ�
 * <li>Un d�partment
 * <li>Une heure standard d'arriv�e
 * <li>Une heure standard de d�part
 * <li>Une liste de jours de travail
 * </ul>
 * 
 * <p>Il est possible d'ajouter des jours de travrail ou d'en enlever.</p>
 *
 */
public class Employee extends Person implements java.io.Serializable{
	

	private static final long serialVersionUID = -488295036120737115L;
	/**
	 * ID de l'employ�
	 */
	private long iIDEmp;
	/**
	 * D�partment de l'employ�
	 */
	private Department DEPDpt;
	/**
	 * Heure standard d'arriv�e
	 */
	private HourMod HMODStdAT;
	/**
	 * Heure standard de d�part
	 */
	private HourMod HMODStdDT;
	/**
	 * Liste des jours de travails de l'employ�
	 */
	private ArrayList<WorkingDay> lWORDaysList;
	/**
	 * Constructeur par d�faut
	 * <p>Cr�e un Employee vide.</p>
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
	 * <p>Cr�e un Employee et initialise ses attributs avec les valeurs donn�es en param�tres</p>
	 * @param EmpName
	 * 		Nom de l'employ�
	 * @param EmpSurname
	 * 		Pr�nom de l'employ�
	 * @param ID
	 * 		Id de l'employ�
	 * @param EmpContact
	 * 		Contact de l'employ�
	 * @param hourMod
	 * 		Heure d'arriv�e standard
	 * @param hourMod2
	 * 		Heure de d�part standard
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
	 * Change l'ID de l'employ�
	 * @param newID
	 * 		Nouvel ID
	 */
	public void EMPSetEmpID(long newID){
		iIDEmp = newID;
	}
	/**
	 * 
	 * @return Id de l'employ�
	 */
	public long EMPGetEmpID(){
		return(iIDEmp);
	}
	/**
	 * Change le d�partement
	 * @param newDpt
	 * 		Nouveau d�partement
	 */
	public void EMPSetDepartment(Department newDpt){
		DEPDpt = newDpt;
	}
	/**
	 * 
	 * @return D�partment de l'employ�
	 */
	public Department EMPGetDepartment(){
		return(DEPDpt);
	}
	/**
	 * Change l'heure d'arriv�e standard
	 * @param newStdAT
	 * 		Nouvelle heure d'arriv�e
	 */
	public void EMPSetStdAT(HourMod newStdAT){
		HMODStdAT = newStdAT;
	}
	/**
	 * 
	 * @return Heure d'arriv�e standard
	 */
	public HourMod EMPGetStdAT(){ //attention difference entre dt et at !
		return(HMODStdAT);
	}
	/**
	 * Change l'heure de d�part standard
	 * @param newStdDT
	 * 		Nouvelle heure de d�part
	 */
	public void EMPSetStdDT(HourMod newStdDT){
		HMODStdDT = newStdDT;
	}
	/**
	 * 
	 * @return Heure de d�part standard
	 */
	public HourMod EMPGetStdDT(){
		return(HMODStdDT);
	}
	
	/**
	 * 
	 * @return Liste de WorkingDay de l'employ�
	 * @see WorkingDay
	 */
	public ArrayList<WorkingDay> EMPGetWorkindDayList()
	{
		return lWORDaysList;
	}
	/**
	 * Ajoute un WorkingDay � la liste de l'employ�
	 * @param newWorkingDay
	 * 		Nouveau WorkingDay
	 */
	public void EMPAddWorkingDay(WorkingDay newWorkingDay){
		lWORDaysList.add(newWorkingDay);
	}
	/**
	 * Retire un WorkingDay de la liste dont la date et l'heure correspondent � RMDate et RMTime
	 * @param RMDate
	 * 		Date recherch�e
	 * @param RMTime
	 * 		Heure recherch�e
	 */
	public void EMPRemoveWorkingDay(LocalDate RMDate,LocalTime RMTime)
	{
		//� gerer : absence du workingday
		for(int iter = 0; iter < lWORDaysList.size(); iter++)
		{
			if(lWORDaysList.get(iter).getPunchIn().getPunchDate()== RMDate 
					&& lWORDaysList.get(iter).getPunchIn().getPunchHour().getHour()==RMTime )
				lWORDaysList.remove(lWORDaysList.get(iter));
		}
	}
	/**
	 * Recherche un WorkingDay de la liste dont la date et l'heure correspondent � RMDate et RMTime
	 * @param GetDate
	 * 		Date recherch�e
	 * @param GetTime
	 * 		Heure recherch�e
	 * @return Jour de travail correspondant, ou null
	 */
	public WorkingDay EMPGetWorkingDay(LocalDate GetDate,LocalTime GetTime)
	{
		//� gerer : absence du workingday
		for(WorkingDay iter : lWORDaysList)
		{
			if(iter.getPunchIn().getPunchDate()== GetDate 
					&& iter.getPunchIn().getPunchHour().getHour()==GetTime )
				return iter;
		}
		return null; // ?
	}
	
	
	/**
	 * Convertit en String un employ� et ses attributs
	 */
	public String toString(){
		return Integer.toString((int) iIDEmp)+" "+super.toString();
	}
	/**
	 * Affiche dans la console un employ�
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
