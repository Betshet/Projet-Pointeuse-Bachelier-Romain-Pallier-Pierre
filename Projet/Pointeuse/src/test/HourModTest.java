package test;

import static org.junit.Assert.*;

import java.time.LocalTime;

import model.HourMod;

import org.junit.Test;

public class HourModTest {
	
	@Test
	public void modifHourTest()
	{
		LocalTime dt=LocalTime.of(16,07,0,0);
		HourMod testHour = new HourMod(dt);
		assertEquals(testHour.getHour().getHour(),16);
		assertEquals(testHour.getHour().getMinute(),0);
		
		dt=LocalTime.of(16,14,0,0);
		testHour = new HourMod(dt);
		assertEquals(testHour.getHour().getHour(),16);
		assertEquals(testHour.getHour().getMinute(),15);
		
		dt=LocalTime.of(0,0,1,9);
		testHour = new HourMod(dt);
		assertEquals(testHour.getHour().getHour(),0);
		assertEquals(testHour.getHour().getMinute(),0);
	}
	
	

}
