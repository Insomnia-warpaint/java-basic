package com.insomnia.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentDao implements BaseDao
{

	private static final Logger logger = LogManager.getLogger(StudentDao.class);

	private static Connection connection;

	private static Statement statement;

	private static PreparedStatement prepared;


	@Override
	public <T> boolean save(T o)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer id)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> boolean update(T o)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T select(Integer id)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
