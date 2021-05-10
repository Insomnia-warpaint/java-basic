package com.insomnia.java.design.singleton;

public class LazyDoubleCheckSingleton {

    private volatile static LazyDoubleCheckSingleton instance;

    private LazyDoubleCheckSingleton(){}

    public static LazyDoubleCheckSingleton getInstance(){

        if (null == instance){
            synchronized (LazyDoubleCheckSingleton.class){
                //if (null == instance)
                instance = new LazyDoubleCheckSingleton();
            }
        }
        return instance;
    }
}
