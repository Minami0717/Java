package db_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Java_Update {

	static Connection conn;
	static Statement stmt;
	static PreparedStatement pstmt;
	static ResultSet rs = null;
	
	static String driver = "com.mysql.jdbc.Driver";
	static String user = "root";
	static String pass = "1111";
	static String dbURL = "jdbc:mysql://localhost:3306/employees?severTimezone=Asia/Seoul";
	
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
		
		stmt = conn.createStatement();
		String sql = "SELECT dept_no,dept_name FROM departments";
		
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			String dept_no = rs.getString(1);
			String dept_name = rs.getString(2);

			System.out.println(dept_no + " " + dept_name);
		}
		
		String str_modi = "UPDATE departments SET dept_name = '자바' WHERE dept_no = 'd011'";
		try {
			int i = stmt.executeUpdate(str_modi);
			if (i == 1) {
				System.out.println("레코드 수정 성공");
				
				rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
					String dept_no = rs.getString(1);
					String dept_name = rs.getString(2);

					System.out.println(dept_no + " " + dept_name);
				}
			} else 
				System.out.println("레코드 수정 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}