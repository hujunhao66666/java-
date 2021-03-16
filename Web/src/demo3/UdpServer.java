package demo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {
    public static void main(String[] args) throws IOException {
        //开放端口
        DatagramSocket datagramSocket = new DatagramSocket(9000);
        //接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);

        datagramSocket.receive(datagramPacket);//阻塞接收

        System.out.println(datagramPacket.getAddress().getHostAddress());
        System.out.println(new String (datagramPacket.getData(),0,datagramPacket.getLength()));

        //关闭端口
        datagramSocket.close();
    }
}
