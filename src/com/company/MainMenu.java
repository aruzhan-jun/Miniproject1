package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends Container {
    public JButton add;
    public JButton list;
    public JButton exit;
    public MainMenu(){
        setSize(500, 500);
        setLayout(null);

        add = new JButton("ADD STUDENT");
        add.setLocation(100, 150);
        add.setSize(300, 30);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.mainMenu.setVisible(false);
                MainFrame.addStudent.setVisible(true);
            }
        });
        add(add);

        list = new JButton("LIST STUDENTS");
        list.setLocation(100, 190);
        list.setSize(300, 30);
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getListStudents().generateTextArea(Main.listStudents());
                MainFrame.mainMenu.setVisible(false);
                MainFrame.listStudents.setVisible(true);
            }
        });
        add(list);

        exit = new JButton("EXIT");
        exit.setLocation(100, 230);
        exit.setSize(300, 30);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);
    }
}
