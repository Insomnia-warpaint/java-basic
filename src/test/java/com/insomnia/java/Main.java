package com.insomnia.java;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author insomnia
 * @date 2021年3月23日 上午11:07:41
 * 
 */
public class Main
{

	private static Logger logger = LogManager.getLogger(Main.class);
	public static void main(String[] args)
	{
		float f = 12.6F;
		int i = (int) f;
		logger.info("f is " + f);
		logger.info("i is " + i);
		logger.info(4.5 / 100);

	}
}
