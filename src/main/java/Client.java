import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);

        InputStream in = socket.getInputStream();

        int data;

        while ((data = in.read()) != -1){
            System.out.print((char) data);
        }

        socket.close();
    }
}
