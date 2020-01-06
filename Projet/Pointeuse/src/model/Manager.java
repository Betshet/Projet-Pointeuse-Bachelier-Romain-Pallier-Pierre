package model;

/**
 * La classe Manager permet de créer des objets Manager, décrivant un manager de l'entreprise et s'il 
 * dirige effectivement un département.
 * <p>Il est possible de déclarer le manager comme "actif" ou "inactif", respectivement dirigeant
 * ou ne dirigeant pas de département.</p>
 *
 */
public class Manager extends Employee implements java.io.Serializable{
	//PAS SUR POUR LE STATUT DEMPLOYE !
	private static final long serialVersionUID = 1L;
	/**
	 * Statut du manager. <i>True</i>signifie qu'il dirige un département, <i>false</i> qu'il n'en dirige pas.
	 */
	private boolean Active;
	/**
	 * Constructeur par défaut.
	 */
	public Manager(){
		super();
	}
	/**
	 * Constructeur de confort
	 * <p>Crée un employé Manager.</p>
	 * @param ManName
	 * 		Nom du Manager
	 * @param ManSurname
	 * 		Prénom du Manager
	 * @param ManContact
	 * 		Contact du Manager
	 * @param ManID
	 * 		ID du Manager
	 * @param ManSdtAT
	 * 		Heure standard d'arrivée
	 * @param ManStdDT
	 * 		Heure standard de départ
	 */
	public Manager(String ManName, String ManSurname, String ManContact, long ManID, HourMod ManSdtAT, HourMod ManStdDT){
		super(ManName,ManSurname,ManID,ManContact,ManSdtAT,ManStdDT);
		Active = false;
	}

	/**
	 * 
	 * @return Statut actif ou non du Manager
	 */
	public boolean MANisActive() {
		return Active;
	}

	/**
	 * Change le statut actif ou inactif du Manager
	 * @param active
	 * 		Nouveau statut du Manager
	 */
	public void MANsetActive(boolean active) {
		Active = active;
	}
	
	
}
