package com.insomnia.java.design.jdbc;

/**
 * @author insomnia
 */
public class Order {

    private boolean ascending;
    private String propertyName;

    @Override
    public String toString() {
        return "Order{" +
                "ascending=" + ascending +
                ", propertyName='" + propertyName + '\'' +
                '}';
    }

    protected Order(String propertyName,boolean ascending){
        this.propertyName = propertyName;
        this.ascending = ascending;
    }

    public static Order asc(String propertyName){
        return new Order(propertyName,true);
    }

    public static Order desc(String propertyName){
        return new Order(propertyName,false);
    }
}
