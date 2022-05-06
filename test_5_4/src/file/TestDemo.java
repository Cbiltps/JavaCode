package file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 文件操作案例（1）：
 * 查找目录中的文件并删除
 */
public class TestDemo {
    public static void main(String[] args) {
        // 1. 输入文件的目录，以及需要删除的文件
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要扫描的路径：");
        String rootDirPath = scanner.next();
        System.out.println("请输入要删除的文件名：");
        String toDeleteFileName = scanner.next();

        // 判断是否是文件
        File rootDir = new File(rootDirPath);
        if (!rootDir.isDirectory()) {
            System.out.println("输入的扫描路径有问题！");
            return;
        }

        // 2. 遍历目录, 把指定目录中的所有文件和子目录都遍历一遍, 从而找到要删除的文件
        csanDir(rootDir, toDeleteFileName);
    }

    /**
     * 实现递归便利并删除
     */
    private static void csanDir(File rootDir, String toDeleteFileName) {
        // 1：列出rootDir中有哪些内容
        File[] files  = rootDir.listFiles();
        if (files == null) {
            return;// 空目录直接返回
        }

        // 2：便利列出的内容，如果是普通文件就判断是否是要删除的文件
        for (File n : files) {
            if (n.isFile()) {
                if (n.getName().contains(toDeleteFileName)) {
                    // 不需要文件名完全一样，只要包含了关键字就可以删除
                    deleteFile(n);
                }
            } else if(n.isDirectory()) { // 如果是目录就递归进行删除
                csanDir(n, toDeleteFileName);
            }
        }

    }

    private static void deleteFile(File n) {
        try {
            System.out.println(n.getCanonicalFile() + "确定要删除吗？（Y/N）");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            if (choice.equals("Y") || choice.equals("y")) {
                n.delete();
                System.out.println("文件删除成功！");
            } else {
                System.out.println("取消删除！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
