import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	int x;
	int y;
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
					Login frame = new Login();
					frame.setUndecorated(false);
					frame.setResizable(false);
					frame.setLocation(200, 10);
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
	public Login() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xx = e.getXOnScreen();
				int xy=e.getYOnScreen();
				Login.this.setLocation(x+xx, y+xy);
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int xx = e.getXOnScreen();
				int xy=e.getYOnScreen();
				Login.this.setLocation(x+xx, y+xy);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int xx = arg0.getXOnScreen();
				int xy=arg0.getYOnScreen();
				Login.this.setLocation(x+xx, y+xy);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				x=arg0.getX();
				y=arg0.getY();
			}
		});
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 389, 671);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(57, 182, 256, 256);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Home\\eclipse-workspace\\Pharmaceutical Management System\\login.png"));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Click Here To Sign Up");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SignUp frame = new SignUp();
				frame.setResizable(false);
				frame.show();
				frame.setLocation(200, 15);
				frame.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(85, 604, 192, 20);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","toor"); 
                    Statement state = conn.createStatement();
                    String username = textField_1.getText();
                    String password1 = new String(passwordField.getPassword());
                    String query = "insert into login(username,password) VALUES(?,?)";
                    if(username.equals("")||password1.equals("")) {
                       	JOptionPane.showMessageDialog(null,"Please fill in the form");;}else  {Main_Page frame = new Main_Page();
        				frame.show();frame.setLocation(50, 10);
                       	}
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, username);
                    preparedStmt.setString(2, password1);
                   
                    
                    preparedStmt.execute();
                    System.out.println("Success");
                    dispose();
}catch(Exception arg01) {arg01.printStackTrace();

			}
				
			}	});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 10));
		btnNewButton.setBounds(519, 608, 436, 34);
		contentPane.add(btnNewButton);
		
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel.setBounds(519, 430, 60, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 10));
		lblUsername.setBounds(519, 330, 60, 14);
		contentPane.add(lblUsername);
		
		textField_1 = new JTextField();
		textField_1.setBounds(519, 350, 426, 34);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(519, 450, 426, 34);
		contentPane.add(passwordField);
	}
}
