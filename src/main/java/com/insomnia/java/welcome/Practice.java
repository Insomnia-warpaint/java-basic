package com.insomnia.java.welcome;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.insomnia.java.enmu.CirculationModle;

/**
 * @author insomnia
 * @date 2021年3月21日 下午2:42:27
 * 
 */
public class Practice
{
	private static Logger logger = LogManager.getLogger(Practice.class);

	public static void main(String[] args)
	{
		displayThreeMassage();
		displayFiveMassage(CirculationModle.FOR);
		displayPatternWithJava();
		displayArithmeticTable();
		ComputerExpression();
	}


	/**
	 * 算出 (9.5 * 4.5 - 2.5 * 3) / 45.5 - 3.5 的结果
	 * 数列求和 
	 * 求 🥧 的近似值
	 */
	private static void ComputerExpression()
	{

		// 算出 (9.5 * 4.5 - 2.5 * 3) / 45.5 - 3.5 的结果
		logger.info("(9.5 * 4.5 - 2.5 * 3) / (45.5 - 3.5) =" + ((9.5 * 4.5 - 2.5 * 3) / (45.5 - 3.5)));

		// 数列求和
		int sum = 0;
		int i = 0;
		for (i = 0; i < 10; i++)
		{
			sum += i;
		}

		logger.info("1 + 2 + 3 + ... + 9  = " + sum);

		int flag = 0;
		double PI;
		double var = 1.0;
		// 求 🥧 的近似值
		// 🥧 = 4 * (1- (1 / 3) + (1 / 5) - (1 / 7) ... + (1 / 13))
		for (i = 0; i < 14; i++)
		{

			if (1 == i)
			{
				continue;
			}
			if (0 == i % 2)
			{
				continue;
			}

			if (0 == flag % 2)
			{
				logger.info("var  = " + var + " - " + "( 1 / " + i + ")");
				var -= (1.0 / i);
				logger.info("var = " + var);
				flag++;
				continue;
			}
			logger.info("var  = " + var + " + " + "( 1 / " + i + ")");
			var += (1.0 / i);
			logger.info("var = " + var);
			flag++;

		}

		PI = 4 * var;
		logger.info("PI = 4 * " + var + " = " + PI);

	}

	/**
	 * 1. 显示算术结果 Math.pow(var1,var2) 算出 var1 的 var2 次方 
	 */

	private static void displayArithmeticTable()
	{
		System.out.println("a	a^2	a^3");
		System.out.println("1" + " 	" + (int) Math.pow(1, 2) + " 	" + (int) Math.pow(1, 3));
		System.out.println("2" + " 	" + (int) Math.pow(2, 2) + " 	" + (int) Math.pow(2, 3));
		System.out.println("3" + " 	" + (int) Math.pow(3, 2) + " 	" + (int) Math.pow(3, 3));
		System.out.println("4" + " 	" + (int) Math.pow(4, 2) + " 	" + (int) Math.pow(4, 3));
	}

	/**
	 * 显示图案
	 */
	private static void displayPatternWithJava()
	{
		System.out.println("    J     A   V     V    A");
		System.out.println("    J    A A   V   V    A A");
		System.out.println("J   J   AAAAA   V V    AAAAA");
		System.out.println(" J J   A     A   V    A     A");

	}

	/**
	 * 显示 三条消息 Welcome to Java , Welcome to Computer Science , Programming is fun
	 */
	private static void displayThreeMassage()
	{
		logger.info("Wlecome to Java");
		logger.info("Wlecome to Computer Science");
		logger.info("Programming is fun");
	}

	/**
	 * 显示 Welcome to Java 五次.
	 */
	private static void displayFiveMassage(CirculationModle circulationModle)
	{
		int i = 0;
		switch (circulationModle)
		{
			case FOR:
				logger.warn("into Fro ...");
				for (i = 0; i < 5; i++)
				{
					logger.info("Wlecome to Java.");
				}
				break;
			case WHILE:
				logger.warn("into While ...");
				while (i < 5)
				{
					logger.info("Wlecome to Java.");
					i++;
				}
				break;
			default:
				logger.warn("into Do While ...");
				do
				{
					logger.info("Wlecome to Java.");
					i++;
				} while (i < 5);
				break;
		}
	}

}
