import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Cbiltps
 * Date: 2023-02-20
 * Time: 19:57
 */
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

    public static void main(String[] args) {

    }
}
