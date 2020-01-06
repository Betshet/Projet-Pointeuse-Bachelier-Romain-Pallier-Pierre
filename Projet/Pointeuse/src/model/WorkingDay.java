package model;
import java.io.Serializable;
import java.time.*;

/**
 * La classe WorkingDay permet de cr�er des jours ouvr�s, avec ces attributs :
 * <ul>
 * <li>Un employ� travaillant ce jour-ci
 * <li>Un pointage entrant
 * <li>Un pointage sortant
 * </ul>
 * <p>Un WorkingDay est cr�� lors d'un premier pointage entrant. Si multiple sorties en journ�e ont lieu
 *  on cr�e de nouveaux WorkingDay pour correspondre aux pointages entrants et sortants.</p>
 */
public class WorkingDay implements Serializable{
	private static final long serialVersionUID = -1864525357380450638L;
	/**
	 * Employ� travaillant
	 */
	private Employee WorkingEmployee;
	/**
	 * Pointage entrant
	 */
	private PunchingIO PunchIn;
	/**
	 * Pointage sortant
	 */
	private PunchingIO PunchOut;
	
	//si on sort en journee on cree un nouveau workingday
	/**
	 * Constructeur par d�faut
	 */
	public WorkingDay()
	{
		setWorkingEmployee(new Employee());
		setPunchIn(null);
		setPunchOut(null);
	}
	/**
	 * Constructeur de confort
	 * <p>Cr�e un jour de travail</p>
	 * @param WorkingEmp
	 * 		Employ� travaillant
	 * @param PUNPunchIn
	 * 		Pointage entrant
	 * @param PUNPunchOut
	 * 		Pointage sortant
	 */
	public WorkingDay(Employee WorkingEmp ,PunchingIO PUNPunchIn ,PunchingIO PUNPunchOut )
	{
		setWorkingEmployee(WorkingEmp);
		setPunchIn(PUNPunchIn);
		setPunchOut(PUNPunchOut);
	}
	
	/**
	 * Instancie un PunchingIO et le place dans PunchIn. A appeler quand un employ�
	 * fait un pointage entrant.
	 * @see PunchingIO#PunchingIO(LocalDate, LocalTime, boolean, Employee)
	 * @param LDTPunchDate
	 * 		Date du pointage
	 * @param LDTPunchHour
	 * 		Heure du pointage
	 */
	public void WORgetIn(LocalDate LDTPunchDate,LocalTime LDTPunchHour)
	{
		setPunchIn(new PunchingIO(LDTPunchDate,LDTPunchHour, true, WorkingEmployee));
	}
	/**
	 * Instancie un PunchingIO et le place dans PunchOut. A appeler quand un employ�
	 * fait un pointage sortant.
	 * @see PunchingIO#PunchingIO(LocalDate, LocalTime, boolean, Employee)
	 * @param LDTPunchDate
	 * 		Date du pointage
	 * @param LDTPunchHour
	 * 		Heure du pointage
	 */
	public void WORgetOut(LocalDate LDTPunchDate,LocalTime LDTPunchHour)
	{
		setPunchOut(new PunchingIO(LDTPunchDate,LDTPunchHour, false, WorkingEmployee));
	}

	/**
	 * 
	 * @return Employ� travaillant
	 */
	public Employee getWorkingEmployee() {
		return WorkingEmployee;
	}
	/**
	 * Change l'employ� travaillant
	 * @param workingEmployee
	 * 		Nouvel employ� travaillant
	 */
	public void setWorkingEmployee(Employee workingEmployee) {
		WorkingEmployee = workingEmployee;
	}
	/**
	 *
	 * @return Pointage entrant
	 */
	public PunchingIO getPunchIn() {
		return PunchIn;
	}
	/**
	 * Change le pointage entrant
	 * @param punchIn
	 * 		Nouveau pointage entrant
	 */
	public void setPunchIn(PunchingIO punchIn) {
		PunchIn = punchIn;
	}
	/**
	 * 
	 * @return Pointage sortant
	 */
	public PunchingIO getPunchOut() {
		return PunchOut;
	}
	/**
	 * Change le pointage sortant
	 * @param punchOut
	 * 		Nouveau pointage sortant
	 */
	public void setPunchOut(PunchingIO punchOut) {
		PunchOut = punchOut;
	}
	/**
	 * Affiche dans la console un WorkingDay et ses attributs.
	 */
	public void printWDay()
	{
		/*System.out.println("Working employee info under : \n");
		WorkingEmployee.printEmp();*/
		System.out.println("Punch in under : \n");
		PunchIn.printPunching();
		System.out.println("Punch out under : \n");
		PunchOut.printPunching();
	}
	/**
	 * Convertit en String un pointage entrant
	 * @see PunchingIO#toString()
	 * @return
	 * 		Pointage entrant converti en String
	 */
	public String toStringPunchIn()
	{
		return getPunchIn().toString();
	}
	/**
	 * Convertit en String un pointage sortant
	 * @see PunchingIO#toString()
	 * @return
	 * 		Pointage sortant converti en String
	 */
	public String toStringPunchOut()
	{
		return getPunchOut().toString();
	}
	
}
