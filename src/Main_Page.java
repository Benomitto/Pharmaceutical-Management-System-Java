import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main_Page extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Page frame = new Main_Page();
					frame.setVisible(true);
					frame.setResizable(false);
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
	public Main_Page() {
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
		
		JLabel lblAdministratorLoginPage = new JLabel("Administrator SignUp Page");
		lblAdministratorLoginPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Administrator ad = new Administrator();
				ad.show();
				ad.setResizable(false);
				ad.setLocation(50,10);
				dispose();
			}
		});
		lblAdministratorLoginPage.setForeground(Color.WHITE);
		lblAdministratorLoginPage.setBounds(27, 194, 235, 20);
		lblAdministratorLoginPage.setFont(new Font("Arial", Font.BOLD, 17));
		panel.add(lblAdministratorLoginPage);
		
		JButton btnNewButton = new JButton("Drug Details");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Drug details = new Drug();
				details.setLocation(200, 30);
				details.show();
				dispose();
			}
		});
		btnNewButton.setBounds(349, 67, 150, 150);
		contentPane.add(btnNewButton);
		
		JButton btnPurchaseDetails = new JButton("Purchase Details");
		btnPurchaseDetails.setForeground(Color.WHITE);
		btnPurchaseDetails.setBackground(Color.GREEN);
		btnPurchaseDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Purchase details = new Purchase();
				details.setLocation(200, 30);
				details.show();
				dispose();
			}
		});
		btnPurchaseDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPurchaseDetails.setBounds(583, 67, 150, 150);
		contentPane.add(btnPurchaseDetails);
		
		JButton btnBills = new JButton("Bills");
		btnBills.setForeground(Color.WHITE);
		btnBills.setBackground(Color.GREEN);
		btnBills.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Bill report = new Bill();
				report.setLocation(200, 30);
				report.show();
				dispose();
			}
		});
		btnBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBills.setBounds(819, 67, 150, 150);
		contentPane.add(btnBills);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.GREEN);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(1042, 67, 150, 150);
		contentPane.add(btnExit);
	}
}
