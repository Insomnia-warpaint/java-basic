package com.insomnia.java.scanner;


import com.insomnia.java.logger.Logger;
import com.insomnia.java.logger.LoggerFactory;

/**
 * 
 * @author insomnia
 *
 */
public class AdditionQuiz
{
	private static final Logger logger = LoggerFactory.getLogger(AdditionQuiz.class);
	
	public static void main(String[] args)
	{
		int number1 = (int) (System.currentTimeMillis() % 10);
		int number2 = (int) (System.currentTimeMillis() / 10 % 10);
		
		logger.info("" + number1);
		logger.info("" + number2);
	}
}
