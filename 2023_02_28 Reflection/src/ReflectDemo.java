import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 关于反射, 面试的时候一般不会问, 就算问会问到:
 *     关于反射有哪几个重要的类?
 *     反射一般是在哪里用的?怎么用的?
 * User: cbiltps
 * Date: 2023-02-28
 * Time: 14:55
 */
public class ReflectDemo {
    /**
     * 通过Class类的newInstance方法, 获取学生实例
     */
    public static void reflectNewInstance() {
        try {
            // 1. 想要反射Student类, 首先获取Student类的class对象
            Class<?> c1 = Class.forName("Student");
            // 2. 创建实例
            Student student = (Student) c1.newInstance();
            System.out.println(student);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void reflectPrivateConstructor() {
        try {
            Class<?> c1 = Class.forName("Student");
            Constructor<?> constructor = c1.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true);
            Student student = (Student) constructor.newInstance("xiangzi", 18);
            System.out.println(student);
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

    /**
     * 反射属性 获取私有  或者公开的
     */
    public static void reflectPrivateField() {
        try {
            Class<?> c1 = Class.forName("Student");
            Student student = (Student)c1.newInstance();

            Field field = c1.getDeclaredField("name");
            field.setAccessible(true);
            field.set(student,"zhangsan");
            System.out.println(student);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void reflectPrivateMethod() {
        try {
            Class<?> c1 = Class.forName("Student");
            Student student = (Student)c1.newInstance();

            Method method = c1.getDeclaredMethod("printStr", String.class);
            method.setAccessible(true);
            method.invoke(student, "我是私有方法的参数!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        reflectNewInstance();
//        reflectPrivateConstructor();
//        reflectPrivateField();
        reflectPrivateMethod();
    }
}
