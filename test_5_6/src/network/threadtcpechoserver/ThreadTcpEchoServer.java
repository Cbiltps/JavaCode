package network.threadtcpechoserver;

import network.tcpechoserver.TcpEchoServer;

import java.io.IOException;
import java.net.Socket;

public class ThreadTcpEchoServer extends TcpEchoServer {

    public ThreadTcpEchoServer(int port) throws IOException {
        super(port);
    }

    @Override
    public void start() throws IOException {
        System.out.println("服务器启动！");
        while (true) {
            Socket clientSocket = listenSocket.accept();
            // 改进方法:在这个地方, 每次 accept 成功, 都创建一个新的线程, 由新线程负责执行这个 processConnection 方法~
            Thread t = new Thread(() -> {
                processConnection(clientSocket);
            });
            t.start();
        }
    }

    public static void main(String[] args) throws IOException {
        ThreadTcpEchoServer threadTcpEchoServer = new ThreadTcpEchoServer(9090);
        threadTcpEchoServer.start();
    }
}
