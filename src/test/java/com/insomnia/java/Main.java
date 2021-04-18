package com.insomnia.java;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.insomnia.java.util.JDBCUtils;

public class Main
{
	Logger logger = LogManager.getLogger(Main.class);

	@Test
	public void testException()
	{
		try
		{
			throw new NullPointerException("is null");
		}
		catch (Exception e)
		{
			logger.error("错误消息: {}", e.getMessage(), e);
		}

	}

	@Test
	public void DBConnection()
	{
		try
		{
			System.out.println(JDBCUtils.openConnection());
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void saveStudent()
	{


	}

	@Test
	public void deleteStudent()
	{



	}

}
