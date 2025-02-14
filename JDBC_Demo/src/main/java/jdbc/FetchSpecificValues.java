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

public class FetchSpecificValues {

	
	// check password before execute
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url="jdbc:mysql://localhost:3306/jdbc_demo";
		String UserName="root";
		String PassWord="Rithik@7518";
		String Query="select Sname from students where Sid=7";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, UserName, PassWord);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(Query);
		
		rs.next();
		String name =rs.getString("Sname");
		
		System.out.println(name);
		
		st.close();
		con.close();
		
		
	}

}
