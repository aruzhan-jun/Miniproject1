package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static MainFrame frame;
    public static Socket socket;
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;

    public static void main(String[] args) {
        connectToServer();
        frame = new MainFrame();
        frame.setVisible(true);
    }
    public static void connectToServer() {
        try {
            socket = new Socket("127.0.0.1", 1984);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addStudent(Student student) {
        PackageData packageData = new PackageData();
        packageData.setOperationType("ADD STUDENT");
        packageData.setStudent(student);
        try {
            outputStream.writeObject(packageData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> listStudents() {
        ArrayList<Student> students = new ArrayList<>();
        PackageData packageData = new PackageData();
        packageData.setOperationType("LIST STUDENTS");
        try {
            outputStream.writeObject(packageData);
            PackageData pd;
            if ((pd = (PackageData) inputStream.readObject()) != null) {
                students = pd.getStudents();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
