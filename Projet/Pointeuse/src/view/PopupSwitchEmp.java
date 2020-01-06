package view;

import java.util.ArrayList;
import javax.swing.*;
import model.*;

public class PopupSwitchEmp extends JPanel {
private static final long serialVersionUID = 1L;
	
	private JComboBox<Employee> EmpBox;
	
	public PopupSwitchEmp(ArrayList<Employee> EmpList) 
	{

		setEmpBox(new JComboBox<Employee>( EmpList.toArray(new Employee[EmpList.size()])));
		
		add(new JLabel("Choisir employé à filtrer:"));
		add(getEmpBox());
		
		JOptionPane.showConfirmDialog(
				null,
				this,
                "Filtrer employé",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.PLAIN_MESSAGE
                );
		
		
	}

	public JComboBox<Employee> getEmpBox() {
		return EmpBox;
	}

	public void setEmpBox(JComboBox<Employee> empBox) {
		EmpBox = empBox;
	}
}
