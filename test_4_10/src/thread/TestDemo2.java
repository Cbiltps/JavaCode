package thread;

// 实现单例模式 - 懒汉模式
class Singleton2 {
    // 1. 就不是立即就初始化实例.
    private static volatile Singleton2 instance = null;// 注意：这里的volatile讲到后面加上的这样就解决了很多问题，看笔记！œ
    // 2. 把构造方法设为 private
    private Singleton2() {} // 括号里啥都不写！
    // 3. 提供一个方法来获取到上述单例的实例
    //    只有当真正需要用到这个 实例 的时候, 才会真正去创建这个实例.
    public static Singleton2 getInstance() {
        /**
         * 注意：在这里的 双重if条件 以及 加锁 的操作里面有很深的文章，建议去看当时上课的笔记！
         * 上课的时间是：0327（使用检索软件检索）～
         * 添加文档注释的目的是醒目（绿色的）！
         */
        // 如果这个条件成立, 说明当前的单例未初始化过的, 存在线程安全风险, 就需要加锁~~
        if (instance == null) {
            synchronized (Singleton2.class) { // 括号中为啥是XXXX.class也是有原因的，建议看笔记！
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        Singleton2 instance = Singleton2.getInstance();
    }
}
