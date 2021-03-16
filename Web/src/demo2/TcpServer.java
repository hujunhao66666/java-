package demo2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        //1.创建端口
        ServerSocket serverSocket = new ServerSocket(9000);

        //2.监听客户端的连接
        Socket accept = serverSocket.accept();

        //3.获取输入流
        InputStream inputStream = accept.getInputStream();

        //4.文件输出
        FileOutputStream fos = new FileOutputStream(new File("receive.jpg"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len=inputStream.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }

        //通知客户端接收完毕
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("我接收完了".getBytes());


        //5.关闭资源
        fos.close();
        inputStream.close();
        accept.close();
        serverSocket.close();


    }
}
