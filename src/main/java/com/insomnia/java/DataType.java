package com.insomnia.java;

/**
 * @author insomnia
 * @date 2021年3月23日 上午11:45:50
 * 
 */
public enum DataType
{

	/**
	 * 基本数据类型
	 */
	BYTE("byte"), SHORT("short"), INT("int"), LONG("long"), FLOAT("float"), DOUBLE("double");


	private DataType(String type)
	{
		this.type = type;
	}

	private String type;
	
	public String getType() {
		return type;
	}

}
