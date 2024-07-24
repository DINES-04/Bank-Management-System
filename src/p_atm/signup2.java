package p_atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class signup2 extends JFrame implements ActionListener{
	TextField tf,tf1,tf2,tf3,tf4;
	JComboBox combo,combo1,combo2,combo3;
	JButton next,clear;
	Connection connection;
	Statement st;
	PreparedStatement ps;
	String aadhar;
    signup2(String aadhar) throws SQLException {
    	this.aadhar=aadhar;
        setTitle("APPLICATION FORM");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem","root","D1d2&D3d4");
		st= connection.createStatement();
		
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("image/bank.png"));
        Image img2 = img.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(25, 10, 100, 100);
        add(image);

        JLabel label = new JLabel("APPLICATION FORM");
        label.setForeground(Color.WHITE);
        label.setBounds(260, 20, 600, 40);
        label.setFont(new Font("Raleway", Font.BOLD, 35));
        add(label);

        JLabel label1 = new JLabel("Personal Details");
        label1.setForeground(new Color(255, 244, 79));
        label1.setFont(new Font("Raleway", Font.BOLD, 22));
        label1.setBounds(350, 80, 600, 30);
        add(label1);

        JPanel blackPanel = new JPanel();
        blackPanel.setBackground(Color.BLACK);
        blackPanel.setBounds(0, 0, 850, 120);
        add(blackPanel);
        
        JLabel address = new JLabel("Address :");
        address.setFont(new Font("Bodoni MT",Font.BOLD,24));
        address.setBounds(100,190,200,30);
        add(address);
        tf= new TextField("Enter the Address");
        tf.setFont(new Font("Raleway",Font.BOLD,16));
        tf.setBounds(300,190,250,30);
        tf.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
            	if(tf.getText().equals("Enter the Address")) {
            		tf.setText("");
            	}
            	
            }
            
        });
        tf.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
        		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        			System.out.println("Entered");
        			tf1.requestFocus();
        		}
        	}
        });
        add(tf);
        
        JLabel state = new JLabel("State :");
        state.setFont(new Font("Bodoni MT",Font.BOLD,24));
        state.setBounds(100,240,100,30);
        add(state);
        tf1= new TextField("Enter the State");
        tf1.setFont(new Font("Raleway",Font.BOLD,16));
        tf1.setBounds(300,240,250,30);
        tf1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
            	if(tf1.getText().equals("Enter the State")) {
            	tf1.setText("");
            	}
            }
            
        });
        tf1.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
        		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        			System.out.println("Entered");
        			tf2.requestFocus();
        		}
        	}
        });
        add(tf1);
        
        JLabel city = new JLabel("City :");
        city.setFont(new Font("Bodoni MT",Font.BOLD,24));
        city.setBounds(100,290,150,30);
        add(city);
        
        tf2= new TextField("Enter the City");
        tf2.setFont(new Font("Raleway",Font.BOLD,16));
        tf2.setBounds(300,290,250,30);
        tf2.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
            	if(tf2.getText().equals("Enter the City")) {
            		tf2.setText("");
            	}
            }
            
        });
        tf2.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
        		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        			System.out.println("Entered");
        			tf3.requestFocus();
        		}
        	}
        });
        add(tf2);
        
        JLabel pincode = new JLabel("Pin Code :");
        pincode.setFont(new Font("Bodoni MT",Font.BOLD,24));
        pincode.setBounds(100,340,150,30);
        add(pincode);
        
        tf3= new TextField("Enter the Pin Code");
        tf3.setFont(new Font("Raleway",Font.BOLD,16));
        tf3.setBounds(300,340,250,30);
        tf3.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
            	if(tf3.getText().equals("Enter the Pin Code")) {
            		tf3.setText("");
            	}
            }
            
        });
        tf3.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
        		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        			System.out.println("Entered");
        			tf4.requestFocus();
        		}
        	}
        });
        add(tf3);

        JLabel religion = new JLabel("Religion :");
        religion.setFont(new Font("Bodoni MT",Font.BOLD,24));
        religion.setBounds(100,390,150,30);
        add(religion);
        String r[] = {"None","Hindu","Muslim","Sikh","Christian","Other"};
        combo= new JComboBox(r);
        //combo.setBackground(new Color(157,166,167));
        combo.setFont(new Font("Raleway",Font.BOLD,16));
        combo.setBounds(300,390,250,30);
        add(combo);
        
        JLabel category = new JLabel("Category :");
        category.setFont(new Font("Bodoni MT",Font.BOLD,24));
        category.setBounds(100,440,150,30);
        add(category);
        String c[] = {"None","General","OBC","SC","ST","Other"};
        combo1= new JComboBox(c);
        combo1.setFont(new Font("Raleway",Font.BOLD,16));
        combo1.setBounds(300,440,250,30);
        add(combo1);
        
        JLabel income = new JLabel("Income :");
        income.setFont(new Font("Bodoni MT",Font.BOLD,24));
        income.setBounds(100,490,150,30);
        add(income);
        
        tf4= new TextField("Enter the Income");
        tf4.setFont(new Font("Raleway",Font.BOLD,16));
        tf4.setBounds(300,490,250,30);
        tf4.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
            	tf4.setText("");
            }
            
        });
        tf4.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
        		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        			System.out.println("Entered");
        			next.requestFocus();
        		}
        	}
        });
        add(tf4);
        
        JLabel education = new JLabel("Educational :");
        education.setFont(new Font("Bodoni MT",Font.BOLD,24));
        education.setBounds(100,540,150,30);
        add(education);
        String e[] = {"None","Graduate","Non-Graduate","Post-Graduate","Doctrate","Other"};
        combo2= new JComboBox(e);
        combo2.setFont(new Font("Raleway",Font.BOLD,16));
        combo2.setBounds(300,540,250,30);
        add(combo2);
        
        JLabel occupation = new JLabel("Occupation :");
        occupation.setFont(new Font("Bodoni MT",Font.BOLD,24));
        occupation.setBounds(100,590,150,30);
        add(occupation);
        String o[] = {"None","Salaried","Self-Employed","Business","Student","Retired","Other"};
        combo3= new JComboBox(o);
        combo3.setFont(new Font("Raleway",Font.BOLD,16));
        combo3.setBounds(300,590,250,30);
        add(combo3);
        
        next= new JButton("Next");
        next.setFont(new Font("Bodoni MT",Font.BOLD,17));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(560,650,90,35);
        add(next);
        
        clear= new JButton("Clear");
        clear.setFont(new Font("Bodoni MT",Font.BOLD,17));
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(100,650,90,35);
        add(clear);
        clear.addActionListener((ActionListener) this); 
        next.addActionListener((ActionListener) this);
        
        getContentPane().setBackground(new Color(157, 166, 167));
        setLayout(null);
        setSize(850, 750);
        setLocation(250, 0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
           tf.setText("Enter the Address");
           tf1.setText("Enter the State");
           tf2.setText("Enter the City");
           tf3.setText("Enter the Pin Code");
           combo.setSelectedItem("None");
           combo1.setSelectedItem("None");
           tf4.setText("Enter the Income");
           combo2.setSelectedItem("None");
           combo3.setSelectedItem("None");
           
        } else if (e.getSource() == next) {
        	String address= tf.getText();
        	String state= tf1.getText();
        	String city= tf2.getText();
        	String pincode= tf3.getText();
        	String religion= (String) combo.getSelectedItem();
        	String category= (String) combo1.getSelectedItem();
        	String income= tf4.getText();
        	String educational= (String) combo2.getSelectedItem();
        	String occupation= (String) combo3.getSelectedItem();
        	try {
        		if(address.equals("")||address.equals("Enter the Address")||state.equals("")||state.equals("Enter the State")) {
        			JOptionPane.showMessageDialog(null,"Fill all the entry");
        		}else if(pincode.equals("")||pincode.equals("Enter the Pin Code")||city.equals("")||city.equals("Enter the City")){
        			JOptionPane.showMessageDialog(null,"Fill all the entry");
        		}else if(religion==null||religion.equals("None")||category.equals("None")||income.equals("")||category==null){
        			JOptionPane.showMessageDialog(null,"Fill all the entry");
        		}else if(educational==null||educational.equals("None")||occupation.equals("None")||occupation==null){
        			JOptionPane.showMessageDialog(null,"Fill all the entry");
        		}else {
        			String query = "INSERT INTO signup2(address,state,city,pincode,religion,category,income,educational,occupation,aadhar) VALUES (?,?,?,?,?,?,?,?,?,?)";
        			ps= st.getConnection().prepareStatement(query);
        			ps.setString(1,address);
        			ps.setString(2, state);
        			ps.setString(3, city);
        			ps.setString(4, pincode);
        			ps.setString(5, religion);
        			ps.setString(6, category);
        			ps.setString(7, income);
        			ps.setString(8, educational);
        			ps.setString(9, occupation);
        			ps.setString(10, aadhar);
        			ps.executeUpdate();
        			ps.close();
        			connection.close();
        			st.close();
        			
        			new signup3(aadhar);
        			setVisible(false);
        			
        		}
        	}catch(Exception E) {
        		E.printStackTrace();
        	}
        }
    }

   /* public static void main(String arg[]) throws SQLException {
        new signup2();
    }*/

}
