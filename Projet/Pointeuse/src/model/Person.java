package model;


/**
 * La classe Person permet de cr�er des personnes, les entit�s composant l'entreprise,
 * et leurs attributs qui sont :
 * <ul>
 * <li>Un nom
 * <li>Un pr�nom
 * <li>Un contact (mail g�n�ralement)
 * </ul>
 */
public class Person implements java.io.Serializable {
	
	private static final long serialVersionUID = 8022310804395722104L;
	/**
	 * Nom de la personne
	 */
	private String sName;
	/**
	 * Pr�nom de la personne
	 */
	private String sSurname;
	/**
	 * Contact de la personne
	 */
	private String sContact;
	/**
	 * Constructeur par d�faut
	 */
	public Person(){
		sName = null;
		sSurname = null;
		sContact = null;
	}
	/**
	 * Constructeur de confort
	 * <p>Cr�e une personne</p>
	 * @param newName
	 * 		Nom de la personne instanci�e
	 * @param newSurname
	 * 		Pr�nom de la personne instanci�e
	 * @param newContact
	 * 		Contact de la personne instanci�e
	 */
	public Person(String newName, String newSurname, String newContact){
		sName = newName;
		sSurname = newSurname;
		sContact = newContact;
	}
	/**
	 * Change les informations li�es � la personne
	 * @param newName
	 * 		Nouveau nom de la personne
	 * @param newSurname
	 * 		Nouveau pr�nom de la personne
	 * @param newContact
	 * 		Nouveau Contact de la personne
	 */
	public void PERModifyPersonInfo(String newName, String newSurname, String newContact){
		sName = newName;
		sSurname = newSurname;
		sContact = newContact;
	}
	/**
	 * Change le nom et pr�nom de la personne
	 * @param newName
	 * 		Nouveau nom de la personne
	 * @param newSurname
	 * 		Nouveau pr�nom de la personne
	 */
	public void PERModifyPersonName(String newName, String newSurname){
		sName = newName;
		sSurname = newSurname;
	}
	/**
	 * Change le contact de la personne
	 * @param newContact
	 * 		Nouveau contact de la personne
	 */
	public void PERModifyPersonContact(String newContact){
		sContact = newContact;
	}
	/**
	 * 
	 * @return Nom de la personne
	 */
	public String PERGetPersonName(){
		return sName;
	}
	/**
	 * 
	 * @return Pr�nom de la personne
	 */
	public String PERGetPersonSurname(){
		return sSurname;
	}
	/**
	 * 
	 * @return Contact de la personne
	 */
	public String PERGetPersonContact(){
		return sContact;
	}
	/**
	 * Convertit en String l'entit� Person et ses attributs
	 */
	public String toString(){
		return sName+" "+sSurname;
	}
	/**
	 * Affiche une personne et ses attributs dans la console
	 */
	public void printPers()
	{
		System.out.println("sName : " + sName);
		System.out.println("sSurname : " + sSurname);
		System.out.println("sContact : " + sContact);
	}
}
