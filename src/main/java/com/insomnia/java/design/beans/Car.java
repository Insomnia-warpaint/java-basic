package com.insomnia.java.design.beans;

import com.insomnia.java.design.virtual.Vehicle;

/**
 * 
 * @author insomnia 汽车类
 * 	实现关系 
 * 	汽车实现交通工具类
 */
public class Car implements Vehicle
{
	private String name;
	//汽车持有司机的引用对象
	private Driver driver;

	//汽车由哪个司机驾驶 在启动前初始化
	public void addDriver(Driver driver)
	{
		
	}

	// 汽车需要汽油来提供动力 汽车依赖于汽油
	public void beforRun(Oil oil)
	{

	}

	@Override
	public void run()
	{
		
	};
}


