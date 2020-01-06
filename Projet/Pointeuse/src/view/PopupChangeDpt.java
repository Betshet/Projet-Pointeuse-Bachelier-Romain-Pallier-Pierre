package view;

import java.util.ArrayList;

import javax.swing.*;

import model.*;


public class PopupChangeDpt extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JTextField FieldNom;
	private JComboBox<Department> DepartmentBox;
	
	public PopupChangeDpt(ArrayList<Department> DepartmentList) 
	{
			
		setFieldNom(new JTextField(20));

		setDepartmentBox(new JComboBox<Department>( DepartmentList.toArray(new Department[DepartmentList.size()])));
		
		add(new JLabel("Nouveau departement:"));
		add(getDepartmentBox());
		
		JOptionPane.showConfirmDialog(
				null,
				this,
                "Changer Departement",
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


	public JComboBox<Department> getDepartmentBox() {
		return DepartmentBox;
	}

	public void setDepartmentBox(JComboBox<Department> departmentBox) {
		DepartmentBox = departmentBox;
	}


}
