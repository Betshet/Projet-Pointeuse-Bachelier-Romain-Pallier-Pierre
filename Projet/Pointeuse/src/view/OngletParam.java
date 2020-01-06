package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

import controller.Controller;

public class OngletParam extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton importButton;
	private JButton exportButton;
	private JPanel boutons;
	private GroupLayout gl;
	private GroupLayout.ParallelGroup hGroup;
	private GroupLayout.SequentialGroup vGroup;
	private Controller control;
	
	
	public OngletParam(Controller controller)
	{
		setControl(controller);
		setBoutons(new JPanel());
		setImportButton(new JButton("Importer CSV"));
		setExportButton(new JButton("Exporter CSV"));
		
		//getBoutons().add(getImportButton());
		//Ne fonctionne pas
		getBoutons().add(getExportButton());
		
		getImportButton().addActionListener(this);
		getExportButton().addActionListener(this);
		
		setGl(new GroupLayout(this));
		getGl().setAutoCreateGaps(true);
		getGl().setAutoCreateContainerGaps(true);
		this.setLayout(getGl());
		
		sethGroup( getGl().createParallelGroup()
	        	.addComponent(getBoutons()) );
			setvGroup( getGl().createSequentialGroup()
	        	.addComponent(getBoutons()) );
			getGl().setHorizontalGroup(gethGroup());
			getGl().setVerticalGroup(getvGroup());
	}
	
	public JButton getImportButton() {
		return importButton;
	}


	public void setImportButton(JButton importButton) {
		this.importButton = importButton;
	}


	public JButton getExportButton() {
		return exportButton;
	}


	public void setExportButton(JButton exportButton) {
		this.exportButton = exportButton;
	}


	public JPanel getBoutons() {
		return boutons;
	}


	public void setBoutons(JPanel boutons) {
		this.boutons = boutons;
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
	public void actionPerformed(ActionEvent arg0) {
		if( arg0.getActionCommand().equals("Importer CSV"))
		{
			getControl().importCSV();
		}
		if( arg0.getActionCommand().equals("Exporter CSV"))
		{
			getControl().exportCSV();
		}
		
	}

}
