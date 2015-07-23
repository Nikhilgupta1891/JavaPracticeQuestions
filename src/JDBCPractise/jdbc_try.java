package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc_try {

    public String driverName = "oracle.jdbc.OracleDriver";

    public String url = "jdbc:oracle:thin:@localhost:1521:xe";

    public String userName = "admin";

    public String passWord = "admin";

    public void getConnection() throws SQLException, Exception {

        Connection conn = null;
        Statement stmt = null;
        //Take ResultSet when you want to fetch records from Database
        ResultSet rs = null;

        try {
            // Load the Driver
            Class.forName(driverName);

            // Get Connection
            conn = DriverManager.getConnection(url, userName, passWord);

            // If Connection is Successfull than do SQL operation
            if (conn != null) {
                System.out.println("Connected to database");

                // Create a Statement
                stmt = conn.createStatement();

                String selectSQL = "SELECT * FROM student";

                // Execute SQL Statement
                rs = stmt.executeQuery(selectSQL);

                // First Check if rs having records in it.
                if (rs != null) {
                    // If There are records in rs then print them using while loop
                    System.out.println("         ***** ACCOUNT TABLE *****             ");
                    System.out.println("-----------------------------------------------");
                    System.out.println("ACCOUNT_ID     BAL        NAME    ");
                    System.out.println("-----------------------------------------------");
                    while (rs.next()) {
                        System.out.println(rs.getInt("ACCOUNT_ID") + "             " + rs.getString("BAL") + "       " + rs.getString("NAME"));
                    }
                    System.out.println("-----------------------------------------------");
                }

            } else {
                System.out.println("Could not Connected to Database");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public static void main(String[] args) {
        jdbc_try jdbcExampleSimpleQuerySelect = new jdbc_try();
        try {
            jdbcExampleSimpleQuerySelect.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
