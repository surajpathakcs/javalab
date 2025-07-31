import java.net.*;
import java.io.*;

public class UDPClient {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            byte[] sendBuffer;
            byte[] receiveBuffer = new byte[1024];

            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9876;

            while (true) {
                // Send
                System.out.print("You: ");
                String message = userInput.readLine();
                sendBuffer = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPort);
                socket.send(sendPacket);

                // Receive reply
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);
                String reply = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server: " + reply);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
