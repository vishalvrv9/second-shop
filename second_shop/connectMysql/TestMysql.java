package connectMysql;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class TestMysql {
	
	
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver");      
			System.out.println("Success loading Mysql Driver!");
			} catch (Exception e) {
				System.out.print("Error loading Mysql Driver!");
				e.printStackTrace();
			}
			try {
				Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root",
						"password" + "");
				System.out.println("Success connect Mysql server!");
				Statement stmt = connect.createStatement();
				ResultSet rs = stmt.executeQuery("select * from Clothes");
				while (rs.next()) {
					System.out.println(rs.getString("name"));
				}
	    }catch (Exception e) {
	    	System.out.print("get data error!");
	    	e.printStackTrace();
	    }
	  }
	}

	