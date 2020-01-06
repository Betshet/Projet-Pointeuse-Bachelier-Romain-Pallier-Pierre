package view;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.Controller;

public class OngletPointage extends JPanel implements ActionListener 
{

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private JTable tableauPoint;
	private JScrollPane scroll;
	private JPanel boutons;
	private JButton changeBouton;
	private JComboBox<String> filterBox;
	private GroupLayout gl;
	private GroupLayout.ParallelGroup hGroup;
	private GroupLayout.SequentialGroup vGroup;
	private Controller control;
	private String[] nomColonnes = {"Date","Heure", "Employe", "Entree/Sortie"};
	private String[] nomFiltres = {"Tous","Employé","Departement","Date"};
	
	
	public OngletPointage(Controller controller)
	{
		setControl(controller);
		
		setModel( new DefaultTableModel(getControl().getCompany().getAllPointages(),nomColonnes) );
		
		setTableauPoint(new JTable(model));
		setScroll(new JScrollPane(getTableauPoint()));
		getTableauPoint().setAutoCreateRowSorter(true);
		
		setBoutons(new JPanel());
		setChangeButton(new JButton("Filtrer"));
		setFilterBox(new JComboBox<String>(nomFiltres));
		
		getBoutons().add(getFilterBox());
		getBoutons().add(getChangeButton());

		getChangeButton().addActionListener(this);
		
		setGl(new GroupLayout(this));
		getGl().setAutoCreateGaps(true);
		getGl().setAutoCreateContainerGaps(true);
		this.setLayout(getGl());
		
		sethGroup( getGl().createParallelGroup()
        	.addComponent(getScroll())
        	.addComponent(getBoutons()) );
		setvGroup( getGl().createSequentialGroup()
        	.addComponent(getScroll())
        	.addComponent(getBoutons()) );
		getGl().setHorizontalGroup(gethGroup());
		getGl().setVerticalGroup(getvGroup());
	}
	
	
	public DefaultTableModel getModel() {
		return model;
	}
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	public JTable getTableauPoint() {
		return tableauPoint;
	}
	public void setTableauPoint(JTable tableauPoint) {
		this.tableauPoint = tableauPoint;
	}
	public JScrollPane getScroll() {
		return scroll;
	}
	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
	public JPanel getBoutons() {
		return boutons;
	}
	public void setBoutons(JPanel boutons) {
		this.boutons = boutons;
	}
	public JButton getChangeButton() {
		return changeBouton;
	}
	public void setChangeButton(JButton addButton) {
		this.changeBouton = addButton;
	}
	public JComboBox<String> getFilterBox() {
		return filterBox;
	}


	public void setFilterBox(JComboBox<String> filterBox) {
		this.filterBox = filterBox;
	}


	public GroupLayout getGl() {
		return gl;
	}
	public void setGl(GroupLayout gl) {
		this.gl = gl;
	}
	public GroupLayout.ParallelGroup gethGroup() {
		return hGroup;
	}
	public void sethGroup(GroupLayout.ParallelGroup hGroup) {
		this.hGroup = hGroup;
	}
	public GroupLayout.SequentialGroup getvGroup() {
		return vGroup;
	}
	public void setvGroup(GroupLayout.SequentialGroup vGroup) {
		this.vGroup = vGroup;
	}
	public Controller getControl() {
		return control;
	}
	public void setControl(Controller control) {
		this.control = control;
	}
	
	public String[] getNomColonnes() {
		return nomColonnes;
	}


	public String[] getNomFiltres() {
		return nomFiltres;
	}


	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(getFilterBox().getSelectedItem().equals("Tous"))
		{
			getControl().switchAll();
		}
		if(getFilterBox().getSelectedItem().equals("Employé"))
		{
			getControl().switchEmp();
		}
		if(getFilterBox().getSelectedItem().equals("Departement"))
		{
			getControl().switchDepartment();
		}
		if(getFilterBox().getSelectedItem().equals("Date"))
		{
			getControl().switchDate();
		}
		
	}
	

}