package View;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;
import javax.swing.*;
import controller.Controller;
import model.*;

import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;

public class IHM extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private Controller control;
	private DefaultComboBoxModel<Employee> EmployeeModel;
	private JComboBox<Employee> EmployeeList;
	private JButton CheckIO = new JButton("Check In/Out");
	private JButton SyncButton = new JButton("Sync. Infos from the Main App");
	private ClockComponent clock = new ClockComponent();
	private Container panel = getContentPane();
	private GroupLayout gl = new GroupLayout(panel);
	private GroupLayout.ParallelGroup hGroup = gl.createParallelGroup();
	private GroupLayout.SequentialGroup vGroup = gl.createSequentialGroup();

	public IHM(Controller setcontrol, ArrayList<Employee> EmpList) 
	{		
		setControl(setcontrol);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(600,300);	    
	    
	    setEmployeeModel( new DefaultComboBoxModel<Employee>(EmpList.toArray(new Employee[EmpList.size()])) );
	    setEmployeeList( new JComboBox<Employee>(getEmployeeModel() ));
	    CheckIO.addActionListener( this );
	    SyncButton.addActionListener( this );
	    
	    panel.setLayout(gl);
	    
	    gl.setAutoCreateGaps(true);
	    gl.setAutoCreateContainerGaps(true);
	    
	    hGroup.addGroup(gl.createSequentialGroup()
	    		.addPreferredGap(RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	            .addComponent(clock)
	            .addPreferredGap(RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
	    hGroup.addGroup(gl.createSequentialGroup()
	    		.addComponent(EmployeeList)
	            .addComponent(CheckIO)
	            .addPreferredGap(RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
	    hGroup.addGroup(gl.createSequentialGroup()
	            .addPreferredGap(RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	            .addComponent(SyncButton));
	    
	    vGroup.addGroup(gl.createSequentialGroup()
	    		.addPreferredGap(RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
	    vGroup.addGroup(gl.createSequentialGroup()
	    		.addComponent(clock));
	    vGroup.addGroup(gl.createSequentialGroup()
	    		.addPreferredGap(RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
	    vGroup.addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
	            .addComponent(EmployeeList)
	            .addComponent(CheckIO));
	    vGroup.addGroup(gl.createSequentialGroup()
	    		.addPreferredGap(RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
	    vGroup.addGroup(gl.createParallelGroup()
	            .addComponent(SyncButton));
	    
	    gl.setHorizontalGroup(hGroup);
	    gl.setVerticalGroup(vGroup);
	    
	    setVisible(true);
	}

	public Controller getControl() {
		return control;
	}

	public void setControl(Controller control) {
		this.control = control;
	}

	public DefaultComboBoxModel<Employee> getEmployeeModel() {
		return EmployeeModel;
	}

	public void setEmployeeModel(DefaultComboBoxModel<Employee> employeeModel) {
		EmployeeModel = employeeModel;
	}

	public JComboBox<Employee> getEmployeeList() {
		return EmployeeList;
	}

	public void setEmployeeList(JComboBox<Employee> employeeList) {
		EmployeeList = employeeList;
	}

	public JButton getCheckIO() {
		return CheckIO;
	}

	public void setCheckIO(JButton checkIO) {
		CheckIO = checkIO;
	}

	public JButton getSyncButton() {
		return SyncButton;
	}

	public void setSyncButton(JButton syncButton) {
		SyncButton = syncButton;
	}

	public ClockComponent getClock() {
		return clock;
	}

	public void setClock(ClockComponent clock) {
		this.clock = clock;
	}

	public Container getPanel() {
		return panel;
	}

	public void setPanel(Container panel) {
		this.panel = panel;
	}

	public GroupLayout getGl() {
		return gl;
	}

	public void setGl(GroupLayout gl) {
		this.gl = gl;
	}

	public void afficher()
	{
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Check In/Out"))
		{
			getControl().check();
		}
		if(e.getActionCommand().equals("Sync. Infos from the Main App"))
		{
			getControl().sync();
		}
	}
	
	public void sync(ArrayList<Employee> EmpList)
	{
		setEmployeeModel( new DefaultComboBoxModel<Employee>(EmpList.toArray(new Employee[EmpList.size()])));
		getEmployeeList().setModel( getEmployeeModel());
	}
}
	

