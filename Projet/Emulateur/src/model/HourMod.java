package model;
import java.sql.Time;
import java.time.LocalTime;
public class HourMod implements java.io.Serializable{
	
	private static final long serialVersionUID = -1127660746644602750L;
	private LocalTime hour;

	public HourMod()
	{
		setHour(java.time.LocalTime.of(1,1));
	}
	
	public HourMod(LocalTime hourToMod)
	{
		setHour(hourToMod);
		LocalTime hourEight= LocalTime.of(hourToMod.getHour(),7,30,0);
		if(hourToMod.isBefore(hourEight))
		{
			setHour(LocalTime.of(hourToMod.getHour(),0,0,0));
			
		}
		else 
		{
			setHour(hourToMod.plusMinutes((75-hour.getMinute())%15));
			setHour(LocalTime.of(hour.getHour(),hour.getMinute(),0,0));
		}
	}
	
	public HourMod(String heure, String minutes)
	{
		int heureInt = Integer.parseInt(heure);
		int minuteInt = Integer.parseInt(minutes);
		
		@SuppressWarnings("deprecation")
		Time newTime = new Time(heureInt, minuteInt, 0);
		
		setHour(newTime.toLocalTime());
	}

	public LocalTime getHour() {
		return hour;
	}

	public void setHour(LocalTime hour) {
		this.hour = hour;
	}

	public void printHourMod()
	{
		System.out.println("Hour : "+hour);
	}
	
	@Override
	public String toString()
	{
		return getHour().toString();
	}
	
	public boolean equals(HourMod comp)
	{
		if(hour.equals(comp.getHour()))
			return true;
		else return false;
	}
	
	
}
