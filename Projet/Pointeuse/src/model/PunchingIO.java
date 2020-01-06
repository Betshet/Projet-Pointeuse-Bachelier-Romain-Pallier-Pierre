package model;
import java.time.*;

/**
 * La classe PunchingIO permet de créer des pointages, générés au moment où l'employé
 * utilise la pointeuse. Un PunchingIO contient :
 * <ul>
 * <li>Une date de pointage
 * <li>Une heure de pointage
 * <li>Un booléen indiquant s'il s'agit d'un pointage entrant ou sortant
 * <li>Un employé, qui a effectué le pointage
 * </ul>
 */
public class PunchingIO implements java.io.Serializable{
	
	private static final long serialVersionUID = -3116600432979746L;
	/**
	 * Date de pointage
	 */
	private LocalDate punchDate;
	/**
	 * Heure de pointage
	 */
	private HourMod punchHour;
	/**
	 * Statut du pointage, <i>true</i> si il est entrant,<i>false</i> sinon
	 */
	private boolean bIn;
	/**
	 * Employé ayant pointé
	 */
	private Employee punchingEmp;
	/**
	 * Constructeur par défaut
	 */
	public PunchingIO()
	{
		setPunchDate(null);
		punchHour=null;
		bIn=false;
		setPunchingEmp(new Employee());
	}
	/**
	 * Constructeur de confort.
	 * <p>Crée un pointage</p>
	 * @param punchingDate
	 * 		Date de pointage
	 * @param punchingHour
	 * 		Heure de pointage
	 * @param bIsIn
	 * 		Statut du pointage
	 * @param punchEmp
	 * 		Employé ayant pointé
	 */
	public PunchingIO(LocalDate punchingDate, LocalTime punchingHour, boolean bIsIn, Employee punchEmp)
	{
		setPunchDate(punchingDate);
		punchHour=new HourMod(punchingHour);
		bIn=bIsIn;
		setPunchingEmp(punchEmp);
	}
	/**
	 * 
	 * @return Date de pointage
	 */
	public LocalDate getPunchDate() {
		return punchDate;
	}
	/**
	 * Change la date de pointage
	 * @param punchDate 
	 * 		Nouvelle date de pointage
	 */
	public void setPunchDate(LocalDate punchDate) {
		this.punchDate = punchDate;
	}
	/**
	 * 
	 * @return Heure de pointage
	 */
	public HourMod getPunchHour() {
		return punchHour;
	}
	/**
	 * Change l'heure de pointage
	 * @param NewPunchDate
	 * 		Nouvelle heure de pointage
	 */
	public void setPunchHour(LocalTime NewPunchDate) {
		punchHour.setHour(NewPunchDate);
	}
	/**
	 * 
	 * @return Statut du pointage
	 */
	public boolean isbIn() {
		return bIn;
	}
	/**
	 * Change le statut du pointage, <i>true</i> si il est entrant, <i>false</i> sinon
	 * @param bNewIn
	 * 		Nouveau statut du pointage
	 */
	public void setbIn(boolean bNewIn) {
		bIn = bNewIn;
	}
	/**
	 * 
	 * @return Employé ayant pointé
	 */
	public Employee getPunchingEmp() {
		return punchingEmp;
	}
	/**
	 * Change l'employé ayant pointé
	 * @param EMPNewPunchingEmp
	 * 		Nouvel employé pointeur
	 */
	public void setPunchingEmp(Employee EMPNewPunchingEmp) {
		punchingEmp = EMPNewPunchingEmp;
	}
	/**
	 * Affiche dans la console un objet PunchingIO et ses attributs
	 */
	public void printPunching()
	{
		System.out.println("Punch Hour under : \n");
		punchHour.printHourMod();
	}
}
