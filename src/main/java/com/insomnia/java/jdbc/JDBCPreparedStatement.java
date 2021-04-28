package com.insomnia.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.insomnia.java.beans.Student;
import com.insomnia.java.enmu.DBProvide;
import com.insomnia.java.util.JDBCUtils;

public class JDBCPreparedStatement
{
	
	private static final Logger LOG = LogManager.getLogger(JDBCPreparedStatement.class);
	
	public static void main(String[] args)
	{
		Student stu = new Student();
		stu.setName("张三");
		stu.setAge(18);
		stu.setGender("1");
		insert(stu);
	}
	
	public static void insert(Student student)
	{
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = null;
		try
		{
			connection = new JDBCUtils.Build().buildConnection(DBProvide.MYSQL).build();
			LOG.info(connection);
			
			sql = "insert into student (name , age , gender) values (? , ? , ?)";
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, student.getName());
			ps.setInt(2, student.getAge());
			ps.setString(3, student.getGender());
			
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtils.closeStatement(ps);
			JDBCUtils.closeConnection(connection);
		}
	}
	
	public static void delete()
	{
		
	}
	
	public static void update()
	{
		
	}
}
