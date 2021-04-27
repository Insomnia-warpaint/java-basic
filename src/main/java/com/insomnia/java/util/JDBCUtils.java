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

import com.insomnia.java.enmu.DBProvide;

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
		}
		catch (IOException e)
		{
			logger.error("{}", e.getMessage(), e);
		}
		
	}
	
	public static class Build
	{
		
		private DBProvide dbProvide;
		
		/**
		 * 传入需要构建的数据库类型 ORACLE or MYSQL
		 * @param dbProvide
		 * @return
		 */
		public Build buildConnection(DBProvide dbProvide)
		{
			this.dbProvide = dbProvide;
			
			return this;
		}
		
		public Connection build() throws SQLException
		{
			return openConnection(dbProvide);
		}
	}
	

	/**
	 * 开启数据库连接
	 * @return 
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	private static Connection openConnection(DBProvide dbProvide) throws SQLException
	{
		String url = "";
		
		String driverClassName = "";
		String userName = "";
		String password = "";
		switch (dbProvide)
		{
			case MYSQL:
				url = dbProperties.getProperty("mysql.jdbc.url");
				driverClassName = dbProperties.getProperty("mysql.jdbc.driverClass");
				userName = dbProperties.getProperty("mysql.jdbc.userName");
				password = dbProperties.getProperty("mysql.jdbc.password");
				break;
			
			case ORACLE:
				url = dbProperties.getProperty("oracle.jdbc.url");
				driverClassName = dbProperties.getProperty("oracle.jdbc.driverClass");
				userName = dbProperties.getProperty("oracle.jdbc.userName");
				password = dbProperties.getProperty("oracle.jdbc.password");
				break;
		}
		
		try
		{
			Class.forName(driverClassName);
		}
		catch (ClassNotFoundException e)
		{
			logger.error("错误消息:{}" + e.getMessage(), e);
		}
		
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


