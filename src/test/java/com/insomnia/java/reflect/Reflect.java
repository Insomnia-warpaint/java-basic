package com.insomnia.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.insomnia.java.beans.Student;

/**
 * 
 * @author insomnia
 *
 */
public class Reflect
{
	private static final Logger logger = LogManager.getLogger(Reflect.class);

	@Test
	public void getStudentInstanceByNewClass()
	{
		Student student = new Student(1, "liMing", 12, "1");
		logger.info(student);
	}

	@Test
	public void getStudentInstanceByReflect()
	        throws NoSuchMethodException , SecurityException , InstantiationException , IllegalAccessException ,
	        IllegalArgumentException , InvocationTargetException
	{
		/**
		 * 通过反射创建实例
		 */
		Class<Student> clazz = Student.class;
		
		Constructor<Student> constructor = clazz.getConstructor(Integer.class, String.class, Integer.class, char.class);
		
		Student instance = constructor.newInstance(2, "wiMing", 13, '0');
		/**
		 * 获取 Student 实例
		 */
		logger.info(instance);
		/**
		 * 
		 */
		logger.info(clazz.getModifiers());
		/**
		 * Canonical : 典范
		 * 全类名 不带 .class 后缀  com.insomnia.java.beans.Student
		 */
		logger.info(clazz.getCanonicalName());
		/**
		 * 和 getCanonicalName 一样 输出 com.insomnia.java.beans.Student
		 */
		logger.info(clazz.getName());
		/**
		 * Student
		 */
		logger.info(clazz.getSimpleName());
		/**
		 * com.insomnia.java.beans.Student
		 */
		logger.info(clazz.getTypeName());
		/**
		 * null
		 */
		logger.info(Arrays.toString(clazz.getSigners()));
		/**
		 * true
		 */
		logger.info(clazz.getClasses() instanceof Object);
		
		/**
		 * 
		 */
		logger.info(Arrays.toString(clazz.getClasses()));
		/**
		 * public class com.insomnia.java.beans.Student
		 */
		logger.info(clazz.toGenericString());
		/**
		 * class com.insomnia.java.beans.Student
		 */
		logger.info(clazz.toString());
		/**
		 * AppClassLoader
		 */
		logger.info(clazz.getClassLoader().getClass().getSimpleName());
		/**
		 * 获取类中所有字段 [ public java.lang.Character
		 * com.insomnia.java.beans.Student.sequence private java.lang.Integer
		 * com.insomnia.java.beans.Student.id, private java.lang.String
		 * com.insomnia.java.beans.Student.name, private java.lang.Integer
		 * com.insomnia.java.beans.Student.age, private char
		 * com.insomnia.java.beans.Student.gender ]
		 */
		logger.info(Arrays.toString(clazz.getDeclaredFields()));
		/**
		 * 获取类中 public 的 字段 
		 * [public java.lang.Character
		 * com.insomnia.java.beans.Student.sequence]
		 */
		logger.info(Arrays.toString(clazz.getFields()));
		/**
		 * 获取类中的所有 public 声明构造器 
		 * [public com.insomnia.java.beans.Student(), 
		 * public com.insomnia.java.beans.Student(java.lang.Integer,
		 * java.lang.String,java.lang.Integer,char)]
		 */
		logger.info(Arrays.toString(clazz.getConstructors()));
		/**
		 * []
		 */
		logger.info(Arrays.toString(clazz.getDeclaredClasses()));
		
		/**
		 * 获取类声明的所有的构造器
		 * [public com.insomnia.java.beans.Student(java.lang.Integer,java.lang.String,java.lang.Integer,char),
		 *  private com.insomnia.java.beans.Student(java.lang.Integer,java.lang.String,java.lang.Integer),
		 *  public com.insomnia.java.beans.Student()]
		 */
		logger.info(Arrays.toString(clazz.getDeclaredConstructors()));
		/**
		 * 获取类中声明的所有方法
		 *  [public java.lang.Integer com.insomnia.java.beans.Student.getAge(), 
		 *  public void com.insomnia.java.beans.Student.setId(java.lang.Integer),
		 *  public void com.insomnia.java.beans.Student.setGender(char),
		 *  public void com.insomnia.java.beans.Student.setAge(java.lang.Integer),
		 *  private void com.insomnia.java.beans.Student.readingBook(),
		 *  protected void com.insomnia.java.beans.Student.study(),
		 *  ...]
		 */
		logger.info(Arrays.toString(clazz.getDeclaredMethods()));
		
		/**
		 * 获取类中声明的所有 public 的方法
		 * [public final native void java.lang.Object.notify(), 
		 * public final native void java.lang.Object.notifyAll()
		 * ...]
		 */
		logger.info(Arrays.toString(clazz.getMethods()));
		
		/**
		 * null
		 */
		logger.info(Arrays.toString(clazz.getEnumConstants()));
		
	}
}
