import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description: 测试排序的时间
 * 注意: 时间复杂度 != 代码的运行时间
 * 其实, 不是看你运行的时间来说明的, 时间只是一个衡量的某个标准!
 *
 * User: cbiltps
 * Date: 2023-02-03
 * Time: 07:00
 */
public class TimeTest {
    /**
     * 有序的数据
     * @param capacity
     */
    public static void test1(int capacity) {
        int[] array = new int[capacity];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        long start = System.currentTimeMillis();
//        TestSort.insertSort(array);
//        TestSort.shellSort(array);
//        TestSort.selectSort(array);
        TestSort.heapSort(array);
//        TestSort.quickSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 无序的数据
     * @param capacity
     */
    public static void test2(int capacity) {
        int[] array = new int[capacity];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(capacity);
        }
        long start = System.currentTimeMillis();
//        TestSort.insertSort(array);
//        TestSort.shellSort(array);
//        TestSort.selectSort(array);
        TestSort.heapSort(array);
//        TestSort.quickSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) {
        test1(10_0000);
        test2(10_0000);
    }
}
