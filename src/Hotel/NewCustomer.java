package Hotel;

import javax.swing.*;
import java.awt.*;

public class NewCustomer extends JFrame {

    JComboBox comboid;
    NewCustomer(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("New Customer Form");
        text.setBounds(100,20,300,20);
        text.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(text);

        JLabel lblid = new JLabel("ID");
       lblid.setBounds(35,80,100,20);
        lblid.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblid);

        String options[] = { "Ctitizen id","Passport", "Driving licence", "Voter card" };
        comboid = new JComboBox (options);
        setBounds(200,80,150,25);
        add(comboid);


        setBounds(350,200,800,500);
        setVisible(true);
    }

    public static void main(String[] args){
        new NewCustomer();
    }
}
