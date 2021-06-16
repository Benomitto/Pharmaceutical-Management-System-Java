import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Employee extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
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
	public Employee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 300, 659);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(310, 11, 78, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(310, 45, 65, 14);
		contentPane.add(lblLastName);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(310, 81, 46, 14);
		contentPane.add(lblGender);
		
		JLabel lblPlaceOfBirth = new JLabel("Place of Birth");
		lblPlaceOfBirth.setBounds(310, 118, 78, 14);
		contentPane.add(lblPlaceOfBirth);
		
		JLabel lblDob = new JLabel("D.O.B");
		lblDob.setBounds(310, 155, 46, 14);
		contentPane.add(lblDob);
		
		JLabel lblMaritalStatus = new JLabel("Country of Birth");
		lblMaritalStatus.setBounds(310, 193, 78, 14);
		contentPane.add(lblMaritalStatus);
		
		JLabel lblMaritalStatus_1 = new JLabel("Marital Status");
		lblMaritalStatus_1.setBounds(310, 236, 91, 14);
		contentPane.add(lblMaritalStatus_1);
		
		JLabel lblGender_1 = new JLabel("Sex");
		lblGender_1.setBounds(310, 280, 46, 14);
		contentPane.add(lblGender_1);
		
		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setBounds(310, 331, 78, 14);
		contentPane.add(lblNationality);
		
		JLabel lblNewLabel_1 = new JLabel("Salary");
		lblNewLabel_1.setBounds(310, 371, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		String [] company = {"Make a selection","Johnstone","Kamau","Sarah"};
		JComboBox comboBox = new JComboBox(company);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");	
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");

				if(comboBox.getSelectedItem().equals("Kamau")) {
					textField.setText("");	
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");
					textField_8.setText("");
				}
				
				if(comboBox.getSelectedItem().equals("Sarah")) {
					textField.setText("Smith");	
					textField_1.setText("Female");
					textField_2.setText("Nairobi");
					textField_3.setText("12/06/1994");
					textField_4.setText("Kenya");
					textField_5.setText("Married");
					textField_6.setText("F");
					textField_7.setText("Kenyan");
					textField_8.setText("80,000");
				}
				}
			
			   
			
			
		});
		comboBox.setBounds(409, 8, 164, 20);
		contentPane.add(comboBox);
		
		
		
		textField = new JTextField();
		textField.setBounds(409, 42, 164, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(409, 78, 164, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(409, 115, 164, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(409, 152, 164, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(409, 190, 164, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(411, 233, 164, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(409, 277, 164, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(409, 328, 164, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(409, 368, 164, 20);
		contentPane.add(textField_8);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
				textField_8.setText(null);
			}
		});
		btnClear.setBounds(564, 515, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnNewButton = new JButton("Main Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin back = new Admin();
				back.setLocation(50, 15);
				dispose();
				back.show();
			}
		});
		btnNewButton.setBounds(678, 515, 89, 23);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(602, 6, 372, 426);
		contentPane.add(textArea);
	
		
		JButton btnRecord = new JButton("Record");
		btnRecord.setVisible(true);
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("\t\t Pharmacy Records \n\n"+"\t\t Employee \n"+comboBox.getSelectedIndex()+"\n\n"+comboBox.getSelectedItem()+
						"\n=================================================\n"+
								
						"Lastname:\t\t\t"+textField.getText()+"\n\n"+
						"Gender:\t\t\t"+textField_1.getText()+"\n\n"+
						"Place of Birth:\t\t\t"+textField_2.getText()+"\n\n"+
						"D.O.B:\t\t\t"+textField_3.getText()+"\n\n"+
						"Country of Birth:\t\t\t"+textField_4.getText()+"\n\n"+
						"Marital Status:\t\t\t"+textField_5.getText()+"\n\n"+
						"Sex:\t\t\t"+textField_6.getText()+"\n\n"+
						"Nationality:\t\t\t"+textField_7.getText()+"\n\n"+
						"Salary:\t\t\t"+textField_8.getText()+"\n\n");
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","toor"); 
                    Statement state = conn.createStatement();
                    String FirstName = comboBox.getName();
                    String LastName = textField.getText();
                    String Gender = textField_1.getText();
                    String POB = textField_2.getText();
                    String DOB = textField_3.getText();
                    String COB = textField_4.getText();
                    String MaritalStatus = textField_5.getText();
                    String Sex = textField_6.getText();
                    String Nationality = textField_7.getText();
                    String Salary = textField_8.getText();
                    String query = "insert into employeedetails(FirstName,LastName,Gender,POB,DOB,COB,MaritalStatus,Sex,Nationality,Salary)VALUES(?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, FirstName);
                    preparedStmt.setString(2, LastName);
                    preparedStmt.setString(3, Gender);
                    preparedStmt.setString(4, POB);
                    preparedStmt.setString(5, DOB);
                    preparedStmt.setString(6, COB);
                    preparedStmt.setString(7, MaritalStatus);
                    preparedStmt.setString(8, Sex);
                    preparedStmt.setString(9, Nationality);
                    preparedStmt.setString(10, Salary);  
                    preparedStmt.execute();
                    System.out.println("Success");
                    
}catch(Exception e1) {e1.printStackTrace();

			}
			}});

		btnRecord.setBounds(325, 515, 89, 23);
		contentPane.add(btnRecord);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setBounds(446, 515, 89, 23);
		contentPane.add(btnPrint);
	}
}	

