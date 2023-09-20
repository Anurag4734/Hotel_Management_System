package Hotel;

import javax.swing.*;
import java.awt.*;

public class Reception extends JFrame {
    Reception(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);


        JButton newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        add(newCustomer);

        JButton rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        add(rooms);

        JButton dept = new JButton("Department");
        dept.setBounds(10,110,200,30);
        dept.setBackground(Color.BLACK);
        dept.setForeground(Color.WHITE);
        add(dept);

        JButton emp = new JButton("All Employee");
        emp.setBounds(10,150,200,30);
        emp.setBackground(Color.BLACK);
        emp.setForeground(Color.WHITE);
        add(emp);

        JButton cust = new JButton("Customer Info");
        cust.setBounds(10,190,200,30);
        cust.setBackground(Color.BLACK);
        cust.setForeground(Color.WHITE);
        add(cust);

        JButton manager = new JButton("Manager Info");
        manager.setBounds(10,230,200,30);
        manager.setBackground(Color.BLACK);
        manager.setForeground(Color.WHITE);
        add(manager);

        JButton checkout = new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        add(checkout);

        JButton update = new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);

        JButton roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10,350,200,30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        add(roomStatus);

        JButton pickUp = new JButton("Pickup Service");
        pickUp.setBounds(10,390,200,30);
        pickUp.setBackground(Color.BLACK);
        pickUp.setForeground(Color.WHITE);
        add(pickUp);

        JButton searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10,430,200,30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        add(searchRoom);

        JButton logout = new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);

        setBounds(350,200,800,570);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}
