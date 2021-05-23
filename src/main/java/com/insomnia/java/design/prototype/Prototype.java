package com.insomnia.java.design.prototype;

/**
 * @author insomnia
 */
public interface Prototype<T> {
    /**
     * 克隆
     * @return
     */
    T clone();
}
