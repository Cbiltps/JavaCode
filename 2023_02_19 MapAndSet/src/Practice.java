import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Cbiltps
 * Date: 2023-02-20
 * Time: 13:42
 */



public class Practice {

    /**
     * 给定10W个数据, 统计每个数据出现的次数
     * @param array
     * @return
     */
    //key是关键字 value是出现的次数
    public static Map<Integer, Integer> numOfData(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        //判断array中的元素, 是否在map当中, 如果不在放入的元素val就是1; 在就是在原来的基础上+1.49
        for (int x : array) {
            if (map.get(x) == null) {
                map.put(x, 1);
            } else {
                int val = map.get(x);
                map.put(x, val+1);
            }
        }
        return map;
    }

    /**
     * 将10W个数据中的数据去重
     * @param array
     * @return
     */
    public static Set<Integer> dataDeduplication(int[] array) {
        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < array.length-1; i++) {
//            set.add(array[i]);
//        }
        for (int x : array) {
            set.add(x);
        }
        return set;
    }

    public static int firstDuplicateData (int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int x : array) {
            if (set.contains(x)) {
                return  x;// 找到重复的元素直接返回
            }
            set.add(x);
        }
        return -1;// 没有重复的元素
    }

    /**
     * 给定10W个数据, 找出第一个重复的数据
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[1_0000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }

//        Map<Integer, Integer> map = numOfData(array);
//        System.out.println(map);
//
//        Set<Integer> set = dataDeduplication(array);
//        System.out.println(set);
//
        int result = firstDuplicateData(array);
        System.out.println(result);
    }
}