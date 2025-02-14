package jdbc;

import java.sql.*;


/*
 * 1.import
 * 2.load & register driver
 * 3.create connection
 * 4.create statement
 * 5.execute query
 * 6.process the result
 * 7.close
 * 
 */

public class InsertMultipleData {

	
	// check password before execute
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url="jdbc:mysql://localhost:3306/jdbc_demo";
		String UserName="root";
		String PassWord="Rithik@7518";
		String Query="insert into students values(99,'Ash')";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, UserName, PassWord);
		Statement st=con.createStatement();
		int count=st.executeUpdate(Query);
		
		System.out.println(count+"  row/s affected");
		
		st.close();
		con.close();
		
		
	}

}
