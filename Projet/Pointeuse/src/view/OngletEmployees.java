package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.Controller;

public class OngletEmployees extends JPanel implements ActionListener 
{
	private static final long serialVersionUID = 1L;

	private DefaultTableModel model;
	private JTable tableauEmp;
	private String[] nomColonnes = {"ID","Nom", "Prenom", "Contact", "Département", "StdAT", "StdDT"};
	private JScrollPane scroll;
	private JPanel boutons;
	private JButton addButton;
	private JButton removeButton;
	private JButton changeDptButton;
	private GroupLayout gl;
	private GroupLayout.ParallelGroup hGroup;
	private GroupLayout.SequentialGroup vGroup;
	private Controller control;
	
	
	public OngletEmployees(Controller controller)
	{
		setControl(controller);
		
		setModel( new DefaultTableModel(getControl().getCompany().getAllEmployeesString(),nomColonnes) );
		
		setTableauEmp(new JTable(model));
		setScroll(new JScrollPane(getTableauEmp()));
		getTableauEmp().setAutoCreateRowSorter(true);
		
		setBoutons(new JPanel());
		setAddButton(new JButton("Ajouter"));
		setRemoveButton(new JButton("Supprimer"));
		setChangeDptButton(new JButton("Changer departement"));
		
		getBoutons().add(getAddButton());
		getBoutons().add(getRemoveButton());
		getBoutons().add(getChangeDptButton());
		
		getAddButton().addActionListener(this);
		getRemoveButton().addActionListener(this);
		getChangeDptButton().addActionListener(this);
		
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
	public JTable getTableauEmp() {
		return tableauEmp;
	}
	public void setTableauEmp(JTable tableauEmp) {
		this.tableauEmp = tableauEmp;
	}
	public String[] getNomColonnes() {
		return nomColonnes;
	}

	public void setNomColonnes(String[] nomColonnes) {
		this.nomColonnes = nomColonnes;
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
	public JButton getAddButton() {
		return addButton;
	}
	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}
	public JButton getRemoveButton() {
		return removeButton;
	}
	public void setRemoveButton(JButton removeButton) {
		this.removeButton = removeButton;
	}
	public JButton getChangeDptButton() {
		return changeDptButton;
	}

	public void setChangeDptButton(JButton changeDptButton) {
		this.changeDptButton = changeDptButton;
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

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if( arg0.getActionCommand().equals("Ajouter"))
			getControl().addRowEmp();
		if( arg0.getActionCommand().equals("Supprimer"))
			getControl().removeRowEmp();
		if( arg0.getActionCommand().equals("Changer departement"))
			getControl().changeDepartmentEmp();
	}

	
}
