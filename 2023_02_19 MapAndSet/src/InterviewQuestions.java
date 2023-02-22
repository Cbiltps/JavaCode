import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Cbiltps
 * Date: 2023-02-20
 * Time: 19:57
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = null;
    }
}

public class InterviewQuestions {
    /**
     * 136. 只出现一次的数字
     * https://leetcode.cn/problems/single-number/
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x)) {
                set.remove(x);// 找到重复的元素直接删除
                continue;
            }
            set.add(x);
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 138. 复制带随机指针的链表(百度面试/剑指offer)
     * https://leetcode.cn/problems/copy-list-with-random-pointer/
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        // 第一次遍历，储存老结点和新结点的映射关系
        while (cur != null) {
            Node newNode = new Node(cur.val);
            map.put(cur, newNode);
            cur = cur.next;
        }

        cur = head;
        // 第二次遍历，修改新结点的next和random
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }


    /**
     * 138. 复制带随机指针的链表(非Map方法)
     * 博哥写的, 有时间的时候看一下
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        if(head == null){
            return head;
        }
        // 空间复杂度O(1)，将克隆结点放在原结点后面
        Node node = head;
        // 1->2->3  ==>  1->1'->2->2'->3->3'
        while(node != null){
            Node clone = new Node(node.val, node.next, null);
            Node temp = node.next;
            node.next = clone;
            node = temp;
        }
        // 处理random指针
        node = head;
        while(node != null){
            // ！！
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        // 还原原始链表，即分离原链表和克隆链表
        node = head;
        Node cloneHead = head.next;
        while(node.next != null){
            Node temp = node.next;
            node.next = node.next.next;
            node = temp;
        }
        return cloneHead;
    }

    /**
     * 771. 宝石与石头
     * https://leetcode.cn/problems/jewels-and-stones/
     * @param jewels
     * @param stones
     */
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        // 把字符放入set中
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }

        int count = 0;
        // 查看stones中的字符是否存在于jewels, 存在既count++
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                count++;
            }
        }

        return count;
    }

    public int numJewelsInStones2(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        for (Character character : jewels.toCharArray()) {
            set.add(character);
        }

        int count = 0;
        for (Character character : stones.toCharArray()) {
            if(set.contains(character)) {
                count++;
            }
        }

        return count;
    }

    /**
     * 坏键盘打字
     * https://www.nowcoder.com/questionTerminal/f88dafac00c8431fa363cd85a37c2d5e
     * @param expected
     * @param actual
     */
    public static void searchBadKeyboard(String expected, String actual) {
        HashSet<Character> actualSet = new HashSet<>();
        for (char ch : actual.toUpperCase().toCharArray()) {
            actualSet.add(ch);
        }

        HashSet<Character> badKeyboardSet = new HashSet<>();
        for (char ch : expected.toUpperCase().toCharArray()) {
            if (!actualSet.contains(ch) && !badKeyboardSet.contains(ch)) {
                System.out.print(ch);
                badKeyboardSet.add(ch);
            }
        }
    }

    /**
     * 692. 前K个高频单词(这道题非常的重量级, 非常绕, 复习的时候多看看, 笔记在搜索二叉树的前面[Map和Set的面试题])
     * https://leetcode.cn/problems/top-k-frequent-words/description/
     *
     * 特别注意题目中的两个条件:
     * A:返回的答案应该按单词出现频率由高到低排序。
     * B:如果不同的单词有相同出现频率，按字典顺序排序。
     * 要满足两个条件是不容易的, 他们是互相矛盾的,
     * 满足A, B不满足, 反之也是.
     * 所以要按代码中的方式巧妙解决, 恶心至极!
     *
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        // 1、用map统计每个单词出现的次数
        for (String s : words) {
            if(map.get(s) == null) {
                map.put(s, 1);
            }else {
                int val = map.get(s);
                map.put(s, val+1);
            }
        }

        // 2、建立一个大小为K的小根堆
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().compareTo(o2.getValue()) == 0) { // 出现次数相同的时候
                    return o2.getKey().compareTo(o1.getKey());// 对于单词(字典)来说又是大根堆
                }
                return o1.getValue() - o2.getValue();
            }
        });

        // 3、遍历Map, 将Map中的Map.Entry<String, Integer>按规则放入PriorityQueue<Map.Entry<String,Integer>>
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            // 这里提醒一下, 前k次放置的时候, 也要注意放置的顺序
            // 所以, Override的compare方法要加下面的if语句!
            /*
                if(o1.getValue().compareTo(o2.getValue()) == 0) {
                    return o2.getKey().compareTo(o1.getKey());
                }
             */
            if(minHeap.size() < k) {
                minHeap.offer(entry);
            }else {
                // 说明堆中, 已经放满了K个元素, 需要看 堆顶元素 的数据和 当前的数据 的大小关系
                Map.Entry<String, Integer> top = minHeap.peek();
                // 判断频率是否相同, 如果相同, 比较单词(字典)的大小, 单词小的入堆
                if(top.getValue().compareTo(entry.getValue()) == 0) { // 判断频率是否相同, 等于0既相同
                    if(top.getKey().compareTo(entry.getKey()) > 0) { // 比较单词(字典)的大小, 单词小的入堆
                        minHeap.poll();
                        minHeap.offer(entry);
                    }
                } else {
                    if(top.getValue().compareTo(entry.getValue()) < 0) {
                        minHeap.poll();
                        minHeap.offer(entry);
                    }
                }
            }
        }

        // System.out.println(minHeap);
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> top = minHeap.poll();
            ret.add(top.getKey());
        }
        Collections.reverse(ret);// 逆置
        return ret;
    }

    /**
     * 坏键盘打字的main函数
     * @param args
     */
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String expected = scanner.nextLine();
            String actual = scanner.nextLine();
            searchBadKeyboard(expected, actual);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //String[] worlds = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        String[] worlds = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> ret = topKFrequent(worlds,3);
        System.out.println(ret);
    }
}
