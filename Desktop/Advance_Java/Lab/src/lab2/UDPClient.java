package lab2;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to calculate its factorial: ");
        int number = scanner.nextInt(); // Take user input

        // Send number to server
        String message = String.valueOf(number);
        byte[] buff = message.getBytes();
        InetAddress address = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(buff, buff.length, address, 4445);
        socket.send(packet);

        // Receive response from server
        buff = new byte[256];
        packet = new DatagramPacket(buff, buff.length);
        socket.receive(packet);

        String received = new String(packet.getData(), 0, packet.getLength()); // Extract response
        System.out.println("Response from server: " + received);

        socket.close();
        scanner.close();
    }
}
