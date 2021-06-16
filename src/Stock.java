import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Stock extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextArea  txtReceipt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock frame = new Stock();
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
	public Stock() {
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
		
		JLabel lblNewLabel = new JLabel("Product Name");
		lblNewLabel.setBounds(310, 11, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblInStock = new JLabel("In Stock");
		lblInStock.setBounds(310, 64, 46, 14);
		contentPane.add(lblInStock);
		
		JLabel lblAllocated = new JLabel("Allocated");
		lblAllocated.setBounds(310, 117, 46, 14);
		contentPane.add(lblAllocated);
		
		JLabel lblOnHand = new JLabel("On hand");
		lblOnHand.setBounds(310, 174, 46, 14);
		contentPane.add(lblOnHand);
		
		JLabel lblMinimumStockLevel = new JLabel("Minimum Stock Lvl");
		lblMinimumStockLevel.setBounds(310, 234, 118, 14);
		contentPane.add(lblMinimumStockLevel);
		
		String [] combo = {"Make a selection","Cataflam","Brufen","Diclofenac","Modafinil"};
		JComboBox comboBox = new JComboBox(combo);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Cataflam")) 
				{textField.setText("Y");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");}
				
				if(comboBox.getSelectedItem().equals("Brufen")) 
				{textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");}
				
				if(comboBox.getSelectedItem().equals("Diclofenac")) 
				{textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");}

				if(comboBox.getSelectedItem().equals("Modafinil")) 
				{textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");}
				
				
				}
				
			
		});
		comboBox.setBounds(442, 8, 203, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(442, 61, 203, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(442, 114, 203, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(442, 171, 203, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(442, 231, 203, 20);
		contentPane.add(textField_3);
		
		JTextArea txtReceipt = new JTextArea();
		txtReceipt.setBounds(671, 6, 303, 398);
		contentPane.add(txtReceipt);
		
		JButton btnReport = new JButton("Report");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtReceipt.append("\t\t Pharmacy Records \n\n"+"\t\t Product Name \n"+comboBox.getSelectedIndex()+"\n\n"+comboBox.getSelectedItem()+
						"\n=================================================\n"+
						
						
						"In Stock No:\t\t\t"+textField.getText()+"\n\n"+
						"Allocated:\t\t\t"+textField_1.getText()+"\n\n"+
						"On Hand:\t\t\t"+textField_2.getText()+"\n\n"+
						"Minimum Stock Level:\t\t"+textField_3.getText()+"\n\n");
						

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","toor"); 
                    Statement state = conn.createStatement();
                    String ProductName = comboBox.getName();
                    String InStock = textField.getText();
                    String Allocation = textField_1.getText();
                    String OnHand = textField_2.getText();
                    String MinimumStockLevel = textField_3.getText();
                    
                    String query = "insert into stockreport(ProductName,InStock,Allocation,OnHand,MinimumStockLevel)VALUES(?,?,?,?,?)";
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, ProductName);
                    preparedStmt.setString(2, InStock);
                    preparedStmt.setString(3, Allocation);
                    preparedStmt.setString(4, OnHand);
                    preparedStmt.setString(5, MinimumStockLevel);
         
                    preparedStmt.execute();
                    System.out.println("Success");
                    
}catch(Exception e1) {e1.printStackTrace();
	
			}
			}});
		btnReport.setBounds(310, 479, 89, 23);
		contentPane.add(btnReport);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtReceipt.print();
					}catch(PrinterException e1 ) {
						e1.printStackTrace();
					}
			}
		});
		btnPrint.setBounds(441, 479, 89, 23);
		contentPane.add(btnPrint);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null); 
				txtReceipt.setText(null);
				
			}
		});
		btnClear.setBounds(575, 479, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Admin back = new Admin();
				back.setResizable(false);
				back.show();
				dispose();
				back.setLocation(50, 15);
			}
		});
		btnMainMenu.setBounds(706, 479, 89, 23);
		contentPane.add(btnMainMenu);
	}

}
