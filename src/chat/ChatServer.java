package chat;

import java.io.*;
import java.net.*;
public class ChatServer {
    public static void main(String[] args) {
        int port = 5000;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started. Listening on port " + port + ".");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected à l'adresse : " + clientSocket.getInetAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String line;
            while (true) {
                // Lecture du message du client
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                System.out.println("Client: " + line);

                // Lecture du message depuis la console du serveur
                System.out.print("Server: ");
                line = console.readLine();
                if (line == null) {
                    break;
                }

                // Envoi du message saisi depuis la console du serveur au client
                writer.println("Server: " + line);
            }

            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

