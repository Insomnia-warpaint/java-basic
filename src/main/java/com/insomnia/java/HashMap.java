package com.insomnia.java;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HashMap<K,V> extends AbstractMap<K, V> implements Map<K, V>,Cloneable,Serializable
{

	private static final Logger logger = LogManager.getLogger(HashMap.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 8655577179475928171L;
	/**
	 * 初始化容量 2 的 4 次方 16
	 */
	static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

	/**
	 * 最大容量 2 的 30 次方
	 */
	static final int MAXIMUM_CAPACITY = 1 << 30;

	/**
	 * 阈值 0.75
	 */
	static final float DEFAULT_LOAD_FACTOR = 0.75f;

	/**
	 * 树化临界点
	 */
	static final int TREEIFY_THRESHOLD = 8;

	/**
	 * 取消树化的临界点
	 */
	static final int UNTREEIFY_THRESHOLD = 6;

	/**
	 * 最小的树化容量
	 */
	static final int MIN_TREEIFY_CAPACITY = 64;

	static class Node<K, V> implements Map.Entry<K, V>
	{

		final int hash;
		final K key;
		V value;
		Node<K, V> next;

		Node(int hash, K key, V value, Node<K, V> next)
		{
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}

		@Override
		public K getKey()
		{
			return key;
		}

		@Override
		public V getValue()
		{
			return value;
		}

		public final int hashCode()
		{
			return Objects.hash(key) ^ Objects.hashCode(value);
		}

		@Override
		public final V setValue(V newValue)
		{
			V oldValue = value;
			value = newValue;
			return value;
		}

		public final boolean equals(Object o)
		{
			if (o == this)
				return true;
			if(o instanceof Map.Entry){
				Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
				if (Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue()))
				return true;
			}
			return false;
		}

	}

	/**
	 * 判断 类是否实现类 Comparable 接口
	 * 
	 * @param x
	 * @return
	 */
	static Class<?> comparableClassFor(Object x)
	{
		if (x instanceof Comparable)
		{
			Class<?> c;
			Type[] ts, as;
			Type t;
			ParameterizedType p;
			if ((c = x.getClass()) == String.class)
				return c;
			if ((ts = c.getGenericInterfaces()) != null)
			{
				for (int i = 0; i < ts.length; i++)
				{
					if(((t = ts[i]) instanceof ParameterizedType) && 
							((p = (ParameterizedType) t).getRawType() == Comparable.class)
							&&
							(as = p.getActualTypeArguments()) != null && as.length == 1 && as[0] == c)
						return c;
				}

			}
		}
		return null;
	}

	public static void main(String[] args)
	{


		logger.info(Objects.hash('A'));
	}

	@Override
	public V get(Object key)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(Object key)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
