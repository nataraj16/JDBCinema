package Application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class UPIPaymentPage {

	private JFrame frame;
	private JTextField upiField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UPIPaymentPage window = new UPIPaymentPage("");
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
	public UPIPaymentPage(String text) {
		initialize(text);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String text) {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nithi\\OneDrive\\Desktop\\movie-icon.jpg"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to UPI Payment Process");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(10, 10, 416, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEnterYourUpi = new JLabel("Enter Your UPI ID:-");
		lblEnterYourUpi.setForeground(new Color(255, 255, 255));
		lblEnterYourUpi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterYourUpi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblEnterYourUpi.setBounds(10, 125, 190, 29);
		frame.getContentPane().add(lblEnterYourUpi);
		
		upiField = new JTextField();
		upiField.setBounds(210, 129, 190, 23);
		frame.getContentPane().add(upiField);
		upiField.setColumns(10);
		
		JButton btnNewButton = new JButton("Proceed");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EndingPage ep = new EndingPage();
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		btnNewButton.setBounds(149, 192, 110, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblMsg = new JLabel(text);
		lblMsg.setForeground(new Color(255, 255, 255));
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblMsg.setBounds(10, 70, 416, 23);
		frame.getContentPane().add(lblMsg);
		
		JLabel lblMsg2 = new JLabel("via UPI Payment Only!");
		lblMsg2.setForeground(new Color(255, 255, 255));
		lblMsg2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblMsg2.setBounds(10, 103, 416, 23);
		frame.getContentPane().add(lblMsg2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\nithi\\Downloads\\Create a visual 1 (2) (1).png"));
		lblNewLabel_1.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(lblNewLabel_1);
		
	}
}
