package demo1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket=null;
        Socket accept=null;
        InputStream inputStream=null;
        ByteArrayOutputStream out=null;
        try {
            //有一个地址
            serverSocket = new ServerSocket(9999);

            while (true) {
                //等待客户端连接
                accept = serverSocket.accept();
                //读取客户端消息
                inputStream = accept.getInputStream();

            /*byte[] bytes = new byte[1024];
            int len;
            while ((len=inputStream.read(bytes))!=-1){
                String msg = new String(bytes, 0, len);
                System.out.println(msg);
            }*/

                out = new ByteArrayOutputStream();
                byte[] bytes = new byte[1024];
                int len;
                while ((len = inputStream.read(bytes)) != -1) {
                    out.write(bytes, 0, len);
                }

                System.out.println(out.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
