package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 字节流进行写操作
 */
public class TestDemo9 {
    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("/Users/cbiltps/Documents/NativeCode/JavaCode/JavaCode/test_5_2/test2.txt")) {
//            outputStream.write(97);
//            outputStream.write(98);
//            outputStream.write(99);

            byte[] buffer = {97, 98, 99, 100};
            outputStream.write(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
