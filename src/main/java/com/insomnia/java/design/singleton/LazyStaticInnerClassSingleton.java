package com.insomnia.java.design.singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLOutput;

/**
 * @author insomnia
 */
public class LazyStaticInnerClassSingleton {

    /**
     * 企图反射调用私有构造器 若已经存在实例,则抛出异常
     */
    private LazyStaticInnerClassSingleton(){

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> LazyStaticInnerClassSingleton 私有构造器");

       if (null != LazyHolder.INSTANCE) {
           throw  new RuntimeException("不允许创建多个实例!");
       }

    }

    public static  LazyStaticInnerClassSingleton getInstance(){

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>  获取 LazyStaticInnerClassSingleton 实例");
        return LazyHolder.INSTANCE;
    }

    /**
     * 默认不加载内部类
     */
    private static class LazyHolder{
        static {
            System.out.println(">>>>>>>>>>>>>>>>>>>>静态内部类的静态代码快 ");
        }
        private static final LazyStaticInnerClassSingleton INSTANCE = new LazyStaticInnerClassSingleton();

    }
}
