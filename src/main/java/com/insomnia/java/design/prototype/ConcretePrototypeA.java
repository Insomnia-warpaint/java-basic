package com.insomnia.java.design.prototype;

/**
 * @author insomnia
 */
public class ConcretePrototypeA implements Prototype<ConcretePrototypeA> {
    private String desc;

    public ConcretePrototypeA(String desc){
        this.desc = desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public ConcretePrototypeA clone() {
        // 进行克隆
        return new ConcretePrototypeA(this.desc);
    }

    @Override
    public String toString() {
        return "ConcretePrototypeA{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
