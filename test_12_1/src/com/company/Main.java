package com.company;

public class Main {

    class Animal {
        public String name;
        public int age;

        public Animal(String name,int age) { //父类的构造方法
         this.name = name;
         this.age = age;
        }
    }

    class Dog extends Animal{
        public String name;
        public int age;

        public Dog (String name,int age){ //关于子类的构造方法，看知识点的截图
            super(name, age);
        }
    }

    public static void main(String[] args) { //注意：不能用static
        //这个是今天的学习日志！也包括上课所学知识的代码！
    }
}
