package com.insomnia.java.scanner;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.insomnia.java.util.ScannerUtils;

/**
 * @author insomnia
 * @date 2021年3月23日 下午9:32:31
 * 
 */
public class ComputeLoan
{
	private static Logger logger = LogManager.getLogger(ComputeLoan.class);

	/**
	 * 程序满足如下需求: 
	 * 必须能让用户输入 利率 贷款额度 以及支付年数 从而计算支付额度 
	 * 必须能计算显示 月支付额度 和 总支付额度
	 * 
	 * 月支付额度 = 贷款额度 * 月利率 / 1 / ( 1 - ( 1 / ( 1 + 月利率 ) ^ 年数 * 12 ) )
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner input = ScannerUtils.getSystemInputStream();
		//输入年利率
		logger.info("Enter annual interest rate, e.g ,5.75: ");
		double annualInterestRate = input.nextDouble();
		//转换成月利率
		double monthlyInterestRate = annualInterestRate / 1200;

		//输入支付了多少年
		logger.info("Enter number of years as an integer, e.g. , 5: ");
		int numberOfYears = input.nextInt();

		//输入贷款总金额
		logger.info("Enter loan mount , e.g, 120000.95");
		double loadAmount = input.nextDouble();
		
		// calculation payment 按照上面的公式 计算 月支付额度
		double monthlyPayment = loadAmount * monthlyInterestRate / 1 / (1 - (1 / Math.pow(
				(1 + monthlyInterestRate), numberOfYears * 12
		)));

		// 总支付额度 = 月支付额度 * 12 * 支付的年数
		double totalPayment = monthlyPayment * numberOfYears * 12;

		logger.info("The monthly payment is $" + (int) monthlyPayment);
		logger.info("The total payment is $" + (int) totalPayment);
	}
}
