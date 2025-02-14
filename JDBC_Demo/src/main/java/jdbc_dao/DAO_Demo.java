package jdbc_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Student{
	int jerseryNo;
	String Name;
}


class StudentDAO{
	
	Connection con=null;
	public void connect() throws Exception {
		String url="jdbc:mysql://localhost:3306/dao_demo";
		String UserName="root";
		String PassWord="Rithik@7518";
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url, UserName, PassWord);
	}
	
	public Student getStudent(int jerseryNo) throws Exception {
		
		String Query="select Name from student where jerseryNo="+jerseryNo;
		
		Student s= new Student();
		s.jerseryNo=jerseryNo;
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(Query);
		rs.next();
		String name=rs.getString(1);
		s.Name=name;
		return s;
	}

	public void addStudent(Student s2) throws Exception {
		String Query="insert into student values(?,?)";
		PreparedStatement pst=con.prepareStatement(Query);
		pst.setInt(1, s2.jerseryNo);
		pst.setString(2, s2.Name);
		pst.executeUpdate();
		System.out.println("updated successfully");
		
	}
}

public class DAO_Demo {

	public static void main(String[] args) throws Exception {
		StudentDAO dao=new StudentDAO();
		//Student s1=dao.getStudent(18);
		//System.out.println(s1.Name);
		
		Student s2=new Student();
		s2.jerseryNo=3;
		s2.Name="Raina";
		dao.connect();
		dao.addStudent(s2);
		
	}

}
