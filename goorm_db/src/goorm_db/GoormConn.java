package goorm_db;
import java.sql.*;

public class GoormConn {

	static Connection conn;
	static Statement stmt;
	static PreparedStatement pstmt;
	static ResultSet rs = null;
	
	static String driver = "com.mysql.jdbc.Driver";
	static String user = "admin";
	static String pass = "1111";
	static String dbURL = "jdbc:mysql://13.209.199.136:56630/webdb?severTimezone=UTC";
	
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dbURL, user, pass);
			pstmt = null;
			System.out.println("연결성공");
		} catch (SQLException ee) {
			System.out.println("데이터베이스연결 실패");
			System.out.println("에러: " + ee);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이브 검색 에러");
		}
	}

}
