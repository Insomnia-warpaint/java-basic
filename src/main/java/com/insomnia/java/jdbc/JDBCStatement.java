package com.insomnia.java.jdbc;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.insomnia.java.beans.Student;

public class JDBCStatement
{
	
	private static final Logger LOG = LogManager.getLogger(JDBCStatement.class);
	
	public static void main(String[] args)
	{
		Connection connection = connectionMysql();
		LOG.info(connection);
		
		String sql = "select id , name , age , gender from student where id = 5";
		
		try
		{
			Student student = get(sql, Student.class);
			
			if (null != student)
			{
				LOG.info(student);
				return;
			}
			
			LOG.info("获取信息失败!");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Connection connectionMysql()
	{
		
		String url = null;
		Properties info  = null;
		InputStream inStream = null;
		String dirverClass = null;
		String user = null;
		String password = null;
		try{
			inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("DB.properties");
			info = new Properties();
			info.load(inStream);
			url = info.getProperty("mysql.jdbc.url");
			dirverClass = info.getProperty("mysql.jdbc.driverClass");
			user = info.getProperty("mysql.jdbc.userName");
			password = info.getProperty("mysql.jdbc.password");
			Class.forName(dirverClass);
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		}
		catch (Exception e)
		{
			LOG.error("数据库连接异常: {}", e.getMessage(), e);
		}
		
		return null;
		 
	}
	
	public static <T> T get(String sql , Class<T> clazz) throws SQLException
	{
		
		Connection connectionMysql = connectionMysql();
		Statement statement = null;
		ResultSet resultSet = null;
		ResultSetMetaData metaData = null;
		try
		{
			statement = connectionMysql.createStatement();
			resultSet = statement.executeQuery(sql);
			
			metaData = resultSet.getMetaData();
			
			int columnCount = metaData.getColumnCount();
			
			while (resultSet.next())
			{
				T instance = clazz.newInstance();
				
				for (int i = 0; i < columnCount; i++)
				{
					String columnName = metaData.getColumnName(i + 1);
					
					Object columnVal = resultSet.getObject(columnName);
					
					Field declaredField = clazz.getDeclaredField(columnName);
					
					declaredField.setAccessible(true);
					
					declaredField.set(instance, columnVal);
				}
				
				return instance;
			}
			
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
		catch (NoSuchFieldException e)
		{
			e.printStackTrace();
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
		finally
		{
			resultSet.close();
			statement.close();
			connectionMysql.close();
		}
		
		return null;
	}
}
