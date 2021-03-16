package demo1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream=null;
        Socket socket=null;
        try {
            //1.获取服务器地址、端口号
            InetAddress IP = InetAddress.getByName("127.0.0.1");
            int port=9999;

            //2.创建socket连接
            socket = new Socket(IP,port);

            //发送消息ID流
            outputStream = socket.getOutputStream();

            outputStream.write("你好a ".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            socket.close();
            outputStream.close();
        }

    }
}
