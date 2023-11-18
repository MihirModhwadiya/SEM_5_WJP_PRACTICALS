import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            serverSocket = new ServerSocket(12345);

            System.out.println("Server is listening on port 12345...");

            clientSocket = serverSocket.accept();

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String clientMessage;
            String response;

            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Client: " + clientMessage);

                response = "Server Response: " + clientMessage;
                out.println(response);

                if (clientMessage.equals("byy")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        } finally {
            try {
                in.close();
                out.close();
                clientSocket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
