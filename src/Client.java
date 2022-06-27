import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),8080);
        try (var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             var out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             var scanner = new Scanner(System.in)) {
            String msg;

            System.out.println("Enter message for server...");
                msg = scanner.nextLine();
                out.println(msg);

                System.out.println("Server: " + in.readLine());
        }
    }

}

