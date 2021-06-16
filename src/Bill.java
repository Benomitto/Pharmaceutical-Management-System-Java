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
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Bill extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill frame = new Bill();
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
	public Bill() {
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
		lblBack.setBounds(109, 211, 89, 14);
		panel.add(lblBack);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setBounds(311, 11, 46, 14);
		contentPane.add(lblCompany);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(310, 52, 46, 14);
		contentPane.add(lblDate);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setBounds(310, 95, 46, 14);
		contentPane.add(lblNumber);
		
		JLabel lblVendor = new JLabel("Vendor");
		lblVendor.setBounds(310, 141, 46, 14);
		contentPane.add(lblVendor);
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setBounds(310, 188, 71, 14);
		contentPane.add(lblTotalAmount);
		
		String [] company = {"Make a selection","United Pharma","Cosmos Pharmaceutical","Sai Pharmaceuticals"};
		JComboBox comboBox = new JComboBox(company);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("United Pharma")) 
				textField.setText("18/08/2019");	
				{textField_1.setText("INV001");
				textField_2.setText("Halton's Pharmacy");
				textField_3.setText("30,000");
				}
				
				if(comboBox.getSelectedItem().equals("Cosmos Pharmaceutical")) 
				{
				textField.setText("19/08/2019");	
				textField_1.setText("INV002");
				textField_2.setText("Halton's Pharmacy");
				textField_3.setText("20,000");
				//textField_4.setText("03/01/2018");
				}
				
				if(comboBox.getSelectedItem().equals("Sai Pharmaceuticals")) 
				{
				textField.setText("20/09/2019");
				textField_1.setText("INV003");
				textField_2.setText("Halton's Pharmacy");
				textField_3.setText("10,000");
				//textField_4.setText("04/01/2018");
				}
				
			}
		});
		comboBox.setBounds(388, 8, 190, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(388, 49, 190, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(388, 92, 190, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(388, 138, 190, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(391, 185, 190, 20);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
			}
		});
		btnNewButton.setBounds(414, 519, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Page back = new Main_Page();
				back.setLocation(50, 15);
				back.show();
				dispose();
			}
		});
		btnMainMenu.setBounds(547, 519, 89, 23);
		contentPane.add(btnMainMenu);
	}

}
