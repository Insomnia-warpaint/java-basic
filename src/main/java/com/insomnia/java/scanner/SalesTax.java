package com.insomnia.java.scanner;
/**
 * @author insomnia
 * @date 2021年3月23日 下午9:00:39
 * 
 */

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.insomnia.java.util.ScannerUtils;

public class SalesTax
{
	private static Logger logger = LogManager.getLogger(SalesTax.class);

	public static void main(String[] args)
	{
		// purchase 采购 Sales 销售 tax 税 amount 数量
		Scanner input = ScannerUtils.getSystemInputStream();
		logger.info("Enter purchase amount :");
		double purchaseAmount = input.nextDouble();

		double tax = purchaseAmount * 0.06;

		logger.info("Sales tax is $" + (int) (tax * 100) / 100.0);
	}
}
