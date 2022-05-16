package network.dictserver;

import network.tcpthreadechoserver.TcpThreadPoolEchoServer;

import java.io.IOException;
import java.util.HashMap;

public class TcpDictServer extends TcpThreadPoolEchoServer {
    private HashMap<String, String> dict= new HashMap<>();

    public TcpDictServer(int port) throws IOException {
        super(port);

        // 简单构造几个词
        dict.put("cat", "小猫");
        dict.put("dog", "小狗");
        dict.put("fuck", "卧槽");
        dict.put("pig", "小猪");
    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request, "该单词没有办法被翻译！");
    }

    public static void main(String[] args) throws IOException {
        TcpDictServer tcpDictServer = new TcpDictServer(9090);
        tcpDictServer.start();
    }
}
