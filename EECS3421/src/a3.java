import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class a3 {

	
	public static Connection conDB;
	public static String url;
	public static ArrayList<String> localCat;
	
	public static String club, year;
	
	public static String price;
	
	//customer information fields
	public static String cidNum, name, city;
	
	public static ArrayList items;
	
	//main class
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		//establish a connection
		System.out.println("Connecting...");
		Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
		establishConnection();
		
		
	}
	
	//connect to the database method
	
	public static void establishConnection() throws SQLException
	{
		url = "jdbc:db2:c3421m";
		conDB = DriverManager.getConnection(url);
	}
	
	//find customer method
	/*For find customer you have to do two things: If the customer is found return CID, Name and City
	 * IF the customer does not exist then we have to print an error message to the console and let the user
	 * try again*/
	
	public static boolean cid_exist(int cid) throws SQLException
	{
		
		//prepare the query
		String query = "select * from yrb_customer y where y.cid = " + cid;
		PreparedStatement stmnt = null;
		ResultSet result = null;
		
		boolean ans = false;
		
		stmnt = conDB.prepareStatement(query);
		result = stmnt.executeQuery();
		
		while(result.next())
		{
			ans = true;
			cidNum = result.getString(1);
			name = result.getString(2);
			city = result.getString(3);
			
		}
		result.close();
		return ans;
		
	}
	
	/*Once we know that the customer exists, we will fetch_categories and display them onto the console*/
	public static ArrayList fetch_categories() throws SQLException
	{
		//put categories in an ArrayList
		ArrayList<String> catagories = new ArrayList<String>();
		//String query_find_id = "SELECT * FROM YRB_CUSTOMER P WHERE P.CID = " + customer_id; 
				PreparedStatement stmnt = null;
				ResultSet result = null;
				
				String getCategories = "select * from yrb_category";
				stmnt = conDB.prepareStatement(getCategories);
				result = stmnt.executeQuery();
				String cat;
				
				while(result.next())
				{
					 cat = result.getString(1);
					 
					// System.out.println(cat);
					 catagories.add(cat);
					// result.next();
					 
				
				}
				result.close();
			
		return catagories;			
	}
	
	//get category
	public static String getCategory(int i)
	{
		String cat = "";
		//get the category
		cat = (String) items.get(i);
		
		return cat;
	}
	/*Customer then enters a title of the book. We look for the book and the selected category and return the books.
	 * If a given title exists then return the title, year, language and weight. If the book title does not exist
	 * the user gets to enter a book title again as well as the category*/
	
	public static boolean find_book(String title, String cat) throws SQLException
	{
		//prepare the query
				String query = "select * from yrb_book y where y.cat = '" + cat + "' and y.title = '"
						+ title + "'";
				PreparedStatement stmnt = null;
				ResultSet result = null;
				
				boolean ans = false;
				
				stmnt = conDB.prepareStatement(query);
				result = stmnt.executeQuery();
				String t, year, language, weight, last;
				//if book exists then add it to the array bookTitles
				while(result.next())
				{
					t = result.getString(1);
					year = result.getString(2);
					language = result.getString(3);
					weight = result.getString(4);
					last = "Title = " + t + ", Year = " + year + ", Language = " + language + ", Weight = " + weight;
					//bookTitles.add(last);
					ans = true;
				}
		return ans;
	}
	
	public static ArrayList getBook(String title, String cat) throws SQLException
	{
		ArrayList<String> bookTitles = new ArrayList<String>();
		//prepare the query
		String query = "select * from yrb_book y where y.cat = '" + cat + "' and y.title = '"
				+ title + "'";
		PreparedStatement stmnt = null;
		ResultSet result = null;
		
		boolean ans = false;
		
		stmnt = conDB.prepareStatement(query);
		result = stmnt.executeQuery();
		String t, language, weight, last;
		//if book exists then add it to the array bookTitles
		while(result.next())
		{
			t = result.getString(1);
			year = result.getString(2);
			language = result.getString(3);
			weight = result.getString(4);
			last = "Title = " + t + ", Year = " + year + ", Language = " + language + ", Weight = " + weight;
			bookTitles.add(last);
			ans = true;
			
		}
		result.close();
		return bookTitles;
		
	}
	
	public static boolean min_price(int cid, String title) throws SQLException
	{
		String query = "select min(y.price) from yrb_offer y where y.club in "
				+ "(select yrb_member.club from yrb_member where yrb_member.cid = " + cid + ") and "
						+ "y.title = '" + title + "'";
		
		
		PreparedStatement stmnt = null;
		ResultSet result = null;
		
		boolean ans = false;
		
		stmnt = conDB.prepareStatement(query);
		result = stmnt.executeQuery();
		
		while(result.next())
		{
			price = result.getString(1);
			//club = result.getString(2);
			ans = true;
			
		}
		//System.out.println("price = " + price + " club = " + club);
		result.close();
		return ans;
	}
	
	public static String min_club(int cid, double price, String title) throws SQLException
	{
		String query = "select y.club from yrb_offer y where y.club in "
				+ "(select yrb_member.club from yrb_member where yrb_member.cid = " + cid + ") and "
						+ "y.title = '" + title + "' and y.price = " + price;
		
		PreparedStatement stmnt = null;
		ResultSet result = null;
		
		stmnt = conDB.prepareStatement(query);
		result = stmnt.executeQuery();
		
		while(result.next())
		{
			club = result.getString(1);
		}
		result.close();
		return club;
	}
	
	public static void insert_purchase() throws SQLException
	{
		String query = "insert into yrb_purchase values (" + CIDNumber.c + ", '" + club + "', '" + DisplayBook.t +
				"', " + year + ", current timestamp, " + BuyBooks.quantity + ")";
		
		
		Statement stmnt = null;
		ResultSet result = null;
		
		stmnt = conDB.createStatement();
		stmnt.executeUpdate(query);
		//result = stmnt.executeQuery();
		
		System.out.println(query);
		
		//result.close();
	}
	

	
	
	
}
