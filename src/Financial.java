import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Financial extends JFrame {
    
	
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
					Financial frame = new Financial();
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
	public Financial() {
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
		
		JLabel lblNewLabel = new JLabel("Statement");
		lblNewLabel.setBounds(310, 11, 69, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblRevenue = new JLabel("Revenue");
		lblRevenue.setBounds(310, 52, 69, 14);
		contentPane.add(lblRevenue);
		
		JLabel lblExpenses = new JLabel("Expenses");
		lblExpenses.setBounds(310, 104, 69, 14);
		contentPane.add(lblExpenses);
		
		JLabel lblNetAssets = new JLabel("Net Assets");
		lblNetAssets.setBounds(310, 151, 86, 14);
		contentPane.add(lblNetAssets);
		
		JLabel lblAssets = new JLabel("Assets");
		lblAssets.setBounds(310, 193, 46, 14);
		contentPane.add(lblAssets);
		
		JLabel lblLiability = new JLabel("Liability");
		lblLiability.setBounds(310, 238, 46, 14);
		contentPane.add(lblLiability);
		
		
		String [] company = {"Make a selection","United Pharma","Cosmos Pharmaceutical","Sai Pharmaceuticals"};
		JComboBox comboBox = new JComboBox(company);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem().equals("United Pharma")) 
				{textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");}
				
				if(comboBox.getSelectedItem().equals("Cosmos Pharmaceutical")) 
				{textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");}
				
				if(comboBox.getSelectedItem().equals("Sai Pharmaceuticals")) 
				{textField.setText("180,000");
				textField_1.setText("15,000");
				textField_2.setText("1,250,000");
				textField_3.setText("215,000");
				textField_4.setText("500,000");}
				
			}
		});
		comboBox.setBounds(404, 8, 189, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(404, 49, 189, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(404, 101, 189, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
	    textField_2.setColumns(10);
		textField_2.setBounds(404, 148, 189, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(404, 190, 189, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(404, 235, 189, 20);
		contentPane.add(textField_4);
		
		txtReceipt = new JTextArea();
		contentPane.add(txtReceipt);
		
		JButton btnNewButton = new JButton("Print");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				txtReceipt.print();
				}catch(PrinterException e ) {
					e.printStackTrace();
				}
			}
		});
		
		JTextArea txtReceipt = new JTextArea();
		txtReceipt.setBorder(new LineBorder(new Color(0,0,0),2));
		txtReceipt.setBounds(630, 10, 350, 500);
		contentPane.add(txtReceipt);
		btnNewButton.setBounds(490, 548, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRecord = new JButton("Record");
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtReceipt.append("\t\t Pharmacy Records \n\n"+"\t\t Statement \n"+comboBox.getSelectedIndex()+"\n\n"+comboBox.getSelectedItem()+
				"\n=================================================\n"+
						
				"Revenue:\t\t\t"+textField.getText()+"\n\n"+
				"Expenses:\t\t\t"+textField_1.getText()+"\n\n"+
				"Net Assets:\t\t\t"+textField_2.getText()+"\n\n"+
				"Assets:\t\t\t"+textField_3.getText()+"\n\n"+
				"Liabilities:\t\t\t"+textField_4.getText()+"\n\n"
						);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","toor"); 
                    Statement state = conn.createStatement();
                    String Statement = comboBox.getName();
                    String Revenue = textField.getText();
                    String Expenses = textField_1.getText();
                    String NetAssets = textField_2.getText();
                    String Assets = textField_3.getText();
                    String Liabilities = textField_4.getText();
                   
                    String query = "insert into financialreport(Statement,Revenue,Expenses,NetAssets,Assets,Liabilities)VALUES(?,?,?,?,?,?)";
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, Statement);
                    preparedStmt.setString(2, Revenue);
                    preparedStmt.setString(3, Expenses);
                    preparedStmt.setString(4, NetAssets);
                    preparedStmt.setString(5, Assets);
                    preparedStmt.setString(6, Liabilities);
                
                    preparedStmt.execute();
                    System.out.println("Success");
                    
}catch(Exception e1) {e1.printStackTrace();

			}
			}});
		btnRecord.setBounds(361, 548, 89, 23);
		contentPane.add(btnRecord);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				txtReceipt.setText(null);
				
			}
		});
		btnClear.setBounds(616, 548, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnNewButton_1 = new JButton("Main Menu");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Admin back = new Admin();
				back.setResizable(false);
				back.setLocation(50,15);
				back.show();
				dispose();
			}
		});
		btnNewButton_1.setBounds(752, 548, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
