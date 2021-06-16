import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Purchase extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextArea txtReceipt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purchase frame = new Purchase();
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
	public Purchase() {
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
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("Arial", Font.BOLD, 17));
		lblBack.setBounds(95, 317, 46, 14);
		panel.add(lblBack);
		
		
		JLabel lblNewLabel = new JLabel("Company Name");
		lblNewLabel.setBounds(313, 29, 91, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPurchaseOrderNumber = new JLabel("Purchase Order No");
		lblPurchaseOrderNumber.setBounds(310, 89, 144, 14);
		contentPane.add(lblPurchaseOrderNumber);
		
		JLabel lblReseller = new JLabel("Reseller");
		lblReseller.setBounds(310, 150, 66, 14);
		contentPane.add(lblReseller);
		
		JLabel lblNewLabel_1 = new JLabel("Purchase Date");
		lblNewLabel_1.setBounds(310, 207, 112, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Invoice Number");
		lblNewLabel_2.setBounds(310, 262, 94, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Invoice Date");
		lblNewLabel_3.setBounds(310, 318, 77, 14);
		contentPane.add(lblNewLabel_3);
		
		String [] company = {"Make a selection","United Pharma","Cosmos Pharmaceutical","Sai Pharmaceuticals"};
		JComboBox comboBox_1 = new JComboBox(company);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_1.getSelectedItem().equals("United Pharma")) 
				{textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField.setText("");}
				
				if(comboBox_1.getSelectedItem().equals("Cosmos Pharmaceutical")) 
				{textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField.setText("");}
				
				if(comboBox_1.getSelectedItem().equals("Sai Pharmaceuticals")) 
				{textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField.setText("");}
				
			}
		});
		comboBox_1.setBounds(426, 26, 215, 20);
		contentPane.add(comboBox_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(426, 86, 215, 20);
		contentPane.add(textField);
		
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(426, 147, 215, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(426, 204, 215, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(426, 259, 215, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(426, 315, 215, 20);
		contentPane.add(textField_4);
		
		txtReceipt = new JTextArea();
		contentPane.add(txtReceipt);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(651, 24, 323, 464);
		contentPane.add(textArea);
		
		JButton btnRecord = new JButton("Record");
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("\t\t Pharmacy Records \n\n"+"\t\t Company Name \n"+comboBox_1.getSelectedIndex()+"\n\n"+comboBox_1.getSelectedItem()+
						"\n=================================================\n"+
						
						
						"Purchase Order No:\t\t"+textField.getText()+"\n\n"+
						"Reseller:\t\t\t"+textField_1.getText()+"\n\n"+
						"Purchase Date:\t\t\t"+textField_2.getText()+"\n\n"+
						"Invoice Number:\t\t"+textField_3.getText()+"\n\n"+
						"Invoice Date:\t\t\t"+textField_4.getText()+"\n\n");
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","toor"); 
                    Statement state = conn.createStatement();
                    String CompanyName = comboBox_1.getName();
                    String PurchaseOrder = textField.getText();
                    String Reseller = textField_1.getText();
                    String PurchaseDate = textField_2.getText();
                    String InvoiceNumber = textField_3.getText();
                    String InvoiceDate = textField_4.getText();
                    
                    String query = "insert into purchasedetails(CompanyName,PurchaseOrder,Reseller,PurchaseDate,InvoiceNumber,InvoiceDate)VALUES(?,?,?,?,?,?)";
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, CompanyName);
                    preparedStmt.setString(2, PurchaseOrder);
                    preparedStmt.setString(3, Reseller);
                    preparedStmt.setString(4, PurchaseDate);
                    preparedStmt.setString(5, InvoiceNumber);
                    preparedStmt.setString(6, InvoiceDate);
                      
                    preparedStmt.execute();
                    System.out.println("Success");
                    
}catch(Exception e1) {e1.printStackTrace();


			}
		}});
		btnRecord.setBounds(313, 561, 89, 23);
		contentPane.add(btnRecord);
		
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
		btnPrint.setBounds(444, 561, 89, 23);
		contentPane.add(btnPrint);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
			}
		});
		btnClear.setBounds(577, 561, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Page back = new Main_Page();
				back.setResizable(false);
				back.setLocation(50, 15);
				back.show();
				dispose();
			}
		});
		btnMainMenu.setBounds(708, 561, 89, 23);
		contentPane.add(btnMainMenu);
	}
}
