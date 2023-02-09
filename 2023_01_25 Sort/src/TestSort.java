import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-01-25
 * Time: 17:38
 */
public class TestSort {
    /**
     * 直接插入排序:
     * 时间复杂度：O(N^2)-逆序的时候
     *      最好的情况是O(N): 对于直接插入排序来说，最好的情况就是数据有序的时候;
     *      根据这个结论，推导出另一个结论：对于直接插入排序来说，数据越有序，越快。
     *      所以: 直接插入排序可以用于排序的优化!
     * 空间复杂度：O(1)
     * 稳定性：稳定的
     *
     * 一个稳定的排序，可以实现为不稳定的排序
     * 但是一个本身就不稳定的排序，是不可以变成稳定的排序的
     *
     * 经常使用在  数据量不多  且 整体数据 趋于有序的时候!
     * @param array
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= 0 ; j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    //array[j+1] = tmp; 把这段代码写到下面更好
                    break;
                }
            }
            //j小于0的时候
            array[j+1] = tmp;
        }
    }

    /**
     * 希尔排序的核心步骤:按组数进行直接插入排序
     * @param array 待排序序列
     * @param gap 组数
     */
    public static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (array[j] > tmp) {
                    array[j+gap] = array[j];
                } else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    /**
     * 时间复杂度[和增量有关系的]：O(n^1.3 - n^1.5)
     * 空间复杂度：O(1)
     * 稳定性: 不稳定的
     * 如何简单判断是否稳定: 看在比较的过程当中, 是否发生了跳跃式的交换;
     *     如果发生了跳跃式的交换, 那么就是不稳定的排序!
     *     但是, 最好的方式依旧是 举几个例子, 按照代码 走几遍!
     * 面试的时候基本上没有考过~
     * @param array
     */
    public static void shellSort(int[] array) {
        int gap = array.length;
        // 很难计算增量, 简单控制增量即可(不一定为素数, 并且是增量)~
        while (gap > 1) {
            shell(array, gap);
            gap /= 2;
        }
        shell(array, 1);//保证最后是1组
    }

    /**
     * 按照分组情况测试希尔排序
     * @param array
     */
    public static void testShellSort(int[] array) {
        int[] drr = {5};
        for (int i = 0; i < drr.length; i++) {
            shell(array, drr[i]);
        }
    }

