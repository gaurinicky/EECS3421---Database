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

public class ChooseBook extends JFrame {
	
	//get ArrayList of Books from the database
	ArrayList titles = DisplayBook.titles;
	JList list;
	DefaultListModel model;
	public static double price;

	
	public static void main(String[] args) throws SQLException
	{
		Categories frameTable = new Categories();
	}
	
	
	JPanel panel = new JPanel();
	JButton next = new JButton("Next");
	
	
	//JComboBox<String> cat = new JComboBox<String>();
	
	ChooseBook() throws SQLException
	{
		super("Choose Book");
		setSize(400, 300);
		setLocation(500, 280);
		panel.setLayout(null);
		
		model = new DefaultListModel();
		list = new JList(model);
		JScrollPane pane = new JScrollPane(list);
		
		
		for(int i = 0; i < titles.size(); i++)
		{
			model.addElement(titles.get(0).toString());
			
		}
		
		pane.setBounds(10, 10, 380, 200);
		next.setBounds(150, 250, 80, 40);
		panel.add(pane);
		panel.add(next);
		
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		getMinPrice();
		
	}
	
	public void getMinPrice() throws SQLException
	{
		next.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							if(a3.min_price(CIDNumber.c, DisplayBook.t)==true)
							{
								//System.out.println("price = " + a3.price);
								
								a3.min_club(CIDNumber.c, Double.parseDouble(a3.price), DisplayBook.t);
								//System.out.println("Club = " + a3.club);
								BuyBooks book = new BuyBooks();
								book.setVisible(true);
								dispose();
							}
							
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							//e1.printStackTrace();
							//dispose();
						}
						
						
					}
			
				});
	}
	

}