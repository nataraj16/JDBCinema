package Application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.UIClientPropertyKey;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ChoosePayment {

	String paymentMethod="null";
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoosePayment window = new ChoosePayment(400,"29-10-2023");
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
	public ChoosePayment(int totalAmount,String bookingDate) {
		initialize(totalAmount,bookingDate);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int totalAmount,String bookingDate) {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nithi\\OneDrive\\Desktop\\movie-icon.jpg"));
		frame.setBounds(100, 100, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pay");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 10, 516, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("&");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_1.setBounds(10, 40, 516, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblEnjoyYourDay = new JLabel("Enjoy Your Day");
		lblEnjoyYourDay.setForeground(new Color(255, 255, 255));
		lblEnjoyYourDay.setVerticalAlignment(SwingConstants.TOP);
		lblEnjoyYourDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnjoyYourDay.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblEnjoyYourDay.setBounds(10, 70, 516, 29);
		frame.getContentPane().add(lblEnjoyYourDay);
		
		JLabel lblDate = new JLabel(bookingDate);
		lblDate.setForeground(new Color(255, 255, 255));
		lblDate.setVerticalAlignment(SwingConstants.TOP);
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblDate.setBounds(10, 100, 516, 29);
		frame.getContentPane().add(lblDate);
		
		JRadioButton upiRadioBtn = new JRadioButton("UPI Payment");
		upiRadioBtn.setForeground(new Color(0, 0, 0));
		upiRadioBtn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		upiRadioBtn.setBounds(24, 197, 121, 34);
		frame.getContentPane().add(upiRadioBtn);
		
		JRadioButton bankRadioBtn = new JRadioButton("Cash Payment At Theater");
		bankRadioBtn.setForeground(new Color(0, 0, 0));
		bankRadioBtn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		bankRadioBtn.setBounds(157, 197, 192, 34);
		frame.getContentPane().add(bankRadioBtn);
		
		JRadioButton cardRadioBtn = new JRadioButton("Debit or Credit Card");
		cardRadioBtn.setForeground(new Color(0, 0, 0));
		cardRadioBtn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cardRadioBtn.setBounds(365, 197, 161, 34);
		frame.getContentPane().add(cardRadioBtn);
		
		JButton btnNewButton = new JButton("Proceed");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(paymentMethod.equals("null")) {
					JOptionPane.showMessageDialog(frame, "Warning:- Select a Payment Method to Proceed further");
				}
				else {
					JOptionPane.showMessageDialog(frame, "Your Payment Method is "+paymentMethod);
					if(paymentMethod.equalsIgnoreCase("UPI Payment")) {
						UPIPaymentPage upi = new UPIPaymentPage("");
						frame.dispose();
					}
					else if(paymentMethod.equalsIgnoreCase("Card Payment")) {
						CardPaymentPage cpp = new CardPaymentPage();
						frame.dispose();
					}
					else {
						UPIPaymentPage cupi = new UPIPaymentPage("Pay Some Fee To the Theater for Holding Your Seats");
						frame.dispose();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBounds(186, 270, 161, 34);
		frame.getContentPane().add(btnNewButton);
		
		upiRadioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(upiRadioBtn.isSelected()) {
					paymentMethod = "UPI Payment";
					bankRadioBtn.setSelected(false);
					cardRadioBtn.setSelected(false);
				}
				else {
					paymentMethod="null";
				}
			}
		});
		bankRadioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bankRadioBtn.isSelected()) {
					paymentMethod = "Cash Payment";
					upiRadioBtn.setSelected(false);
					cardRadioBtn.setSelected(false);
				}
				else {
					paymentMethod="null";
				}
			}
		});
		cardRadioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardRadioBtn.isSelected()) {
					paymentMethod = "Card Payment";
					upiRadioBtn.setSelected(false);
					bankRadioBtn.setSelected(false);
				}
				else {
					paymentMethod="null";
				}
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\nithi\\Downloads\\Create a visual 0 (3) (2).png"));
		lblNewLabel_2.setBounds(0, 0, 536, 363);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
