package view;

import java.util.ArrayList;
import javax.swing.*;
import model.*;


public class PopupSwitchDpt extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JComboBox<Department> DepartmentBox;
	
	public PopupSwitchDpt(ArrayList<Department> DepartmentList) 
	{
		setDepartmentBox(new JComboBox<Department>( DepartmentList.toArray(new Department[DepartmentList.size()])));

		add(new JLabel("Choisir département à filtrer:"));
		add(getDepartmentBox());
		
		JOptionPane.showConfirmDialog(
				null,
				this,
                "Filtrer département",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.PLAIN_MESSAGE
                );
	}

	public JComboBox<Department> getDepartmentBox() {
		return DepartmentBox;
	}

	public void setDepartmentBox(JComboBox<Department> departmentBox) {
		DepartmentBox = departmentBox;
	}


}
