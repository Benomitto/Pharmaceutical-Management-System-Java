import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Supplier extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supplier frame = new Supplier();
					frame.setVisible(true);
					frame.setLocation(170, 30);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Supplier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 300, 650);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Back");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Main_Page back = new Main_Page();
				back.setLocation(50, 15);
				back.show();
				dispose();
			}
		});
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_1.setBounds(94, 326, 101, 14);
		lblNewLabel_1.setForeground(Color.WHITE);
		panel.add(lblNewLabel_1);
		
		JLabel lblSupplierId = new JLabel("Supplier ID");
		lblSupplierId.setBounds(310, 32, 76, 14);
		contentPane.add(lblSupplierId);
		
		JLabel lblSupplierName = new JLabel("Supplier Name");
		lblSupplierName.setBounds(310, 86, 93, 14);
		contentPane.add(lblSupplierName);
		
		JLabel lblNewLabel = new JLabel("Address");
		lblNewLabel.setBounds(310, 145, 57, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(310, 195, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(310, 250, 46, 14);
		contentPane.add(lblPhone);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setBounds(310, 293, 46, 14);
		contentPane.add(lblMobile);
		
		JLabel lblFax = new JLabel("Fax");
		lblFax.setBounds(310, 338, 46, 14);
		contentPane.add(lblFax);
		
		String [] company = {"Make a selection","K586","C2548","H524"};
		
		JComboBox comboBox = new JComboBox(company);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem().equals("K586")) 
				{textField.setText("Kai Limited");
				textField_1.setText("6734-00100 CBD");
				textField_2.setText("kailimimited@pharma@proton.com");
				textField_3.setText("020-258-7289");
				textField_4.setText("0734982782");
				textField_5.setText("+25412654988");}
				
				if(comboBox.getSelectedItem().equals("C2548")) 
				{textField.setText("Cosocoso Limited");
				textField_1.setText("34-00100 CBD");
				textField_2.setText("coso@gmail.com");
				textField_3.setText("020-158-9875");
				textField_4.setText("0714082182");
				textField_5.setText("+25412721165");}
				
				if(comboBox.getSelectedItem().equals("H524")) 
				{textField.setText("Harley's Limited");
				textField_1.setText("100-00100 CBD");
				textField_2.setText("harley's@gmail.com");
				textField_3.setText("254-158-100");
				textField_4.setText("0714549780");
				textField_5.setText("+25423585989");}
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","toor"); 
                    Statement state = conn.createStatement();
                    String SupplierID = comboBox.getName();
                    String SupplierName = textField.getText();
                    String Address = textField_1.getText();
                    String Email = textField_2.getText();
                    String Phone = textField_3.getText();
                    String Mobile = textField_4.getText();
                    String Fax = textField_5.getText();
                    
                    String query = "insert into supplier(SupplierID,SupplierName,Address,Email,Phone,Mobile,Fax)VALUES(?,?,?,?,?,?,?)";
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, SupplierID);
                    preparedStmt.setString(2, SupplierName);
                    preparedStmt.setString(3, Address);
                    preparedStmt.setString(4, Email);
                    preparedStmt.setString(5, Phone);
                    preparedStmt.setString(6, Mobile);
                    preparedStmt.setString(7, Fax);  
                    preparedStmt.execute();
                    System.out.println("Success");
                    
}catch(Exception e1) {e1.printStackTrace();

				
				
			}
			}});
		comboBox.setBounds(431, 29, 191, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(431, 83, 191, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(431, 142, 191, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(431, 192, 191, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(431, 247, 191, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(431, 290, 191, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(431, 335, 191, 20);
		contentPane.add(textField_5);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
			}
		});
		btnClear.setBounds(314, 543, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin back = new Admin();
				back.setLocation(50, 10);
				back.show();
				dispose();
			}
		});
		btnMainMenu.setBounds(448, 543, 89, 23);
		contentPane.add(btnMainMenu);
	}
}
