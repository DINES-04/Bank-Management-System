package p_atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class final_form extends JFrame implements ActionListener{
	TextField tf,tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
	TextField tf11,tf12,tf13,tf14,tf15,tf16,tf17,tf18,tf19;
	Connection connection;
	Statement st;
	PreparedStatement ps;
	JButton next,edit;
	String name="";
	String fname="";
	String mname="";
	String dob="";
	String gender="";
	String email="";
	String martial="";
	String phone="";
	String aadhar2="";
	String address="";
	String state="";
	String city="";
	String pincode="";
	String religion="";
	String category="";
	String income="";
	String educational="";
	String occupation="";
	String country="";
	String pan="";
	JLabel label;
	static String aadhar="";
	final_form(String aadhar) throws SQLException {
		this.aadhar=aadhar;
		setTitle("FINAL FORM");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem","root","D1d2&D3d4");
		st= connection.createStatement();
		String query="select * from signup where aadhar='"+aadhar+"'";
		String query1="select * from signup2 where aadhar='"+aadhar+"'";
		String query2="select * from signup3 where aadhar='"+aadhar+"'";
		Statement st= connection.createStatement();
		ResultSet rs= st.executeQuery(query);
		Statement st1= connection.createStatement();
		ResultSet rs1=st1.executeQuery(query1);
		Statement st2= connection.createStatement();
		ResultSet rs2=st2.executeQuery(query2);
		if(rs.next()) {
			name=rs.getString(1);
			fname=rs.getString(2);
			mname=rs.getString(3);
			dob=rs.getString(4);
			gender=rs.getString(5);
			email=rs.getString(6);
			martial=rs.getString(7);
			phone=rs.getString(8);
			aadhar2=rs.getString(9);
		}else {
			System.out.println("No data found.");
		}
		if(rs1.next()) {
			address=rs1.getString(4);
			state=rs1.getString(2);
			city=rs1.getString(1);
			pincode=rs1.getString(3);
			religion=rs1.getString(5);
			category=rs1.getString(6);
			income=rs1.getString(7);
			educational=rs1.getString(8);
			occupation=rs1.getString(9);
		}else {
			System.out.println("No data found.");
		}
		if(rs2.next()) {
			country=rs2.getString(1);
			pan=rs2.getString(2);
		}else {
			System.out.println("No data found.");
		}
		
	    label = new JLabel("FINAL VERIFICATION FORM");
	    label.setForeground(Color.YELLOW);
	    label.setBounds(260, 25, 600, 40);
	    label.setFont(new Font("Bodoni MT", Font.BOLD, 25));
	    add(label);
	    
	    JPanel blackPanel = new JPanel();
	    blackPanel.setBackground(Color.BLACK);
	    blackPanel.setBounds(0,0, 850, 90);
	    add(blackPanel);
	    
	    JLabel name1 = new JLabel("Name :");
        name1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        name1.setBounds(45,140,100,30);
        add(name1);
        tf= new TextField(name);
        tf.setFont(new Font("Raleway",Font.BOLD,17));
        tf.setEditable(false);
        tf.setBounds(210,140,200,30);
        add(tf);
        
        JLabel fname1 = new JLabel("Father Name :");
        fname1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        fname1.setBounds(45,190,150,30);
        add(fname1);
        tf1= new TextField(fname);
        tf1.setFont(new Font("Raleway",Font.BOLD,17));
        tf1.setEditable(false);
        tf1.setBounds(210,190,200,30);
        add(tf1);
        
        JLabel mname1 = new JLabel("Mother Name :");
        mname1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        mname1.setBounds(45,240,150,30);
        add(mname1);
        tf2= new TextField(mname);
        tf2.setFont(new Font("Raleway",Font.BOLD,17));
        tf2.setEditable(false);
        tf2.setBounds(210,240,200,30);
        add(tf2);
        
        JLabel dob1 = new JLabel("Date Of Birth :");
        dob1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        dob1.setBounds(45,290,150,30);
        add(dob1);
        tf3= new TextField(dob);
        tf3.setFont(new Font("Raleway",Font.BOLD,17));
        tf3.setEditable(false);
        tf3.setBounds(210,290,200,30);
        add(tf3);
        
        JLabel gender1 = new JLabel("Gender :");
        gender1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        gender1.setBounds(45,340,150,30);
        add(gender1);
        tf4= new TextField(gender);
        tf4.setFont(new Font("Raleway",Font.BOLD,17));
        tf4.setEditable(false);
        tf4.setBounds(210,340,200,30);
        add(tf4);
        
        JLabel email1 = new JLabel("E-Mail :");
        email1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        email1.setBounds(45,390,150,30);
        add(email1);
        tf5= new TextField(email);
        tf5.setFont(new Font("Raleway",Font.BOLD,15));
        tf5.setEditable(false);
        tf5.setBounds(210,390,200,30);
        add(tf5);
        
        JLabel martial1 = new JLabel("Martial :");
        martial1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        martial1.setBounds(45,440,150,30);
        add(martial1);
        tf6= new TextField(martial);
        tf6.setFont(new Font("Raleway",Font.BOLD,15));
        tf6.setEditable(false);
        tf6.setBounds(210,440,200,30);
        add(tf6);
        
        JLabel phone1 = new JLabel("Phone NO :");
        phone1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        phone1.setBounds(45,490,150,30);
        add(phone1);
        tf7= new TextField(phone);
        tf7.setFont(new Font("Raleway",Font.BOLD,15));
        tf7.setEditable(false);
        tf7.setBounds(210,490,200,30);
        add(tf7);
        
        JLabel aadhar1 = new JLabel("Aadhar NO :");
        aadhar1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        aadhar1.setBounds(45,540,150,30);
        add(aadhar1);
        tf8= new TextField(aadhar2);
        tf8.setFont(new Font("Raleway",Font.BOLD,15));
        tf8.setEditable(false);
        tf8.setBounds(210,540,200,30);
        add(tf8);
        
        JLabel address1 = new JLabel("Address :");
        address1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        address1.setBounds(45,590,150,30);
        add(address1);
        tf9= new TextField(address);
        tf9.setFont(new Font("Raleway",Font.BOLD,15));
        tf9.setEditable(false);
        tf9.setBounds(210,590,200,30);
        add(tf9);
        
        JLabel state1 = new JLabel("State :");
        state1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        state1.setBounds(450,140,150,30);
        add(state1);
        tf10= new TextField(state);
        tf10.setFont(new Font("Raleway",Font.BOLD,17));
        tf10.setEditable(false);
        tf10.setBounds(600,140,200,30);
        add(tf10);
        
        JLabel city1 = new JLabel("City :");
        city1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        city1.setBounds(450,190,150,30);
        add(city1);
        tf11= new TextField(city);
        tf11.setFont(new Font("Raleway",Font.BOLD,17));
        tf11.setEditable(false);
        tf11.setBounds(600,190,200,30);
        add(tf11);
        
        JLabel pin1 = new JLabel("Pin Code :");
        pin1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        pin1.setBounds(450,240,150,30);
        add(pin1);
        tf12= new TextField(pincode);
        tf12.setFont(new Font("Raleway",Font.BOLD,17));
        tf12.setEditable(false);
        tf12.setBounds(600,240,200,30);
        add(tf12);
        
        JLabel religion1 = new JLabel("Religion :");
        religion1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        religion1.setBounds(450,290,150,30);
        add(religion1);
        tf13= new TextField(religion);
        tf13.setFont(new Font("Raleway",Font.BOLD,17));
        tf13.setEditable(false);
        tf13.setBounds(600,290,200,30);
        add(tf13);
        
        JLabel category1 = new JLabel("Category :");
        category1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        category1.setBounds(450,340,150,30);
        add(category1);
        tf14= new TextField(category);
        tf14.setFont(new Font("Raleway",Font.BOLD,17));
        tf14.setEditable(false);
        tf14.setBounds(600,340,200,30);
        add(tf14);
        
        JLabel income1 = new JLabel("Income :");
        income1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        income1.setBounds(450,390,150,30);
        add(income1);
        tf15= new TextField(income);
        tf15.setFont(new Font("Raleway",Font.BOLD,17));
        tf15.setEditable(false);
        tf15.setBounds(600,390,200,30);
        add(tf15);
        
        JLabel educational1 = new JLabel("Educational :");
        educational1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        educational1.setBounds(450,440,150,30);
        add(educational1);
        tf16= new TextField(educational);
        tf16.setFont(new Font("Raleway",Font.BOLD,17));
        tf16.setEditable(false);
        tf16.setBounds(600,440,200,30);
        add(tf16);
        
        JLabel occupation1 = new JLabel("Occupation :");
        occupation1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        occupation1.setBounds(450,490,150,30);
        add(occupation1);
        tf17= new TextField(occupation);
        tf17.setFont(new Font("Raleway",Font.BOLD,17));
        tf17.setEditable(false);
        tf17.setBounds(600,490,200,30);
        add(tf17);
        
        JLabel country1 = new JLabel("Country :");
        country1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        country1.setBounds(450,540,150,30);
        add(country1);
        tf18= new TextField(country);
        tf18.setFont(new Font("Raleway",Font.BOLD,17));
        tf18.setEditable(false);
        tf18.setBounds(600,540,200,30);
        add(tf18);
        
        JLabel pan1 = new JLabel("PAN Number :");
        pan1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        pan1.setBounds(450,590,150,30);
        add(pan1);
        tf19= new TextField(pan);
        tf19.setFont(new Font("Raleway",Font.BOLD,17));
        tf19.setEditable(false);
        tf19.setBounds(600,590,200,30);
        add(tf19);
        
        next= new JButton("Next");
        next.setFont(new Font("Bodoni MT",Font.BOLD,17));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(570,650,90,35);
        add(next);
        
        edit= new JButton("Edit");
        edit.setFont(new Font("Bodoni MT",Font.BOLD,17));
        edit.setBackground(Color.BLACK);
        edit.setForeground(Color.WHITE);
        edit.setBounds(100,650,90,35);
        add(edit);
        
        edit.addActionListener((ActionListener) this); 
        next.addActionListener((ActionListener) this);
	    
	    getContentPane().setBackground(new Color(157, 166, 167));
	    setLayout(null);
	    setSize(850, 750);
	    setLocation(250, 0);
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	boolean b=false;
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == edit) {
			tf.setEditable(true);
			tf1.setEditable(true);
			tf2.setEditable(true);
			tf3.setEditable(true);
			tf4.setEditable(true);
			tf5.setEditable(true);
			tf6.setEditable(true);
			tf7.setEditable(true);
			tf8.setEditable(true);
			tf9.setEditable(true);
			tf10.setEditable(true);
			tf11.setEditable(true);
			tf12.setEditable(true);
			tf13.setEditable(true);
			tf14.setEditable(true);
			tf15.setEditable(true);
			tf16.setEditable(true);
			tf17.setEditable(true);
			tf18.setEditable(true);
			tf19.setEditable(true);
			b=true;
		}else if(e.getSource() == next) {
			if(b) {
				int choice=JOptionPane.showConfirmDialog(null,"Do you want to proceed this Data?","Confirmation",JOptionPane.YES_NO_OPTION);
				if(choice == JOptionPane.YES_OPTION) {
					name=tf.getText();
					fname=tf1.getText();
					mname=tf2.getText();
					dob=tf3.getText();
					gender=tf4.getText();
					email=tf5.getText();
					martial=tf6.getText();
					phone=tf7.getText();
					aadhar2=tf8.getText();
					address=tf9.getText();
					state=tf10.getText();
					city=tf11.getText();
					pincode=tf12.getText();
					religion=tf13.getText();
					category=tf14.getText();
					income=tf15.getText();
					educational=tf16.getText();
					occupation=tf17.getText();
					country=tf18.getText();
					pan=tf19.getText();
					String query = "UPDATE signup SET name=?,fname=?,mname=?,dob=?,gender=?,email=?,martial=?,phone=?,aadhar=?,address=?,state=?,city=?,pincode=?,religion=?,category=?,income=?,educational=?,occupation=?,country=?,pan=? where aadhar=?";
					try {
						ps= st.getConnection().prepareStatement(query);
						ps.setString(1,name);
						ps.setString(2,fname);
						ps.setString(3,mname);
						ps.setString(4,dob);
						ps.setString(5,gender);
						ps.setString(6,email);
						ps.setString(7,martial);
						ps.setString(8,phone);
						ps.setString(9,aadhar2);
						ps.setString(10,address);
						ps.setString(11,state);
						ps.setString(12,city);
						ps.setString(13,pincode);
						ps.setString(14,religion);
						ps.setString(15,category);
						ps.setString(16,income);
						ps.setString(17,educational);
						ps.setString(18,occupation);
						ps.setString(19,country);
						ps.setString(20,pan);
						ps.setString(21,aadhar);
						ps.executeUpdate();
						
						ps.close();
						connection.close();
						st.close();
						
						setVisible(false);
						try {
							new final_form(aadhar);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}else {
					setVisible(false);
					try {
						new final_form(aadhar);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}else {
				setVisible(false);
				try {
					new final_form2(aadhar);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}
	/*public static void main(String arg[]) throws SQLException {
		try {
			new final_form(aadhar);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
}
