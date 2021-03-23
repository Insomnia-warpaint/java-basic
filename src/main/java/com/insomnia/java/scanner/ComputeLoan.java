package com.insomnia.java.scanner;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.insomnia.java.util.ScannerUtils;

/**
 * @author insomnia
 * @date 2021年3月23日 下午9:32:31
 * 
 */
public class ComputeLoan
{
	private static Logger logger = LogManager.getLogger(ComputeLoan.class);

	/**
	 * 程序满足如下需求: 
	 * 必须能让用户输入 利率 贷款额度 以及支付年数 从而计算支付额度 
	 * 必须能计算显示 月支付额度 和 总支付额度
	 * 
	 * 月支付额度 = 贷款额度 * 月利率 / 1 / ( 1 - ( 1 / ( 1 + 月利率 ) ^ 年数 * 12 ) )
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner input = ScannerUtils.getSystemInputStream();

	}
}
