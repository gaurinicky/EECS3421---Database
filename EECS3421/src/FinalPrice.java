import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;

public class FinalPrice extends JFrame {

	private JPanel contentPane;
	public static double finalPrice = BuyBooks.quantity * Double.parseDouble(a3.price);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalPrice frame = new FinalPrice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FinalPrice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250, 300);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYourFinalPrice = new JLabel("Your Final Price is: $" + finalPrice);
		lblYourFinalPrice.setBounds(28, 10, 170, 20);
		contentPane.add(lblYourFinalPrice);
		
		JLabel lblDoYouWish = new JLabel("Do you wish to proceed?");
		lblDoYouWish.setBounds(203, 10, 176, 20);
		contentPane.add(lblDoYouWish);
		
		JButton btnYes = new JButton("Yes");
		btnYes.setBounds(151, 35, 57, 29);
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					a3.insert_purchase();
					JOptionPane.showMessageDialog(null, "Your purchase is complete! Have a good day :)");
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(384, 19, 0, 2);
		contentPane.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBounds(389, 15, 10, 10);
		contentPane.add(panel);
		contentPane.add(btnYes);
		
		JButton btnNo = new JButton("No");
		btnNo.setBounds(218, 35, 53, 29);
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Goodbye!");
				
				dispose();
			}
		});
		
		JLabel label = new JLabel("");
		label.setBounds(213, 49, 0, 0);
		contentPane.add(label);
		contentPane.add(btnNo);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(276, 49, 0, 0);
		contentPane.add(label_1);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(394, 10, 20, 1);
		contentPane.add(horizontalStrut);
	}
}
