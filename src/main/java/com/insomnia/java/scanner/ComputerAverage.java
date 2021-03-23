package com.insomnia.java.scanner;
/**
 * @author insomnia
 * @date 2021年3月23日 上午10:39:02
 * 
 */

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.insomnia.java.util.ScannerUtils;

public class ComputerAverage
{
	private static Logger logger = LogManager.getLogger(ComputerAverage.class);

	public static void main(String[] args)
	{
		Scanner input = ScannerUtils.getSystemInputStream();

		logger.info("Enter three number:");
		double firstNum = input.nextDouble();
		double secondNum = input.nextDouble();
		double thridNum = input.nextDouble();

		double avg = (firstNum + secondNum + thridNum) / 3;

		logger.info("The avg of " + firstNum + " " + secondNum + " " + thridNum + " is " + avg);

		input.close();
	}
}
