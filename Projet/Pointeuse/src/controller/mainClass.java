package controller;

import java.util.concurrent.ExecutionException;

import controller.TCP.TCPController;
import model.*;


public class mainClass {

	public static void main(String[] args) 
	{
		try
		{
			Company comp = (Company)Backup.readBackup("CompanySave.xml");
			
			Controller control = new Controller(comp);
			control.controllerStart();

			//SERVER CODE
			PunchingIO test = new PunchingIO();
			while(true)
			{
				try
				{
					test=TCPController.waitForData();
					System.out.println("The Centrale server keeps running");
					if(test.getPunchDate() == null && 
					   test.getPunchHour()==null && 
					   test.getPunchingEmp() == null)
					{ }
					else
					{
						control.addPunching(test.getPunchingEmp(),test);
					}
					TCPData dataToSend= new TCPData(comp.getEmpList());
					TCPController.sendData(dataToSend);
				} 
				catch (InterruptedException | ExecutionException e)
				{
					e.printStackTrace();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
