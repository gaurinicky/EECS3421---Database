import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;


public class Categories extends JFrame{
	
	public static ArrayList<String> c;
	public static String cate;
	
	public static void main(String[] args) throws SQLException
	{
		Categories frameTable = new Categories();
	}
	
	JTextArea welcome = new JTextArea("Please select the cagtegory from the drop down list");
	JPanel panel = new JPanel();
	JButton next = new JButton("Next");
	
	JComboBox<String> cat = new JComboBox<String>();
	
	Categories() throws SQLException
	{
		super("Category");
		setSize(300, 200);
		setLocation(500, 280);
		panel.setLayout(null);
		
		c = a3.fetch_categories();
		int i;
		for(i = 0; i < c.size(); i++)
		{
			cat.addItem(c.get(i));
		}
		
		welcome.setBounds(40, 20, 220, 40);
		welcome.setLineWrap(true);
		welcome.setBackground(Color.GRAY.lightGray);
		welcome.setEditable(false);
		cat.setBounds(50, 70, 150, 40);
		next.setBounds(50, 150, 80, 40);
		panel.add(next);
		panel.add(welcome);
		panel.add(cat);
		
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		goToBook();
	}
	
	public void goToBook()
	{
		next.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				//get categry from the user
				cate = cat.getSelectedItem().toString();
				
				//open a new panel to allow the user to add the Book information they are searching for
				try {
					DisplayBook book = new DisplayBook();
					dispose();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
	}

}
