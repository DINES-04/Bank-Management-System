package p_atm;

import java.awt.Color;
import java.awt.Component;
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
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class signup3 extends JFrame implements ActionListener{
	TextField tf,tf1,tf2;
	JRadioButton r1,r2,r3,r4;
	ButtonGroup bg,b;
	JComboBox combo;
	Connection connection;
	Statement st;
	PreparedStatement ps;
	Random random;
	JPasswordField password;
	static String aadhar;
	JButton b1;
	JCheckBox c1,c2,c3,c4,c5,c6;
	JButton next,clear;
	long randomnumber;
	signup3(String aadhar) throws SQLException {
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
    
    JLabel country = new JLabel("Country :");
    country.setFont(new Font("Bodoni MT",Font.BOLD,24));
    country.setBounds(100,170,200,30);
    add(country);
    tf= new TextField("Enter the Country");
    tf.setFont(new Font("Raleway",Font.BOLD,16));
    tf.setBounds(300,170,250,30);
    tf.addFocusListener(new FocusAdapter() {
        public void focusGained(FocusEvent e) {
        	if(tf.getText().equals("Enter the Country")) {
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

    JLabel pan_number = new JLabel("PAN Number :");
    pan_number.setFont(new Font("Bodoni MT",Font.BOLD,24));
    pan_number.setBounds(100,230,200,30);
    add(pan_number);
    tf1= new TextField("Enter the PAN Number");
    tf1.setFont(new Font("Raleway",Font.BOLD,16));
    tf1.setBounds(300,230,250,30);
    tf1.addFocusListener(new FocusAdapter() {
        public void focusGained(FocusEvent e) {
        	if(tf1.getText().equals("Enter the PAN Number"))
        	tf1.setText("");
        }
        
    });
    tf1.addKeyListener(new KeyAdapter() {
    	public void keyPressed(KeyEvent evt) {
    		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
    			System.out.println("Entered");
    			password.requestFocus();
    		}
    	}
    });
    add(tf1);
    
    JLabel senior= new JLabel("Senior Citizen :");
    senior.setFont(new Font("Bodoni MT",Font.BOLD,24));
    senior.setBounds(100,280,250,30);
    add(senior);
    r1= new JRadioButton("Yes");
    r1.setFont(new Font("Raleway",Font.BOLD,16));
    r1.setBackground(new Color(157,166,167));
    r1.setBounds(300,280,70,30);
    add(r1);
    r2= new JRadioButton("No");
    r2.setBackground(new Color(157,166,167));
    r2.setFont(new Font("Raleway",Font.BOLD,16));
    r2.setBounds(380,280,90,30);
    add(r2);
    bg= new ButtonGroup();
    bg.add(r1);
    bg.add(r2);
    
    JLabel existing= new JLabel("Existing Acount :");
    existing.setFont(new Font("Bodoni MT",Font.BOLD,24));
    existing.setBounds(100,330,250,30);
    add(existing);
    r3= new JRadioButton("Yes");
    r3.setFont(new Font("Raleway",Font.BOLD,16));
    r3.setBackground(new Color(157,166,167));
    r3.setBounds(300,330,70,30);
    add(r3);
    r4= new JRadioButton("No");
    r4.setBackground(new Color(157,166,167));
    r4.setFont(new Font("Raleway",Font.BOLD,16));
    r4.setBounds(380,330,90,30);
    add(r4);
    b= new ButtonGroup();
    b.add(r3);
    b.add(r4);
    
    JLabel type = new JLabel("Account Type :");
    type.setFont(new Font("Bodoni MT",Font.BOLD,24));
    type.setBounds(100,380,150,30);
    add(type);
    String t[] = {"None","Saving Account","Fixed Deposit Account","Current Account","Recurring Deposit Account"};
    combo= new JComboBox(t);
    combo.setFont(new Font("Raleway",Font.BOLD,16));
    combo.setBounds(300,380,250,30);
    add(combo);
    
    JLabel card= new JLabel("Card Number :");
    card.setFont(new Font("Bodoni MT",Font.BOLD,24));
    card.setBounds(100,430,250,30);
    add(card);
    Random random = new Random();
    long min = 111111111111L;
    long max = 999999999999L;
    randomnumber = min + ((long) (random.nextDouble() * (max - min)));
    long ld = randomnumber % 10000;
    System.out.println("Last four digits: " + ld);
    JLabel cnumber= new JLabel("XXXX-XXXX-XXXX-"+ld);
    cnumber.setFont(new Font("Bodoni MT",Font.BOLD,24));
    cnumber.setBounds(300,430,300,30);
    add(cnumber);
    JLabel appear = new JLabel("(It would appear atm card/ cheque Book and Statements)");
    appear.setFont(new Font("Raleway",Font.BOLD,12));
    appear.setBounds(300,460,500,20);
    add(appear);
    
    JLabel pin = new JLabel("Pin No:");
	pin.setFont(new Font("Bodoni MT",Font.BOLD,24));
	pin.setBounds(100,510,250,30);
	add(pin);
	JLabel text= new JLabel("(4-Digit Password)");
	text.setFont(new Font("Bodoni MT",Font.BOLD,14));
	text.setBounds(100,540,200,20);
	add(text);
    password = new JPasswordField("Password",15);
	password.setBounds(300,520,230,30);
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
	             b1.requestFocus();
	        }
	    }
	});
	add(password);
	
    JLabel service = new JLabel("Services Required :");
    service.setFont(new Font("Bodoni MT",Font.BOLD,24));
	service.setBounds(100,600,250,30);
    add(service);
	c1 = new JCheckBox("ATM CARD");
	c1.setBackground(new Color(157, 166, 167));
	c1.setFont(new Font("Raleway",Font.BOLD,16));
	c1.setBounds(320,600,130,30);
	add(c1);
	c2 = new JCheckBox("Internet Banking");
	c2.setBackground(new Color(157, 166, 167));
	c2.setFont(new Font("Raleway",Font.BOLD,16));
	c2.setBounds(460,600,190,30);
	add(c2);
	c3 = new JCheckBox("Cheque Book");
	c3.setBackground(new Color(157, 166, 167));
	c3.setFont(new Font("Raleway",Font.BOLD,16));
	c3.setBounds(650,600,230,30);
	add(c3);
	c4 = new JCheckBox("E-Statement");
	c4.setBackground(new Color(157, 166, 167));
	c4.setFont(new Font("Raleway",Font.BOLD,16));
	c4.setBounds(320,640,130,30);
	add(c4);
	c5 = new JCheckBox("Moblie Banking");
	c5.setBackground(new Color(157, 166, 167));
	c5.setFont(new Font("Raleway",Font.BOLD,16));
	c5.setBounds(460,640,190,30);
	add(c5);
	c6 = new JCheckBox("Email Alerts");
	c6.setBackground(new Color(157, 166, 167));
	c6.setFont(new Font("Raleway",Font.BOLD,16));
	c6.setBounds(650,640,230,30);
	add(c6);
	
	 next= new JButton("Next");
     next.setFont(new Font("Bodoni MT",Font.BOLD,17));
     next.setBackground(Color.BLACK);
     next.setForeground(Color.WHITE);
     next.setBounds(560,670,90,35);
     add(next);
     
     clear= new JButton("Clear");
     clear.setFont(new Font("Bodoni MT",Font.BOLD,17));
     clear.setBackground(Color.BLACK);
     clear.setForeground(Color.WHITE);
     clear.setBounds(100,670,90,35);
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
			 tf.setText("Enter the Country");
			 tf1.setText("Enter the PAN Number");
			 bg.clearSelection(); 
	         b.clearSelection(); 
	         combo.setSelectedItem("None");
	         password.setText("Password");
	         c1.setSelected(false);
	         c2.setSelected(false);
	         c3.setSelected(false);
	         c4.setSelected(false);
	         c5.setSelected(false);
	         c6.setSelected(false);
		 } else if(e.getSource() == next) {
			 String country=tf.getText();
			 String pan=tf1.getText();
			 String senior="";
			 if(r1.isSelected()) {
				 senior="yes";
			 }else if(r2.isSelected()) {
				 senior="no";
			 }
			 String existing="";
			 if(r3.isSelected()) {
				 existing="yes";
			 }else if(r4.isSelected()) {
				 existing="no";
			 }
			 String account=(String) combo.getSelectedItem();
			 long random=randomnumber;
			 String pin=password.getText();
			 String service[]= new String[6];
			 if(c1.isSelected()) {
				 service[0]="ATM CARD";
			 } 
			 if(c2.isSelected()) {
				 service[1]="Internet Banking";
			 }
			 if(c3.isSelected()) {
				 service[2]="Cheque Book";
			 }
			 if(c4.isSelected()) {
				 service[3]="E-Statement";
			 }
			 if(c5.isSelected()) {
				 service[4]="Mobile Banking";
			 }
			 if(c6.isSelected()) {
				 service[5]="Email Alerts";
			 }
			 try {
	        		if(country.equals("")||country.equals("Enter the Country")||pan.equals("")||pan.equals("Enter the PAN Number")) {
	        			JOptionPane.showMessageDialog(null,"Fill all the entry");
	        		}else if(senior.equals("")||senior==null||existing.equals("")||existing==null){
	        			JOptionPane.showMessageDialog(null,"Fill all the entry");
	        		}else if(account==null||account.equals("None")||pin==null||pin.equals("Password")){
	        			JOptionPane.showMessageDialog(null,"Fill all the entry");
	        		}else if(service[0]==null && service[1]==null && service[2]==null && service[3]==null && service[4]==null && service[5]==null) {
	        			JOptionPane.showMessageDialog(null,"Fill all the entry");
	        		}else {
	        			String query = "INSERT INTO signup3(country,pan,senior,existing,account_type,card_number,pin,service_a,service_i,service_c,service_e,service_m,service_ea,aadhar) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	        			ps= st.getConnection().prepareStatement(query);
	        			ps.setString(1,country);
	        			ps.setString(2, pan);
	        			ps.setString(3, senior);
	        			ps.setString(4, existing);
	        			ps.setString(5, account);
	        			ps.setLong(6, random);
	        			ps.setString(7, pin);
	        			ps.setString(8, service[0]);
	        			ps.setString(9, service[1]);
	        			ps.setString(10, service[2]);
	        			ps.setString(11, service[3]);
	        			ps.setString(12, service[4]);
	        			ps.setString(13, service[5]);
	        			ps.setString(14, aadhar);
	        			ps.executeUpdate();
	        			ps.close();
	        			String query1="INSERT INTO login VALUES( '"+aadhar+"','"+random+"','"+pin+"')";
	        			st.executeUpdate(query1);
	        			connection.close();
	        			st.close();
	        			setVisible(false);
	        			new final_form(aadhar);
	        		}
			 }catch(Exception E) {
	        		E.printStackTrace();
	        	}
		 }
	}
	public static void main(String arg[]) throws SQLException {
		try {
			new signup3(aadhar);
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}
