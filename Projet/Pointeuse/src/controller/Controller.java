package controller;


import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import model.*;
import view.*;

/**
 * La classe Controller fait la liaison entre le modèle et la vue. 
 * Elle contient les actions déclenchées par les input de l'utilisateur.
 * Ses attributs sont : 
 * <ul>
 * <li>Une référence sur la compagnie
 * <li>Une view
 * </ul>
 */
public class Controller {
	private Company company;
	private IHM view;

	/**
	 * Constructeur de confort
	 * <p>Met en place la compagnie, et instancie la vue. </p>
	 * @param Test
	 * 		Compagnie
	 */
	public Controller(Company Test)
	{
		setCompany(Test);
		setView( new IHM(this) );	
	}
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public IHM getView() {
		return view;
	}
	public void setView(IHM view) {
		this.view = view;
	}

	public void controllerStart()
	{	        
	    view.afficher();
	}
	
	public void addRowEmp()
	{
		try 
		{
			PopupAddEmp add = new PopupAddEmp(getCompany().getDptList());
			
			long newId = company.uniqueID();
			
			Department dpt = (Department) add.getBoxDpt().getSelectedItem();
			HourMod StdAT = new HourMod((String)add.getBoxStdATHour().getSelectedItem(),(String)add.getBoxStdATMin().getSelectedItem());
			HourMod StdDT = new HourMod((String)add.getBoxStdDTHour().getSelectedItem(),(String)add.getBoxStdDTMin().getSelectedItem());
			
			getView().getOngletEmp().getModel().addRow(new Object[]{
					newId,
					add.getFieldNom().getText(),
					add.getFieldPrenom().getText(),
					add.getFieldContact().getText(),
					dpt,
					StdAT,
					StdDT});

			getCompany().hireEmployee(new Employee(add.getFieldNom().getText(),
													add.getFieldPrenom().getText(),
													newId,
													add.getFieldContact().getText(),
													StdAT,
													StdDT),
													dpt);
			
			getView().getOngletDpt().getModel().fireTableDataChanged();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
	
	public void removeRowEmp()
	{
		try 
		{
			int selectedRow = getView().
								getOngletEmp().
								getTableauEmp().
								getSelectedRow();
			if(selectedRow != -1)
			{
				//Fire employee
				getCompany().	
				fireEmployee( getCompany().
							getEmployeeByID( (long)getView().
											getOngletEmp().
											getTableauEmp().
											getValueAt(selectedRow, 0) ));
				
				getView().
				getOngletEmp().
				getModel().
				removeRow( selectedRow );
				
				getView().getOngletDpt().getModel().fireTableDataChanged();

			}
		}

		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
	
	public void addRowDpt()
	{
		try
		{
			PopupAddDpt add = new PopupAddDpt(getCompany().getManagerList());
			
			getView().getOngletDpt().getModel().addRow(new Object[]{
					add.getFieldNom().getText(),
					add.getManagerBox().getSelectedItem(),
					0,
					0
			});
			
			getCompany().createDepartment(add.getFieldNom().getText(), (Manager)add.getManagerBox().getSelectedItem());
			
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void removeRowDpt()
	{
		try
		{
			int selectedRow = getView().
					getOngletDpt().
					getTableauEmp().
					getSelectedRow();
			
			if(selectedRow != -1)
			{		
				getCompany().
				removeDepartment( getCompany().
								  getDepartment( (String) getView().
														  getOngletDpt().
														  getTableauEmp().
														  getValueAt(selectedRow, 0)));
				getView().
				getOngletDpt().
				getModel().
				removeRow( selectedRow );
				
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void addRowMan()
	{
		try 
		{
			PopupAddEmp add = new PopupAddEmp(getCompany().getDptList());
			
			long newId = company.uniqueID();
			
			Department dpt = (Department) add.getBoxDpt().getSelectedItem();
			HourMod StdAT = new HourMod((String)add.getBoxStdATHour().getSelectedItem(),(String)add.getBoxStdATMin().getSelectedItem());
			HourMod StdDT = new HourMod((String)add.getBoxStdDTHour().getSelectedItem(),(String)add.getBoxStdDTMin().getSelectedItem());
			
			getView().getOngletMan().getModel().addRow(new Object[]{
					newId,
					add.getFieldNom().getText(),
					add.getFieldPrenom().getText(),
					add.getFieldContact().getText(),
					dpt,
					StdAT,
					StdDT});

			getCompany().hireManager(new Manager(add.getFieldNom().getText(),
													add.getFieldPrenom().getText(),
													add.getFieldContact().getText(),
													newId,
													StdAT,
													StdDT),
													dpt);

			getView().
			getOngletDpt().
			getModel().
			fireTableDataChanged();

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

	public void removeRowMan()
	{
		try 
		{
			int selectedRow = getView().
								getOngletMan().
								getTableauEmp().
								getSelectedRow();
			if(selectedRow != -1)
			{
				//Fire manager
				getCompany().	
				fireManager( getCompany().
							getManagerByID( (long)getView().
											getOngletMan().
											getTableauEmp().
											getValueAt(selectedRow, 0) ));
				
				//Update model Employees
				getView().
				getOngletMan().
				getModel().
				removeRow( selectedRow );
				
				getView().
				getOngletDpt().
				getModel().
				fireTableDataChanged();
				
			}
		}

		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
	
	public void changeDepartmentEmp()
	{
		try 
		{
			int selectedRow = getView().
								getOngletEmp().
								getTableauEmp().
								getSelectedRow();
			if(selectedRow != -1)
			{
				PopupChangeDpt add = new PopupChangeDpt(getCompany().getDptList());
				
				//Get employee
				Employee empTemp = getCompany().
								   getEmployeeByID( (long)getView().
													getOngletEmp().
													getTableauEmp().
													getValueAt(selectedRow, 0) );
				//Fire employee
				getCompany().	
				fireEmployee( empTemp );
				
				//Hire employee
				getCompany().hireEmployee(empTemp, (Department)add.getDepartmentBox().getSelectedItem());
				
				//Update
				getView().
				getOngletEmp().
				getModel().
				removeRow( selectedRow );
				
				getView().
				getOngletEmp().
				getModel().
				addRow(new Object[]{
						empTemp.EMPGetEmpID(),
						empTemp.PERGetPersonName(),
						empTemp.PERGetPersonSurname(),
						empTemp.PERGetPersonContact(),
						empTemp.EMPGetDepartment(),
						empTemp.EMPGetStdAT(),
						empTemp.EMPGetStdDT()});
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void changeDepartmentMan()
	{
		try 
		{
			int selectedRow = getView().
								getOngletMan().
								getTableauEmp().
								getSelectedRow();
			if(selectedRow != -1)
			{
				PopupChangeDpt add = new PopupChangeDpt(getCompany().getDptList());
				
				//Get employee
				Manager manTemp = getCompany().
								   getManagerByID( (long)getView().
													getOngletMan().
													getTableauEmp().
													getValueAt(selectedRow, 0) );
				//Fire employee
				getCompany().	
				fireManager( manTemp );
				
				//Hire employee
				getCompany().hireManager(manTemp, (Department)add.getDepartmentBox().getSelectedItem());
				
				//Update
				getView().
				getOngletMan().
				getModel().
				removeRow( selectedRow );
				
				getView().
				getOngletMan().
				getModel().
				addRow(new Object[]{
						manTemp.EMPGetEmpID(),
						manTemp.PERGetPersonName(),
						manTemp.PERGetPersonSurname(),
						manTemp.PERGetPersonContact(),
						manTemp.EMPGetDepartment(),
						manTemp.EMPGetStdAT(),
						manTemp.EMPGetStdDT()});
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void changeManagerDpt()
	{
		try 
		{
			int selectedRow = getView().
								getOngletDpt().
								getTableauEmp().
								getSelectedRow();
			
			
			if(selectedRow != -1)
			{
				PopupChangeMan add = new PopupChangeMan(getCompany().getManagerList());
				
				Department dptTemp = getCompany().
									 getDepartment( (String)getView().
											 		getOngletDpt().
											 		getTableauEmp().
											 		getValueAt(selectedRow, 0) );
				
				//Get employee
				dptTemp.
			    setManager( (Manager)add.getManagerBox().getSelectedItem() );


				//Update
				getView().
				getOngletDpt().
				getModel().
				removeRow( selectedRow );
				
				getView().
				getOngletDpt().
				getModel().
				addRow(new Object[]{
						dptTemp.getSDepName(),
						dptTemp.getManager(),
						dptTemp.getEmployeeList().size(),
						dptTemp.getManagerList().size()});
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void addPunching(Employee emp, PunchingIO punch) throws Exception
	{
		if(emp.EMPGetWorkindDayList().size() != 0)
		{
			if( emp.EMPGetWorkindDayList().get( emp.EMPGetWorkindDayList().size()-1 ).getPunchOut() == null)
			{
				punch.setbIn(false);
				getCompany().getEmployeeByID(emp.EMPGetEmpID()).EMPGetWorkindDayList().get( emp.EMPGetWorkindDayList().size()-1 ).setPunchOut(punch);		
			}
			else 
			{
				getCompany().getEmployeeByID(emp.EMPGetEmpID()).EMPAddWorkingDay( new WorkingDay(emp,punch,null) );
			}
		}
		else 
		{
			getCompany().getEmployeeByID(emp.EMPGetEmpID()).EMPAddWorkingDay( new WorkingDay(emp,punch,null) );
		}
		
		String boolStr;
		if(punch.isbIn())
		{
			boolStr = "Entrée";
		}
		else
		{
			boolStr = "Sortie";
		}
		getView().getOngletPoint().getModel().addRow(new Object[]{
				punch.getPunchDate(),
				punch.getPunchHour(),
				punch.getPunchingEmp(),
				boolStr});
	}
	
	public void switchAll()
	{
		view.
		getOngletPoint().
		setModel( new DefaultTableModel( getCompany().getAllPointages(),
										 getView().getOngletPoint().getNomColonnes()));
		view.
		getOngletPoint().
		getTableauPoint().
		setModel( view.
				getOngletPoint().
				getModel());
	}
	
	public void switchEmp()
	{
		PopupSwitchEmp change = new PopupSwitchEmp(getCompany().getEmpList());
		
		view.
		getOngletPoint().
		setModel( new DefaultTableModel( getCompany().getAllPointagesByEmployee( (Employee)change.getEmpBox().getSelectedItem() ),
										 getView().getOngletPoint().getNomColonnes()));
		view.
		getOngletPoint().
		getTableauPoint().
		setModel( view.
				getOngletPoint().
				getModel());
	}
	
	public void switchDate()
	{
		PopupChangeDate change = new PopupChangeDate();
		
		LocalDate dateTemp = LocalDate.parse((String)change.getYear().getSelectedItem()
											 +"-"
											 +(String)change.getMonth().getSelectedItem()
											 +"-"
											 +(String)change.getDay().getSelectedItem());
		
		view.
		getOngletPoint().
		setModel( new DefaultTableModel( getCompany().getAllPointagesByDate( dateTemp ),
										 getView().getOngletPoint().getNomColonnes()));
		view.
		getOngletPoint().
		getTableauPoint().
		setModel( view.
				getOngletPoint().
				getModel());
	}
	
	public void switchDepartment()
	{
		PopupSwitchDpt change = new PopupSwitchDpt(getCompany().getDptList());
		
		view.
		getOngletPoint().
		setModel( new DefaultTableModel( getCompany().getAllPointagesByDepartment( (Department)change.getDepartmentBox().getSelectedItem()),
				  getView().getOngletPoint().getNomColonnes()) );
		view.
		getOngletPoint().
		getTableauPoint().
		setModel( view.
				getOngletPoint().
				getModel());
		
	}

	@SuppressWarnings("unchecked")
	public void importCSV()
	{
		PopupImport imp = new PopupImport();
		
		ArrayList<Object> backup = Backup.importEmployeeCSV( imp.getFieldNom().getText() );
		getCompany().setEmpList((ArrayList<Employee>)backup.get(0));
		assignDepartmentsToEmployees((ArrayList<Employee>)backup.get(0), (ArrayList<String>)backup.get(1));
		
	}
	
	public void exportCSV()
	{
		PopupExport exp = new PopupExport();
		Backup.exportEmployeeCSV(getCompany().getEmpList(), exp.getFieldNom().getText());
	}
	
	/**
     * Associe une liste d'employées à une liste de Départements existants, ou les crée si besoin.
     * Les deux listes doivent avoir un nombre egal de valeurs.
     * @param listEmployee
     *         Liste d'employés
     * @param listeDptName
     *         Listes de nom de départments
     * @throws Exception 
     */
    public void assignDepartmentsToEmployees(ArrayList<Employee> listEmployee,ArrayList<String> listeDptName) 
    {
        int counter=0;
        for(Employee currentEmployee : listEmployee)
        {
        	try 
        	{
				currentEmployee.EMPSetDepartment( getCompany().getDepartment( listeDptName.get(counter)) );
			} 
        	catch (Exception e) 
        	{
				getCompany().createDepartment(listeDptName.get(counter), null);
			}
        	counter++;  
        }
                      
        
    }

}
