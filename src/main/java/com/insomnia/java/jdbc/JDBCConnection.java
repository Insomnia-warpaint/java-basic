package com.insomnia.java.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBCConnection
{
	
	private static final Logger LOG = LogManager.getLogger(JDBCConnection.class);
	
	public static void main(String[] args)
	{
		patternOne();
		patternTwo();
		patternThree();
		patternFour();
		patternFive();
	}
	
	private static void patternOne()
	{
		LOG.info("获取连接方式一:");
		Driver driver = null;
		
		Properties info = null;
		
		String url = null;
		
		try
		{
			driver = new com.mysql.cj.jdbc.Driver();
			url = "jdbc:mysql://127.0.0.1:3306";
			info = new Properties();
			info.setProperty("user", "root");
			info.setProperty("password", "final");
			Connection connection = driver.connect(url, info);
			LOG.info(connection);
			connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	private static void patternTwo()
	{
		LOG.info("获取连接方式二:");
		String url = null;
		Properties info = null;
		try
		{
			url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			info = new Properties();
			info.setProperty("user", "SCOTT");
			info.setProperty("password", "final");
			Driver driver = (Driver) Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			Connection connection = driver.connect(url, info);
			LOG.info(connection);
			connection.close();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	private static void patternThree()
	{
		LOG.info("获取连接方式三:");
		String url = null;
		Properties info = null;
		
		try
		{
			url = "jdbc:mysql://127.0.0.1:3306";
			info = new Properties();
			info.setProperty("user", "root");
			info.setProperty("password", "final");
			@SuppressWarnings("unchecked")
			Class<Driver> clazz = (Class<Driver>) Class.forName("com.mysql.cj.jdbc.Driver");
			Driver driver = clazz.newInstance();
			DriverManager.registerDriver(driver);
			Connection connection = DriverManager.getConnection(url, info);
			LOG.info(connection);
			connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	private static void patternFour()
	{
		LOG.info("获取连接方式四:");
		String url = null;
		Properties info = null;
		
		try
		{
			url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			info = new Properties();
			info.setProperty("user", "SCOTT");
			info.setProperty("password", "final");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection(url, info);
			LOG.info(connection);
			connection.close();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	private static void patternFive()
	{
		LOG.info("获取连接方式五:");
		InputStream inStream = null;
		Properties info = null;
		try
		{
			inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("DB.properties");
			info = new Properties();
			info.load(inStream);
			String url = info.getProperty("mysql.jdbc.url");
			String dirverClass = info.getProperty("mysql.jdbc.driverClass");
			String user = info.getProperty("mysql.jdbc.userName");
			String password = info.getProperty("mysql.jdbc.password");
			Class.forName(dirverClass);
			Connection connection = DriverManager.getConnection(url, user, password);
			LOG.info(connection);
			connection.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
