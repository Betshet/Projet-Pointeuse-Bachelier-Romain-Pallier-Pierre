package model;
import java.util.ArrayList;

public class Department implements java.io.Serializable {

	private static final long serialVersionUID = 8428352569692187727L;
	private String DepName;
	private Manager EMPManager;
	private ArrayList<Employee> EmployeeList;
	private ArrayList<Manager> ManagerList;
	
	//Constructeurs
	public Department()
	{
		DepName=null;
		EMPManager = new Manager();
		EmployeeList = new ArrayList<Employee>();
		ManagerList = new ArrayList<Manager>();
	}	
	
	public Department(String newDepName, Manager newManager)
	{
		DepName=newDepName;

		EMPManager = newManager;

		EmployeeList=new ArrayList<Employee>();
		ManagerList = new ArrayList<Manager>();
		
	}
	
	//Getters
	public String getSDepName() 
	{
		return DepName;
	}
	
	public Manager getManager() 
	{
		return EMPManager;
	}
		
	public ArrayList<Employee> getEmployeeList() 
	{
		return EmployeeList;
	}
	
	//Setters
	public void setDepName(String sDepName) 
	{
		DepName = sDepName;
	}
	
	public void setManager(Manager eMPManager) 
	{
		EMPManager = eMPManager;
	}
	
	public void setEmployeeList(ArrayList<Employee> newlEmployeeList) 
	{
		EmployeeList = newlEmployeeList;
	}
	
	public ArrayList<Manager> getManagerList() {
		return ManagerList;
	}

	public void setManagerList(ArrayList<Manager> managerList) {
		ManagerList = managerList;
	}

	public void hireEmployee(Employee newEmployee)
	{
		EmployeeList.add(newEmployee);	
	}
	
	public void fireEmployee(Employee newEmployee)
	{
		EmployeeList.remove(newEmployee);
	}
	
	public void hireManager(Manager newManager)
	{
		ManagerList.add(newManager);	
	}
	
	public void fireManager(Manager manager)
	{
		ManagerList.remove(manager);
	}
	
	public void printDept()
	{
		System.out.println("SDepName : "+DepName+"\n");
		System.out.println("Dep Manager info under : \n");
		EMPManager.printPers();
		for(int iIter=0;iIter<EmployeeList.size();iIter++)
		{
			System.out.println("Employee number : "+iIter+"\n");
			EmployeeList.get(iIter).printEmp();
			System.out.println("\n");
		}
	}
	
	@Override
	public String toString()
	{
		return getSDepName();
	}

}
