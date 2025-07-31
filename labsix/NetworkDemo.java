
import java.net.*;
import java.io.*;

public class NetworkDemo {

    public static void main(String[] args) {
        try {
            // InetAddress demo
            InetAddress ip = InetAddress.getByName("www.instagram.com");
            System.out.println("Host Name: " + ip.getHostName());
            System.out.println("IP Address: " + ip.getHostAddress());

            // URL demo
            URL url = new URL("https://www.example.com");
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());

            // URLConnection demo
            URLConnection con = url.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            int count = 0;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

            in.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
