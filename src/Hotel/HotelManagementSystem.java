package Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{
//    JLabel l1;
//    JButton b1;

    public HotelManagementSystem() {

        setSize(1366, 565);          // setContentPane(300,300,1366,390);   frame size
        setLayout(null);
        setLocation(10, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1366,565);
        add(image);

        JLabel text = new JLabel("Hotel Management System");
        text.setBounds(20,430,650,50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif" , Font.PLAIN ,55 ));
        image.add(text);

        JButton next = new JButton("Next");
        next.setBounds(1150,450,150,50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.MAGENTA);
        next.addActionListener(this);
        next.setFont(new Font("serif" , Font.PLAIN , 30));
        image.add(next);

//        l1 = new JLabel("");
//        b1 = new JButton("Next");
//
//        b1.setBackground(Color.WHITE);
//        b1.setForeground(Color.BLACK);
//
//        JLabel lid=new JLabel("HOTEL MANAGEMENT SYSTEM");
//        lid.setBounds(30,300,1500,100);
//        lid.setFont(new Font("serif",Font.PLAIN,70));
//        lid.setForeground(Color.red);
//        l1.add(lid);

//        b1.setBounds(1170,325,150,50);
//        l1.setBounds(0, 0, 1366, 390);
//
//        l1.add(b1);
//        add(l1);
//
//        b1.addActionListener(this);
        setVisible(true);
//
        while(true){
            text.setVisible(false); // lid =  j label
            try{
                Thread.sleep(500); //1000 = 1 second
            }catch(Exception e){}
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }
    }

    public void actionPerformed(ActionEvent ae){
        new Login();
        setVisible(false);

    }

    public static void main(String[] args) {
        HotelManagementSystem window = new HotelManagementSystem();
        window.setVisible(true);

    }

}
