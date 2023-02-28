/**
 * Created with IntelliJ IDEA.
 * Description: 如何获取class对象(三种方式)
 * User: cbiltps
 * Date: 2023-02-28
 * Time: 14:26
 */
class Student {
    // 私有属性name
    private String name = "bit";
    // 公有属性age
    public int age = 18;
    // 不带参数的构造方法
    public Student(){
        System.out.println("Student()");
    }

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Student(String,name)");
    }

    private void eat(){
        System.out.println("i am eat");
    }

    public void sleep(){
        System.out.println("i want sleep");
    }

    private void printStr(String str) {
        System.out.println(str);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class TestDemo {
    public static void main(String[] args) throws ClassNotFoundException {
//        Student student = new Student(123, 10);// error, 带参数的构造方法是私有的
        Class<?> c1 = Class.forName("Student");

        Class<?> c2 = Student.class;

        Student student = new Student();
        Class<?> c3 = student.getClass();

        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
        System.out.println(c2 == c3);
        /*
        结果都是true, 说明不管使用那种获取方式, class对象只有一个!
         */
    }
}
