package com.company;

/**
 * 现在讲第三个接口！
 *
 * 我们继续来探讨一下 创建对象的方式：
 * 1：new关键字
 * 2：实现Cloneable接口
 */

//要想一个类被克隆就要实现Cloneable接口
//class Person implements Cloneable{
//    public int age;
//
//    public void eat() {
//        System.out.println("Eatting!");
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "age=" + age +
//                '}';
//    }

    /**
     * clone方法比较特殊，底层是用C/C++实现的，如果要使用它就必须override
     * @return
     * @throws CloneNotSupportedException
     */
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();//这里没有具体的重写实现，其实就是调用的C/C++代码！
//    }
//}


//public class Main {
//
//    public static void main(String[] args) throws CloneNotSupportedException {
//	Person person = new Person();
//    person.age = 99;//这里赋值
//    Person person1 = (Person) person.clone();//在内存上，拷贝的age也是99！
//        //如果是修改拷贝（person1）的值，也不会影响person的值！
//    }

    //决定是深拷贝还是浅拷贝，不是方法所决定的，而是代码的实现！

    //所以说Clone不能说是深拷贝，
    //但是，我们要想办法让它变成深拷贝！
//}

/**
 * 现在来说如何深拷贝！
 * 下面将上面的代码，进行升华！
 */
class Money implements Cloneable{
    public double m = 12.5;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable{
        public int age;
        public Money money = new Money();

        public void eat() {
            System.out.println("Eatting!");
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
//            return super.clone();//这里没有具体的重写实现，其实就是调用的C/C++代码！
            Person tmp = (Person)super.clone();
            tmp.money = (Money) this.money.clone();
            return tmp;
            //上面的操作就是一个 深拷贝 的作用！
        }
    }

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        Person person2 = (Person)person.clone();
        System.out.println(person.money.m);
        System.out.println(person2.money.m);
        //打印出来后都是一样的值，为什么呢？看内存图！
        System.out.println("=====================");
        person2.money.m = 99.99;
        System.out.println(person.money.m);
        System.out.println(person2.money.m);
        //打印出来后都是一样的值，为什么呢？看内存图！

        //所以这里是浅拷贝！
        //如何深拷贝呢？

        //决定是深拷贝还是浅拷贝，不是方法所决定的，而是代码的实现！
    }
}
