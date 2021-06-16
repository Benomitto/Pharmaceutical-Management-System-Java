import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
					frame.setLocation(50, 10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 700);
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
			public void mouseClicked(MouseEvent arg0) {
				Admin back = new Admin();
				back.show();
				back.setLocation(50,10);
				dispose();
			}
		});
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("Arial", Font.BOLD, 17));
		lblBack.setBounds(93, 252, 46, 14);
		panel.add(lblBack);
		
		JButton btnNewButton_2 = new JButton("Purchase Report");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.GREEN);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Purchase details = new Purchase();
				details.setResizable(false);
				details.setLocation(200, 15);
				details.show();
				dispose();
			}
		});
		btnNewButton_2.setBounds(349, 67, 150, 150);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Supplier Details");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.GREEN);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Supplier details = new Supplier();
				details.setResizable(false);
				details.setLocation(200, 15);
				details.show();
				dispose();
			}
		});
		btnNewButton_3.setBounds(583, 67, 150, 150);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("Financial Report");
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(Color.GREEN);
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Financial report = new Financial();
				report.setResizable(false);
				report.setLocation(200, 15);
				report.show();
				dispose();
			}
		});
		btnNewButton_5.setBounds(810, 67, 150, 150);
		contentPane.add(btnNewButton_5);
		
		JButton btnStockReport = new JButton("Stock Report");
		btnStockReport.setForeground(Color.WHITE);
		btnStockReport.setBackground(Color.GREEN);
		btnStockReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Stock report = new Stock();
				report.setResizable(false);
				report.setLocation(200, 15);
				report.show();
				dispose();
			}
		});
		btnStockReport.setBounds(1028, 67, 150, 150);
		contentPane.add(btnStockReport);
		
		JButton btnNewButton_7 = new JButton("Employee Details");
		btnNewButton_7.setForeground(Color.WHITE);
		btnNewButton_7.setBackground(Color.GREEN);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee report = new Employee();
				report.setResizable(false);
				report.setLocation(200, 15);
				report.show();
				dispose();
			}
		});
		btnNewButton_7.setBounds(349, 316, 150, 150);
		contentPane.add(btnNewButton_7);
		
		JButton btnFinancialReport_1 = new JButton("Exit");
		btnFinancialReport_1.setBackground(Color.GREEN);
		btnFinancialReport_1.setForeground(Color.WHITE);
		btnFinancialReport_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnFinancialReport_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showConfirmDialog(null, "Do you want to quit");System.exit(0);	}
			
		});
		btnFinancialReport_1.setBounds(583, 316, 150, 150);
		contentPane.add(btnFinancialReport_1);
	}
}
