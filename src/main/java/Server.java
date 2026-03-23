import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        Socket socket = serverSocket.accept();

        OutputStream out = socket.getOutputStream();

        out.write("Hello from server".getBytes());

        socket.close();
        serverSocket.close();


    }
}
