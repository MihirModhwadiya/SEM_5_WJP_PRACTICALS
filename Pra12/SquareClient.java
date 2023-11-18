import java.io.*;
import java.net.*;

public class SquareClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            int num1 = 5;
            int num2 = 7;

            out.println(Integer.toString(num1));
            out.println(Integer.toString(num2));

            System.out.println(in.readLine());
            System.out.println(in.readLine());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
