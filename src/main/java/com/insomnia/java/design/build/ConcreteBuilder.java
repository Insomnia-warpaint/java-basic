package com.insomnia.java.design.build;

/**
 * @author insomnia
 */
public class ConcreteBuilder implements IBuild{

    private Product product = new Product();
    @Override
    public Product build() {
        return product;
    }
}
