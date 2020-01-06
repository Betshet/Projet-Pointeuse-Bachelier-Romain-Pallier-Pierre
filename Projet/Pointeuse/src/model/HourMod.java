package model;
import java.sql.Time;
import java.time.LocalTime;

/**
 * La classe HourMod contient une heure (LocalTime) arrondie au quart d'heure près. 
 */
public class HourMod implements java.io.Serializable{

	private static final long serialVersionUID = -1127660746644602750L;
	/**
	 * Heure arrondie au quart d'heure près.
	 */
	private LocalTime hour;
	/**
	 * Constructeur par défaut
	 */
	public HourMod()
	{
		setHour(java.time.LocalTime.of(1,1));
	}
	/**
	 * Constructeur de confort
	 * <p>Crée un HourMod en arrondissant l'heure en paramètres au quart d'heure près et
	 * en la stockant dans l'attribut <i>hour</i> </p>
	 * @param hourToMod
	 * 		Heure à modifier
	 */
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
	
	/**
	 * Constructeur de confort
	 * <p>Crée un HourMod à partir de chaînes de caratères représentant l'heure et les minutes </p>
	 * @param heure
	 * 		String de l'heure
	 * @param minutes
	 * 		String des minutes
	 */
	public HourMod(String heure, String minutes)
	{
		int heureInt = Integer.parseInt(heure);
		int minuteInt = Integer.parseInt(minutes);
		
		@SuppressWarnings("deprecation")
		Time newTime = new Time(heureInt, minuteInt, 0);
		
		setHour(newTime.toLocalTime());
	}
	
	
	/**
	 * 
	 * @return Heure
	 */
	public LocalTime getHour() {
		return hour;
	}
	/**
	 * Change l'heure
	 * @param hour
	 * 		Heure
	 */
	public void setHour(LocalTime hour) {
		this.hour = hour;
	}
	/**
	 * Affiche l'objet HourMod dans la console
	 */
	public void printHourMod()
	{
		System.out.println("Hour : "+hour);
	}
	/**
	 * Convertit en String l'objet HourMod
	 */
	@Override
	public String toString()
	{
		return getHour().toString();
	}
	/**
	 * Vérifie si une HourMod est égale à une autre
	 * @param comp
	 * 		HourMod comparé
	 * @return <i>true</i> si les deux HourMod sont égales, <i>false</i> sinon
	 */
	public boolean equals(HourMod comp)
	{
		if(hour.equals(comp.getHour()))
			return true;
		else return false;
	}
}
