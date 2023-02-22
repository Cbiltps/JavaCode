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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String expected = scanner.nextLine();
            String actual = scanner.nextLine();
            searchBadKeyboard(expected, actual);
            System.out.println();
        }
    }
}
