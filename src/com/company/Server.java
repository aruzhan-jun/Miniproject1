package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        DBManager manager = new DBManager();
        manager.connect();
        try {
            ServerSocket server = new ServerSocket(1984);
            System.out.println("WAITING FOR CLIENT");
            Socket socket = server.accept();
            System.out.println("CLIENT CONNECTED");
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            PackageData packageData = null;
            while((packageData = (PackageData) inputStream.readObject()) != null){
                if (packageData.getOperationType().equals("ADD STUDENT")){
                    manager.addStudent(packageData.getStudent());
                }else if (packageData.getOperationType().equals("LIST STUDENTS")){
                    packageData.setStudents(manager.getAllStudents());
                    outputStream.writeObject(packageData);
                }else if (packageData.getOperationType().equals("EXIT")){
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
