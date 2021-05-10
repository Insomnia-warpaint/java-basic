package com.insomnia.java.design.factory;

import com.insomnia.java.design.goods.Goods_A;
import com.insomnia.java.design.goods.Goods_B;
import com.insomnia.java.design.goods.Goods_C;
import com.insomnia.java.design.virtual.Product;

public class SimpleGoodsFactory
{
	public static Product makeGoods(Integer kind)
	{
		switch (kind)
		{
			case Const.Goods_A:
				return new Goods_A();

			case Const.Goods_B:

				return new Goods_B();
			case Const.Goods_C:

				return new Goods_C();
		}

		throw new IllegalArgumentException("商品种类: 1 = Goods_A , 2 = Goods_B , 3 = Goods_C ,请填写相应种类.");
	}

	final class Const
	{
		static final int Goods_A = 1;
		static final int Goods_B = 2;
		static final int Goods_C = 3;
	}

}

