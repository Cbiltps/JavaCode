package com.other;

class Animal {
    public String name = "动物";
    public int age;
    protected int count;

    public Animal(String name,int age) {
        eat();//在父类中调用父类和子类重写的eat方法，也会发生所谓的动态绑定！
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println(name+" eat()");
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

    public void func(int a) {
        System.out.println("int");
    }

    public void func(int a,int b) {
        System.out.println("int,int");
    }

    public void func(int a,int b,int c) {
        System.out.println("int,int");
    }
}

class Bird extends Animal {
    public String wing;
    public String name = "鸟类";

    public Bird(String name, int age, String wing) {
        super(name, age);
        this.wing = wing;
    }

    public void fly() {
        System.out.println(super.name + "fly()");
    }
}

public class TestDemo2 {

    public static void main(String[] args) {
        Dog dog = new Dog("wawa",23);
    }

    public static void main6(String[] args) {
        Animal animal4 = new Dog("aa",23);
//        Bird bird = (Bird)animal4;//这里就会报 类型转换异常
//        bird.fly();

        if (animal4 instanceof Bird) { //这里if语句没进来
            Bird bird = (Bird)animal4;//这里就会报 类型转换异常
            bird.fly();
        }
        //运行之后就是什么都没有
    }

    public static void main5(String[] args) {
        Animal animal3 = new Bird("lala",12,"flyyyyy");
        Bird bird = (Bird)animal3;//强行转换
        bird.fly();//这里可以调用fly方法

        //在这里不建议这样写，有的时候是错的（不是非常的安全）！
        //因为不是所有的动物都是鸟，逻辑上就是颠覆认知的！

        //你可以向下转型;
        //前提是：这个引用(animal3) 引用了 你将要向下转型的这个对象(bird)!
    }

    public static void main4(String[] args) {
        Dog dog = new Dog("haha",19);
        dog.func(10);
    }

    //此时发生了 动态绑定
    public static void main2(String[] args) {
//        Animal animal = new Dog("旺财",23);//向上转型   父类引用 引用 子类对象
//        animal.eat();

        Animal animal2 = new Bird("wuya",12,"wuya fly!");
        animal2.eat();//可以调用eat方法

        System.out.println(animal2.name);//这里其实访问的是父类的name

//        System.out.println(animal2.wing); 无法访问的
//        因为animal的类型是Animal类型
//        意思就是：通过父类引用，只能访问父类自己的成员！

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
