package jdbc_crud;

import java.sql.*;

public class CreateTable {

	public static void main(String[] args) throws Exception {
		 String url = "jdbc:mysql://localhost:3306/jdbc_crud_demo";
	        String user = "root";
	        String password = "Rithik@7518";
	        String sql = "CREATE TABLE IF NOT EXISTS Students (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(50), " +
                    "age INT)";
	        
	        Connection conn = DriverManager.getConnection(url, user, password);
	        Statement stmt = conn.createStatement();
	        stmt.executeUpdate(sql);
	        System.out.println("Table Created Successfully!");
	        
	}

}
