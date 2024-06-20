package Application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;

public class EndingPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndingPage window = new EndingPage();
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
	public EndingPage() {
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
		
		JLabel lblNewLabel = new JLabel("THANK YOU");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 25, 416, 103);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTheEnd = new JLabel("THE END");
		lblTheEnd.setForeground(new Color(255, 255, 255));
		lblTheEnd.setVerticalAlignment(SwingConstants.TOP);
		lblTheEnd.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheEnd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblTheEnd.setBounds(10, 132, 416, 103);
		frame.getContentPane().add(lblTheEnd);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\nithi\\Downloads\\Create a visual 1 (6) (1).png"));
		lblNewLabel_1.setBounds(0, 0, 436, 258);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
