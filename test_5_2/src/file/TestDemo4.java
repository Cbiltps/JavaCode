package file;

import java.io.File;

/**
 * 文件删除
 */
public class TestDemo4 {
    public static void main(String[] args) {
        File f = new File("./test.txt");
        f.delete();// 删除文件
    }
}
