package com.insomnia.java.design.goods;

import com.insomnia.java.design.virtual.Product;

public class Goods_A implements Product
{

	@Override
	public void doSomething()
	{
		System.out.println("I am Goods A.");
	}

}
