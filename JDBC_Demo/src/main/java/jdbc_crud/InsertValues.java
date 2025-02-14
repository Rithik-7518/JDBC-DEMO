package jdbc_crud;

import java.sql.*;

public class InsertValues {

	public static void main(String[] args) throws Exception {
		 	String url = "jdbc:mysql://localhost:3306/jdbc_crud_demo";
	        String user = "root";
	        String password = "Rithik@7518";
	        String insertSQL = "INSERT INTO Students (name, age) VALUES (?, ?)";
	        String selectSQL = "SELECT * FROM Students";
	        String name="Msd";
	        int age=42;
	        
	        Connection conn = DriverManager.getConnection(url, user, password);
	        PreparedStatement pstmt = conn.prepareStatement(insertSQL);
	        pstmt.setString(1, name);
	        pstmt.setInt(2, age);
	        pstmt.executeUpdate();
	        System.out.println("Record Inserted Successfully!");
	        PreparedStatement ps = conn.prepareStatement(selectSQL);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
                int id = rs.getInt("id");
                String nameData = rs.getString("name");
                int ageData = rs.getInt("age");

                System.out.println("ID: " + id + ", Name: " + nameData + ", Age: " + ageData);
	        }


	       
	}

}
