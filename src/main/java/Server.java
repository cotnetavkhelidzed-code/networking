import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
//        Socket socket = new Socket("localhost", 5000);
//
//        InputStream in = socket.getInputStream();
//
//        int data;
//
//        while ((data = in.read()) != -1){
//            System.out.print((char) data);
//        }
//
//        socket.close();

        DatagramSocket socket = new DatagramSocket(6000);
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        String message = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Received: " + message);
        socket.close();

    }
}
