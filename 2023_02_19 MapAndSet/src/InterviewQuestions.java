import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Cbiltps
 * Date: 2023-02-20
 * Time: 19:57
 */

/**
 * 138. 复制带随机指针的链表
 * 用于此题结点的构造
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
        // 第一次遍历，修改新结点的next和random
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 138. 复制带随机指针的链表
     * https://leetcode.cn/problems/copy-list-with-random-pointer/
     * @param args
     */
    public static void main(String[] args) {

    }
}
