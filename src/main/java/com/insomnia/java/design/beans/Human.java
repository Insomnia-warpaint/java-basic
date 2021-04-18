package com.insomnia.java.design.beans;

/**
 * 
 * @author insomnia
 *	组合关系 
 *	人的头部和身体是不可分割的一部分
 *	和人具有相同的生命周期
 */
public class Human
{
	private Head head;
	private Body body;
	public void setHead(Head head)
	{
		this.head = head;
	}
	public void setBody(Body body)
	{
		this.body = body;
	}

	public void display()
	{
	}
}
