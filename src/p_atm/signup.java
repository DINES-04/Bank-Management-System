package p_atm;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.sql.*;

import com.toedter.calendar.JDateChooser;

public class signup extends JFrame implements ActionListener {
	TextField tf,tf1,tf2,tf3,tf4,tf5;
	JDateChooser d;
	JRadioButton r1,r2,r3,r4,r5,r6;
	JButton next,clear;
	ButtonGroup bg,b;
	Connection connection;
	Statement st;
	PreparedStatement ps;
	signup() throws SQLException{
		setTitle("APPLICATION FORM");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem","root","D1d2&D3d4");
		st= connection.createStatement();
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("image/bank.png"));
		Image img2= img.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon img3=new ImageIcon(img2);
		JLabel image=new JLabel(img3);
		image.setBounds(25,10,100,100);
		add(image);
		
		JLabel label = new JLabel("APPLICATION FORM");
		label.setForeground(Color.WHITE);
		label.setBounds(260,20,600,40);
		label.setFont(new Font("Raleway",Font.BOLD,35));
		add(label);
		
		JLabel label1= new JLabel("Personal Details");
		label1.setForeground(new Color(255, 244, 79));
		label1.setFont(new Font("Ralway",Font.BOLD,22));
		label1.setBounds(350,80,600,30);
		add(label1);
		
		JPanel blackPanel = new JPanel();
        blackPanel.setBackground(Color.BLACK);
        blackPanel.setBounds(0, 0, 850, 120);
        add(blackPanel);
		
        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Bodoni MT",Font.BOLD,24));
        name.setBounds(100,190,100,30);
        add(name);
        
