package goorm_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Goorm_Connector {
	Connection conn;

	static String driver = "com.mysql.jdbc.Driver";
	static String user = "admin";
	static String pass = "1111";
	static String dbURL = "jdbc:mysql://3.39.11.95:56773/webdb?severTimezone=UTC";
	
	Goorm_Connector() {
		try {
			Class.forName(driver);
			System.out.println("MySQL 드라이버 검색 성공...");
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL 드라이버 검색 오류");
		}
		
		try {
			conn = DriverManager.getConnection(dbURL, user, pass);
			System.out.println("MySQL 연결 성공...");
		} catch (SQLException e) {
			System.out.println("MySQL 연결 객체 생성 실패" + e);
			System.exit(0);
		}
	}
}
