package com.insomnia.java.design.prototype;

/**
 * @author insomnia
 */
public class ConcretePrototypeB implements Prototype<ConcretePrototypeB>{

    private String desc;

    public ConcretePrototypeB(String desc) {
        this.desc = desc;
    }

    @Override
    public ConcretePrototypeB clone() {
        return new ConcretePrototypeB(this.desc);
    }

    @Override
    public String toString() {
        return "ConcretePrototypeB{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
