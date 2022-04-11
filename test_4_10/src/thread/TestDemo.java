package thread;

// 通过 Singleton 这个类来实现单例模式. 保证 Singleton 这个类只有唯一实例

// 饿汉模式
class Singleton {
    // 1. 使用 static 创建一个实例, 并且立即进行实例化.
    //    这个 instance 对应的实例, 就是该类的唯一实例.
    private static Singleton instance = new Singleton();
    // 2. 为了防止程序猿在其他地方不小心的 new 这个 Singleton, 就可以把构造方法设为 private
    private Singleton() {}
    // 3. 提供一个方法, 让外面能够拿到唯一实例.
    public static Singleton getInstance() {
        return instance;
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();

        // 此时这里的new操作会报错，编译不了！
        // Singleton instance2 = new Singleton();
    }
}
