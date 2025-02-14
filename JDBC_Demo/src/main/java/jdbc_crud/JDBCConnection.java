package jdbc_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/jdbc_crud_demo";
        String user = "root";
        String password = "Rithik@7518";
        
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Database Connected Successfully!");
        conn.close();
       
    }
}
