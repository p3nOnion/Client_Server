import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class serverSocket {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        DataInputStream in;
        DataOutputStream out;

        ServerSocket serverSocket;
        Socket connectToClient;
        try {
            serverSocket = new ServerSocket(port);
            connectToClient = serverSocket.accept();
            in = new DataInputStream(connectToClient.getInputStream());
            out = new DataOutputStream(connectToClient.getOutputStream());
            //System.out.println(in.readDouble());
            while (true) {
                System.out.println("Tinh dien tich: ");
                double radius = in.readDouble();
                System.out.println("ban kinh nhan tu Client: " + radius);
                double area = radius * radius * Math.PI;
                //response
                out.writeDouble(area);
                out.flush();
                System.out.println("Hinh tron ban kinh: " + radius + " co dien tich la: " + area);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
