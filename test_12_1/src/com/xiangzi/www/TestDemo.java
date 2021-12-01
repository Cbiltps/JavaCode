package com.xiangzi.www;

class Animal {
    public String name;
    public int age;

    public Animal(String name,int age) { //父类的构造方法
        this.name = name;
        this.age = age;
    }
}

class Dog extends Animal {
    public Dog (String name,int age){ //关于子类的构造方法，看知识点的截图
        super(name, age);
    }
}

public class TestDemo {
    public static void main(String[] args) {
//        Animal animal = new Dog("哈士奇",19);//父类引用 引用 子类对象
//        System.out.println(animal.age);
        Dog dog = new Dog("金毛",20);
        System.out.println(dog.age);
    }
}
