package com.insomnia.java.design.factory;

import org.apache.logging.log4j.Logger;

import com.insomnia.java.logger.LoggerFactory;

public class Main
{
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args)
	{
		SimpleGoodsFactory.makeGoods(1).doSomething();

		logger.info("111");
	}
}

