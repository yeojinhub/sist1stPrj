package kr.co.sist.jtg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
		
	}
	
	public static DBConnection getInstance() {
		if(dbCon == null) {
			dbCon = new DBConnection();
		}
		return dbCon;
	}
	
	public Connection getConn()throws SQLException {
		//properties 파일 사용 ( 소스코드에 계정정보를 하드코딩하지 않는다 )
		String currentDir = System.getProperty("user.dir");
		File file = new File(currentDir+"/src/properties/database.properties");
		if(!file.exists()) {
			throw new SQLException("database.properties가 지정된 경로에 존재하지 않습니다.");
		}
		
		//생성
		Properties prop = new Properties();
		//파일 로딩
		String driver = "";
		String url = "";
		String id = "";
		String pass = "";
		try {
			prop.load(new FileInputStream(file));
			driver = prop.getProperty("driverClass");
			url = prop.getProperty("url");
			id = prop.getProperty("id");
			pass = prop.getProperty("pass");
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
		//1.드라이버로딩
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		//2.connection 얻기
//		String url = "";
//		String id = "";
//		String pass = "";
		
		con = DriverManager.getConnection(url, id, pass);
		
		return con;
	}
	
	public void closeDB(Connection con, Statement stmt, ResultSet rs)
			throws SQLException{
		try {
			if(rs != null) {rs.close();}
			if(stmt != null) {stmt.close();}
		}finally {
			if(con != null) {con.close();}
		}
		
	}
	
//	public static void main(String[] args) {
//		try {
//			System.out.println( new DbConnection().getConn() );
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
		
}
