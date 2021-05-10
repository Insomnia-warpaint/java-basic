package com.insomnia.java.design.singleton;

public class HungryStaticSingleton {

    private  static  final  HungryStaticSingleton HUNGRY_STATIC_SINGLETON;
    static {
        HUNGRY_STATIC_SINGLETON = new HungryStaticSingleton();
    }

    private HungryStaticSingleton(){}

    public static HungryStaticSingleton getInstance(){

        return HUNGRY_STATIC_SINGLETON;
    }
}
