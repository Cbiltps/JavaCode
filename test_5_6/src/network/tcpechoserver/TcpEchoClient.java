package network.tcpechoserver;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    // 用普通的 socket 即可, 不用 ServerSocket 了
    // 此处也不用手动给客户端指定端口号, 让系统自由分配.
    private Socket socket = null;

    public TcpEchoClient(String serverIP, int serverPort) throws IOException {
        // 其实这里是可以给的. 但是这里给了之后, 含义是不同的. ~~
        // 这里传入的 ip 和 端口号 的含义表示的不是自己绑定, 而是表示和这个 ip 端口建立连接!!
        // 调用这个构造方法, 就会和服务器建立连接 (打电话拨号了)
        socket = new Socket(serverIP, serverPort);
    }

    public void start() {
        System.out.println("和服务器连接成功！");
        Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream()) {
            try (OutputStream outputStream = socket.getOutputStream()) {
                while (true) {
                    // 要做的事情, 仍然是四个步骤
                    // 1. 从控制台读取字符串
                    System.out.print("====>");
                    String request = scanner.next();
                    // 2. 根据读取的字符串, 构造请求, 把请求发给服务器
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(request);
                    printWriter.flush();// 如果不刷新, 可能服务器无法及时看到数据.
                    // 3. 从服务器读取响应, 并解析
                    Scanner responseScanner = new Scanner(inputStream);
                    String response = responseScanner.next();
                    // 4. 把结果显示到控制台上.
                    System.out.printf("request:%s response:%s\n", request, response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1", 9090);
        tcpEchoClient.start();
    }
}
