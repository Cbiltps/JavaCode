/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-02-28
 * Time: 16:31
 */
public enum EnumTest {

    RED("red", 1), BLACK("black", 3), GREEN("green", 8), WHITE("white",2);

    public String color;
    public int ordinal;

    // 此时的构造方法默认是私有的, 所以说在类外是拿不到对象的
    EnumTest(String color, int ordinal) {
        this.color = color;
        this.ordinal = ordinal;
    }

    /**
     * 无参构造方法
     * @param args
     */
//    EnumTest() {
//    }

    public static void main(String[] args) {
        //把字符串变成对应的枚举对象
        EnumTest enumTest = EnumTest.valueOf("RED");
        System.out.println(enumTest);

        System.out.println(RED.compareTo(GREEN));// 默认索引比较的
        System.out.println(BLACK.compareTo(RED));
    }

    public static void main3(String[] args) {
        EnumTest[] enumTest = EnumTest.values();
        for (int i = 0; i < enumTest.length; i++) {
            System.out.println(enumTest[i] + " -> " + enumTest[i].ordinal());
        }
    }

    /**
     * 枚举可以用于switch语句
     * @param args
     */
    public static void main2(String[] args) {
        EnumTest enumTest = EnumTest.BLACK;
        switch (enumTest) {
            case RED:
                System.out.println("RED");
                break;
            case BLACK:
                System.out.println("BLACK");
                break;
            case WHITE:
                System.out.println("WHITE");
                break;
            case GREEN:
                System.out.println("GREEN");
                break;
            default:
                break;
        }
    }

    public static void main1(String[] args) {
        System.out.println(RED);
    }
}
