package kr.co.sist.yj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {
	private static DBConnection dbCon;

	private DBConnection() {

	} // DbConnection

	public static DBConnection getInstance() {
		if (dbCon == null) {
			dbCon = new DBConnection();
		} // end if

		return dbCon;
	} // DbConnection getInstatnce

	public Connection getConn() throws SQLException {
		// properties 파일 사용(소스코드에 계정정보를 하드코딩하지 않는다.)
		String currentDir = System.getProperty("user.dir");
		File file = new File(currentDir + "/src/kr/co/sist/yj/properties/database.properties");
		if (!file.exists()) {
			throw new SQLException("database.properties가 지정된 경로에 존재하지 않습니다.");
		} // end if

		// properties 생성
		Properties prop = new Properties();

		@SuppressWarnings("unused")
		String driver = "";
		String url = "";
		String id = "";
		String pass = "";

		// properties File 로딩
		try {
			prop.load(new FileInputStream(file));
			driver = prop.getProperty("driverClass");
			url = prop.getProperty("url");
			id = prop.getProperty("id");
			pass = prop.getProperty("pass");
		} catch (IOException ie) {
			ie.printStackTrace();
		} // end try catch

		Connection con = null;
		// 1. Driver 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} // end try catch

		// 2. Connection 얻기
		con = DriverManager.getConnection(url, id, pass);

		return con;
	} // getConn

	public void closeDB(ResultSet rs, Statement stmt, Connection con) throws SQLException {
		try {
			if (rs != null) {
				rs.close();
			} // end if
			if (stmt != null) {
				stmt.close();
			} // end if
		} finally {
			if (con != null) {
				con.close();
			} // end if
		} // end try finally
	} // closeDB

} // class