        tf= new TextField("Enter the Name");
        tf.setFont(new Font("Raleway",Font.BOLD,16));
        tf.setBounds(300,190,250,30);
        tf.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
            	if(tf.getText().equals("Enter the Name")) {
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
        
        JLabel fname = new JLabel("Father Name :");
        fname.setFont(new Font("Bodoni MT",Font.BOLD,24));
        fname.setBounds(100,240,150,30);
        add(fname);
        
        tf1= new TextField("Enter the Father Name");
        tf1.setFont(new Font("Raleway",Font.BOLD,16));
        tf1.setBounds(300,240,250,30);
        tf1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
            	if(tf1.getText().equals("Enter the Father Name")) {
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
        
        JLabel mname = new JLabel("Mother Name :");
        mname.setFont(new Font("Bodoni MT",Font.BOLD,24));
        mname.setBounds(100,290,150,30);
        add(mname);
        
        tf2= new TextField("Enter the Mother Name");
        tf2.setFont(new Font("Raleway",Font.BOLD,16));
        tf2.setBounds(300,290,250,30);
        tf2.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
            	if(tf2.getText().equals("Enter the Mother Name")) {
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
        
        JLabel dob= new JLabel("Date Of Birth :");
        dob.setFont(new Font("Bodoni MT",Font.BOLD,24));
        dob.setBounds(100,340,150,30);
        add(dob);
       
        d = new JDateChooser();
        d.setForeground(new Color(105,105,105));
        d.setBounds(300,340,250,30);
        d.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
        		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        			System.out.println("Entered");
        			d.requestFocus();
        		}
        	}
        });
        add(d);
       
        JLabel gender= new JLabel("Gender :");
        gender.setFont(new Font("Bodoni MT",Font.BOLD,24));
        gender.setBounds(100,390,250,30);
        add(gender);
        
        r1= new JRadioButton("Male");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(new Color(157,166,167));
        r1.setBounds(300,390,70,30);
        add(r1);
        r2= new JRadioButton("Female");
        r2.setBackground(new Color(157,166,167));
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(380,390,90,30);
        add(r2);
        r3= new JRadioButton("Transgender");
        r3.setBackground(new Color(157,166,167));
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(475,390,150,30);
        add(r3);
        bg= new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        
        JLabel email= new JLabel("Email Address :");
        email.setFont(new Font("Bodoni MT",Font.BOLD,24));
        email.setBounds(100,440,170,30);
        add(email);
        
        tf3= new TextField("Enter the Email Address");
        tf3.setFont(new Font("Raleway",Font.BOLD,16));
        tf3.setBounds(300,440,250,30);
        tf3.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
            	if(tf3.getText().equals("Enter the Email Address")) {
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
        

        JLabel martial= new JLabel("Martial Status :");
        martial.setFont(new Font("Bodoni MT",Font.BOLD,24));
        martial.setBounds(100,490,250,30);
        add(martial);
        
        r4= new JRadioButton("Married");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(new Color(157,166,167));
        r4.setBounds(300,490,90,30);
        add(r4);
        r5= new JRadioButton("Unmarried");
        r5.setBackground(new Color(157,166,167));
        r5.setFont(new Font("Raleway",Font.BOLD,16));
        r5.setBounds(390,490,110,30);
        add(r5);
        r6= new JRadioButton("Widow");
        r6.setBackground(new Color(157,166,167));
        r6.setFont(new Font("Raleway",Font.BOLD,16));
        r6.setBounds(500,490,80,30);
        add(r6);
        b= new ButtonGroup();
        b.add(r4);
        b.add(r5);
        b.add(r6);
        
        JLabel phone= new JLabel("Phone Number :");
        phone.setFont(new Font("Bodoni MT",Font.BOLD,24));
        phone.setBounds(100,540,170,30);
        add(phone);
        tf4= new TextField("Enter the Phone Number");
        tf4.setFont(new Font("Raleway",Font.BOLD,16));
        tf4.setBounds(300,540,250,30);
        tf4.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
            	if(tf4.getText().equals("Enter the Phone Number")) {
            		tf4.setText("");
            	}
            }
            
        });
        tf4.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
        		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        			System.out.println("Entered");
        			tf5.requestFocus();
        		}
        	}
        });
        add(tf4);
        
        JLabel aadhar= new JLabel("Aadhar Number :");
        aadhar.setFont(new Font("Bodoni MT",Font.BOLD,24));
        aadhar.setBounds(100,590,190,30);
        add(aadhar);
        tf5= new TextField("Enter the Aadhar number");
        tf5.setFont(new Font("Raleway",Font.BOLD,16));
        tf5.setBounds(300,590,250,30);
        tf5.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
            	if(tf5.getText().equals("Enter the Aadhar number")) {
            		tf5.setText("");
            	}
            }
            
        });
        tf5.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
        		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        			System.out.println("Entered");
        			next.requestFocus();
        		}
        	}
        });
        add(tf5);
        
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
		getContentPane().setBackground(new Color(157,166,167));
		setLayout(null);
		setSize(850,750);
		setLocation(250,0);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            tf.setText("Enter the Name");
            tf1.setText("Enter the Father Name");
            tf2.setText("Enter the Mother Name");
            tf3.setText("Enter the Email Address");
            tf4.setText("Enter the Phone Number");
            tf5.setText("Enter the Aadhar number");
            d.setDate(null); 
            bg.clearSelection(); 
            b.clearSelection(); 
        } else if (e.getSource() == next) {
        	String name= tf.getText();
        	String fname= tf1.getText();
        	String mname= tf2.getText();
        	String dob=((JTextField) d.getDateEditor().getUiComponent()).getText();
        	String gender= null;
        	if(r1.isSelected()) {
        		gender="Male";
        	}else if(r2.isSelected()) {
        		gender="Female";
        	}else if(r3.isSelected()) {
        		gender="transgender";
        	}
        	String email= tf3.getText();
        	String martial= null;
        	if(r4.isSelected()) {
        		martial="Married";
        	}else if(r5.isSelected()) {
        		martial="Unmarried";
        	}else if(r6.isSelected()) {
        		martial="Widow";
        	}
        	String phone = tf4.getText();
        	String aadhar = tf5.getText();
        	try {
        		if(name.equals("")||name.equals("Enter the Name")||fname.equals("")||fname.equals("Enter the Father Name")) {
        			JOptionPane.showMessageDialog(null,"Fill all the entry");
        		}else if(mname.equals("")||mname.equals("Enter the Mother Name")||dob.equals("")||dob.equals("Enter the Date")){
        			JOptionPane.showMessageDialog(null,"Fill all the entry");
        		}else if(gender==null||email.equals("")||email.equals("Enter the Email Address")||aadhar.equals("")){
        			JOptionPane.showMessageDialog(null,"Fill all the entry");
        		}else if(martial==null||phone.equals("")||phone.equals("Enter the Phone Number")||aadhar.equals("Enter the City")){
        			JOptionPane.showMessageDialog(null,"Fill all the entry");
        		}else {
        			
        			String query = "INSERT INTO signup(name,fname,mname,dob,gender,email,martial,phone,aadhar) VALUES (?,?,?,?,?,?,?,?,?)";
        			ps= st.getConnection().prepareStatement(query);
        			ps.setString(1,name);
        			ps.setString(2, fname);
        			ps.setString(3, mname);
        			ps.setString(4, dob);
        			ps.setString(5, gender);
        			ps.setString(6, email);
        			ps.setString(7, martial);
        			ps.setString(8, phone);
        			ps.setString(9, aadhar);
        			ps.executeUpdate();
        			ps.close();
        			connection.close();
        			st.close();
        			new signup2(aadhar);
        			setVisible(false);
        		}
        	}catch(Exception E) {
        		E.printStackTrace();
        	}
        }
    }
	public static void main(String arg[]) throws SQLException {
		new signup();
	}
}
