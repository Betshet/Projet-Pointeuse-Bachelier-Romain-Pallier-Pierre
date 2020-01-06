package model;
import java.util.ArrayList;


public class Company implements java.io.Serializable{


	private static final long serialVersionUID = 734751888988596959L;
	private String sCompanyName;
	private ArrayList<Department> DptList; 
	private Person PERBoss;
	private static long uniqueIDcount = 0;
	private ArrayList<Employee> EmpList;
	private ArrayList<Manager> ManagerList;

	
	public Company()
	{
		sCompanyName=null;
		DptList=new ArrayList<Department>();
		PERBoss=null;
		EmpList = new ArrayList<Employee>();
		ManagerList = new ArrayList<Manager>();
	}
	public Company(String sCompName, Person Boss)
	{
		sCompanyName=sCompName;
		DptList=new ArrayList<Department>();
		PERBoss=Boss;
		EmpList = new ArrayList<Employee>();
		ManagerList = new ArrayList<Manager>();
	}
	
	public String getCompanyName()
	{
		return sCompanyName;
	}
	
	public  ArrayList<Department> getDptList()
	{
		return DptList;
	}
	
	public Person getBoss()
	{
		return PERBoss;
	}

	public long getUniqueIDcount() {
		return uniqueIDcount;
	}

	public void setUniqueIDcount(long uniqueIDcount) {
		Company.uniqueIDcount = uniqueIDcount;
	}
	
	public long uniqueID()
	{
		setUniqueIDcount(uniqueIDcount++);
		return getUniqueIDcount();
	}

	public ArrayList<Employee> getEmpList() {
		return EmpList;
	}

	public void setEmpList(ArrayList<Employee> empList) {
		EmpList = empList;
	}

	public ArrayList<Manager> getManagerList() {
		return ManagerList;
	}
	public void setManagerList(ArrayList<Manager> managerList) {
		ManagerList = managerList;
	}
	public void setCompanyName(String sCompName)
	{
		sCompanyName=sCompName;		
	}
	
	public void hireManager(Manager newManager, Department dpt)
	{
		getManagerList().add(newManager);
		dpt.hireManager(newManager);
		newManager.EMPSetDepartment(dpt);
	}
	
	public void fireManager(Manager man)
	{
		getManagerList().remove(man);
		man.EMPGetDepartment().fireManager(man);
	}
	
	public void addDepartment(Department newDepartment)
	{
		DptList.add(newDepartment);
	}
	
	public void removeDepartment(Department oldDepartment)
	{
		DptList.remove(oldDepartment); 
	}
	
	public void createDepartment(String nomDpt, Manager manager)
	{
		addDepartment(new Department(nomDpt,manager));
	}
	
	public void setBoss(Person newBoss)
	{
		PERBoss=newBoss;		
	}
	
	private void addEmployee(Employee emp)
	{
		getEmpList().add(emp);
	}
	
	private void removeEmployee(Employee emp)
	{
		getEmpList().remove(emp);
	}

	public void hireEmployee(Employee emp, Department dpt)
	{
		addEmployee(emp);
		dpt.hireEmployee(emp);
		emp.EMPSetDepartment(dpt);
	}
	
	public void fireEmployee(Employee emp)
	{
		removeEmployee(emp);
		emp.EMPGetDepartment().fireEmployee(emp);
	}
	
	public Employee getEmployeeByID(long ID) throws Exception
	{
		for(Employee emp: getEmpList())
		{
			if(emp.EMPGetEmpID() == ID)
				return emp;
		}
		throw new Exception("Invalid Index");
	}
	
	public Manager getManagerByID(long ID) throws Exception
	{
		for(Manager man: getManagerList())
		{
			if(man.EMPGetEmpID() == ID)
				return man;
		}
		throw new Exception("Invalid Index");
	}
	
	public ArrayList<Employee> getEmployeeByName(String name) 
	{
		ArrayList<Employee> retour = new ArrayList<Employee>();
		for(Employee emp: getEmpList())
		{
			if(emp.PERGetPersonName().equals(name))
				retour.add(emp);
		}
		return retour;

	}
	
	public ArrayList<Employee> getEmployeeBySurname(String name) 
	{
		ArrayList<Employee> retour = new ArrayList<Employee>();
		for(Employee emp: getEmpList())
		{
			if(emp.PERGetPersonName().equals(name))
				retour.add(emp);
		}
		return retour;
	}
	
