package mysql;
import java.sql.*; 

public class databaseConnect {

	public static void main(String args[]) 
	{
		Connection conn = null; 
		Statement stmt = null; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "password");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * from training";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				System.out.println("ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("Age: " + age);
				System.out.println("");
				
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception se) {}
	}
}
