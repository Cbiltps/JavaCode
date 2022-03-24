import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * 这次的是第三天的题 第二天的我没注意过期了  都是笔试题所以早晚会遇见的
 */
public class TestDemo {
    public static String main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        char[] temp = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            temp[i] = str.charAt(i);
        }

        Queue<Character> queue = new LinkedList<>();
        for (int j = 0; j < temp.length; j++) {
            if (temp[j] > 48 && temp[j] < 57) {
                if (queue.peek() != temp[j]) {
                    queue.offer(temp[j]);
                }
            }
        }
        char[] str2 = new char[str.length()];
        for (int k = 0; k < str2.length; k++) {
            str2[k] = queue.poll();
        }
        return Arrays.toString(str2);
    }
}
