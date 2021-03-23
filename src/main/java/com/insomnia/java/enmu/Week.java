package com.insomnia.java.enmu;
/**
 * @author insomnia
 * @date 2021年3月23日 下午1:48:22
 * 
 */
public enum Week
{
	SUNDAY("SunDay", 0), MONDAY("Monday", 1), TUESDAY("Tuesday", 2), WEDNESDAY("WednesDay", 3), THURSDAY("ThursDay", 4),
	FRIDAY("Friday", 5), SATURDAY("Saturday", 6);

	private String weekName;
	private int weekDay;

	private Week(String weekName, int weekDay)
	{
		this.weekName = weekName;
		this.weekDay = weekDay;
	}

	public String getWeekName()
	{
		return weekName;
	}

	public int getWeekDay()
	{
		return weekDay;
	}

}
