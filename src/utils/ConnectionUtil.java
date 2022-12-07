package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/secondshop";
	private static final String USER = "root";
	private static final String PASS = "123456";
	Connection conn = null;

	public static Connection connectToDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			return con;
		} catch (ClassNotFoundException | SQLException ex) {
			System.err.println("ConnectionUtil : " + ex.getMessage());
			return null;
		}
	}
	// make sure you add the lib to your Build path of the project as we all are
	// using eclipse.
	//	Download the jar from here https://mvnrepository.com/artifact/mysql/mysql-connector-java

}
