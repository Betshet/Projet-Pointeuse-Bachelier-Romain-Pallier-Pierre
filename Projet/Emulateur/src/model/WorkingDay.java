package model;
import java.io.Serializable;
//import java.io.Serializable;
import java.time.*;

public class WorkingDay implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1864525357380450638L;
	private Employee WorkingEmployee;
	private PunchingIO PunchIn;
	private PunchingIO PunchOut;
	//si on sort en journee on cree un nouveau workingday
	public WorkingDay()
	{
		setWorkingEmployee(new Employee());
		setPunchIn(null);
		setPunchOut(null);
	}
	
	public WorkingDay(Employee WorkingEmp ,PunchingIO PUNPunchIn ,PunchingIO PUNPunchOut )
	{
		setWorkingEmployee(WorkingEmp);
		setPunchIn(PUNPunchIn);
		setPunchOut(PUNPunchOut);
	}
	
	public void WORgetIn(LocalDate LDTPunchDate,LocalTime LDTPunchHour)
    {
        setPunchIn(new PunchingIO(LDTPunchDate,LDTPunchHour, true, WorkingEmployee));
    }

    public void WORgetOut(LocalDate LDTPunchDate,LocalTime LDTPunchHour)
    {
        setPunchOut(new PunchingIO(LDTPunchDate,LDTPunchHour, false, WorkingEmployee));
    }

	public Employee getWorkingEmployee() {
		return WorkingEmployee;
	}

	public void setWorkingEmployee(Employee workingEmployee) {
		WorkingEmployee = workingEmployee;
	}

	public PunchingIO getPunchIn() {
		return PunchIn;
	}

	public void setPunchIn(PunchingIO punchIn) {
		PunchIn = punchIn;
	}

	public PunchingIO getPunchOut() {
		return PunchOut;
	}

	public void setPunchOut(PunchingIO punchOut) {
		PunchOut = punchOut;
	}

	public void printWDay()
	{
		/*System.out.println("Working employee info under : \n");
		WorkingEmployee.printEmp();*/
		System.out.println("Punch in under : \n");
		PunchIn.printPunching();
		System.out.println("Punch out under : \n");
		PunchOut.printPunching();
	}
	
	public String toStringPunchIn()
	{
		return getPunchIn().toString();
	}
	
	public String toStringPunchOut()
	{
		return getPunchOut().toString();
	}
	
}
