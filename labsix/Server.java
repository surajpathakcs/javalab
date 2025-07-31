import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server started. Waiting for client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // Thread to listen for messages from client
            new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        System.out.println("Client: " + msg);
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed.");
                }
            }).start();

            // Main thread reads input from server user and sends to client
            String message;
            while ((message = userInput.readLine()) != null) {
                out.write(message);
                out.newLine();
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
