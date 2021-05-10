package com.insomnia.java;

import java.sql.Connection;

import com.insomnia.java.design.jdbc.DBConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Main
{
	private static Logger logger = LogManager.getLogger(Main.class);

	@Test
	public void understandException()
	{
		try
		{
			throw new NullPointerException("is null");
		}
		catch (NullPointerException e)
		{
			logger.error("错误消息: {}", e.getMessage(), e);
		}

	}

	@Test
	public void DBConnection()
	{
		try
		{
			DBConnectionPool pool = DBConnectionPool.getInstance();


			Connection connection = pool.getConnection();
			System.out.println(pool.getNum());
			System.out.println(pool.getNumActive());
			pool.release();

			System.out.println(pool.getNum());
			System.out.println(pool.getNumActive());
//			Connection connection = new JDBCUtils.Build().buildConnection(DBProvide.ORACLE).build();
			logger.info(connection);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * {@link java.util.Collections.indexedBinarySearch}
	 * @see line 226
	 */
	@Test
	public void unSignedShift()
	{
		/**
		 * 无符号右移动  5 >>> 1 like 5 / 2  =  2.5  = 2 ignore decimal point  5 >>> 2 like 5 / 2 = 2 then 2 / 2 = 1 
		 */
		logger.info((10 + 10) >>> 3);

	}
	
	public void understandGetIteratorWithCollections(){
		 
		
	}


}
