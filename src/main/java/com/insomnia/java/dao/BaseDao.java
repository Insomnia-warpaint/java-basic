package com.insomnia.java.dao;

import java.sql.SQLException;

public interface BaseDao
{
	/**
	 * 保存信息
	 * @param <T>
	 * @param o 对象
	 * @return 成功 true 失败 false
	 */
	<T> boolean save(T o) throws SQLException;
	
	/**
	 * 删除信息
	 * @param id 主键
	 * @return 成功 true 失败 false
	 */
	boolean delete(Integer id);
	
	/**
	 * 修改信息
	 * @param <T>
	 * @param o 对象
	 * @return 成功 true 失败 false
	 */
	<T> boolean update(T o);

	/**
	 * 
	 * @param <T>
	 * @param id 主键
	 * @return 查询结果
	 */
	<T> T select(Integer id);

}
