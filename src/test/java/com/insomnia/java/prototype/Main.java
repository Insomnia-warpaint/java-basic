package com.insomnia.java.prototype;

import com.insomnia.java.design.prototype.ConcretePrototype;
import com.insomnia.java.design.prototype.ConcretePrototypeA;
import com.insomnia.java.design.prototype.ConcretePrototypeB;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Main {

    @Test
    public void testPrototype(){
        ConcretePrototypeA prototypeA = new ConcretePrototypeA("This is prototypeA");

        System.out.printf("prototypeA : %s \n" , prototypeA);

        ConcretePrototypeA clonePrototypeA = prototypeA.clone();
        clonePrototypeA.setDesc("clone desc for prototypeA");
        System.out.printf("clone prototypeA : %s \n" , clonePrototypeA);

        ConcretePrototypeB prototypeB = new ConcretePrototypeB("This is prototypeB");

        System.out.printf("prototypeB : %s \n" , prototypeB);

        ConcretePrototypeB clonePrototypeB = prototypeB.clone();

        System.out.printf("clone prototypeB : %s \n" , clonePrototypeB);

    }

    @Test
    public void testPrototypeImpCloneable(){
        ConcretePrototype prototype = new ConcretePrototype();
        prototype.setAge(11);
        prototype.setName("Tom");
        Set<String> hobbies = new HashSet<>();

        hobbies.add("书法");
        hobbies.add("美术");
        prototype.setHobbies(hobbies);
        System.out.printf("原型对象 %s \n" , prototype);

        // 深克隆
        ConcretePrototype deepClonePrototype = prototype.deepClone();
        deepClonePrototype.getHobbies().add("颜控");
        System.out.printf("深克隆之后的 prototype  %s \n" , prototype);
        System.out.printf("deepClonePrototype  %s \n" , deepClonePrototype);

        //浅克隆
        ConcretePrototype cloneType = prototype.clone();
        cloneType.getHobbies().add("技术控");
        System.out.printf("浅克隆之后的 prototype  %s \n" , prototype);
        System.out.printf("clone prototype %s \n" , cloneType);




    }
}
