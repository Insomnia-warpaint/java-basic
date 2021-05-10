package com.insomnia.java.design.singleton;

public class LazySimpleSingleton {

    private LazySimpleSingleton (){}

    private static LazySimpleSingleton lazySimpleSingleton = null;

    public synchronized static LazySimpleSingleton getInstance(){

        if (null == lazySimpleSingleton){
            lazySimpleSingleton = new LazySimpleSingleton();
        }

        return lazySimpleSingleton;
    }
}
