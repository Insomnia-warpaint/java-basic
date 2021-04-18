package com.insomnia.java.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBCUtils
{
	private static final Logger logger = LogManager.getLogger(JDBCUtils.class);
	private static final String DB_PROPERTIES_NAME = "DB.properties";
	private static ClassLoader jdbcClassLoader;
	private static InputStream input;
	private static Properties dbProperties;

	/**
	 * 初始化配置文件
	 */
	static
	{
		try
		{
			jdbcClassLoader = Thread.currentThread().getContextClassLoader();
			input = jdbcClassLoader.getResourceAsStream(DB_PROPERTIES_NAME);
			dbProperties = new Properties();
			dbProperties.load(input);
			String driverClassName = dbProperties.getProperty("mysql.jdbc.driverClass");
			Class.forName(driverClassName);
		}
		catch (IOException | ClassNotFoundException e)
		{
			logger.error("{}", e.getMessage(), e);
		}
		
	}
	
	/**
	 * 开启数据库连接
	 * @return 
	 * @throws SQLException
	 */
	public static Connection openConnection() throws SQLException
	{
		String url = dbProperties.getProperty("mysql.jdbc.url");
		String userName = dbProperties.getProperty("mysql.jdbc.userName");
		String password = dbProperties.getProperty("mysql.jdbc.password");
			Connection connection = DriverManager.getConnection(url, userName, password);
			if (null == connection)
			{
				throw new NullPointerException("connection is null");
			}

			return connection;

	}
	
	/**
	 * 关闭 数据库连接
	 * @param connection
	 */
	public static void closeConnection(Connection connection)
	{
		if (null == connection)
		{
			return;
		}

		try
		{
			connection.close();
		}
		catch (SQLException e)
		{
			logger.error(e.getMessage(), e);
		}
	}
	
	public static void closeStatement(Statement statement)
	{
		if (null == statement)
		{
			return;
		}

		try
		{
			statement.close();
		}
		catch (SQLException e)
		{
			logger.error(e.getMessage(), e);
		}
	}
}
