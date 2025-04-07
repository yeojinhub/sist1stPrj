package kr.cos.sist.ldu;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	private static DBConnection instance = null;

	private DBConnection() {

	}// DBConnection

	public static DBConnection getInstance() {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}// getDBConnection

	public Connection getConn() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sistprj", "tiger");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end try-catch

		return con;
	}// getConn

	public void closeDB(Connection con, Statement stmt, ResultSet rs) {
		try {
			if(con != null) { con.close(); };
			if(stmt != null) { stmt.close();; };
			if(rs != null) { rs.close(); };
		} catch (SQLException e) {
			e.printStackTrace();
		}// end try-catch
	}// closeDB

}// class
