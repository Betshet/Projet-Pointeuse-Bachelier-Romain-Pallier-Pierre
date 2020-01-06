package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import View.*;
import controller.TCP.TCPController;
import model.*;


public class Controller {
	private IHM view;
	
	public Controller()
	{
		ArrayList<Employee> EmpList = new ArrayList<Employee>();
	
		setView( new IHM(this,EmpList) );
	}
	
	public void controllerStart()
	{	        
	    view.afficher();
	}
	
	
	public IHM getView() {
		return view;
	}

	public void setView(IHM view) {
		this.view = view;
	}
	
	public void check()
	{
		PunchingIO newPunch = new PunchingIO(LocalDate.now(),
				 							 LocalTime.now(),
				 							 true,
				 							 (Employee) view.getEmployeeList().getSelectedItem());
		TCPData dataToSend= new TCPData(newPunch);
		TCPController.sendData(dataToSend);
	}
	
	public void sync()
	{
		PunchingIO newPunch = new PunchingIO();
		TCPData dataToSend= new TCPData(newPunch);
		TCPController.sendData(dataToSend);
	}
	
	public void reload()
	{
		 view.setVisible(false); 
		 view.setVisible(true);
	}
	
	
}
