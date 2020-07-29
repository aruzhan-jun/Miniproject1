package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        DBManager manager = new DBManager();
        manager.connect();
        try{
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
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
