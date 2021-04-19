package com.insomnia.java.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author insomnia
 *
 */
public class Student
{
	
	private static final Logger logger = LogManager.getLogger(Student.class);
	
	public Character sequence;
	/**
	 * 学号 id 主键
	 */
	private Integer id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 	年龄
	 */
	private Integer age;
	/**
	 *  0 女 1 男
	 */
	private char gender;

	public Student()
	{

	}
	
	@SuppressWarnings("unused")
	private Student(Integer id, String name, Integer age)
	{
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Student(Integer id, String name, Integer age, char gender)
	{
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public char getGender()
	{
		return gender;
	}

	public void setGender(char gender)
	{
		this.gender = gender;
	}
	
	protected void study()
	{
		logger.info("The quietly study");
	}
	
	@SuppressWarnings("unused")
	private void readingBook()
	{
		logger.info("reading design patterns");
	}

	@Override
	public String toString()
	{
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + gender;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age == null)
		{
			if (other.age != null)
				return false;
		}
		else if (!age.equals(other.age))
			return false;
		if (gender != other.gender)
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	static enum Const
	{
		KNOWLEDGE
	}

}
