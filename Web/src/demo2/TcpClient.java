package demo2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        //1.创建socket
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9000);

        //2.创建输出
        OutputStream os = socket.getOutputStream();

        //3.文件流
        FileInputStream file = new FileInputStream(new File("me.jpg"));

        //4.写出文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len=file.read(buffer))!=-1){
            os.write(buffer,0,len);
        }

        //通知服务器，图片已经传输完成
        socket.shutdownOutput();

        //确定服务器接收完毕，才能关闭服务器
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[]bytes2=new byte[1024];
        int len2;
        while ((len2=inputStream.read(bytes2))!=-1){
            baos.write(bytes2,0,len2);
        }

        System.out.println(baos.toString());

        //5.关闭文件
        inputStream.close();
        baos.close();
        file.close();;
        os.close();
        socket.close();

    }
}
