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
import java.awt.Font;

public class Purchasereport extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextArea txtReceipt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purchasereport frame = new Purchasereport();
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
	public Purchasereport() {
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
		
		JLabel lblNewLabel_4 = new JLabel("Back");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main_Page back = new Main_Page();
				back.setLocation(50, 15);
				back.show();
				dispose();
			}
		});
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_4.setBounds(116, 281, 50, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Company Name");
		lblNewLabel.setBounds(310, 31, 129, 14);
		contentPane.add(lblNewLabel);
		
		String [] company = {"Make a selection","United Pharma","Cosmos Pharmaceutical","Sai Pharmaceuticals"};
		JComboBox comboBox = new JComboBox(company);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("United Pharma")) 
				{textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");}
				
				if(comboBox.getSelectedItem().equals("Cosmos Pharmaceutical")) 
				{textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");}
				
				if(comboBox.getSelectedItem().equals("Sai Pharmaceuticals")) 
				{textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");}
	
	
			
		}});
		comboBox.setBounds(423, 28, 151, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Purchase Order");
		lblNewLabel_1.setBounds(310, 92, 92, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(423, 89, 151, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity Ordered");
		lblNewLabel_2.setBounds(310, 148, 92, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(423, 145, 151, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setBounds(310, 212, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(423, 209, 151, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(310, 283, 46, 14);
		contentPane.add(lblAmount);
		
		textField_3 = new JTextField();
		textField_3.setBounds(423, 280, 151, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		txtReceipt = new JTextArea();
		contentPane.add(txtReceipt);
		
		JTextArea txtReceipt = new JTextArea();
		txtReceipt.setBounds(607, 87, 367, 418);
		contentPane.add(txtReceipt);
		
		JButton btnRe = new JButton("Record");
		btnRe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtReceipt.append("\t\t Pharmacy Records \n\n"+"\t\t Product Name \n"+comboBox.getSelectedIndex()+"\n\n"+comboBox.getSelectedItem()+
						"\n=================================================\n"+
						
						
						"Purchase Order:\t\t"+textField.getText()+"\n\n"+
						"Quantity Ordered:\t\t"+textField_1.getText()+"\n\n"+
						"Price:\t\t\t"+textField_2.getText()+"\n\n"+
						"Amount:\t\t\t"+textField_3.getText()+"\n\n");
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","toor"); 
                    Statement state = conn.createStatement();
                    String ProductName = comboBox.getName();
                    String PurchaseOrder = textField.getText();
                    String QuantityOrdered = textField_1.getText();
                    String Price = textField_2.getText();
                    String Amount = textField_3.getText();
                    
                    String query = "insert into purchasereport(ProductName,PurchaseOrder,QuantityOrdered,Price,Amount)VALUES(?,?,?,?,?)";
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, ProductName);
                    preparedStmt.setString(2, PurchaseOrder);
                    preparedStmt.setString(3, QuantityOrdered);
                    preparedStmt.setString(4, Price);
                    preparedStmt.setString(5, Amount);
                     
                    preparedStmt.execute();
                    System.out.println("Success");
                    
}catch(Exception e1) {e1.printStackTrace();

				
				
			}
			}});
		btnRe.setBounds(310, 565, 89, 23);
		contentPane.add(btnRe);
		
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
		btnPrint.setBounds(449, 565, 89, 23);
		contentPane.add(btnPrint);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
			}
		});
		btnClear.setBounds(585, 565, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Admin back = new Admin();
				back.setResizable(false);
				back.setLocation(50, 15);
				back.show();
				dispose();
			}
		});
		btnMainMenu.setBounds(717, 565, 89, 23);
		contentPane.add(btnMainMenu);
	}
}
