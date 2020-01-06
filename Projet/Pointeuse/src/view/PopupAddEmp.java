package view;

import java.util.ArrayList;

import javax.swing.*;

import model.Department;


public class PopupAddEmp extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JTextField FieldNom;
	private JTextField FieldPrenom;
	private JTextField FieldContact;
	private JComboBox<Department> BoxDpt;
	private JComboBox<String> BoxStdATHour; 
	private JComboBox<String> BoxStdDTHour; 
	private JComboBox<String> BoxStdATMin; 
	private JComboBox<String> BoxStdDTMin; 
	
	private String[] HourList = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
	private String[] MinList = {"00","15","30","45"};
	
	private JPanel topPanel;
	private JPanel botPanel;
	
	private GroupLayout gl;
	private GroupLayout.ParallelGroup hGroup;
	private GroupLayout.SequentialGroup vGroup;

	
	public PopupAddEmp(ArrayList<Department> DptList) 
	{
			
		setFieldNom(new JTextField(20));
		setFieldPrenom(new JTextField(20));
		setFieldContact(new JTextField(20));
		setBoxDpt(new JComboBox<Department>( DptList.toArray(new Department[DptList.size()])));
		
		setBoxStdATHour(new JComboBox<String>(HourList));
		setBoxStdDTHour(new JComboBox<String>(HourList));
		setBoxStdATMin(new JComboBox<String>(MinList));
		setBoxStdDTMin(new JComboBox<String>(MinList));
	   
		setTopPanel( new JPanel() );
		setBotPanel( new JPanel() );
		
		
		getTopPanel().add(new JLabel("Nom:"));
		getTopPanel().add(getFieldNom());
		getTopPanel().add(Box.createHorizontalStrut(15));
		getTopPanel().add(new JLabel("Prenom:"));
		getTopPanel().add(getFieldPrenom());
		getTopPanel().add(Box.createHorizontalStrut(15)); 
		getTopPanel().add(new JLabel("Contact:"));
		getTopPanel().add(getFieldContact());
		
		getBotPanel().add(new JLabel("Departement:"));
		getBotPanel().add(getBoxDpt());
		getBotPanel().add(Box.createHorizontalStrut(15)); 
		getBotPanel().add(new JLabel("Standart Arrival Time:"));
		getBotPanel().add(getBoxStdATHour());
		getBotPanel().add(new JLabel(" : "));
		getBotPanel().add(getBoxStdATMin());
		getBotPanel().add(Box.createHorizontalStrut(15)); 
		getBotPanel().add(new JLabel("Standart Departure Time:"));
		getBotPanel().add(getBoxStdDTHour());
		getBotPanel().add(new JLabel(" : "));
		getBotPanel().add(getBoxStdDTMin());
		
		setGl(new GroupLayout(this));
		getGl().setAutoCreateGaps(true);
		getGl().setAutoCreateContainerGaps(true);
		this.setLayout(getGl());
		
		sethGroup( getGl().createParallelGroup()
	        	.addComponent(getTopPanel())
	        	.addComponent(getBotPanel()) );
		setvGroup( getGl().createSequentialGroup()
	        	.addComponent(getTopPanel())
	        	.addComponent(getBotPanel()) );
		getGl().setHorizontalGroup(gethGroup());
		getGl().setVerticalGroup(getvGroup());
		
		JOptionPane.showConfirmDialog(
				null,
				this,
                "Ajouter Employé",
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
	public JTextField getFieldPrenom() {
		return FieldPrenom;
	}
	public void setFieldPrenom(JTextField yField) {
		this.FieldPrenom = yField;
	}
	public JTextField getFieldContact() {
		return FieldContact;
	}
	public void setFieldContact(JTextField fieldContact) {
		FieldContact = fieldContact;
	}
	public JComboBox<Department> getBoxDpt() {
		return BoxDpt;
	}
	public void setBoxDpt(JComboBox<Department> fieldDpt) {
		BoxDpt = fieldDpt;
	}

	public JComboBox<String> getBoxStdATHour() {
		return BoxStdATHour;
	}

	public void setBoxStdATHour(JComboBox<String> boxStdATHour) {
		BoxStdATHour = boxStdATHour;
	}

	public JComboBox<String> getBoxStdDTHour() {
		return BoxStdDTHour;
	}

	public void setBoxStdDTHour(JComboBox<String> boxStdDTHour) {
		BoxStdDTHour = boxStdDTHour;
	}

	public JComboBox<String> getBoxStdATMin() {
		return BoxStdATMin;
	}

	public void setBoxStdATMin(JComboBox<String> boxStdATMin) {
		BoxStdATMin = boxStdATMin;
	}

	public JComboBox<String> getBoxStdDTMin() {
		return BoxStdDTMin;
	}

	public void setBoxStdDTMin(JComboBox<String> boxStdDTMin) {
		BoxStdDTMin = boxStdDTMin;
	}

	public JPanel getTopPanel() {
		return topPanel;
	}
	public void setTopPanel(JPanel topPanel) {
		this.topPanel = topPanel;
	}
	public JPanel getBotPanel() {
		return botPanel;
	}
	public void setBotPanel(JPanel botPanel) {
		this.botPanel = botPanel;
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


}
