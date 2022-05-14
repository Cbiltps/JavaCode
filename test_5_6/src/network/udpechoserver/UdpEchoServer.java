package network.udpechoserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 写一个最简单的客户端服务器程序，回显服务~ EchoServer
 *
 * 站在服务器的角度:
 * 1. 源 IP: 服务器程序本机的 IP
 * 2. 源端口: 服务器绑定的端口 (此处手动指定了 9090)
 * 3. 目的 IP: 包含在收到的数据报中. (客户端的IP)
 * 4. 目的端口: 包含在收到的数据报中. (客户端的端口)
 * 5. 协议类型: UDP
 */
public class UdpEchoServer {
    // 进行网络编程, 第一步就需要先准备好 socket 实例~ 这是进行网络编程的大前提.
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    // 启动服务器
    public void start() throws IOException {
        System.out.println("启动服务器！");
        // UDP不需要建立链接，直接接收从客服端发来的数据即可
        while (true) {
            // 1. 读取客户端发来的请求
            DatagramPacket requestSocket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(requestSocket);// 为了接受数据, 需要先准备好一个空的 DatagramPacket 对象, 由 receive 来进行填充数据

            // 把 DatagramPacket 解析成一个 String
            String request = new String(requestSocket.getData(), 0, requestSocket.getLength(), "UTF-8");

            // 2. 根据请求计算响应（由于这是一个回显服务，2省略)
            String response = process(request);

            // 3. 把响应写回客户端
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                    requestSocket.getSocketAddress());
            socket.send(responsePacket);
            System.out.printf("address:%s port:%d request:%s response:%s\n", requestSocket.getAddress().toString(),
                    requestSocket.getPort(), request, response);

        }
    }

    /**
     * 由于是回显服务, 响应就和请求一样了.
     * 实际上对于一个真实的服务器来说, 这个过程是最复杂的. 为了实现这个过程, 可能需要几万行, 几十万行代码....
     * @param request
     * @return
     */
    public String process(String request) {
        return  request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer udpEchoServer = new UdpEchoServer(9090);
        udpEchoServer.start();
    }
}