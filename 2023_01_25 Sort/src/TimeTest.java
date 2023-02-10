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
//        TestSort.heapSort(array);
        TestSort.quickSort2(array);
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
//        TestSort.heapSort(array);

        /**
         * 数据为100_0000的时候, 直接进行测试, 会发生栈溢出问题!
         *
         * 难道计算机的栈空间很小吗? 数据仅仅100_0000条!
         *     其实不是的, 开辟栈空间其大小是不确定的, 一般是1M或者2M;
         *     IDEA开辟空间的时候是有一个默认的大小的, 并且可以设置!
         *
         * 得出原因: 数据是有序的, 并且只有左子树或者右子树, 深度非常深, 递归次数太多, 超多当前栈空间!
         *     而且看的不仅仅是数据的大小, 而是栈帧的大小, 包括函数的其他信息和参数等!
         *
         * 所以, 快速排序要进行下一步优化---使用三数取中法!
         */
        TestSort.quickSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    public static void main(String[] args) {
        test1(10_0000);
//        test2(10_0000);
    }
}
