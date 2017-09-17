import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;


public class CIDNumber extends JFrame{
	
	public static Connection conDB;
	public static String url;
	public static String information;
	
	public static int c;
	
	JTextArea displayCid = new JTextArea("Result : " + information);
	
	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		CIDNumber frameTable = new CIDNumber();
		
		Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
		a3.establishConnection();
	}
	
	JButton display = new JButton("Display");
	JLabel message = new JLabel("Please enter the CID Number");
	JLabel label = new JLabel("CID:");
	JButton next = new JButton("Next");
	JPanel panel = new JPanel(new BorderLayout());
	JTextField cid = new JTextField(15);
	
	CIDNumber() throws SQLException
	{
		super("Customer ID Number");
		setSize(300, 300);//need bigger frame to display customer information obtained from database
		setLocation(500, 280);
		panel.setLayout(null);
		
		displayCid();
		message.setBounds(30, 30, 200, 20);
		cid.setBounds(50, 100, 150, 20);
		displayCid.setBounds(25, 140, 250, 60);
		display.setBounds(55, 250, 90, 20);
		next.setBounds(150, 250, 80, 20);
		displayCid.setLineWrap(true);
		displayCid.setEditable(false);
		panel.add(display, BorderLayout.SOUTH);
		panel.add(message, BorderLayout.WEST);
		panel.add(cid, BorderLayout.CENTER);
		panel.add(displayCid, BorderLayout.SOUTH);
		panel.add(next);
		
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		goToCat();
		
		
	}
	
	public void displayCid() throws SQLException
	{
		display.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				String cidNum = cid.getText();
				int c = Integer.parseInt(cidNum);
				//if(cidNum.equals("test"))
				try {
					if(a3.cid_exist(c) == true)
					{
						//Categories categories = new Categories();
						//categories.setVisible(true);
						information = "CID Number: " + a3.cidNum + "\nCustomer's Name: " + a3.name + "\nCity = " + a3.city;
						displayCid.setText(information);
						//dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "The CID number you have entered does not exist");
						cid.setText("");
						cid.requestFocus();
					}
				} catch (HeadlessException | SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null, "The CID number you have entered does not exist");
					cid.setText("");
					cid.requestFocus();
				}
			}
		});
	}
	
	public void goToCat() throws SQLException
	{
		next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				
				String cidNum = cid.getText();
				c = Integer.parseInt(cidNum);
				//if(cidNum.equals("test"))
				try {
					if(a3.cid_exist(c) == true)
					{
						Categories categories = new Categories();
						categories.setVisible(true);
						//information = "CID Number: " + a3.cidNum + ", Customer's Name: " + a3.name + ", City = " + a3.city;
						//displayCid.setText(information);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "The CID number you have entered does not exist");
						cid.setText("");
						cid.requestFocus();
					}
				} catch (HeadlessException | SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null, "The CID number you have entered does not exist");
					cid.setText("");
					cid.requestFocus();
				}
			}
		});
	}

}
