package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceive {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6666);


        while (true) {
            //准备接收
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
            socket.receive(packet);

            byte[] data = packet.getData();
            String msg = new String(data, 0, data.length);

            System.out.println(msg);
            //System.out.println(msg.length());
            if (msg.substring(0,3).equals("bye")){
                break;
            }
        }

        socket.close();

    }
}
