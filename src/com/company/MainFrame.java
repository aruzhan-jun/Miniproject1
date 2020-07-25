package com.company;

import javax.swing.*;

public class MainFrame extends JFrame{
    public static MainMenu mainMenu;
    public static AddStudent addStudent;
    public static ListStudents listStudents;
    public MainFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("STUDENTS APPLICATION");
        setSize(500, 500);
        setLayout(null);

        mainMenu = new MainMenu();
        add(mainMenu);

        addStudent = new AddStudent();
        addStudent.setVisible(false);
        add(addStudent);

        listStudents = new ListStudents();
        listStudents.setVisible(false);
        add(listStudents);
    }
    public static ListStudents getListStudents(){
        return listStudents;
    }
}
