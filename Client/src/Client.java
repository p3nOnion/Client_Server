import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
public class Client {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int port = 8080;
        String host = "localhost";
        DataInputStream in;
        DataInputStream str;
        DataOutputStream out;
        Socket connectToServer;
        try {
            //tao 1 socket de ket noi voi socket server;
            connectToServer = new Socket(host, port);
            //tao luong nhan du lieu tu server
            in = new DataInputStream(connectToServer.getInputStream());
            //tao luong gui du lieu den server
            out = new DataOutputStream(connectToServer.getOutputStream());
            //tao luong nhan du lieu tu ban phim
            str = new DataInputStream(System.in);
            //request
            while (true) {
                Double data;
                //nhap ban kinh
                System.out.println("Nhap ban kinh: ");

                double radius =  myObj.nextDouble();

                //Gui du lieu cho server
                out.writeDouble(radius);
                out.flush();
                //nhan ket qua tu server
                double area = in.readDouble();
                System.out.println("dien tich la: " + area);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
