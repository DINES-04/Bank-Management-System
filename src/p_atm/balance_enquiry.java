package p_atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class balance_enquiry extends JFrame implements ActionListener {

    String pin;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JButton b1;
    Connection connection;
    Statement st;
    balance_enquiry(String pin){
        this.pin =pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/atm3.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("Your Current Balance is Rs ");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 20));
        label1.setBounds(130,100,700,35);
        l3.add(label1);

        label2 = new JLabel();
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 18));
        label2.setBounds(130,140,400,35);
        l3.add(label2);
        
        label3 = new JLabel("Type: ");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System", Font.BOLD, 16));
        label3.setBounds(150,200,400,35);
        l3.add(label3);
        
        label4 = new JLabel();
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("System", Font.BOLD, 14));
        label4.setBounds(200,200,400,35);
        l3.add(label4);
        
        label5 = new JLabel("Time: ");
        label5.setForeground(Color.WHITE);
        label5.setFont(new Font("System", Font.BOLD, 16));
        label5.setBounds(150,230,400,35);
        l3.add(label5);
        
        label6 = new JLabel();
        label6.setForeground(Color.WHITE);
        label6.setFont(new Font("System", Font.BOLD, 14));
        label6.setBounds(200,230,400,35);
        l3.add(label6);

        b1 = new JButton("Back");
        b1.setBounds(525,300,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        float balance =0;
        String dates="null";
        String type="null";
        try{
        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem","root","D1d2&D3d4");
    		st= connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM BANK WHERE pin='"+pin+"'");
            if(rs.next()) {
            	balance = balance + Float.parseFloat(rs.getString(4));
            	dates=rs.getString(2);
            	type=rs.getString(3);
            }else {
            	JOptionPane.showMessageDialog(null,"Please check correct pin");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        label2.setText(""+balance);
        label4.setText(""+type);
        label6.setText(""+dates);

        setLayout(null);
        setSize(850,480);
		setLocation(250,150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_class(pin);
    }

    public static void main(String[] args) {
        new balance_enquiry("");
    }
}