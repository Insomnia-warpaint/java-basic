package com.insomnia.java.scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author insomnia
 * @date 2021年3月23日 上午10:01:07
 * 
 */
public class ComputerArea
{
	private static Logger logger = LogManager.getLogger(ComputerArea.class);

	/**
	 * 计算圆的面积
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		double radius;
		double area;

		radius = 20;
		area = radius * radius * Math.PI;

		logger.info("The area for the circle of raduis " + radius + " is " + area);
	}
}
