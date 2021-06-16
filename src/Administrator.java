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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administrator extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator frame = new Administrator();
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
	public Administrator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 300, 659);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(20, 183, 256, 256);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Home\\eclipse-workspace\\Pharmaceutical Management System\\administrator-256.png"));
		panel.add(lblNewLabel);
		
		JLabel lblLoginHere = new JLabel("Login Here");
		lblLoginHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AdminLogin log = new AdminLogin();
				log.setResizable(false);
				log.show();
				log.setLocation(200, 10);
				log.setVisible(true);
				dispose();
			}
		});
		lblLoginHere.setFont(new Font("Arial", Font.BOLD, 17));
		lblLoginHere.setForeground(Color.WHITE);
		lblLoginHere.setBounds(103, 518, 94, 20);
		panel.add(lblLoginHere);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Home\\eclipse-workspace\\Pharmaceutical Management System\\halton_logo.png"));
		lblNewLabel_1.setBounds(583, 28, 284, 74);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 10));
		lblUsername.setBounds(519, 230, 60, 14);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(519, 250, 426, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 10));
		lblEmail.setBounds(519, 330, 60, 20);
		contentPane.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setBounds(519, 350, 426, 34);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_2.setBounds(519, 430, 101, 14);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(519, 450, 426, 34);
		contentPane.add(passwordField);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","toor"); 
                    Statement state = conn.createStatement();
                    String username = textField.getText();
                    String email=textField_1.getText();
                    String password = new String(passwordField.getPassword());
                    String query = "insert into administrator(username,email,password) VALUES(?,?,?)";
                    if(username.equals("")||email.equals("")||password.equals("")) {
                       	JOptionPane.showMessageDialog(null,"Please fill in the form");;}
                    else {Admin frame = new Admin();
    				frame.setLocation(50,15);
    				frame.show();}
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, username);
                    preparedStmt.setString(2, email);
                    preparedStmt.setString(3, password); 
                    preparedStmt.execute();
                    System.out.println("Success");							
}catch(Exception arg0) {arg0.printStackTrace();
			}
				
		}});
		btnSignUp.setBackground(Color.GREEN);
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBounds(519, 608, 436, 34);
		contentPane.add(btnSignUp);
	}
}
