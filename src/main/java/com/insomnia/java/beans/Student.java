package com.insomnia.java.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

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
	private String gender;

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

	public Student(Integer id, String name, Integer age, String gender)
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

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
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
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Student)) {
			return false;
		}
		Student student = (Student) o;
		return sequence.equals(student.sequence) && getId().equals(student.getId()) && getName().equals(student.getName()) && getAge().equals(student.getAge()) && getGender().equals(student.getGender());
	}

	@Override
	public int hashCode() {
		return Objects.hash(sequence, getId(), getName(), getAge(), getGender());
	}

	static enum Const
	{
		KNOWLEDGE
	}

}
