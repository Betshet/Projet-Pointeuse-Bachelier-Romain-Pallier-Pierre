package view;

import java.util.ArrayList;

import javax.swing.*;

import model.*;


public class PopupAddDpt extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JTextField FieldNom;
	private JComboBox<Manager> ManagerBox;
	
	public PopupAddDpt(ArrayList<Manager> ManagerList) 
	{
			
		setFieldNom(new JTextField(20));

		setManagerBox(new JComboBox<Manager>( ManagerList.toArray(new Manager[ManagerList.size()])));
		
		add(new JLabel("Nom:"));
		add(getFieldNom());
		add(Box.createHorizontalStrut(15));
		add(new JLabel("Manager:"));
		add(getManagerBox());
		
		JOptionPane.showConfirmDialog(
				null,
				this,
                "Ajouter Departement",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.PLAIN_MESSAGE
                );
		
		
	}

	public JTextField getFieldNom() {
		return FieldNom;
	}
	public void setFieldNom(JTextField xField) {
		this.FieldNom = xField;
	}


	public JComboBox<Manager> getManagerBox() {
		return ManagerBox;
	}

	public void setManagerBox(JComboBox<Manager> managerBox) {
		ManagerBox = managerBox;
	}


}
