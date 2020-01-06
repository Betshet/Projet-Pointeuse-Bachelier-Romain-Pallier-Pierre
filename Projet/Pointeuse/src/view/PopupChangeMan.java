package view;

import java.util.ArrayList;

import javax.swing.*;

import model.*;


public class PopupChangeMan extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JTextField FieldNom;
	private JComboBox<Manager> ManagerBox;
	
	public PopupChangeMan(ArrayList<Manager> ManagerList) 
	{
			
		setFieldNom(new JTextField(20));

		setManagerBox(new JComboBox<Manager>( ManagerList.toArray(new Manager[ManagerList.size()])));
		
		add(new JLabel("Nouveau manager:"));
		add(getManagerBox());
		
		JOptionPane.showConfirmDialog(
				null,
				this,
                "Changer Manager",
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
