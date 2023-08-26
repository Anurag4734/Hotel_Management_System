package Hotel;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

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

        JMenu reception = new JMenu("Reception");
        reception.setForeground(Color.RED);
        mb.add(reception);

        JMenu admin = new JMenu("Admin");
        admin.setForeground(Color.RED);
        mb.add(admin);

        JMenuItem ad1=new JMenuItem("Add Employees");
        admin.add(ad1);

        JMenuItem ad2=new JMenuItem("Add Rooms");
        admin.add(ad2);

        JMenuItem ad3=new JMenuItem("Add Drivers");
        admin.add(ad3);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
