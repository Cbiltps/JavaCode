package com.other;

class Animal {
    public String name = "动物";
    public int age;
    protected int count;

    public Animal(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println(name+"eat()");
    }
}

class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);//显示调用构造方法
    }

    @Override //这个是注解
    public void eat() {
        System.out.println(name+"crazy eat()");
    }
}

class Bird extends Animal {
    public String wing;
    public String name;//null

    public Bird(String name, int age, String wing) {
        super(name, age);
        this.wing = wing;
    }

    public void fly() {
        System.out.println(super.name + "fly()");
    }
}

public class TestDemo2 {

    //此时发生了 动态绑定
    public static void main(String[] args) {
        Animal animal = new Dog("旺财",23);//向上转型   父类引用 引用 子类对象
        animal.eat();
    }

    public static void func(Animal animals) {

    }

    public static Animal fun2(Animal animalss) {
        Dog dog = new Dog("huahua",23);
        return dog;
    }

    public static void main1(String[] args) {

        /*Dog dog = new Dog("旺财",20);
        Animal animal = dog;*/

        //把上面的代码简化一下
//        Animal animal = new Dog("旺财",23);//向上转型   父类引用 引用 子类对象

        Dog dog = new Dog("金毛",20);
        func(dog);
    }
}
