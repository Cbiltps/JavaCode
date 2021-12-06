package com.cbiltps.test;

class Animal {
    public String name;
    public int age;

    public void eat() {
        System.out.println("EAT");
    }
}

//继承Animal类，代码量大大的减少了
class Dog extends Animal{ //这里的Dog称之为子类
    
}

class Bird extends Animal{

    public String swing;

    public void fly() {
        System.out.println("FLY");
    }
}

public class TestDemo2 {
}
