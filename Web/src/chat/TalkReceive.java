package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable {
    DatagramSocket socket=null;
    private int port;
    private String msgFrom;

    public TalkReceive(int port,String msgFrom) {
        this.port = port;
        try {
            this.socket=new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        this.msgFrom=msgFrom;
    }

    @Override
    public void run() {
        while (true){

            try {
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                socket.receive(packet);
                byte[] data = packet.getData();
                String msg = new String(data, 0, data.length);
                System.out.println(msgFrom+":"+msg);

                if (msg.equals("bye")){
                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }





        }
        socket.close();
    }
}
