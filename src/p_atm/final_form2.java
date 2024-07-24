package p_atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class final_form2 extends JFrame implements ActionListener{
	TextField tf,tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
	Connection connection;
	Statement st;
	PreparedStatement ps;
	JCheckBox c1;
	JButton button,cancel;
	static String aadhar="543216789012";
	String senior="";
	String existing="";
	String account="";
	String card="";
	String pin="";
	String atm="";
	String internet="";
	String cheque="";
	String es="";
	String mobile="";
	String ea="";
	final_form2(String aadhar) throws SQLException {
		setTitle("FINAL FORM");
		
		this.aadhar=aadhar;
		setTitle("FINAL FORM");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem","root","D1d2&D3d4");
		st= connection.createStatement();
		String query="select * from signup3 where aadhar='"+aadhar+"'";
		
		st= connection.createStatement();
		ResultSet rs= st.executeQuery(query);
		if(rs.next()) {
			senior=rs.getString(3);
			existing=rs.getString(4);
			account=rs.getString(5);
			card=rs.getString(6);
			pin=rs.getString(7);
			atm=rs.getString(8);
			internet=rs.getString(9);
			cheque=rs.getString(10);
			es=rs.getString(11);
			mobile=rs.getString(12);
			ea=rs.getString(13);
		}else {
			System.out.println("No data found.");
		}
		JLabel label = new JLabel("FINAL VERIFICATION FORM");
	    label.setForeground(Color.YELLOW);
	    label.setBounds(260, 25, 600, 40);
	    label.setFont(new Font("Bodoni MT", Font.BOLD, 25));
	    add(label);
	    
	    JPanel blackPanel = new JPanel();
	    blackPanel.setBackground(Color.BLACK);
	    blackPanel.setBounds(0,0, 850, 90);
	    add(blackPanel);
	    
	    JLabel senior1 = new JLabel("Senior Citizen :");
        senior1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        senior1.setBounds(45,140,150,30);
        add(senior1);
        tf= new TextField(senior);
        tf.setFont(new Font("Raleway",Font.BOLD,17));
        tf.setEditable(false);
        tf.setBounds(210,140,150,30);
        add(tf);
        
        JLabel account1 = new JLabel("Account Type :");
        account1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        account1.setBounds(45,190,150,30);
        add(account1);
        tf2= new TextField(account);
        tf2.setFont(new Font("Raleway",Font.BOLD,17));
        tf2.setEditable(false);
        tf2.setBounds(210,190,300,30);
        add(tf2);
        
        JLabel card1 = new JLabel("Card Number :");
        card1.setFont(new Font("Bodoni MT",Font.BOLD,24));
        card1.setBounds(45,240,150,30);
        add(card1);
        String lastfour;
        if(card.length() >= 4) {
            lastfour = card.substring(card.length() - 4);
        } else {
            lastfour = card; 
        }
        tf3= new TextField("xxxx-xxxx-xxxx-"+lastfour);
        tf3.setFont(new Font("Raleway",Font.BOLD,17));
        tf3.setEditable(false);
        tf3.setBounds(210,240,200,30);
        add(tf3);
        
        JLabel exist1 = new JLabel("Existing Account :");
        exist1.setFont(new Font("Bodoni MT",Font.BOLD,22));
        exist1.setBounds(450,140,180,30);
        add(exist1);
        tf1= new TextField(existing);
        tf1.setFont(new Font("Raleway",Font.BOLD,17));
        tf1.setEditable(false);
        tf1.setBounds(630,140,150,30);
        add(tf1);
        
        JLabel service1 = new JLabel("Services Required :");
        service1.setFont(new Font("Bodoni MT",Font.BOLD,22));
        service1.setBounds(45,290,180,30);
        add(service1);
        JLabel atm1 = new JLabel("ATM CARD :");
        atm1.setFont(new Font("Bodoni MT",Font.BOLD,22));
        atm1.setBounds(70,340,150,30);
        add(atm1);
        if(atm!=null && !atm.equals("")) {
        	tf4= new TextField("Selected");
        }else {
        	tf4= new TextField("Rejected");
        }
        tf4.setFont(new Font("Raleway",Font.BOLD,17));
        tf4.setEditable(false);
        tf4.setBounds(220,340,120,30);
        add(tf4);
        
        JLabel internet1 = new JLabel("Internet Banking :");
        internet1.setFont(new Font("Bodoni MT",Font.BOLD,22));
        internet1.setBounds(450,340,170,30);
        add(internet1);
        if(internet!=null && !internet.equals("")) {
        	tf5= new TextField("Selected");
        }else {
        	tf5= new TextField("Rejected");
        }
        tf5.setFont(new Font("Raleway",Font.BOLD,17));
        tf5.setEditable(false);
        tf5.setBounds(630,340,120,30);
        add(tf5);
        
        JLabel cheque1 = new JLabel("Cheque Book :");
        cheque1.setFont(new Font("Bodoni MT",Font.BOLD,22));
        cheque1.setBounds(70,390,150,30);
        add(cheque1);
        if(cheque!=null && cheque.equals("")) {
        	tf6= new TextField("Selected");
        }else {
        	tf6= new TextField("Rejected");
        }
        tf6.setFont(new Font("Raleway",Font.BOLD,17));
        tf6.setEditable(false);
        tf6.setBounds(220,390,120,30);
        add(tf6);
        
        JLabel e1 = new JLabel("E-Statement :");
        e1.setFont(new Font("Bodoni MT",Font.BOLD,22));
        e1.setBounds(450,390,170,30);
        add(e1);
        if(es!=null && !es.equals("")) {
        	tf7= new TextField("Selected");
        }else {
        	tf7= new TextField("Rejected");
        }
        tf7.setFont(new Font("Raleway",Font.BOLD,17));
        tf7.setEditable(false);
        tf7.setBounds(630,390,120,30);
        add(tf7);
        
        JLabel mobile1 = new JLabel("Mobile Banking :");
        mobile1.setFont(new Font("Bodoni MT",Font.BOLD,22));
        mobile1.setBounds(60,440,160,30);
        add(mobile1);
        if(mobile!=null && mobile.equals("")) {
        	tf8= new TextField("Selected");
        }else {
        	tf8= new TextField("Rejected");
        }
        tf8.setFont(new Font("Raleway",Font.BOLD,17));
        tf8.setEditable(false);
        tf8.setBounds(220,440,120,30);
        add(tf8);
        
        JLabel ea1 = new JLabel("Email Alert :");
        ea1.setFont(new Font("Bodoni MT",Font.BOLD,22));
        ea1.setBounds(450,440,170,30);
        add(ea1);
        if(ea!=null && !ea.equals("")) {
        	tf9= new TextField("Selected");
        }else {
        	tf9= new TextField("Rejected");
        }
        tf9.setFont(new Font("Raleway",Font.BOLD,17));
        tf9.setEditable(false);
        tf9.setBounds(630,440,120,30);
        add(tf9);
        
        JLabel know1 = new JLabel("(This page doesn't have edit option)");
    	know1.setFont(new Font("Raleway",Font.BOLD,17));
    	know1.setBounds(500,490,300,30);
    	add(know1);
		
        c1 = new JCheckBox("I here by decleares that the above entered details correct to the best of my");
    	c1.setBackground(new Color(157, 166, 167));
    	c1.setFont(new Font("Raleway",Font.BOLD,17));
    	c1.setBounds(70,550,700,30);
    	add(c1);
    	
    	JLabel know = new JLabel("knowlege.");
    	know.setFont(new Font("Raleway",Font.BOLD,17));
    	know.setBounds(70,570,700,30);
    	add(know);
    	
    	cancel = new JButton("Cancel");
    	cancel.setFont(new Font("Bodoni MT",Font.BOLD,17));
    	cancel.setBackground(Color.BLACK);
    	cancel.setForeground(Color.WHITE);
    	cancel.setBounds(70, 625, 100, 30);
        add(cancel);
    	button = new JButton("Submit");
        button.setFont(new Font("Bodoni MT",Font.BOLD,17));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setBounds(650, 625, 100, 30);
        button.setEnabled(false);
        add(button);
        cancel.addActionListener((ActionListener) this); 
        button.addActionListener((ActionListener) this);
        
        c1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    button.setEnabled(true); 
                } else {
                    button.setEnabled(false); 
                }
            }
        });
    	
		getContentPane().setBackground(new Color(157, 166, 167));
	    setLayout(null);
	    setSize(850, 750);
	    setLocation(250, 0);
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancel) {
			int choice=JOptionPane.showConfirmDialog(null,"Do you want to Cancel this Data?","Confirmation",JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION) {
				try {
					String query = "DELETE FROM signup WHERE aadhar = ?";
					String query1 = "DELETE FROM signup2 WHERE aadhar = ?";
					String query2 = "DELETE FROM signup3 WHERE aadhar = ?";
				    
				    ps = connection.prepareStatement(query);
				    ps.setString(1, aadhar);
				    ps.executeUpdate();
				    
				    ps = connection.prepareStatement(query1);
				    ps.setString(1, aadhar);
				    ps.executeUpdate();
				    
				    ps = connection.prepareStatement(query2);
				    ps.setString(1, aadhar);
				    ps.executeUpdate();
				    
				    ps.close();
				    connection.close();
				    st.close();
				    
				    setVisible(false);
				    new atm();
				} catch (SQLException e1) {
				    e1.printStackTrace();
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
		if (e.getSource() == button) {
			int choice=JOptionPane.showConfirmDialog(null,"Do you want to Submit this Data?","Confirmation",JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION) {
				setVisible(false);
				new deposit(pin);
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
	public static void main(String arg[]) throws SQLException {
		new final_form2(aadhar);
	}
}
