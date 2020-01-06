package model;
import java.time.*;


public class PunchingIO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3116600432979746L;
	private LocalDate punchDate;
	private HourMod punchHour;
	private boolean bIn;
	private Employee punchingEmp;
	
	public PunchingIO()
	{
		setPunchDate(null);
		punchHour=null;
		bIn=false;
		setPunchingEmp(null);
	}
	
	public PunchingIO(LocalDate punchingDate, LocalTime punchingHour, boolean bIsIn, Employee punchEmp)
	{
		setPunchDate(punchingDate);
		punchHour=new HourMod(punchingHour);
		bIn=bIsIn;
		setPunchingEmp(punchEmp);
	}
	
	public LocalDate getPunchDate() {
		return punchDate;
	}

	public void setPunchDate(LocalDate punchDate) {
		this.punchDate = punchDate;
	}
		
	public HourMod getPunchHour() {
		return punchHour;
	}
	
	public void setPunchHour(LocalTime NewPunchDate) {
		punchHour.setHour(NewPunchDate);
	}
	
	public boolean isbIn() {
		return bIn;
	}
	
	public void setbIn(boolean bNewIn) {
		bIn = bNewIn;
	}
	
	public Employee getPunchingEmp() {
		return punchingEmp;
	}
	public void setPunchingEmp(Employee EMPNewPunchingEmp) {
		punchingEmp = EMPNewPunchingEmp;
	}
	
	public void printPunching()
	{
		System.out.println("Punch Hour under : \n");
		punchHour.printHourMod();
	}

	
}
