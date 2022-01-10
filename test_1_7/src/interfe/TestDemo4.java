package interfe;

interface IA {
    //接口中的成员变量，默认是 public static final 的！
    //public static final int a = 10;//可以写成下面的样子！
    int A = 10;//相当于是常量

    void funcA();//方法就这样写，默认是 pubilc abstract 的！
}

interface IB {
    void funcB();
}

class A implements IA,IB { //一个类可以实现多接口！
    @Override
    public void funcA() { //当一个类实现一个接口并在重写方法的时候，方法必须是 pubilc 的！
        System.out.println("Override funcA");
        System.out.println(A);//当然也可以访问接口中的东西！
    }

    @Override
    public void funcB() {
        System.out.println("Override funcB");
    }
}

public class TestDemo4 {
}
