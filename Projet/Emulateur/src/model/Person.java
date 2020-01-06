package model;
public class Person implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8022310804395722104L;
	private String sName;
	private String sSurname;
	private String sContact;
	
	public Person(){
		sName = null;
		sSurname = null;
		sContact = null;
	}
	
	public Person(String newName, String newSurname, String newContact){
		sName = newName;
		sSurname = newSurname;
		sContact = newContact;
	}
	
	public void PERModifyPersonInfo(String newName, String newSurname, String newContact){
		sName = newName;
		sSurname = newSurname;
		sContact = newContact;
	}
	
	public void PERModifyPersonName(String newName, String newSurname){
		sName = newName;
		sSurname = newSurname;
	}
	
	public void PERModifyPersonContact(String newContact){
		sContact = newContact;
	}
	
	public String PERGetPersonName(){
		return sName;
	}
	
	public String PERGetPersonSurname(){
		return sSurname;
	}
	
	public String PERGetPersonContact(){
		return sContact;
	}
	
	public String toString(){
		return sName+" "+sSurname;
	}
	
	public void printPers()
	{
		System.out.println("sName : " + sName);
		System.out.println("sSurname : " + sSurname);
		System.out.println("sContact : " + sContact);
	}
}
