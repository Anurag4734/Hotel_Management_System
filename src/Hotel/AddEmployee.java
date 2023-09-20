package Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField tname,tage,tsalary,tphone,tpan,temail;
    JRadioButton male,female;
    JButton submit;
    JComboBox cjob;

    AddEmployee() {
        setLayout(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);


        JLabel name =new JLabel("NAME");
        name.setBounds(60,30,120,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(name);

        tname = new JTextField();
        tname.setBounds(200,30,150,30);
        add(tname);

        JLabel title =new JLabel("Add Employee Details");
        title.setBounds(490,30,320,30);
        title.setFont(new Font("Tahoma",Font.PLAIN,28));
        title.setForeground(Color.BLUE);
        add(title);


        JLabel age =new JLabel("AGE");
        age.setBounds(60,80,120,30);
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(age);

        tage = new JTextField();
        tage.setBounds(200,80,150,30);
        add(tage);

        JLabel gender =new JLabel("GENDER");
        gender.setBounds(60,130,120,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(gender);

        male =new JRadioButton("MALE");
        male.setBounds(200,130,70,30);
        male.setFont(new Font("Tahoma",Font.PLAIN,14));
        male.setBackground(Color.WHITE);
        add(male);

        female =new JRadioButton("FEMALE");
        female.setBounds(275,130,75,30);
        female.setFont(new Font("Tahoma",Font.PLAIN,14));
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel job =new JLabel("JOB");
        job.setBounds(60,180,120,30);
        job.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(job);

        String val[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
        cjob = new JComboBox(val);
        cjob.setBounds(200,180,150,30);
        cjob.setBackground(Color.WHITE);
        add(cjob);

        JLabel salary =new JLabel("SALARY");
        salary.setBounds(60,230,120,30);
        salary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(200,230,150,30);
        add(tsalary);

        JLabel phone =new JLabel("PHONE");
        phone.setBounds(60,280,120,30);
        phone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(200,280,150,30);
        add(tphone);

        JLabel pan =new JLabel("PAN NUMBER");
        pan.setBounds(60,330,120,30);
        pan.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(pan);

        tpan = new JTextField();
        tpan.setBounds(200,330,150,30);
        add(tpan);

        JLabel email =new JLabel("EMAIL");
        email.setBounds(60,380,120,30);
        email.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(email);

        temail = new JTextField();
        temail.setBounds(200,380,150,30);
        add(temail);

        submit = new JButton("SUBMIT");
        submit.setBounds(200,450,150,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        setVisible(true);
    }

        public  void actionPerformed(ActionEvent ae) {
            String name = tname.getText();
            String age = tage.getText();
            String salary = tsalary.getText();
            String phone = tphone.getText();
            String pan = tpan.getText();
            String email = temail.getText();

            String gender = null;
            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            }
            String job = (String) cjob.getSelectedItem();

            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name should not be empty");
                return;
            } else if (age.equals("")) {
                JOptionPane.showMessageDialog(null, "Age should not be empty");
                return;
            } else if (salary.equals("")) {
                JOptionPane.showMessageDialog(null, "Salary should not be empty");
                return;
            } else if (phone.equals("")) {
                JOptionPane.showMessageDialog(null, "Phone should not be empty");
                return;
            } else if (pan.equals("")) {
                JOptionPane.showMessageDialog(null, "Pan should not be empty");
                return;
            } else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Email should not be empty");
                return;
            } else {

                try {
                    Conn c = new Conn();


                    String query = "INSERT INTO employee values( '" + name + "', '" + age + "', '" + gender + "','" + job + "', '" + salary + "', '" + phone + "','" + pan + "', '" + email + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Employee added successfully");

                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    public static void main(String[] args) {
        new AddEmployee();
    }
}