package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/**
 * 
 *         (1) CREATE TABLE `accounts` (`ACCOUNT_ID` int(11) default NULL,`BAL` int(11) default NULL, `NAME` varchar(40) default NULL);
 *         
 *         (2) SELECT * FROM ACCOUNTS;
 *         
 *          DROP PROCEDURE IF EXISTS test.PROC_ADDACCOUNTDETAILS;
			CREATE PROCEDURE test.`PROC_ADDACCOUNTDETAILS`(IN ACCOUNT_NO INT, IN BAL INT, IN NAME VARCHAR(40), out TOTAL INT)
			BEGIN
			 INSERT INTO ACCOUNTS VALUES(ACCOUNT_NO,BAL,NAME);
			 SET TOTAL = 1;
			END
 * 
 */

public class JdbcExampleCallableStatementProcedure {

	public String driverName = "org.gjt.mm.mysql.Driver";

	public String url = "jdbc:mysql://localhost:3306/test";

	public String userName = "root";

	public String passWord = "root";

	// Default values to be used for SQL operation
	int id = 100;
	int bal = 25000;
	String name = "CALLABLE STATEMENT";

	public void getConnection() throws SQLException, Exception {

		Connection conn = null;
		CallableStatement cs = null;

		try {
			// Load the Driver
			Class.forName(driverName);

			// Get Connection
			conn = DriverManager.getConnection(url, userName, passWord);

			// If Connection is Successfull than do SQL operation
			if (conn != null) {
				System.out.println("Connected to database");

				// Create a Statement
				cs = conn.prepareCall("{ CALL PROC_ADDACCOUNTDETAILS(?,?,?,?)}");

				cs.setInt(1, id);
				cs.setInt(2, bal);
				cs.setString(3, name);
				cs.registerOutParameter(4, Types.INTEGER);

				// Execute SQL Statement
				cs.execute();
				int rowsInserted = cs.getInt(4);
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
		JdbcExampleCallableStatementProcedure jdbcExampleCallableStatementProcedure = new JdbcExampleCallableStatementProcedure();
		jdbcExampleCallableStatementProcedure.getConnection();
	}

}
