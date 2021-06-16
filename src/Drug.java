import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JTextArea;

public class Drug extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextArea textArea;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drug frame = new Drug();
					frame.setVisible(true);
					frame.setResizable(false);
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
	public Drug() {
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
		panel.setLayout(null);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main_Page back = new Main_Page();
				back.setLocation(50, 15);
				back.show();
				dispose();
			}
		});
		lblBack.setFont(new Font("Arial", Font.BOLD, 17));
		lblBack.setForeground(Color.WHITE);
		lblBack.setBounds(115, 377, 59, 20);
		panel.add(lblBack);
		
		String [] combo = {"Make a selection","Cataflam","Brufen","Diclofenac","Modafinil"};
		JComboBox comboBox = new JComboBox(combo);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem().equals("Cataflam")) 
				{textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField.setText("Keep in a cool dry place");}
				
				if(comboBox.getSelectedItem().equals("Brufen")) 
				{textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("20");
				textField.setText("Keep in a cool dry place");}
				
				if(comboBox.getSelectedItem().equals("Diclofenac")) 
				{textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("1");
				textField_7.setText("");
				textField_8.setText("");
				textField.setText("Keep in a cool dry place");}
				
				
				if(comboBox.getSelectedItem().equals("Modafinil")) 
				{textField_1.setText("657760");
				textField_2.setText("Modafinil");
				textField_3.setText("3");
				textField_4.setText("18/6/2018");
				textField_5.setText("12/9/2020");
				textField_6.setText("1");
				textField_7.setText("Headaches");
				textField_8.setText("30");
				textField.setText("Keep in a cool dry place");}
				
				}
		
		});
		
		comboBox.setBounds(415, 17, 178, 20);
		contentPane.add(comboBox);
		
		JLabel lblNumberOfTablets = new JLabel("Reference No");
		lblNumberOfTablets.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumberOfTablets.setBounds(310, 64, 111, 20);
		contentPane.add(lblNumberOfTablets);
		
		JLabel lblNameOfTablets = new JLabel("Name of Tablets");
		lblNameOfTablets.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNameOfTablets.setBounds(310, 17, 111, 20);
		contentPane.add(lblNameOfTablets);
		
		JLabel lblDosemg = new JLabel("Dose (Mg)");
		lblDosemg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDosemg.setBounds(310, 105, 111, 20);
		contentPane.add(lblDosemg);
		
		JLabel lblNoOfDrugs = new JLabel("No of Tablets");
		lblNoOfDrugs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNoOfDrugs.setBounds(310, 197, 111, 20);
		contentPane.add(lblNoOfDrugs);
		
		JLabel lblIssueDate = new JLabel("Issue Date");
		lblIssueDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIssueDate.setBounds(310, 240, 111, 20);
		contentPane.add(lblIssueDate);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date");
		lblExpiryDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblExpiryDate.setBounds(310, 276, 111, 20);
		contentPane.add(lblExpiryDate);
		
		JLabel lblDailyDose = new JLabel("Daily Dose");
		lblDailyDose.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDailyDose.setBounds(310, 311, 111, 20);
		contentPane.add(lblDailyDose);
		
		JLabel lblSideEffects = new JLabel("Side Effects");
		lblSideEffects.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSideEffects.setBounds(310, 347, 111, 20);
		contentPane.add(lblSideEffects);
		
		JLabel lblStorageAdvice = new JLabel("Storage Advice");
		lblStorageAdvice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStorageAdvice.setBounds(310, 388, 94, 14);
		contentPane.add(lblStorageAdvice);
		
		textField = new JTextField();
		textField.setBounds(415, 385, 185, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(414, 64, 185, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(414, 105, 185, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(415, 197, 185, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(415, 240, 185, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(415, 276, 185, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(415, 311, 185, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(415, 347, 185, 20);
		contentPane.add(textField_7);
		
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(622, 15, 352, 392);
		contentPane.add(textArea);
		
		JButton btnPurchased = new JButton("Purchased");
		btnPurchased.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("\t\t Pharmacy Records \n\n"+"\t\t Name of Tablets \n"+comboBox.getSelectedIndex()+"\n\n"+comboBox.getSelectedItem()+
						"\n=================================================\n"+
								
						"Reference No:\t\t\t"+textField_1.getText()+"\n\n"+
						"Dose:\t\t\t"+textField_2.getText()+"\n\n"+
						"No of Tablets:\t\t\t"+textField_3.getText()+"\n\n"+
						"Issue Date:\t\t\t"+textField_4.getText()+"\n\n"+
						"Expiry Date:\t\t\t"+textField_5.getText()+"\n\n"+
				        "Daily Dose:\t\t\t"+textField_6.getText()+"\n\n"+
				        "Side Effects:\t\t\t"+textField_7.getText()+"\n\n"+
				        "Storage Advice:\t\t\t"+textField.getText()+"\n\n");
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","toor"); 
                    Statement state = conn.createStatement();
                    String NameofTablets = comboBox.getName();
                    String ReferenceNo = textField_1.getText();
                    String Dose = textField_2.getText();
                    String Price = textField_3.getText();
                    String NoofTablets = textField_4.getText();
                    String IssueDate = textField_5.getText();
                    String ExpiryDate = textField_6.getText();
                    String DailyDose = textField_7.getText();
                    String SideEffect = textField_8.getText();
                    String StorageAdvice = textField.getText();
                    String query = "insert into drugdetails(NameofTablets,ReferenceNo,Dose,Price,NoofTablets,IssueDate,ExpiryDate,DailyDose,SideEffect,StorageAdvice)VALUES(?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, NameofTablets);
                    preparedStmt.setString(2, ReferenceNo);
                    preparedStmt.setString(3, Dose);
                    preparedStmt.setString(4, Price);
                    preparedStmt.setString(5, NoofTablets);
                    preparedStmt.setString(6, IssueDate);
                    preparedStmt.setString(7, ExpiryDate);
                    preparedStmt.setString(8, DailyDose);
                    preparedStmt.setString(9, SideEffect);
                    preparedStmt.setString(10, StorageAdvice);  
                    preparedStmt.execute();
                    System.out.println("Success");
                    
}catch(Exception e1) {e1.printStackTrace();

			}
			}});
		btnPurchased.setBounds(310, 465, 111, 23);
		contentPane.add(btnPurchased);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.print();
					}catch(PrinterException e1 ) {
						e1.printStackTrace();
					}
			}
		});
		btnPrint.setBounds(441, 465, 89, 23);
		contentPane.add(btnPrint);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
				textField_8.setText(null);
				textArea.setText(null);
			}
		});
		btnClear.setBounds(551, 465, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin back = new Admin();
				back.setLocation(50, 15);
				back.show();
				dispose();
			}
		});
		btnMainMenu.setBounds(663, 465, 89, 23);
		contentPane.add(btnMainMenu);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrice.setBounds(310, 155, 46, 14);
		contentPane.add(lblPrice);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(415, 152, 185, 20);
		contentPane.add(textField_8);
	}
}
