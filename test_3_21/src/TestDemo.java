import java.util.Arrays;
import java.util.Scanner;

/**
 * 组队竞速
 */
public class TestDemo {
    public static int game(int n) {
        int[] total = new int[3*n];
        for (int i = 0; i < 3*n-1; i++) {
            // 输入所有的值,存入数组中
            Scanner scanner = new Scanner(System.in);
            total[i] = scanner.nextInt();
        }
        Arrays.sort(total);
        int num = total.length / 3;// 分成num个组
        if (num % 2 == 1) {
            // 奇数
            return total[num] + total[num-1];
        }else {
            // 偶数
            return total[num] + total[num-1] + total[num+1];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        game(n);
    }
}
