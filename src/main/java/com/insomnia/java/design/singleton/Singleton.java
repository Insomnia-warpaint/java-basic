package com.insomnia.java.design.singleton;

/**
 * @author insomnia
 */
public class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return  INSTANCE;
    }
}
