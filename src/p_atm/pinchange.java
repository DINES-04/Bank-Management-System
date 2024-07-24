package p_atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class pinchange extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;
    Connection connection;
    Statement st;
    pinchange(String pin){
        this.pin =pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/atm3.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 20));
        label1.setBounds(100,100,400,35);
        l3.add(label1);


        JLabel label2 = new JLabel("New PIN: ");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(100,150,150,35);
        l3.add(label2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(65,125,128));
        p1.setForeground(Color.WHITE);
        p1.setBounds(250,155,180,25);
        p1.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(p1);

        JLabel label3 = new JLabel("Re-Enter New PIN: ");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System", Font.BOLD, 16));
        label3.setBounds(100,200,400,35);
        l3.add(label3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(65,125,128));
        p2.setForeground(Color.WHITE);
        p2.setBounds(250,205,180,25);
        p2.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(p2);



        b1 = new JButton("CHANGE");
        b1.setBounds(550,300,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(550,350,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(850, 480);
        setLocation(250, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{

            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if (!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            if (e.getSource()==b1){
                if (p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New PIN");
                    return;
                }
                if (p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
                    return;
                }

                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "D1d2&D3d4");
                st = connection.createStatement();
                String q1 = "update bank set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q2 = "update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update signup3 set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q4 = "update transcation set pin = '"+pin1+"' where pin = '"+pin+"'";
                st.executeUpdate(q1);
                st.executeUpdate(q2);
                st.executeUpdate(q3);
                st.executeUpdate(q4);
                
                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                JOptionPane.showMessageDialog(null,"Once again , Restart Application...");
                setVisible(false);
                new atm();

            } else if (e.getSource()==b2) {
            	setVisible(false);
            	new main_class(pin);
            }


        }catch (Exception E){
            E.printStackTrace();
        }



    }

    public static void main(String[] args) {
        new pinchange("");
    }
}