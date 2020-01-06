 package model;
import java.util.ArrayList;
import java.time.*;


public class Employee extends Person implements java.io.Serializable{
	

	private static final long serialVersionUID = -488295036120737115L;
	private long iIDEmp;
	private Department DEPDpt;
	private HourMod HMODStdAT; 
	private HourMod HMODStdDT;
	private ArrayList<WorkingDay> lWORDaysList;
	
	public Employee(){
		super();
		iIDEmp = -1;
		DEPDpt = null;
		HMODStdAT = null; //standard arrival time
		HMODStdAT = null; // standard departure time
		lWORDaysList = null;
	}
	
	public Employee(String EmpName, String EmpSurname, long ID, String EmpContact, HourMod hourMod, HourMod hourMod2){
		super(EmpName,EmpSurname,EmpContact);
		iIDEmp = ID;
		DEPDpt = null;
		HMODStdAT = hourMod;
		HMODStdDT = hourMod2;
		lWORDaysList = new ArrayList<WorkingDay>();
	}
	

	
	public void EMPSetEmpID(int newID){
		iIDEmp = newID;
	}
	
	public long EMPGetEmpID(){
		return(iIDEmp);
	}
	
	public void EMPSetDepartment(Department newDpt){
		DEPDpt = newDpt;
	}
	
	public Department EMPGetDepartment(){
		return(DEPDpt);
	}
	
	public void EMPSetStdAT(HourMod newStdAT){
		HMODStdAT = newStdAT;
	}
	
	public HourMod EMPGetStdAT(){ //attention difference entre dt et at !
		return(HMODStdAT);
	}
	
	public void EMPSetStdDT(HourMod newStdDT){
		HMODStdDT = newStdDT;
	}
	
	public HourMod EMPGetStdDT(){
		return(HMODStdDT);
	}
	
	public void EMPAddWorkingDay(WorkingDay newWorkingDay){
		lWORDaysList.add(newWorkingDay);
	}
	
	public void EMPRemoveWorkingDay(LocalDate RMDate,LocalTime RMTime)
    {
        //à gerer : absence du workingday
        for(int iter = 0; iter < lWORDaysList.size(); iter++)
        {
            if(lWORDaysList.get(iter).getPunchIn().getPunchDate()== RMDate 
                    && lWORDaysList.get(iter).getPunchIn().getPunchHour().getHour()==RMTime )
                lWORDaysList.remove(lWORDaysList.get(iter));
        }
    }
	
	public WorkingDay EMPGetWorkingDay(LocalDate GetDate,LocalTime GetTime)
    {
        //à gerer : absence du workingday
        for(WorkingDay iter : lWORDaysList)
        {
            if(iter.getPunchIn().getPunchDate()== GetDate 
                    && iter.getPunchIn().getPunchHour().getHour()==GetTime )
                return iter;
        }
        return null; // ?
    }
	
	
	
	public String toString(){
		return Integer.toString((int) iIDEmp)+" "+super.toString();
	}
	
	public void printEmp()
	{
		System.out.println("Employee info under : ");
		this.printPers();
		System.out.println("iIDEmp : "+iIDEmp);
		System.out.println("Standard arrival");
		HMODStdAT.printHourMod();
		System.out.println("Standard departure");
		HMODStdDT.printHourMod();
		//print HMod1
		//print HMod2
		//print WorkingDaylist
	}
	
	
}
