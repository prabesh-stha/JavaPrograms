package lab2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    ServerSocket ss;
    Socket soc;

    public TCPServer() throws IOException {
        ss = new ServerSocket(1254);
        System.out.println("Server is waiting for a client...");
        soc = ss.accept(); // Accept the request from the client

        DataInputStream ins = new DataInputStream(soc.getInputStream());
        DataOutputStream outs = new DataOutputStream(soc.getOutputStream());

        int n = ins.readInt(); // Read the number from the client
        String fibonacciSeries = generateFibonacci(n); // Generate Fibonacci series
        outs.writeUTF(fibonacciSeries); // Send the series to the client

        System.out.println("Fibonacci series sent to the client: " + fibonacciSeries);

        ins.close();
        outs.close();
        soc.close();
        ss.close();
    }

    private String generateFibonacci(int n) {
        if (n <= 0) return "Invalid input";

        // Create an array to hold the Fibonacci series
        int[] fibo = new int[n];
        fibo[0] = 0;
        if (n > 1) fibo[1] = 1;

        // Calculate the Fibonacci series
        for (int i = 2; i < n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        // Convert the array to a space-separated string
        String result = "";
        for (int i = 0; i < n; i++) {
            result += fibo[i];
            if (i < n - 1) result += " "; // Add a space between numbers
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        new TCPServer();
    }
}
