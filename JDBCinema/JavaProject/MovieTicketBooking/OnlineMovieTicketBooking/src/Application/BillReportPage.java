package Application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class BillReportPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String[] bookings = new String[] {"C 22","C 21","C 24"};
					BillReportPage window = new BillReportPage("Leo","Asian Sridevi Mall",3,bookings,900,"29-10-2023");
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
	public BillReportPage(String movieName,String theaterName,int totalNumberOfBookings,String[] bookings,int totalAmount,String bookingDate) {
		initialize(movieName,theaterName,totalNumberOfBookings,bookings,totalAmount,bookingDate);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String movieName,String theaterName,int totalNumberOfBookings,String[] bookings,int totalAmount,String bookingDate) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 0, 0));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nithi\\OneDrive\\Desktop\\movie-icon.jpg"));
		frame.setBounds(100, 100, 450, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Final Bill Report");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 416, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblMovieName = new JLabel("Movie Name:- "+movieName);
		lblMovieName.setForeground(new Color(255, 255, 255));
		lblMovieName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblMovieName.setBounds(10, 55, 416, 28);
		frame.getContentPane().add(lblMovieName);
		
		JLabel lblTheaterName = new JLabel("Theater Name:- "+theaterName);
		lblTheaterName.setForeground(new Color(255, 255, 255));
		lblTheaterName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheaterName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblTheaterName.setBounds(10, 93, 416, 28);
		frame.getContentPane().add(lblTheaterName);
		
		JLabel lblSeatsYouHave = new JLabel("Seats You Have Booked are given below:- ");
		lblSeatsYouHave.setForeground(new Color(255, 255, 255));
		lblSeatsYouHave.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeatsYouHave.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblSeatsYouHave.setBounds(10, 202, 416, 28);
		frame.getContentPane().add(lblSeatsYouHave);
		
		int y=240;
		for(int i=0;i<bookings.length;i++) {
			JLabel lblSeatingNumbers = new JLabel(bookings[i]);
			lblSeatingNumbers.setForeground(new Color(0, 0, 0));
			lblSeatingNumbers.setBackground(new Color(255,255,255));
			lblSeatingNumbers.setVerticalAlignment(SwingConstants.TOP);
			lblSeatingNumbers.setHorizontalAlignment(SwingConstants.CENTER);
			lblSeatingNumbers.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			lblSeatingNumbers.setBounds(10, y, 416, 25);
			frame.getContentPane().add(lblSeatingNumbers);
			y=y+25;
		}
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChoosePayment cp = new ChoosePayment(totalAmount,bookingDate);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBounds(286, 401, 101, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeatsBookingPage sbp = new SeatsBookingPage(movieName,theaterName,bookingDate);
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnBack.setBounds(50, 401, 101, 35);
		frame.getContentPane().add(btnBack);
		
		JLabel lblTotalSeats = new JLabel("Total Number Of Seats Booked:- "+totalNumberOfBookings);
		lblTotalSeats.setForeground(new Color(255, 255, 255));
		lblTotalSeats.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalSeats.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblTotalSeats.setBounds(10, 164, 416, 28);
		frame.getContentPane().add(lblTotalSeats);
		
		JLabel lblAmount = new JLabel("Total Amount To Be Paid:- "+totalAmount);
		lblAmount.setForeground(new Color(255, 255, 255));
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblAmount.setBounds(10, 363, 416, 28);
		frame.getContentPane().add(lblAmount);
		
		JLabel lblDate = new JLabel("Date:- "+bookingDate);
		lblDate.setForeground(new Color(255, 255, 255));
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblDate.setBounds(10, 131, 416, 28);
		frame.getContentPane().add(lblDate);
	}

}
