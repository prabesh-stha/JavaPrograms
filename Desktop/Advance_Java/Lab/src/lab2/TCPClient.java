package lab2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket soc = new Socket("localhost", 1254);
        DataInputStream inc = new DataInputStream(soc.getInputStream());
        DataOutputStream outc = new DataOutputStream(soc.getOutputStream());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of Fibonacci terms: ");
        int n = scanner.nextInt(); // Read custom number from the user

        outc.writeInt(n); // Send the number to the server
        String response = inc.readUTF(); // Receive Fibonacci series from the server
        System.out.println("The Fibonacci series is: " + response);

        scanner.close();
        inc.close();
        outc.close();
        soc.close();
    }
}
