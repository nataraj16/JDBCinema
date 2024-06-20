package Application;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class SignUpPage {

	String uname=null,password=null,name=null,email=null,mobile=null,gender=null,warning=null;
	int ok=0,un=0,mob=0;
	private JFrame frame;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField mobileField;
	private JTextField unameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPage window = new SignUpPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUpPage() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nithi\\OneDrive\\Desktop\\movie-icon.jpg"));
		frame.getContentPane().setBackground(new Color(255, 0, 0));
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Online Booking System");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 866, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(305, 98, 89, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email ID");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(305, 129, 89, 23);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mobile");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(305, 162, 89, 23);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Gender");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(305, 195, 89, 23);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Username");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(305, 228, 89, 23);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Password");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_5.setBounds(305, 261, 89, 23);
		frame.getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_2_1 = new JLabel(":");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(416, 98, 15, 22);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel(":");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1.setBounds(416, 131, 15, 22);
		frame.getContentPane().add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel(":");
		lblNewLabel_1_2_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_2_1_2.setBounds(416, 164, 15, 22);
		frame.getContentPane().add(lblNewLabel_1_2_1_2);
		
		JLabel lblNewLabel_1_2_1_3 = new JLabel(":");
		lblNewLabel_1_2_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_2_1_3.setBounds(416, 197, 15, 22);
		frame.getContentPane().add(lblNewLabel_1_2_1_3);
		
		JLabel lblNewLabel_1_2_1_4 = new JLabel(":");
		lblNewLabel_1_2_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_2_1_4.setBounds(416, 230, 15, 22);
		frame.getContentPane().add(lblNewLabel_1_2_1_4);
		
		JLabel lblNewLabel_1_2_1_5 = new JLabel(":");
		lblNewLabel_1_2_1_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_2_1_5.setBounds(416, 262, 15, 22);
		frame.getContentPane().add(lblNewLabel_1_2_1_5);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		nameField.setColumns(10);
		nameField.setBounds(461, 96, 157, 22);
		frame.getContentPane().add(nameField);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		emailField.setColumns(10);
		emailField.setBounds(461, 129, 157, 22);
		frame.getContentPane().add(emailField);
		
		mobileField = new JTextField();
		mobileField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mobileField.setColumns(10);
		mobileField.setBounds(461, 162, 157, 22);
		frame.getContentPane().add(mobileField);
		
		unameField = new JTextField();
		unameField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		unameField.setColumns(10);
		unameField.setBounds(461, 228, 157, 22);
		frame.getContentPane().add(unameField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		passwordField.setBounds(461, 261, 158, 22);
		frame.getContentPane().add(passwordField);
		
		JRadioButton maleRadioBtn = new JRadioButton("Male");
		maleRadioBtn.setBackground(new Color(255, 0, 0));
		maleRadioBtn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		maleRadioBtn.setBounds(461, 197, 68, 21);
		frame.getContentPane().add(maleRadioBtn);
		
		JRadioButton femaleRadioBtn = new JRadioButton("Female");
		femaleRadioBtn.setBackground(new Color(255, 0, 0));
		femaleRadioBtn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		femaleRadioBtn.setBounds(531, 197, 83, 21);
		frame.getContentPane().add(femaleRadioBtn);
		
		maleRadioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "Male";
				femaleRadioBtn.setSelected(false);
			}
		});
		
		femaleRadioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "Female";
				maleRadioBtn.setSelected(false);
			}
		});
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnSignUp.setBounds(328, 321, 85, 21);
		frame.getContentPane().add(btnSignUp);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unameField.setText(null);
				passwordField.setText(null);
				nameField.setText(null);
				mobileField.setText(null);
				emailField.setText(null);
				maleRadioBtn.setSelected(false);
				femaleRadioBtn.setSelected(false);
				gender = null;
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnClear.setBounds(511, 321, 85, 21);
		frame.getContentPane().add(btnClear);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage lp = new LoginPage();
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnNewButton.setBounds(398, 411, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Already had Account? Then Login");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_3_1.setBounds(10, 375, 866, 22);
		frame.getContentPane().add(lblNewLabel_1_3_1);
		
		warning = "Warning: All fields with '*' are mandatory";
		JLabel warningLabel = new JLabel(warning);
		warningLabel.setForeground(new Color(255, 255, 255));
		warningLabel.setHorizontalAlignment(SwingConstants.CENTER);
		warningLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		warningLabel.setBounds(10, 56, 866, 23);
		frame.getContentPane().add(warningLabel);
		
		JLabel lblNewLabel_1_6 = new JLabel("*");
		lblNewLabel_1_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_6.setBounds(391, 98, 15, 23);
		frame.getContentPane().add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("*");
		lblNewLabel_1_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_6_1.setForeground(Color.WHITE);
		lblNewLabel_1_6_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_6_1.setBounds(391, 129, 15, 23);
		frame.getContentPane().add(lblNewLabel_1_6_1);
		
		JLabel lblNewLabel_1_6_2 = new JLabel("*");
		lblNewLabel_1_6_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_6_2.setForeground(Color.WHITE);
		lblNewLabel_1_6_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_6_2.setBounds(391, 162, 15, 23);
		frame.getContentPane().add(lblNewLabel_1_6_2);
		
		JLabel lblNewLabel_1_6_3 = new JLabel("*");
		lblNewLabel_1_6_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_6_3.setForeground(Color.WHITE);
		lblNewLabel_1_6_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_6_3.setBounds(391, 195, 15, 23);
		frame.getContentPane().add(lblNewLabel_1_6_3);
		
		JLabel lblNewLabel_1_6_4 = new JLabel("*");
		lblNewLabel_1_6_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_6_4.setForeground(Color.WHITE);
		lblNewLabel_1_6_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_6_4.setBounds(391, 228, 15, 23);
		frame.getContentPane().add(lblNewLabel_1_6_4);
		
		JLabel lblNewLabel_1_6_5 = new JLabel("*");
		lblNewLabel_1_6_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_6_5.setForeground(Color.WHITE);
		lblNewLabel_1_6_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_6_5.setBounds(391, 261, 15, 23);
		frame.getContentPane().add(lblNewLabel_1_6_5);
		
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customermovieticketsbooking", "root", "");
					Statement stmt = con.createStatement();
					name = nameField.getText();
					email = emailField.getText();
					mobile = mobileField.getText();
					uname = unameField.getText();
					password = String.valueOf(passwordField.getPassword());
					if(name.equals("")) {
						JOptionPane.showMessageDialog(frame, "Warning: 'Name' is Mandatory");
					}
					else if(email.equals("")) {
						JOptionPane.showMessageDialog(frame, "Warning: 'Email ID' is Mandatory");
					}
					else if(mobile.equals("")) {
						JOptionPane.showMessageDialog(frame, "Warning: 'Mobile Number' is Mandatory");
					}
					else if(uname.equals("")) {
						JOptionPane.showMessageDialog(frame, "Warning: 'Username' is Mandatory");
					}
					else if(password.equals("")) {
						JOptionPane.showMessageDialog(frame, "Warning: 'Password' is Mandatory");
					}
					else if(gender.equals("")) {
						JOptionPane.showMessageDialog(frame, "Warning: 'Gender' is Mandatory");
					}
					else {
						String qry = "select * from customerlogin";
						ResultSet rs = stmt.executeQuery(qry);
						while(rs.next()) {
							un=0;
							mob=0;
							if(uname.equals(rs.getString(1))) {
								un=1;
								break;
							}
							if(mobile.equals(rs.getString(6))) {
								mob=1;
								break;
							}
						}
						if(un==1) {
							JOptionPane.showMessageDialog(frame, "Warning: 'Username' is Already Taken");
						}
						else if(mob==1) {
							JOptionPane.showMessageDialog(frame, "Warning: 'Mobile Number' is Already Taken");
						}
						else {
							ok=1;
						}
					}
					if(ok==1) {
						String sql = "insert into customerlogin values ('"+uname+"','"+password+"', '"+name+"', '"+gender+"','"+email+"', '"+mobile+"')";
						stmt.executeUpdate(sql);
						stmt.close();
						con.close();
						JOptionPane.showMessageDialog(frame, "Registration Completed Successfully");
						LoginPage lp = new LoginPage();
						frame.dispose();
					}
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}
}
