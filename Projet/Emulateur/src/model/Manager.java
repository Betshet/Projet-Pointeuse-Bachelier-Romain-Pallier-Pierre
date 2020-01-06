package model;
public class Manager extends Employee implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean Active;
	
	public Manager(){
		super();
	}
	
	public Manager(String ManName, String ManSurname, String ManContact, long ManID, HourMod ManSdtAT, HourMod ManStdDT){
		super(ManName,ManSurname,ManID,ManContact,ManSdtAT,ManStdDT);
		Active = false;
	}


	public boolean MANisActive() {
		return Active;
	}


	public void MANsetActive(boolean active) {
		Active = active;
	}
	
	
}
