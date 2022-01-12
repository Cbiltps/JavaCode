package interfe;

//接口与接口之间的关系

interface IA1 {
    void funcA();
}

//接口和接口之间可以使用extends来操作他们的关系，此时，这里面意为:拓展。
interface IB1 extends IA1 {
    void funcB();
}

class C implements IB1 {

    @Override
    public void funcB() {
        System.out.println("光重写B还不够！");
    }

    @Override
    public void funcA() {
        System.out.println("还要重写A！");
    }
}

public class TestDemo5 {
}
