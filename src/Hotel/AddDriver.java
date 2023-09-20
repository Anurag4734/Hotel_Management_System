package Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {
    JTextField tname,tage,tcar,tmodel,tlocation;

    JRadioButton male,female;
    JButton submit;
    JComboBox caval;
    AddDriver(){
        setLayout(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel name =new JLabel("NAME");
        name.setBounds(60,80,120,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(name);

        tname = new JTextField();
        tname.setBounds(200,80,150,30);
        add(tname);

        JLabel title =new JLabel("Add Driver");
        title.setBounds(150,30,200,20);
        title.setFont(new Font("Tahoma",Font.PLAIN,26));
        title.setForeground(Color.BLUE);
        add(title);


        JLabel age =new JLabel("AGE");
        age.setBounds(60,130,120,30);
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(age);

        tage = new JTextField();
        tage.setBounds(200,130,150,30);
        add(tage);

        JLabel gender =new JLabel("GENDER");
        gender.setBounds(60,180,120,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(gender);

        male =new JRadioButton("MALE");
        male.setBounds(200,180,70,30);
        male.setFont(new Font("Tahoma",Font.PLAIN,14));
        male.setBackground(Color.WHITE);
        add(male);

        female =new JRadioButton("FEMALE");
        female.setBounds(275,180,75,30);
        female.setFont(new Font("Tahoma",Font.PLAIN,14));
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);


        JLabel car =new JLabel("CAR COMPANY");
        car.setBounds(60,230,120,30);
        car.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(car);

        tcar = new JTextField();
        tcar.setBounds(200,230,150,30);
        add(tcar);

        JLabel model =new JLabel("CAR MODEL");
        model.setBounds(60,280,120,30);
        model.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(model);

        tmodel = new JTextField();
        tmodel.setBounds(200,280,150,30);
        add(tmodel);

        JLabel available =new JLabel("AVAILABLE");
        available.setBounds(60,330,120,30);
        available.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(available);

        String val[] = {"Available","Busy"};
        caval = new JComboBox(val);
        caval.setBounds(200,330,150,30);
        caval.setBackground(Color.WHITE);
        add(caval);

        JLabel location =new JLabel("LOCATION");
        location.setBounds(60,380,120,30);
        location.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(location);

        tlocation = new JTextField();
        tlocation.setBounds(200,380,150,30);
        add(tlocation);



        submit = new JButton("ADD DRIVER");
        submit.setBounds(200,450,150,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,40,550,370);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,980,540);
        setVisible(true);
    }

    public  void actionPerformed(ActionEvent ae) {
        String name = tname.getText();
        String age = tage.getText();
        String car = tcar.getText();
        String model = tmodel.getText();
        String location = tlocation.getText();

        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String aval = (String) caval.getSelectedItem();

        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name should not be empty");
            return;
        } else if (age.equals("")) {
            JOptionPane.showMessageDialog(null, "Age should not be empty");
            return;
        } else if (car.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter car company name");
            return;
        } else if (model.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter car model");
            return;
        } else if (location.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter the location");
            return;
        }else {

            try {
                Conn c = new Conn();


                String query = "INSERT INTO driver values( '"+name+"', '"+age+"', '"+gender+"','"+car+"', '"+model+"', '"+aval+"','"+location+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "New Driver added successfully");

                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new AddDriver();
    }
}
