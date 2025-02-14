package jdbc_crud;

import java.sql.*;

class Connect {
    protected Connection con;

    public Connect() throws Exception {
        String url = "jdbc:mysql://localhost:3306/Crud_In_JDBC";
        String user = "root";
        String password = "Rithik@7518";
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, password);
    }

    public void closeConnection() throws Exception {
        if (con != null) {
            con.close();
        }
    }
}

class TableCreate extends Connect {
    public TableCreate() throws Exception {
        super();
        Statement stmt = con.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS Students (" +
                     "id INT PRIMARY KEY AUTO_INCREMENT, " +
                     "name VARCHAR(50), " +
                     "age INT)";
        stmt.executeUpdate(sql);
        System.out.println("Table Created Successfully!");
        stmt.close();
    }
}

class ValueInsert extends Connect {
    public ValueInsert() throws Exception {
		super();
	}

	public void insertStudent(String name, int age) throws Exception {
        
        String insertSQL = "INSERT INTO Students (name, age) VALUES (?, ?)";
        PreparedStatement pstmt = con.prepareStatement(insertSQL);
        pstmt.setString(1, name);
        pstmt.setInt(2, age);
        pstmt.executeUpdate();
        System.out.println("Record Inserted Successfully!");
        pstmt.close();
    }
}

class UpdateData extends Connect {
    public UpdateData() throws Exception {
		super();
		
	}

	public void updateStudent(String name, int newAge) throws Exception {
        
        String updateSQL = "UPDATE Students SET age = ? WHERE name = ?";
        PreparedStatement pstmt = con.prepareStatement(updateSQL);
        pstmt.setInt(1, newAge);
        pstmt.setString(2, name);
        int rows = pstmt.executeUpdate();
        if (rows > 0) {
            System.out.println("Record Updated Successfully!");
        } else {
            System.out.println("No Record Found to Update!");
        }
        pstmt.close();
    }
}

class DeleteData extends Connect {
    public DeleteData() throws Exception {
		super();
		
	}

	public void deleteStudent(String name) throws Exception {
        
        String deleteSQL = "DELETE FROM Students WHERE name = ?";
        PreparedStatement pstmt = con.prepareStatement(deleteSQL);
        pstmt.setString(1, name);
        int rows = pstmt.executeUpdate();
        if (rows > 0) {
            System.out.println("Record Deleted Successfully!");
        } else {
            System.out.println("No Record Found to Delete!");
        }
        pstmt.close();
    }
}

class DataFetch extends Connect {
    public DataFetch() throws Exception {
		super();
		
	}

	public void fetchStudents() throws Exception {
       
        String selectSQL = "SELECT * FROM Students";
        PreparedStatement ps = con.prepareStatement(selectSQL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
        }
        rs.close();
        ps.close();
    }
}

public class Crud_In_JDBC {
    public static void main(String[] args) throws Exception {
        // Creating Table
        TableCreate create=new TableCreate();
           
        // Inserting Data
        ValueInsert insertObj = new ValueInsert();
        insertObj.insertStudent("Msd", 40);
        insertObj.insertStudent("Virat", 35);
        insertObj.insertStudent("raina", 37);
		
        // Fetching Data
        DataFetch fetchObj = new DataFetch();
        
        fetchObj.fetchStudents();
        // Updating Data
        UpdateData updateObj = new UpdateData();
        updateObj.updateStudent("Msd", 43);
              
        fetchObj.fetchStudents();
        
        
        // Deleting Data
        DeleteData deleteObj = new DeleteData();
        deleteObj.deleteStudent("Virat");
               
        // Fetching Data After Deletion
        fetchObj.fetchStudents();
        
        
        
        
    }
}
