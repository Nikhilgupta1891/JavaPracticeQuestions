package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 *
 * Using the -commit and the ,savepoint.......... (1) CREATE TABLE
 * ACCOUNTS(ACCOUNT_ID INT(5),BAL INT(6),NAME VARCHAR(25)); (2) SELECT * FROM
 * ACCOUNTS;
 */
public class JdbcExampleSimpleQueryInsert1 {

    public String driverName = "org.gjt.mm.mysql.Driver";

    public String url = "jdbc:mysql://localhost:3306/test";

    public String userName = "root";

    public String passWord = "root";

    /*public String driverName = "oracle.jdbc.driver.OracleDriver";
     public String url = "jdbc:oracle:thin:@192.168.1.1:1521:abc";
     public String userName = "scott";
     public String passWord = "tiger";*/
    /**
     * Default values to be used for SQL operation
     *
     */
    int accountId = 10;
    int balance = 5000;
    String name = "SIMPLE STATEMENT";

    public void getConnection() throws SQLException, Exception {

        Connection conn = null;
        Statement stmt = null;
        Savepoint savepoint = null;

        try {
            /**
             * NOTE : Following commented line will load the Driver. This STEP
             * will not required in Java 6.
			 *
             */
            // Class.forName(driverName);

            /**
             * Get Connection with Database
			 *
             */
            conn = DriverManager.getConnection(url, userName, passWord);

            /**
             * After getting connection successful do some SQL operation.
			 *
             */
            if (conn != null) {
                System.out.println("Connected to database");

                conn.setAutoCommit(false);
                savepoint = conn.setSavepoint("beforInsert");
                /**
                 * Create a Statement to send SQL command. 
				 *
                 */
                stmt = conn.createStatement();

                String insertSQL = "INSERT INTO ACCOUNTS VALUES(" + accountId + "," + balance + ",'" + name + "')";

                /**
                 * Execute SQL Statement.
				 *
                 */
                int rowsInserted = stmt.executeUpdate(insertSQL);
                System.out.println(rowsInserted + " Row(s) Insrted Successfully");
                conn.commit();
            } else {
                System.out.println("Could not Connected to Database");
            }
        } /*catch (ClassNotFoundException e) {
         e.printStackTrace();
         }*/ catch (SQLException e) {
            conn.rollback(savepoint);
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public static void main(String[] args) throws SQLException, Exception {
        JdbcExampleSimpleQueryInsert1 jdbcExampleSimpleInsertQuery = new JdbcExampleSimpleQueryInsert1();
        jdbcExampleSimpleInsertQuery.getConnection();
    }

}
