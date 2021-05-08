package com.insomnia.java.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Pool {

	private static final Logger LOG = LogManager.getLogger(Pool.class);

	private static Pool instance = null;
	
	protected String propertiesName = "DB.properties";

	protected int maxConnect = 100;

	protected int normalConnect = 10;

	protected String driverName = null;

	protected Driver driver = null;

	protected Pool() {

		try {
			init();
			loadDrivers(driverName);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void init() throws IOException {

		InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesName);
		Properties prop = new Properties();
		prop.load(inStream);
		this.driverName = prop.getProperty("driverName");
		this.maxConnect = Integer.parseInt(prop.getProperty("maxConnect"));
	}

	protected void loadDrivers(String driverName) {
		String driverClassName  = driverName;
		
		try {
		 driver = (Driver)Class.forName(driverClassName).getDeclaredConstructor().newInstance();
		 DriverManager.registerDriver(driver);
		 LOG.info("driver register success!");
		} catch (Exception e) {
			LOG.error("register driver : " + driverClassName + " error ,Cause {}", e.getMessage() , e);
		} 
	};
	
	/**
	 * 创建连接池
	 */
	public abstract void createPool();
	
	/**
	 * 
	 * @return	 获取连接池实例
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 */
	public static synchronized Pool getInstance() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		
		if(null == instance) {
			/*
			 * ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			 * Class<Pool> loadClass = (Class<Pool>)
			 * classLoader.loadClass("com.insomnia.java.jdbc.Pool");
			 * loadClass.getDeclaredConstructor().setAccessible(true);
			 * loadClass.getDeclaredConstructor().newInstance();
			 */
			Constructor<?> constructor = Class.forName("com.insomnia.java.jdbc.Pool").getDeclaredConstructor();
			constructor.setAccessible(true);
			instance = (Pool) constructor.newInstance();
		}
		return instance;
		
	}

	/**
	 * 获取数据库连接
	 * @return
	 */
	public abstract Connection getConnection();

	/**
	 * 获取数据库连接，有时间限制
	 * @param time
	 * @return
	 */
	public abstract Connection getConnection(long time);

	/**
	 * 将连接对象释放到连接池
	 * @param conn
	 */
	public abstract void freeConnection(Connection conn);

	/**
	 * 返回空闲连接数
	 * @return
	 */
	public abstract int getNum();

	/**
	 * 获取当前连接数
	 * @return
	 */
	public  abstract int getNumActive();

	/**
	 * 关闭所有连接，注销注册驱动
	 */
	protected  synchronized void release(){
		try {
			DriverManager.deregisterDriver(driver);
			LOG.info("deregisterDriver success!");
		} catch (SQLException e) {
			LOG.error("deregisterDriver fail Cause : {}" + e.getMessage() , e);
		}


	}

}
