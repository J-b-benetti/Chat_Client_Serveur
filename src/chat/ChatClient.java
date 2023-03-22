package chat;

import java.io.*;
import java.net.*;
public class ChatClient {
    public static void main(String[] args) {
        int port = 5000;
        try {
            Socket socket = new Socket("localhost", port);
            System.out.println("Connected to server.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line);
                System.out.println(in.readLine());
            }

            socket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
