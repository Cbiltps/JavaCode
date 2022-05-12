package network.echoserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * 写代码的时候，就会涉及到一系列的 ip 和端口~~
 *  其中有一个重要的概念："五元组"
 *  就是一次通信，是由 五个 核心信息，描述出来的~~
 *
 *  站在客户端的角度:
 *  源 IP: 本机 IP
 *  源端口: 系统分配的端口
 *  目的 IP: 服务器的 IP
 *  目的端口: 服务器的端口
 *  协议类型: UDP
 */
public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIP;
    private int serverPort;

    public UdpEchoClient(String ip, int port) throws SocketException {
        /*
        * 此处的 port 是服务器的端口.
        * 客户端启动的时候, 不需要给 socket 指定端口.
        * 客户端自己的端口是系统随机分配的~~
        */
        socket = new DatagramSocket();// 不指定端口号，系统自动分配一个空闲的端口号
        serverIP = ip;
        serverPort = port;
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 1. 先从控制台读取用户输入的字符串
            System.out.println("启动客户端 -> ");
            String request = scanner.next();
            // 2. 把这个用户输入的内容, 构造成一个 UDP 请求, 并发送.
            //    构造的请求里包含两部分信息:
            //    1) 数据的内容. request 字符串
            //    2) 数据要发给谁~ 服务器的 IP + 端口
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName(serverIP), serverPort);
            socket.send(requestPacket);

            // 3. 从服务器读取响应数据, 并解析
            DatagramPacket responsePacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength(), "UTF-8");
            // 4. 把响应结果显示到控制台上.
            System.out.printf("request: %s  response: %s\n", request, response);
        }
    }

    public static void main(String[] args) throws IOException {
        // 由于服务器和客户端在同一个机器上, 使用的 IP 仍然是 127.0.0.1 . 如果是在不同的机器上, 当然就需要更改这里的 IP 了
        UdpEchoClient udpEchoClient = new UdpEchoClient("127.0.0.1", 9090);
        udpEchoClient.start();
    }
}