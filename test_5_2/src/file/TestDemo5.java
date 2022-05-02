package file;

import java.io.File;

/**
 * 创建目录
 */
public class TestDemo5 {
    public static void main(String[] args) {
        File f = new File("./aaa/bbb/ccc/ddd");
        // f.mkdir();// 只能创建一级目录
        f.mkdirs();// 可以创建多级目录
        System.out.println(f.isDirectory());
    }
}
