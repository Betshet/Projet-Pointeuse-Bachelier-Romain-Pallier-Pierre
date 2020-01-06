package model;

/**
 * La classe Manager permet de cr�er des objets Manager, d�crivant un manager de l'entreprise et s'il 
 * dirige effectivement un d�partement.
 * <p>Il est possible de d�clarer le manager comme "actif" ou "inactif", respectivement dirigeant
 * ou ne dirigeant pas de d�partement.</p>
 *
 */
public class Manager extends Employee implements java.io.Serializable{
	//PAS SUR POUR LE STATUT DEMPLOYE !
	private static final long serialVersionUID = 1L;
	/**
	 * Statut du manager. <i>True</i>signifie qu'il dirige un d�partement, <i>false</i> qu'il n'en dirige pas.
	 */
	private boolean Active;
	/**
	 * Constructeur par d�faut.
	 */
	public Manager(){
		super();
	}
	/**
	 * Constructeur de confort
	 * <p>Cr�e un employ� Manager.</p>
	 * @param ManName
	 * 		Nom du Manager
	 * @param ManSurname
	 * 		Pr�nom du Manager
	 * @param ManContact
	 * 		Contact du Manager
	 * @param ManID
	 * 		ID du Manager
	 * @param ManSdtAT
	 * 		Heure standard d'arriv�e
	 * @param ManStdDT
	 * 		Heure standard de d�part
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
