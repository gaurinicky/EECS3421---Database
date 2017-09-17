import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BuyBooks extends JFrame {
	
	//get ArrayList of Books from the database
	ArrayList titles = DisplayBook.titles;
	JList list;
	DefaultListModel model;
	public static double price;
	public static int quantity;

	
	public static void main(String[] args) throws SQLException
	{
		Categories frameTable = new Categories();
	}
	
	
	JPanel panel = new JPanel();
	JTextArea label = new JTextArea("The minimum price of the book " + DisplayBook.t + " is \n$" + a3.price
			+ "\n How many books would you like to buy? Please enter the quantity below");
	
	JButton next = new JButton("Next");
	JTextField qnty = new JTextField();
	
	//JComboBox<String> cat = new JComboBox<String>();
	
	BuyBooks() throws SQLException
	{
		super("Buy Book");
		setSize(400, 300);
		setLocation(500, 280);
		panel.setLayout(null);
		
		
		
		qnty.setBounds(150, 150, 80, 40);
		next.setBounds(150, 200, 80, 40);
		label.setBounds(50, 50, 300, 70);
		label.setLineWrap(true);
		panel.add(label);
		panel.add(next);
		panel.add(qnty);
		
		label.setEditable(false);
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		finalPrice();
		
	}
	
	public void finalPrice() throws SQLException
	{
		next.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						quantity = Integer.parseInt(qnty.getText());
						//price = a3.min_price(CIDNumber.c, DisplayBook.t);
						FinalPrice book = new FinalPrice();
						book.setVisible(true);
						dispose();
						
						
					}
			
				});
	}
	

}