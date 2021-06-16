import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Color;


public class Welcome extends JFrame {

	
	public JPanel contentPane;

	

	
	public static void main(String[] args)throws InterruptedException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
					frame.setUndecorated(true);
					frame.setLocation(400, 100);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	

	public Welcome() {
		setAlwaysOnTop(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 584, 411);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setEnabled(true);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Home\\eclipse-workspace\\Pharmaceutical Management System\\halton_logo.png"));
		lblNewLabel.setBounds(166, 162, 301, 110);
		panel.add(lblNewLabel);
				
		JLabel lblLabel = new JLabel("Loading...");
		//lblLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//lblLabel.setIcon(new ImageIcon("C:\\Users\\Home\\eclipse-workspace\\Pharmaceutical Management System\\spinner.gif"));
		//lblLabel.setBounds(217, 132, 171, 157);
		panel.add(lblLabel);

	}
}
