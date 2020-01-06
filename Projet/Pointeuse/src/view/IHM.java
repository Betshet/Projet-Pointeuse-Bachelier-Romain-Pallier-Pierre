package view;


import java.awt.*;
import java.util.*;

import javax.swing.*;

import controller.*;
import model.Backup;

/**
 * La classe IHM met en place une interface graphique.. 
 * Elle contient la fenêtre principale de la centrale, ainsi que les différents onglets.
 */
public class IHM {
	private JFrame frame;
	private ArrayList<JPanel> ListeTabs;
	private String[] nomTabs;
	private JTabbedPane tabbedPane;
	private Controller control;
	private OngletEmployees ongletEmp;
	private OngletManagers ongletMan;
	private OngletPointage ongletPoint;
	private OngletDepartment ongletDpt;
	private OngletParam ongletParam;
	
	public IHM(Controller controller)
	{
		setControl(controller);
		
		setFrame( new JFrame("Centrale") );
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().setSize(1200,1000);
		
		Runtime.getRuntime().addShutdownHook(new Thread() 
	    { 
	      public void run() 
	      { 
	        Backup.makeBackup(getControl().getCompany(), "CompanySave.xml");
	      } 
	    }); 

	    
		
		setNomTabs( new String[] {"Employés","Managers","Department","Pointages","Paramètres"} );
		setTabbedPane( new JTabbedPane() );
		setOngletEmp(new OngletEmployees(control));
		setOngletMan(new OngletManagers(control));
		setOngletPoint(new OngletPointage(control));
		setOngletDpt(new OngletDepartment(control));
		setOngletParam(new OngletParam(control));
	
		getTabbedPane().addTab(getNomTabs()[0],getOngletEmp());
		getTabbedPane().addTab(getNomTabs()[1],getOngletMan());
		getTabbedPane().addTab(getNomTabs()[2],getOngletDpt());
		getTabbedPane().addTab(getNomTabs()[3],getOngletPoint());
		getTabbedPane().addTab(getNomTabs()[4],getOngletParam());
		
		
        //addButton.addActionListener(new Actions());
        
        getFrame().add(tabbedPane, BorderLayout.CENTER);;
	}

	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public ArrayList<JPanel> getListeTabs() {
		return ListeTabs;
	}
	public void setListeTabs(ArrayList<JPanel> listeTabs) {
		ListeTabs = listeTabs;
	}
	public String[] getNomTabs() {
		return nomTabs;
	}
	public void setNomTabs(String[] nomTabs) {
		this.nomTabs = nomTabs;
	}
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}
	public Controller getControl() {
		return control;
	}
	public void setControl(Controller control) {
		this.control = control;
	}

	public OngletEmployees getOngletEmp() {
		return ongletEmp;
	}

	public void setOngletEmp(OngletEmployees ongletEmp) {
		this.ongletEmp = ongletEmp;
	}

	public OngletManagers getOngletMan() {
		return ongletMan;
	}

	public void setOngletMan(OngletManagers ongletMan) {
		this.ongletMan = ongletMan;
	}

	public OngletPointage getOngletPoint() {
		return ongletPoint;
	}

	public void setOngletPoint(OngletPointage ongletPoint) {
		this.ongletPoint = ongletPoint;
	}

	public OngletDepartment getOngletDpt() {
		return ongletDpt;
	}

	public void setOngletDpt(OngletDepartment ongletDpt) {
		this.ongletDpt = ongletDpt;
	}

	public OngletParam getOngletParam() {
		return ongletParam;
	}

	public void setOngletParam(OngletParam ongletParam) {
		this.ongletParam = ongletParam;
	}

	public void afficher()
	{
		getFrame().setVisible(true);
	}
	

}
