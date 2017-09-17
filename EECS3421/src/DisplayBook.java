import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;


public class DisplayBook extends JFrame{
	
	public static ArrayList<String> c;
	public static String t;
	private static final long serialVersionUID = 1L;
	
	
	JList list = new JList();
	public static ArrayList<String> titles;
	public static void main(String[] args) throws SQLException
	{
		Categories frameTable = new Categories();
	}
	
	JLabel welcome = new JLabel("Please enter the title you are looking for:");
	JLabel category = new JLabel();
	JTextField title = new JTextField();
	
	JPanel panel = new JPanel();
	
	JButton display = new JButton("Next");
	
	//JComboBox<String> cat = new JComboBox<String>();
	
	DisplayBook() throws SQLException
	{
		super("Find Book");
		setSize(400, 300);
		setLocation(500, 280);
		panel.setLayout(null);
		
		//this.getContentPane().setLayout(new FlowLayout());
		
		category.setText("The Category you have selected is: " + Categories.cate);
		
		category.setBounds(50, 50, 400, 60);
		welcome.setBounds(50, 80, 400, 40);
		title.setBounds(110, 110, 150, 40);
		
		display.setBounds(130, 200, 80, 40);
	
		
		
		
		
		
		//JScrollPane scroll = new JScrollPane(textArea);
		
		//scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		//scroll.setHorizontalScrollBarPolicy ( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS );
		
		panel.add(display);
		
		panel.add(welcome);
		panel.add(title);
		panel.add(category);
		//panel.add(scroll);
		
	
		
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		goToBook();
	}
	
	public void goToBook() throws SQLException
	{
		display.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				//get array list from findBooks
				
				
				/*we have to display the titles in the text
				area*/
				
				try {
					if(a3.find_book(title.getText(), Categories.cate) == true)
					{
						t = title.getText();
						try {
							titles = a3.getBook(title.getText().toString(), Categories.cate.toString());
							
							
							t = title.getText();
							ChooseBook cb = new ChooseBook();
							cb.setVisible(true);
							dispose();
							
							//textArea.setText(titles.toString());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							//e1.printStackTrace();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "The book title you entered does not exist. Please try again");
						try {
							Categories categories = new Categories();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							//e1.printStackTrace();
						}
						dispose();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null, "The book title you entered does not exist. Please try again");
					try {
						Categories categories = new Categories();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
					dispose();
				}
				
				
				
				
				
				
				
			}
			
		});
	}
		
	

}
