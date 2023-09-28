package Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
    JButton newCustomer, rooms, dept, emp, manager,cust,searchRoom,update;
    Reception(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);


        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(this);
        add(newCustomer);

         rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);

         dept = new JButton("Department");
        dept.setBounds(10,110,200,30);
        dept.setBackground(Color.BLACK);
        dept.setForeground(Color.WHITE);
        dept.addActionListener(this);
        add(dept);

        emp = new JButton("All Employee");
        emp.setBounds(10,150,200,30);
        emp.setBackground(Color.BLACK);
        emp.setForeground(Color.WHITE);
        emp.addActionListener(this);
        add(emp);

        cust = new JButton("Customer Info");
        cust.setBounds(10,190,200,30);
        cust.setBackground(Color.BLACK);
        cust.setForeground(Color.WHITE);
        cust.addActionListener(this);
        add(cust);

        manager = new JButton("Manager Info");
        manager.setBounds(10,230,200,30);
        manager.setBackground(Color.BLACK);
        manager.setForeground(Color.WHITE);
        manager.addActionListener(this);
        add(manager);

        JButton checkout = new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        add(checkout);

        update = new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
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

        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10,430,200,30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
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

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==newCustomer){
            setVisible(false);
            new NewCustomer();
        } else if (ae.getSource()==rooms) {
            setVisible(false);
            new Room();
        } else if (ae.getSource()==dept) {
            setVisible(false);
            new Department();
        } else if (ae.getSource()==emp) {
            setVisible(false);
            new EmployeeInfo();

        }else if(ae.getSource()==manager){
            setVisible(false);
            new ManagerInfo();
        } else if (ae.getSource()==cust) {
            setVisible(false);
            new CustomerInfo();

        } else if (ae.getSource()==searchRoom) {
            setVisible(false);
            new SearchRoom();
        } else if (ae.getSource()==update) {
            setVisible(false);
            new UpdateCheck();
            
        }
    }

    public static void main(String[] args) {
        new Reception();
    }
}