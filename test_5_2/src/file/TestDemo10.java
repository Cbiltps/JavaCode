package file;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 前面是以字节流的形式读写，下面看看以字符流读的方式！
 */
public class TestDemo10 {
    public static void main(String[] args) {
        try (Reader reader = new FileReader("/Users/cbiltps/Documents/NativeCode/JavaCode/JavaCode/test_5_2/test.txt")) {
            // 按照字符来读.
            while (true) {
                char[] buffer = new char[1024];
                int len = reader.read(buffer);
                if (len == -1) {
                    break;
                }

//                for (int i = 0; i < len; i++) {
//                    System.out.println(buffer[i]);
//                }

                // 如果这里传入的 数组 是 byte数组, 还可以手动的指定一下 utf8字符集 避免乱码.
                String s = new String(buffer, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
