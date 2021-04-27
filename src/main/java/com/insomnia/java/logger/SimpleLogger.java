package com.insomnia.java.logger;

import org.apache.logging.log4j.LogManager;

public class SimpleLogger implements Logger
{
	
	private static org.apache.logging.log4j.Logger logger;
	
	public SimpleLogger(Class<?> clazz)
	{
		logger = LogManager.getLogger(clazz);
	}
	
	@Override
	public void info(String msg)
	{
		logger.info(msg);

	}
	
	@Override
	public void debug(String msg)
	{
		logger.debug(msg);
		
	}
	
	@Override
	public void error(String msg)
	{
		logger.error(msg);
	}
	
}
