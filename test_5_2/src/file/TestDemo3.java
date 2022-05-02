package file;

import java.io.File;
import java.io.IOException;

/**
 * 创建文件
 */
public class TestDemo3 {
    public static void main(String[] args) throws IOException {
        File f = new File("./test.txt");
        System.out.println(f.exists());// 判断文件是否存在
        System.out.println("创建文件");
        f.createNewFile();
        System.out.println("创建文件结束");
        System.out.println(f.exists());
    }
}
