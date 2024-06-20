package Application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class LoginPage {

	String uname=null,password=null;
	int ok=0;
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage() {
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enjoy Your Booking");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 10, 416, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(77, 71, 86, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(77, 103, 86, 22);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel(":");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(187, 71, 15, 22);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel(":");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(187, 103, 15, 22);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField.setBounds(213, 71, 157, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		passwordField.setBounds(212, 103, 158, 22);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uname = textField.getText();
				password = String.valueOf(passwordField.getPassword());
				if(uname.equals("")) {
					JOptionPane.showMessageDialog(frame, "Warning: 'Username' is Mandatory");
				}
				else if(password.equals("")) {
					JOptionPane.showMessageDialog(frame, "Warning: 'Password' is Mandatory");
				}
				else {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customermovieticketsbooking", "root", "");
						Statement stmt = con.createStatement();
						String qry = "select * from customerlogin";
						ResultSet rs = stmt.executeQuery(qry);
						while(rs.next()) {
							if(uname.equalsIgnoreCase(rs.getString(1)) && password.equals((rs.getString(2)))) {
								ok=1;
								break;
							}
						}
						if(ok==1) {
							stmt.close();
							con.close();
							JOptionPane.showMessageDialog(frame, "Login Successfully");
							MoviesListPage mlp = new MoviesListPage();
							frame.dispose();
						}
						else {
							JOptionPane.showMessageDialog(frame, "Login Unsuccessfully");
							textField.setText(null);
							passwordField.setText(null);
						}
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnNewButton.setBounds(117, 155, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnClear.setBounds(258, 155, 85, 21);
		frame.getContentPane().add(btnClear);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpPage sup = new SignUpPage();
				frame.dispose();
			}
		});
		btnSignUp.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnSignUp.setBounds(187, 218, 85, 21);
		frame.getContentPane().add(btnSignUp);
		
		JLabel lblNewLabel_1_3 = new JLabel("Didn't had Account? Create with below Button");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(10, 186, 416, 22);
		frame.getContentPane().add(lblNewLabel_1_3);
		//frame.setVisible(true);
	}
}
