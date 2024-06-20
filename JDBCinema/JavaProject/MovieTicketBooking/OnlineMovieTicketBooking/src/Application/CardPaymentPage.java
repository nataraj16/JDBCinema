package Application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class CardPaymentPage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardPaymentPage window = new CardPaymentPage();
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
	public CardPaymentPage() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nithi\\OneDrive\\Desktop\\movie-icon.jpg"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToCard = new JLabel("Welcome to Card Payment Process");
		lblWelcomeToCard.setForeground(new Color(255, 255, 255));
		lblWelcomeToCard.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToCard.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblWelcomeToCard.setBounds(10, 10, 416, 50);
		frame.getContentPane().add(lblWelcomeToCard);
		
		JLabel lblEnterYourCard = new JLabel("Enter Card Number:-");
		lblEnterYourCard.setForeground(new Color(255, 255, 255));
		lblEnterYourCard.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterYourCard.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblEnterYourCard.setBounds(20, 109, 190, 29);
		frame.getContentPane().add(lblEnterYourCard);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(220, 113, 190, 23);
		frame.getContentPane().add(textField);
		
		JLabel lblEnterCardExpiry = new JLabel("Enter Card Expiry Date:-");
		lblEnterCardExpiry.setForeground(new Color(255, 255, 255));
		lblEnterCardExpiry.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterCardExpiry.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblEnterCardExpiry.setBounds(20, 148, 190, 29);
		frame.getContentPane().add(lblEnterCardExpiry);
		
		JLabel lblEnterCvvNumber = new JLabel("Enter CVV Number:-");
		lblEnterCvvNumber.setForeground(new Color(255, 255, 255));
		lblEnterCvvNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterCvvNumber.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblEnterCvvNumber.setBounds(20, 187, 190, 29);
		frame.getContentPane().add(lblEnterCvvNumber);
		
		JLabel lblEnterCardHolder = new JLabel("Enter Card Holder Name:-");
		lblEnterCardHolder.setForeground(new Color(255, 255, 255));
		lblEnterCardHolder.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterCardHolder.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblEnterCardHolder.setBounds(20, 70, 190, 29);
		frame.getContentPane().add(lblEnterCardHolder);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(220, 152, 190, 23);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(220, 191, 190, 23);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(220, 70, 190, 23);
		frame.getContentPane().add(textField_3);
		
		JButton btnNewButton = new JButton("Proceed");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EndingPage ep = new EndingPage();
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		btnNewButton.setBounds(159, 224, 110, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nithi\\Downloads\\Create a visual 1 (2) (1).png"));
		lblNewLabel.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(lblNewLabel);
	}

}
