package file;

import java.io.File;
import java.io.IOException;

/**
 * 关于文件的路径以及获取文件名
 */
public class TestDemo {
    public static void main(String[] args) throws IOException {
        // 绝对路径的形式创建文件对象
        File f = new File("/Users/cbiltps/Documents/NativeCode/JavaCode/JavaCode/test_5_2/test");
        System.out.println(f.getParent()); // 获取到文件的父目录
        System.out.println(f.getName());    // 获取到文件名
        System.out.println(f.getPath());    // 获取到文件路径(构造 File 的时候指定的路径)
        System.out.println(f.getAbsolutePath()); // 获取到绝对路径
        System.out.println(f.getCanonicalPath()); // 获取到绝对路径（简化版 这里看不出来）

        System.out.println("=================");

        // 相对路径的形式穿件文件对象
        File f2 = new File("./test.txt");
        System.out.println(f2.getParent()); // 获取到文件的父目录
        System.out.println(f2.getName());    // 获取到文件名
        System.out.println(f2.getPath());    // 获取到文件路径(构造 File 的时候指定的路径)
        System.out.println(f2.getAbsolutePath()); // 获取到绝对路径
        System.out.println(f2.getCanonicalPath()); // 获取到绝对路径（简化版 这里可以看出来）
    }
}
