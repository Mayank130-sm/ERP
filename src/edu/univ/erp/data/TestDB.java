package edu.univ.erp.data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
// import edu.uni.erp.data.DatabaseConnection;

// Provide your own DatabaseConnection class for demonstration
class DatabaseConnection {
    public static Connection getErpConnection() throws Exception {
        // Replace with your actual JDBC URL, username, and password
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return java.sql.DriverManager.getConnection(url, user, password);
    }
}

public class TestDB {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getErpConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

            while (rs.next()) {
                System.out.println(rs.getString("roll_no") + " - " + rs.getString("program"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
