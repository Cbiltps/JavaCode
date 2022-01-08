package polymorphic;

class Shape {
    public void draw() {
        System.out.println("打印图形中...");
    }
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

class Triangle extends Shape{
    @Override
    public void draw() {
        System.out.println("△");
    }
}


public class TestDemo1 {

    public static void main4(String[] args) {
        Rect rect = new Rect();
        Flower flower = new Flower();
        Triangle triangle = new Triangle();

        Shape[] shapes = {triangle,rect,triangle,rect,flower,};
        for (Shape shape : shapes) {
            shape.draw();
        }
    }


    public static void main3(String[] args) {
        Rect rect = new Rect();
        Flower flower = new Flower();
        Triangle triangle = new Triangle();

        String[] shapes = {"triangle", "rect", "triangle", "rect", "flower"};
        for (String s : shapes) {
            if(s.equals("triangle")) {
                triangle.draw();
            }else if(s.equals("rect")) {
                rect.draw();
            }else {
                flower.draw();
            }
        }
    }

    public static void drawMap(Shape shape) {
        shape.draw();//动态绑定（运行时），这里调用了重写的draw方法
    }

    public static void main(String[] args) {
        //它的类以及下面对象的类都是Shape类的子类，目的就是为了发生向上转型!
        Rect rect = new Rect();
        drawMap(rect);
        Flower flower = new Flower();
        drawMap(flower);
    }

    public static void main1(String[] args) {
//        Rect rect = new Rect();
//        rect.draw();//这里没有发生向上转型，也没有发生动态绑定！

        Shape shape1 = new Rect();
        shape1.draw();//向上转型
    }
}
