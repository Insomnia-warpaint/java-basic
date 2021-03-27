package com.insomnia.java.scanner;
/**
 * @author insomnia
 * @date 2021年3月26日 上午8:23:38
 * 
 */

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.insomnia.java.util.ScannerUtils;

public class ComputeChange
{
	private static Logger logger = LogManager.getLogger(ComputeChange.class);

	public static void main(String[] args)
	{
		Scanner input = ScannerUtils.getSystemInputStream();
		logger.info("Enter an amount in double, for example 11.56: ");
		double amount = input.nextDouble();

		int remainingAmount = (int) (amount * 100);
	}
}
