package p_atm;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;

import javax.swing.*;

public class atm implements ActionListener{
	JLabel label,label1,label2;
	JTextField textfield;
	JPasswordField password;
	JButton button,button1,button2;
	Connection connection;
	Statement st;
	JFrame f;
	atm() {
		
		f= new JFrame();
		f.setTitle("ATM INTERFACE");
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("image/bank.png"));
		Image img2= img.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon img3=new ImageIcon(img2);
		JLabel image=new JLabel(img3);
		image.setBounds(350,10,100,100);
		
		ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("image/card.png"));
		Image im2= im.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon im3=new ImageIcon(im2);
		JLabel im1=new JLabel(im3);
		im1.setBounds(700,350,100,100);
		
		label= new JLabel("WELCOME TO ATM");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("AvantGarde",Font.BOLD,38));
		label.setBounds(230,125,450,40);
		f.add(label);
		
		label1 = new JLabel("Card No:");
		label1.setFont(new Font("ralway",Font.BOLD,25));
		label1.setForeground(Color.white);
		label1.setBounds(180,200,375,30);
		f.add(label1);
		
		textfield = new JTextField("Enter the Card Number",15);
		textfield.setBounds(325, 200, 230, 30);
		textfield.setFont(new Font("Arial", Font.BOLD, 14));
		textfield.addFocusListener(new FocusAdapter() {
	            public void focusGained(FocusEvent e) {
	            	textfield.setText("");
	            }
	            
	        });
		textfield.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent evt) {
		        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
		            System.out.println("Entered");
		            password.requestFocus();
		        }
		    }
		});
		f.add(textfield);
		
		label2 = new JLabel("Pin No:");
		label2.setFont(new Font("ralway",Font.BOLD,25));
		label2.setForeground(Color.white);
		label2.setBounds(190,250,375,30);
		f.add(label2);
		
		password = new JPasswordField("Password",15);
		password.setBounds(325,250,230,30);
		password.setFont(new Font("Arial",Font.BOLD,14));
		password.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
            	password.setText("");
            }
            
        });
		password.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent evt) {
		        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
		            System.out.println("Entered");
		            button.requestFocus();
		        }
		    }
		});
		f.add(password);
		
		button = new JButton("SIGN IN");
		button.setFont(new Font("Arival",Font.BOLD,14));
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLACK);
		button.setBounds(325,325,100,30);
		button.addActionListener(this);
		f.add(button);
		
		button1 = new JButton("CLEAR");
		button1.setFont(new Font("Arival",Font.BOLD,14));
		button1.setForeground(Color.WHITE);
		button1.setBackground(Color.BLACK);
		button1.setBounds(450,325,100,30);
		button1.addActionListener(this);
		f.add(button1);
		
		button2 = new JButton("SIGN UP");
		button2.setFont(new Font("Arival",Font.BOLD,14));
		button2.setForeground(Color.WHITE);
		button2.setBackground(Color.BLACK);
		button2.setBounds(550,50,100,30);
		button2.addActionListener(this);
		button2.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent evt) {
		        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
		            System.out.println("Entered");
		            	textfield.requestFocus();
		        }
		    }
		});
		f.add(button2);
		
		f.getContentPane().setBackground(Color.BLACK);
		f.setLayout(null);
		f.setSize(850,480);
		f.setLocation(250,150);
		f.add(image);
		f.add(im1);
		f.setVisible(true);
	}
	public static void main(String[] args){
		new atm();

	}
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource()==button) {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem","root","D1d2&D3d4");
				st= connection.createStatement();
				String cardno =textfield.getText();
				String pin =password.getText();
				String q= "select * from login where card_number= '"+cardno+"' and pin= '"+pin+"'";
				ResultSet resultset= st.executeQuery(q);
				if(resultset.next()) {
					f.setVisible(false);
					new main_class(pin);
				}else {
					JOptionPane.showMessageDialog(null,"Please check Card Number or Pin");
				}
			}else if(e.getSource()==button1) {
				textfield.setText("");
				password.setText("");
			}else if(e.getSource()==button2) {
				new signup();
				f.setVisible(false);
			}
		}catch(Exception E) {
			E.printStackTrace();
		}
	}
	
}
