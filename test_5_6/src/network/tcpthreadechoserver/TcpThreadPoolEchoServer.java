package network.tcpthreadechoserver;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpThreadPoolEchoServer extends TcpThreadEchoServer{
    public TcpThreadPoolEchoServer(int port) throws IOException {
        super(port);
    }

    @Override
    public void start() throws IOException {
        System.out.println("服务器启动！");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Socket clientSocket = listenSocket.accept();
            //  通过线程池来实现 这里背后的实现有一定的差别（和之前的方式相比）
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            });
        }
    }

    public static void main(String[] args) throws IOException {
        TcpThreadPoolEchoServer tcpThreadPoolEchoServer = new TcpThreadPoolEchoServer(9090);
        tcpThreadPoolEchoServer.start();
    }
}
