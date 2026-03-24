import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws IOException {
//        ServerSocket serverSocket = new ServerSocket(5000);
//        Socket socket = serverSocket.accept();
//
//        OutputStream out = socket.getOutputStream();
//
//        out.write("Hello from server".getBytes());
//
//        socket.close();
//        serverSocket.close();


        DatagramSocket socket = new DatagramSocket();

        byte[] data = "Hello UDP server".getBytes();

        InetAddress address = InetAddress.getByName("localhost");

        DatagramPacket packet = new DatagramPacket(data, data.length, address, 6000);

        socket.send(packet);

    }
}
