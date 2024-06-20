package Application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MoviesListPage {

	int count=0;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoviesListPage window = new MoviesListPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public MoviesListPage() throws ClassNotFoundException, SQLException {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nithi\\OneDrive\\Desktop\\movie-icon.jpg"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Movies List");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 416, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel movieSelection = new JLabel("Movie Name:- ");
		movieSelection.setForeground(new Color(255, 255, 255));
		movieSelection.setHorizontalAlignment(SwingConstants.CENTER);
		movieSelection.setFont(new Font("Times New Roman", Font.BOLD, 16));
		movieSelection.setBounds(10, 47, 416, 16);
		frame.getContentPane().add(movieSelection);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage lp = new LoginPage();
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnBack.setBounds(183, 232, 85, 21);
		frame.getContentPane().add(btnBack);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customermovieticketsbooking", "root", "");
			Statement stmt = con.createStatement();
			String qry = "select * from movies";
			ResultSet rs = stmt.executeQuery(qry);
			int y=70;
			while(rs.next()) {
				String movieName = rs.getString(1);
				JButton movie_1 = new JButton(movieName);
				movie_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
				movie_1.setBounds(10, y, 416, 27);
				frame.getContentPane().add(movie_1);
				y=y+30;
				movie_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String var = "Movie Name:- "+movieName;
						movieSelection.setText(var);
						JOptionPane.showMessageDialog(frame, var);
						TheatersListPage tlp = new TheatersListPage(movieName);
						frame.dispose();
					}
				});
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		JLabel lblBackGround = new JLabel("");
		lblBackGround.setIcon(new ImageIcon("C:\\Users\\nithi\\Downloads\\Create a visual 1 (5) (2).png"));
		lblBackGround.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(lblBackGround);
	}
}
