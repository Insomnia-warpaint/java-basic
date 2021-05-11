package com.insomnia.java.design.singleton;

import javax.print.attribute.SetOfIntegerSyntax;

public enum EnumSingleton {
    INSTANCE;

    private Object o;

    public void setO(Object o) {
        this.o = o;
    }

    public Object getO() {
        return o;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
