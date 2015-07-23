package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * (1) CREATE TABLE `accounts` (`ACCOUNT_ID` int(11) default NULL,`BAL` int(11)
 * default NULL, `NAME` varchar(40) default NULL);
 *
 * (2) SELECT * FROM ACCOUNTS;
 *
 * DROP FUNCTION IF EXISTS test.FUN_ADDACCOUNTDETAILS; CREATE FUNCTION
 * test.`ADDACCOUNTDETAILS`(ACCOUNT_NO INT, BAL INT, NAME VARCHAR(40)) RETURNS
 * int(11) BEGIN DECLARE TOTAL INT; INSERT INTO ACCOUNTS VALUES (ACCOUNT_NO,
 * BAL, NAME); SET TOTAL = 1; RETURN TOTAL; END;
 *
 *
 */
public class JdbcExampleCallableStatementFunction {

    public String driverName = "org.gjt.mm.mysql.Driver";

    public String url = "jdbc:mysql://localhost:3306/test";

    public String userName = "root";

    public String passWord = "root";

    // Default values to be used for SQL operation
    int id = 100;
    int bal = 25000;
    String name = "STATEMENT";

    public void callFunctionFromJava() throws SQLException, Exception {

        Connection conn = null;
        CallableStatement cs = null;

        try {
            // Load the Driver
            Class.forName(driverName);

            // Get Connection
            conn = DriverManager.getConnection(url, userName, passWord);

            // If Connection is Successful than do SQL operation
            if (conn != null) {
                System.out.println("Connected to database");

                // Create a Statement
                cs = conn.prepareCall("{? = CALL FUN_ADDACCOUNTDETAILS(?,?,?)}");

                cs.registerOutParameter(1, Types.INTEGER);
                cs.setInt(2, id);
                cs.setInt(3, bal);
                cs.setString(4, name);

                // Execute SQL Statement
                cs.execute();
                String rowsInserted = cs.getString(1);
                System.out.println(rowsInserted + " Row(s) Inserted Successfully");

            } else {
                System.out.println("Could not Connected to Database");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cs != null) {
                cs.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public static void main(String[] args) throws SQLException, Exception {
        JdbcExampleCallableStatementFunction jdbcExampleCallableStatementFunction = new JdbcExampleCallableStatementFunction();
        jdbcExampleCallableStatementFunction.callFunctionFromJava();
    }

}
