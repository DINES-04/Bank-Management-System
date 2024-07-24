package p_atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;

public class withdraw extends JFrame implements ActionListener {
	String pin;
   TextField textField;
   Connection connection;
   Statement st;
   JButton b1, b2;
    withdraw(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/atm3.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460,150,700,35);
        l3.add(label1);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(490,180,400,35);
        l3.add(label2);

        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460,230,320,25);
        textField.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(textField);

        b1 = new JButton("WITHDRAWL");
        b1.setBounds(640,315,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(640,375,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);


        setLayout(null);
        setSize(850,480);
		setLocation(250,150);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount1 = textField.getText();
            float amount=0;
            Date date = new Date();
            if (e.getSource()==b1){
                if (textField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the Amount you want to Withdraw");
                }else {
                	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem","root","D1d2&D3d4");
            		st= connection.createStatement();
            		ResultSet rs= st.executeQuery("SELECT amount FROM BANK WHERE pin= '"+pin+"'");
            		if(rs.next()) {
            			String at=rs.getString(1);
            			float number = Float.parseFloat(at);
            			amount=Float.parseFloat(amount1);
            			if(number>=amount) {
            				if(amount>=0 && amount<=10000) {
            					number=number-amount;
            					PreparedStatement ps = connection.prepareStatement("UPDATE bank SET date = ?, amount = ?, type = 'withdrawl' WHERE pin = ?");
            					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            			        String dateString = formatter.format(date);
            					ps.setString(1, dateString);
            					ps.setDouble(2, number);
            					ps.setString(3, pin);
            					ps.executeUpdate();
            					st.executeUpdate("insert into transcation values('"+pin+"', '"+dateString+"','withdrawl', '"+amount+"')");
            					JOptionPane.showMessageDialog(null,"Rs. "+amount+" withdrawl Successfully");
            					JOptionPane.showMessageDialog(null,"Balance Rs. "+number);
                                setVisible(false);
                                new main_class(pin);
            					}else {
            					JOptionPane.showMessageDialog(null,"Please enter the valid amount");
            					textField.setText("");
            				}
            			}else {
            				JOptionPane.showMessageDialog(null,"Can't withdrawl, Your bank balance: "+number);
            				textField.setText("");
            			}
            		}else {
            			JOptionPane.showMessageDialog(null,"Please check correct pin");
            		}
                }
            }else if (e.getSource()==b2){
                setVisible(false);
                new main_class(pin);
            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new withdraw("");
    }
}