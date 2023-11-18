import java.io.*;
import java.net.*;

public class SquareServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String num1Str = in.readLine();
                String num2Str = in.readLine();

                int num1 = Integer.parseInt(num1Str);
                int num2 = Integer.parseInt(num2Str);

                int square1 = num1 * num1;
                int square2 = num2 * num2;

                out.println("Square of " + num1 + " is: " + square1);
                out.println("Square of " + num2 + " is: " + square2);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
