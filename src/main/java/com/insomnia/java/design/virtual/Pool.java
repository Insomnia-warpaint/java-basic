package com.insomnia.java.design.virtual;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Driver;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 自定义连接池 返回 pool 的唯一实例
 * @author insomnia
 *
 */
public abstract class Pool
{
	private static final Logger logger = LogManager.getLogger(Pool.class);
	/**
	 * properties 文件的名称
	 */
	public String dbProperteisFileName = "";
	
	/**
	 * 数据库连接池的唯一实例
	 */
	private static Pool instance = null;
	
	/**
	 * 最大连接数量
	 */
	protected int maxConnectionSize = 100;
	
	/**
	 * 正常连接数量
	 */
	protected int normalConnectionSize = 10;
	
	/**
	 * 驱动名称
	 */
	protected String driverName = null;
	
	/**
	 * 驱动类
	 */
	protected Driver driver = null;
	
	protected Pool()
	{
		try
		{
			init();
			loadDriver(driverName);
		}
		catch (IOException e)
		{
			logger.error("读取配置文件异常:{}", e.getMessage(), e);
		}
		catch (Exception e)
		{
			
		}
	}
	
	private void init() throws IOException
	{
		InputStream propertSource = Pool.class.getResourceAsStream(dbProperteisFileName);
		Properties properties = new Properties();
		properties.load(propertSource);
		this.driverName = properties.getProperty("");
	}
	
	private void loadDriver(String driverName)
	{
		// TODO Auto-generated method stub
		
	}
	
}
