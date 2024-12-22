package lab2;

import java.io.IOException;
import java.net.*;

public class UDPServer {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(4445);
        byte[] buff = new byte[256];

        // Receive packet from client
        DatagramPacket packet = new DatagramPacket(buff, buff.length);
        socket.receive(packet);
        String received = new String(packet.getData(), 0, packet.getLength()); // Get the actual message
        System.out.println("Received from client: " + received);

        try {
            int number = Integer.parseInt(received.trim()); // Parse the number
            long factorial = calculateFactorial(number); // Calculate factorial

            // Send factorial result back to the client
            String response = "Factorial of " + number + " is " + factorial;
            buff = response.getBytes();
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buff, buff.length, address, port);
            socket.send(packet);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number received.");
        }

        socket.close();
    }

    private static long calculateFactorial(int n) {
        if (n < 0) return -1; // Invalid input for factorial
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
