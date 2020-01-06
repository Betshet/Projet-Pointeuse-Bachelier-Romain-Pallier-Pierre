package model;


/**
 * La classe Person permet de créer des personnes, les entités composant l'entreprise,
 * et leurs attributs qui sont :
 * <ul>
 * <li>Un nom
 * <li>Un prénom
 * <li>Un contact (mail généralement)
 * </ul>
 */
public class Person implements java.io.Serializable {
	
	private static final long serialVersionUID = 8022310804395722104L;
	/**
	 * Nom de la personne
	 */
	private String sName;
	/**
	 * Prénom de la personne
	 */
	private String sSurname;
	/**
	 * Contact de la personne
	 */
	private String sContact;
	/**
	 * Constructeur par défaut
	 */
	public Person(){
		sName = null;
		sSurname = null;
		sContact = null;
	}
	/**
	 * Constructeur de confort
	 * <p>Crée une personne</p>
	 * @param newName
	 * 		Nom de la personne instanciée
	 * @param newSurname
	 * 		Prénom de la personne instanciée
	 * @param newContact
	 * 		Contact de la personne instanciée
	 */
	public Person(String newName, String newSurname, String newContact){
		sName = newName;
		sSurname = newSurname;
		sContact = newContact;
	}
	/**
	 * Change les informations liées à la personne
	 * @param newName
	 * 		Nouveau nom de la personne
	 * @param newSurname
	 * 		Nouveau prénom de la personne
	 * @param newContact
	 * 		Nouveau Contact de la personne
	 */
	public void PERModifyPersonInfo(String newName, String newSurname, String newContact){
		sName = newName;
		sSurname = newSurname;
		sContact = newContact;
	}
	/**
	 * Change le nom et prénom de la personne
	 * @param newName
	 * 		Nouveau nom de la personne
	 * @param newSurname
	 * 		Nouveau prénom de la personne
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
	 * @return Prénom de la personne
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
	 * Convertit en String l'entité Person et ses attributs
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
