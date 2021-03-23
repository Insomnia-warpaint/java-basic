package com.insomnia.java.scanner;
/**
 * @author insomnia
 * @date 2021年3月23日 上午11:14:59
 * 
 */

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.insomnia.java.util.ScannerUtils;

public class ComputerAreaWithConstant
{
	private static Logger logger = LogManager.getLogger(ComputerAreaWithConstant.class);

	public static void main(String[] args)
	{
		final double PI = 3.14159;

		Scanner input = ScannerUtils.getSystemInputStream();

		logger.info("Enter a number for radius:");

		double radius = input.nextDouble();

		double area = radius * radius * PI;

		logger.info("The area for the circle of radius " + radius + " is " + area);

		input.close();
	}
}
