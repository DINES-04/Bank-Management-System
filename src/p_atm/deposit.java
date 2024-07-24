package p_atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;

public class deposit extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    Connection connection;
    Statement st;
    JButton b1, b2;

    deposit(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/atm3.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460, 180, 400, 35);
        l3.add(label1);

        textField = new TextField();
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460, 230, 320, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(textField);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(640, 315, 150, 35);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(640, 375, 150, 35);
        b2.setBackground(new Color(65, 125, 128));
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
        try {
            String amountStr = textField.getText();
            float amount = 0;
            if(amountStr.equals("")) {
            	amount=0;
            }else {
            	amount = Float.parseFloat(amountStr);
            }
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(date);

            if (e.getSource() == b1) {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "D1d2&D3d4");
                st = connection.createStatement();

                ResultSet rs = st.executeQuery("SELECT amount FROM BANK WHERE pin= '" + pin + "'");
                float currentBalance = 0;
                if (rs.next()) {
                    currentBalance = rs.getFloat(1);
                    float newBalance = currentBalance + amount;

                    st.executeUpdate("UPDATE bank SET amount='" + newBalance + "', date='" + dateString + "', type='Deposit' WHERE pin='" + pin + "'");
                }else {
                	st.executeUpdate("INSERT INTO bank (pin, date, type, amount) VALUES ('" + pin + "', '" + dateString + "', 'Deposit', '" + amount + "')");
                }

                
                st.executeUpdate("INSERT INTO transcation (pin, date, type, amount) VALUES ('" + pin + "', '" + dateString + "', 'Deposit', '" + amount + "')");
               
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");
                setVisible(false);
                new main_class(pin);
            } else if (e.getSource() == b2) {
                setVisible(false);
                new main_class(pin);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new deposit("");
    }
}
