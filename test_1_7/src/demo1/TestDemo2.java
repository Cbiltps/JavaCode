package demo1;

/*abstract class Shape {
    //public int a;
    *//*public void func() {
        System.out.println("测试普通方法！");
    }*//*
    public abstract void draw();//抽象方法
}

abstract class A extends Shape{
    public abstract void funcA();
}
class B extends A {
    @Override
    public void funcA() {

    }

    @Override
    public void draw() {

    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("♦");
        //super.func();
    }
}
class Flower extends Shape {
    @Override
    public void draw() {
        System.out.println("❀");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("△");
    }
}
class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("●");
    }
}

public class Test {

    public static void drawMap(Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        Shape shape = new Rect();
        drawMap(shape);
        Cycle cycle = new Cycle();
        drawMap(cycle);
        //Shape shape2 = new Shape();
    }
}*/

abstract class Shape {
    abstract public void draw();
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("♦");
    }
}

class Flower extends Shape {
    @Override
    public void draw() {
        System.out.println("❀");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("△");
    }
}

class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("●");
    }
}

abstract class A extends Shape{
    public abstract void funcA();
}

class B extends A {
    @Override
    public void funcA() {

    }

    @Override
    public void draw() {

    }
}

public class TestDemo2 {

    public static void drawMap(Shape shape) {
        shape.draw();
    }


    public static void main(String[] args) {
//    Shape shape = new Shape(); 这里是无法实例化的
        Shape shape = new Rect();//这里仍然可以发生向上转型
        drawMap(shape);
    }


}
