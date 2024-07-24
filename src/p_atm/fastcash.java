package p_atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class fastcash extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;
    Connection connection;
    Statement st;

    fastcash(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/atm3.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel label = new JLabel("SELECT WITHDRAWAL AMOUNT");
        label.setBounds(220, 100, 700, 35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System", Font.BOLD, 23));
        l3.add(label);

        b1 = new JButton("Rs. 100");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65, 125, 128));
        b1.setBounds(100, 200, 150, 35);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("Rs. 500");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65, 125, 128));
        b2.setBounds(550, 200, 150, 35);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("Rs. 1000");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65, 125, 128));
        b3.setBounds(100, 265, 150, 35);
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("Rs. 2000");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65, 125, 128));
        b4.setBounds(550, 265, 150, 35);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("Rs. 5000");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65, 125, 128));
        b5.setBounds(100, 330, 150, 35);
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("Rs. 10000");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65, 125, 128));
        b6.setBounds(550, 330, 150, 35);
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("BACK");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65, 125, 128));
        b7.setBounds(550, 395, 150, 35);
        b7.addActionListener(this);
        l3.add(b7);

        setLayout(null);
        setSize(850, 480);
        setLocation(250, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b7) {
            setVisible(false);
            new main_class(pin);
        } else {
            String amount = ((JButton) e.getSource()).getText().substring(4);
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "D1d2&D3d4");
                st = connection.createStatement();
                
                ResultSet resultSet = st.executeQuery("SELECT amount FROM bank WHERE pin = '" + pin + "'");
                if (resultSet.next()) {  // Move cursor to the first row
                    float balance = resultSet.getFloat("amount");
                    if (balance < Float.parseFloat(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String dateString = formatter.format(date);

                    float newBalance = balance - Float.parseFloat(amount);
                    st.executeUpdate("UPDATE bank SET amount='" + newBalance + "', date='" + dateString + "', type='Withdrawal' WHERE pin='" + pin + "'");
                    st.executeUpdate("INSERT INTO transcation (pin, date, type, amount) VALUES ('" + pin + "', '" + dateString + "', 'Withdrawal', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                    JOptionPane.showMessageDialog(null, "Rs. " + newBalance + "  current Balance.");
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
            setVisible(false);
            new main_class(pin);
        }
    }

    public static void main(String[] args) {
        new fastcash("");
    }
}