	public ArrayList<Employee> getEmployeeByDepartment(Department dpt) throws Exception
	{
		for(Employee emp: getEmpList())
		{
			if(emp.EMPGetDepartment().getSDepName().equals(dpt.getSDepName()))
				return emp.EMPGetDepartment().getEmployeeList();
		}
		return null;
	}
	
	public ArrayList<Employee> getEmployeeByStdAT(HourMod stdat)
	{
		ArrayList<Employee> retour = new ArrayList<Employee>();
		for(Employee emp: getEmpList())
		{
			if(emp.EMPGetStdAT().equals(stdat))
				retour.add(emp);
		}
		return retour;
	}
	
	public ArrayList<Employee> getEmployeeByStdDT(HourMod stdat)
	{
		ArrayList<Employee> retour = new ArrayList<Employee>();
		for(Employee emp: getEmpList())
		{
			if(emp.EMPGetStdDT().equals(stdat))
				retour.add(emp);
		}
		return retour;
	}
	
	

	public Department getDepartment(String name) throws Exception
	{
		for(Department iter: getDptList())
		{
			if(iter.getSDepName().equals(name))
				return iter;
		}
		throw new Exception("No department found");
	}
	
	public void printComp()
	{
		System.out.println("sCompanyName : "+sCompanyName+"\n");
		System.out.println("Boss info under : ");
		PERBoss.printPers();
		for(int iIter=0;iIter<DptList.size();iIter++)
		{
			System.out.println("Dpt number : "+iIter+"\n");
			DptList.get(iIter).printDept();
			System.out.println("\n");
		}
		
	}
	
	public Object[][] getAllEmployeesString()
	{

		Object[][] returnList = new Object[getEmpList().size()][7];
		int compteur = 0;
		for(Employee currentEmp : getEmpList())
		{
				returnList[compteur][0]=currentEmp.EMPGetEmpID();
				returnList[compteur][1]=currentEmp.PERGetPersonName();
				returnList[compteur][2]=currentEmp.PERGetPersonSurname();
				returnList[compteur][3]=currentEmp.PERGetPersonContact();
				returnList[compteur][4]=currentEmp.EMPGetDepartment().getSDepName();
				returnList[compteur][5]=currentEmp.EMPGetStdAT().toString();
				returnList[compteur][6]=currentEmp.EMPGetStdDT().toString();
				compteur++;
		}
		
		return returnList;
	}
	
	public Object[][] getAllPointages()
	{
		Object[][] returnList = new Object[getEmpList().size()][6];
		int compteur = 0;
		for(Employee currentEmp : getEmpList())
		{
				returnList[compteur][0]=currentEmp.EMPGetEmpID();
				returnList[compteur][1]=currentEmp.PERGetPersonName();
				returnList[compteur][2]=currentEmp.PERGetPersonSurname();
				returnList[compteur][3]=currentEmp.PERGetPersonContact();
				returnList[compteur][4]=currentEmp.EMPGetDepartment().getSDepName();
				returnList[compteur][5]=currentEmp.EMPGetStdAT().toString();
				returnList[compteur][6]=currentEmp.EMPGetStdDT().toString();
				compteur++;
		}
		
		return returnList;
	}
	
	public Object[][] getAllDepartments()
	{
		Object[][] returnList = new Object[getDptList().size()][4];
		int compteur = 0;
		for(Department currentDpt : getDptList())
		{
				returnList[compteur][0]=currentDpt.getSDepName();
				returnList[compteur][1]=currentDpt.getManager().PERGetPersonSurname() +" "+ currentDpt.getManager().PERGetPersonName();
				returnList[compteur][2]=currentDpt.getEmployeeList().size();
				returnList[compteur][3]=currentDpt.getManagerList().size();
				compteur++;
		}
		
		return returnList;
	}
	
	public Object[][] getAllManager()
	{
		
		Object[][] returnList = new Object[getManagerList().size()][7];
		int compteur = 0;
		for(Manager currentMan : getManagerList())
		{
				returnList[compteur][0]=currentMan.EMPGetEmpID();
				returnList[compteur][1]=currentMan.PERGetPersonName();
				returnList[compteur][2]=currentMan.PERGetPersonSurname();
				returnList[compteur][3]=currentMan.PERGetPersonContact();
				returnList[compteur][4]=currentMan.EMPGetDepartment().getSDepName();
				returnList[compteur][5]=currentMan.EMPGetStdAT().toString();
				returnList[compteur][6]=currentMan.EMPGetStdDT().toString();
				compteur++;
		}
		
		return returnList;
	}
	
	
}
