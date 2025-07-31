import java.net.*;
import java.io.*;   

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // Thread to listen for messages from server
            new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        System.out.println("Server: " + msg);
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed.");
                }
            }).start();

            // Main thread reads input from client user and sends to server
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
