package file;

import java.io.File;

/**
 * 文件改名
 */
public class TestDemo7 {
    public static void main(String[] args) {
        File f = new File("./aaa");
        File f2 = new File("./zzz");
        f.renameTo(f2);// 把aaa的文件名改为zzz
    }
}
