package Application;

import java.awt.EventQueue;
import java.text.*;
import java.time.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class TimingsPage {

	private JFrame frame;
	long daysDifference=0;
	String d1,line,bookingDate=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimingsPage window = new TimingsPage("Jawan","PVR cinema");
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
	public TimingsPage(String movieName,String theaterName) {
		initialize(movieName,theaterName);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String movieName,String theaterName) {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nithi\\OneDrive\\Desktop\\movie-icon.jpg"));
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mark your Date and Time");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 10, 416, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date:-");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(51, 83, 77, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customermovieticketsbooking", "root", "");
			Statement stmt = con.createStatement();
			String qry = "select * from theaters";
			ResultSet rs = stmt.executeQuery(qry);
			while(rs.next()) {
				if(movieName.equalsIgnoreCase(rs.getString(2)) && theaterName.equalsIgnoreCase(rs.getString(1))) {
					d1 = rs.getString(4);
					line = rs.getString(3);
					break;
				}
			}
			//Converting String to date
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date = null;
	        try {
	            date = dateFormat.parse(d1);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
			//Finding Difference between the today and last date
			Date today1 = new Date();
			long difference = date.getTime() - today1.getTime(); 
            daysDifference = difference / (24 * 60 * 60 * 1000);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		JComboBox<LocalDate> comboBox = new JComboBox<LocalDate>();
		comboBox.setBounds(153, 85, 149, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel lblDateTime = new JLabel("Date & Time:- ");
		lblDateTime.setForeground(new Color(255, 255, 255));
		lblDateTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateTime.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDateTime.setBounds(10, 51, 416, 22);
		frame.getContentPane().add(lblDateTime);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TheatersListPage tlp = new TheatersListPage(movieName);
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnBack.setBounds(181, 532, 85, 21);
		frame.getContentPane().add(btnBack);
		
		//Adding dates to comboBox
		LocalDate today = LocalDate.now();
		comboBox.addItem(null);
		comboBox.addItem(today);
        for(int i=1;i<=daysDifference+1;i++) {
        	LocalDate nextDays = today.plusDays(i);
        	comboBox.addItem(nextDays);
        }
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookingDate = String.valueOf(comboBox.getSelectedItem());
			}
		});
		
		int y=130;
		String[] arr = line.split(", ");
		for(int i=0;i<arr.length;i++) {
			String timing = arr[i];
			JButton timingBtn = new JButton(timing);
			timingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(bookingDate==null || bookingDate.equals("null")) {
						JOptionPane.showMessageDialog(frame, "Warning: 'Date' is Mandatory");
					}
					else {
						String var = "Date & Time:- "+bookingDate+" & "+timing;
						lblDateTime.setText(var);
						SeatsBookingPage sbp = new SeatsBookingPage(movieName,theaterName,bookingDate);
						frame.dispose();
					}
				}
			});
			timingBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			timingBtn.setBounds(10, y, 416, 28);
			frame.getContentPane().add(timingBtn);
			y=y+30;
		}
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("C:\\Users\\nithi\\Downloads\\Create a visual 1 (7) (1).png"));
		lblImage.setBounds(0, 0, 436, 563);
		frame.getContentPane().add(lblImage);
	}
}
