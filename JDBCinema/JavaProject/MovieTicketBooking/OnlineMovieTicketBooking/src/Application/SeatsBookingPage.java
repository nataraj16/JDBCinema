package Application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;

public class SeatsBookingPage {

	int totalNumberOfBookings=0,totalSelectedSeats=0,bookingInd=-1,totalAmount=0,removedInd=-1;
	int[] removedSeat = new int[4];
	String[] bookings = new String[4];
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeatsBookingPage window = new SeatsBookingPage("Leo","Asian Sridevi Mall","29-10-2023");
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
	public SeatsBookingPage(String movieName,String theaterName,String bookingDate) {
		initialize(movieName,theaterName,bookingDate);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String movieName,String theaterName,String bookingDate) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 0, 0));
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enjoy With Your Seats");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 766, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Number of Seats to Book:- ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(208, 59, 272, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("0");
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.setBounds(485, 60, 54, 21);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Proceed to Payment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(totalSelectedSeats==0) {
					JOptionPane.showMessageDialog(frame, "Warning: You Have to Select Seats First");
				}
				else if(totalSelectedSeats!=totalNumberOfBookings) {
					String warn="Warning: Still You can Select "+(Integer.toString(totalNumberOfBookings-totalSelectedSeats))+" Seats";
					JOptionPane.showMessageDialog(frame, warn);
				}
				else {
					String[] finalBookings = new String[totalNumberOfBookings];
					int index=0;
					for(int i=0;i<bookings.length;i++) {
						if(bookings[i] != null && index<totalNumberOfBookings) {
							finalBookings[index]=bookings[i];
							System.out.println(finalBookings[index]+" "+index);
							index++;
						}
					}
					Arrays.sort(finalBookings);
					String res="Your Booking Seats:- ";
					for(int i=0;i<totalNumberOfBookings;i++) {
						res+="\n"+finalBookings[i];
					}
					res+="\nTotol Amount Only for Seats Booking (Excluding Tax, etc....):- "+totalAmount+" Rs.";
					JOptionPane.showMessageDialog(frame, res);
					BillReportPage brp = new BillReportPage(movieName,theaterName,totalNumberOfBookings,finalBookings,totalAmount,bookingDate);
					frame.dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBounds(283, 622, 222, 31);
		frame.getContentPane().add(btnNewButton);
		
		JLabel amountUpdate = new JLabel("Amount for the Select Number of Seats to Book:- '0' rs.");
		amountUpdate.setForeground(new Color(255, 255, 255));
		amountUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		amountUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		amountUpdate.setBounds(10, 577, 766, 22);
		frame.getContentPane().add(amountUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimingsPage tp = new TimingsPage(movieName, theaterName);
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnBack.setBounds(21, 622, 134, 31);
		frame.getContentPane().add(btnBack);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totalNumberOfBookings = Integer.parseInt((String) comboBox.getSelectedItem());
			}
		});
		
		
		int seatX=45,seatY=90+30;
		char var='A';
		String rowName;
		for(int i=0;i<14;i++) {
			seatX=45;
			for(int j=0;j<24;j++) {
				rowName=Character.toString((char) (var+i))+" "+Integer.toString(j+1);
				JCheckBox chckbxNewCheckBox = new JCheckBox();
				chckbxNewCheckBox.setBounds(seatX, seatY, 21, 21);
				frame.getContentPane().add(chckbxNewCheckBox);
				chckbxNewCheckBox.setText(rowName);
				chckbxNewCheckBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customermovieticketsbooking", "root", "");
							Statement stmt = con.createStatement();
							String qry = "select Amount from theaters where movie_name='"+movieName+"' and theater_name='"+theaterName+"'";
							ResultSet rs = stmt.executeQuery(qry);
							rs.next();
							if(chckbxNewCheckBox.isSelected()) {
								if(totalNumberOfBookings==0) {
									JOptionPane.showMessageDialog(frame, "Warning: You Must Select Total Number of Booking First.\n(\"Value Should Be Greater Than 0 and Less Than 5\")");
									chckbxNewCheckBox.setSelected(false);
								}
								else if(totalNumberOfBookings==totalSelectedSeats) {
									chckbxNewCheckBox.setSelected(false);
									JOptionPane.showMessageDialog(frame, "Warning: You Have Reached Your Booking Limit");
								}
								else {
									totalSelectedSeats++;
									if(removedInd==-1) {
										bookingInd++;
										bookings[bookingInd]=chckbxNewCheckBox.getText();
									}
									else {
										bookings[removedSeat[removedInd]]=chckbxNewCheckBox.getText();
										removedInd--;
									}
									totalAmount+=Integer.parseInt((String)rs.getString(1));
									String text = "Amount for the Select Number of Seats to Book:- '"+Integer.toString(totalAmount)+"' rs.";
									amountUpdate.setText(text);
								}
							}
							else {
								bookingInd--;
								totalSelectedSeats--;
								String unWantSeat=chckbxNewCheckBox.getText();
								for(int i=0;i<bookings.length;i++) {
									if(unWantSeat.equalsIgnoreCase(bookings[i])) {
										removedInd++;
										removedSeat[removedInd]=i;
										bookings[i]=null;
										break;
									}
								}
								totalAmount-=Integer.parseInt((String)rs.getString(1));
								String text = "Amount for the Select Number of Seats to Book:- '"+Integer.toString(totalAmount)+"' rs.";
								amountUpdate.setText(text);
							}
							
						}
						catch(Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				seatX=seatX+30;
			}
			seatY=seatY+30;
		}
		
		/*JLabel lblNum = new JLabel("1");
		lblNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNum.setBounds(51, 59, 21, 29);
		frame.getContentPane().add(lblNum);*/
		
		int x=50;
		for(int i=0;i<24;i++) {
			int num=i+1;
			JLabel lblNum = new JLabel(Integer.toString(num));
			lblNum.setForeground(new Color(255, 255, 255));
			lblNum.setHorizontalAlignment(SwingConstants.CENTER);
			lblNum.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblNum.setBounds(x, 90, 15, 20);
			frame.getContentPane().add(lblNum);
			x=x+30;
		}
		
		/*JLabel lblAlpha = new JLabel("A");
		lblAlpha.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlpha.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAlpha.setBounds(10, 113, 21, 29);
		frame.getContentPane().add(lblAlpha);*/
		
		int y=90+30;
		var='A';
		for(int i=0;i<14;i++) {
			JLabel lblAlpha = new JLabel(Character.toString((char) (var+i)));
			lblAlpha.setForeground(new Color(255, 255, 255));
			lblAlpha.setHorizontalAlignment(SwingConstants.CENTER);
			lblAlpha.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblAlpha.setBounds(10, y, 15, 25);
			frame.getContentPane().add(lblAlpha);
			y=y+30;
		}
	}
}
