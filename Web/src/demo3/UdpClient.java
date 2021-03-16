package demo3;

import java.io.IOException;
import java.net.*;

public class UdpClient {
    public static void main(String[] args) throws IOException {
        //1.建立一个socket
        DatagramSocket datagramSocket = new DatagramSocket();

        //2.建立一个包
        String msg="你好，胡峻皓";

        //发送给谁
        InetAddress localhost = InetAddress.getByName("localhost");
        int port=9000;

        //数据，数据的长度起始，要发给谁
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);

        //3.发送包
        datagramSocket.send(datagramPacket);

        //4.关闭流
        datagramSocket.close();
    }
}
