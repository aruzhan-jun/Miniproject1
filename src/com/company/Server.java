package com.company;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1984);
            System.out.println("WAITING FOR CLIENT");
            while (true){
                Socket socket = server.accept();
                System.out.println("CLIENT CONNECTED");
                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
