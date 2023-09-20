package Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {
    JTextField troom,tprice;
    JComboBox cava,cclean,cbed;
    JButton submit;
    AddRooms(){
        setLayout(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("ADD ROOMS");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);

        JLabel room =new JLabel("ROOM NUMBER");
        room.setBounds(60,80,120,30);
        room.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(room);

        troom = new JTextField();
        troom.setBounds(200,80,150,30);
        add(troom);

        JLabel available =new JLabel("AVAILABLE");
        available.setBounds(60,130,120,30);
        available.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(available);

        String val1[] = {"Available","Occupied"};
        cava = new JComboBox(val1);
        cava.setBounds(200,130,150,30);
        cava.setBackground(Color.WHITE);
        add(cava);

        JLabel status =new JLabel("CLEAN STATUS");
        status.setBounds(60,180,150,30);
        status.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(status);

        String val2[] = {"Cleaned","Dirty"};
        cclean = new JComboBox(val2);
        cclean.setBounds(200,180,150,30);
        cclean.setBackground(Color.WHITE);
        add(cclean);

        JLabel price =new JLabel("PRICE");
        price.setBounds(60,230,120,30);
        price.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(price);

        tprice = new JTextField();
        tprice.setBounds(200,230,150,30);
        add(tprice);

        JLabel bed =new JLabel("BED TYPE");
        bed.setBounds(60,280,120,30);
        bed.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(bed);

        String val3[] = {"Single Bed","Double Bed"};
        cbed = new JComboBox(val3);
        cbed.setBounds(200,280,150,30);
        cbed.setBackground(Color.WHITE);
        add(cbed);

        submit = new JButton("ADD ROOM");
        submit.setBounds(150,350,150,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,30,500,380);
        add(image);

        setBounds(330,300,940,470);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        String room = troom.getText();
        String price = tprice.getText();
        String available = (String) cava.getSelectedItem();
        String clean = (String) cclean.getSelectedItem();
        String bed = (String) cbed.getSelectedItem();

        if (room.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter room number");
            return;
        }else if (price.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Price");
            return;
        }else {
            try{
                Conn c = new Conn();

                String query = "INSERT INTO room values( '"+room+"', '"+available+"', '"+clean+"','"+price+"', '"+bed+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "New Room  added successfully");
                setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new AddRooms();
    }
}
