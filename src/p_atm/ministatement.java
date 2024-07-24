package p_atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ministatement extends JFrame implements ActionListener {
    String pin;
    JButton button;
    Connection connection;
    Statement st;
    Connection connection1;
    Statement st1;

    ministatement(String pin) {
        this.pin = pin;
        getContentPane().setBackground(new Color(0, 0, 0));
        setSize(400, 600);
        setLocation(20, 20);
        setLayout(null);

        JLabel label1 = new JLabel();
        label1.setBounds(20, 140, 400, 200);
        label1.setForeground(Color.WHITE);
        add(label1);

        JLabel label2 = new JLabel(" Bank Mini-Statement");
        label2.setFont(new Font("System", Font.BOLD, 18));
        label2.setForeground(Color.WHITE);
        label2.setBounds(110, 30, 200, 20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20, 100, 300, 20);
        label3.setForeground(Color.WHITE);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(20, 400, 300, 20);
        label4.setForeground(Color.WHITE);
        add(label4);

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "D1d2&D3d4");
            st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM login WHERE pin = '" + pin + "'");
            while (resultSet.next()) {
                label3.setText("Card Number:  " + resultSet.getString(2).substring(0, 3) + "XXXXXXX" + resultSet.getString(2).substring(11,12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            float balance = 0;
            connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "D1d2&D3d4");
            st1 = connection1.createStatement();
            ResultSet rs = st1.executeQuery("SELECT * FROM transcation WHERE pin = '" + pin + "'");
            while (rs.next()) {
                label1.setText(label1.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");

                if (rs.getString("type").equals("Deposit")) {
                    balance += Float.parseFloat(rs.getString("amount"));
                } else {
                    balance -= Float.parseFloat(rs.getString("amount"));
                }
            }
            label4.setText("Your Total Balance is Rs " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(250, 500, 100, 25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new ministatement("");
    }
}
