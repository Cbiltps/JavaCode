package file;

import java.io.*;
import java.util.Scanner;

/**
 * 复制文件
 */
public class TestDemo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要复制的源文件：");
        String src = scanner.next();
        System.out.println("请输入要复制的目标文件：");
        String dest = scanner.next();

        File srcFile = new File(src);
        if (!srcFile.isFile()) {
            System.out.println("输入的源文件路径有问题！");
            return;
        }

        // 2. 读取源文件, 拷贝到目标文件中
        // 此处不太需要检查目标文件是否存在. OutputStream 写文件的时候能够自动创建不存在的文件.
        try (InputStream inputStream = new FileInputStream(src)) {
            try (OutputStream outputStream = new FileOutputStream(dest)) {
                // 把 inputStream 中的数据读出来, 写入到 outputStream 中
                byte[] buffer = new byte[1024];
                while (true) {
                    int len = inputStream.read(buffer);
                    if (len == -1) {
                        break;
                    }
                    // 写入的时候, 不能把整个 buffer 都写进去. 毕竟 buffer 可能是只有一部分才是有效数据.
                    outputStream.write(buffer, 0, len);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
