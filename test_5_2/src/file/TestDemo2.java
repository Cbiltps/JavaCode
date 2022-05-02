package file;

import java.io.File;

/**
 * 文件基础判断（是否是指定文件）
 */
public class TestDemo2 {
    public static void main(String[] args) {
         File f = new File("/Users/cbiltps/Documents/NativeCode/JavaCode/JavaCode/test_5_2/test");
//        File f = new File("./test.txt");
        System.out.println(f.exists());// 判断文件是否存在
        System.out.println(f.isDirectory());//  判断文件是否是目录
        System.out.println(f.isFile());// 判断是否是一个普通文件
    }
}
