import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-02-19
 * Time: 16:36
 */
public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("abc", 3);
        map.put("bit", 2);
        map.put("bit", 6);// 存储元素的时候 要注意 key如果相同 value值会被覆盖.
        map.put("hello", 4);
        map.put(null, null);// TreeMap中不能放置key为null, 可以value为null
        System.out.println(map);// 打印出来的循序和put的顺序是不一样的, 为什么? 回去看笔记!

        // Map.Entry<String, Integer>
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }

//        Set<String> set = map.keySet();// Set这个集合当中存储的元素都是不重复的
//        System.out.println(set);

//        int ret = map.get("bit");// 通过key, 获取对应的val值
//        System.out.println(ret);
//        System.out.println(map.getOrDefault("bit2", 0));// 如果获取不到可以设置默认值
//        Integer ret2 = map.remove("bit");
//        System.out.println(ret2);
//        System.out.println(map);
    }
}
