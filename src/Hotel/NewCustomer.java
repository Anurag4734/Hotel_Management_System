package Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class NewCustomer extends JFrame implements ActionListener {

    JComboBox comboid;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JRadioButton male,female;
    Choice croom;
    JLabel checkintime;
    JButton add,back;
    NewCustomer(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JLabel text = new JLabel("New Customer Form");
        text.setBounds(100,20,300,20);
        text.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(text);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(35,80,100,20);
        lblid.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblid);

        String options[] = { "Citizen id","Passport", "Driving licence", "Voter card" };
        comboid = new JComboBox (options);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel lblnumber = new JLabel("NUMBER");
        lblnumber.setBounds(35,120,100,20);
        lblnumber.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(35,160,100,20);
        lblname.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);

        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(35,200,100,20);
        lblgender.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblgender);

        male =new JRadioButton("MALE");
        male.setBounds(200,200,70,25);
        male.setFont(new Font("Raleway",Font.PLAIN,14));
        male.setBackground(Color.WHITE);
        add(male);

        female =new JRadioButton("FEMALE");
        female.setBounds(270,200,100,25);
        female.setFont(new Font("Raleway",Font.PLAIN,14));
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel lblcountry = new JLabel("COUNTRY");
        lblcountry.setBounds(35,240,100,20);
        lblcountry.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);

        JLabel lblroom = new JLabel("ROOM NUMBER");
        lblroom.setBounds(35,280,150,20);
        lblroom.setFont(new Font("Raleway", Font.PLAIN, 19));
        add(lblroom);

        croom = new Choice();
        try {
            Conn c = new Conn();
            String query = "Select * from room where available = 'Available'";
            ResultSet rs =  c.s.executeQuery(query);
            while (rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        croom.setBounds(200,280,150,25);
        add(croom);

        JLabel lbltime = new JLabel("CHECK-IN");
        lbltime.setBounds(35,320,150,20);
        lbltime.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lbltime);

        Date date = new Date();

        checkintime = new JLabel("" +date);
        checkintime.setBounds(200,320,150,25);
        checkintime.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(checkintime);

        JLabel lbldeposit = new JLabel("DEPOSIT");
        lbldeposit.setBounds(35,360,100,20);
        lbldeposit.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lbldeposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);

        add = new JButton("ADD");
        add.setBounds(50,410,120,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(200,410,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);


        setBounds(350,200,800,500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            }
            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposit = tfdeposit.getText();
            if (deposit.equals("")) {
                deposit = "0";

            }

            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Number should not be empty");
                return;
            } else if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name should not be empty");
                return;
            } else if (country.equals("")) {
                JOptionPane.showMessageDialog(null, "Country should not be empty");
                return;
            } else {
                try {
                    String query = "insert into customer values('" + id + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + room + "','" + time + "','" + deposit + "')";
                    String query2 = "update room set available = 'Occupied' where roomnumber = '" + room + "'";

                    Conn c = new Conn();
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
                    setVisible(false);
                    new Reception();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }else if (ae.getSource()== back){
            setVisible(false);
            new Reception();
        }

    }

    public static void main(String[] args){
        new NewCustomer();
    }
}
