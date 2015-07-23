package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*  
 *  
 *  (1) CREATE TABLE ACCOUNTS(ACCOUNT_ID  NUMBER(5),BAL NUMBER(6),NAME VARCHAR2(25));
 *  (2) SELECT * FROM ACCOUNTS;
 */
public class JdbcExamplePreparedStatementDelete {

    public String driverName = "org.gjt.mm.mysql.Driver";

    public String url = "jdbc:mysql://localhost:3306/test";

    public String userName = "root";

    public String passWord = "root";

    //Default values to be used for SQL operation
    int id = 10;
    int bal = 5000;
    String name = " Education";

    public void getConnection() throws SQLException, Exception {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Load the Driver
            Class.forName(driverName);

            // Get Connection
            conn = DriverManager.getConnection(url, userName, passWord);

            // If Connection is Successfull than do SQL operation
            if (conn != null) {
                System.out.println("Connected to database");

                String deleteSQL = "DELETE FROM ACCOUNTS WHERE ACCOUNT_ID = ?";

                // Create a Statement
                pstmt = conn.prepareStatement(deleteSQL);
                pstmt.setInt(1, id);

                // Execute SQL Statement
                int rowsDeleted = pstmt.executeUpdate();
                System.out.println(rowsDeleted + " Row(s) Deleted Successfully");

            } else {
                System.out.println("Could not Connected to Database");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public static void main(String[] args) throws SQLException, Exception {
        JdbcExamplePreparedStatementDelete jdbcExamplePreparedStatementDelete = new JdbcExamplePreparedStatementDelete();
        jdbcExamplePreparedStatementDelete.getConnection();
    }

}
