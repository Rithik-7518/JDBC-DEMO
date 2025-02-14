package jdbc_crud;

import java.sql.*;

public class SelectData {

	public static void main(String[] args) throws Exception {
		 	String url = "jdbc:mysql://localhost:3306/jdbc_crud_demo";
	        String user = "root";
	        String password = "Rithik@7518";
	        String selectSQL = "SELECT * FROM Students";
	        
	        Connection conn = DriverManager.getConnection(url, user, password);
	        PreparedStatement ps = conn.prepareStatement(selectSQL);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
	        }
	}

}


