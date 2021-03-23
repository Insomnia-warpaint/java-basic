package com.insomnia.java.scanner;
/**
 * @author insomnia
 * @date 2021年3月23日 上午11:30:30
 * 
 */

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.insomnia.java.util.ScannerUtils;

public class Practice
{
	private static Logger logger = LogManager.getLogger(Practice.class);

	public static void main(String[] args)
	{
		nameConvention();
		inputDataType();
		circulationRemainder();
		displayWeek(150, 2);
	}

	// 今天星期二 , 100 天后星期几
	/**
	 * 
	 * @param day     多少天之后
	 * @param weekday 今天星期几
	 */
	private static void displayWeek(int day, int weekday)
	{
		// 求出 day 天后,余数是多少
		int week = day % 7;
		// 用现在的时间 ,加上 day 天后剩下的时间 ,跟 7 取余数
		switch ((week + weekday) % 7)
		{
			case 0:
				logger.info(day + " 天后是星期天");
				break;
			case 1:
				logger.info(day + " 天后是星期一");
				break;
			case 2:
				logger.info(day + " 天后是星期二");
				break;
			case 3:
				logger.info(day + " 天后是星期三");
				break;
			case 4:
				logger.info(day + " 天后是星期四");
				break;
			case 5:
				logger.info(day + " 天后是星期五");
				break;
			case 6:
				logger.info(day + " 天后是星期六");
				break;
			default:
				break;
		}
	}

	// 计算余数 并输出
	private static void circulationRemainder()
	{
		logger.info("56 % 6 = " + 56 % 6);
		logger.info("78 % -4 = " + 78 % -4);
		logger.info("-34 % 5 = " + -34 % 5);
		logger.info("-34 % -5 = " + -34 % -5);
		logger.info("5 % 1 = " + 5 % 1);
		logger.info("1 % 5 = " + 1 % 5);
		logger.info("1 % 5 = " + 1 % 5);
		logger.info("2 % 5 = " + 2 % 5);
		logger.info("3 % 5 = " + 3 % 5);
		logger.info("4 % 5 = " + 4 % 5);
		logger.info("5 % 5 = " + 5 % 5);
		logger.info("25 / 4 = " + 25 / 4);
		logger.info("25 / 4.0 = " + 25 / 4.0);
		logger.info("3 * 2 / 4 = " + 3 * 2 / 4);
		logger.info("3.0 * 2 / 4 = " + 3.0 * 2 / 4);
		logger.info("2 的 3.5 次方 = Math.pow(2 , 3.5) = " + Math.pow(2, 3.5));

	}

	private static void inputDataType()
	{
		Scanner input = ScannerUtils.getSystemInputStream();

		logger.info("Enter a byte value: ");
		// byte byteValue = input.nextByte();
		logger.info("Enter a short value: ");
		// short shortValue = input.nextShort();
		logger.info("Enter a int value: ");
		// int intValue = input.nextInt();
		logger.info("Enter a long value: ");
		// long longValue = input.nextLong();
		logger.info("Enter a float value: ");
		// float floatValue = input.nextFloat();
		logger.info("Enter a double value: ");
		// double doubleValue = input.nextDouble();
		input.close();

	}

	/**
	 * 声明一个 double 类型的 miles 初始化值为 100 
	 * 声明一个 double 类型的常量 KILOMETERS_PRE_MILES 初始化为 1.609 
	 * 声明一个 double 类型的 kilometers , 将 miles 和 KILOMETERS_PRE_MILES 相乘 ,并且赋值给 kilometers 
	 * 在控制台显示 kilometers
	 */
	private static void nameConvention()
	{
		double miles = 100;
		final double KILOMETERS_PRE_MILE = 1.609;
		double kilometers = miles * KILOMETERS_PRE_MILE;

		logger.info("kilometers is " + kilometers);
	}
}
