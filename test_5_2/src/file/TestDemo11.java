package file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 以字符流的形式写！
 */
public class TestDemo11 {
    public static void main(String[] args) {
        try (Writer writer = new FileWriter("/Users/cbiltps/Documents/NativeCode/JavaCode/JavaCode/test_5_2/test2.txt")) {
            writer.write("xyz");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*当然了，出来上面的写操作还有其他的 就是Scanner和Printwriter，后期的时候会讲的！*/
