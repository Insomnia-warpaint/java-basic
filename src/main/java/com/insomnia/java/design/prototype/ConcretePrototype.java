package com.insomnia.java.design.prototype;

import java.io.*;
import java.util.List;
import java.util.Set;

/**
 * @author insomnia
 */
public class ConcretePrototype implements Cloneable , Serializable {

    private Integer age;

    private String name;

    private Set<String> hobbies;

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHobbies(Set<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Set<String> getHobbies() {
        return hobbies;
    }

    @Override
    public ConcretePrototype clone(){
        try {
            return (ConcretePrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 序列化深克隆
     * @return
     */
    public ConcretePrototype deepClone(){

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (ConcretePrototype) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}
