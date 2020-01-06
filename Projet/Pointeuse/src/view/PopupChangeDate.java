package view;

import javax.swing.*;


public class PopupChangeDate extends JPanel{

	private static final long serialVersionUID = 1L;
	private JComboBox<String> Year;
	private JComboBox<String> Month;
	private JComboBox<String> Day;
	private String[] Years = {"2020","2019","2018","2017"};
	private String[] Months = {"01","02","03","04","05","06","07","08","09","10","11","12"};
	private String[] Days = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	
	public PopupChangeDate() 
	{
		setYear(new JComboBox<String>( Years ));
		setMonth(new JComboBox<String>( Months ));
		setDay(new JComboBox<String>( Days ));
		
		add(new JLabel("Choisir date à filtrer: "));
		add(new JLabel("Année"));
		add(getYear());
		add(new JLabel("Mois"));
		add(getMonth());
		add(new JLabel("Jour"));
		add(getDay());
		
		JOptionPane.showConfirmDialog(
				null,
				this,
                "Filtrer date",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.PLAIN_MESSAGE
                );
	}

	public JComboBox<String> getYear() {
		return Year;
	}

	public void setYear(JComboBox<String> year) {
		Year = year;
	}

	public JComboBox<String> getMonth() {
		return Month;
	}

	public void setMonth(JComboBox<String> month) {
		Month = month;
	}

	public JComboBox<String> getDay() {
		return Day;
	}

	public void setDay(JComboBox<String> day) {
		Day = day;
	}

	public String[] getYears() {
		return Years;
	}

	public String[] getMonths() {
		return Months;
	}

	public String[] getDays() {
		return Days;
	}
}
