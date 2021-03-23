package com.insomnia.java.scanner;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.insomnia.java.util.ScannerUtils;

/**
 * @author insomnia
 * @date 2021年3月23日 下午1:12:15
 * 
 */
public class DisplayTime
{
	private static Logger logger = LogManager.getLogger(DisplayTime.class);

	public static void main(String[] args)
	{
		Scanner input = ScannerUtils.getSystemInputStream();
		// 输入秒数 计算 小时数 分钟数 以及 秒数
		logger.info("Enter an Integer for seconds: ");
		int second = input.nextInt();
		int minuters = second / 60;
		;
		int hours = 0;

		if (60 <= minuters)
		{
			hours = minuters / 60;
			minuters = minuters % 60;
		}

		int remainingSeconds = second % 60;

		logger.info(second + " seconds is " + hours + " hours and " + minuters + " minuters and " + remainingSeconds
				+ " seconds.");

	}
}
