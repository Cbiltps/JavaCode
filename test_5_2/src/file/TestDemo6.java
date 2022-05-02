package file;

import java.io.File;
import java.util.Arrays;

/**
 * 目录下的文件名
 */
public class TestDemo6 {
    public static void main(String[] args) {
        File f = new File("./");
//        System.out.println(Arrays.toString(f.list()));// 展示目录下的所有文件名
        System.out.println(Arrays.toString(f.listFiles())); // 展示当前目下的文件名（显示当前目录）
    }
}
