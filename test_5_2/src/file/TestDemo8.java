package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节流进行读操作
 */
public class TestDemo8 {
    /*构造方法中需要指定打开文件的路径，
    * 此处的路径可以是绝对路径, 也可以是相对路径, 还可以是 File 对象！*/
    public static void main(String[] args) {

//        InputStream inputStream = null;// 把变量定义在外面，方便在finally里面访问
//        try {
//            // 1. 创建对象, 同时也是在打开文件.
//            inputStream = new FileInputStream("/Users/cbiltps/Documents/NativeCode/JavaCode/JavaCode/test_5_2/test.txt");
//            // 2. 尝试一个一个字节的读, 把整个文件都读完.
//            while (true) {
//                int a = inputStream.read();
//                if (a == -1) {
//                    break;// 当a = -1的时候代表文件读到末尾了
//                }
//                System.out.println(a);
//            }
//            // 3. 读完之后要记得关闭文件, 释放资源~
////            inputStream.close();// 这里的close最好是写在finally中
//        } catch (IOException e) { // 注意：这里面是有两个异常的FileNotFound和IO
//            e.printStackTrace();
//        } finally {
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }

        /**
         * 上面的代码需要把变量定义在括号外边，还需在finally里面在抛异常，非常的繁琐！
         * 下面的try会自动调用close，就是借助代码块的结束，自动回收资源！
         * 注意：上面和下面的代码仅仅代表的是一次读一个字节！
         */
//        try (InputStream inputStream = new FileInputStream("/Users/cbiltps/Documents/NativeCode/JavaCode/JavaCode/test_5_2/test.txt")) {
//            while (true) {
//                int a = inputStream.read();
//                if (a == -1) {
//                    break;
//                }
//                System.out.println(a);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /**
         * 一次读多个字节
         */
        try (InputStream inputStream = new FileInputStream("/Users/cbiltps/Documents/NativeCode/JavaCode/JavaCode/test_5_2/test.txt")) {
            while (true) {
                byte[] buffer = new byte[1024];
                int len = inputStream.read(buffer);// 把读到的结果放到指定数组中
                if (len == -1) { // 如果返回-1，说明读取完了
                    break;
                }
                // 循环遍历
                for (int i = 0; i < len; i++) {
                    System.out.println(buffer[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}