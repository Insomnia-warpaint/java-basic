package com.insomnia.java.scanner;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author insomnia
 * @date 2021年3月23日 上午10:22:03
 * 
 */
public class ComputerAreaWithConsoleInput
{
	private static Logger logger = LogManager.getLogger(ComputerAreaWithConsoleInput.class);
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		logger.info("Enter a number for radius :");
		double radius = input.nextDouble();

		double area = radius * radius * Math.PI;

		logger.info("The area for the circle of radius " + radius + " is " + area);
		input.close();

	}
}
