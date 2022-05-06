package file;

import java.io.*;
import java.util.Scanner;

/**
 * 扫描指定目录，并找到名称或者内容中包含指定字符的所有普通文件（不包含目录）
 */
public class TestDemo3 {
    public static void main(String[] args) throws IOException {
        // 1. 输入要扫描的文件路径
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入扫描的路径：");
        String rootDirPath = scanner.next();
        System.out.println("请输入要查询的关键词：");
        String keyWord = scanner.next();

        File rootDir = new File(rootDirPath);
        if (!rootDir.isDirectory()) {
            System.out.println("输入的文件路径有问题！");
            return;
        }
        // 2. 进行递归便利并查找
        scanDir(rootDir, keyWord);
    }

    private static void scanDir(File rootDir, String keyWord) throws IOException {
        // 1. 列出rootDir中的元素
        File[] files = rootDir.listFiles();
        if (files == null) {
            return;
        }

        // 2. 遍历列出的元素，正对文件和目录分别进行处理
        for (File n : files) {
            if (n.isFile()) {
                if (containsWord(n, keyWord)) { // 正对文件内容进行查找
                    System.out.println(n.getCanonicalPath());
                }
            } else if (n.isDirectory()) {
                scanDir(n, keyWord);// 针对目录进行递归
            }
        }
    }

    private static boolean containsWord(File n, String keyWord) {
        // 把 n 中的内容读出来放到一个 stringBuilder 中
        StringBuilder stringBuilder = new StringBuilder();// 注意：写代码的时候不要缩写

        try (Reader reader = new FileReader(n)) {
            char[] buffer = new char[1024];
            while (true) {
                int len = reader.read(buffer);
                if (len == -1) {
                    break;
                }
                // 把读到的结果放到stringBuilder中
                stringBuilder.append(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // indexOf 返回的是子串的下标. 如果 word 在 stringBuilder 中不存在, 则返回下标为 -1
        return stringBuilder.indexOf(keyWord) != -1;
    }
}
