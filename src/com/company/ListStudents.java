package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListStudents extends Container{
    private String header[] = {"Name", "Surname", "Age"};
    private JScrollPane scrollPane;
    private JTable table;
    public ListStudents(){
        setLayout(null);
        setSize(500, 500);

        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setRowHeight(30);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(350, 200);
        scrollPane.setLocation(100, 100);
        add(scrollPane);

        JButton button = new JButton("BACK");
        button.setLocation(100, 400);
        button.setSize(300, 30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.listStudents.setVisible(false);
                MainFrame.mainMenu.setVisible(true);
            }
        });
        add(button);
    }
    public void generateTable(ArrayList<Student> students){
        Object data[][] = new Object[students.size()][3];
        for (int i=0; i<students.size(); i++){
            data[i][0] = students.get(i).getName();
            data[i][1] = students.get(i).getSurname();
            data[i][2] = students.get(i).getAge();
        }
        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);
    }
}
