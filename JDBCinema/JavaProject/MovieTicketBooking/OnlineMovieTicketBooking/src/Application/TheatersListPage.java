package Application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class TheatersListPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheatersListPage window = new TheatersListPage("Gunturu Karam");
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
	public TheatersListPage(String movieName) {
		initialize(movieName);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */


	
	private void initialize(String movieName) {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nithi\\OneDrive\\Desktop\\movie-icon.jpg"));
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Theaters List");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 10, 416, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTheaterName = new JLabel("Theater Name:- ");
		lblTheaterName.setForeground(new Color(255, 255, 255));
		lblTheaterName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheaterName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTheaterName.setBounds(10, 49, 416, 19);
		frame.getContentPane().add(lblTheaterName);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MoviesListPage mlp = new MoviesListPage();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnNewButton.setBounds(167, 532, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		/*JButton theaterName = new JButton("");
		theaterName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		theaterName.setBounds(10, 78, 416, 28);
		frame.getContentPane().add(theaterName);*/
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customermovieticketsbooking", "root", "");
			Statement stmt = con.createStatement();
			String qry = "select * from movies";
			ResultSet rs = stmt.executeQuery(qry);
			String line = null;
			while(rs.next()) {
				if(movieName.equalsIgnoreCase(rs.getString(1))) {
					line = rs.getString(2);
					break;
				}
			}
			String[] arr = line.split(", ");
			//System.out.println(line);
			int y=80;
			for(int i=0;i<arr.length;i++) {
				String var = arr[i];
				JButton theaterName = new JButton(var);
				theaterName.setFont(new Font("Times New Roman", Font.BOLD, 16));
				theaterName.setBounds(10, y, 416, 28);
				frame.getContentPane().add(theaterName);
				theaterName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String label = "Theater Name:- "+var;
						lblTheaterName.setText(label);
						TimingsPage tp = new TimingsPage(movieName,var);
						frame.dispose();
					}
				});
				y+=30;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\nithi\\Downloads\\Create a visual 0 (2) (1).png"));
		lblNewLabel_1.setBounds(0, 0, 436, 563);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
