package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudent extends Container {
    protected JButton add;
    protected JButton back;

    public AddStudent(){
        setLayout(null);
        setSize(500, 500);

        JLabel label1 = new JLabel("NAME:");
        label1.setLocation(100, 100);
        label1.setSize(100, 30);
        add(label1);

        JLabel label2 = new JLabel("SURNAME:");
        label2.setLocation(100, 140);
        label2.setSize(100, 30);
        add(label2);

        JLabel label3 = new JLabel("AGE");
        label3.setLocation(100, 180);
        label3.setSize(100, 30);
        add(label3);

        JTextField textField1 = new JTextField();
        textField1.setLocation(240, 100);
        textField1.setSize(100, 30);
        add(textField1);

        JTextField textField2 = new JTextField();
        textField2.setLocation(240, 140);
        textField2.setSize(100, 30);
        add(textField2);

        JTextField textField3 = new JTextField();
        textField3.setLocation(240, 180);
        textField3.setSize(100, 30);
        add(textField3);

        add = new JButton("ADD");
        add.setLocation(100, 230);
        add.setSize(150, 30);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String surname = textField2.getText();
                int age = 0;
                try{
                    age = Integer.parseInt(textField3.getText());
                }catch(Exception a){
                    a.printStackTrace();
                }
                Student student = new Student(null, name, surname, age);
                Main.addStudent(student);
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            }
        });
        add(add);

        back = new JButton("BACK");
        back.setLocation(280, 230);
        back.setSize(150, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.addStudent.setVisible(false);
                MainFrame.mainMenu.setVisible(true);
            }
        });
        add(back);
    }
}
