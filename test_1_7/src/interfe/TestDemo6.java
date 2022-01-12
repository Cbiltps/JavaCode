package interfe;

class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }
}
//不是所有的动物都会飞，所以不能写到Animal类当中。
//如果写到另一个类当中，也不行，因为一个类不能继承多个类，所以，采用接口！
interface IFlying {
    void fly();
}

interface IRunning {
    void run();
}

interface ISwimming {
    void swimming();
}

class Bird extends Animal implements IFlying{
    public Bird(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(this.name+" 正在飞！");
    }
}
class Frog extends Animal implements IRunning,ISwimming{
    public Frog(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name+" 正在跑！");
    }

    @Override
    public void swimming() {
        System.out.println(this.name+" 正在游泳！");
    }
}
class Duck extends Animal implements IRunning,ISwimming,IFlying{

    public Duck(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(this.name+" 正在飞！");
    }

    @Override
    public void run() {
        System.out.println(this.name+" 正在跑！");
    }

    @Override
    public void swimming() {
        System.out.println(this.name+" 正在游泳！");
    }
}

class Roobot implements IRunning{

    @Override
    public void run() {
        System.out.println("机器人在跑！");
    }
}

public class TestDemo6 {

    public static void runFunc(IRunning iRunning) {
        iRunning.run();
    }

    public static void swimmingFunc(ISwimming iSwimming) {
        iSwimming.swimming();
    }

    public static void flyingFunc(IFlying iFlying) {
        iFlying.fly();
    }

    public static void main(String[] args) {
        runFunc(new Duck("鸭子"));
        runFunc(new Frog("青蛙"));
        runFunc(new Roobot());

//        flyingFunc(new Duck("鸭子"));
//        flyingFunc(new Bird("小鸟"));

//        swimmingFunc(new Duck("鸭子"));
//        swimmingFunc(new Frog("青蛙"));

//        runFunc(new Duck("鸭子"));
//        runFunc(new Frog("青蛙"));
    }
}
