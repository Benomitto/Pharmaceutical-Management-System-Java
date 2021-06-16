import java.sql.*;
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import java.awt.Color;
//import javax.swing.JButton;
//import javax.swing.UIManager;
//import java.awt.SystemColor;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
//import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	int xx;
	int xy;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setUndecorated(false);
					frame.setResizable(false);
					frame.setLocation(200, 15);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUp() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getXOnScreen();
				SignUp.this.setLocation(x-xx, y-xy);
		
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				xy=e.getY();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp frame = new SignUp();
				frame.setResizable(false);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GREEN);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setUndecorated(true)
		contentPane.setVisible(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 389, 681);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(57, 182, 256, 256);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Home\\eclipse-workspace\\Pharmaceutical Management System\\addUser.png"));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Click Here To Login");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Login log = new Login();
				log.setResizable(false);
				log.show();
				log.setLocation(200, 10);
				log.setVisible(true);
				dispose();
				
			}
		});
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_4.setBounds(85, 604, 192, 20);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","toor"); 
                            Statement state = conn.createStatement();
                            String username = textField.getText();
                            String email=textField_1.getText();
                            String password1 = new String(passwordField.getPassword());
                            
                            String query = "insert into signup(username,email,password) VALUES(?,?,?)";
                            if(username.equals("")||email.equals("")||password1.equals("")) {
                               	JOptionPane.showMessageDialog(null,"Please fill in the form");;}
                            else {
                               //	{JOptionPane.showMessageDialog(null,"Success");
                            	Admin frame = new Admin();
                            	frame.setLocation(50,15);
        						frame.setVisible(true);
        						dispose();			
                            	;}
                            PreparedStatement preparedStmt = conn.prepareStatement(query);
                            preparedStmt.setString(1, username);
                            preparedStmt.setString(2, email);
                            preparedStmt.setString(3, password1);
                            preparedStmt.execute();							
	}catch(Exception arg0) {arg0.printStackTrace();
	
	
;}
						
								
		}});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setBounds(519, 608, 436, 34);
		contentPane.add(btnNewButton);
		//Main_Page frame = new Main_Page();
		
		textField = new JTextField();
		textField.setBounds(519, 250, 426, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 10));
		lblUsername.setBounds(519, 230, 60, 14);
		contentPane.add(lblUsername);
		
		textField_1 = new JTextField();
		textField_1.setBounds(519, 350, 426, 34);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 10));
		lblEmail.setBounds(519, 330, 60, 14);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel.setBounds(519, 430, 101, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Home\\eclipse-workspace\\Pharmaceutical Management System\\halton_logo.png"));
		lblNewLabel_2.setBounds(583, 28, 284, 74);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(519, 450, 426, 34);
		contentPane.add(passwordField);
	}

	protected JPasswordField passwordField_1(char[] input) {
		// TODO Auto-generated method stub
		return null;
	}
}
