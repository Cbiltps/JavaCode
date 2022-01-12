package usually;

import java.util.Arrays;
import java.util.Comparator;

/*//这里直接实现一个Comparable接口
class Student implements Comparable<Student> {
    public int age;
    public String name;
    public double score;

    @Override
    public int compareTo(Student o) { //谁调用这个方法 谁就是this
        *//*if(this.age > o.age) {
            return 1;
        }else if(this.age == o.age) {
            return 0;
        }else {
            return -1;
        }*//*

        //更简单的实现（从小到大）
        return this.age - o.age;
    }

    public Student(int age, String name, double score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}*/

class Student {
    public int age;
    public String name;
    public double score;

    public Student(int age, String name, double score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

//这里有一个快捷键 alt+7 就是看里面有啥方法！

class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}

class Score implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return (int)(o1.score - o2.score);//强制转化成int类型
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

public class TestDemo7 {

    //了解compareTo是如何用的！
   /* public static void main(String[] args) {
        Student student1 = new Student(98,"huahua",56);
        Student student2 = new Student(45,"wewe",34);

        //了解compareTo是如何用的！
//        System.out.println(student1.compareTo(student2));//这里是一个大于零的数字

        //了解compare是如何用的！
        AgeComparator ageComparator = new AgeComparator();
        System.out.println(ageComparator.compare(student1,student2));//这里是一个大于零的数字
    }*/

    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student(12,"huahua",56);
        students[1] = new Student(45,"wewe",34);
        students[2] = new Student(32,"rous",78);

        System.out.println(Arrays.toString(students));//排序前打印
        AgeComparator ageComparator = new AgeComparator();
        Score score = new Score();
        NameComparator nameComparator = new NameComparator();
        //这里可以使用不同的比较器！
        Arrays.sort(students,nameComparator);//这里ageComparator（传的就是一个比较器），建议看源码！
        System.out.println(Arrays.toString(students));//排序后打印
    }
}
