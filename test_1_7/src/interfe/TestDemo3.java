package interfe;

//使用 interface 定义一个接口
interface IShape {
//    abstract public void draw();
    void draw();

    default public void func() {
        System.out.println("接口中的普通方法...");
    }

    public static void funcStatic() {
        System.out.println("接口中的静态方法...");
    }
}

class Rect implements IShape {
    @Override
    public void draw() {
        System.out.println("♦");
    }

    @Override
    public void func() {
        System.out.println("重写接口当中的默认方法");
    }
}

class Flower implements IShape {
    @Override
    public void draw() {
        System.out.println("❀");
    }
}

class Triangle implements IShape {
    @Override
    public void draw() {
        System.out.println("△");
    }
}

class Cycle implements IShape {
    @Override
    public void draw() {
        System.out.println("●");
    }
}

public class TestDemo3 {

    public static void drawMap(IShape iShape) {
        iShape.draw();//动态绑定（运行时），这里调用了重写的draw方法
    }

    public static void main(String[] args) {

        //IShape iShape = new IShape();//错误的，接口不能实例化！
        IShape iShape = new Rect();
        iShape.draw();

        ////它的类以及下面对象的类都是Shape类的子类，目的就是为了发生向上转型!
        Rect rect = new Rect();
        Flower flower = new Flower();
        drawMap(rect);
        drawMap(flower);
    }
}
