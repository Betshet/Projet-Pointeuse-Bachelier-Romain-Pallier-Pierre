package controller;


import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import controller.TCP.TCPController;
import model.*;

public class mainClass {

	public static void main(String[] args) 
	{
		Controller control = new Controller();
		control.controllerStart();
		
		//SERVER CODE
		ArrayList<Employee> test = new ArrayList<Employee>();
		while(true)
		{
			try
			{
				test=TCPController.waitForData();
				System.out.println("The Emu server keeps running");
				control.getView().sync(test);
			} 
			catch (InterruptedException | ExecutionException e)
			{
				e.printStackTrace();
			}
		}
		

		
	}


}
