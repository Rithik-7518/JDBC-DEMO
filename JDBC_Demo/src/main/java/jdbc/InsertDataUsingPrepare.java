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

public class InsertDataUsingPrepare {

	
	// check password before execute
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url="jdbc:mysql://localhost:3306/jdbc_demo";
		String UserName="root";
		String PassWord="Rithik@7518";
		int Sid=33;
		String Sname="Hardik";
		String Query="insert into students values(?,?)";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, UserName, PassWord);
		PreparedStatement st=con.prepareStatement(Query);
		st.setInt(1, Sid);
		st.setString(2, Sname);
		
		int count=st.executeUpdate();
		
		System.out.println(count+"  row/s affected");
		
		st.close();
		con.close();
		
		
	}

}
