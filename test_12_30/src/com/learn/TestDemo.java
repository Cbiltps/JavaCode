package com.learn;

//class Animal {
//    public String name = "hello";
//    public int age;
//    protected int count;
//
//    public Animal(String name,int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public void eat() {
//        System.out.println(name+"eat()");
//        System.out.println(count);
//    }
//}
//
//class Dog extends Animal{ //把共性抽取出来之后，代码量大大减少了
//      /*public Dog() {
//          super();
//      }*/
//    public Dog(String name,int age) {
//        super(name,age);
//        //System.out.println("fsfda");
//    }
//}
//
//class Bird extends Animal {
//    public String wing;
//    public String name;//null
//
//    public Bird(String name,int age,String wing) {
//        super(name,age);
//        this.wing = wing;
//    }
//
//    public void fly() {
//        System.out.println(super.name+"fly()"+age);
//    }
//}

class Animal {
    //动物的名字和年龄都是共有的！
    public String name;
    public int age;

    public Animal(String name,int age) {
        this.name = name;
        this.age = age;
    }

    //包括吃也是共有的行为！
    public void eat() {
        System.out.println(name+"eat()");
    }
}

class Dog extends Animal {
    //抽取完后大大减少了代码量！
    public Dog(String name, int age) {
        super(name, age);//显示调用构造方法
    }
}

//下面是错误的对照
//class Bird extends Animal {
//    public String wing;
//
//    public void fly() {
//        System.out.println(name+"fly()"+age);
//    }
//}


public class TestDemo {

}
