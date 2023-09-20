package Hotel;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    Dashboard(){
        setBounds(0,0,1560,1000);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 =i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);

        JLabel text =new JLabel("The Taj Group Welcomes You");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.PLAIN,45));
        text.setForeground(Color.WHITE);
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);

        JMenu hm = new JMenu("Front Desk");
        hm.setForeground(Color.RED);
        mb.add(hm);

        JMenuItem reception = new JMenuItem("Reception");
        reception.addActionListener(this);
        reception.setForeground(Color.RED);
        hm.add(reception);

        JMenu admin = new JMenu("Admin");
        admin.setForeground(Color.RED);
        mb.add(admin);

        JMenuItem ad1=new JMenuItem("Add Employees");
        ad1.addActionListener(this);
        admin.add(ad1);

        JMenuItem ad2=new JMenuItem("Add Rooms");
        ad2.addActionListener(this);
        admin.add(ad2);

        JMenuItem ad3=new JMenuItem("Add Drivers");
        ad3.addActionListener(this);
        admin.add(ad3);

        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Add Employees")){
            new AddEmployee();
        }else if(ae.getActionCommand().equals("Add Rooms")){
            new AddRooms();
        }else if(ae.getActionCommand().equals("Add Drivers")){
            new AddDriver();
        }else if(ae.getActionCommand().equals("Reception")){
            new Reception();
        }
    }


    public static void main(String[] args) {
        new Dashboard();
    }
}

