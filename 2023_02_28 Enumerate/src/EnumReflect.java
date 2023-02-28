import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * Description: 既然枚举的构造方法是私有的, 那么是否可以通过反射来获取到枚举对象的实例呢？
 * User: cbiltps
 * Date: 2023-02-28
 * Time: 18:45
 */
public class EnumReflect {
    public static void reflectPrivateConstructor() {
        try {
            Class<?> classEnum = Class.forName("EnumTest");
            /*
            虽然子类构造方法写的是两个参数, 但是默认它还添加了两个参数, 我们看一下Enum类的源码!
            也就是说, 我们自己的构造函数有两个参数(String和int), 同时默认后边还会给两个参数(String和int).
            也就是说, 这里我们应该有四个参数!
             */
            Constructor<?> constructor = classEnum.getDeclaredConstructor(String.class, int.class, String.class, int.class);
            constructor.setAccessible(true);
            EnumTest testEnum = (EnumTest)constructor.newInstance("green", 66, "BROWN", 66);
            System.out.println("获得枚举的私有构造函数：" + testEnum);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        reflectPrivateConstructor();
        /*
        Cannot reflectively create enum objects
        运行完之后, 抛异常如上述!
        可见枚举非常安全!
        连反射都拿不到对应的实例!
         */

        /*
        报异常的源代码:
        if ((clazz.getModifiers() & Modifier.ENUM) != 0)
            throw new IllegalArgumentException("Cannot reflectively create enum objects");
        ConstructorAccessor ca = constructorAccessor;   // read volatile
         */



        /**
         * 看了源代码, 所以就有了一个面试题:
         *     如何实现一个线程安全的单例模式(只能获取一个实例)?
         */

        /*// 实现单例模式 - 懒汉模式
        class Singleton2 {
            // 1. 就不是立即就初始化实例.
            private static volatile Singleton2 instance = null;// 注意：这里的volatile讲到后面加上的这样就解决了很多问题，看笔记！
            // 2. 把构造方法设为 private
            private Singleton2() {} // 括号里啥都不写！
            // 3. 提供一个方法来获取到上述单例的实例
            //    只有当真正需要用到这个 实例 的时候, 才会真正去创建这个实例.
            public static Singleton2 getInstance() {
                *//**
                 * 注意：在这里的 双重if条件 以及 加锁 的操作里面有很深的文章，建议去看当时上课的笔记！
                 * 上课的时间是：0327（使用检索软件检索）～
                 * 添加文档注释的目的是醒目（绿色的）！
                 *//*
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
        }*/



        /**
         * 在上述的单例模式中, 其实是可以用反射再次获取多个对象的, 线程就不安全了!
         * 但是, 如果使用枚举进行单例模式, 最后连反射都无法实例化对象!
         * 既实现单例, 故线程安全!
         * 代码如下段!
         */

        /*public enum TestEnum {
            INSTANCE;
            public TestEnum getInstance(){
                return INSTANCE;
            }
            public static void main(String[] args) {
                TestEnum singleton1 = TestEnum.INSTANCE;
                TestEnum singleton2 = TestEnum.INSTANCE;
                System.out.println("两个实例是否相同：" + (singleton1 == singleton2));
            }
        }*/
    }
}