    /**
     * 用于交换的一个方法
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 选择排序
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定的排序
     * @param array 待排序序列
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    swap(array, i, j);
                }
            }
        }
    }

    /**
     * 选择排序的一个优化
     * @param array
     */
    public static void selectSort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int midIndex = i;// 假设当前坐标为最小的值
            for (int j = i+1; j < array.length; j++) {
                // 找到下标最小的值(比i还小的值)
                if (array[j] < array[midIndex]) {
                    midIndex = j;
                }
            }
            swap(array, i, midIndex);
        }
    }

    /**
     * 向下调整函数的实现
     * @param parent 每棵树的根节点
     * @param len 每棵树调整过的长度
     * @param array 待排序序列
     */
    public static void shiftDown(int[] array, int parent, int len) {
        int child = 2 * parent + 1;
        //1、最起码是有左孩子的, 至少有1个孩子
        while (child < len) {
            if(child+1 < len && array[child] < array[child+1]) {
                child++;//保证当前左右孩子最大值的下标
            }
            if (array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    /**
     * 注意:这个方法的时间复杂度为O(n), 具体的过程看下面的链接.
     * https://gitee.com/gaobo1/java-102/blob/master/102-%E6%9D%BF%E4%B9%A6/2022-01-22-%E4%BA%8C%E5%8F%89%E6%A0%91%E5%AE%8C+%E5%A0%86.png
     * @param array
     * @return
     */
    public static void createHeap(int[] array) {
        for (int parent = ((array.length-1)-1)/2; parent >= 0; parent--) {
            shiftDown(array, parent, array.length);
        }
    }

    /**
     * 时间复杂度：O(N + N * log N) ≈ O(N * log N)
     *     随着 O(N * log N) 的增大, O(N) 对整体的影响越来越小, 所以 O(N) 省略!
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * 注意:面试的时候 写堆排序 就是写 调整的过程(shiftDown)!
     * @param array
     */
    public static void heapSort(int array[]) {
        //1、建堆  O(N)
        createHeap(array);
        //2、交换然后调整 O(N * log N)
        int end = array.length - 1;
        while (end > 0) {
            swap(array, 0, end);
            shiftDown(array, 0, end);
            end--;
        }
    }

    /**
     * 冒泡排序
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定的排序
     * @param array
     */
    public static  void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if(array[j] > array[j+1]) {
                    swap(array, j+1, j);
                }
            }
        }
    }

    /**
     * 冒泡排序(优化后)
     * 时间复杂度：有序O(n) ~ 逆序O(N^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定的排序
     * @param array
     */
    public static void bubbleSort2(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            boolean flg = false;
            for (int j = 0; j < array.length - 1-i; j++) {
                if(array[j] > array[j+1]) {
                    swap(array, j+1, j);
                    flg = true;
                }
            }
            if(flg == false) {
                break;
            }
        }
    }

    /**
     * 时间复杂度：
     *     最好【每次可以均匀的分割待排序序列】：O(N*logn)
     *     最坏：数据有序 或者逆序的情况 O(N^2)
     * 空间复杂度：
     *     最好：O(logn)
     *     最坏：O(n) 只有左子树或者右子树
     * 稳定性：不稳定的排序
     * @param array
     */
    public static void quickSort(int[] array) {
        sort(array, 0, array.length-1);
    }

    public static void insertSort2(int[] array, int start, int end) {
        for (int i = 1; i <= end; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= start ; j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    //array[j+1] = tmp;  只要j回退的时候，遇到了 比tmp小的元素就结束这次的比较
                    break;
                }
            }
            //j回退到了 小于0 的地方
            array[j+1] = tmp;
        }
    }

    public static void sort(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        //0、如果区间内的数据，在排序的过程当中，小于某个范围了，可以使用直接插入排序  0  1  2 3
//        if(right - left+1 <= 1400) {
//            //使用直接插入排序
//            insertSort2(array, left, right);
//            return;
//        }

        //1、找基准之前，我们找到中间大小的值-使用三数取中法
//        int midValIndex = findMidValIndex(array, left, right);
//        swap(array, midValIndex, left);

        int pivot = partition(array, left, right);// 基准
        sort(array, left, pivot-1);
        sort(array, pivot+1, right);
    }

    private static int findMidValIndex(int[] array,int start,int end) {
        int mid = start + ((end - start) >>> 1);
        if(array[start] < array[end]) {
            if(array[mid] < array[start]) {
                return start;
            }else if(array[mid] > array[end]) {
                return end;
            }else {
                return mid;
            }
        }else {
            if(array[mid] > array[start]) {
                return start;
            }else if(array[mid] < array[end]) {
                return end;
            }else {
                return mid;
            }
        }
    }

    /**
     * 寻找基准值(挖坑法)
     *     当然还有 Hoare法 和 前后遍历法 , 了解即可.
     * 注意: 以后面试的时候, 80%的情况之下都是写 挖坑法 !
     *     挖坑法 和 Hoare法 找到的基准值前面的数据的顺序有一些不同!
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private static int partition(int[] array,int start,int end) {
        int tmp = array[start];// 假设基准值是它
        while (start < end) {
            while (start < end && array[end] >= tmp) { // 没有等于就会陷入死循环
                end--;
            }
            //end下标就遇到了 < tmp的值
            array[start] = array[end];
            while (start < end && array[start] <= tmp) { // 没有等于同样也会陷入死循环
                start++;
            }
            //start下标就遇到了 > tmp的值
            array[end] = array[start];
        }
        array[start] = tmp;
        return start;
    }

    public static void main(String[] args) {
        //int[] array = {12, 5, 18, 10, 4, 2};
        int[] array = {12, 5, 9, 34, 6, 8, 33, 56, 89, 0, 7, 4, 22, 55, 77};
//        shellSort(array);
//        selectSort2(array);
//        heapSort(array);
//        bubbleSort2(array);
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}