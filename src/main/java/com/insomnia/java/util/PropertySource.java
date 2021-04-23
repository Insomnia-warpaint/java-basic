package com.insomnia.java.util;

public interface PropertySource
{
	/**
	 * 获取优先级
	 * @return
	 */
	int getPriority();
	
	/**
	 * 根据 key 获取 value
	 * @param key
	 * @return
	 */
	default String getProperty(String key)
	{
		return null;
	}
	
	/**
	 * 是否包含 key
	 * @param key
	 * @return
	 */
	default boolean containsProperty(String key)
	{
		return false;
	}
	
}
