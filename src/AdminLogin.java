import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
					frame.setLocation(200, 10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 300, 659);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(20, 183, 256, 256);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Home\\eclipse-workspace\\Pharmaceutical Management System\\administrator-256.png"));
		panel.add(lblNewLabel);
		
		JLabel lblSignUoHere = new JLabel("Sign Up Here");
		lblSignUoHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Administrator log = new Administrator();
				log.setResizable(false);
				log.show();
				log.setLocation(200, 10);
				log.setVisible(true);
				
				//SignUp frame = new SignUp();
				dispose();
			}
		});
		lblSignUoHere.setFont(new Font("Arial", Font.BOLD, 17));
		lblSignUoHere.setForeground(Color.WHITE);
		lblSignUoHere.setBounds(89, 488, 111, 28);
		panel.add(lblSignUoHere);
		
		JLabel lblNewLabel_1 = new JLabel("");
		//lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Home\\eclipse-workspace\\Pharmaceutical Management System\\halton_logo.png"));
		lblNewLabel_1.setBounds(583, 28, 284, 74);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_2.setBounds(519, 330, 60, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(519, 350, 426, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_3.setBounds(519, 430, 60, 14);
		contentPane.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(519, 450, 426, 34);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","toor"); 
                    Statement state = conn.createStatement();
                    String username = textField.getText();
                    String password1 = new String(passwordField.getPassword());
                    String query = "insert into adminlogin(username,password) VALUES(?,?)";
                    if(username.equals("")||password1.equals("")) {
                       	JOptionPane.showMessageDialog(null,"Please fill in the form");;}else  {Admin frame = new Admin();
        				frame.show();frame.setLocation(50, 10);
                       	}
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, username);
                    preparedStmt.setString(2, password1);
                    preparedStmt.execute();
                    System.out.println("Success");							
}catch(Exception arg01) {arg01.printStackTrace();

}
			
				
				}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(Color.GREEN);
		btnLogin.setFont(new Font("Arial", Font.BOLD, 10));
		btnLogin.setBounds(519, 608, 436, 34);
		contentPane.add(btnLogin);
	}
}
