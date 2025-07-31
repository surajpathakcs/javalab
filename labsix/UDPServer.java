import java.net.*;
import java.io.*;

public class UDPServer {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(9876)) {
            byte[] receiveBuffer = new byte[1024];
            byte[] sendBuffer;

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Server started. Waiting for client...");

            while (true) {
                // Receive
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);
                String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Client: " + msg);

                // Send reply
                System.out.print("You: ");
                String reply = userInput.readLine();
                sendBuffer = reply.getBytes();
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
