package com.insomnia.java.design;

import com.insomnia.java.design.singleton.EnumSingleton;
import com.insomnia.java.design.singleton.ExecutorThread;
import com.insomnia.java.design.singleton.LazyStaticInnerClassSingleton;
import com.insomnia.java.logger.Logger;
import com.insomnia.java.logger.LoggerFactory;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main
{
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args)
	{
		Thread h1 = new Thread(new ExecutorThread());
		Thread h2 = new Thread(new ExecutorThread());
		h1.start();
		h2.start();
		LOG.info("END");

	}


	@Test
	public void singleton(){


		try {
			Constructor<LazyStaticInnerClassSingleton> constructor = LazyStaticInnerClassSingleton.class.getDeclaredConstructor();
			constructor.setAccessible(true);
			constructor.getName();
			//constructor.newInstance();


			LazyStaticInnerClassSingleton instance1 = LazyStaticInnerClassSingleton.getInstance();
			LazyStaticInnerClassSingleton instance2 = LazyStaticInnerClassSingleton.getInstance();
			LazyStaticInnerClassSingleton instance3 = LazyStaticInnerClassSingleton.getInstance();

			//LOG.info(instance1 + "");
			//LOG.info(instance2 + "");
			//LOG.info(instance3 + "");




			//LazyStaticInnerClassSingleton o2 = constructor.newInstance();
			//LazyStaticInnerClassSingleton o3 = constructor.newInstance();
			//LOG.info(o1 + "");
			//LOG.info(o2 + "");
			//LOG.info(o3 + "");

			//System.out.println(o1 == o2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void EnumSingletonTest(){
		EnumSingleton instance1 = null;

		EnumSingleton instance2 = EnumSingleton.INSTANCE;

		instance2.setO(new Object());

		try {
			FileOutputStream fos = new FileOutputStream("EnumSingleton.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(instance2);
			oos.flush();
			oos.close();

			FileInputStream fis = new FileInputStream("EnumSingleton.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			instance1 = (EnumSingleton) ois.readObject();

			ois.close();

			System.out.println(instance1.getO());

			System.out.println(instance2.getO());

			System.out.println(instance1.getO() == instance2.getO());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

