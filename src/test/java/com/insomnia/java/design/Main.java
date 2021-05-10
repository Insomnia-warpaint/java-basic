package com.insomnia.java.design;

import com.insomnia.java.design.singleton.ExecutorThread;
import com.insomnia.java.logger.Logger;
import com.insomnia.java.logger.LoggerFactory;

public class Main
{
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args)
	{
		Thread h1 = new Thread(new ExecutorThread());
		Thread h2 = new Thread(new ExecutorThread());
		h1.start();
		h2.start();
		logger.info("END");

	}
}

